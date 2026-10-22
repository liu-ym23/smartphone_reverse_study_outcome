package d.o;

/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class b {
    public static final boolean a(char r1) {
        if (Character.isWhitespace(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r1) == true) goto L8;
        return false;
    }

    public static final int a(char r0, int r1) {
        return Character.digit(r0, r1);
    }

    public static final int a(int r4) {
        boolean r0 = false;
        if (2 <= r4) goto L5;
    L7:
        if (r0 == false) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("radix " + r4 + " was not in valid range " + new d.l.j(2, 36));
    L5:
        if (r4 >= 37) goto L7;
        r0 = true;
        goto L7
    }
}
