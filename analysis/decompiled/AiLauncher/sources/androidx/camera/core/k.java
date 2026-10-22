package androidx.camera.core;

import K.F0;
import K.x0;
import androidx.camera.core.impl.j;
import androidx.camera.core.k;

/* loaded from: classes.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f11617a = new k() { // from class: D.j0
        @Override // androidx.camera.core.k
        public final k.c b(k.b bVar) {
            return k.c.f11622d;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final k f11618b = new j.b(e());

    /* renamed from: c, reason: collision with root package name */
    public static final k f11619c = new androidx.camera.core.impl.j(e());

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final k f11620a;

        /* renamed from: b, reason: collision with root package name */
        public long f11621b;

        public a(k kVar) {
            this.f11620a = kVar;
            this.f11621b = kVar.a();
        }

        public k a() {
            k kVar = this.f11620a;
            return kVar instanceof x0 ? ((x0) kVar).c(this.f11621b) : new F0(this.f11621b, this.f11620a);
        }
    }

    public interface b {
        Throwable a();

        long b();

        int getStatus();
    }

    public static final class c {

        /* renamed from: d, reason: collision with root package name */
        public static final c f11622d = new c(false, 0);

        /* renamed from: e, reason: collision with root package name */
        public static final c f11623e = new c(true);

        /* renamed from: f, reason: collision with root package name */
        public static final c f11624f = new c(true, 100);

        /* renamed from: g, reason: collision with root package name */
        public static c f11625g = new c(false, 0, true);

        /* renamed from: a, reason: collision with root package name */
        public final long f11626a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11627b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f11628c;

        public c(boolean z10) {
            this(z10, a());
        }

        public static long a() {
            return 500L;
        }

        public long b() {
            return this.f11626a;
        }

        public boolean c() {
            return this.f11628c;
        }

        public boolean d() {
            return this.f11627b;
        }

        public c(boolean z10, long j10) {
            this(z10, j10, false);
        }

        public c(boolean z10, long j10, boolean z11) {
            this.f11627b = z10;
            this.f11626a = j10;
            if (z11) {
                B0.h.b(!z10, "shouldRetry must be false when completeWithoutFailure is set to true");
            }
            this.f11628c = z11;
        }
    }

    static long e() {
        return 6000L;
    }

    default long a() {
        return 0L;
    }

    c b(b bVar);
}
