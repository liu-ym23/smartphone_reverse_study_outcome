package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum CCApplicationAccessState extends Enum<CCApplicationAccessState> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ CCApplicationAccessState[] $VALUES = null;
    public static final CCApplicationAccessState Denied = null;
    public static final CCApplicationAccessState DeniedBlacklist = null;
    public static final CCApplicationAccessState Granted = null;
    public static final CCApplicationAccessState Pending = null;
    public static final CCApplicationAccessState Unknown = null;

    private static final /* synthetic */ CCApplicationAccessState[] $values() {
        return new CCApplicationAccessState[]{Denied, Granted, Pending, DeniedBlacklist, Unknown};
    }

    public static a<CCApplicationAccessState> getEntries() {
        return $ENTRIES;
    }

    private CCApplicationAccessState(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Denied = new CCApplicationAccessState("Denied", 0);
        Granted = new CCApplicationAccessState("Granted", 1);
        Pending = new CCApplicationAccessState("Pending", 2);
        DeniedBlacklist = new CCApplicationAccessState("DeniedBlacklist", 3);
        Unknown = new CCApplicationAccessState("Unknown", 4);
        CCApplicationAccessState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static CCApplicationAccessState valueOf(String r2) {
        return (CCApplicationAccessState) ZeusTransformUtils.preCheckCast(Enum.valueOf(CCApplicationAccessState.class, r2), CCApplicationAccessState.class, "com.obric.aiagent.plugin");
    }

    public static CCApplicationAccessState[] values() {
        return (CCApplicationAccessState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CCApplicationAccessState[].class, "com.obric.aiagent.plugin");
    }
}
