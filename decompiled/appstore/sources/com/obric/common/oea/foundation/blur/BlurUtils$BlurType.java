package com.obric.common.oea.foundation.blur;

/* JADX INFO: loaded from: classes3.dex */
public final enum BlurUtils$BlurType extends Enum<BlurUtils$BlurType> {
    private static final /* synthetic */ BlurUtils$BlurType[] $VALUES = null;
    public static final BlurUtils$BlurType NONE = null;
    public static final BlurUtils$BlurType NORMAL_BLUR = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_DOWN_UP = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_LEFT_RIGHT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_RIGHT_LEFT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_UP_DOWN = null;

    static {
        BlurUtils$BlurType r10 = new BlurUtils$BlurType("NONE", 0);
        NONE = r10;
        BlurUtils$BlurType r11 = new BlurUtils$BlurType("NORMAL_BLUR", 1);
        NORMAL_BLUR = r11;
        BlurUtils$BlurType r12 = new BlurUtils$BlurType("PROGRESS_BLUR_DOWN_UP", 2);
        PROGRESS_BLUR_DOWN_UP = r12;
        BlurUtils$BlurType r13 = new BlurUtils$BlurType("PROGRESS_BLUR_UP_DOWN", 3);
        PROGRESS_BLUR_UP_DOWN = r13;
        BlurUtils$BlurType r14 = new BlurUtils$BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4);
        PROGRESS_BLUR_LEFT_RIGHT = r14;
        BlurUtils$BlurType r15 = new BlurUtils$BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5);
        PROGRESS_BLUR_RIGHT_LEFT = r15;
        $VALUES = new BlurUtils$BlurType[]{r10, r11, r12, r13, r14, r15};
    }

    private BlurUtils$BlurType(String r10, int r11) {
        super(r10, r11);
    }

    public static BlurUtils$BlurType valueOf(String r10) {
        return (BlurUtils$BlurType) Enum.valueOf(BlurUtils$BlurType.class, r10);
    }

    public static BlurUtils$BlurType[] values() {
        return (BlurUtils$BlurType[]) $VALUES.clone();
    }
}
