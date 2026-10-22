package com.stepos.motionkit;

import B9.Q;
import C7.r;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.C0764ViewTreeLifecycleOwner;
import android.view.DefaultLifecycleObserver;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n*\u000258\u0018\u0000 D2\u00020\u0001:\u0001DB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\bJ\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010?\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010C\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/stepos/motionkit/MotionHost;", "", "Landroid/view/View;", "view", AppAgent.CONSTRUCT, "(Landroid/view/View;)V", "LC7/r;", "observeLifecycle", "()V", "observeActivity", "stopObservingActivity", "Lcom/stepos/motionkit/MotionModule;", "module", "register", "(Lcom/stepos/motionkit/MotionModule;)V", "resume", "pause", "release", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/stepos/motionkit/FrameLoop;", "frameLoop", "Lcom/stepos/motionkit/FrameLoop;", "getFrameLoop", "()Lcom/stepos/motionkit/FrameLoop;", "Lcom/stepos/motionkit/PerformanceMonitor;", "performanceMonitor", "Lcom/stepos/motionkit/PerformanceMonitor;", "getPerformanceMonitor", "()Lcom/stepos/motionkit/PerformanceMonitor;", "", "_modules", "Ljava/util/List;", "", "elapsedMs", "J", "", "released", "Z", "Landroidx/lifecycle/Lifecycle;", "observedLifecycle", "Landroidx/lifecycle/Lifecycle;", "Landroid/app/Application;", "fallbackApp", "Landroid/app/Application;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "fallbackActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "fallbackCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "com/stepos/motionkit/MotionHost$attachListener$1", "attachListener", "Lcom/stepos/motionkit/MotionHost$attachListener$1;", "com/stepos/motionkit/MotionHost$lifecycleObserver$1", "lifecycleObserver", "Lcom/stepos/motionkit/MotionHost$lifecycleObserver$1;", "", "getModules", "()Ljava/util/List;", "modules", "isActive", "()Z", "getElapsedTimeMs", "()J", "elapsedTimeMs", "Companion", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MotionHost {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<MotionModule> _modules;
    private final MotionHost$attachListener$1 attachListener;
    private long elapsedMs;
    private WeakReference<Activity> fallbackActivity;
    private Application fallbackApp;
    private Application.ActivityLifecycleCallbacks fallbackCallbacks;
    private final FrameLoop frameLoop;
    private final MotionHost$lifecycleObserver$1 lifecycleObserver;
    private Lifecycle observedLifecycle;
    private final PerformanceMonitor performanceMonitor;
    private boolean released;
    private final View view;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/stepos/motionkit/MotionHost$Companion;", "", AppAgent.CONSTRUCT, "()V", "attach", "Lcom/stepos/motionkit/MotionHost;", "view", "Landroid/view/View;", "findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Activity findActivity(Context context) {
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            return null;
        }

        public final MotionHost attach(View view) {
            k.f(view, "view");
            return new MotionHost(view, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ MotionHost(View view, e eVar) {
        this(view);
    }

    private final void observeActivity() {
        Application application;
        if (this.fallbackCallbacks != null) {
            return;
        }
        Companion companion = INSTANCE;
        Context context = this.view.getContext();
        k.e(context, "getContext(...)");
        Activity activityFindActivity = companion.findActivity(context);
        if (activityFindActivity == null || (application = activityFindActivity.getApplication()) == null) {
            return;
        }
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.stepos.motionkit.MotionHost$observeActivity$callbacks$1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle state) {
                k.f(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity destroyed) {
                k.f(destroyed, "destroyed");
                WeakReference weakReference = this.this$0.fallbackActivity;
                Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
                if (activity == null || destroyed == activity) {
                    this.this$0.release();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                k.f(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                k.f(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle state) {
                k.f(activity, "activity");
                k.f(state, "state");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                k.f(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                k.f(activity, "activity");
            }
        };
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        this.fallbackApp = application;
        this.fallbackActivity = new WeakReference<>(activityFindActivity);
        this.fallbackCallbacks = activityLifecycleCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeLifecycle() {
        if (this.released || this.observedLifecycle != null) {
            return;
        }
        LifecycleOwner lifecycleOwner = C0764ViewTreeLifecycleOwner.get(this.view);
        Lifecycle lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
        if (lifecycle == null) {
            observeActivity();
            return;
        }
        lifecycle.addObserver(this.lifecycleObserver);
        this.observedLifecycle = lifecycle;
        stopObservingActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r resume$lambda$2(MotionHost motionHost, float f) {
        motionHost.performanceMonitor.onFrame();
        motionHost.elapsedMs += (long) (1000 * f);
        Iterator<T> it = motionHost._modules.iterator();
        while (it.hasNext()) {
            ((MotionModule) it.next()).tick(f);
        }
        return r.f317a;
    }

    private final void stopObservingActivity() {
        Application application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.fallbackCallbacks;
        if (activityLifecycleCallbacks != null && (application = this.fallbackApp) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.fallbackCallbacks = null;
        this.fallbackActivity = null;
        this.fallbackApp = null;
    }

    /* renamed from: getElapsedTimeMs, reason: from getter */
    public final long getElapsedMs() {
        return this.elapsedMs;
    }

    public final FrameLoop getFrameLoop() {
        return this.frameLoop;
    }

    public final List<MotionModule> getModules() {
        return this._modules;
    }

    public final PerformanceMonitor getPerformanceMonitor() {
        return this.performanceMonitor;
    }

    public final View getView() {
        return this.view;
    }

    public final boolean isActive() {
        return !this.released && this.frameLoop.getRunning();
    }

    public final void pause() {
        this.frameLoop.pause();
    }

    public final void register(MotionModule module) {
        k.f(module, "module");
        if (this.released) {
            return;
        }
        this._modules.add(module);
        resume();
    }

    public final void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.frameLoop.stop();
        Iterator<T> it = this._modules.iterator();
        while (it.hasNext()) {
            ((MotionModule) it.next()).release();
        }
        this._modules.clear();
        this.view.removeOnAttachStateChangeListener(this.attachListener);
        Lifecycle lifecycle = this.observedLifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.observedLifecycle = null;
        stopObservingActivity();
    }

    public final void resume() {
        if (this.released || !this.view.isAttachedToWindow() || this.frameLoop.getRunning() || this._modules.isEmpty()) {
            return;
        }
        this.frameLoop.start(new Q(this, 28));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View$OnAttachStateChangeListener, com.stepos.motionkit.MotionHost$attachListener$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.stepos.motionkit.MotionHost$lifecycleObserver$1] */
    private MotionHost(View view) {
        this.view = view;
        this.frameLoop = new FrameLoop();
        this.performanceMonitor = new PerformanceMonitor();
        this._modules = new ArrayList();
        ?? r02 = new View.OnAttachStateChangeListener() { // from class: com.stepos.motionkit.MotionHost$attachListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v10) {
                k.f(v10, "v");
                this.this$0.observeLifecycle();
                this.this$0.resume();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v10) {
                k.f(v10, "v");
                this.this$0.pause();
            }
        };
        this.attachListener = r02;
        this.lifecycleObserver = new DefaultLifecycleObserver() { // from class: com.stepos.motionkit.MotionHost$lifecycleObserver$1
            @Override // android.view.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                k.f(owner, "owner");
                this.this$0.release();
            }

            @Override // android.view.DefaultLifecycleObserver
            public void onStart(LifecycleOwner owner) {
                k.f(owner, "owner");
                this.this$0.resume();
            }

            @Override // android.view.DefaultLifecycleObserver
            public void onStop(LifecycleOwner owner) {
                k.f(owner, "owner");
                this.this$0.pause();
            }
        };
        view.addOnAttachStateChangeListener(r02);
        observeLifecycle();
    }
}
