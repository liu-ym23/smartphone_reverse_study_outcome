package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes4.dex */
public final enum ConstraintSetParser$MotionLayoutDebugFlags extends Enum<ConstraintSetParser$MotionLayoutDebugFlags> {
    private static final /* synthetic */ ConstraintSetParser$MotionLayoutDebugFlags[] $VALUES = null;
    public static final ConstraintSetParser$MotionLayoutDebugFlags NONE = null;
    public static final ConstraintSetParser$MotionLayoutDebugFlags SHOW_ALL = null;
    public static final ConstraintSetParser$MotionLayoutDebugFlags UNKNOWN = null;

    static {
        ConstraintSetParser$MotionLayoutDebugFlags r10 = new ConstraintSetParser$MotionLayoutDebugFlags("NONE", 0);
        NONE = r10;
        ConstraintSetParser$MotionLayoutDebugFlags r11 = new ConstraintSetParser$MotionLayoutDebugFlags("SHOW_ALL", 1);
        SHOW_ALL = r11;
        ConstraintSetParser$MotionLayoutDebugFlags r12 = new ConstraintSetParser$MotionLayoutDebugFlags("UNKNOWN", 2);
        UNKNOWN = r12;
        $VALUES = new ConstraintSetParser$MotionLayoutDebugFlags[]{r10, r11, r12};
    }

    private ConstraintSetParser$MotionLayoutDebugFlags(String r10, int r11) {
        super(r10, r11);
    }

    public static ConstraintSetParser$MotionLayoutDebugFlags valueOf(String r10) {
        return (ConstraintSetParser$MotionLayoutDebugFlags) Enum.valueOf(ConstraintSetParser$MotionLayoutDebugFlags.class, r10);
    }

    public static ConstraintSetParser$MotionLayoutDebugFlags[] values() {
        return (ConstraintSetParser$MotionLayoutDebugFlags[]) $VALUES.clone();
    }
}
