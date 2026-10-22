package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum Constraint$Behaviour extends Enum<Constraint$Behaviour> {
    private static final /* synthetic */ Constraint$Behaviour[] $VALUES = null;
    public static final Constraint$Behaviour PERCENT = null;
    public static final Constraint$Behaviour RATIO = null;
    public static final Constraint$Behaviour RESOLVED = null;
    public static final Constraint$Behaviour SPREAD = null;
    public static final Constraint$Behaviour WRAP = null;

    static {
        Constraint$Behaviour r10 = new Constraint$Behaviour("SPREAD", 0);
        SPREAD = r10;
        Constraint$Behaviour r11 = new Constraint$Behaviour("WRAP", 1);
        WRAP = r11;
        Constraint$Behaviour r12 = new Constraint$Behaviour("PERCENT", 2);
        PERCENT = r12;
        Constraint$Behaviour r13 = new Constraint$Behaviour("RATIO", 3);
        RATIO = r13;
        Constraint$Behaviour r14 = new Constraint$Behaviour("RESOLVED", 4);
        RESOLVED = r14;
        $VALUES = new Constraint$Behaviour[]{r10, r11, r12, r13, r14};
    }

    private Constraint$Behaviour(String r10, int r11) {
        super(r10, r11);
    }

    public static Constraint$Behaviour valueOf(String r10) {
        return (Constraint$Behaviour) Enum.valueOf(Constraint$Behaviour.class, r10);
    }

    public static Constraint$Behaviour[] values() {
        return (Constraint$Behaviour[]) $VALUES.clone();
    }
}
