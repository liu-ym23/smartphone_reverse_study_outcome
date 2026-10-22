package r4;

/* renamed from: r4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1018a {
    public static final int a(int i5) {
        if (2 <= i5 && i5 < 37) {
            return i5;
        }
        throw new IllegalArgumentException("radix " + i5 + " was not in valid range " + new kotlin.ranges.h(2, 36));
    }

    public static final int b(char c6, int i5) {
        return Character.digit((int) c6, i5);
    }

    public static final boolean c(char c6) {
        return Character.isWhitespace(c6) || Character.isSpaceChar(c6);
    }
}
