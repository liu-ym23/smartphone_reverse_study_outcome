package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentbus/generated/ToolType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "CORE", "INSTALLED", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolType {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ ToolType[] $VALUES;
    public static final ToolType CORE = new ToolType("CORE", 0);
    public static final ToolType INSTALLED = new ToolType("INSTALLED", 1);

    private static final /* synthetic */ ToolType[] $values() {
        return new ToolType[]{CORE, INSTALLED};
    }

    static {
        ToolType[] toolTypeArr$values = $values();
        $VALUES = toolTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(toolTypeArr$values);
    }

    private ToolType(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static ToolType valueOf(String str) {
        return (ToolType) Enum.valueOf(ToolType.class, str);
    }

    public static ToolType[] values() {
        return (ToolType[]) $VALUES.clone();
    }
}
