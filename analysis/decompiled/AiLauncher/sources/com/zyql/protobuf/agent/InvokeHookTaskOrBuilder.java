package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.agent.InvokeHookTask;
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

/* loaded from: classes4.dex */
public interface InvokeHookTaskOrBuilder extends MessageLiteOrBuilder {
    AgentCompleteHookData getAgentComplete();

    AgentStartHookData getAgentStart();

    HandoffPostHookData getHandoffPost();

    HandoffPreHookData getHandoffPre();

    InvokeHookTask.HookDataCase getHookDataCase();

    MessagePostHookData getMessagePost();

    MessagePreHookData getMessagePre();

    ModelCallPostHookData getModelCallPost();

    ModelCallPreHookData getModelCallPre();

    SessionEndHookData getSessionEnd();

    SessionStartHookData getSessionStart();

    String getTaskId();

    ByteString getTaskIdBytes();

    ToolCallErrorHookData getToolCallError();

    ToolCallPostHookData getToolCallPost();

    ToolCallPreHookData getToolCallPre();

    boolean hasAgentComplete();

    boolean hasAgentStart();

    boolean hasHandoffPost();

    boolean hasHandoffPre();

    boolean hasMessagePost();

    boolean hasMessagePre();

    boolean hasModelCallPost();

    boolean hasModelCallPre();

    boolean hasSessionEnd();

    boolean hasSessionStart();

    boolean hasToolCallError();

    boolean hasToolCallPost();

    boolean hasToolCallPre();
}
