package com.obric.oui.swipeaction.util;

/* JADX INFO: loaded from: classes4.dex */
public final enum Attributes$Mode extends Enum<Attributes$Mode> {
    private static final /* synthetic */ Attributes$Mode[] $VALUES = null;
    public static final Attributes$Mode Multiple = null;
    public static final Attributes$Mode Single = null;

    static {
        Attributes$Mode r10 = new Attributes$Mode("Single", 0);
        Single = r10;
        Attributes$Mode r11 = new Attributes$Mode("Multiple", 1);
        Multiple = r11;
        $VALUES = new Attributes$Mode[]{r10, r11};
    }

    private Attributes$Mode(String r10, int r11) {
        super(r10, r11);
    }

    public static Attributes$Mode valueOf(String r10) {
        return (Attributes$Mode) Enum.valueOf(Attributes$Mode.class, r10);
    }

    public static Attributes$Mode[] values() {
        return (Attributes$Mode[]) $VALUES.clone();
    }
}
