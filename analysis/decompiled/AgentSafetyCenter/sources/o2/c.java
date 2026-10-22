package o2;

import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface c {
    default long E(float f5) {
        return n(M(f5));
    }

    default float J(int i) {
        return i / a();
    }

    default float M(float f5) {
        return f5 / a();
    }

    float T();

    default float X(float f5) {
        return a() * f5;
    }

    float a();

    default int e0(float f5) {
        float fX = X(f5);
        return Float.isInfinite(fX) ? Reader.READ_DONE : Math.round(fX);
    }

    default long j0(long j10) {
        if (j10 == 9205357640488583168L) {
            return 9205357640488583168L;
        }
        float fX = X(Float.intBitsToFloat((int) (j10 >> 32)));
        float fX2 = X(Float.intBitsToFloat((int) (j10 & 4294967295L)));
        return (Float.floatToRawIntBits(fX) << 32) | (Float.floatToRawIntBits(fX2) & 4294967295L);
    }

    default float m0(long j10) {
        if (!o.a(n.c(j10), 4294967296L)) {
            h.b("Only Sp can convert to Px");
        }
        return X(u(j10));
    }

    default long n(float f5) {
        float[] fArr = p2.b.f9692a;
        if (T() < 1.03f) {
            return com.stepos.statsrpk.h.C(f5 / T(), 4294967296L);
        }
        p2.a aVarA = p2.b.a(T());
        return com.stepos.statsrpk.h.C(aVarA != null ? aVarA.a(f5) : f5 / T(), 4294967296L);
    }

    default float u(long j10) {
        if (!o.a(n.c(j10), 4294967296L)) {
            h.b("Only Sp can convert to Px");
        }
        float[] fArr = p2.b.f9692a;
        if (T() < 1.03f) {
            return T() * n.d(j10);
        }
        p2.a aVarA = p2.b.a(T());
        if (aVarA != null) {
            return aVarA.b(n.d(j10));
        }
        return T() * n.d(j10);
    }
}
