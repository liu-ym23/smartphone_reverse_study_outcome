package com.bytedance.common.wschannel.heartbeat.smart.state;

/* JADX INFO: loaded from: classes.dex */
public final enum StateType extends Enum<StateType> {
    private static final /* synthetic */ StateType[] $VALUES = null;
    public static final StateType ACTIVE = null;
    public static final StateType IDLE = null;
    public static final StateType PLUMB = null;
    public static final StateType SECONDARY_ACTIVE = null;
    public static final StateType STABLE = null;

    static {
        StateType r10 = new StateType("ACTIVE", 0);
        ACTIVE = r10;
        StateType r11 = new StateType("SECONDARY_ACTIVE", 1);
        SECONDARY_ACTIVE = r11;
        StateType r12 = new StateType("PLUMB", 2);
        PLUMB = r12;
        StateType r13 = new StateType("STABLE", 3);
        STABLE = r13;
        StateType r14 = new StateType("IDLE", 4);
        IDLE = r14;
        $VALUES = new StateType[]{r10, r11, r12, r13, r14};
    }

    private StateType(String r10, int r11) {
        super(r10, r11);
    }

    public static StateType valueOf(String r10) {
        return (StateType) Enum.valueOf(StateType.class, r10);
    }

    public static StateType[] values() {
        return (StateType[]) $VALUES.clone();
    }
}
