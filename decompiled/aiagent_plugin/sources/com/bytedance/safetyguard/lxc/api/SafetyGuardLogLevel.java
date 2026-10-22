package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: SafetyGuardLogging.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum SafetyGuardLogLevel extends Enum<SafetyGuardLogLevel> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ SafetyGuardLogLevel[] $VALUES = null;
    public static final SafetyGuardLogLevel DEBUG = null;
    public static final SafetyGuardLogLevel ERROR = null;
    public static final SafetyGuardLogLevel INFO = null;
    public static final SafetyGuardLogLevel WARN = null;

    private static final /* synthetic */ SafetyGuardLogLevel[] $values() {
        return new SafetyGuardLogLevel[]{DEBUG, INFO, WARN, ERROR};
    }

    public static a<SafetyGuardLogLevel> getEntries() {
        return $ENTRIES;
    }

    public static SafetyGuardLogLevel valueOf(String r2) {
        return (SafetyGuardLogLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(SafetyGuardLogLevel.class, r2), SafetyGuardLogLevel.class, "com.obric.aiagent.plugin");
    }

    public static SafetyGuardLogLevel[] values() {
        return (SafetyGuardLogLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SafetyGuardLogLevel[].class, "com.obric.aiagent.plugin");
    }

    private SafetyGuardLogLevel(String r1, int r2) {
        super(r1, r2);
    }

    static {
        DEBUG = new SafetyGuardLogLevel("DEBUG", 0);
        INFO = new SafetyGuardLogLevel("INFO", 1);
        WARN = new SafetyGuardLogLevel("WARN", 2);
        ERROR = new SafetyGuardLogLevel("ERROR", 3);
        SafetyGuardLogLevel[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
