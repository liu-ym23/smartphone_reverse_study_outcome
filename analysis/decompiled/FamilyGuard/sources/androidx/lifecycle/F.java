package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.H;

/* loaded from: classes.dex */
public final class F implements InterfaceC0539t {

    /* renamed from: i, reason: collision with root package name */
    public static final b f10795i = new b(null);

    /* renamed from: j, reason: collision with root package name */
    private static final F f10796j = new F();

    /* renamed from: a, reason: collision with root package name */
    private int f10797a;

    /* renamed from: b, reason: collision with root package name */
    private int f10798b;

    /* renamed from: e, reason: collision with root package name */
    private Handler f10801e;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10799c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10800d = true;

    /* renamed from: f, reason: collision with root package name */
    private final C0541v f10802f = new C0541v(this);

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f10803g = new Runnable() { // from class: androidx.lifecycle.E
        @Override // java.lang.Runnable
        public final void run() {
            F.h(this.f10794a);
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private final H.a f10804h = new d();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10805a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            j4.k.g(activity, "activity");
            j4.k.g(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        public final InterfaceC0539t a() {
            return F.f10796j;
        }

        public final void b(Context context) {
            j4.k.g(context, "context");
            F.f10796j.g(context);
        }

        private b() {
        }
    }

    public static final class c extends C0529i {

        public static final class a extends C0529i {
            final /* synthetic */ F this$0;

            a(F f5) {
                this.this$0 = f5;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                j4.k.g(activity, "activity");
                this.this$0.d();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                j4.k.g(activity, "activity");
                this.this$0.e();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.C0529i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            j4.k.g(activity, "activity");
        }

        @Override // androidx.lifecycle.C0529i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            j4.k.g(activity, "activity");
            F.this.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            j4.k.g(activity, "activity");
            a.a(activity, new a(F.this));
        }

        @Override // androidx.lifecycle.C0529i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            j4.k.g(activity, "activity");
            F.this.f();
        }
    }

    public static final class d implements H.a {
        d() {
        }

        @Override // androidx.lifecycle.H.a
        public void a() {
            F.this.e();
        }

        @Override // androidx.lifecycle.H.a
        public void b() {
        }

        @Override // androidx.lifecycle.H.a
        public void onResume() {
            F.this.d();
        }
    }

    private F() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(F f5) {
        j4.k.g(f5, "this$0");
        f5.i();
        f5.j();
    }

    public final void c() {
        int i5 = this.f10798b - 1;
        this.f10798b = i5;
        if (i5 == 0) {
            Handler handler = this.f10801e;
            j4.k.d(handler);
            handler.postDelayed(this.f10803g, 700L);
        }
    }

    public final void d() {
        int i5 = this.f10798b + 1;
        this.f10798b = i5;
        if (i5 == 1) {
            if (this.f10799c) {
                this.f10802f.i(AbstractC0533m.a.ON_RESUME);
                this.f10799c = false;
            } else {
                Handler handler = this.f10801e;
                j4.k.d(handler);
                handler.removeCallbacks(this.f10803g);
            }
        }
    }

    public final void e() {
        int i5 = this.f10797a + 1;
        this.f10797a = i5;
        if (i5 == 1 && this.f10800d) {
            this.f10802f.i(AbstractC0533m.a.ON_START);
            this.f10800d = false;
        }
    }

    public final void f() {
        this.f10797a--;
        j();
    }

    public final void g(Context context) {
        j4.k.g(context, "context");
        this.f10801e = new Handler();
        this.f10802f.i(AbstractC0533m.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        j4.k.e(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    @Override // androidx.lifecycle.InterfaceC0539t
    public AbstractC0533m getLifecycle() {
        return this.f10802f;
    }

    public final void i() {
        if (this.f10798b == 0) {
            this.f10799c = true;
            this.f10802f.i(AbstractC0533m.a.ON_PAUSE);
        }
    }

    public final void j() {
        if (this.f10797a == 0 && this.f10799c) {
            this.f10802f.i(AbstractC0533m.a.ON_STOP);
            this.f10800d = true;
        }
    }
}
