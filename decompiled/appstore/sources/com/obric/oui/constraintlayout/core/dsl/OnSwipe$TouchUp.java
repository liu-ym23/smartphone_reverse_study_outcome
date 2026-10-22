package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum OnSwipe$TouchUp extends Enum<OnSwipe$TouchUp> {
    private static final /* synthetic */ OnSwipe$TouchUp[] $VALUES = null;
    public static final OnSwipe$TouchUp AUTOCOMPLETE = null;
    public static final OnSwipe$TouchUp DECELERATE = null;
    public static final OnSwipe$TouchUp DECELERATE_COMPLETE = null;
    public static final OnSwipe$TouchUp NEVER_COMPLETE_END = null;
    public static final OnSwipe$TouchUp NEVER_COMPLETE_START = null;
    public static final OnSwipe$TouchUp STOP = null;
    public static final OnSwipe$TouchUp TO_END = null;
    public static final OnSwipe$TouchUp TO_START = null;

    static {
        OnSwipe$TouchUp r10 = new OnSwipe$TouchUp("AUTOCOMPLETE", 0);
        AUTOCOMPLETE = r10;
        OnSwipe$TouchUp r11 = new OnSwipe$TouchUp("TO_START", 1);
        TO_START = r11;
        OnSwipe$TouchUp r12 = new OnSwipe$TouchUp("NEVER_COMPLETE_END", 2);
        NEVER_COMPLETE_END = r12;
        OnSwipe$TouchUp r13 = new OnSwipe$TouchUp("TO_END", 3);
        TO_END = r13;
        OnSwipe$TouchUp r14 = new OnSwipe$TouchUp("STOP", 4);
        STOP = r14;
        OnSwipe$TouchUp r15 = new OnSwipe$TouchUp("DECELERATE", 5);
        DECELERATE = r15;
        OnSwipe$TouchUp r16 = new OnSwipe$TouchUp("DECELERATE_COMPLETE", 6);
        DECELERATE_COMPLETE = r16;
        OnSwipe$TouchUp r17 = new OnSwipe$TouchUp("NEVER_COMPLETE_START", 7);
        NEVER_COMPLETE_START = r17;
        $VALUES = new OnSwipe$TouchUp[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private OnSwipe$TouchUp(String r10, int r11) {
        super(r10, r11);
    }

    public static OnSwipe$TouchUp valueOf(String r10) {
        return (OnSwipe$TouchUp) Enum.valueOf(OnSwipe$TouchUp.class, r10);
    }

    public static OnSwipe$TouchUp[] values() {
        return (OnSwipe$TouchUp[]) $VALUES.clone();
    }
}
