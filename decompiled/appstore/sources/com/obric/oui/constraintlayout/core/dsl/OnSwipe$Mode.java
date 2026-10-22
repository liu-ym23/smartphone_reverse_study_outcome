package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum OnSwipe$Mode extends Enum<OnSwipe$Mode> {
    private static final /* synthetic */ OnSwipe$Mode[] $VALUES = null;
    public static final OnSwipe$Mode SPRING = null;
    public static final OnSwipe$Mode VELOCITY = null;

    static {
        OnSwipe$Mode r10 = new OnSwipe$Mode("VELOCITY", 0);
        VELOCITY = r10;
        OnSwipe$Mode r11 = new OnSwipe$Mode("SPRING", 1);
        SPRING = r11;
        $VALUES = new OnSwipe$Mode[]{r10, r11};
    }

    private OnSwipe$Mode(String r10, int r11) {
        super(r10, r11);
    }

    public static OnSwipe$Mode valueOf(String r10) {
        return (OnSwipe$Mode) Enum.valueOf(OnSwipe$Mode.class, r10);
    }

    public static OnSwipe$Mode[] values() {
        return (OnSwipe$Mode[]) $VALUES.clone();
    }
}
