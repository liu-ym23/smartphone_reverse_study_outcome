package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes.dex */
abstract class Token {
    static final Token EMPTY = null;
    private final Token previous;

    abstract void appendTo(BitArray r1, byte[] r2);

    static {
        EMPTY = new SimpleToken(null, 0, 0);
    }

    Token(Token r1) {
        this.previous = r1;
    }

    final Token getPrevious() {
        return this.previous;
    }

    final Token add(int r2, int r3) {
        return new SimpleToken(this, r2, r3);
    }

    final Token addBinaryShift(int r2, int r3) {
        return new BinaryShiftToken(this, r2, r3);
    }
}
