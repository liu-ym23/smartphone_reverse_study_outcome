package com.google.zxing.qrcode.encoder;

/* JADX INFO: loaded from: classes3.dex */
final class BlockPair {
    private final byte[] dataBytes;
    private final byte[] errorCorrectionBytes;

    BlockPair(byte[] r1, byte[] r2) {
        this.dataBytes = r1;
        this.errorCorrectionBytes = r2;
    }

    public byte[] getDataBytes() {
        return this.dataBytes;
    }

    public byte[] getErrorCorrectionBytes() {
        return this.errorCorrectionBytes;
    }
}
