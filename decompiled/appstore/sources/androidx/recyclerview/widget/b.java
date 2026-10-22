package androidx.recyclerview.widget;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f4316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DiffUtil.ItemCallback f4318c;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Object f4319d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Executor f4320e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f4321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f4322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DiffUtil.ItemCallback f4323c;

        static {
            f4319d = new Object();
        }

        public a(DiffUtil.ItemCallback r10) {
            this.f4323c = r10;
        }

        public b a() {
            if (this.f4322b != null) goto L16;
            Object r10 = f4319d;
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (f4320e != null) goto L11;
            f4320e = Executors.newFixedThreadPool(2);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            this.f4322b = f4320e;
        L16:
            return new b(this.f4321a, this.f4322b, this.f4323c);
        }
    }

    public b(Executor r10, Executor r11, DiffUtil.ItemCallback r12) {
        this.f4316a = r10;
        this.f4317b = r11;
        this.f4318c = r12;
    }

    public Executor a() {
        return this.f4317b;
    }

    public DiffUtil.ItemCallback b() {
        return this.f4318c;
    }

    public Executor c() {
        return this.f4316a;
    }
}
