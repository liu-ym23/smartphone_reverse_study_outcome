package com.zyql.protobuf.agent;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.agent.ToolDefinition;

/* loaded from: classes4.dex */
public interface ToolDefinitionOrBuilder extends MessageLiteOrBuilder {
    AgentTool getAgentTool();

    McpTool getMcpTool();

    ToolDefinition.ToolCase getToolCase();

    ToolProvider getToolProvider();

    boolean hasAgentTool();

    boolean hasMcpTool();

    boolean hasToolProvider();
}
