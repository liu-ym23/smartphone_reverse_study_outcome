package tc;

import kotlin.time.DurationUnit;
import rc.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s implements pc.a<hc.a> {

    /* renamed from: a, reason: collision with root package name */
    public static final s f13048a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f13049b = new v0("kotlin.time.Duration", d.i.f11785a);

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        long j10;
        long j11;
        int iG;
        long j12 = ((hc.a) obj).f9404a;
        int i10 = hc.a.f9403d;
        StringBuilder sb2 = new StringBuilder();
        if (j12 < 0) {
            sb2.append('-');
        }
        sb2.append("PT");
        boolean z = true;
        if (j12 < 0) {
            j10 = ((-(j12 >> 1)) << 1) + (((int) j12) & 1);
            int i11 = hc.b.f9405a;
        } else {
            j10 = j12;
        }
        long jG = hc.a.g(j10, DurationUnit.h);
        if (hc.a.d(j10)) {
            j11 = 0;
            iG = 0;
        } else {
            j11 = 0;
            iG = (int) (hc.a.g(j10, DurationUnit.f10102e) % 60);
        }
        int iG2 = hc.a.d(j10) ? 0 : (int) (hc.a.g(j10, DurationUnit.f10101d) % 60);
        int iC = hc.a.c(j10);
        if (hc.a.d(j12)) {
            jG = 9999999999999L;
        }
        boolean z3 = jG != j11;
        boolean z10 = (iG2 == 0 && iC == 0) ? false : true;
        if (iG == 0 && (!z10 || !z3)) {
            z = false;
        }
        if (z3) {
            sb2.append(jG);
            sb2.append('H');
        }
        if (z) {
            sb2.append(iG);
            sb2.append('M');
        }
        if (z10 || (!z3 && !z)) {
            hc.a.b(sb2, iG2, iC, 9, "S", true);
        }
        kVar.B(sb2.toString());
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        int i10 = hc.a.f9403d;
        String value = dVar.v();
        kotlin.jvm.internal.g.f(value, "value");
        try {
            return new hc.a(androidx.datastore.preferences.protobuf.b1.e(value));
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a0.a.k("Invalid ISO duration string format: '", value, "'."), e10);
        }
    }

    @Override // pc.c
    public final rc.e d() {
        return f13049b;
    }
}
