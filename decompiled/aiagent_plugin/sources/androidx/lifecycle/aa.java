package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProcessLifecycleOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class aa implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1972a = null;
    private static final aa j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1976e;
    private Handler f;
    private final r g;
    private final Runnable h;
    private final ReportFragment.a i;

    /* JADX INFO: compiled from: ProcessLifecycleOwner.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1977a = null;

        static {
            f1977a = new a();
        }

        private a() {
        }

        public static final void a(Activity r2, Application.ActivityLifecycleCallbacks r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            Application.ActivityLifecycleCallbacks r5 = (Application.ActivityLifecycleCallbacks) ZeusTransformUtils.wrapperContextForParams(r3, Application.ActivityLifecycleCallbacks.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "activity");
            d.h.b.o.e(r5, "callback");
            r4.registerActivityLifecycleCallbacks(r5);
        }
    }

    /* JADX INFO: compiled from: ProcessLifecycleOwner.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final p a() {
            return (p) ZeusTransformUtils.preCheckCast(aa.g(), p.class, "com.obric.aiagent.plugin");
        }

        public final void a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            aa.g().a(r1);
        }
    }

    /* JADX INFO: compiled from: ProcessLifecycleOwner.kt */
    public static final class c implements ReportFragment.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ aa f1978a;

        @Override // androidx.lifecycle.ReportFragment.a
        public void a() {
        }

        c(aa r1) {
            this.f1978a = r1;
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void b() {
            this.f1978a.a();
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void c() {
            this.f1978a.b();
        }
    }

    public static /* synthetic */ void lambda$SWY1fX9YYtXDSYzhmqDoiTN5VNc(aa r0) {
        b(r0);
    }

    private aa() {
        this.f1975d = true;
        this.f1976e = true;
        this.g = new r((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"));
        this.h = new $$Lambda$aa$SWY1fX9YYtXDSYzhmqDoiTN5VNc(this);
        this.i = (ReportFragment.a) ZeusTransformUtils.preCheckCast(new c(this), ReportFragment.a.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ ReportFragment.a a(aa r0) {
        return r0.i;
    }

    public static final /* synthetic */ aa g() {
        return j;
    }

    private static final void b(aa r1) {
        d.h.b.o.e(r1, "this$0");
        r1.e();
        r1.f();
    }

    static {
        f1972a = new b(null);
        j = new aa();
    }

    public final void a() {
        int r0 = this.f1973b + 1;
        this.f1973b = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.f1976e == false) goto L9;
        this.g.a(i.a.ON_START);
        this.f1976e = false;
        return;
    }

    public final void b() {
        int r0 = this.f1974c + 1;
        this.f1974c = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.f1975d == false) goto L7;
        this.g.a(i.a.ON_RESUME);
        this.f1975d = false;
        return;
    L7:
        Handler r1 = this.f;
        d.h.b.o.a(r1);
        r1.removeCallbacks(this.h);
    }

    public final void c() {
        int r0 = this.f1974c - 1;
        this.f1974c = r0;
        if (r0 != 0) goto L6;
        Handler r1 = this.f;
        d.h.b.o.a(r1);
        r1.postDelayed(this.h, 700);
        return;
    }

    public final void d() {
        this.f1973b--;
        f();
    }

    public final void e() {
        if (this.f1974c != 0) goto L6;
        this.f1975d = true;
        this.g.a(i.a.ON_PAUSE);
        return;
    }

    public final void f() {
        if (this.f1973b == 0) goto L5;
        return;
    L5:
        if (this.f1975d == false) goto L9;
        this.g.a(i.a.ON_STOP);
        this.f1976e = true;
        return;
    }

    public final void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        this.f = new Handler();
        this.g.a(i.a.ON_CREATE);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r6, "null cannot be cast to non-null type android.app.Application");
        ((Application) ZeusTransformUtils.preCheckCast(r6, Application.class, "com.obric.aiagent.plugin")).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(new ProcessLifecycleOwner$attach$1(this), Application.ActivityLifecycleCallbacks.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.lifecycle.p
    public i getLifecycle() {
        return (i) ZeusTransformUtils.preCheckCast(this.g, i.class, "com.obric.aiagent.plugin");
    }
}
