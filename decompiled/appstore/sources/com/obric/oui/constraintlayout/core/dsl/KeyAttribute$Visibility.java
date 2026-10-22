package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyAttribute$Visibility extends Enum<KeyAttribute$Visibility> {
    private static final /* synthetic */ KeyAttribute$Visibility[] $VALUES = null;
    public static final KeyAttribute$Visibility GONE = null;
    public static final KeyAttribute$Visibility INVISIBLE = null;
    public static final KeyAttribute$Visibility VISIBLE = null;

    static {
        KeyAttribute$Visibility r10 = new KeyAttribute$Visibility("VISIBLE", 0);
        VISIBLE = r10;
        KeyAttribute$Visibility r11 = new KeyAttribute$Visibility("INVISIBLE", 1);
        INVISIBLE = r11;
        KeyAttribute$Visibility r12 = new KeyAttribute$Visibility("GONE", 2);
        GONE = r12;
        $VALUES = new KeyAttribute$Visibility[]{r10, r11, r12};
    }

    private KeyAttribute$Visibility(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyAttribute$Visibility valueOf(String r10) {
        return (KeyAttribute$Visibility) Enum.valueOf(KeyAttribute$Visibility.class, r10);
    }

    public static KeyAttribute$Visibility[] values() {
        return (KeyAttribute$Visibility[]) $VALUES.clone();
    }
}
