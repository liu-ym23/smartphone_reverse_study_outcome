package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum Chain$Style extends Enum<Chain$Style> {
    private static final /* synthetic */ Chain$Style[] $VALUES = null;
    public static final Chain$Style PACKED = null;
    public static final Chain$Style SPREAD = null;
    public static final Chain$Style SPREAD_INSIDE = null;

    static {
        Chain$Style r10 = new Chain$Style("PACKED", 0);
        PACKED = r10;
        Chain$Style r11 = new Chain$Style("SPREAD", 1);
        SPREAD = r11;
        Chain$Style r12 = new Chain$Style("SPREAD_INSIDE", 2);
        SPREAD_INSIDE = r12;
        $VALUES = new Chain$Style[]{r10, r11, r12};
    }

    private Chain$Style(String r10, int r11) {
        super(r10, r11);
    }

    public static Chain$Style valueOf(String r10) {
        return (Chain$Style) Enum.valueOf(Chain$Style.class, r10);
    }

    public static Chain$Style[] values() {
        return (Chain$Style[]) $VALUES.clone();
    }
}
