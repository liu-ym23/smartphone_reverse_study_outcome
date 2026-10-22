package com.zyql.protobuf.agent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ToolDefinition$ToolCase {

    /* renamed from: a, reason: collision with root package name */
    public static final ToolDefinition$ToolCase f4256a;
    public static final ToolDefinition$ToolCase b;
    public static final ToolDefinition$ToolCase c;
    public static final ToolDefinition$ToolCase d;
    public static final /* synthetic */ ToolDefinition$ToolCase[] e;

    static {
        ToolDefinition$ToolCase toolDefinition$ToolCase = new ToolDefinition$ToolCase("AGENT_TOOL", 0);
        f4256a = toolDefinition$ToolCase;
        ToolDefinition$ToolCase toolDefinition$ToolCase2 = new ToolDefinition$ToolCase("TOOL_PROVIDER", 1);
        b = toolDefinition$ToolCase2;
        ToolDefinition$ToolCase toolDefinition$ToolCase3 = new ToolDefinition$ToolCase("MCP_TOOL", 2);
        c = toolDefinition$ToolCase3;
        ToolDefinition$ToolCase toolDefinition$ToolCase4 = new ToolDefinition$ToolCase("TOOL_NOT_SET", 3);
        d = toolDefinition$ToolCase4;
        e = new ToolDefinition$ToolCase[]{toolDefinition$ToolCase, toolDefinition$ToolCase2, toolDefinition$ToolCase3, toolDefinition$ToolCase4};
    }

    public static ToolDefinition$ToolCase valueOf(String str) {
        return (ToolDefinition$ToolCase) Enum.valueOf(ToolDefinition$ToolCase.class, str);
    }

    public static ToolDefinition$ToolCase[] values() {
        return (ToolDefinition$ToolCase[]) e.clone();
    }
}
