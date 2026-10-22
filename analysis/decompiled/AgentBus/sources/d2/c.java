package d2;

/* loaded from: classes.dex */
public interface c {
    default long F(long j2) {
        if (j2 == 9205357640488583168L) {
            return 9205357640488583168L;
        }
        float fO = o(Float.intBitsToFloat((int) (j2 >> 32)));
        float fO2 = o(Float.intBitsToFloat((int) (j2 & 4294967295L)));
        return (Float.floatToRawIntBits(fO) << 32) | (Float.floatToRawIntBits(fO2) & 4294967295L);
    }

    default float J(long j2) {
        if (!o.a(n.b(j2), 4294967296L)) {
            h.b("Only Sp can convert to Px");
        }
        return o(t(j2));
    }

    default long R(float f10) {
        return n(X(f10));
    }

    default float X(float f10) {
        return f10 / c();
    }

    float c();

    float j();

    default long n(float f10) {
        float[] fArr = e2.b.f3046a;
        if (j() < 1.03f) {
            return s7.a.Q(f10 / j(), 4294967296L);
        }
        e2.a aVarA = e2.b.a(j());
        return s7.a.Q(aVarA != null ? aVarA.a(f10) : f10 / j(), 4294967296L);
    }

    default float o(float f10) {
        return c() * f10;
    }

    default float t(long j2) {
        if (!o.a(n.b(j2), 4294967296L)) {
            h.b("Only Sp can convert to Px");
        }
        float[] fArr = e2.b.f3046a;
        if (j() < 1.03f) {
            return j() * n.c(j2);
        }
        e2.a aVarA = e2.b.a(j());
        if (aVarA != null) {
            return aVarA.b(n.c(j2));
        }
        return j() * n.c(j2);
    }

    default int y(float f10) {
        float fO = o(f10);
        if (Float.isInfinite(fO)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fO);
    }
}
