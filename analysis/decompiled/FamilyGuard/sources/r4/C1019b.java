package r4;

/* renamed from: r4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1019b extends C1018a {
    public static final boolean d(char c6, char c7, boolean z5) {
        if (c6 == c7) {
            return true;
        }
        if (!z5) {
            return false;
        }
        char upperCase = Character.toUpperCase(c6);
        char upperCase2 = Character.toUpperCase(c7);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}
