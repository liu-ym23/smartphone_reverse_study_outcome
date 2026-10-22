package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
final class State {
    static final State INITIAL_STATE = null;
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    static {
        INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    }

    private State(Token r1, int r2, int r3, int r4) {
        this.token = r1;
        this.mode = r2;
        this.binaryShiftByteCount = r3;
        this.bitCount = r4;
    }

    int getMode() {
        return this.mode;
    }

    Token getToken() {
        return this.token;
    }

    int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    int getBitCount() {
        return this.bitCount;
    }

    State latchAndAppend(int r4, int r5) {
        int r0 = this.bitCount;
        Token r1 = this.token;
        if (r4 == this.mode) goto L6;
        int r3 = HighLevelEncoder.LATCH_TABLE[this.mode][r4];
        int r2 = 65535 & r3;
        int r6 = r3 >> 16;
        r1 = r1.add(r2, r6);
        r0 = r0 + r6;
    L6:
        if (r4 != 2) goto L8;
        int r7 = 4;
    L10:
        return new State(r1.add(r5, r7), r4, 0, r0 + r7);
    L8:
        r7 = 5;
        goto L10
    }

    State shiftAndAppend(int r6, int r7) {
        Token r0 = this.token;
        if (this.mode != 2) goto L5;
        int r1 = 4;
    L7:
        return new State(r0.add(HighLevelEncoder.SHIFT_TABLE[this.mode][r6], r1).add(r7, 5), this.mode, 0, (this.bitCount + r1) + 5);
    L5:
        r1 = 5;
        goto L7
    }

    State addBinaryShiftChar(int r6) {
        Token r0 = this.token;
        int r1 = this.mode;
        int r2 = this.bitCount;
        if (r1 != 4) goto L5;
    L6:
        int r3 = HighLevelEncoder.LATCH_TABLE[r1][0];
        int r4 = 65535 & r3;
        int r5 = r3 >> 16;
        r0 = r0.add(r4, r5);
        r2 = r2 + r5;
        r1 = 0;
    L7:
        int r7 = this.binaryShiftByteCount;
        if (r7 != 0) goto L10;
    L16:
        int r8 = 18;
    L17:
        State r9 = new State(r0, r1, r7 + 1, r2 + r8);
        if (r9.binaryShiftByteCount == 2078) goto L20;
        return r9;
    L20:
        return r9.endBinaryShift(r6 + 1);
    L10:
        if (r7 == 31) goto L16;
        if (r7 != 62) goto L15;
        r8 = 9;
        goto L17
    L15:
        r8 = 8;
        goto L17
    L5:
        if (r1 != 2) goto L7;
        goto L6
    }

    State endBinaryShift(int r4) {
        int r0 = this.binaryShiftByteCount;
        if (r0 != 0) goto L6;
        return this;
    L6:
        return new State(this.token.addBinaryShift(r4 - r0, r0), this.mode, 0, this.bitCount);
    }

    boolean isBetterThanOrEqualTo(State r4) {
        int r0 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][r4.mode] >> 16);
        int r1 = r4.binaryShiftByteCount;
        if (r1 <= 0) goto L9;
        int r3 = this.binaryShiftByteCount;
        if (r3 == 0) goto L7;
        if (r3 <= r1) goto L9;
    L7:
        r0 = r0 + 10;
    L9:
        if (r0 > r4.bitCount) goto L12;
        return true;
    L12:
        return false;
    }

    BitArray toBitArray(byte[] r3) {
        LinkedList r0 = new LinkedList();
        Token r2 = endBinaryShift(r3.length).token;
    L3:
        if (r2 == null) goto L5;
        r0.addFirst(r2);
        r2 = r2.getPrevious();
        goto L3
    L5:
        BitArray r4 = new BitArray();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Token) r1.next()).appendTo(r4, r3);
        goto L7
    L9:
        return r4;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)});
    }
}
