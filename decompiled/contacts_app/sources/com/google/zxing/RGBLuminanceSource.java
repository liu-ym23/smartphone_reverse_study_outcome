package com.google.zxing;

/* JADX INFO: loaded from: classes.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public RGBLuminanceSource(int r5, int r6, int[] r7) {
        super(r5, r6);
        this.dataWidth = r5;
        this.dataHeight = r6;
        int r0 = 0;
        this.left = 0;
        this.top = 0;
        int r8 = r5 * r6;
        this.luminances = new byte[r8];
    L3:
        if (r0 >= r8) goto L5;
        int r9 = r7[r0];
        int r1 = (r9 >> 16) & 255;
        int r2 = (r9 >> 7) & 510;
        int r3 = r1 + r2;
        this.luminances[r0] = (byte) ((r3 + (r9 & 255)) / 4);
        r0 = r0 + 1;
        goto L3
    }

    private RGBLuminanceSource(byte[] r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        super(r6, r7);
        if ((r6 + r4) > r2) goto L9;
        if ((r7 + r5) > r3) goto L9;
        this.luminances = r1;
        this.dataWidth = r2;
        this.dataHeight = r3;
        this.left = r4;
        this.top = r5;
        return;
    L9:
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int r3, byte[] r4) {
        if (r3 < 0) goto L13;
        if (r3 >= getHeight()) goto L13;
        int r0 = getWidth();
        if (r4 != null) goto L8;
    L9:
        r4 = new byte[r0];
    L10:
        System.arraycopy(this.luminances, ((r3 + this.top) * this.dataWidth) + this.left, r4, 0, r0);
        return r4;
    L8:
        if (r4.length >= r0) goto L10;
    L13:
        throw new IllegalArgumentException("Requested row is outside the image: " + r3);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int r0 = getWidth();
        int r1 = getHeight();
        int r2 = this.dataWidth;
        if (r0 == r2) goto L5;
    L8:
        int r3 = r0 * r1;
        byte[] r4 = new byte[r3];
        int r5 = (this.top * r2) + this.left;
        int r6 = 0;
        if (r0 != r2) goto L12;
        System.arraycopy(this.luminances, r5, r4, 0, r3);
        return r4;
    L12:
        if (r6 >= r1) goto L14;
        byte[] r7 = this.luminances;
        System.arraycopy(r7, r5, r4, r6 * r0, r0);
        r5 = r5 + this.dataWidth;
        r6 = r6 + 1;
        goto L12
    L14:
        return r4;
    L5:
        if (r1 != this.dataHeight) goto L8;
        return this.luminances;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int r10, int r11, int r12, int r13) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + r10, this.top + r11, r12, r13);
    }
}
