package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.common.HookDefinition;
import java.util.List;

/* loaded from: classes4.dex */
public interface AgentInfoOrBuilder extends MessageLiteOrBuilder {
    String getAgentId();

    ByteString getAgentIdBytes();

    String getDescription();

    ByteString getDescriptionBytes();

    HookDefinition getHooks(int i10);

    int getHooksCount();

    List<HookDefinition> getHooksList();

    String getInstructions();

    ByteString getInstructionsBytes();

    ModelConfig getModelConfig();

    String getName();

    ByteString getNameBytes();

    Skill getSkills(int i10);

    int getSkillsCount();

    List<Skill> getSkillsList();

    AgentInfo getSubAgents(int i10);

    int getSubAgentsCount();

    List<AgentInfo> getSubAgentsList();

    ToolDefinition getTools(int i10);

    int getToolsCount();

    List<ToolDefinition> getToolsList();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasModelConfig();
}
