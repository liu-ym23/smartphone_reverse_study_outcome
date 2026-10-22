package androidx.core.graphics;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final enum BlendModeCompat extends Enum<BlendModeCompat> {
    private static final /* synthetic */ BlendModeCompat[] $VALUES = null;
    public static final BlendModeCompat CLEAR = null;

    @RequiresApi(29)
    public static final BlendModeCompat COLOR = null;

    @RequiresApi(29)
    public static final BlendModeCompat COLOR_BURN = null;

    @RequiresApi(29)
    public static final BlendModeCompat COLOR_DODGE = null;
    public static final BlendModeCompat DARKEN = null;

    @RequiresApi(29)
    public static final BlendModeCompat DIFFERENCE = null;
    public static final BlendModeCompat DST = null;
    public static final BlendModeCompat DST_ATOP = null;
    public static final BlendModeCompat DST_IN = null;
    public static final BlendModeCompat DST_OUT = null;
    public static final BlendModeCompat DST_OVER = null;

    @RequiresApi(29)
    public static final BlendModeCompat EXCLUSION = null;

    @RequiresApi(29)
    public static final BlendModeCompat HARD_LIGHT = null;

    @RequiresApi(29)
    public static final BlendModeCompat HUE = null;
    public static final BlendModeCompat LIGHTEN = null;

    @RequiresApi(29)
    public static final BlendModeCompat LUMINOSITY = null;
    public static final BlendModeCompat MODULATE = null;

    @RequiresApi(29)
    public static final BlendModeCompat MULTIPLY = null;
    public static final BlendModeCompat OVERLAY = null;
    public static final BlendModeCompat PLUS = null;

    @RequiresApi(29)
    public static final BlendModeCompat SATURATION = null;
    public static final BlendModeCompat SCREEN = null;

    @RequiresApi(29)
    public static final BlendModeCompat SOFT_LIGHT = null;
    public static final BlendModeCompat SRC = null;
    public static final BlendModeCompat SRC_ATOP = null;
    public static final BlendModeCompat SRC_IN = null;
    public static final BlendModeCompat SRC_OUT = null;
    public static final BlendModeCompat SRC_OVER = null;
    public static final BlendModeCompat XOR = null;

    static {
        BlendModeCompat r10 = new BlendModeCompat("CLEAR", 0);
        CLEAR = r10;
        BlendModeCompat r11 = new BlendModeCompat("SRC", 1);
        SRC = r11;
        BlendModeCompat r12 = new BlendModeCompat("DST", 2);
        DST = r12;
        BlendModeCompat r13 = new BlendModeCompat("SRC_OVER", 3);
        SRC_OVER = r13;
        BlendModeCompat r14 = new BlendModeCompat("DST_OVER", 4);
        DST_OVER = r14;
        BlendModeCompat r15 = new BlendModeCompat("SRC_IN", 5);
        SRC_IN = r15;
        BlendModeCompat r16 = new BlendModeCompat("DST_IN", 6);
        DST_IN = r16;
        BlendModeCompat r17 = new BlendModeCompat("SRC_OUT", 7);
        SRC_OUT = r17;
        BlendModeCompat r18 = new BlendModeCompat("DST_OUT", 8);
        DST_OUT = r18;
        BlendModeCompat r19 = new BlendModeCompat("SRC_ATOP", 9);
        SRC_ATOP = r19;
        BlendModeCompat r110 = new BlendModeCompat("DST_ATOP", 10);
        DST_ATOP = r110;
        BlendModeCompat r111 = new BlendModeCompat("XOR", 11);
        XOR = r111;
        BlendModeCompat r112 = new BlendModeCompat("PLUS", 12);
        PLUS = r112;
        BlendModeCompat r113 = new BlendModeCompat("MODULATE", 13);
        MODULATE = r113;
        BlendModeCompat r20 = new BlendModeCompat("SCREEN", 14);
        SCREEN = r20;
        BlendModeCompat r21 = new BlendModeCompat("OVERLAY", 15);
        OVERLAY = r21;
        BlendModeCompat r22 = new BlendModeCompat("DARKEN", 16);
        DARKEN = r22;
        BlendModeCompat r23 = new BlendModeCompat("LIGHTEN", 17);
        LIGHTEN = r23;
        BlendModeCompat r24 = new BlendModeCompat("COLOR_DODGE", 18);
        COLOR_DODGE = r24;
        BlendModeCompat r25 = new BlendModeCompat("COLOR_BURN", 19);
        COLOR_BURN = r25;
        BlendModeCompat r26 = new BlendModeCompat("HARD_LIGHT", 20);
        HARD_LIGHT = r26;
        BlendModeCompat r27 = new BlendModeCompat("SOFT_LIGHT", 21);
        SOFT_LIGHT = r27;
        BlendModeCompat r28 = new BlendModeCompat("DIFFERENCE", 22);
        DIFFERENCE = r28;
        BlendModeCompat r29 = new BlendModeCompat("EXCLUSION", 23);
        EXCLUSION = r29;
        BlendModeCompat r30 = new BlendModeCompat("MULTIPLY", 24);
        MULTIPLY = r30;
        BlendModeCompat r31 = new BlendModeCompat("HUE", 25);
        HUE = r31;
        BlendModeCompat r32 = new BlendModeCompat("SATURATION", 26);
        SATURATION = r32;
        BlendModeCompat r33 = new BlendModeCompat("COLOR", 27);
        COLOR = r33;
        BlendModeCompat r34 = new BlendModeCompat("LUMINOSITY", 28);
        LUMINOSITY = r34;
        $VALUES = new BlendModeCompat[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34};
    }

    private BlendModeCompat(String r10, int r11) {
        super(r10, r11);
    }

    public static BlendModeCompat valueOf(String r10) {
        return (BlendModeCompat) Enum.valueOf(BlendModeCompat.class, r10);
    }

    public static BlendModeCompat[] values() {
        return (BlendModeCompat[]) $VALUES.clone();
    }
}
