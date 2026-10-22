package com.bytedance.agentrobots.identity;

import com.byted.cast.common.bean.State;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public final enum RobotAgentType extends Enum<RobotAgentType> {
    public static final RobotAgentType ASSISTIVE = null;
    public static final RobotAgentType AUTONOMOUS = null;
    public static final RobotAgentType RECORDING = null;
    public static final RobotAgentType SUGGESTIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RobotAgentType[] f33934a = null;

    static {
        RobotAgentType r100 = new RobotAgentType(State.RECORDING, 0);
        RECORDING = r100;
        RobotAgentType r101 = new RobotAgentType("SUGGESTIVE", 1);
        SUGGESTIVE = r101;
        RobotAgentType r102 = new RobotAgentType("ASSISTIVE", 2);
        ASSISTIVE = r102;
        RobotAgentType r103 = new RobotAgentType("AUTONOMOUS", 3);
        AUTONOMOUS = r103;
        f33934a = new RobotAgentType[]{r100, r101, r102, r103};
    }

    public static RobotAgentType[] values() {
        return (RobotAgentType[]) f33934a.clone();
    }

    public static RobotAgentType valueOf(String r100) {
        return (RobotAgentType) a.a(RobotAgentType.class, r100);
    }

    public RobotAgentType(String r100, int r101) {
        super(r100, r101);
    }
}
