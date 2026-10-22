package com.google.zxing.oned;

/* JADX INFO: loaded from: classes3.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = null;
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = null;
    private static final char DEFAULT_GUARD = 0;
    private static final char[] START_END_CHARS = null;

    public CodaBarWriter() {
    }

    static {
        char[] r1 = {'A', 'B', 'C', 'D'};
        START_END_CHARS = r1;
        ALT_START_END_CHARS = new char[]{'T', 'N', '*', 'E'};
        CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[]{'/', ':', '+', '.'};
        DEFAULT_GUARD = r1[0];
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r10) {
        if (r10.length() >= 2) goto L5;
        StringBuilder r9 = new StringBuilder();
        char r0 = DEFAULT_GUARD;
        r10 = r9.append(r0).append(r10).append(r0).toString();
    L19:
        int r11 = 20;
        int r1 = 1;
    L21:
        if (r1 >= (r10.length() - 1)) goto L36;
        if (Character.isDigit(r10.charAt(r1)) == false) goto L25;
    L34:
        r11 = r11 + 9;
    L35:
        r1 = r1 + 1;
        goto L21
    L25:
        if (r10.charAt(r1) == '-') goto L34;
        if (r10.charAt(r1) == '$') goto L34;
        if (CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, r10.charAt(r1)) == false) goto L33;
        r11 = r11 + 10;
        goto L35
    L33:
        throw new IllegalArgumentException("Cannot encode : '" + r10.charAt(r1) + '\'');
    L36:
        boolean[] r12 = new boolean[r11 + (r10.length() - 1)];
        int r2 = 0;
        int r3 = 0;
    L38:
        if (r2 >= r10.length()) goto L77;
        char r4 = Character.toUpperCase(r10.charAt(r2));
        if (r2 == 0) goto L44;
        if (r2 == (r10.length() - 1)) goto L44;
    L56:
        int r5 = 0;
    L58:
        if (r5 >= CodaBarReader.ALPHABET.length) goto L63;
        if (r4 == CodaBarReader.ALPHABET[r5]) goto L61;
        r5 = r5 + 1;
        goto L58
    L61:
        int r6 = CodaBarReader.CHARACTER_ENCODINGS[r5];
    L64:
        int r7 = 0;
        int r8 = 0;
        boolean r13 = true;
    L66:
        if (r7 >= 7) goto L74;
        r12[r3] = r13;
        r3 = r3 + 1;
        if (((r6 >> (6 - r7)) & 1) == 0) goto L72;
        if (r8 == 1) goto L72;
        r8 = r8 + 1;
    L72:
        r13 = !r13;
        r7 = r7 + 1;
        r8 = 0;
        goto L66
    L74:
        if (r2 >= (r10.length() - 1)) goto L76;
        r12[r3] = false;
        r3 = r3 + 1;
    L76:
        r2 = r2 + 1;
        goto L38
    L63:
        r6 = 0;
    L44:
        if (r4 != '*') goto L46;
        r4 = 'C';
        goto L56
    L46:
        if (r4 != 'E') goto L48;
        r4 = 'D';
        goto L56
    L48:
        if (r4 != 'N') goto L50;
        r4 = 'B';
        goto L56
    L50:
        if (r4 != 'T') goto L56;
        r4 = 'A';
        goto L56
    L77:
        return r12;
    L5:
        char r14 = Character.toUpperCase(r10.charAt(0));
        char r15 = Character.toUpperCase(r10.charAt(r10.length() - 1));
        char[] r16 = START_END_CHARS;
        boolean r17 = CodaBarReader.arrayContains(r16, r14);
        boolean r18 = CodaBarReader.arrayContains(r16, r15);
        char[] r19 = ALT_START_END_CHARS;
        boolean r20 = CodaBarReader.arrayContains(r19, r14);
        boolean r21 = CodaBarReader.arrayContains(r19, r15);
        if (r17 == false) goto L11;
        if (r18 == true) goto L19;
        throw new IllegalArgumentException("Invalid start/end guards: " + r10);
    L11:
        if (r20 == false) goto L16;
        if (r21 == true) goto L19;
        throw new IllegalArgumentException("Invalid start/end guards: " + r10);
    L16:
        if (r18 == true) goto L79;
        if (r21 == true) goto L79;
        StringBuilder r22 = new StringBuilder();
        char r23 = DEFAULT_GUARD;
        r10 = r22.append(r23).append(r10).append(r23).toString();
    L79:
        throw new IllegalArgumentException("Invalid start/end guards: " + r10);
    }
}
