package androidx.lifecycle;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f3540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f3541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f3542c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LifecycleRegistry f3543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lifecycle.Event f3544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3545c;

        public a(LifecycleRegistry r10, Lifecycle.Event r11) {
            kotlin.jvm.internal.q.g(r10, "registry");
            kotlin.jvm.internal.q.g(r11, "event");
            this.f3543a = r10;
            this.f3544b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3545c == true) goto L6;
            this.f3543a.handleLifecycleEvent(this.f3544b);
            this.f3545c = true;
            return;
        }
    }

    public i0(LifecycleOwner r10) {
        kotlin.jvm.internal.q.g(r10, "provider");
        this.f3540a = new LifecycleRegistry(r10);
        this.f3541b = new Handler();
    }

    private final void postDispatchRunnable(Lifecycle.Event r10) {
        a r11 = this.f3542c;
        if (r11 == null) goto L5;
        r11.run();
    L5:
        a r12 = new a(this.f3540a, r10);
        this.f3542c = r12;
        Handler r13 = this.f3541b;
        kotlin.jvm.internal.q.d(r12);
        r13.postAtFrontOfQueue(r12);
    }

    public Lifecycle a() {
        return this.f3540a;
    }

    public void b() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void c() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP);
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }
}
