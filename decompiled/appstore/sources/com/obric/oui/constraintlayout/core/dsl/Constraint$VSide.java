package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum Constraint$VSide extends Enum<Constraint$VSide> {
    private static final /* synthetic */ Constraint$VSide[] $VALUES = null;
    public static final Constraint$VSide BASELINE = null;
    public static final Constraint$VSide BOTTOM = null;
    public static final Constraint$VSide TOP = null;

    static {
        Constraint$VSide r10 = new Constraint$VSide("TOP", 0);
        TOP = r10;
        Constraint$VSide r11 = new Constraint$VSide("BOTTOM", 1);
        BOTTOM = r11;
        Constraint$VSide r12 = new Constraint$VSide("BASELINE", 2);
        BASELINE = r12;
        $VALUES = new Constraint$VSide[]{r10, r11, r12};
    }

    private Constraint$VSide(String r10, int r11) {
        super(r10, r11);
    }

    public static Constraint$VSide valueOf(String r10) {
        return (Constraint$VSide) Enum.valueOf(Constraint$VSide.class, r10);
    }

    public static Constraint$VSide[] values() {
        return (Constraint$VSide[]) $VALUES.clone();
    }
}
