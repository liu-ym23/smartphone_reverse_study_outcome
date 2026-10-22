package com.bytedanceos.common.toolbox;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum SizeConverter extends Enum<SizeConverter> {
    private static final /* synthetic */ SizeConverter[] $VALUES = null;
    public static final SizeConverter Arbitrary = null;
    public static final SizeConverter ArbitraryTrim = null;
    public static final SizeConverter B = null;
    public static final SizeConverter BTrim = null;
    private static final String FORMAT_D = "%1$-1d";
    private static final String FORMAT_D_UNIT = "%1$-1d%2$s";
    private static final String FORMAT_F = "%1$-1.1f";
    private static final String FORMAT_F_UNIT = "%1$-1.1f%2$s";
    public static final SizeConverter GB = null;
    public static final SizeConverter GBTrim = null;
    public static final SizeConverter KB = null;
    public static final SizeConverter KBTrim = null;
    private static final int LAST_IDX = 0;
    public static final SizeConverter MB = null;
    public static final SizeConverter MBTrim = null;
    public static final SizeConverter TB = null;
    public static final SizeConverter TBTrim = null;
    private static final String[] UNITS = null;
    private static int UNIT_SIZE;

    private static /* synthetic */ SizeConverter[] $values() {
        return new SizeConverter[]{Arbitrary, B, KB, MB, GB, TB, ArbitraryTrim, BTrim, KBTrim, MBTrim, GBTrim, TBTrim};
    }

    static {
        final String r10 = "Arbitrary";
        final int r11 = 0;
        Arbitrary = new AnonymousClass1(r10, r11);
        final String r12 = "B";
        final int r13 = 1;
        B = new AnonymousClass2(r12, r13);
        final String r14 = "KB";
        final int r15 = 2;
        KB = new AnonymousClass3(r14, r15);
        final String r16 = "MB";
        final int r17 = 3;
        MB = new AnonymousClass4(r16, r17);
        final String r18 = "GB";
        final int r19 = 4;
        GB = new AnonymousClass5(r18, r19);
        final String r20 = "TB";
        final int r21 = 5;
        TB = new AnonymousClass6(r20, r21);
        final String r22 = "ArbitraryTrim";
        final int r23 = 6;
        ArbitraryTrim = new AnonymousClass7(r22, r23);
        final String r24 = "BTrim";
        final int r25 = 7;
        BTrim = new AnonymousClass8(r24, r25);
        final String r26 = "KBTrim";
        final int r27 = 8;
        KBTrim = new AnonymousClass9(r26, r27);
        final String r28 = "MBTrim";
        final int r29 = 9;
        MBTrim = new AnonymousClass10(r28, r29);
        final String r30 = "GBTrim";
        final int r31 = 10;
        GBTrim = new AnonymousClass11(r30, r31);
        final String r32 = "TBTrim";
        final int r33 = 11;
        TBTrim = new AnonymousClass12(r32, r33);
        $VALUES = $values();
        UNIT_SIZE = 1000;
        String[] r34 = {"B", "KB", "MB", "GB", "TB", "PB", "**"};
        UNITS = r34;
        LAST_IDX = r34.length - 1;
    }

    private SizeConverter(String r10, int r11) {
        super(r10, r11);
    }

    public static /* synthetic */ int access$100() {
        return UNIT_SIZE;
    }

    public static /* synthetic */ String access$200(int r10, float r11) {
        return converter(r10, r11);
    }

    public static /* synthetic */ String access$300(int r10, float r11) {
        return trimConverter(r10, r11);
    }

    private static String convert(int r10, float r11, boolean r12) {
    L2:
        int r13 = UNIT_SIZE;
        if (r11 <= r13) goto L5;
        r10 = r10 + 1;
        r11 = r11 / r13;
        goto L2
    L5:
        if (r12 == false) goto L13;
        int r14 = LAST_IDX;
        if (r10 < r14) goto L11;
        r10 = r14;
    L11:
        return String.format(FORMAT_F_UNIT, new Object[]{Float.valueOf(r11), UNITS[r10]});
    L13:
        return String.format(FORMAT_F, new Object[]{Float.valueOf(r11)});
    }

    public static String convertBytes(float r10, boolean r11) {
        if (r11 == false) goto L6;
        return trimConvert(0, r10, true);
    L6:
        return convert(0, r10, true);
    }

    public static String convertKB(float r10, boolean r11) {
        if (r11 == false) goto L6;
        return trimConvert(1, r10, true);
    L6:
        return convert(1, r10, true);
    }

    public static String convertMB(float r10, boolean r11) {
        if (r11 == false) goto L6;
        return trimConvert(2, r10, true);
    L6:
        return convert(2, r10, true);
    }

    private static String converter(int r10, float r11) {
    L2:
        int r12 = UNIT_SIZE;
        if (r11 <= r12) goto L5;
        r10 = r10 + 1;
        r11 = r11 / r12;
        goto L2
    L5:
        int r13 = LAST_IDX;
        if (r10 < r13) goto L10;
        r10 = r13;
    L10:
        return String.format(FORMAT_F_UNIT, new Object[]{Float.valueOf(r11), UNITS[r10]});
    }

    private static String trimConvert(int r10, float r11, boolean r12) {
    L2:
        int r13 = UNIT_SIZE;
        if (r11 <= r13) goto L5;
        r10 = r10 + 1;
        r11 = r11 / r13;
        goto L2
    L5:
        int r14 = (int) r11;
        if ((r11 - r14) <= 0.0f) goto L8;
        boolean r15 = true;
    L9:
        if (r12 == false) goto L19;
        int r16 = LAST_IDX;
        if (r10 < r16) goto L14;
        r10 = r16;
    L14:
        if (r15 == false) goto L18;
        return String.format(FORMAT_F_UNIT, new Object[]{Float.valueOf(r11), UNITS[r10]});
    L18:
        return String.format(FORMAT_D_UNIT, new Object[]{Integer.valueOf(r14), UNITS[r10]});
    L19:
        if (r15 == false) goto L23;
        return String.format(FORMAT_F, new Object[]{Float.valueOf(r11)});
    L23:
        return String.format(FORMAT_D, new Object[]{Integer.valueOf(r14)});
    L8:
        r15 = false;
        goto L9
    }

    private static String trimConverter(int r10, float r11) {
    L2:
        int r12 = UNIT_SIZE;
        if (r11 <= r12) goto L5;
        r10 = r10 + 1;
        r11 = r11 / r12;
        goto L2
    L5:
        int r13 = (int) r11;
        if ((r11 - r13) <= 0.0f) goto L8;
        boolean r14 = true;
    L9:
        int r15 = LAST_IDX;
        if (r10 < r15) goto L13;
        r10 = r15;
    L13:
        if (r14 == false) goto L17;
        return String.format(FORMAT_F_UNIT, new Object[]{Float.valueOf(r11), UNITS[r10]});
    L17:
        return String.format(FORMAT_D_UNIT, new Object[]{Integer.valueOf(r13), UNITS[r10]});
    L8:
        r14 = false;
        goto L9
    }

    public static SizeConverter valueOf(String r10) {
        return (SizeConverter) Enum.valueOf(SizeConverter.class, r10);
    }

    public static SizeConverter[] values() {
        return (SizeConverter[]) $VALUES.clone();
    }

    public abstract String convert(float r10);

    public /* synthetic */ SizeConverter(String r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }
}
