package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyAttributes$Visibility extends Enum<KeyAttributes$Visibility> {
    private static final /* synthetic */ KeyAttributes$Visibility[] $VALUES = null;
    public static final KeyAttributes$Visibility GONE = null;
    public static final KeyAttributes$Visibility INVISIBLE = null;
    public static final KeyAttributes$Visibility VISIBLE = null;

    static {
        KeyAttributes$Visibility r10 = new KeyAttributes$Visibility("VISIBLE", 0);
        VISIBLE = r10;
        KeyAttributes$Visibility r11 = new KeyAttributes$Visibility("INVISIBLE", 1);
        INVISIBLE = r11;
        KeyAttributes$Visibility r12 = new KeyAttributes$Visibility("GONE", 2);
        GONE = r12;
        $VALUES = new KeyAttributes$Visibility[]{r10, r11, r12};
    }

    private KeyAttributes$Visibility(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyAttributes$Visibility valueOf(String r10) {
        return (KeyAttributes$Visibility) Enum.valueOf(KeyAttributes$Visibility.class, r10);
    }

    public static KeyAttributes$Visibility[] values() {
        return (KeyAttributes$Visibility[]) $VALUES.clone();
    }
}
