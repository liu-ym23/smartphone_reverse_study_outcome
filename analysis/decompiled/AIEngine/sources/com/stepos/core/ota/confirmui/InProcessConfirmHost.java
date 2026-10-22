package com.stepos.core.ota.confirmui;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InProcessConfirmHost implements ConfirmUiHost {
    private static final Companion Companion = new Companion(null);
    private static final long REHOST_TIMEOUT_MS = 10000;
    private static final String TAG = "InProcessConfirmHost";
    private final zb.a<Activity> activityProvider;
    private Application.ActivityLifecycleCallbacks deathWatcher;
    private final HashMap<String, OtaAlertDialog> dialogs;
    private WeakReference<Activity> hostActivityRef;
    private final Handler main;
    private final HashSet<String> pendingReqIds;
    private final HashMap<String, ConfirmUiRequest> pendingRequests;
    private final String perfLabel;
    private String rehostFromClass;
    private final Runnable rehostTimeout;
    private Application watcherApp;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InProcessConfirmHost(zb.a<? extends Activity> activityProvider) {
        kotlin.jvm.internal.g.f(activityProvider, "activityProvider");
        this.activityProvider = activityProvider;
        this.main = new Handler(Looper.getMainLooper());
        this.dialogs = new HashMap<>();
        this.pendingReqIds = new HashSet<>();
        this.pendingRequests = new HashMap<>();
        this.rehostTimeout = new Runnable() { // from class: com.stepos.core.ota.confirmui.b
            @Override // java.lang.Runnable
            public final void run() {
                InProcessConfirmHost.rehostTimeout$lambda$0(this.f7489a);
            }
        };
        this.perfLabel = "in-process";
    }

    public static final /* synthetic */ void access$onHostRecreating(InProcessConfirmHost inProcessConfirmHost, Activity activity) {
        inProcessConfirmHost.onHostRecreating(activity);
    }

    public static final /* synthetic */ void access$rehostOn(InProcessConfirmHost inProcessConfirmHost, Activity activity) {
        inProcessConfirmHost.rehostOn(activity);
    }

    private final void dismissAllDialogs() {
        Collection<OtaAlertDialog> collectionValues = this.dialogs.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        for (OtaAlertDialog otaAlertDialog : collectionValues) {
            if (!otaAlertDialog.isShowing()) {
                otaAlertDialog = null;
            }
            if (otaAlertDialog != null) {
                try {
                    otaAlertDialog.dismiss();
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
            }
        }
        this.dialogs.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissPending$lambda$7(InProcessConfirmHost inProcessConfirmHost) {
        inProcessConfirmHost.main.removeCallbacks(inProcessConfirmHost.rehostTimeout);
        inProcessConfirmHost.rehostFromClass = null;
        inProcessConfirmHost.hostActivityRef = null;
        inProcessConfirmHost.dismissAllDialogs();
        List listO0 = kotlin.collections.a.O0(inProcessConfirmHost.pendingReqIds);
        inProcessConfirmHost.pendingReqIds.clear();
        inProcessConfirmHost.pendingRequests.clear();
        inProcessConfirmHost.unregisterDeathWatcher();
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            try {
                ConfirmDecisionBus.INSTANCE.submit((String) it.next(), ConfirmDecisionBus.Decision.CANCEL);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeUnregisterDeathWatcher() {
        if (this.dialogs.isEmpty() && this.pendingReqIds.isEmpty() && this.rehostFromClass == null) {
            unregisterDeathWatcher();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHostRecreating(Activity activity) {
        Log.i(TAG, ai.onnxruntime.a.i("host recreating (config change): ", this.pendingReqIds.size(), activity.getClass().getSimpleName(), ", keep ", " pending"));
        dismissAllDialogs();
        this.hostActivityRef = null;
        this.main.removeCallbacks(this.rehostTimeout);
        this.main.postDelayed(this.rehostTimeout, 10000L);
    }

    private final void registerDeathWatcher(Activity activity) {
        if (this.deathWatcher != null) {
            return;
        }
        Application application = activity.getApplication();
        InProcessConfirmHost$registerDeathWatcher$watcher$1 inProcessConfirmHost$registerDeathWatcher$watcher$1 = new InProcessConfirmHost$registerDeathWatcher$watcher$1(this);
        application.registerActivityLifecycleCallbacks(inProcessConfirmHost$registerDeathWatcher$watcher$1);
        this.deathWatcher = inProcessConfirmHost$registerDeathWatcher$watcher$1;
        this.watcherApp = application;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rehostOn(Activity activity) {
        this.main.removeCallbacks(this.rehostTimeout);
        this.rehostFromClass = null;
        if (activity.isFinishing() || activity.isDestroyed() || this.pendingRequests.isEmpty()) {
            return;
        }
        Log.i(TAG, "rehost " + this.pendingRequests.size() + " pending dialog(s) on new " + activity.getClass().getSimpleName());
        this.hostActivityRef = new WeakReference<>(activity);
        Collection<ConfirmUiRequest> collectionValues = this.pendingRequests.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        for (ConfirmUiRequest confirmUiRequest : collectionValues) {
            kotlin.jvm.internal.g.c(confirmUiRequest);
            showOnActivity(activity, confirmUiRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rehostTimeout$lambda$0(InProcessConfirmHost inProcessConfirmHost) {
        inProcessConfirmHost.rehostFromClass = null;
        inProcessConfirmHost.dismissPending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1(InProcessConfirmHost inProcessConfirmHost, ConfirmUiRequest confirmUiRequest) {
        Activity activityInvoke = inProcessConfirmHost.activityProvider.invoke();
        if (activityInvoke != null && !activityInvoke.isFinishing() && !activityInvoke.isDestroyed()) {
            inProcessConfirmHost.hostActivityRef = new WeakReference<>(activityInvoke);
            inProcessConfirmHost.registerDeathWatcher(activityInvoke);
            inProcessConfirmHost.showOnActivity(activityInvoke, confirmUiRequest);
        } else {
            Log.i(TAG, "show: no live activity, fallback to onShowFailed reqId=" + confirmUiRequest.getReqId());
            confirmUiRequest.getOnShowFailed().invoke();
        }
    }

    private final void showOnActivity(Activity activity, final ConfirmUiRequest confirmUiRequest) {
        Object objA;
        this.pendingReqIds.add(confirmUiRequest.getReqId());
        this.pendingRequests.put(confirmUiRequest.getReqId(), confirmUiRequest);
        ConfirmPerf.INSTANCE.mark(confirmUiRequest.getPerfTraceId(), confirmUiRequest.getPerfT0(), "INPROCESS_SHOW", ai.onnxruntime.a.k("plan=", confirmUiRequest.getParams().getPlan()));
        try {
            objA = Boolean.valueOf(new OtaConfirmDialogPresenter(activity, confirmUiRequest.getParams(), new OtaConfirmDialogPresenter.Sink() { // from class: com.stepos.core.ota.confirmui.InProcessConfirmHost$showOnActivity$presenter$1
                @Override // com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink
                public void stage(ConfirmDecisionBus.SubStage stage) {
                    kotlin.jvm.internal.g.f(stage, "stage");
                    try {
                        ConfirmDecisionBus.INSTANCE.notifyStage(confirmUiRequest.getReqId(), stage);
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }

                @Override // com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink
                public void submit(ConfirmDecisionBus.Decision decision) {
                    kotlin.jvm.internal.g.f(decision, "decision");
                    this.this$0.pendingReqIds.remove(confirmUiRequest.getReqId());
                    this.this$0.pendingRequests.remove(confirmUiRequest.getReqId());
                    this.this$0.dialogs.remove(confirmUiRequest.getReqId());
                    this.this$0.maybeUnregisterDeathWatcher();
                    try {
                        ConfirmDecisionBus.INSTANCE.submit(confirmUiRequest.getReqId(), decision);
                        lb.n nVar = lb.n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
            }, new com.stepos.aicgroup.f(5, this, confirmUiRequest), confirmUiRequest.getPerfTraceId(), confirmUiRequest.getPerfT0()).start());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.e(TAG, "present in-process confirm failed reqId=" + confirmUiRequest.getReqId(), thB);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        if (((Boolean) objA).booleanValue()) {
            return;
        }
        this.pendingReqIds.remove(confirmUiRequest.getReqId());
        this.pendingRequests.remove(confirmUiRequest.getReqId());
        maybeUnregisterDeathWatcher();
        confirmUiRequest.getOnShowFailed().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n showOnActivity$lambda$2(InProcessConfirmHost inProcessConfirmHost, ConfirmUiRequest confirmUiRequest, OtaAlertDialog dialog) {
        kotlin.jvm.internal.g.f(dialog, "dialog");
        inProcessConfirmHost.dialogs.put(confirmUiRequest.getReqId(), dialog);
        return lb.n.f10413a;
    }

    private final void unregisterDeathWatcher() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.deathWatcher;
        if (activityLifecycleCallbacks == null) {
            return;
        }
        Application application = this.watcherApp;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.deathWatcher = null;
        this.watcherApp = null;
    }

    public final void dismissPending() {
        this.main.post(new c(this, 0));
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public String getPerfLabel() {
        return this.perfLabel;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public void show(ConfirmUiRequest request) {
        kotlin.jvm.internal.g.f(request, "request");
        this.main.post(new androidx.appcompat.app.l(11, this, request));
    }
}
