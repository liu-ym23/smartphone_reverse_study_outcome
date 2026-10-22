package c0;

import d2.l0;
import o2.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: h, reason: collision with root package name */
    public static b f2095h;

    /* renamed from: a, reason: collision with root package name */
    public l f2096a;

    /* renamed from: b, reason: collision with root package name */
    public l0 f2097b;

    /* renamed from: c, reason: collision with root package name */
    public o2.c f2098c;

    /* renamed from: d, reason: collision with root package name */
    public g2.d f2099d;

    /* renamed from: e, reason: collision with root package name */
    public l0 f2100e;

    /* renamed from: f, reason: collision with root package name */
    public float f2101f;

    /* renamed from: g, reason: collision with root package name */
    public float f2102g;

    public final long a(int i, long j10) {
        int iJ;
        l0 l0Var = this.f2100e;
        float f5 = this.f2102g;
        float fB = this.f2101f;
        if (Float.isNaN(f5) || Float.isNaN(fB)) {
            float fB2 = ac.a.e(c.f2103a, l0Var, o2.b.b(0, 0, 15), this.f2098c, this.f2099d, 1).b();
            fB = ac.a.e(c.f2104b, l0Var, o2.b.b(0, 0, 15), this.f2098c, this.f2099d, 2).b() - fB2;
            this.f2102g = fB2;
            this.f2101f = fB;
            f5 = fB2;
        }
        if (i != 1) {
            int iRound = Math.round((fB * (i - 1)) + f5);
            iJ = iRound >= 0 ? iRound : 0;
            int iH = o2.a.h(j10);
            if (iJ > iH) {
                iJ = iH;
            }
        } else {
            iJ = o2.a.j(j10);
        }
        return o2.b.a(o2.a.k(j10), o2.a.i(j10), iJ, o2.a.h(j10));
    }
}
