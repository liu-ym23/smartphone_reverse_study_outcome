package android.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.E;
import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0002\u0013\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Landroidx/lifecycle/C;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "LY8/t;", "e", Const.INTENT_KEY_UMID, "c", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/content/Context;", "context", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)V", "", Const.INTENT_KEY_APIKEY, "I", "startedCounter", Const.INTENT_KEY_PKGNAME, "resumedCounter", "", "Z", "pauseSent", "stopSent", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Landroidx/lifecycle/q;", "Landroidx/lifecycle/q;", "registry", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "delayedPauseRunnable", "Landroidx/lifecycle/E$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/lifecycle/E$a;", "initializationListener", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class C implements LifecycleOwner {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    public static final C f14160j = new C();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int startedCounter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int resumedCounter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean pauseSent = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean stopSent = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final C1399q registry = new C1399q(this);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Runnable delayedPauseRunnable = new Runnable() { // from class: androidx.lifecycle.B
        @Override // java.lang.Runnable
        public final void run() {
            C.h(this.f14158a);
        }
    };

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final E.a initializationListener = new d();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/C$a;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;Landroid/app/Application$ActivityLifecycleCallbacks;)V", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14169a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            p.i(activity, "activity");
            p.i(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/C$b;", "", "<init>", "()V", "Landroidx/lifecycle/LifecycleOwner;", Const.INTENT_KEY_APIKEY, "()Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "Landroidx/lifecycle/C;", "newInstance", "Landroidx/lifecycle/C;", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.C$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final LifecycleOwner a() {
            return C.f14160j;
        }

        public final void b(Context context) {
            p.i(context, "context");
            C.f14160j.g(context);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"androidx/lifecycle/C$c", "Landroidx/lifecycle/g;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onActivityPreCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityCreated", "onActivityPaused", "(Landroid/app/Activity;)V", "onActivityStopped", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends C1389g {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"androidx/lifecycle/C$c$a", "Landroidx/lifecycle/g;", "Landroid/app/Activity;", "activity", "LY8/t;", "onActivityPostStarted", "(Landroid/app/Activity;)V", "onActivityPostResumed", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends C1389g {
            final /* synthetic */ C this$0;

            public a(C c10) {
                this.this$0 = c10;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                p.i(activity, "activity");
                this.this$0.d();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                p.i(activity, "activity");
                this.this$0.e();
            }
        }

        public c() {
        }

        @Override // android.view.C1389g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            p.i(activity, "activity");
        }

        @Override // android.view.C1389g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p.i(activity, "activity");
            C.this.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
            p.i(activity, "activity");
            a.a(activity, new a(C.this));
        }

        @Override // android.view.C1389g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p.i(activity, "activity");
            C.this.f();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"androidx/lifecycle/C$d", "Landroidx/lifecycle/E$a;", "LY8/t;", Const.INTENT_KEY_UMID, "()V", UxipConstants.f30640D, "onResume", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements E.a {
        public d() {
        }

        @Override // androidx.lifecycle.E.a
        public void d() {
        }

        @Override // androidx.lifecycle.E.a
        public void onResume() {
            C.this.d();
        }

        @Override // androidx.lifecycle.E.a
        public void onStart() {
            C.this.e();
        }
    }

    public static final void h(C c10) {
        c10.i();
        c10.j();
    }

    public final void c() {
        int i10 = this.resumedCounter - 1;
        this.resumedCounter = i10;
        if (i10 == 0) {
            Handler handler = this.handler;
            p.f(handler);
            handler.postDelayed(this.delayedPauseRunnable, 700L);
        }
    }

    public final void d() {
        int i10 = this.resumedCounter + 1;
        this.resumedCounter = i10;
        if (i10 == 1) {
            if (this.pauseSent) {
                this.registry.i(Lifecycle.Event.ON_RESUME);
                this.pauseSent = false;
            } else {
                Handler handler = this.handler;
                p.f(handler);
                handler.removeCallbacks(this.delayedPauseRunnable);
            }
        }
    }

    public final void e() {
        int i10 = this.startedCounter + 1;
        this.startedCounter = i10;
        if (i10 == 1 && this.stopSent) {
            this.registry.i(Lifecycle.Event.ON_START);
            this.stopSent = false;
        }
    }

    public final void f() {
        this.startedCounter--;
        j();
    }

    public final void g(Context context) {
        p.i(context, "context");
        this.handler = new Handler();
        this.registry.i(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        p.g(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    @Override // android.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.registry;
    }

    public final void i() {
        if (this.resumedCounter == 0) {
            this.pauseSent = true;
            this.registry.i(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void j() {
        if (this.startedCounter == 0 && this.pauseSent) {
            this.registry.i(Lifecycle.Event.ON_STOP);
            this.stopSent = true;
        }
    }
}
