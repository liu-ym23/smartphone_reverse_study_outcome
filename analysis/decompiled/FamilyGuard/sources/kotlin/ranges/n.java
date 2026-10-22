package kotlin.ranges;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends m {
    public static float a(float f5, float f6) {
        return f5 < f6 ? f6 : f5;
    }

    public static int b(int i5, int i6) {
        return i5 < i6 ? i6 : i5;
    }

    public static long c(long j5, long j6) {
        return j5 < j6 ? j6 : j5;
    }

    public static float d(float f5, float f6) {
        return f5 > f6 ? f6 : f5;
    }

    public static int e(int i5, int i6) {
        return i5 > i6 ? i6 : i5;
    }

    public static long f(long j5, long j6) {
        return j5 > j6 ? j6 : j5;
    }

    public static float g(float f5, float f6, float f7) {
        if (f6 <= f7) {
            return f5 < f6 ? f6 : f5 > f7 ? f7 : f5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f7 + " is less than minimum " + f6 + '.');
    }

    public static int h(int i5, int i6, int i7) {
        if (i6 <= i7) {
            return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i7 + " is less than minimum " + i6 + '.');
    }

    public static f i(int i5, int i6) {
        return f.f17961d.a(i5, i6, -1);
    }

    public static h j(int i5, int i6) {
        return i6 <= Integer.MIN_VALUE ? h.f17969e.a() : new h(i5, i6 - 1);
    }
}
