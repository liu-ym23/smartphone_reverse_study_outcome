package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyCycle$Wave extends Enum<KeyCycle$Wave> {
    private static final /* synthetic */ KeyCycle$Wave[] $VALUES = null;
    public static final KeyCycle$Wave COS = null;
    public static final KeyCycle$Wave REVERSE_SAW = null;
    public static final KeyCycle$Wave SAW = null;
    public static final KeyCycle$Wave SIN = null;
    public static final KeyCycle$Wave SQUARE = null;
    public static final KeyCycle$Wave TRIANGLE = null;

    static {
        KeyCycle$Wave r10 = new KeyCycle$Wave("SIN", 0);
        SIN = r10;
        KeyCycle$Wave r11 = new KeyCycle$Wave("SQUARE", 1);
        SQUARE = r11;
        KeyCycle$Wave r12 = new KeyCycle$Wave("TRIANGLE", 2);
        TRIANGLE = r12;
        KeyCycle$Wave r13 = new KeyCycle$Wave("SAW", 3);
        SAW = r13;
        KeyCycle$Wave r14 = new KeyCycle$Wave("REVERSE_SAW", 4);
        REVERSE_SAW = r14;
        KeyCycle$Wave r15 = new KeyCycle$Wave("COS", 5);
        COS = r15;
        $VALUES = new KeyCycle$Wave[]{r10, r11, r12, r13, r14, r15};
    }

    private KeyCycle$Wave(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyCycle$Wave valueOf(String r10) {
        return (KeyCycle$Wave) Enum.valueOf(KeyCycle$Wave.class, r10);
    }

    public static KeyCycle$Wave[] values() {
        return (KeyCycle$Wave[]) $VALUES.clone();
    }
}
