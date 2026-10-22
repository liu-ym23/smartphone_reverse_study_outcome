package aj0;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final boolean a(int r100, int r101) {
        if (r101 != 51) goto L14;
        if (r100 == 0) goto L19;
        if (r100 != 1) goto L7;
        return false;
    L7:
        if (r100 == 4) goto L21;
        if (r100 == 5) goto L22;
        if (r100 != 8) goto L11;
        return false;
    L11:
        if (r100 == 9) goto L24;
    L12:
        return true;
    L24:
        return false;
    L22:
        return false;
    L21:
        return false;
    L19:
        return false;
    L14:
        if (r101 != 67) goto L17;
        if (r100 > 8) goto L12;
        return false;
    L17:
        if (r100 > 5) goto L12;
        return false;
    }

    public static final boolean c(int r100) {
        if (r100 != 51) goto L5;
    L14:
        return true;
    L5:
        if (r100 == 56) goto L14;
        if (r100 == 57) goto L14;
        if (r100 == 58) goto L14;
        if (r100 == 67) goto L14;
        return false;
    }

    public static final boolean b(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L10:
        if (r100 != null) goto L13;
    L14:
        if (r100 != null) goto L17;
    L18:
        if (r100 != null) goto L21;
    L23:
        return false;
    L21:
        if (r100.intValue() != 39) goto L23;
    L24:
        return true;
    L17:
        if (r100.intValue() == 33) goto L24;
    L13:
        if (r100.intValue() == 32) goto L24;
    L9:
        if (r100.intValue() == 31) goto L24;
    L5:
        if (r100.intValue() == 17) goto L24;
        goto L6
    }
}
