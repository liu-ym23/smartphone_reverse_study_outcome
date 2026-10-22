package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum OnSwipe$Boundary extends Enum<OnSwipe$Boundary> {
    private static final /* synthetic */ OnSwipe$Boundary[] $VALUES = null;
    public static final OnSwipe$Boundary BOUNCE_BOTH = null;
    public static final OnSwipe$Boundary BOUNCE_END = null;
    public static final OnSwipe$Boundary BOUNCE_START = null;
    public static final OnSwipe$Boundary OVERSHOOT = null;

    static {
        OnSwipe$Boundary r10 = new OnSwipe$Boundary("OVERSHOOT", 0);
        OVERSHOOT = r10;
        OnSwipe$Boundary r11 = new OnSwipe$Boundary("BOUNCE_START", 1);
        BOUNCE_START = r11;
        OnSwipe$Boundary r12 = new OnSwipe$Boundary("BOUNCE_END", 2);
        BOUNCE_END = r12;
        OnSwipe$Boundary r13 = new OnSwipe$Boundary("BOUNCE_BOTH", 3);
        BOUNCE_BOTH = r13;
        $VALUES = new OnSwipe$Boundary[]{r10, r11, r12, r13};
    }

    private OnSwipe$Boundary(String r10, int r11) {
        super(r10, r11);
    }

    public static OnSwipe$Boundary valueOf(String r10) {
        return (OnSwipe$Boundary) Enum.valueOf(OnSwipe$Boundary.class, r10);
    }

    public static OnSwipe$Boundary[] values() {
        return (OnSwipe$Boundary[]) $VALUES.clone();
    }
}
