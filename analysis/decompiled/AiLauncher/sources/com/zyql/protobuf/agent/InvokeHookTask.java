package com.zyql.protobuf.agent;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.common.AgentCompleteHookData;
import com.zyql.protobuf.common.AgentStartHookData;
import com.zyql.protobuf.common.HandoffPostHookData;
import com.zyql.protobuf.common.HandoffPreHookData;
import com.zyql.protobuf.common.MessagePostHookData;
import com.zyql.protobuf.common.MessagePreHookData;
import com.zyql.protobuf.common.ModelCallPostHookData;
import com.zyql.protobuf.common.ModelCallPreHookData;
import com.zyql.protobuf.common.SessionEndHookData;
import com.zyql.protobuf.common.SessionStartHookData;
import com.zyql.protobuf.common.ToolCallErrorHookData;
import com.zyql.protobuf.common.ToolCallPostHookData;
import com.zyql.protobuf.common.ToolCallPreHookData;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class InvokeHookTask extends GeneratedMessageLite<InvokeHookTask, Builder> implements InvokeHookTaskOrBuilder {
    public static final int AGENT_COMPLETE_FIELD_NUMBER = 41;
    public static final int AGENT_START_FIELD_NUMBER = 40;
    private static final InvokeHookTask DEFAULT_INSTANCE;
    public static final int HANDOFF_POST_FIELD_NUMBER = 51;
    public static final int HANDOFF_PRE_FIELD_NUMBER = 50;
    public static final int MESSAGE_POST_FIELD_NUMBER = 61;
    public static final int MESSAGE_PRE_FIELD_NUMBER = 60;
    public static final int MODEL_CALL_POST_FIELD_NUMBER = 31;
    public static final int MODEL_CALL_PRE_FIELD_NUMBER = 30;
    private static volatile Parser<InvokeHookTask> PARSER = null;
    public static final int SESSION_END_FIELD_NUMBER = 11;
    public static final int SESSION_START_FIELD_NUMBER = 10;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int TOOL_CALL_ERROR_FIELD_NUMBER = 22;
    public static final int TOOL_CALL_POST_FIELD_NUMBER = 21;
    public static final int TOOL_CALL_PRE_FIELD_NUMBER = 20;
    private Object hookData_;
    private int hookDataCase_ = 0;
    private String taskId_ = "";

    /* renamed from: com.zyql.protobuf.agent.InvokeHookTask$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<InvokeHookTask, Builder> implements InvokeHookTaskOrBuilder {
        public Builder clearAgentComplete() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearAgentComplete();
            return this;
        }

        public Builder clearAgentStart() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearAgentStart();
            return this;
        }

        public Builder clearHandoffPost() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearHandoffPost();
            return this;
        }

        public Builder clearHandoffPre() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearHandoffPre();
            return this;
        }

        public Builder clearHookData() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearHookData();
            return this;
        }

        public Builder clearMessagePost() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearMessagePost();
            return this;
        }

        public Builder clearMessagePre() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearMessagePre();
            return this;
        }

        public Builder clearModelCallPost() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearModelCallPost();
            return this;
        }

        public Builder clearModelCallPre() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearModelCallPre();
            return this;
        }

        public Builder clearSessionEnd() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearSessionEnd();
            return this;
        }

        public Builder clearSessionStart() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearSessionStart();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearTaskId();
            return this;
        }

        public Builder clearToolCallError() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearToolCallError();
            return this;
        }

        public Builder clearToolCallPost() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearToolCallPost();
            return this;
        }

        public Builder clearToolCallPre() {
            copyOnWrite();
            ((InvokeHookTask) this.instance).clearToolCallPre();
            return this;
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public AgentCompleteHookData getAgentComplete() {
            return ((InvokeHookTask) this.instance).getAgentComplete();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public AgentStartHookData getAgentStart() {
            return ((InvokeHookTask) this.instance).getAgentStart();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public HandoffPostHookData getHandoffPost() {
            return ((InvokeHookTask) this.instance).getHandoffPost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public HandoffPreHookData getHandoffPre() {
            return ((InvokeHookTask) this.instance).getHandoffPre();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public HookDataCase getHookDataCase() {
            return ((InvokeHookTask) this.instance).getHookDataCase();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public MessagePostHookData getMessagePost() {
            return ((InvokeHookTask) this.instance).getMessagePost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public MessagePreHookData getMessagePre() {
            return ((InvokeHookTask) this.instance).getMessagePre();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public ModelCallPostHookData getModelCallPost() {
            return ((InvokeHookTask) this.instance).getModelCallPost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public ModelCallPreHookData getModelCallPre() {
            return ((InvokeHookTask) this.instance).getModelCallPre();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public SessionEndHookData getSessionEnd() {
            return ((InvokeHookTask) this.instance).getSessionEnd();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public SessionStartHookData getSessionStart() {
            return ((InvokeHookTask) this.instance).getSessionStart();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public String getTaskId() {
            return ((InvokeHookTask) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public ByteString getTaskIdBytes() {
            return ((InvokeHookTask) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public ToolCallErrorHookData getToolCallError() {
            return ((InvokeHookTask) this.instance).getToolCallError();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public ToolCallPostHookData getToolCallPost() {
            return ((InvokeHookTask) this.instance).getToolCallPost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public ToolCallPreHookData getToolCallPre() {
            return ((InvokeHookTask) this.instance).getToolCallPre();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasAgentComplete() {
            return ((InvokeHookTask) this.instance).hasAgentComplete();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasAgentStart() {
            return ((InvokeHookTask) this.instance).hasAgentStart();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasHandoffPost() {
            return ((InvokeHookTask) this.instance).hasHandoffPost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasHandoffPre() {
            return ((InvokeHookTask) this.instance).hasHandoffPre();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasMessagePost() {
            return ((InvokeHookTask) this.instance).hasMessagePost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasMessagePre() {
            return ((InvokeHookTask) this.instance).hasMessagePre();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasModelCallPost() {
            return ((InvokeHookTask) this.instance).hasModelCallPost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasModelCallPre() {
            return ((InvokeHookTask) this.instance).hasModelCallPre();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasSessionEnd() {
            return ((InvokeHookTask) this.instance).hasSessionEnd();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasSessionStart() {
            return ((InvokeHookTask) this.instance).hasSessionStart();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasToolCallError() {
            return ((InvokeHookTask) this.instance).hasToolCallError();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasToolCallPost() {
            return ((InvokeHookTask) this.instance).hasToolCallPost();
        }

        @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
        public boolean hasToolCallPre() {
            return ((InvokeHookTask) this.instance).hasToolCallPre();
        }

        public Builder mergeAgentComplete(AgentCompleteHookData agentCompleteHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeAgentComplete(agentCompleteHookData);
            return this;
        }

        public Builder mergeAgentStart(AgentStartHookData agentStartHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeAgentStart(agentStartHookData);
            return this;
        }

        public Builder mergeHandoffPost(HandoffPostHookData handoffPostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeHandoffPost(handoffPostHookData);
            return this;
        }

        public Builder mergeHandoffPre(HandoffPreHookData handoffPreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeHandoffPre(handoffPreHookData);
            return this;
        }

        public Builder mergeMessagePost(MessagePostHookData messagePostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeMessagePost(messagePostHookData);
            return this;
        }

        public Builder mergeMessagePre(MessagePreHookData messagePreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeMessagePre(messagePreHookData);
            return this;
        }

        public Builder mergeModelCallPost(ModelCallPostHookData modelCallPostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeModelCallPost(modelCallPostHookData);
            return this;
        }

        public Builder mergeModelCallPre(ModelCallPreHookData modelCallPreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeModelCallPre(modelCallPreHookData);
            return this;
        }

        public Builder mergeSessionEnd(SessionEndHookData sessionEndHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeSessionEnd(sessionEndHookData);
            return this;
        }

        public Builder mergeSessionStart(SessionStartHookData sessionStartHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeSessionStart(sessionStartHookData);
            return this;
        }

        public Builder mergeToolCallError(ToolCallErrorHookData toolCallErrorHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeToolCallError(toolCallErrorHookData);
            return this;
        }

        public Builder mergeToolCallPost(ToolCallPostHookData toolCallPostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeToolCallPost(toolCallPostHookData);
            return this;
        }

        public Builder mergeToolCallPre(ToolCallPreHookData toolCallPreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).mergeToolCallPre(toolCallPreHookData);
            return this;
        }

        public Builder setAgentComplete(AgentCompleteHookData agentCompleteHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setAgentComplete(agentCompleteHookData);
            return this;
        }

        public Builder setAgentStart(AgentStartHookData agentStartHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setAgentStart(agentStartHookData);
            return this;
        }

        public Builder setHandoffPost(HandoffPostHookData handoffPostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setHandoffPost(handoffPostHookData);
            return this;
        }

        public Builder setHandoffPre(HandoffPreHookData handoffPreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setHandoffPre(handoffPreHookData);
            return this;
        }

        public Builder setMessagePost(MessagePostHookData messagePostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setMessagePost(messagePostHookData);
            return this;
        }

        public Builder setMessagePre(MessagePreHookData messagePreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setMessagePre(messagePreHookData);
            return this;
        }

        public Builder setModelCallPost(ModelCallPostHookData modelCallPostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setModelCallPost(modelCallPostHookData);
            return this;
        }

        public Builder setModelCallPre(ModelCallPreHookData modelCallPreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setModelCallPre(modelCallPreHookData);
            return this;
        }

        public Builder setSessionEnd(SessionEndHookData sessionEndHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setSessionEnd(sessionEndHookData);
            return this;
        }

        public Builder setSessionStart(SessionStartHookData sessionStartHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setSessionStart(sessionStartHookData);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        public Builder setToolCallError(ToolCallErrorHookData toolCallErrorHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setToolCallError(toolCallErrorHookData);
            return this;
        }

        public Builder setToolCallPost(ToolCallPostHookData toolCallPostHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setToolCallPost(toolCallPostHookData);
            return this;
        }

        public Builder setToolCallPre(ToolCallPreHookData toolCallPreHookData) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setToolCallPre(toolCallPreHookData);
            return this;
        }

        private Builder() {
            super(InvokeHookTask.DEFAULT_INSTANCE);
        }

        public Builder setAgentComplete(AgentCompleteHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setAgentComplete(builder.build());
            return this;
        }

        public Builder setAgentStart(AgentStartHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setAgentStart(builder.build());
            return this;
        }

        public Builder setHandoffPost(HandoffPostHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setHandoffPost(builder.build());
            return this;
        }

        public Builder setHandoffPre(HandoffPreHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setHandoffPre(builder.build());
            return this;
        }

        public Builder setMessagePost(MessagePostHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setMessagePost(builder.build());
            return this;
        }

        public Builder setMessagePre(MessagePreHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setMessagePre(builder.build());
            return this;
        }

        public Builder setModelCallPost(ModelCallPostHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setModelCallPost(builder.build());
            return this;
        }

        public Builder setModelCallPre(ModelCallPreHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setModelCallPre(builder.build());
            return this;
        }

        public Builder setSessionEnd(SessionEndHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setSessionEnd(builder.build());
            return this;
        }

        public Builder setSessionStart(SessionStartHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setSessionStart(builder.build());
            return this;
        }

        public Builder setToolCallError(ToolCallErrorHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setToolCallError(builder.build());
            return this;
        }

        public Builder setToolCallPost(ToolCallPostHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setToolCallPost(builder.build());
            return this;
        }

        public Builder setToolCallPre(ToolCallPreHookData.Builder builder) {
            copyOnWrite();
            ((InvokeHookTask) this.instance).setToolCallPre(builder.build());
            return this;
        }
    }

    public enum HookDataCase {
        SESSION_START(10),
        SESSION_END(11),
        TOOL_CALL_PRE(20),
        TOOL_CALL_POST(21),
        TOOL_CALL_ERROR(22),
        MODEL_CALL_PRE(30),
        MODEL_CALL_POST(31),
        AGENT_START(40),
        AGENT_COMPLETE(41),
        HANDOFF_PRE(50),
        HANDOFF_POST(51),
        MESSAGE_PRE(60),
        MESSAGE_POST(61),
        HOOKDATA_NOT_SET(0);

        private final int value;

        HookDataCase(int i10) {
            this.value = i10;
        }

        public static HookDataCase forNumber(int i10) {
            if (i10 == 0) {
                return HOOKDATA_NOT_SET;
            }
            if (i10 == 10) {
                return SESSION_START;
            }
            if (i10 == 11) {
                return SESSION_END;
            }
            if (i10 == 30) {
                return MODEL_CALL_PRE;
            }
            if (i10 == 31) {
                return MODEL_CALL_POST;
            }
            if (i10 == 40) {
                return AGENT_START;
            }
            if (i10 == 41) {
                return AGENT_COMPLETE;
            }
            if (i10 == 50) {
                return HANDOFF_PRE;
            }
            if (i10 == 51) {
                return HANDOFF_POST;
            }
            if (i10 == 60) {
                return MESSAGE_PRE;
            }
            if (i10 == 61) {
                return MESSAGE_POST;
            }
            switch (i10) {
                case 20:
                    return TOOL_CALL_PRE;
                case 21:
                    return TOOL_CALL_POST;
                case 22:
                    return TOOL_CALL_ERROR;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static HookDataCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        InvokeHookTask invokeHookTask = new InvokeHookTask();
        DEFAULT_INSTANCE = invokeHookTask;
        GeneratedMessageLite.registerDefaultInstance(InvokeHookTask.class, invokeHookTask);
    }

    private InvokeHookTask() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentComplete() {
        if (this.hookDataCase_ == 41) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentStart() {
        if (this.hookDataCase_ == 40) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHandoffPost() {
        if (this.hookDataCase_ == 51) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHandoffPre() {
        if (this.hookDataCase_ == 50) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHookData() {
        this.hookDataCase_ = 0;
        this.hookData_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessagePost() {
        if (this.hookDataCase_ == 61) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessagePre() {
        if (this.hookDataCase_ == 60) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModelCallPost() {
        if (this.hookDataCase_ == 31) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModelCallPre() {
        if (this.hookDataCase_ == 30) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionEnd() {
        if (this.hookDataCase_ == 11) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionStart() {
        if (this.hookDataCase_ == 10) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCallError() {
        if (this.hookDataCase_ == 22) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCallPost() {
        if (this.hookDataCase_ == 21) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCallPre() {
        if (this.hookDataCase_ == 20) {
            this.hookDataCase_ = 0;
            this.hookData_ = null;
        }
    }

    public static InvokeHookTask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAgentComplete(AgentCompleteHookData agentCompleteHookData) {
        agentCompleteHookData.getClass();
        if (this.hookDataCase_ != 41 || this.hookData_ == AgentCompleteHookData.getDefaultInstance()) {
            this.hookData_ = agentCompleteHookData;
        } else {
            this.hookData_ = AgentCompleteHookData.newBuilder((AgentCompleteHookData) this.hookData_).mergeFrom((AgentCompleteHookData.Builder) agentCompleteHookData).buildPartial();
        }
        this.hookDataCase_ = 41;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAgentStart(AgentStartHookData agentStartHookData) {
        agentStartHookData.getClass();
        if (this.hookDataCase_ != 40 || this.hookData_ == AgentStartHookData.getDefaultInstance()) {
            this.hookData_ = agentStartHookData;
        } else {
            this.hookData_ = AgentStartHookData.newBuilder((AgentStartHookData) this.hookData_).mergeFrom((AgentStartHookData.Builder) agentStartHookData).buildPartial();
        }
        this.hookDataCase_ = 40;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHandoffPost(HandoffPostHookData handoffPostHookData) {
        handoffPostHookData.getClass();
        if (this.hookDataCase_ != 51 || this.hookData_ == HandoffPostHookData.getDefaultInstance()) {
            this.hookData_ = handoffPostHookData;
        } else {
            this.hookData_ = HandoffPostHookData.newBuilder((HandoffPostHookData) this.hookData_).mergeFrom((HandoffPostHookData.Builder) handoffPostHookData).buildPartial();
        }
        this.hookDataCase_ = 51;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHandoffPre(HandoffPreHookData handoffPreHookData) {
        handoffPreHookData.getClass();
        if (this.hookDataCase_ != 50 || this.hookData_ == HandoffPreHookData.getDefaultInstance()) {
            this.hookData_ = handoffPreHookData;
        } else {
            this.hookData_ = HandoffPreHookData.newBuilder((HandoffPreHookData) this.hookData_).mergeFrom((HandoffPreHookData.Builder) handoffPreHookData).buildPartial();
        }
        this.hookDataCase_ = 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessagePost(MessagePostHookData messagePostHookData) {
        messagePostHookData.getClass();
        if (this.hookDataCase_ != 61 || this.hookData_ == MessagePostHookData.getDefaultInstance()) {
            this.hookData_ = messagePostHookData;
        } else {
            this.hookData_ = MessagePostHookData.newBuilder((MessagePostHookData) this.hookData_).mergeFrom((MessagePostHookData.Builder) messagePostHookData).buildPartial();
        }
        this.hookDataCase_ = 61;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessagePre(MessagePreHookData messagePreHookData) {
        messagePreHookData.getClass();
        if (this.hookDataCase_ != 60 || this.hookData_ == MessagePreHookData.getDefaultInstance()) {
            this.hookData_ = messagePreHookData;
        } else {
            this.hookData_ = MessagePreHookData.newBuilder((MessagePreHookData) this.hookData_).mergeFrom((MessagePreHookData.Builder) messagePreHookData).buildPartial();
        }
        this.hookDataCase_ = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeModelCallPost(ModelCallPostHookData modelCallPostHookData) {
        modelCallPostHookData.getClass();
        if (this.hookDataCase_ != 31 || this.hookData_ == ModelCallPostHookData.getDefaultInstance()) {
            this.hookData_ = modelCallPostHookData;
        } else {
            this.hookData_ = ModelCallPostHookData.newBuilder((ModelCallPostHookData) this.hookData_).mergeFrom((ModelCallPostHookData.Builder) modelCallPostHookData).buildPartial();
        }
        this.hookDataCase_ = 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeModelCallPre(ModelCallPreHookData modelCallPreHookData) {
        modelCallPreHookData.getClass();
        if (this.hookDataCase_ != 30 || this.hookData_ == ModelCallPreHookData.getDefaultInstance()) {
            this.hookData_ = modelCallPreHookData;
        } else {
            this.hookData_ = ModelCallPreHookData.newBuilder((ModelCallPreHookData) this.hookData_).mergeFrom((ModelCallPreHookData.Builder) modelCallPreHookData).buildPartial();
        }
        this.hookDataCase_ = 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSessionEnd(SessionEndHookData sessionEndHookData) {
        sessionEndHookData.getClass();
        if (this.hookDataCase_ != 11 || this.hookData_ == SessionEndHookData.getDefaultInstance()) {
            this.hookData_ = sessionEndHookData;
        } else {
            this.hookData_ = SessionEndHookData.newBuilder((SessionEndHookData) this.hookData_).mergeFrom((SessionEndHookData.Builder) sessionEndHookData).buildPartial();
        }
        this.hookDataCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSessionStart(SessionStartHookData sessionStartHookData) {
        sessionStartHookData.getClass();
        if (this.hookDataCase_ != 10 || this.hookData_ == SessionStartHookData.getDefaultInstance()) {
            this.hookData_ = sessionStartHookData;
        } else {
            this.hookData_ = SessionStartHookData.newBuilder((SessionStartHookData) this.hookData_).mergeFrom((SessionStartHookData.Builder) sessionStartHookData).buildPartial();
        }
        this.hookDataCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeToolCallError(ToolCallErrorHookData toolCallErrorHookData) {
        toolCallErrorHookData.getClass();
        if (this.hookDataCase_ != 22 || this.hookData_ == ToolCallErrorHookData.getDefaultInstance()) {
            this.hookData_ = toolCallErrorHookData;
        } else {
            this.hookData_ = ToolCallErrorHookData.newBuilder((ToolCallErrorHookData) this.hookData_).mergeFrom((ToolCallErrorHookData.Builder) toolCallErrorHookData).buildPartial();
        }
        this.hookDataCase_ = 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeToolCallPost(ToolCallPostHookData toolCallPostHookData) {
        toolCallPostHookData.getClass();
        if (this.hookDataCase_ != 21 || this.hookData_ == ToolCallPostHookData.getDefaultInstance()) {
            this.hookData_ = toolCallPostHookData;
        } else {
            this.hookData_ = ToolCallPostHookData.newBuilder((ToolCallPostHookData) this.hookData_).mergeFrom((ToolCallPostHookData.Builder) toolCallPostHookData).buildPartial();
        }
        this.hookDataCase_ = 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeToolCallPre(ToolCallPreHookData toolCallPreHookData) {
        toolCallPreHookData.getClass();
        if (this.hookDataCase_ != 20 || this.hookData_ == ToolCallPreHookData.getDefaultInstance()) {
            this.hookData_ = toolCallPreHookData;
        } else {
            this.hookData_ = ToolCallPreHookData.newBuilder((ToolCallPreHookData) this.hookData_).mergeFrom((ToolCallPreHookData.Builder) toolCallPreHookData).buildPartial();
        }
        this.hookDataCase_ = 20;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static InvokeHookTask parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (InvokeHookTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InvokeHookTask parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<InvokeHookTask> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentComplete(AgentCompleteHookData agentCompleteHookData) {
        agentCompleteHookData.getClass();
        this.hookData_ = agentCompleteHookData;
        this.hookDataCase_ = 41;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentStart(AgentStartHookData agentStartHookData) {
        agentStartHookData.getClass();
        this.hookData_ = agentStartHookData;
        this.hookDataCase_ = 40;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandoffPost(HandoffPostHookData handoffPostHookData) {
        handoffPostHookData.getClass();
        this.hookData_ = handoffPostHookData;
        this.hookDataCase_ = 51;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandoffPre(HandoffPreHookData handoffPreHookData) {
        handoffPreHookData.getClass();
        this.hookData_ = handoffPreHookData;
        this.hookDataCase_ = 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessagePost(MessagePostHookData messagePostHookData) {
        messagePostHookData.getClass();
        this.hookData_ = messagePostHookData;
        this.hookDataCase_ = 61;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessagePre(MessagePreHookData messagePreHookData) {
        messagePreHookData.getClass();
        this.hookData_ = messagePreHookData;
        this.hookDataCase_ = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelCallPost(ModelCallPostHookData modelCallPostHookData) {
        modelCallPostHookData.getClass();
        this.hookData_ = modelCallPostHookData;
        this.hookDataCase_ = 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelCallPre(ModelCallPreHookData modelCallPreHookData) {
        modelCallPreHookData.getClass();
        this.hookData_ = modelCallPreHookData;
        this.hookDataCase_ = 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionEnd(SessionEndHookData sessionEndHookData) {
        sessionEndHookData.getClass();
        this.hookData_ = sessionEndHookData;
        this.hookDataCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionStart(SessionStartHookData sessionStartHookData) {
        sessionStartHookData.getClass();
        this.hookData_ = sessionStartHookData;
        this.hookDataCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskId(String str) {
        str.getClass();
        this.taskId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.taskId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCallError(ToolCallErrorHookData toolCallErrorHookData) {
        toolCallErrorHookData.getClass();
        this.hookData_ = toolCallErrorHookData;
        this.hookDataCase_ = 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCallPost(ToolCallPostHookData toolCallPostHookData) {
        toolCallPostHookData.getClass();
        this.hookData_ = toolCallPostHookData;
        this.hookDataCase_ = 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCallPre(ToolCallPreHookData toolCallPreHookData) {
        toolCallPreHookData.getClass();
        this.hookData_ = toolCallPreHookData;
        this.hookDataCase_ = 20;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new InvokeHookTask();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0001\u0000\u0001=\u000e\u0000\u0000\u0000\u0001Ȉ\n<\u0000\u000b<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u001e<\u0000\u001f<\u0000(<\u0000)<\u00002<\u00003<\u0000<<\u0000=<\u0000", new Object[]{"hookData_", "hookDataCase_", "taskId_", SessionStartHookData.class, SessionEndHookData.class, ToolCallPreHookData.class, ToolCallPostHookData.class, ToolCallErrorHookData.class, ModelCallPreHookData.class, ModelCallPostHookData.class, AgentStartHookData.class, AgentCompleteHookData.class, HandoffPreHookData.class, HandoffPostHookData.class, MessagePreHookData.class, MessagePostHookData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<InvokeHookTask> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (InvokeHookTask.class) {
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

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public AgentCompleteHookData getAgentComplete() {
        return this.hookDataCase_ == 41 ? (AgentCompleteHookData) this.hookData_ : AgentCompleteHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public AgentStartHookData getAgentStart() {
        return this.hookDataCase_ == 40 ? (AgentStartHookData) this.hookData_ : AgentStartHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public HandoffPostHookData getHandoffPost() {
        return this.hookDataCase_ == 51 ? (HandoffPostHookData) this.hookData_ : HandoffPostHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public HandoffPreHookData getHandoffPre() {
        return this.hookDataCase_ == 50 ? (HandoffPreHookData) this.hookData_ : HandoffPreHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public HookDataCase getHookDataCase() {
        return HookDataCase.forNumber(this.hookDataCase_);
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public MessagePostHookData getMessagePost() {
        return this.hookDataCase_ == 61 ? (MessagePostHookData) this.hookData_ : MessagePostHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public MessagePreHookData getMessagePre() {
        return this.hookDataCase_ == 60 ? (MessagePreHookData) this.hookData_ : MessagePreHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public ModelCallPostHookData getModelCallPost() {
        return this.hookDataCase_ == 31 ? (ModelCallPostHookData) this.hookData_ : ModelCallPostHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public ModelCallPreHookData getModelCallPre() {
        return this.hookDataCase_ == 30 ? (ModelCallPreHookData) this.hookData_ : ModelCallPreHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public SessionEndHookData getSessionEnd() {
        return this.hookDataCase_ == 11 ? (SessionEndHookData) this.hookData_ : SessionEndHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public SessionStartHookData getSessionStart() {
        return this.hookDataCase_ == 10 ? (SessionStartHookData) this.hookData_ : SessionStartHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public ToolCallErrorHookData getToolCallError() {
        return this.hookDataCase_ == 22 ? (ToolCallErrorHookData) this.hookData_ : ToolCallErrorHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public ToolCallPostHookData getToolCallPost() {
        return this.hookDataCase_ == 21 ? (ToolCallPostHookData) this.hookData_ : ToolCallPostHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public ToolCallPreHookData getToolCallPre() {
        return this.hookDataCase_ == 20 ? (ToolCallPreHookData) this.hookData_ : ToolCallPreHookData.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasAgentComplete() {
        return this.hookDataCase_ == 41;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasAgentStart() {
        return this.hookDataCase_ == 40;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasHandoffPost() {
        return this.hookDataCase_ == 51;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasHandoffPre() {
        return this.hookDataCase_ == 50;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasMessagePost() {
        return this.hookDataCase_ == 61;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasMessagePre() {
        return this.hookDataCase_ == 60;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasModelCallPost() {
        return this.hookDataCase_ == 31;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasModelCallPre() {
        return this.hookDataCase_ == 30;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasSessionEnd() {
        return this.hookDataCase_ == 11;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasSessionStart() {
        return this.hookDataCase_ == 10;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasToolCallError() {
        return this.hookDataCase_ == 22;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasToolCallPost() {
        return this.hookDataCase_ == 21;
    }

    @Override // com.zyql.protobuf.agent.InvokeHookTaskOrBuilder
    public boolean hasToolCallPre() {
        return this.hookDataCase_ == 20;
    }

    public static Builder newBuilder(InvokeHookTask invokeHookTask) {
        return DEFAULT_INSTANCE.createBuilder(invokeHookTask);
    }

    public static InvokeHookTask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvokeHookTask) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InvokeHookTask parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static InvokeHookTask parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static InvokeHookTask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static InvokeHookTask parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static InvokeHookTask parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static InvokeHookTask parseFrom(InputStream inputStream) throws IOException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InvokeHookTask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InvokeHookTask parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static InvokeHookTask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvokeHookTask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
