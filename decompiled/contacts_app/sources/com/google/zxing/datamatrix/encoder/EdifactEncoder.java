package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes3.dex */
final class EdifactEncoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 4;
    }

    EdifactEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext r6) {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (r6.hasMoreCharacters() == false) goto L10;
        encodeChar(r6.getCurrentChar(), r0);
        r6.pos++;
        if (r0.length() < 4) goto L4;
        r6.writeCodewords(encodeToCodewords(r0, 0));
        r0.delete(0, 4);
        if (HighLevelEncoder.lookAheadTest(r6.getMessage(), r6.pos, getEncodingMode()) == getEncodingMode()) goto L4;
        r6.signalEncoderChange(0);
    L10:
        r0.append(31);
        handleEOD(r6, r0);
    }

    private static void handleEOD(EncoderContext r6, CharSequence r7) {
        int r1 = r7.length();     // Catch: Throwable -> L33
        if (r1 != 0) goto L7;
        r6.signalEncoderChange(0);
        return;
    L7:
        boolean r3 = true;
        if (r1 != 1) goto L15;
        r6.updateSymbolInfo();     // Catch: Throwable -> L33
        int r4 = r6.getSymbolInfo().getDataCapacity() - r6.getCodewordCount();     // Catch: Throwable -> L33
        if (r6.getRemainingCharacters() != 0) goto L15;
        if (r4 > 2) goto L15;
        r6.signalEncoderChange(0);
        return;
    L15:
        if (r1 > 4) goto L32;
        int r2 = r1 - 1;
        String r8 = encodeToCodewords(r7, 0);     // Catch: Throwable -> L33
        if ((!r6.hasMoreCharacters()) == false) goto L21;
        if (r2 > 2) goto L21;
    L22:
        if (r2 > 2) goto L26;
        r6.updateSymbolInfo(r6.getCodewordCount() + r2);     // Catch: Throwable -> L33
        if ((r6.getSymbolInfo().getDataCapacity() - r6.getCodewordCount()) < 3) goto L26;
        r6.updateSymbolInfo(r6.getCodewordCount() + r8.length());     // Catch: Throwable -> L33
        r3 = false;
    L26:
        if (r3 == false) goto L28;
        r6.resetSymbolInfo();     // Catch: Throwable -> L33
        r6.pos -= r2;     // Catch: Throwable -> L33
    L29:
        r6.signalEncoderChange(0);
        return;
    L28:
        r6.writeCodewords(r8);     // Catch: Throwable -> L33
    L21:
        r3 = false;
        goto L22
    L32:
        throw new IllegalStateException("Count must not exceed 4");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r6.signalEncoderChange(0);
        throw th;
    }

    private static void encodeChar(char r2, StringBuilder r3) {
        if (r2 < ' ') goto L9;
        if (r2 > '?') goto L9;
        r3.append(r2);
        return;
    L9:
        if (r2 >= '@') goto L11;
    L14:
        HighLevelEncoder.illegalCharacter(r2);
        return;
    L11:
        if (r2 > '^') goto L14;
        r3.append((char) (r2 - '@'));
    }

    private static String encodeToCodewords(CharSequence r8, int r9) {
        int r0 = r8.length() - r9;
        if (r0 == 0) goto L23;
        char r1 = r8.charAt(r9);
        char r2 = 0;
        if (r0 < 2) goto L7;
        char r4 = r8.charAt(r9 + 1);
    L9:
        if (r0 < 3) goto L11;
        char r6 = r8.charAt(r9 + 2);
    L13:
        if (r0 < 4) goto L15;
        r2 = r8.charAt(r9 + 3);
    L15:
        int r10 = (((r1 << 18) + (r4 << '\f')) + (r6 << 6)) + r2;
        char r11 = (char) ((r10 >> 16) & 255);
        char r3 = (char) ((r10 >> 8) & 255);
        char r12 = (char) (r10 & 255);
        StringBuilder r5 = new StringBuilder(3);
        r5.append(r11);
        if (r0 < 2) goto L18;
        r5.append(r3);
    L18:
        if (r0 < 3) goto L21;
        r5.append(r12);
    L21:
        return r5.toString();
    L11:
        r6 = 0;
        goto L13
    L7:
        r4 = 0;
        goto L9
    L23:
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
