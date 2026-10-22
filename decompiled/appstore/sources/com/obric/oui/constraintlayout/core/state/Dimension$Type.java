package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes4.dex */
public final enum Dimension$Type extends Enum<Dimension$Type> {
    private static final /* synthetic */ Dimension$Type[] $VALUES = null;
    public static final Dimension$Type FIXED = null;
    public static final Dimension$Type MATCH_CONSTRAINT = null;
    public static final Dimension$Type MATCH_PARENT = null;
    public static final Dimension$Type WRAP = null;

    static {
        Dimension$Type r10 = new Dimension$Type("FIXED", 0);
        FIXED = r10;
        Dimension$Type r11 = new Dimension$Type("WRAP", 1);
        WRAP = r11;
        Dimension$Type r12 = new Dimension$Type("MATCH_PARENT", 2);
        MATCH_PARENT = r12;
        Dimension$Type r13 = new Dimension$Type("MATCH_CONSTRAINT", 3);
        MATCH_CONSTRAINT = r13;
        $VALUES = new Dimension$Type[]{r10, r11, r12, r13};
    }

    private Dimension$Type(String r10, int r11) {
        super(r10, r11);
    }

    public static Dimension$Type valueOf(String r10) {
        return (Dimension$Type) Enum.valueOf(Dimension$Type.class, r10);
    }

    public static Dimension$Type[] values() {
        return (Dimension$Type[]) $VALUES.clone();
    }
}
