package com.obric.capabilitykit.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum TaskState extends Enum<TaskState> {
    private static final /* synthetic */ TaskState[] $VALUES = null;
    public static final TaskState Addition = null;
    public static final TaskState CallUser = null;
    public static final TaskState Clarify = null;
    public static final TaskState Stop = null;
    public static final TaskState UserOperationBegin = null;
    public static final TaskState UserOperationEnd = null;

    private static final /* synthetic */ TaskState[] $values() {
        return new TaskState[]{Clarify, CallUser, UserOperationBegin, UserOperationEnd, Stop, Addition};
    }

    static {
        Clarify = new TaskState("Clarify", 0);
        CallUser = new TaskState("CallUser", 1);
        UserOperationBegin = new TaskState("UserOperationBegin", 2);
        UserOperationEnd = new TaskState("UserOperationEnd", 3);
        Stop = new TaskState("Stop", 4);
        Addition = new TaskState("Addition", 5);
        $VALUES = $values();
    }

    private TaskState(String r1, int r2) {
        super(r1, r2);
    }

    public static TaskState valueOf(String r2) {
        return (TaskState) ZeusTransformUtils.preCheckCast(Enum.valueOf(TaskState.class, r2), TaskState.class, "com.obric.aiagent.plugin");
    }

    public static TaskState[] values() {
        return (TaskState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TaskState[].class, "com.obric.aiagent.plugin");
    }
}
