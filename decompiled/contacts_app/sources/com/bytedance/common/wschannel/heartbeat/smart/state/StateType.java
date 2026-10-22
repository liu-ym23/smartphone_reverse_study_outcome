package com.bytedance.common.wschannel.heartbeat.smart.state;

/* JADX INFO: loaded from: classes2.dex */
public final enum StateType extends Enum<StateType> {
    private static final /* synthetic */ StateType[] $VALUES = null;
    public static final StateType ACTIVE = null;
    public static final StateType IDLE = null;
    public static final StateType PLUMB = null;
    public static final StateType SECONDARY_ACTIVE = null;
    public static final StateType STABLE = null;

    private StateType(String r1, int r2) {
        super(r1, r2);
    }

    public static StateType valueOf(String r1) {
        return (StateType) Enum.valueOf(StateType.class, r1);
    }

    public static StateType[] values() {
        return (StateType[]) $VALUES.clone();
    }

    static {
        StateType r0 = new StateType("ACTIVE", 0);
        ACTIVE = r0;
        StateType r1 = new StateType("SECONDARY_ACTIVE", 1);
        SECONDARY_ACTIVE = r1;
        StateType r3 = new StateType("PLUMB", 2);
        PLUMB = r3;
        StateType r5 = new StateType("STABLE", 3);
        STABLE = r5;
        StateType r7 = new StateType("IDLE", 4);
        IDLE = r7;
        $VALUES = new StateType[]{r0, r1, r3, r5, r7};
    }
}
