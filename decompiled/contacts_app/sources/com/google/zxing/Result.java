package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Result {
    private final BarcodeFormat format;
    private final int numBits;
    private final byte[] rawBytes;
    private Map<ResultMetadataType, Object> resultMetadata;
    private ResultPoint[] resultPoints;
    private final String text;
    private final long timestamp;

    public Result(String r8, byte[] r9, ResultPoint[] r10, BarcodeFormat r11) {
        this(r8, r9, r10, r11, System.currentTimeMillis());
    }

    public Result(String r10, byte[] r11, ResultPoint[] r12, BarcodeFormat r13, long r14) {
        if (r11 != null) goto L4;
        int r0 = 0;
    L5:
        this(r10, r11, r0, r12, r13, r14);
        return;
    L4:
        r0 = r11.length * 8;
        goto L5
    }

    public Result(String r1, byte[] r2, int r3, ResultPoint[] r4, BarcodeFormat r5, long r6) {
        this.text = r1;
        this.rawBytes = r2;
        this.numBits = r3;
        this.resultPoints = r4;
        this.format = r5;
        this.resultMetadata = null;
        this.timestamp = r6;
    }

    public String getText() {
        return this.text;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.format;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.resultMetadata;
    }

    public void putMetadata(ResultMetadataType r3, Object r4) {
        if (this.resultMetadata != null) goto L5;
        this.resultMetadata = new EnumMap(ResultMetadataType.class);
    L5:
        this.resultMetadata.put(r3, r4);
    }

    public void putAllMetadata(Map<ResultMetadataType, Object> r2) {
        if (r2 == null) goto L9;
        Map<ResultMetadataType, Object> r0 = this.resultMetadata;
        if (r0 != null) goto L7;
        this.resultMetadata = r2;
        return;
    L7:
        r0.putAll(r2);
        return;
    }

    public void addResultPoints(ResultPoint[] r5) {
        ResultPoint[] r0 = this.resultPoints;
        if (r0 != null) goto L6;
        this.resultPoints = r5;
        return;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.length <= 0) goto L12;
        ResultPoint[] r1 = new ResultPoint[r0.length + r5.length];
        System.arraycopy(r0, 0, r1, 0, r0.length);
        System.arraycopy(r5, 0, r1, r0.length, r5.length);
        this.resultPoints = r1;
        return;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return this.text;
    }
}
