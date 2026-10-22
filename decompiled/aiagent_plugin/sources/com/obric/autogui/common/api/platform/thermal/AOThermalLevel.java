package com.obric.autogui.common.api.platform.thermal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: AOThermalLevel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AOThermalLevel extends Enum<AOThermalLevel> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AOThermalLevel[] $VALUES = null;
    public static final AOThermalLevel LEVEL_CRITICAL = null;
    public static final AOThermalLevel LEVEL_EMERGENCY = null;
    public static final AOThermalLevel LEVEL_LIGHT = null;
    public static final AOThermalLevel LEVEL_MODERATE = null;
    public static final AOThermalLevel LEVEL_SEVERE = null;
    public static final AOThermalLevel LEVEL_SHUTDOWN = null;

    private static final /* synthetic */ AOThermalLevel[] $values() {
        return new AOThermalLevel[]{LEVEL_LIGHT, LEVEL_MODERATE, LEVEL_SEVERE, LEVEL_CRITICAL, LEVEL_EMERGENCY, LEVEL_SHUTDOWN};
    }

    public static a<AOThermalLevel> getEntries() {
        return $ENTRIES;
    }

    private AOThermalLevel(String r1, int r2) {
        super(r1, r2);
    }

    static {
        LEVEL_LIGHT = new AOThermalLevel("LEVEL_LIGHT", 0);
        LEVEL_MODERATE = new AOThermalLevel("LEVEL_MODERATE", 1);
        LEVEL_SEVERE = new AOThermalLevel("LEVEL_SEVERE", 2);
        LEVEL_CRITICAL = new AOThermalLevel("LEVEL_CRITICAL", 3);
        LEVEL_EMERGENCY = new AOThermalLevel("LEVEL_EMERGENCY", 4);
        LEVEL_SHUTDOWN = new AOThermalLevel("LEVEL_SHUTDOWN", 5);
        AOThermalLevel[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AOThermalLevel valueOf(String r2) {
        return (AOThermalLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(AOThermalLevel.class, r2), AOThermalLevel.class, "com.obric.aiagent.plugin");
    }

    public static AOThermalLevel[] values() {
        return (AOThermalLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AOThermalLevel[].class, "com.obric.aiagent.plugin");
    }
}
