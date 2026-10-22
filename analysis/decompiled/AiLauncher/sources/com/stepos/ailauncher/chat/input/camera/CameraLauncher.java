package com.stepos.ailauncher.chat.input.camera;

import Ua.C1060i;
import Ua.M;
import Wa.g;
import Y8.t;
import Z8.F;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.TransferActivity;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.common.permission.G;
import com.zyql.ai.selector.entity.LocalMedia;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u0001:\u0001CBA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0013J\u0011\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b%\u0010&J\"\u0010'\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0082@¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R(\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010*R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010*R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010/R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010/R\u0018\u00106\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010/R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010@¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/chat/input/camera/CameraLauncher;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lcom/zyql/ai/selector/entity/LocalMedia;", "LY8/t;", "onResult", "", "onShownStateChange", "<init>", "(Landroid/content/Context;Lp9/l;Lp9/l;)V", "LUa/M;", "scope", "fromMoreMenu", "y", "(LUa/M;Z)V", "C", "()V", "r", "z", "v", "w", "D", "H", "()Z", "B", "s", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/app/Activity;", "activity", "x", "(Landroid/app/Activity;)Z", "J", "G", "Landroid/app/ActivityManager$RunningTaskInfo;", "I", "()Landroid/app/ActivityManager$RunningTaskInfo;", "t", "(LUa/M;ZLe9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "Lp9/l;", "Ljava/lang/ref/WeakReference;", "cachedActivity", "Ljava/lang/ref/WeakReference;", "desktopCoverHeld", "Z", "cancelledFromHome", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "interruptedByPermissionUi", "retriedAfterPermissionUi", "retryScope", "LUa/M;", "retryFromMoreMenu", "Landroid/app/Application$ActivityLifecycleCallbacks;", "lifecycleWatcher", "Landroid/app/Application$ActivityLifecycleCallbacks;", "firstStartPending", "Landroid/app/Activity;", "Ljava/lang/Runnable;", "resampleTopRunnable", "Ljava/lang/Runnable;", "retryRunnable", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CameraLauncher {
    private static final long ACTIVITY_TIMEOUT_MS = 2000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CameraLauncher";
    private static volatile WeakReference<CameraLauncher> activeRef;
    private WeakReference<Activity> cachedActivity;
    private volatile boolean cancelledFromHome;
    private final Context context;
    private boolean desktopCoverHeld;
    private Activity firstStartPending;
    private boolean interruptedByPermissionUi;
    private Application.ActivityLifecycleCallbacks lifecycleWatcher;
    private final Handler mainHandler;
    private final InterfaceC5074l<List<? extends LocalMedia>, t> onResult;
    private final InterfaceC5074l<Boolean, t> onShownStateChange;
    private final Runnable resampleTopRunnable;
    private boolean retriedAfterPermissionUi;
    private boolean retryFromMoreMenu;
    private final Runnable retryRunnable;
    private M retryScope;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/input/camera/CameraLauncher$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", "TAG", "Ljava/lang/String;", "", "ACTIVITY_TIMEOUT_MS", "J", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/chat/input/camera/CameraLauncher;", "activeRef", "Ljava/lang/ref/WeakReference;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.input.camera.CameraLauncher$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void a() {
            CameraLauncher cameraLauncher;
            WeakReference weakReference = CameraLauncher.activeRef;
            if (weakReference == null || (cameraLauncher = (CameraLauncher) weakReference.get()) == null) {
                return;
            }
            cameraLauncher.r();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/chat/input/camera/CameraLauncher$b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            p.i(activity, "activity");
            if (CameraLauncher.this.x(activity)) {
                CameraLauncher.this.firstStartPending = activity;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            p.i(activity, "activity");
            p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            p.i(activity, "activity");
            if (CameraLauncher.this.x(activity)) {
                if (CameraLauncher.this.firstStartPending == activity) {
                    CameraLauncher.this.firstStartPending = null;
                    return;
                }
                CameraLauncher.this.G();
                CameraLauncher.this.mainHandler.removeCallbacks(CameraLauncher.this.resampleTopRunnable);
                CameraLauncher.this.mainHandler.postDelayed(CameraLauncher.this.resampleTopRunnable, 150L);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p.i(activity, "activity");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraLauncher(Context context, InterfaceC5074l<? super List<? extends LocalMedia>, t> onResult, InterfaceC5074l<? super Boolean, t> onShownStateChange) {
        p.i(context, "context");
        p.i(onResult, "onResult");
        p.i(onShownStateChange, "onShownStateChange");
        this.context = context;
        this.onResult = onResult;
        this.onShownStateChange = onShownStateChange;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.resampleTopRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.input.camera.b
            @Override // java.lang.Runnable
            public final void run() {
                CameraLauncher.E(this.f25371a);
            }
        };
        this.retryRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.input.camera.c
            @Override // java.lang.Runnable
            public final void run() {
                CameraLauncher.F(this.f25372a);
            }
        };
    }

    public static final void E(CameraLauncher cameraLauncher) {
        cameraLauncher.G();
    }

    public static final void F(CameraLauncher cameraLauncher) {
        cameraLauncher.B();
    }

    public static final t u(M m10, g gVar, Activity activity) {
        p.i(activity, "activity");
        Log.d(TAG, "openCamera: 获取 Activity 成功");
        C1060i.d(m10, null, null, new CameraLauncher$ensureActivity$4$1(gVar, activity, null), 3, null);
        return t.f7040a;
    }

    public final void A() {
        Context applicationContext = this.context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            return;
        }
        J();
        b bVar = new b();
        this.lifecycleWatcher = bVar;
        application.registerActivityLifecycleCallbacks(bVar);
    }

    public final void B() {
        M m10 = this.retryScope;
        if (m10 != null && kotlinx.coroutines.d.h(m10) && !this.cancelledFromHome) {
            z(m10, this.retryFromMoreMenu);
        } else {
            Log.d(TAG, "openCamera: 重开已失效，按取消收口");
            v();
        }
    }

    public final void C() {
        WeakReference<CameraLauncher> weakReference = activeRef;
        if ((weakReference != null ? weakReference.get() : null) == this) {
            activeRef = null;
        }
        this.cachedActivity = null;
        s();
        J();
        this.retryScope = null;
        D();
    }

    public final void D() {
        if (this.desktopCoverHeld) {
            this.desktopCoverHeld = false;
            DesktopChatResidentController.f1();
        }
    }

    public final void G() {
        ActivityManager.RunningTaskInfo runningTaskInfoI;
        String packageName;
        if (this.interruptedByPermissionUi || (runningTaskInfoI = I()) == null) {
            return;
        }
        ComponentName componentName = runningTaskInfoI.topActivity;
        if (componentName == null || (packageName = componentName.getPackageName()) == null) {
            ComponentName componentName2 = runningTaskInfoI.baseActivity;
            packageName = componentName2 != null ? componentName2.getPackageName() : null;
        }
        a aVar = a.INSTANCE;
        ComponentName componentName3 = runningTaskInfoI.topActivity;
        if (aVar.a(packageName, componentName3 != null ? componentName3.getClassName() : null)) {
            Log.i(TAG, "openCamera: 相机退场时栈顶是系统权限窗 pkg=" + packageName);
            this.interruptedByPermissionUi = true;
        }
    }

    public final boolean H() {
        M m10 = this.retryScope;
        if (!a.INSTANCE.b(this.interruptedByPermissionUi, this.retriedAfterPermissionUi, this.cancelledFromHome, m10 != null && kotlinx.coroutines.d.h(m10))) {
            return false;
        }
        Log.i(TAG, "openCamera: 相机被系统权限窗打断自毁，自动重开一次");
        this.retriedAfterPermissionUi = true;
        this.interruptedByPermissionUi = false;
        J();
        TransferActivity.Companion companion = TransferActivity.INSTANCE;
        companion.c();
        companion.f();
        this.cachedActivity = null;
        this.mainHandler.postDelayed(this.retryRunnable, 300L);
        return true;
    }

    public final ActivityManager.RunningTaskInfo I() {
        Object objB;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            Result.Companion companion = Result.INSTANCE;
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService(ActivityManager.class);
            objB = Result.b((activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null) ? null : (ActivityManager.RunningTaskInfo) F.s0(runningTasks));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "getRunningTasks failed: " + thE.getMessage());
        }
        return (ActivityManager.RunningTaskInfo) (Result.g(objB) ? null : objB);
    }

    public final void J() {
        this.firstStartPending = null;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.lifecycleWatcher;
        if (activityLifecycleCallbacks == null) {
            return;
        }
        this.lifecycleWatcher = null;
        this.mainHandler.removeCallbacks(this.resampleTopRunnable);
        Context applicationContext = this.context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public final void r() {
        Log.i(TAG, "cancelFromHome");
        this.cancelledFromHome = true;
        s();
        TransferActivity.Companion companion = TransferActivity.INSTANCE;
        companion.c();
        companion.d();
        v();
        WeakReference<CameraLauncher> weakReference = activeRef;
        if ((weakReference != null ? weakReference.get() : null) == this) {
            activeRef = null;
        }
    }

    public final void s() {
        this.mainHandler.removeCallbacks(this.retryRunnable);
        this.mainHandler.removeCallbacks(this.resampleTopRunnable);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(final Ua.M r9, boolean r10, e9.InterfaceC4014c<? super android.app.Activity> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$1 r0 = (com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$1 r0 = new com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r9 = r0.L$1
            Wa.g r9 = (Wa.g) r9
            java.lang.Object r10 = r0.L$0
            Ua.M r10 = (Ua.M) r10
            kotlin.C4849c.b(r11)
            goto L89
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.C4849c.b(r11)
            java.lang.ref.WeakReference<android.app.Activity> r11 = r8.cachedActivity
            if (r11 == 0) goto L5a
            java.lang.Object r11 = r11.get()
            android.app.Activity r11 = (android.app.Activity) r11
            if (r11 == 0) goto L5a
            boolean r2 = r11.isFinishing()
            if (r2 != 0) goto L56
            boolean r2 = r11.isDestroyed()
            if (r2 != 0) goto L56
            goto L57
        L56:
            r11 = r4
        L57:
            if (r11 == 0) goto L5a
            return r11
        L5a:
            r11 = 0
            r2 = 7
            Wa.g r11 = Wa.j.b(r11, r4, r4, r2, r4)
            com.stepos.ailauncher.chat.TransferActivity$a r2 = com.stepos.ailauncher.chat.TransferActivity.INSTANCE
            android.content.Context r5 = r8.context
            com.stepos.ailauncher.chat.input.camera.d r6 = new com.stepos.ailauncher.chat.input.camera.d
            r6.<init>()
            r2.i(r5, r10, r6)
            com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$activity$1 r2 = new com.stepos.ailauncher.chat.input.camera.CameraLauncher$ensureActivity$activity$1
            r2.<init>(r11, r4)
            java.lang.Object r9 = g9.h.a(r9)
            r0.L$0 = r9
            r0.L$1 = r11
            r0.Z$0 = r10
            r0.label = r3
            r9 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r9 = kotlinx.coroutines.TimeoutKt.e(r9, r2, r0)
            if (r9 != r1) goto L86
            return r1
        L86:
            r7 = r11
            r11 = r9
            r9 = r7
        L89:
            android.app.Activity r11 = (android.app.Activity) r11
            if (r11 != 0) goto L96
            com.stepos.ailauncher.chat.TransferActivity$a r8 = com.stepos.ailauncher.chat.TransferActivity.INSTANCE
            r8.c()
            r8.f()
            return r4
        L96:
            Wa.s.a(r9, r4, r3, r4)
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference
            r9.<init>(r11)
            r8.cachedActivity = r9
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.input.camera.CameraLauncher.t(Ua.M, boolean, e9.c):java.lang.Object");
    }

    public final void v() {
        s();
        J();
        this.interruptedByPermissionUi = false;
        this.retryScope = null;
        this.onShownStateChange.invoke(Boolean.FALSE);
        D();
        this.cachedActivity = null;
    }

    public final void w() {
        if (this.desktopCoverHeld) {
            return;
        }
        this.desktopCoverHeld = DesktopChatResidentController.r0();
    }

    public final boolean x(Activity activity) {
        return p.d(activity.getClass().getName(), a.SELECTOR_CAMERA_EMPTY_ACTIVITY);
    }

    public final void y(M scope, boolean fromMoreMenu) {
        p.i(scope, "scope");
        this.retriedAfterPermissionUi = false;
        z(scope, fromMoreMenu);
    }

    public final void z(M scope, boolean fromMoreMenu) {
        G.INSTANCE.C();
        this.cancelledFromHome = false;
        this.interruptedByPermissionUi = false;
        this.retryScope = scope;
        this.retryFromMoreMenu = fromMoreMenu;
        activeRef = new WeakReference<>(this);
        this.onShownStateChange.invoke(Boolean.TRUE);
        w();
        C1060i.d(scope, null, null, new CameraLauncher$launchInternal$1(this, scope, fromMoreMenu, null), 3, null);
    }
}
