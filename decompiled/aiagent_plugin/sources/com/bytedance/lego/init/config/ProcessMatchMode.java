package com.bytedance.lego.init.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TaskConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum ProcessMatchMode extends Enum<ProcessMatchMode> {
    private static final /* synthetic */ ProcessMatchMode[] $VALUES = null;
    public static final ProcessMatchMode CONTAIN = null;
    public static final ProcessMatchMode ENDWITH = null;
    public static final ProcessMatchMode STRICT = null;

    static {
        ProcessMatchMode r1 = new ProcessMatchMode("STRICT", 0);
        STRICT = r1;
        ProcessMatchMode r2 = new ProcessMatchMode("ENDWITH", 1);
        ENDWITH = r2;
        ProcessMatchMode r3 = new ProcessMatchMode("CONTAIN", 2);
        CONTAIN = r3;
        $VALUES = new ProcessMatchMode[]{r1, r2, r3};
    }

    public static ProcessMatchMode valueOf(String r2) {
        return (ProcessMatchMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProcessMatchMode.class, r2), ProcessMatchMode.class, "com.obric.aiagent.plugin");
    }

    public static ProcessMatchMode[] values() {
        return (ProcessMatchMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProcessMatchMode[].class, "com.obric.aiagent.plugin");
    }

    public ProcessMatchMode(String r1, int r2) {
        super(r1, r2);
    }
}
