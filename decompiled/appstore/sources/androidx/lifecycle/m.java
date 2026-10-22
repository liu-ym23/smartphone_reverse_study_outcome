package androidx.lifecycle;

import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f3556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle.State f3557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f3558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleEventObserver f3559d;

    public m(Lifecycle r10, Lifecycle.State r11, h r12, final Job r13) {
        kotlin.jvm.internal.q.g(r10, "lifecycle");
        kotlin.jvm.internal.q.g(r11, "minState");
        kotlin.jvm.internal.q.g(r12, "dispatchQueue");
        kotlin.jvm.internal.q.g(r13, "parentJob");
        this.f3556a = r10;
        this.f3557b = r11;
        this.f3558c = r12;
        LifecycleEventObserver r14 = new l(this, r13);
        this.f3559d = r14;
        if (r10.b() != Lifecycle.State.DESTROYED) goto L5;
        Job.a.b(r13, null, 1, null);
        b();
        return;
    L5:
        r10.a(r14);
    }

    public static /* synthetic */ void a(m r10, Job r11, LifecycleOwner r12, Lifecycle.Event r13) {
        c(r10, r11, r12, r13);
    }

    public static final void c(m r10, Job r11, LifecycleOwner r12, Lifecycle.Event r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$parentJob");
        kotlin.jvm.internal.q.g(r12, "source");
        kotlin.jvm.internal.q.g(r13, "<anonymous parameter 1>");
        if (r12.getLifecycle().b() != Lifecycle.State.DESTROYED) goto L6;
        Job.a.b(r11, null, 1, null);
        r10.b();
        return;
    L6:
        if (r12.getLifecycle().b().compareTo(r10.f3557b) >= 0) goto L8;
        r10.f3558c.h();
        return;
    L8:
        r10.f3558c.i();
    }

    public final void b() {
        this.f3556a.d(this.f3559d);
        this.f3558c.g();
    }
}
