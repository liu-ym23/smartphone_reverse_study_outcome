package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes3.dex */
final class ASCIIEncoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 0;
    }

    ASCIIEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext r7) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(r7.getMessage(), r7.pos) < 2) goto L6;
        r7.writeCodeword(encodeASCIIDigits(r7.getMessage().charAt(r7.pos), r7.getMessage().charAt(r7.pos + 1)));
        r7.pos += 2;
        return;
    L6:
        char r0 = r7.getCurrentChar();
        int r3 = HighLevelEncoder.lookAheadTest(r7.getMessage(), r7.pos, getEncodingMode());
        if (r3 == getEncodingMode()) goto L29;
        if (r3 == 1) goto L26;
        if (r3 != 2) goto L11;
        r7.writeCodeword(239);
        r7.signalEncoderChange(2);
        return;
    L11:
        if (r3 != 3) goto L13;
        r7.writeCodeword(238);
        r7.signalEncoderChange(3);
        return;
    L13:
        if (r3 != 4) goto L15;
        r7.writeCodeword(240);
        r7.signalEncoderChange(4);
        return;
    L15:
        if (r3 != 5) goto L19;
        r7.writeCodeword(231);
        r7.signalEncoderChange(5);
        return;
    L19:
        throw new IllegalStateException("Illegal mode: " + r3);
    L26:
        r7.writeCodeword(230);
        r7.signalEncoderChange(1);
        return;
    L29:
        if (HighLevelEncoder.isExtendedASCII(r0) == false) goto L32;
        r7.writeCodeword(235);
        r7.writeCodeword((char) ((r0 - 128) + 1));
        r7.pos++;
        return;
    L32:
        r7.writeCodeword((char) (r0 + 1));
        r7.pos++;
    }

    private static char encodeASCIIDigits(char r3, char r4) {
        if (HighLevelEncoder.isDigit(r3) == false) goto L9;
        if (HighLevelEncoder.isDigit(r4) == false) goto L9;
        return (char) ((((r3 - '0') * 10) + (r4 - '0')) + 130);
    L9:
        throw new IllegalArgumentException("not digits: " + r3 + r4);
    }
}
