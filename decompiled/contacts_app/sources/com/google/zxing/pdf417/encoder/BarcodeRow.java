package com.google.zxing.pdf417.encoder;

/* JADX INFO: loaded from: classes3.dex */
final class BarcodeRow {
    private int currentLocation;
    private final byte[] row;

    BarcodeRow(int r1) {
        this.row = new byte[r1];
        this.currentLocation = 0;
    }

    void set(int r1, byte r2) {
        this.row[r1] = r2;
    }

    private void set(int r1, boolean r2) {
        this.row[r1] = r2 ? 1 : 0;
    }

    void addBar(boolean r4, int r5) {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        int r1 = this.currentLocation;
        this.currentLocation = r1 + 1;
        set(r1, r4);
        r0 = r0 + 1;
        goto L3
    }

    byte[] getScaledRow(int r6) {
        int r0 = this.row.length * r6;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.row[r2 / r6];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
