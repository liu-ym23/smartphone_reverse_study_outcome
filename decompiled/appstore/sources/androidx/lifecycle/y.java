package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class y implements LifecycleOwner {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f3580i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y f3581j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f3586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LifecycleRegistry f3587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f3588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReportFragment.ActivityInitializationListener f3589h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3590a = null;

        static {
            f3590a = new a();
        }

        public a() {
        }

        @JvmStatic
        @DoNotInline
        public static final void a(@NotNull Activity r10, @NotNull Application.ActivityLifecycleCallbacks r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
            kotlin.jvm.internal.q.g(r11, "callback");
            r10.registerActivityLifecycleCallbacks(r11);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final LifecycleOwner a() {
            return y.b();
        }

        public final void b(Context r10) {
            kotlin.jvm.internal.q.g(r10, "context");
            y.b().g(r10);
        }

        public b() {
        }
    }

    public static final class c extends i {
        final /* synthetic */ y this$0;

        public static final class a extends i {
            final /* synthetic */ y this$0;

            public a(y r10) {
                this.this$0 = r10;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(@NotNull Activity r10) {
                kotlin.jvm.internal.q.g(r10, "activity");
                this.this$0.d();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(@NotNull Activity r10) {
                kotlin.jvm.internal.q.g(r10, "activity");
                this.this$0.e();
            }
        }

        public c(y r10) {
            this.this$0 = r10;
        }

        @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity r10, @Nullable Bundle r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }

        @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            this.this$0.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @RequiresApi(29)
        public void onActivityPreCreated(@NotNull Activity r10, @Nullable Bundle r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
            a.a(r10, new a(this.this$0));
        }

        @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            this.this$0.f();
        }
    }

    public static final class d implements ReportFragment.ActivityInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f3591a;

        public d(y r10) {
            this.f3591a = r10;
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            this.f3591a.d();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            this.f3591a.e();
        }
    }

    static {
        f3580i = new b(null);
        f3581j = new y();
    }

    public y() {
        this.f3584c = true;
        this.f3585d = true;
        this.f3587f = new LifecycleRegistry(this);
        this.f3588g = new x(this);
        this.f3589h = new d(this);
    }

    public static /* synthetic */ void a(y r10) {
        h(r10);
    }

    public static final /* synthetic */ y b() {
        return f3581j;
    }

    public static final void h(y r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.i();
        r10.j();
    }

    public final void c() {
        int r10 = this.f3583b - 1;
        this.f3583b = r10;
        if (r10 != 0) goto L6;
        Handler r11 = this.f3586e;
        kotlin.jvm.internal.q.d(r11);
        r11.postDelayed(this.f3588g, 700);
        return;
    }

    public final void d() {
        int r10 = this.f3583b + 1;
        this.f3583b = r10;
        if (r10 == 1) goto L5;
        return;
    L5:
        if (this.f3584c == false) goto L7;
        this.f3587f.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.f3584c = false;
        return;
    L7:
        Handler r11 = this.f3586e;
        kotlin.jvm.internal.q.d(r11);
        r11.removeCallbacks(this.f3588g);
    }

    public final void e() {
        int r10 = this.f3582a + 1;
        this.f3582a = r10;
        if (r10 == 1) goto L5;
        return;
    L5:
        if (this.f3585d == false) goto L9;
        this.f3587f.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.f3585d = false;
        return;
    }

    public final void f() {
        this.f3582a--;
        j();
    }

    public final void g(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        this.f3586e = new Handler();
        this.f3587f.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Context r11 = r10.getApplicationContext();
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type android.app.Application");
        ((Application) r11).registerActivityLifecycleCallbacks(new c(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f3587f;
    }

    public final void i() {
        if (this.f3583b != 0) goto L6;
        this.f3584c = true;
        this.f3587f.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        return;
    }

    public final void j() {
        if (this.f3582a == 0) goto L5;
        return;
    L5:
        if (this.f3584c == false) goto L9;
        this.f3587f.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.f3585d = true;
        return;
    }
}
