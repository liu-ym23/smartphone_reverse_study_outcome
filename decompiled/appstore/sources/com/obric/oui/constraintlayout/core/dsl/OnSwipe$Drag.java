package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum OnSwipe$Drag extends Enum<OnSwipe$Drag> {
    private static final /* synthetic */ OnSwipe$Drag[] $VALUES = null;
    public static final OnSwipe$Drag ANTICLOCKWISE = null;
    public static final OnSwipe$Drag CLOCKWISE = null;
    public static final OnSwipe$Drag DOWN = null;
    public static final OnSwipe$Drag END = null;
    public static final OnSwipe$Drag LEFT = null;
    public static final OnSwipe$Drag RIGHT = null;
    public static final OnSwipe$Drag START = null;
    public static final OnSwipe$Drag UP = null;

    static {
        OnSwipe$Drag r10 = new OnSwipe$Drag("UP", 0);
        UP = r10;
        OnSwipe$Drag r11 = new OnSwipe$Drag("DOWN", 1);
        DOWN = r11;
        OnSwipe$Drag r12 = new OnSwipe$Drag("LEFT", 2);
        LEFT = r12;
        OnSwipe$Drag r13 = new OnSwipe$Drag("RIGHT", 3);
        RIGHT = r13;
        OnSwipe$Drag r14 = new OnSwipe$Drag("START", 4);
        START = r14;
        OnSwipe$Drag r15 = new OnSwipe$Drag("END", 5);
        END = r15;
        OnSwipe$Drag r16 = new OnSwipe$Drag("CLOCKWISE", 6);
        CLOCKWISE = r16;
        OnSwipe$Drag r17 = new OnSwipe$Drag("ANTICLOCKWISE", 7);
        ANTICLOCKWISE = r17;
        $VALUES = new OnSwipe$Drag[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private OnSwipe$Drag(String r10, int r11) {
        super(r10, r11);
    }

    public static OnSwipe$Drag valueOf(String r10) {
        return (OnSwipe$Drag) Enum.valueOf(OnSwipe$Drag.class, r10);
    }

    public static OnSwipe$Drag[] values() {
        return (OnSwipe$Drag[]) $VALUES.clone();
    }
}
