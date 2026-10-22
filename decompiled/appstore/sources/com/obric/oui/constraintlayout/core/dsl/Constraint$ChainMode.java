package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum Constraint$ChainMode extends Enum<Constraint$ChainMode> {
    private static final /* synthetic */ Constraint$ChainMode[] $VALUES = null;
    public static final Constraint$ChainMode PACKED = null;
    public static final Constraint$ChainMode SPREAD = null;
    public static final Constraint$ChainMode SPREAD_INSIDE = null;

    static {
        Constraint$ChainMode r10 = new Constraint$ChainMode("SPREAD", 0);
        SPREAD = r10;
        Constraint$ChainMode r11 = new Constraint$ChainMode("SPREAD_INSIDE", 1);
        SPREAD_INSIDE = r11;
        Constraint$ChainMode r12 = new Constraint$ChainMode("PACKED", 2);
        PACKED = r12;
        $VALUES = new Constraint$ChainMode[]{r10, r11, r12};
    }

    private Constraint$ChainMode(String r10, int r11) {
        super(r10, r11);
    }

    public static Constraint$ChainMode valueOf(String r10) {
        return (Constraint$ChainMode) Enum.valueOf(Constraint$ChainMode.class, r10);
    }

    public static Constraint$ChainMode[] values() {
        return (Constraint$ChainMode[]) $VALUES.clone();
    }
}
