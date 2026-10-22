package kotlin.text;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static int a(int r10) {
        if (new bg.c(2, 36).f(r10) == false) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("radix " + r10 + " was not in valid range " + new bg.c(2, 36));
    }

    public static final int b(char r10, int r11) {
        return Character.digit(r10, r11);
    }

    public static final boolean c(char r10) {
        if (Character.isWhitespace(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r10) == true) goto L8;
        return false;
    }
}
