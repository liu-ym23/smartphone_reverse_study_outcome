package com.bytedance.lego.init.monitor;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InitMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum LogType extends Enum<LogType> {
    private static final /* synthetic */ LogType[] $VALUES = null;
    public static final LogType INVALID_COS_TIME = null;

    static {
        LogType r1 = new LogType("INVALID_COS_TIME", 0);
        INVALID_COS_TIME = r1;
        $VALUES = new LogType[]{r1};
    }

    public static LogType valueOf(String r2) {
        return (LogType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LogType.class, r2), LogType.class, "com.obric.aiagent.plugin");
    }

    public static LogType[] values() {
        return (LogType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LogType[].class, "com.obric.aiagent.plugin");
    }

    public LogType(String r1, int r2) {
        super(r1, r2);
    }
}
