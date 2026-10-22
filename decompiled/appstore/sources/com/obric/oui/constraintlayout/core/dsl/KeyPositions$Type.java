package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyPositions$Type extends Enum<KeyPositions$Type> {
    private static final /* synthetic */ KeyPositions$Type[] $VALUES = null;
    public static final KeyPositions$Type CARTESIAN = null;
    public static final KeyPositions$Type PATH = null;
    public static final KeyPositions$Type SCREEN = null;

    static {
        KeyPositions$Type r10 = new KeyPositions$Type("CARTESIAN", 0);
        CARTESIAN = r10;
        KeyPositions$Type r11 = new KeyPositions$Type("SCREEN", 1);
        SCREEN = r11;
        KeyPositions$Type r12 = new KeyPositions$Type("PATH", 2);
        PATH = r12;
        $VALUES = new KeyPositions$Type[]{r10, r11, r12};
    }

    private KeyPositions$Type(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyPositions$Type valueOf(String r10) {
        return (KeyPositions$Type) Enum.valueOf(KeyPositions$Type.class, r10);
    }

    public static KeyPositions$Type[] values() {
        return (KeyPositions$Type[]) $VALUES.clone();
    }
}
