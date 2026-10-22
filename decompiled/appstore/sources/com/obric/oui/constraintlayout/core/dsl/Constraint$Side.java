package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum Constraint$Side extends Enum<Constraint$Side> {
    private static final /* synthetic */ Constraint$Side[] $VALUES = null;
    public static final Constraint$Side BASELINE = null;
    public static final Constraint$Side BOTTOM = null;
    public static final Constraint$Side END = null;
    public static final Constraint$Side LEFT = null;
    public static final Constraint$Side RIGHT = null;
    public static final Constraint$Side START = null;
    public static final Constraint$Side TOP = null;

    static {
        Constraint$Side r10 = new Constraint$Side("LEFT", 0);
        LEFT = r10;
        Constraint$Side r11 = new Constraint$Side("RIGHT", 1);
        RIGHT = r11;
        Constraint$Side r12 = new Constraint$Side("TOP", 2);
        TOP = r12;
        Constraint$Side r13 = new Constraint$Side("BOTTOM", 3);
        BOTTOM = r13;
        Constraint$Side r14 = new Constraint$Side("START", 4);
        START = r14;
        Constraint$Side r15 = new Constraint$Side("END", 5);
        END = r15;
        Constraint$Side r16 = new Constraint$Side("BASELINE", 6);
        BASELINE = r16;
        $VALUES = new Constraint$Side[]{r10, r11, r12, r13, r14, r15, r16};
    }

    private Constraint$Side(String r10, int r11) {
        super(r10, r11);
    }

    public static Constraint$Side valueOf(String r10) {
        return (Constraint$Side) Enum.valueOf(Constraint$Side.class, r10);
    }

    public static Constraint$Side[] values() {
        return (Constraint$Side[]) $VALUES.clone();
    }
}
