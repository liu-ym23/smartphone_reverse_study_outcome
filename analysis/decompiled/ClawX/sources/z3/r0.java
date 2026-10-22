package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public Long f6498a = 0L;

    /* renamed from: b, reason: collision with root package name */
    public Long f6499b = 0L;

    /* renamed from: c, reason: collision with root package name */
    public Long f6500c = 0L;

    static {
        kotlin.jvm.internal.z.a(r0.class);
        try {
            kotlin.jvm.internal.z.c(r0.class);
        } catch (Throwable unused) {
        }
        if (x5.n.t1("TimeoutConfiguration")) {
            throw new IllegalArgumentException("Name can't be blank");
        }
    }

    public r0() {
        c(null);
        b(null);
        d(null);
    }

    public static void a(Long l3) {
        if (l3 != null && l3.longValue() <= 0) {
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS");
        }
    }

    public final void b(Long l3) {
        a(l3);
        this.f6499b = l3;
    }

    public final void c(Long l3) {
        a(l3);
        this.f6498a = l3;
    }

    public final void d(Long l3) {
        a(l3);
        this.f6500c = l3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r0.class != obj.getClass()) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return kotlin.jvm.internal.p.a(this.f6498a, r0Var.f6498a) && kotlin.jvm.internal.p.a(this.f6499b, r0Var.f6499b) && kotlin.jvm.internal.p.a(this.f6500c, r0Var.f6500c);
    }

    public final int hashCode() {
        Long l3 = this.f6498a;
        int iHashCode = (l3 != null ? l3.hashCode() : 0) * 31;
        Long l6 = this.f6499b;
        int iHashCode2 = (iHashCode + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l8 = this.f6500c;
        return iHashCode2 + (l8 != null ? l8.hashCode() : 0);
    }
}
