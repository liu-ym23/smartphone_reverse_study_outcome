package okio;

/* JADX INFO: loaded from: classes5.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String r2) {
        return size(r2, 0, r2.length());
    }

    public static long size(String r9, int r10, int r11) {
        if (r9 == null) goto L43;
        if (r10 < 0) goto L41;
        if (r11 < r10) goto L39;
        if (r11 > r9.length()) goto L37;
        long r0 = 0;
    L8:
        if (r10 >= r11) goto L35;
        char r2 = r9.charAt(r10);
        if (r2 < 128) goto L11;
        if (r2 < 2048) goto L15;
        if (r2 < 55296) goto L34;
        if (r2 > 57343) goto L34;
        int r6 = r10 + 1;
        if (r6 >= r11) goto L25;
        char r7 = r9.charAt(r6);
    L27:
        if (r2 > 56319) goto L33;
        if (r7 < 56320) goto L33;
        if (r7 > 57343) goto L33;
        r0 = r0 + 4;
        r10 = r10 + 2;
    L33:
        r0 = r0 + 1;
        r10 = r6;
        goto L8
    L25:
        r7 = 0;
    L34:
        long r3 = 3;
    L16:
        r0 = r0 + r3;
    L12:
        r10 = r10 + 1;
        goto L8
    L15:
        r3 = 2;
        goto L16
    L11:
        r0 = r0 + 1;
        goto L12
    L35:
        return r0;
    L37:
        throw new IllegalArgumentException("endIndex > string.length: " + r11 + " > " + r9.length());
    L39:
        throw new IllegalArgumentException("endIndex < beginIndex: " + r11 + " < " + r10);
    L41:
        throw new IllegalArgumentException("beginIndex < 0: " + r10);
    L43:
        throw new IllegalArgumentException("string == null");
    }
}
