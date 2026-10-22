package com.obric.capabilitykit.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum ToolType extends Enum<ToolType> {
    private static final /* synthetic */ ToolType[] $VALUES = null;
    public static final ToolType APP = null;
    public static final ToolType APPLET = null;
    public static final ToolType INTENT = null;
    public static final ToolType SHORTCUT = null;
    public static final ToolType UNDEF = null;

    private static final /* synthetic */ ToolType[] $values() {
        return new ToolType[]{UNDEF, APP, SHORTCUT, INTENT, APPLET};
    }

    static {
        UNDEF = new ToolType("UNDEF", 0);
        APP = new ToolType("APP", 1);
        SHORTCUT = new ToolType("SHORTCUT", 2);
        INTENT = new ToolType("INTENT", 3);
        APPLET = new ToolType("APPLET", 4);
        $VALUES = $values();
    }

    private ToolType(String r1, int r2) {
        super(r1, r2);
    }

    public static ToolType valueOf(String r2) {
        return (ToolType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToolType.class, r2), ToolType.class, "com.obric.aiagent.plugin");
    }

    public static ToolType[] values() {
        return (ToolType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToolType[].class, "com.obric.aiagent.plugin");
    }
}
