package com.obric.funcall_api.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: IntentAppAction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ToolType extends Enum<ToolType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ ToolType[] $VALUES = null;
    public static final ToolType APP = null;
    public static final ToolType INTENT = null;
    public static final ToolType SHORTCUT = null;
    public static final ToolType UNDEF = null;

    private static final /* synthetic */ ToolType[] $values() {
        return new ToolType[]{UNDEF, APP, SHORTCUT, INTENT};
    }

    public static a<ToolType> getEntries() {
        return $ENTRIES;
    }

    private ToolType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        UNDEF = new ToolType("UNDEF", 0);
        APP = new ToolType("APP", 1);
        SHORTCUT = new ToolType("SHORTCUT", 2);
        INTENT = new ToolType("INTENT", 3);
        ToolType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ToolType valueOf(String r2) {
        return (ToolType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToolType.class, r2), ToolType.class, "com.obric.aiagent.plugin");
    }

    public static ToolType[] values() {
        return (ToolType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToolType[].class, "com.obric.aiagent.plugin");
    }
}
