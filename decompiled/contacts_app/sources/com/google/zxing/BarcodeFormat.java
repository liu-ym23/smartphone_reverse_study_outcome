package com.google.zxing;

/* JADX INFO: loaded from: classes.dex */
public final enum BarcodeFormat extends Enum<BarcodeFormat> {
    private static final /* synthetic */ BarcodeFormat[] $VALUES = null;
    public static final BarcodeFormat AZTEC = null;
    public static final BarcodeFormat CODABAR = null;
    public static final BarcodeFormat CODE_128 = null;
    public static final BarcodeFormat CODE_39 = null;
    public static final BarcodeFormat CODE_93 = null;
    public static final BarcodeFormat DATA_MATRIX = null;
    public static final BarcodeFormat EAN_13 = null;
    public static final BarcodeFormat EAN_8 = null;
    public static final BarcodeFormat ITF = null;
    public static final BarcodeFormat MAXICODE = null;
    public static final BarcodeFormat PDF_417 = null;
    public static final BarcodeFormat QR_CODE = null;
    public static final BarcodeFormat RSS_14 = null;
    public static final BarcodeFormat RSS_EXPANDED = null;
    public static final BarcodeFormat UPC_A = null;
    public static final BarcodeFormat UPC_E = null;
    public static final BarcodeFormat UPC_EAN_EXTENSION = null;

    private BarcodeFormat(String r1, int r2) {
        super(r1, r2);
    }

    public static BarcodeFormat valueOf(String r1) {
        return (BarcodeFormat) Enum.valueOf(BarcodeFormat.class, r1);
    }

    public static BarcodeFormat[] values() {
        return (BarcodeFormat[]) $VALUES.clone();
    }

    static {
        BarcodeFormat r0 = new BarcodeFormat("AZTEC", 0);
        AZTEC = r0;
        BarcodeFormat r1 = new BarcodeFormat("CODABAR", 1);
        CODABAR = r1;
        BarcodeFormat r3 = new BarcodeFormat("CODE_39", 2);
        CODE_39 = r3;
        BarcodeFormat r5 = new BarcodeFormat("CODE_93", 3);
        CODE_93 = r5;
        BarcodeFormat r7 = new BarcodeFormat("CODE_128", 4);
        CODE_128 = r7;
        BarcodeFormat r9 = new BarcodeFormat("DATA_MATRIX", 5);
        DATA_MATRIX = r9;
        BarcodeFormat r11 = new BarcodeFormat("EAN_8", 6);
        EAN_8 = r11;
        BarcodeFormat r13 = new BarcodeFormat("EAN_13", 7);
        EAN_13 = r13;
        BarcodeFormat r15 = new BarcodeFormat("ITF", 8);
        ITF = r15;
        BarcodeFormat r14 = new BarcodeFormat("MAXICODE", 9);
        MAXICODE = r14;
        BarcodeFormat r12 = new BarcodeFormat("PDF_417", 10);
        PDF_417 = r12;
        BarcodeFormat r10 = new BarcodeFormat("QR_CODE", 11);
        QR_CODE = r10;
        BarcodeFormat r8 = new BarcodeFormat("RSS_14", 12);
        RSS_14 = r8;
        BarcodeFormat r6 = new BarcodeFormat("RSS_EXPANDED", 13);
        RSS_EXPANDED = r6;
        BarcodeFormat r4 = new BarcodeFormat("UPC_A", 14);
        UPC_A = r4;
        BarcodeFormat r2 = new BarcodeFormat("UPC_E", 15);
        UPC_E = r2;
        BarcodeFormat r16 = new BarcodeFormat("UPC_EAN_EXTENSION", 16);
        UPC_EAN_EXTENSION = r16;
        $VALUES = new BarcodeFormat[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
    }
}
