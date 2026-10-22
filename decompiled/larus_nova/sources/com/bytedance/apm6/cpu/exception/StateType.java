package com.bytedance.apm6.cpu.exception;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum StateType extends Enum<StateType> {
    public static final StateType COOL_DOWN = null;
    public static final StateType IDLE = null;
    public static final StateType PROCESS_DETECT = null;
    public static final StateType PROCESS_DOUBLE_DETECT = null;
    public static final StateType THREAD_DETECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StateType[] f190805a = null;

    static {
        StateType r100 = new StateType("PROCESS_DETECT", 0);
        PROCESS_DETECT = r100;
        StateType r101 = new StateType("PROCESS_DOUBLE_DETECT", 1);
        PROCESS_DOUBLE_DETECT = r101;
        StateType r102 = new StateType("THREAD_DETECT", 2);
        THREAD_DETECT = r102;
        StateType r103 = new StateType("COOL_DOWN", 3);
        COOL_DOWN = r103;
        StateType r104 = new StateType("IDLE", 4);
        IDLE = r104;
        f190805a = new StateType[]{r100, r101, r102, r103, r104};
    }

    public static StateType[] values() {
        return (StateType[]) f190805a.clone();
    }

    public static StateType valueOf(String r100) {
        return (StateType) a.a(StateType.class, r100);
    }

    public StateType(String r100, int r101) {
        super(r100, r101);
    }
}
