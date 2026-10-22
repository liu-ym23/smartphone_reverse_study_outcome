package t3;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f22696a = new k();

    private k() {
    }

    public final boolean a(int i5, int i6) {
        return i5 != 0 ? i5 != 1 ? i5 == 2 && i6 >= 1 : i6 == 3 : i6 >= 2;
    }

    public final boolean b(float f5, float f6, float f7, float f8) {
        return (Math.abs(f6) < f8 || Math.abs(f6) <= Math.abs(f7)) ? f5 >= 0.5f : f6 > 0.0f;
    }

    public final int c(int i5, int i6, int i7) {
        if (i5 < 0 || i5 >= 4) {
            throw new IllegalArgumentException("count must be in 0..3");
        }
        if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("iconSize and gap must be non-negative");
        }
        if (i5 == 0) {
            return 0;
        }
        return (i6 * i5) + (i7 * (i5 + 1));
    }
}
