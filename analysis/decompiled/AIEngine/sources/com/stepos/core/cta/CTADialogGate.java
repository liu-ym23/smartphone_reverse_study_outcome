package com.stepos.core.cta;

import a6.d;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.appcompat.app.l;
import com.google.android.material.sidesheet.e;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.deepbinder.ICTACallback;
import gc.o;
import gc.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CTADialogGate {
    private static final long CTA_DECISION_TIMEOUT_MS = 60000;
    public static final String EXTRA_CALLING_UID = "com.stepos.aiengine.extra.CTA_CALLING_UID";
    public static final String EXTRA_CONTINUE_ALGORITHM_IDS = "com.stepos.aiengine.extra.CTA_CONTINUE_ALGORITHM_IDS";
    public static final String EXTRA_FROM_GATE = "com.stepos.aiengine.extra.CTA_FROM_GATE";
    public static final CTADialogGate INSTANCE = new CTADialogGate();
    private static final long MAIN_CONTINUATION_WARN_MS = 50;
    private static final String OTA_PROCESS_SUFFIX = ":ota";
    private static final String POLICY_ACTIVITY = "com.stepos.aiengine.cta.PolicyActivity";
    private static final String TAG = "CTADialogGate";
    private static volatile Context appContext;
    private static final ExecutorService continuationExecutor;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> continueAlgorithmIds;
    private static volatile Runnable decisionTimeout;
    private static final AtomicBoolean dialogShowing;
    private static final ConcurrentHashMap<Integer, ICTACallback> ipcCallbacks;
    private static final Handler mainHandler;
    private static final ConcurrentLinkedQueue<Waiter> waiters;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface CtaContinuation {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class DefaultImpls {
            public static boolean getRunsOnMainThread(CtaContinuation ctaContinuation) {
                return false;
            }
        }

        boolean getRunsOnMainThread();

        void onContinue(Context context);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Waiter {
        private final zb.a<n> onDenied;
        private final CtaContinuation onGranted;

        public Waiter(CtaContinuation onGranted, zb.a<n> aVar) {
            g.f(onGranted, "onGranted");
            this.onGranted = onGranted;
            this.onDenied = aVar;
        }

        public final zb.a<n> getOnDenied() {
            return this.onDenied;
        }

        public final CtaContinuation getOnGranted() {
            return this.onGranted;
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new d(2));
        g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        continuationExecutor = executorServiceNewSingleThreadExecutor;
        mainHandler = new Handler(Looper.getMainLooper());
        ipcCallbacks = new ConcurrentHashMap<>();
        waiters = new ConcurrentLinkedQueue<>();
        dialogShowing = new AtomicBoolean(false);
        continueAlgorithmIds = ConcurrentHashMap.newKeySet();
    }

    private CTADialogGate() {
    }

    private final void armDecisionTimeout(final int i10) {
        Runnable runnable = decisionTimeout;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.core.cta.b
            @Override // java.lang.Runnable
            public final void run() {
                CTADialogGate.armDecisionTimeout$lambda$16(i10);
            }
        };
        decisionTimeout = runnable2;
        mainHandler.postDelayed(runnable2, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void armDecisionTimeout$lambda$16(int i10) {
        if (decisionTimeout != null) {
            AIEngineLogger.w(LogModule.SERVICE, TAG, "CTA decision timeout uid=" + i10 + " → deny (fallback)");
            dispatchResult$default(INSTANCE, i10, false, null, 4, null);
        }
    }

    private final boolean canShowDialog() {
        return appContext != null && isMainProcess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread continuationExecutor$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "cta-continuation", true);
    }

    private final void dispatchContinuation(CtaContinuation ctaContinuation, Context context) {
        Object objA;
        Object objA2;
        try {
            objA = Boolean.valueOf(ctaContinuation.getRunsOnMainThread());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        if (!((Boolean) objA).booleanValue()) {
            continuationExecutor.execute(new l(9, ctaContinuation, context));
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ctaContinuation.onContinue(context);
            objA2 = n.f10413a;
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Throwable thB = Result.b(objA2);
        if (thB != null) {
            AIEngineLogger.e(LogModule.SERVICE, TAG, "onGranted action failed (main)", thB);
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        if (jElapsedRealtime2 > MAIN_CONTINUATION_WARN_MS) {
            a0.a.x(a0.a.o("continuation on main thread took ", jElapsedRealtime2, "ms (> 50ms): ", ctaContinuation.getClass().getName()), " — 违反 CtaContinuation 线程契约，禁止在主线程做阻塞 I/O", LogModule.SERVICE, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchContinuation$lambda$23(CtaContinuation ctaContinuation, Context context) {
        Object objA;
        try {
            ctaContinuation.onContinue(context);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.SERVICE, TAG, "onGranted action failed (worker)", thB);
        }
    }

    public static /* synthetic */ void dispatchResult$default(CTADialogGate cTADialogGate, int i10, boolean z, Context context, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            context = null;
        }
        cTADialogGate.dispatchResult(i10, z, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchResult$lambda$10(List list, boolean z, Context context, int i10) {
        Object objA;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((ICTACallback) it.next()).onResult(z);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (Result.b(objA) != null) {
                AIEngineLogger.w(LogModule.SERVICE, TAG, "ICTACallback dead uid=" + i10);
            }
        }
        if (!z) {
            AIEngineLogger.i(LogModule.SERVICE, TAG, "dispatchResult: denied uid=" + i10);
            INSTANCE.drainDenied();
            return;
        }
        Context context2 = appContext;
        if (context2 != null) {
            context = context2;
        }
        if (context != null) {
            AIEngineLogger.i(LogModule.SERVICE, TAG, a0.a.f("dispatchResult: granted uid=", i10, waiters.size(), " drain="));
            INSTANCE.drainGranted(context);
        } else {
            AIEngineLogger.e(LogModule.SERVICE, TAG, "dispatchResult: no launch context uid=" + i10);
            INSTANCE.drainDenied();
        }
    }

    private final void drainDenied() {
        Object objA;
        while (true) {
            Waiter waiterPoll = waiters.poll();
            if (waiterPoll == null) {
                continueAlgorithmIds.clear();
                return;
            }
            try {
                zb.a<n> onDenied = waiterPoll.getOnDenied();
                if (onDenied != null) {
                    onDenied.invoke();
                    objA = n.f10413a;
                } else {
                    objA = null;
                }
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.SERVICE, TAG, "onDenied action failed", thB);
            }
        }
    }

    private final void drainGranted(Context context) {
        Object objA;
        ArrayList arrayList = new ArrayList();
        while (true) {
            Waiter waiterPoll = waiters.poll();
            if (waiterPoll == null) {
                break;
            } else {
                arrayList.add(waiterPoll);
            }
        }
        if (arrayList.isEmpty()) {
            AIEngineLogger.i(LogModule.SERVICE, TAG, "drainGranted: no waiter");
            return;
        }
        Waiter waiter = (Waiter) kotlin.collections.a.A0(arrayList);
        Iterator it = kotlin.collections.a.q0(1, arrayList).iterator();
        while (it.hasNext()) {
            try {
                zb.a<n> onDenied = ((Waiter) it.next()).getOnDenied();
                if (onDenied != null) {
                    onDenied.invoke();
                    objA = n.f10413a;
                } else {
                    objA = null;
                }
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.SERVICE, TAG, "stale waiter onDenied failed", thB);
            }
        }
        dispatchContinuation(waiter.getOnGranted(), context);
        AIEngineLogger.i(LogModule.SERVICE, TAG, com.stepos.core.ota.d.e(arrayList.size(), "drainGranted: continued last of ", arrayList.size() - 1, ", denied ", " stale"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ensureGranted$default(CTADialogGate cTADialogGate, int i10, CtaContinuation ctaContinuation, zb.a aVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            aVar = null;
        }
        cTADialogGate.ensureGranted(i10, ctaContinuation, aVar);
    }

    private final boolean isMainProcess() {
        Object objA;
        try {
            objA = Application.getProcessName();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        boolean z = false;
        if (str != null && o.e0(str, ":ota", false)) {
            z = true;
        }
        return !z;
    }

    private final void requestDialog(int i10) {
        if (canShowDialog()) {
            Context context = appContext;
            g.c(context);
            dialogShowing.set(true);
            mainHandler.post(new e(i10, 1, context));
            return;
        }
        AIEngineLogger.d(LogModule.SERVICE, TAG, "requestDialog: skipped uid=" + i10);
        dispatchResult$default(this, i10, false, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestDialog$lambda$14(Context context, int i10) {
        Object objA;
        CTADialogGate cTADialogGate = INSTANCE;
        try {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), POLICY_ACTIVITY);
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_FROM_GATE, true);
            intent.putExtra(EXTRA_CALLING_UID, i10);
            intent.putExtra("android.intent.extra.UID", i10);
            ConcurrentHashMap.KeySetView<String, Boolean> continueAlgorithmIds2 = continueAlgorithmIds;
            g.e(continueAlgorithmIds2, "continueAlgorithmIds");
            if (!continueAlgorithmIds2.isEmpty()) {
                intent.putStringArrayListExtra(EXTRA_CONTINUE_ALGORITHM_IDS, new ArrayList<>(continueAlgorithmIds2));
            }
            context.startActivity(intent);
            AIEngineLogger.i(LogModule.SERVICE, TAG, "requestDialog: started PolicyActivity uid=" + i10);
            cTADialogGate.armDecisionTimeout(i10);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            dialogShowing.set(false);
            AIEngineLogger.e(LogModule.SERVICE, TAG, "requestDialog: start PolicyActivity failed uid=" + i10, thB);
            dispatchResult$default(INSTANCE, i10, false, null, 4, null);
        }
    }

    public final Context applicationContext() {
        return appContext;
    }

    public final void clearContinueAlgorithmIds() {
        continueAlgorithmIds.clear();
    }

    public final void dispatchResult(final int i10, final boolean z, final Context context) {
        dialogShowing.set(false);
        Runnable runnable = decisionTimeout;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        decisionTimeout = null;
        ConcurrentHashMap<Integer, ICTACallback> concurrentHashMap = ipcCallbacks;
        Collection<ICTACallback> collectionValues = concurrentHashMap.values();
        g.e(collectionValues, "<get-values>(...)");
        final List listO0 = kotlin.collections.a.O0(collectionValues);
        concurrentHashMap.clear();
        mainHandler.post(new Runnable() { // from class: com.stepos.core.cta.a
            @Override // java.lang.Runnable
            public final void run() {
                CTADialogGate.dispatchResult$lambda$10(listO0, z, context, i10);
            }
        });
    }

    public final void ensureGranted(int i10, CtaContinuation onGranted, zb.a<n> aVar) {
        g.f(onGranted, "onGranted");
        Context context = appContext;
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            if (context != null) {
                dispatchContinuation(onGranted, context);
                return;
            } else {
                if (aVar != null) {
                    aVar.invoke();
                    return;
                }
                return;
            }
        }
        if (canShowDialog()) {
            ConcurrentLinkedQueue<Waiter> concurrentLinkedQueue = waiters;
            concurrentLinkedQueue.add(new Waiter(onGranted, aVar));
            AIEngineLogger.i(LogModule.SERVICE, TAG, a0.a.f("ensureGranted: queued uid=", i10, concurrentLinkedQueue.size(), " pending="));
            requestDialog(i10);
            return;
        }
        AIEngineLogger.d(LogModule.SERVICE, TAG, "ensureGranted: dialog unavailable uid=" + i10);
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void init(Context context) {
        g.f(context, "context");
        CTAPermissionManager.INSTANCE.init(context);
        if (isMainProcess()) {
            appContext = context.getApplicationContext();
        } else {
            AIEngineLogger.d(LogModule.SERVICE, TAG, "init: non-main process, CTA dialog host disabled");
        }
    }

    public final boolean isDialogShowing() {
        return dialogShowing.get();
    }

    public final boolean isFromGate(Intent intent) {
        g.f(intent, "intent");
        return intent.getBooleanExtra(EXTRA_FROM_GATE, false);
    }

    public final void markDialogHostGone() {
        dialogShowing.set(false);
        Runnable runnable = decisionTimeout;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        decisionTimeout = null;
    }

    public final List<String> peekContinueAlgorithmIdsForIntent() {
        ConcurrentHashMap.KeySetView<String, Boolean> continueAlgorithmIds2 = continueAlgorithmIds;
        g.e(continueAlgorithmIds2, "continueAlgorithmIds");
        return kotlin.collections.a.O0(continueAlgorithmIds2);
    }

    public final void promptAuthorization(int i10) {
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            return;
        }
        if (canShowDialog()) {
            requestDialog(i10);
            return;
        }
        AIEngineLogger.d(LogModule.SERVICE, TAG, "promptAuthorization: dialog unavailable uid=" + i10);
    }

    public final int readCallingUid(Intent intent) {
        g.f(intent, "intent");
        if (isFromGate(intent)) {
            return intent.getIntExtra(EXTRA_CALLING_UID, intent.getIntExtra("android.intent.extra.UID", -1));
        }
        return -1;
    }

    public final void registerInteractiveDownload(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        if (q.t0(algorithmId)) {
            return;
        }
        continueAlgorithmIds.add(algorithmId);
    }

    public final void requestWithCallback(int i10, ICTACallback callback) {
        g.f(callback, "callback");
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            try {
                callback.onResult(true);
                n nVar = n.f10413a;
                return;
            } catch (Throwable th) {
                kotlin.c.a(th);
                return;
            }
        }
        if (canShowDialog()) {
            ipcCallbacks.put(Integer.valueOf(i10), callback);
            requestDialog(i10);
            return;
        }
        AIEngineLogger.d(LogModule.SERVICE, TAG, "requestWithCallback: dialog unavailable uid=" + i10);
        try {
            callback.onResult(false);
            n nVar2 = n.f10413a;
        } catch (Throwable th2) {
            kotlin.c.a(th2);
        }
    }
}
