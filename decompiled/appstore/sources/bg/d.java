package bg;

import java.util.Iterator;
import kotlin.collections.h0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f6007d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6010c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f6007d = new a(null);
    }

    public d(long r10, long r11, long r12) {
        if (r12 == 0) goto L11;
        if (r12 == Long.MIN_VALUE) goto L9;
        this.f6008a = r10;
        this.f6009b = uf.c.d(r10, r11, r12);
        this.f6010c = r12;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final long a() {
        return this.f6008a;
    }

    public final long b() {
        return this.f6009b;
    }

    public h0 c() {
        return new e(this.f6008a, this.f6009b, this.f6010c);
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return c();
    }
}
