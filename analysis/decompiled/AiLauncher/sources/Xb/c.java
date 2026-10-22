package Xb;

import com.fasterxml.jackson.core.JsonFactory;

/* loaded from: classes5.dex */
public class c {
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.CharSequence r4, int r5) {
        /*
            int r0 = r4.length()
            r1 = -1
            if (r5 < r0) goto L8
            return r1
        L8:
            char r0 = r4.charAt(r5)
            r2 = 60
            if (r0 != r2) goto L39
        L10:
            int r5 = r5 + 1
            int r0 = r4.length()
            if (r5 >= r0) goto L38
            char r0 = r4.charAt(r5)
            r3 = 10
            if (r0 == r3) goto L38
            if (r0 == r2) goto L38
            r3 = 62
            if (r0 == r3) goto L35
            r3 = 92
            if (r0 == r3) goto L2b
            goto L10
        L2b:
            int r0 = r5 + 1
            boolean r3 = Xb.d.g(r4, r0)
            if (r3 == 0) goto L10
            r5 = r0
            goto L10
        L35:
            int r5 = r5 + 1
            return r5
        L38:
            return r1
        L39:
            int r4 = b(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: Xb.c.a(java.lang.CharSequence, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0042 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(java.lang.CharSequence r6, int r7) {
        /*
            r0 = 0
            r1 = r7
        L2:
            int r2 = r6.length()
            if (r1 >= r2) goto L44
            char r2 = r6.charAt(r1)
            r3 = -1
            if (r2 == 0) goto L40
            r4 = 32
            if (r2 == r4) goto L40
            r5 = 92
            if (r2 == r5) goto L34
            r5 = 40
            if (r2 == r5) goto L2f
            r4 = 41
            if (r2 == r4) goto L29
            boolean r2 = java.lang.Character.isISOControl(r2)
            if (r2 == 0) goto L3d
            if (r1 == r7) goto L28
            goto L42
        L28:
            return r3
        L29:
            if (r0 != 0) goto L2c
            goto L42
        L2c:
            int r0 = r0 + (-1)
            goto L3d
        L2f:
            int r0 = r0 + 1
            if (r0 <= r4) goto L3d
            return r3
        L34:
            int r2 = r1 + 1
            boolean r3 = Xb.d.g(r6, r2)
            if (r3 == 0) goto L3d
            r1 = r2
        L3d:
            int r1 = r1 + 1
            goto L2
        L40:
            if (r1 == r7) goto L43
        L42:
            return r1
        L43:
            return r3
        L44:
            int r6 = r6.length()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Xb.c.b(java.lang.CharSequence, int):int");
    }

    public static int c(CharSequence charSequence, int i10) {
        while (i10 < charSequence.length()) {
            switch (charSequence.charAt(i10)) {
                case '[':
                    return -1;
                case '\\':
                    int i11 = i10 + 1;
                    if (!d.g(charSequence, i11)) {
                        break;
                    } else {
                        i10 = i11;
                        break;
                    }
                case ']':
                    return i10;
            }
            i10++;
        }
        return charSequence.length();
    }

    public static int d(CharSequence charSequence, int i10) {
        if (i10 >= charSequence.length()) {
            return -1;
        }
        char cCharAt = charSequence.charAt(i10);
        char c10 = JsonFactory.DEFAULT_QUOTE_CHAR;
        if (cCharAt != '\"') {
            c10 = '\'';
            if (cCharAt != '\'') {
                if (cCharAt != '(') {
                    return -1;
                }
                c10 = ')';
            }
        }
        int iE = e(charSequence, i10 + 1, c10);
        if (iE != -1 && iE < charSequence.length() && charSequence.charAt(iE) == c10) {
            return iE + 1;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(java.lang.CharSequence r3, int r4, char r5) {
        /*
        L0:
            int r0 = r3.length()
            if (r4 >= r0) goto L28
            char r0 = r3.charAt(r4)
            r1 = 92
            if (r0 != r1) goto L18
            int r1 = r4 + 1
            boolean r2 = Xb.d.g(r3, r1)
            if (r2 == 0) goto L18
            r4 = r1
            goto L25
        L18:
            if (r0 != r5) goto L1b
            return r4
        L1b:
            r1 = 41
            if (r5 != r1) goto L25
            r1 = 40
            if (r0 != r1) goto L25
            r3 = -1
            return r3
        L25:
            int r4 = r4 + 1
            goto L0
        L28:
            int r3 = r3.length()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: Xb.c.e(java.lang.CharSequence, int, char):int");
    }
}
