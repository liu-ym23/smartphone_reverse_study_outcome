package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyPosition$Type extends Enum<KeyPosition$Type> {
    private static final /* synthetic */ KeyPosition$Type[] $VALUES = null;
    public static final KeyPosition$Type CARTESIAN = null;
    public static final KeyPosition$Type PATH = null;
    public static final KeyPosition$Type SCREEN = null;

    static {
        KeyPosition$Type r10 = new KeyPosition$Type("CARTESIAN", 0);
        CARTESIAN = r10;
        KeyPosition$Type r11 = new KeyPosition$Type("SCREEN", 1);
        SCREEN = r11;
        KeyPosition$Type r12 = new KeyPosition$Type("PATH", 2);
        PATH = r12;
        $VALUES = new KeyPosition$Type[]{r10, r11, r12};
    }

    private KeyPosition$Type(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyPosition$Type valueOf(String r10) {
        return (KeyPosition$Type) Enum.valueOf(KeyPosition$Type.class, r10);
    }

    public static KeyPosition$Type[] values() {
        return (KeyPosition$Type[]) $VALUES.clone();
    }
}
