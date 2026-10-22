package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum Constraint$HSide extends Enum<Constraint$HSide> {
    private static final /* synthetic */ Constraint$HSide[] $VALUES = null;
    public static final Constraint$HSide END = null;
    public static final Constraint$HSide LEFT = null;
    public static final Constraint$HSide RIGHT = null;
    public static final Constraint$HSide START = null;

    static {
        Constraint$HSide r10 = new Constraint$HSide("LEFT", 0);
        LEFT = r10;
        Constraint$HSide r11 = new Constraint$HSide("RIGHT", 1);
        RIGHT = r11;
        Constraint$HSide r12 = new Constraint$HSide("START", 2);
        START = r12;
        Constraint$HSide r13 = new Constraint$HSide("END", 3);
        END = r13;
        $VALUES = new Constraint$HSide[]{r10, r11, r12, r13};
    }

    private Constraint$HSide(String r10, int r11) {
        super(r10, r11);
    }

    public static Constraint$HSide valueOf(String r10) {
        return (Constraint$HSide) Enum.valueOf(Constraint$HSide.class, r10);
    }

    public static Constraint$HSide[] values() {
        return (Constraint$HSide[]) $VALUES.clone();
    }
}
