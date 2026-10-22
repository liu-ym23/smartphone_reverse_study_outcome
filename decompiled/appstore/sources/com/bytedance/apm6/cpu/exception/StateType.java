package com.bytedance.apm6.cpu.exception;

/* JADX INFO: loaded from: classes.dex */
public final enum StateType extends Enum<StateType> {
    private static final /* synthetic */ StateType[] $VALUES = null;
    public static final StateType COOL_DOWN = null;
    public static final StateType IDLE = null;
    public static final StateType PROCESS_DETECT = null;
    public static final StateType PROCESS_DOUBLE_DETECT = null;
    public static final StateType THREAD_DETECT = null;

    static {
        StateType r10 = new StateType("PROCESS_DETECT", 0);
        PROCESS_DETECT = r10;
        StateType r11 = new StateType("PROCESS_DOUBLE_DETECT", 1);
        PROCESS_DOUBLE_DETECT = r11;
        StateType r12 = new StateType("THREAD_DETECT", 2);
        THREAD_DETECT = r12;
        StateType r13 = new StateType("COOL_DOWN", 3);
        COOL_DOWN = r13;
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
