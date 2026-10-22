package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes3.dex */
final class X12Encoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 3;
    }

    X12Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext r5) {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (r5.hasMoreCharacters() == false) goto L10;
        char r1 = r5.getCurrentChar();
        r5.pos++;
        encodeChar(r1, r0);
        if ((r0.length() % 3) != 0) goto L4;
        writeNextTriplet(r5, r0);
        int r2 = HighLevelEncoder.lookAheadTest(r5.getMessage(), r5.pos, getEncodingMode());
        if (r2 == getEncodingMode()) goto L4;
        r5.signalEncoderChange(r2);
    L10:
        handleEOD(r5, r0);
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int encodeChar(char r3, StringBuilder r4) {
        if (r3 != '\r') goto L6;
        r4.append(0);
    L25:
        return 1;
    L6:
        if (r3 != '*') goto L9;
        r4.append(1);
        goto L25
    L9:
        if (r3 != '>') goto L12;
        r4.append(2);
        goto L25
    L12:
        if (r3 != ' ') goto L15;
        r4.append(3);
        goto L25
    L15:
        if (r3 < '0') goto L20;
        if (r3 > '9') goto L20;
        r4.append((char) ((r3 - '0') + 4));
    L20:
        if (r3 >= 'A') goto L22;
    L24:
        HighLevelEncoder.illegalCharacter(r3);
        goto L25
    L22:
        if (r3 > 'Z') goto L24;
        r4.append((char) ((r3 - 'A') + 14));
        goto L25
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    void handleEOD(EncoderContext r2, StringBuilder r3) {
        r2.updateSymbolInfo();
        int r1 = r2.getSymbolInfo().getDataCapacity() - r2.getCodewordCount();
        r2.pos -= r3.length();
        if (r2.getRemainingCharacters() > 1) goto L7;
        if (r1 > 1) goto L7;
        if (r2.getRemainingCharacters() != r1) goto L7;
    L9:
        if (r2.getNewEncoding() >= 0) goto L12;
        r2.signalEncoderChange(0);
        return;
    L12:
        return;
    L7:
        r2.writeCodeword(254);
        goto L9
    }
}
