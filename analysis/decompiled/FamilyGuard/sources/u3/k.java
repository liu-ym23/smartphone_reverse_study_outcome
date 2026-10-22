package u3;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f22912a = new k();

    private k() {
    }

    public final int a(int i5) {
        return i5 == 2 ? 0 : 1;
    }

    public final float b(int i5, boolean z5, int i6) {
        if (i6 == 0) {
            return (i5 == 0 || !z5) ? 1.0f : 2.0f;
        }
        if (z5) {
            return 2.0f;
        }
        return a(i6);
    }

    public final float c(int i5) {
        return i5 == 1 ? 1.0f : 0.0f;
    }

    public final int d(int i5, float f5, float f6, float f7, boolean z5, int i6) {
        if (i6 != 0) {
            int iA = a(i6);
            float f8 = iA + ((2 - iA) * 0.2f);
            if (!z5 || f6 < (-f7) || (f6 <= f7 && f5 <= f8)) {
                return iA;
            }
            return 2;
        }
        if (i5 == 0) {
            return (f6 > f7 || (f5 > 0.2f && f6 >= (-f7))) ? 1 : 0;
        }
        if (f6 < (-f7)) {
            return 0;
        }
        if (f5 >= 0.8f || f6 > f7) {
            return (!z5 || (f6 <= f7 && f5 <= 1.2f)) ? 1 : 2;
        }
        return 0;
    }
}
