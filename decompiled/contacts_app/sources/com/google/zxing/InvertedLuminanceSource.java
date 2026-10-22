package com.google.zxing;

/* JADX INFO: loaded from: classes.dex */
public final class InvertedLuminanceSource extends LuminanceSource {
    private final LuminanceSource delegate;

    public InvertedLuminanceSource(LuminanceSource r3) {
        super(r3.getWidth(), r3.getHeight());
        this.delegate = r3;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int r2, byte[] r3) {
        byte[] r4 = this.delegate.getRow(r2, r3);
        int r1 = getWidth();
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L5;
        r4[r5] = (byte) (255 - (r4[r5] & 255));
        r5 = r5 + 1;
        goto L3
    L5:
        return r4;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        byte[] r0 = this.delegate.getMatrix();
        int r1 = getWidth() * getHeight();
        byte[] r4 = new byte[r1];
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r4[r2] = (byte) (255 - (r0[r2] & 255));
        r2 = r2 + 1;
        goto L3
    L5:
        return r4;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int r2, int r3, int r4, int r5) {
        return new InvertedLuminanceSource(this.delegate.crop(r2, r3, r4, r5));
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource invert() {
        return this.delegate;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}
