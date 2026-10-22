package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes3.dex */
abstract enum DataMask extends Enum<DataMask> {
    private static final /* synthetic */ DataMask[] $VALUES = null;
    public static final DataMask DATA_MASK_000 = null;
    public static final DataMask DATA_MASK_001 = null;
    public static final DataMask DATA_MASK_010 = null;
    public static final DataMask DATA_MASK_011 = null;
    public static final DataMask DATA_MASK_100 = null;
    public static final DataMask DATA_MASK_101 = null;
    public static final DataMask DATA_MASK_110 = null;
    public static final DataMask DATA_MASK_111 = null;

    abstract boolean isMasked(int r1, int r2);

    private DataMask(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ DataMask(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static DataMask valueOf(String r1) {
        return (DataMask) Enum.valueOf(DataMask.class, r1);
    }

    public static DataMask[] values() {
        return (DataMask[]) $VALUES.clone();
    }

    static {
        final String r1 = "DATA_MASK_000";
        final int r2 = 0;
        DataMask r0 = new AnonymousClass1(r1, r2);
        DATA_MASK_000 = r0;
        final String r3 = "DATA_MASK_001";
        final int r4 = 1;
        DataMask r5 = new AnonymousClass2(r3, r4);
        DATA_MASK_001 = r5;
        final String r6 = "DATA_MASK_010";
        final int r7 = 2;
        DataMask r8 = new AnonymousClass3(r6, r7);
        DATA_MASK_010 = r8;
        final String r9 = "DATA_MASK_011";
        final int r10 = 3;
        DataMask r11 = new AnonymousClass4(r9, r10);
        DATA_MASK_011 = r11;
        final String r12 = "DATA_MASK_100";
        final int r13 = 4;
        DataMask r14 = new AnonymousClass5(r12, r13);
        DATA_MASK_100 = r14;
        final String r15 = "DATA_MASK_101";
        final int r16 = 5;
        DataMask r17 = new AnonymousClass6(r15, r16);
        DATA_MASK_101 = r17;
        final String r18 = "DATA_MASK_110";
        final int r19 = 6;
        DataMask r110 = new AnonymousClass7(r18, r19);
        DATA_MASK_110 = r110;
        final String r111 = "DATA_MASK_111";
        final int r112 = 7;
        DataMask r113 = new AnonymousClass8(r111, r112);
        DATA_MASK_111 = r113;
        $VALUES = new DataMask[]{r0, r5, r8, r11, r14, r17, r110, r113};
    }

    final void unmaskBitMatrix(BitMatrix r5, int r6) {
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L11;
        int r2 = 0;
    L5:
        if (r2 >= r6) goto L10;
        if (isMasked(r1, r2) == false) goto L9;
        r5.flip(r2, r1);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        r1 = r1 + 1;
        goto L3
    }
}
