package com.obric.autogui.common.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: AgentOperationTargetDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AgentOperationStatus extends Enum<AgentOperationStatus> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AgentOperationStatus[] $VALUES = null;
    public static final AgentOperationStatus START = null;
    public static final AgentOperationStatus STOP = null;

    private static final /* synthetic */ AgentOperationStatus[] $values() {
        return new AgentOperationStatus[]{START, STOP};
    }

    public static a<AgentOperationStatus> getEntries() {
        return $ENTRIES;
    }

    private AgentOperationStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        START = new AgentOperationStatus("START", 0);
        STOP = new AgentOperationStatus("STOP", 1);
        AgentOperationStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AgentOperationStatus valueOf(String r2) {
        return (AgentOperationStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AgentOperationStatus.class, r2), AgentOperationStatus.class, "com.obric.aiagent.plugin");
    }

    public static AgentOperationStatus[] values() {
        return (AgentOperationStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AgentOperationStatus[].class, "com.obric.aiagent.plugin");
    }
}
