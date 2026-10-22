package rx;

import rx.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BackpressureOverflow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Strategy f24125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Strategy f24126b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Strategy f24127c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Strategy f24128d = null;

    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    public static final class a implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24129a = null;

        static {
            f24129a = new a();
        }

        public a() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return false;
        }
    }

    public static final class b implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f24130a = null;

        static {
            f24130a = new b();
        }

        public b() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return true;
        }
    }

    public static final class c implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f24131a = null;

        static {
            f24131a = new c();
        }

        public c() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    static {
        c r10 = c.f24131a;
        f24125a = r10;
        f24126b = r10;
        f24127c = b.f24130a;
        f24128d = a.f24129a;
    }
}
