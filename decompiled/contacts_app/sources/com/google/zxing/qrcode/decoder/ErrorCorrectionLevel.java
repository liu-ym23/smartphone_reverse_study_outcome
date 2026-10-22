package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes3.dex */
public final enum ErrorCorrectionLevel extends Enum<ErrorCorrectionLevel> {
    private static final /* synthetic */ ErrorCorrectionLevel[] $VALUES = null;
    private static final ErrorCorrectionLevel[] FOR_BITS = null;
    public static final ErrorCorrectionLevel H = null;
    public static final ErrorCorrectionLevel L = null;
    public static final ErrorCorrectionLevel M = null;
    public static final ErrorCorrectionLevel Q = null;
    private final int bits;

    public static ErrorCorrectionLevel valueOf(String r1) {
        return (ErrorCorrectionLevel) Enum.valueOf(ErrorCorrectionLevel.class, r1);
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) $VALUES.clone();
    }

    static {
        ErrorCorrectionLevel r0 = new ErrorCorrectionLevel("L", 0, 1);
        L = r0;
        ErrorCorrectionLevel r1 = new ErrorCorrectionLevel("M", 1, 0);
        M = r1;
        ErrorCorrectionLevel r4 = new ErrorCorrectionLevel("Q", 2, 3);
        Q = r4;
        ErrorCorrectionLevel r5 = new ErrorCorrectionLevel("H", 3, 2);
        H = r5;
        $VALUES = new ErrorCorrectionLevel[]{r0, r1, r4, r5};
        FOR_BITS = new ErrorCorrectionLevel[]{r1, r0, r5, r4};
    }

    private ErrorCorrectionLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.bits = r3;
    }

    public int getBits() {
        return this.bits;
    }

    public static ErrorCorrectionLevel forBits(int r2) {
        if (r2 < 0) goto L8;
        ErrorCorrectionLevel[] r0 = FOR_BITS;
        if (r2 >= r0.length) goto L8;
        return r0[r2];
    L8:
        throw new IllegalArgumentException();
    }
}
