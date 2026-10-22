package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum Helper$Type extends Enum<Helper$Type> {
    private static final /* synthetic */ Helper$Type[] $VALUES = null;
    public static final Helper$Type BARRIER = null;
    public static final Helper$Type HORIZONTAL_CHAIN = null;
    public static final Helper$Type HORIZONTAL_GUIDELINE = null;
    public static final Helper$Type VERTICAL_CHAIN = null;
    public static final Helper$Type VERTICAL_GUIDELINE = null;

    static {
        Helper$Type r10 = new Helper$Type("VERTICAL_GUIDELINE", 0);
        VERTICAL_GUIDELINE = r10;
        Helper$Type r11 = new Helper$Type("HORIZONTAL_GUIDELINE", 1);
        HORIZONTAL_GUIDELINE = r11;
        Helper$Type r12 = new Helper$Type("VERTICAL_CHAIN", 2);
        VERTICAL_CHAIN = r12;
        Helper$Type r13 = new Helper$Type("HORIZONTAL_CHAIN", 3);
        HORIZONTAL_CHAIN = r13;
        Helper$Type r14 = new Helper$Type("BARRIER", 4);
        BARRIER = r14;
        $VALUES = new Helper$Type[]{r10, r11, r12, r13, r14};
    }

    private Helper$Type(String r10, int r11) {
        super(r10, r11);
    }

    public static Helper$Type valueOf(String r10) {
        return (Helper$Type) Enum.valueOf(Helper$Type.class, r10);
    }

    public static Helper$Type[] values() {
        return (Helper$Type[]) $VALUES.clone();
    }
}
