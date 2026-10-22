package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum OnSwipe$Side extends Enum<OnSwipe$Side> {
    private static final /* synthetic */ OnSwipe$Side[] $VALUES = null;
    public static final OnSwipe$Side BOTTOM = null;
    public static final OnSwipe$Side END = null;
    public static final OnSwipe$Side LEFT = null;
    public static final OnSwipe$Side MIDDLE = null;
    public static final OnSwipe$Side RIGHT = null;
    public static final OnSwipe$Side START = null;
    public static final OnSwipe$Side TOP = null;

    static {
        OnSwipe$Side r10 = new OnSwipe$Side("TOP", 0);
        TOP = r10;
        OnSwipe$Side r11 = new OnSwipe$Side("LEFT", 1);
        LEFT = r11;
        OnSwipe$Side r12 = new OnSwipe$Side("RIGHT", 2);
        RIGHT = r12;
        OnSwipe$Side r13 = new OnSwipe$Side("BOTTOM", 3);
        BOTTOM = r13;
        OnSwipe$Side r14 = new OnSwipe$Side("MIDDLE", 4);
        MIDDLE = r14;
        OnSwipe$Side r15 = new OnSwipe$Side("START", 5);
        START = r15;
        OnSwipe$Side r16 = new OnSwipe$Side("END", 6);
        END = r16;
        $VALUES = new OnSwipe$Side[]{r10, r11, r12, r13, r14, r15, r16};
    }

    private OnSwipe$Side(String r10, int r11) {
        super(r10, r11);
    }

    public static OnSwipe$Side valueOf(String r10) {
        return (OnSwipe$Side) Enum.valueOf(OnSwipe$Side.class, r10);
    }

    public static OnSwipe$Side[] values() {
        return (OnSwipe$Side[]) $VALUES.clone();
    }
}
