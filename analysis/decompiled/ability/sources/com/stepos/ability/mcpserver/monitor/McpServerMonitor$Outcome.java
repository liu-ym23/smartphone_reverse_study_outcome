package com.stepos.ability.mcpserver.monitor;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/stepos/ability/mcpserver/monitor/McpServerMonitor$Outcome", "", "Lcom/stepos/ability/mcpserver/monitor/McpServerMonitor$Outcome;", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class McpServerMonitor$Outcome {

    /* renamed from: a, reason: collision with root package name */
    public static final McpServerMonitor$Outcome f3192a;
    public static final McpServerMonitor$Outcome b;
    public static final McpServerMonitor$Outcome c;
    public static final McpServerMonitor$Outcome d;
    public static final McpServerMonitor$Outcome e;
    public static final McpServerMonitor$Outcome f;
    public static final McpServerMonitor$Outcome g;
    public static final McpServerMonitor$Outcome h;
    public static final McpServerMonitor$Outcome i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ McpServerMonitor$Outcome[] f3193j;

    static {
        McpServerMonitor$Outcome mcpServerMonitor$Outcome = new McpServerMonitor$Outcome("OK", 0);
        f3192a = mcpServerMonitor$Outcome;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome2 = new McpServerMonitor$Outcome("FAILED", 1);
        b = mcpServerMonitor$Outcome2;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome3 = new McpServerMonitor$Outcome("PARSE_ERROR", 2);
        c = mcpServerMonitor$Outcome3;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome4 = new McpServerMonitor$Outcome("NOTIFICATION", 3);
        d = mcpServerMonitor$Outcome4;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome5 = new McpServerMonitor$Outcome("UNAUTHORIZED", 4);
        e = mcpServerMonitor$Outcome5;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome6 = new McpServerMonitor$Outcome("RATE_LIMITED", 5);
        f = mcpServerMonitor$Outcome6;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome7 = new McpServerMonitor$Outcome("BUSY", 6);
        g = mcpServerMonitor$Outcome7;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome8 = new McpServerMonitor$Outcome("UNAVAILABLE", 7);
        h = mcpServerMonitor$Outcome8;
        McpServerMonitor$Outcome mcpServerMonitor$Outcome9 = new McpServerMonitor$Outcome("CONN_REJECTED", 8);
        i = mcpServerMonitor$Outcome9;
        McpServerMonitor$Outcome[] mcpServerMonitor$OutcomeArr = {mcpServerMonitor$Outcome, mcpServerMonitor$Outcome2, mcpServerMonitor$Outcome3, mcpServerMonitor$Outcome4, mcpServerMonitor$Outcome5, mcpServerMonitor$Outcome6, mcpServerMonitor$Outcome7, mcpServerMonitor$Outcome8, mcpServerMonitor$Outcome9};
        f3193j = mcpServerMonitor$OutcomeArr;
        a.a(mcpServerMonitor$OutcomeArr);
    }

    public static McpServerMonitor$Outcome valueOf(String str) {
        return (McpServerMonitor$Outcome) Enum.valueOf(McpServerMonitor$Outcome.class, str);
    }

    public static McpServerMonitor$Outcome[] values() {
        return (McpServerMonitor$Outcome[]) f3193j.clone();
    }
}
