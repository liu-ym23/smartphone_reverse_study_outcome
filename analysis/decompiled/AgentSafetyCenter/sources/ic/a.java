package ic;

import p5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public static final long f5937c;

    /* renamed from: f, reason: collision with root package name */
    public static final long f5938f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f5939g = 0;

    static {
        int i = b.f5940a;
        f5937c = ac.a.r(4611686018427387903L);
        f5938f = ac.a.r(-4611686018427387903L);
    }

    public static final long a(long j10, long j11) {
        long j12 = 1000000;
        long j13 = j11 / j12;
        long j14 = j10 + j13;
        if (-4611686018426L > j14 || j14 >= 4611686018427L) {
            return ac.a.r(f.r(j14, -4611686018427387903L, 4611686018427387903L));
        }
        long j15 = ((j14 * j12) + (j11 - (j13 * j12))) << 1;
        int i = b.f5940a;
        return j15;
    }

    public static final boolean b(long j10) {
        return j10 == f5937c || j10 == f5938f;
    }
}
