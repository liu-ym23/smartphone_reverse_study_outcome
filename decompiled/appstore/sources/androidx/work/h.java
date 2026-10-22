package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WorkerParameters f5416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f5417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5418d;

    public static abstract class a {

        /* JADX INFO: renamed from: androidx.work.h$a$a, reason: collision with other inner class name */
        public static final class C0057a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final androidx.work.c f5419a;

            public C0057a() {
                this(androidx.work.c.f5406c);
            }

            public androidx.work.c e() {
                return this.f5419a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L5;
                return true;
            L5:
                if (r10 != null) goto L7;
                return false;
            L7:
                if (C0057a.class == r10.getClass()) goto L10;
                return false;
            L10:
                return this.f5419a.equals(((C0057a) r10).f5419a);
            }

            public int hashCode() {
                return (C0057a.class.getName().hashCode() * 31) + this.f5419a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f5419a + '}';
            }

            public C0057a(androidx.work.c r10) {
                this.f5419a = r10;
            }
        }

        public static final class b extends a {
            public b() {
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L5;
                return true;
            L5:
                if (r10 != null) goto L7;
            L9:
                return false;
            L7:
                if (b.class != r10.getClass()) goto L9;
                return true;
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final androidx.work.c f5420a;

            public c() {
                this(androidx.work.c.f5406c);
            }

            public androidx.work.c e() {
                return this.f5420a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L5;
                return true;
            L5:
                if (r10 != null) goto L7;
                return false;
            L7:
                if (c.class == r10.getClass()) goto L10;
                return false;
            L10:
                return this.f5420a.equals(((c) r10).f5420a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f5420a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f5420a + '}';
            }

            public c(androidx.work.c r10) {
                this.f5420a = r10;
            }
        }

        public a() {
        }

        public static a a() {
            return new C0057a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(androidx.work.c r10) {
            return new c(r10);
        }
    }

    public h(Context r10, WorkerParameters r11) {
        if (r10 == null) goto L10;
        if (r11 == null) goto L8;
        this.f5415a = r10;
        this.f5416b = r11;
        return;
    L8:
        throw new IllegalArgumentException("WorkerParameters is null");
    L10:
        throw new IllegalArgumentException("Application Context is null");
    }

    public final Context a() {
        return this.f5415a;
    }

    public Executor b() {
        return this.f5416b.a();
    }

    public ListenableFuture c() {
        androidx.work.impl.utils.futures.a r10 = androidx.work.impl.utils.futures.a.t();
        r10.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return r10;
    }

    public final UUID d() {
        return this.f5416b.c();
    }

    public final c e() {
        return this.f5416b.d();
    }

    public TaskExecutor f() {
        return this.f5416b.e();
    }

    public m g() {
        return this.f5416b.f();
    }

    public final boolean h() {
        return this.f5417c;
    }

    public final boolean i() {
        return this.f5418d;
    }

    public void j() {
    }

    public final void k() {
        this.f5418d = true;
    }

    public abstract ListenableFuture l();

    public final void m() {
        this.f5417c = true;
        j();
    }
}
