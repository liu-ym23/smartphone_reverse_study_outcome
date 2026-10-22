package s7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.InterfaceC1387e;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004*\u00029<\u0018\u0000 B2\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00100R\u001e\u00105\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010=R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060?8F¢\u0006\u0006\u001a\u0004\b&\u0010@¨\u0006C"}, d2 = {"Ls7/o;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Ls7/r;", "module", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ls7/r;)V", "l", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "n", Const.INTENT_KEY_APIKEY, "Landroid/view/View;", "f", "()Landroid/view/View;", "Ls7/h;", Const.INTENT_KEY_PKGNAME, "Ls7/h;", Const.INTENT_KEY_UMID, "()Ls7/h;", "frameLoop", "Ls7/s;", "c", "Ls7/s;", "getPerformanceMonitor", "()Ls7/s;", "performanceMonitor", "", "Ljava/util/List;", "_modules", "", "e", "J", "elapsedMs", "", "Z", "released", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "observedLifecycle", "Landroid/app/Application;", "Landroid/app/Application;", "fallbackApp", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "Ljava/lang/ref/WeakReference;", "fallbackActivity", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "fallbackCallbacks", "s7/o$b", "Ls7/o$b;", "attachListener", "s7/o$c", "Ls7/o$c;", "lifecycleObserver", "", "()Ljava/util/List;", "modules", "m", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final h frameLoop;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final s performanceMonitor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<r> _modules;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long elapsedMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean released;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Lifecycle observedLifecycle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Application fallbackApp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public WeakReference<Activity> fallbackActivity;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public Application.ActivityLifecycleCallbacks fallbackCallbacks;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final b attachListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final c lifecycleObserver;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ls7/o$a;", "", "<init>", "()V", "Landroid/view/View;", "view", "Ls7/o;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)Ls7/o;", "Landroid/content/Context;", "Landroid/app/Activity;", "c", "(Landroid/content/Context;)Landroid/app/Activity;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: s7.o$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final o b(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            return new o(view, null);
        }

        public final Activity c(Context context) {
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            return null;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"s7/o$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            o.this.h();
            o.this.l();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            o.this.i();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"s7/o$c", "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "LY8/t;", UxipConstants.f30640D, "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "onDestroy", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements InterfaceC1387e {
        public c() {
        }

        @Override // android.view.InterfaceC1387e
        public void onDestroy(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            o.this.k();
        }

        @Override // android.view.InterfaceC1387e
        public void onStart(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            o.this.l();
        }

        @Override // android.view.InterfaceC1387e
        public void onStop(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            o.this.i();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"s7/o$d", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "destroyed", "LY8/t;", "onActivityDestroyed", "(Landroid/app/Activity;)V", "activity", "Landroid/os/Bundle;", VoiceWakeupReceiver.EXTRA_STATE, "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements Application.ActivityLifecycleCallbacks {
        public d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle state) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity destroyed) {
            kotlin.jvm.internal.p.i(destroyed, "destroyed");
            WeakReference weakReference = o.this.fallbackActivity;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity == null || destroyed == activity) {
                o.this.k();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle state) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(state, "state");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }
    }

    public /* synthetic */ o(View view, kotlin.jvm.internal.i iVar) {
        this(view);
    }

    public static final Y8.t m(o oVar, float f10) {
        oVar.performanceMonitor.a();
        oVar.elapsedMs += (long) (1000 * f10);
        Iterator<T> it = oVar._modules.iterator();
        while (it.hasNext()) {
            ((r) it.next()).c(f10);
        }
        return Y8.t.f7040a;
    }

    /* renamed from: d, reason: from getter */
    public final h getFrameLoop() {
        return this.frameLoop;
    }

    public final List<r> e() {
        return this._modules;
    }

    /* renamed from: f, reason: from getter */
    public final View getView() {
        return this.view;
    }

    public final void g() {
        Application application;
        if (this.fallbackCallbacks != null) {
            return;
        }
        Companion companion = INSTANCE;
        Context context = this.view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        Activity activityC = companion.c(context);
        if (activityC == null || (application = activityC.getApplication()) == null) {
            return;
        }
        d dVar = new d();
        application.registerActivityLifecycleCallbacks(dVar);
        this.fallbackApp = application;
        this.fallbackActivity = new WeakReference<>(activityC);
        this.fallbackCallbacks = dVar;
    }

    public final void h() {
        if (this.released || this.observedLifecycle != null) {
            return;
        }
        LifecycleOwner lifecycleOwnerA = android.view.View.a(this.view);
        Lifecycle lifecycle = lifecycleOwnerA != null ? lifecycleOwnerA.getLifecycle() : null;
        if (lifecycle == null) {
            g();
            return;
        }
        lifecycle.a(this.lifecycleObserver);
        this.observedLifecycle = lifecycle;
        n();
    }

    public final void i() {
        this.frameLoop.g();
    }

    public final void j(r module) {
        kotlin.jvm.internal.p.i(module, "module");
        if (this.released) {
            return;
        }
        this._modules.add(module);
        l();
    }

    public final void k() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.frameLoop.l();
        Iterator<T> it = this._modules.iterator();
        while (it.hasNext()) {
            ((r) it.next()).release();
        }
        this._modules.clear();
        this.view.removeOnAttachStateChangeListener(this.attachListener);
        Lifecycle lifecycle = this.observedLifecycle;
        if (lifecycle != null) {
            lifecycle.d(this.lifecycleObserver);
        }
        this.observedLifecycle = null;
        n();
    }

    public final void l() {
        if (this.released || !this.view.isAttachedToWindow() || this.frameLoop.getRunning() || this._modules.isEmpty()) {
            return;
        }
        this.frameLoop.k(new InterfaceC5074l() { // from class: s7.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return o.m(this.f40104a, ((Float) obj).floatValue());
            }
        });
    }

    public final void n() {
        Application application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.fallbackCallbacks;
        if (activityLifecycleCallbacks != null && (application = this.fallbackApp) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.fallbackCallbacks = null;
        this.fallbackActivity = null;
        this.fallbackApp = null;
    }

    public o(View view) {
        this.view = view;
        this.frameLoop = new h();
        this.performanceMonitor = new s();
        this._modules = new ArrayList();
        b bVar = new b();
        this.attachListener = bVar;
        this.lifecycleObserver = new c();
        view.addOnAttachStateChangeListener(bVar);
        h();
    }
}
