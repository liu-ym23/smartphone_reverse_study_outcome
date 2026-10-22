package com.zyql.protobuf.agent;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1764C;
import o7.C1767c;
import o7.t;
import o7.z;

/* loaded from: classes2.dex */
public final class ToolDefinition$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolDefinition$Builder(int i) {
        this();
    }

    public ToolDefinition$Builder clearAgentTool() {
        copyOnWrite();
        z.D((z) this.instance);
        return this;
    }

    public ToolDefinition$Builder clearMcpTool() {
        copyOnWrite();
        z.E((z) this.instance);
        return this;
    }

    public ToolDefinition$Builder clearTool() {
        copyOnWrite();
        z.F((z) this.instance);
        return this;
    }

    public ToolDefinition$Builder clearToolProvider() {
        copyOnWrite();
        z.G((z) this.instance);
        return this;
    }

    public C1767c getAgentTool() {
        return ((z) this.instance).O();
    }

    public t getMcpTool() {
        return ((z) this.instance).P();
    }

    public ToolDefinition$ToolCase getToolCase() {
        return ((z) this.instance).Q();
    }

    public C1764C getToolProvider() {
        return ((z) this.instance).R();
    }

    public boolean hasAgentTool() {
        return ((z) this.instance).S();
    }

    public boolean hasMcpTool() {
        return ((z) this.instance).T();
    }

    public boolean hasToolProvider() {
        return ((z) this.instance).U();
    }

    public ToolDefinition$Builder mergeAgentTool(C1767c c1767c) {
        copyOnWrite();
        z.H((z) this.instance, c1767c);
        return this;
    }

    public ToolDefinition$Builder mergeMcpTool(t tVar) {
        copyOnWrite();
        z.I((z) this.instance, tVar);
        return this;
    }

    public ToolDefinition$Builder mergeToolProvider(C1764C c1764c) {
        copyOnWrite();
        z.J((z) this.instance, c1764c);
        return this;
    }

    public ToolDefinition$Builder setAgentTool(C1767c c1767c) {
        copyOnWrite();
        z.K((z) this.instance, c1767c);
        return this;
    }

    public ToolDefinition$Builder setMcpTool(t tVar) {
        copyOnWrite();
        z.L((z) this.instance, tVar);
        return this;
    }

    public ToolDefinition$Builder setToolProvider(C1764C c1764c) {
        copyOnWrite();
        z.M((z) this.instance, c1764c);
        return this;
    }

    private ToolDefinition$Builder() {
        super(z.DEFAULT_INSTANCE);
    }

    public ToolDefinition$Builder setAgentTool(AgentTool$Builder agentTool$Builder) {
        copyOnWrite();
        z.K((z) this.instance, (C1767c) agentTool$Builder.k());
        return this;
    }

    public ToolDefinition$Builder setMcpTool(McpTool$Builder mcpTool$Builder) {
        copyOnWrite();
        z.L((z) this.instance, (t) mcpTool$Builder.k());
        return this;
    }

    public ToolDefinition$Builder setToolProvider(ToolProvider$Builder toolProvider$Builder) {
        copyOnWrite();
        z.M((z) this.instance, (C1764C) toolProvider$Builder.k());
        return this;
    }
}
