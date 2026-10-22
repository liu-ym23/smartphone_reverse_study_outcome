package bytekn.foundation.concurrent.scheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f21741a;

    public static final class a implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile ScheduledExecutorService f21742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f21743b;

        /* JADX INFO: renamed from: bytekn.foundation.concurrent.scheduler.e$a$a, reason: collision with other inner class name */
        public static final class C0380a {
        }

        static {
        }

        public a(f r100) {
            this.f21742a = r100.get();
            this.f21743b = new Object();
        }

        @Override // bytekn.foundation.concurrent.scheduler.i.a
        public final void a(long r100, Function0<Unit> r101) {
            if (this.f21742a == null) goto L14;
            Object r102 = this.f21743b;
            monitor-enter(r102);
            ScheduledExecutorService r103 = this.f21742a;     // Catch: Throwable -> L11
            if (r103 == null) goto L9;
            r103.schedule(new d(r101), r100, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r102);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    @Override // bytekn.foundation.concurrent.scheduler.i
    public final i.a a() {
        return new a(this.f21741a);
    }

    public e(bytekn.foundation.concurrent.scheduler.a r100) {
        this.f21741a = r100;
    }
}
