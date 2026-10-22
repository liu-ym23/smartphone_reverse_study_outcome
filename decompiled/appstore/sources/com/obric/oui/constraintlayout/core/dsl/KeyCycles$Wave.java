package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyCycles$Wave extends Enum<KeyCycles$Wave> {
    private static final /* synthetic */ KeyCycles$Wave[] $VALUES = null;
    public static final KeyCycles$Wave COS = null;
    public static final KeyCycles$Wave REVERSE_SAW = null;
    public static final KeyCycles$Wave SAW = null;
    public static final KeyCycles$Wave SIN = null;
    public static final KeyCycles$Wave SQUARE = null;
    public static final KeyCycles$Wave TRIANGLE = null;

    static {
        KeyCycles$Wave r10 = new KeyCycles$Wave("SIN", 0);
        SIN = r10;
        KeyCycles$Wave r11 = new KeyCycles$Wave("SQUARE", 1);
        SQUARE = r11;
        KeyCycles$Wave r12 = new KeyCycles$Wave("TRIANGLE", 2);
        TRIANGLE = r12;
        KeyCycles$Wave r13 = new KeyCycles$Wave("SAW", 3);
        SAW = r13;
        KeyCycles$Wave r14 = new KeyCycles$Wave("REVERSE_SAW", 4);
        REVERSE_SAW = r14;
        KeyCycles$Wave r15 = new KeyCycles$Wave("COS", 5);
        COS = r15;
        $VALUES = new KeyCycles$Wave[]{r10, r11, r12, r13, r14, r15};
    }

    private KeyCycles$Wave(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyCycles$Wave valueOf(String r10) {
        return (KeyCycles$Wave) Enum.valueOf(KeyCycles$Wave.class, r10);
    }

    public static KeyCycles$Wave[] values() {
        return (KeyCycles$Wave[]) $VALUES.clone();
    }
}
