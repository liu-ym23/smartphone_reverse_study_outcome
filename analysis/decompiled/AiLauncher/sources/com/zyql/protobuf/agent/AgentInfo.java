package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.ModelConfig;
import com.zyql.protobuf.agent.Skill;
import com.zyql.protobuf.agent.ToolDefinition;
import com.zyql.protobuf.common.HookDefinition;
import com.zyql.protobuf.common.HookDefinitionOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class AgentInfo extends GeneratedMessageLite<AgentInfo, Builder> implements AgentInfoOrBuilder {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    private static final AgentInfo DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int HOOKS_FIELD_NUMBER = 10;
    public static final int INSTRUCTIONS_FIELD_NUMBER = 6;
    public static final int MODEL_CONFIG_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<AgentInfo> PARSER = null;
    public static final int SKILLS_FIELD_NUMBER = 11;
    public static final int SUB_AGENTS_FIELD_NUMBER = 7;
    public static final int TOOLS_FIELD_NUMBER = 8;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int bitField0_;
    private ModelConfig modelConfig_;
    private String agentId_ = "";
    private String name_ = "";
    private String version_ = "";
    private String description_ = "";
    private String instructions_ = "";
    private Internal.ProtobufList<AgentInfo> subAgents_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<ToolDefinition> tools_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<HookDefinition> hooks_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<Skill> skills_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.agent.AgentInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AgentInfo, Builder> implements AgentInfoOrBuilder {
        public Builder addAllHooks(Iterable<? extends HookDefinition> iterable) {
            copyOnWrite();
            ((AgentInfo) this.instance).addAllHooks(iterable);
            return this;
        }

        public Builder addAllSkills(Iterable<? extends Skill> iterable) {
            copyOnWrite();
            ((AgentInfo) this.instance).addAllSkills(iterable);
            return this;
        }

        public Builder addAllSubAgents(Iterable<? extends AgentInfo> iterable) {
            copyOnWrite();
            ((AgentInfo) this.instance).addAllSubAgents(iterable);
            return this;
        }

        public Builder addAllTools(Iterable<? extends ToolDefinition> iterable) {
            copyOnWrite();
            ((AgentInfo) this.instance).addAllTools(iterable);
            return this;
        }

        public Builder addHooks(HookDefinition hookDefinition) {
            copyOnWrite();
            ((AgentInfo) this.instance).addHooks(hookDefinition);
            return this;
        }

        public Builder addSkills(Skill skill) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSkills(skill);
            return this;
        }

        public Builder addSubAgents(AgentInfo agentInfo) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSubAgents(agentInfo);
            return this;
        }

        public Builder addTools(ToolDefinition toolDefinition) {
            copyOnWrite();
            ((AgentInfo) this.instance).addTools(toolDefinition);
            return this;
        }

        public Builder clearAgentId() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearAgentId();
            return this;
        }

        public Builder clearDescription() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearDescription();
            return this;
        }

        public Builder clearHooks() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearHooks();
            return this;
        }

        public Builder clearInstructions() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearInstructions();
            return this;
        }

        public Builder clearModelConfig() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearModelConfig();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearName();
            return this;
        }

        public Builder clearSkills() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearSkills();
            return this;
        }

        public Builder clearSubAgents() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearSubAgents();
            return this;
        }

        public Builder clearTools() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearTools();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AgentInfo) this.instance).clearVersion();
            return this;
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public String getAgentId() {
            return ((AgentInfo) this.instance).getAgentId();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public ByteString getAgentIdBytes() {
            return ((AgentInfo) this.instance).getAgentIdBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public String getDescription() {
            return ((AgentInfo) this.instance).getDescription();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public ByteString getDescriptionBytes() {
            return ((AgentInfo) this.instance).getDescriptionBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public HookDefinition getHooks(int i10) {
            return ((AgentInfo) this.instance).getHooks(i10);
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public int getHooksCount() {
            return ((AgentInfo) this.instance).getHooksCount();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public List<HookDefinition> getHooksList() {
            return Collections.unmodifiableList(((AgentInfo) this.instance).getHooksList());
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public String getInstructions() {
            return ((AgentInfo) this.instance).getInstructions();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public ByteString getInstructionsBytes() {
            return ((AgentInfo) this.instance).getInstructionsBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public ModelConfig getModelConfig() {
            return ((AgentInfo) this.instance).getModelConfig();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public String getName() {
            return ((AgentInfo) this.instance).getName();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public ByteString getNameBytes() {
            return ((AgentInfo) this.instance).getNameBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public Skill getSkills(int i10) {
            return ((AgentInfo) this.instance).getSkills(i10);
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public int getSkillsCount() {
            return ((AgentInfo) this.instance).getSkillsCount();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public List<Skill> getSkillsList() {
            return Collections.unmodifiableList(((AgentInfo) this.instance).getSkillsList());
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public AgentInfo getSubAgents(int i10) {
            return ((AgentInfo) this.instance).getSubAgents(i10);
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public int getSubAgentsCount() {
            return ((AgentInfo) this.instance).getSubAgentsCount();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public List<AgentInfo> getSubAgentsList() {
            return Collections.unmodifiableList(((AgentInfo) this.instance).getSubAgentsList());
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public ToolDefinition getTools(int i10) {
            return ((AgentInfo) this.instance).getTools(i10);
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public int getToolsCount() {
            return ((AgentInfo) this.instance).getToolsCount();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public List<ToolDefinition> getToolsList() {
            return Collections.unmodifiableList(((AgentInfo) this.instance).getToolsList());
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public String getVersion() {
            return ((AgentInfo) this.instance).getVersion();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public ByteString getVersionBytes() {
            return ((AgentInfo) this.instance).getVersionBytes();
        }

        @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
        public boolean hasModelConfig() {
            return ((AgentInfo) this.instance).hasModelConfig();
        }

        public Builder mergeModelConfig(ModelConfig modelConfig) {
            copyOnWrite();
            ((AgentInfo) this.instance).mergeModelConfig(modelConfig);
            return this;
        }

        public Builder removeHooks(int i10) {
            copyOnWrite();
            ((AgentInfo) this.instance).removeHooks(i10);
            return this;
        }

        public Builder removeSkills(int i10) {
            copyOnWrite();
            ((AgentInfo) this.instance).removeSkills(i10);
            return this;
        }

        public Builder removeSubAgents(int i10) {
            copyOnWrite();
            ((AgentInfo) this.instance).removeSubAgents(i10);
            return this;
        }

        public Builder removeTools(int i10) {
            copyOnWrite();
            ((AgentInfo) this.instance).removeTools(i10);
            return this;
        }

        public Builder setAgentId(String str) {
            copyOnWrite();
            ((AgentInfo) this.instance).setAgentId(str);
            return this;
        }

        public Builder setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentInfo) this.instance).setAgentIdBytes(byteString);
            return this;
        }

        public Builder setDescription(String str) {
            copyOnWrite();
            ((AgentInfo) this.instance).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentInfo) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setHooks(int i10, HookDefinition hookDefinition) {
            copyOnWrite();
            ((AgentInfo) this.instance).setHooks(i10, hookDefinition);
            return this;
        }

        public Builder setInstructions(String str) {
            copyOnWrite();
            ((AgentInfo) this.instance).setInstructions(str);
            return this;
        }

        public Builder setInstructionsBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentInfo) this.instance).setInstructionsBytes(byteString);
            return this;
        }

        public Builder setModelConfig(ModelConfig modelConfig) {
            copyOnWrite();
            ((AgentInfo) this.instance).setModelConfig(modelConfig);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((AgentInfo) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentInfo) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setSkills(int i10, Skill skill) {
            copyOnWrite();
            ((AgentInfo) this.instance).setSkills(i10, skill);
            return this;
        }

        public Builder setSubAgents(int i10, AgentInfo agentInfo) {
            copyOnWrite();
            ((AgentInfo) this.instance).setSubAgents(i10, agentInfo);
            return this;
        }

        public Builder setTools(int i10, ToolDefinition toolDefinition) {
            copyOnWrite();
            ((AgentInfo) this.instance).setTools(i10, toolDefinition);
            return this;
        }

        public Builder setVersion(String str) {
            copyOnWrite();
            ((AgentInfo) this.instance).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((AgentInfo) this.instance).setVersionBytes(byteString);
            return this;
        }

        private Builder() {
            super(AgentInfo.DEFAULT_INSTANCE);
        }

        public Builder addHooks(int i10, HookDefinition hookDefinition) {
            copyOnWrite();
            ((AgentInfo) this.instance).addHooks(i10, hookDefinition);
            return this;
        }

        public Builder addSkills(int i10, Skill skill) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSkills(i10, skill);
            return this;
        }

        public Builder addSubAgents(int i10, AgentInfo agentInfo) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSubAgents(i10, agentInfo);
            return this;
        }

        public Builder addTools(int i10, ToolDefinition toolDefinition) {
            copyOnWrite();
            ((AgentInfo) this.instance).addTools(i10, toolDefinition);
            return this;
        }

        public Builder setHooks(int i10, HookDefinition.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).setHooks(i10, builder.build());
            return this;
        }

        public Builder setModelConfig(ModelConfig.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).setModelConfig(builder.build());
            return this;
        }

        public Builder setSkills(int i10, Skill.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).setSkills(i10, builder.build());
            return this;
        }

        public Builder setSubAgents(int i10, Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).setSubAgents(i10, builder.build());
            return this;
        }

        public Builder setTools(int i10, ToolDefinition.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).setTools(i10, builder.build());
            return this;
        }

        public Builder addHooks(HookDefinition.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addHooks(builder.build());
            return this;
        }

        public Builder addSkills(Skill.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSkills(builder.build());
            return this;
        }

        public Builder addSubAgents(Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSubAgents(builder.build());
            return this;
        }

        public Builder addTools(ToolDefinition.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addTools(builder.build());
            return this;
        }

        public Builder addHooks(int i10, HookDefinition.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addHooks(i10, builder.build());
            return this;
        }

        public Builder addSkills(int i10, Skill.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSkills(i10, builder.build());
            return this;
        }

        public Builder addSubAgents(int i10, Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addSubAgents(i10, builder.build());
            return this;
        }

        public Builder addTools(int i10, ToolDefinition.Builder builder) {
            copyOnWrite();
            ((AgentInfo) this.instance).addTools(i10, builder.build());
            return this;
        }
    }

    static {
        AgentInfo agentInfo = new AgentInfo();
        DEFAULT_INSTANCE = agentInfo;
        GeneratedMessageLite.registerDefaultInstance(AgentInfo.class, agentInfo);
    }

    private AgentInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllHooks(Iterable<? extends HookDefinition> iterable) {
        ensureHooksIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.hooks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSkills(Iterable<? extends Skill> iterable) {
        ensureSkillsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.skills_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubAgents(Iterable<? extends AgentInfo> iterable) {
        ensureSubAgentsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.subAgents_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTools(Iterable<? extends ToolDefinition> iterable) {
        ensureToolsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.tools_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHooks(HookDefinition hookDefinition) {
        hookDefinition.getClass();
        ensureHooksIsMutable();
        this.hooks_.add(hookDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSkills(Skill skill) {
        skill.getClass();
        ensureSkillsIsMutable();
        this.skills_.add(skill);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubAgents(AgentInfo agentInfo) {
        agentInfo.getClass();
        ensureSubAgentsIsMutable();
        this.subAgents_.add(agentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTools(ToolDefinition toolDefinition) {
        toolDefinition.getClass();
        ensureToolsIsMutable();
        this.tools_.add(toolDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHooks() {
        this.hooks_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInstructions() {
        this.instructions_ = getDefaultInstance().getInstructions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModelConfig() {
        this.modelConfig_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkills() {
        this.skills_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubAgents() {
        this.subAgents_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTools() {
        this.tools_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    private void ensureHooksIsMutable() {
        Internal.ProtobufList<HookDefinition> protobufList = this.hooks_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.hooks_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSkillsIsMutable() {
        Internal.ProtobufList<Skill> protobufList = this.skills_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.skills_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSubAgentsIsMutable() {
        Internal.ProtobufList<AgentInfo> protobufList = this.subAgents_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.subAgents_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureToolsIsMutable() {
        Internal.ProtobufList<ToolDefinition> protobufList = this.tools_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.tools_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static AgentInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeModelConfig(ModelConfig modelConfig) {
        modelConfig.getClass();
        ModelConfig modelConfig2 = this.modelConfig_;
        if (modelConfig2 == null || modelConfig2 == ModelConfig.getDefaultInstance()) {
            this.modelConfig_ = modelConfig;
        } else {
            this.modelConfig_ = ModelConfig.newBuilder(this.modelConfig_).mergeFrom((ModelConfig.Builder) modelConfig).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AgentInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgentInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AgentInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeHooks(int i10) {
        ensureHooksIsMutable();
        this.hooks_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSkills(int i10) {
        ensureSkillsIsMutable();
        this.skills_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSubAgents(int i10) {
        ensureSubAgentsIsMutable();
        this.subAgents_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTools(int i10) {
        ensureToolsIsMutable();
        this.tools_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentId(String str) {
        str.getClass();
        this.agentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.agentId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHooks(int i10, HookDefinition hookDefinition) {
        hookDefinition.getClass();
        ensureHooksIsMutable();
        this.hooks_.set(i10, hookDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInstructions(String str) {
        str.getClass();
        this.instructions_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInstructionsBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.instructions_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelConfig(ModelConfig modelConfig) {
        modelConfig.getClass();
        this.modelConfig_ = modelConfig;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkills(int i10, Skill skill) {
        skill.getClass();
        ensureSkillsIsMutable();
        this.skills_.set(i10, skill);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubAgents(int i10, AgentInfo agentInfo) {
        agentInfo.getClass();
        ensureSubAgentsIsMutable();
        this.subAgents_.set(i10, agentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTools(int i10, ToolDefinition toolDefinition) {
        toolDefinition.getClass();
        ensureToolsIsMutable();
        this.tools_.set(i10, toolDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.version_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AgentInfo();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\u000b\n\u0000\u0004\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005ဉ\u0000\u0006Ȉ\u0007\u001b\b\u001b\n\u001b\u000b\u001b", new Object[]{"bitField0_", "agentId_", "name_", "version_", "description_", "modelConfig_", "instructions_", "subAgents_", AgentInfo.class, "tools_", ToolDefinition.class, "hooks_", HookDefinition.class, "skills_", Skill.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AgentInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AgentInfo.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public String getAgentId() {
        return this.agentId_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public ByteString getAgentIdBytes() {
        return ByteString.copyFromUtf8(this.agentId_);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public HookDefinition getHooks(int i10) {
        return this.hooks_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public int getHooksCount() {
        return this.hooks_.size();
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public List<HookDefinition> getHooksList() {
        return this.hooks_;
    }

    public HookDefinitionOrBuilder getHooksOrBuilder(int i10) {
        return this.hooks_.get(i10);
    }

    public List<? extends HookDefinitionOrBuilder> getHooksOrBuilderList() {
        return this.hooks_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public String getInstructions() {
        return this.instructions_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public ByteString getInstructionsBytes() {
        return ByteString.copyFromUtf8(this.instructions_);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public ModelConfig getModelConfig() {
        ModelConfig modelConfig = this.modelConfig_;
        return modelConfig == null ? ModelConfig.getDefaultInstance() : modelConfig;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public Skill getSkills(int i10) {
        return this.skills_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public int getSkillsCount() {
        return this.skills_.size();
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public List<Skill> getSkillsList() {
        return this.skills_;
    }

    public SkillOrBuilder getSkillsOrBuilder(int i10) {
        return this.skills_.get(i10);
    }

    public List<? extends SkillOrBuilder> getSkillsOrBuilderList() {
        return this.skills_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public AgentInfo getSubAgents(int i10) {
        return this.subAgents_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public int getSubAgentsCount() {
        return this.subAgents_.size();
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public List<AgentInfo> getSubAgentsList() {
        return this.subAgents_;
    }

    public AgentInfoOrBuilder getSubAgentsOrBuilder(int i10) {
        return this.subAgents_.get(i10);
    }

    public List<? extends AgentInfoOrBuilder> getSubAgentsOrBuilderList() {
        return this.subAgents_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public ToolDefinition getTools(int i10) {
        return this.tools_.get(i10);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public int getToolsCount() {
        return this.tools_.size();
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public List<ToolDefinition> getToolsList() {
        return this.tools_;
    }

    public ToolDefinitionOrBuilder getToolsOrBuilder(int i10) {
        return this.tools_.get(i10);
    }

    public List<? extends ToolDefinitionOrBuilder> getToolsOrBuilderList() {
        return this.tools_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    @Override // com.zyql.protobuf.agent.AgentInfoOrBuilder
    public boolean hasModelConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(AgentInfo agentInfo) {
        return DEFAULT_INSTANCE.createBuilder(agentInfo);
    }

    public static AgentInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AgentInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHooks(int i10, HookDefinition hookDefinition) {
        hookDefinition.getClass();
        ensureHooksIsMutable();
        this.hooks_.add(i10, hookDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSkills(int i10, Skill skill) {
        skill.getClass();
        ensureSkillsIsMutable();
        this.skills_.add(i10, skill);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubAgents(int i10, AgentInfo agentInfo) {
        agentInfo.getClass();
        ensureSubAgentsIsMutable();
        this.subAgents_.add(i10, agentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTools(int i10, ToolDefinition toolDefinition) {
        toolDefinition.getClass();
        ensureToolsIsMutable();
        this.tools_.add(i10, toolDefinition);
    }

    public static AgentInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AgentInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AgentInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AgentInfo parseFrom(InputStream inputStream) throws IOException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AgentInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AgentInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AgentInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
