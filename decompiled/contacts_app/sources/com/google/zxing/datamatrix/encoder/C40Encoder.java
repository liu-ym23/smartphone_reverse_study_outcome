package com.google.zxing.datamatrix.encoder;

import com.android.contacts.common.list.DefaultContactListAdapter;

/* JADX INFO: loaded from: classes3.dex */
class C40Encoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 1;
    }

    C40Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext r9) {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (r9.hasMoreCharacters() == false) goto L23;
        char r1 = r9.getCurrentChar();
        r9.pos++;
        int r2 = encodeChar(r1, r0);
        int r5 = r9.getCodewordCount() + ((r0.length() / 3) << 1);
        r9.updateSymbolInfo(r5);
        int r3 = r9.getSymbolInfo().getDataCapacity() - r5;
        if (r9.hasMoreCharacters() == false) goto L7;
        if ((r0.length() % 3) != 0) goto L4;
        int r4 = HighLevelEncoder.lookAheadTest(r9.getMessage(), r9.pos, getEncodingMode());
        if (r4 == getEncodingMode()) goto L4;
        r9.signalEncoderChange(r4);
        goto L23
    L7:
        StringBuilder r6 = new StringBuilder();
        if ((r0.length() % 3) != 2) goto L13;
        if (r3 < 2) goto L11;
        if (r3 <= 2) goto L13;
    L11:
        r2 = backtrackOneCharacter(r9, r0, r6, r2);
    L13:
        if ((r0.length() % 3) != 1) goto L23;
        if (r2 > 3) goto L16;
        if (r3 == 1) goto L16;
    L17:
        r2 = backtrackOneCharacter(r9, r0, r6, r2);
    L16:
        if (r2 > 3) goto L17;
    L23:
        handleEOD(r9, r0);
    }

    private int backtrackOneCharacter(EncoderContext r2, StringBuilder r3, StringBuilder r4, int r5) {
        int r0 = r3.length();
        r3.delete(r0 - r5, r0);
        r2.pos--;
        int r1 = encodeChar(r2.getCurrentChar(), r4);
        r2.resetSymbolInfo();
        return r1;
    }

    static void writeNextTriplet(EncoderContext r2, StringBuilder r3) {
        r2.writeCodewords(encodeToCodewords(r3, 0));
        r3.delete(0, 3);
    }

    void handleEOD(EncoderContext r7, StringBuilder r8) {
        int r6 = (r8.length() / 3) << 1;
        int r2 = r8.length() % 3;
        int r3 = r7.getCodewordCount() + r6;
        r7.updateSymbolInfo(r3);
        int r9 = r7.getSymbolInfo().getDataCapacity() - r3;
        if (r2 != 2) goto L11;
        r8.append(0);
    L6:
        if (r8.length() < 3) goto L9;
        writeNextTriplet(r7, r8);
        goto L6
    L9:
        if (r7.hasMoreCharacters() == false) goto L28;
        r7.writeCodeword(254);
    L28:
        r7.signalEncoderChange(0);
        return;
    L11:
        if (r9 != 1) goto L20;
        if (r2 != 1) goto L20;
    L14:
        if (r8.length() < 3) goto L17;
        writeNextTriplet(r7, r8);
        goto L14
    L17:
        if (r7.hasMoreCharacters() == false) goto L19;
        r7.writeCodeword(254);
    L19:
        r7.pos--;
    L20:
        if (r2 != 0) goto L31;
    L22:
        if (r8.length() < 3) goto L24;
        writeNextTriplet(r7, r8);
        goto L22
    L24:
        if (r9 <= 0) goto L26;
    L27:
        r7.writeCodeword(254);
        goto L28
    L26:
        if (r7.hasMoreCharacters() == false) goto L28;
    L31:
        throw new IllegalStateException("Unexpected case. Please report!");
    }

    int encodeChar(char r5, StringBuilder r6) {
        if (r5 != ' ') goto L7;
        r6.append(3);
        return 1;
    L7:
        if (r5 < '0') goto L13;
        if (r5 > '9') goto L13;
        r6.append((char) ((r5 - '0') + 4));
        return 1;
    L13:
        if (r5 < 'A') goto L19;
        if (r5 > 'Z') goto L19;
        r6.append((char) ((r5 - 'A') + 14));
        return 1;
    L19:
        if (r5 < 0) goto L25;
        if (r5 > 31) goto L25;
        r6.append(0);
        r6.append(r5);
        return 2;
    L25:
        if (r5 < '!') goto L31;
        if (r5 > '/') goto L31;
        r6.append(1);
        r6.append((char) (r5 - '!'));
        return 2;
    L31:
        if (r5 < ':') goto L37;
        if (r5 > '@') goto L37;
        r6.append(1);
        r6.append((char) ((r5 - ':') + 15));
        return 2;
    L37:
        if (r5 < '[') goto L43;
        if (r5 > '_') goto L43;
        r6.append(1);
        r6.append((char) ((r5 - DefaultContactListAdapter.SNIPPET_START_MATCH) + 22));
        return 2;
    L43:
        if (r5 < '`') goto L49;
        if (r5 > 127) goto L49;
        r6.append(2);
        r6.append((char) (r5 - '`'));
        return 2;
    L49:
        if (r5 < 128) goto L53;
        r6.append("\u0001\u001e");
        return encodeChar((char) (r5 - 128), r6) + 2;
    L53:
        throw new IllegalArgumentException("Illegal character: " + r5);
    }

    private static String encodeToCodewords(CharSequence r4, int r5) {
        int r0 = (((r4.charAt(r5) * 1600) + (r4.charAt(r5 + 1) * '(')) + r4.charAt(r5 + 2)) + 1;
        return new String(new char[]{(char) (r0 / 256), (char) (r0 % 256)});
    }
}
