package com.stepos.ability.report.event;

import K7.a;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/ability/report/event/CallType;", "", "value", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Unknown", "LOCAL_MCP", "REMOTE_MCP", "REMOTE_API", "GOOGLE_APPFUNCTIONS", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ CallType[] $VALUES;
    private final String value;
    public static final CallType Unknown = new CallType("Unknown", 0, EnvironmentCompat.MEDIA_UNKNOWN);
    public static final CallType LOCAL_MCP = new CallType("LOCAL_MCP", 1, "local_mcp");
    public static final CallType REMOTE_MCP = new CallType("REMOTE_MCP", 2, "remote_mcp");
    public static final CallType REMOTE_API = new CallType("REMOTE_API", 3, "remote_api");
    public static final CallType GOOGLE_APPFUNCTIONS = new CallType("GOOGLE_APPFUNCTIONS", 4, "google_appfunctions");

    private static final /* synthetic */ CallType[] $values() {
        return new CallType[]{Unknown, LOCAL_MCP, REMOTE_MCP, REMOTE_API, GOOGLE_APPFUNCTIONS};
    }

    static {
        CallType[] callTypeArr$values = $values();
        $VALUES = callTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(callTypeArr$values);
    }

    private CallType(String str, int i, String str2) {
        this.value = str2;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static CallType valueOf(String str) {
        return (CallType) Enum.valueOf(CallType.class, str);
    }

    public static CallType[] values() {
        return (CallType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
