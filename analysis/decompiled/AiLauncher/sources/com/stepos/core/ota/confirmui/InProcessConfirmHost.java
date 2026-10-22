package com.stepos.core.ota.confirmui;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001e0#j\b\u0012\u0004\u0012\u00020\u001e`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\"R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u001e8\u0016X\u0096D¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/stepos/core/ota/confirmui/InProcessConfirmHost;", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "Lkotlin/Function0;", "Landroid/app/Activity;", "activityProvider", "<init>", "(Lp9/a;)V", "activity", "Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;", "request", "LY8/t;", "showOnActivity", "(Landroid/app/Activity;Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;)V", "dismissAllDialogs", "()V", "registerDeathWatcher", "(Landroid/app/Activity;)V", ChatTracker.WORLD_OLD, "onHostRecreating", "rehostOn", "maybeUnregisterDeathWatcher", "unregisterDeathWatcher", "show", "(Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;)V", "dismissPending", "Lp9/a;", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "Ljava/util/HashMap;", "", "Lcom/stepos/core/ota/confirmui/OtaAlertDialog;", "Lkotlin/collections/HashMap;", "dialogs", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pendingReqIds", "Ljava/util/HashSet;", "pendingRequests", "hostActivity", "Landroid/app/Activity;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "deathWatcher", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Application;", "watcherApp", "Landroid/app/Application;", "rehostFromClass", "Ljava/lang/String;", "Ljava/lang/Runnable;", "rehostTimeout", "Ljava/lang/Runnable;", "perfLabel", "getPerfLabel", "()Ljava/lang/String;", "Companion", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InProcessConfirmHost implements ConfirmUiHost {
    private static final Companion Companion = new Companion(null);
    private static final long REHOST_TIMEOUT_MS = 10000;
    private static final String TAG = "InProcessConfirmHost";
    private final InterfaceC5063a<Activity> activityProvider;
    private Application.ActivityLifecycleCallbacks deathWatcher;
    private final HashMap<String, OtaAlertDialog> dialogs;
    private Activity hostActivity;
    private final Handler main;
    private final HashSet<String> pendingReqIds;
    private final HashMap<String, ConfirmUiRequest> pendingRequests;
    private final String perfLabel;
    private String rehostFromClass;
    private final Runnable rehostTimeout;
    private Application watcherApp;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/core/ota/confirmui/InProcessConfirmHost$Companion;", "", "<init>", "()V", "TAG", "", "REHOST_TIMEOUT_MS", "", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InProcessConfirmHost(InterfaceC5063a<? extends Activity> activityProvider) {
        kotlin.jvm.internal.p.i(activityProvider, "activityProvider");
        this.activityProvider = activityProvider;
        this.main = new Handler(Looper.getMainLooper());
        this.dialogs = new HashMap<>();
        this.pendingReqIds = new HashSet<>();
        this.pendingRequests = new HashMap<>();
        this.rehostTimeout = new Runnable() { // from class: com.stepos.core.ota.confirmui.e
            @Override // java.lang.Runnable
            public final void run() {
                InProcessConfirmHost.rehostTimeout$lambda$0(this.f29580a);
            }
        };
        this.perfLabel = "in-process";
    }

    private final void dismissAllDialogs() {
        Collection<OtaAlertDialog> collectionValues = this.dialogs.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (OtaAlertDialog otaAlertDialog : collectionValues) {
            if (!otaAlertDialog.isShowing()) {
                otaAlertDialog = null;
            }
            if (otaAlertDialog != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    otaAlertDialog.dismiss();
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
        this.dialogs.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissPending$lambda$7(InProcessConfirmHost inProcessConfirmHost) {
        inProcessConfirmHost.main.removeCallbacks(inProcessConfirmHost.rehostTimeout);
        inProcessConfirmHost.rehostFromClass = null;
        inProcessConfirmHost.hostActivity = null;
        inProcessConfirmHost.dismissAllDialogs();
        List<String> listM1 = Z8.F.m1(inProcessConfirmHost.pendingReqIds);
        inProcessConfirmHost.pendingReqIds.clear();
        inProcessConfirmHost.pendingRequests.clear();
        inProcessConfirmHost.unregisterDeathWatcher();
        for (String str : listM1) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ConfirmDecisionBus.INSTANCE.submit(str, ConfirmDecisionBus.Decision.CANCEL);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
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
    public final void onHostRecreating(Activity old) {
        Log.i(TAG, "host recreating (config change): " + old.getClass().getSimpleName() + ", keep " + this.pendingReqIds.size() + " pending");
        dismissAllDialogs();
        this.hostActivity = null;
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
        this.hostActivity = activity;
        Collection<ConfirmUiRequest> collectionValues = this.pendingRequests.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (ConfirmUiRequest confirmUiRequest : collectionValues) {
            kotlin.jvm.internal.p.f(confirmUiRequest);
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
            inProcessConfirmHost.hostActivity = activityInvoke;
            inProcessConfirmHost.registerDeathWatcher(activityInvoke);
            inProcessConfirmHost.showOnActivity(activityInvoke, confirmUiRequest);
        } else {
            Log.i(TAG, "show: no live activity, fallback to onShowFailed reqId=" + confirmUiRequest.getReqId());
            confirmUiRequest.getOnShowFailed().invoke();
        }
    }

    private final void showOnActivity(Activity activity, final ConfirmUiRequest request) {
        Object objB;
        this.pendingReqIds.add(request.getReqId());
        this.pendingRequests.put(request.getReqId(), request);
        ConfirmPerf.INSTANCE.mark(request.getPerfTraceId(), request.getPerfT0(), "INPROCESS_SHOW", "plan=" + request.getParams().getPlan());
        OtaConfirmDialogPresenter otaConfirmDialogPresenter = new OtaConfirmDialogPresenter(activity, request.getParams(), new OtaConfirmDialogPresenter.Sink() { // from class: com.stepos.core.ota.confirmui.InProcessConfirmHost$showOnActivity$presenter$1
            @Override // com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink
            public void stage(ConfirmDecisionBus.SubStage stage) {
                kotlin.jvm.internal.p.i(stage, "stage");
                ConfirmUiRequest confirmUiRequest = request;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ConfirmDecisionBus.INSTANCE.notifyStage(confirmUiRequest.getReqId(), stage);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }

            @Override // com.stepos.core.ota.confirmui.OtaConfirmDialogPresenter.Sink
            public void submit(ConfirmDecisionBus.Decision decision) {
                kotlin.jvm.internal.p.i(decision, "decision");
                this.this$0.pendingReqIds.remove(request.getReqId());
                this.this$0.pendingRequests.remove(request.getReqId());
                this.this$0.dialogs.remove(request.getReqId());
                this.this$0.maybeUnregisterDeathWatcher();
                ConfirmUiRequest confirmUiRequest = request;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ConfirmDecisionBus.INSTANCE.submit(confirmUiRequest.getReqId(), decision);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }, new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InProcessConfirmHost.showOnActivity$lambda$2(this.f29577a, request, (OtaAlertDialog) obj);
            }
        }, request.getPerfTraceId(), request.getPerfT0());
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(otaConfirmDialogPresenter.start()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(TAG, "present in-process confirm failed reqId=" + request.getReqId(), thE);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (((Boolean) objB).booleanValue()) {
            return;
        }
        this.pendingReqIds.remove(request.getReqId());
        this.pendingRequests.remove(request.getReqId());
        maybeUnregisterDeathWatcher();
        request.getOnShowFailed().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showOnActivity$lambda$2(InProcessConfirmHost inProcessConfirmHost, ConfirmUiRequest confirmUiRequest, OtaAlertDialog dialog) {
        kotlin.jvm.internal.p.i(dialog, "dialog");
        inProcessConfirmHost.dialogs.put(confirmUiRequest.getReqId(), dialog);
        return Y8.t.f7040a;
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
        this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.f
            @Override // java.lang.Runnable
            public final void run() {
                InProcessConfirmHost.dismissPending$lambda$7(this.f29582a);
            }
        });
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public String getPerfLabel() {
        return this.perfLabel;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public void show(final ConfirmUiRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.g
            @Override // java.lang.Runnable
            public final void run() {
                InProcessConfirmHost.show$lambda$1(this.f29584a, request);
            }
        });
    }
}
