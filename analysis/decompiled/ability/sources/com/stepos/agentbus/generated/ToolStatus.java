package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentbus/generated/ToolStatus;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "PENDING", "RUNNING", "OK", "ERROR", "CANCELLED", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolStatus {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ ToolStatus[] $VALUES;
    public static final ToolStatus PENDING = new ToolStatus("PENDING", 0);
    public static final ToolStatus RUNNING = new ToolStatus("RUNNING", 1);
    public static final ToolStatus OK = new ToolStatus("OK", 2);
    public static final ToolStatus ERROR = new ToolStatus("ERROR", 3);
    public static final ToolStatus CANCELLED = new ToolStatus("CANCELLED", 4);

    private static final /* synthetic */ ToolStatus[] $values() {
        return new ToolStatus[]{PENDING, RUNNING, OK, ERROR, CANCELLED};
    }

    static {
        ToolStatus[] toolStatusArr$values = $values();
        $VALUES = toolStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(toolStatusArr$values);
    }

    private ToolStatus(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static ToolStatus valueOf(String str) {
        return (ToolStatus) Enum.valueOf(ToolStatus.class, str);
    }

    public static ToolStatus[] values() {
        return (ToolStatus[]) $VALUES.clone();
    }
}
