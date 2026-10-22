package a8b;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static boolean a(int r100) {
        switch(Character.getType(r100)) {
            case 20: goto L5;
            case 21: goto L5;
            case 22: goto L5;
            case 23: goto L5;
            case 24: goto L5;
            case 25: goto L5;
            case 26: goto L5;
            case 27: goto L5;
            case 28: goto L5;
            case 29: goto L5;
            case 30: goto L5;
            default: goto L7;
        };
    L5:
        return true;
    L7:
        if (r100 != 36) goto L9;
    L21:
        return true;
    L9:
        if (r100 == 43) goto L21;
        if (r100 == 94) goto L21;
        if (r100 == 96) goto L21;
        if (r100 == 124) goto L21;
        if (r100 == 126) goto L21;
        switch(r100) {
            case 60: goto L21;
            case 61: goto L21;
            case 62: goto L21;
            default: goto L19;
        };
    L19:
        return false;
    }

    public static boolean b(int r100) {
        if (r100 != 9) goto L5;
        return true;
    L5:
        if (r100 != 10) goto L7;
        return true;
    L7:
        if (r100 != 12) goto L9;
        return true;
    L9:
        if (r100 != 13) goto L11;
        return true;
    L11:
        if (r100 != 32) goto L13;
        return true;
    L13:
        if (Character.getType(r100) == 12) goto L22;
        return false;
    L22:
        return true;
    }

    public static int c(CharSequence r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L9;
        char r103 = r100.charAt(r101);
        if (r103 == '\t') goto L8;
        if (r103 == ' ') goto L8;
        return r101;
    L8:
        r101 = r101 + 1;
        goto L2
    L9:
        return r102;
    }
}
