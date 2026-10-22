package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.agent.AgentMessage;

/* loaded from: classes4.dex */
public interface AgentMessageOrBuilder extends MessageLiteOrBuilder {
    Error getError();

    GetAgentInfoResponse getGetAgentInfoResponse();

    GetStoreRequest getGetStoreRequest();

    HookExecutionResult getHookExecutionResult();

    String getId();

    ByteString getIdBytes();

    AgentMessage.RequestCase getRequestCase();

    AgentMessage.ResponseCase getResponseCase();

    long getTimestamp();

    ToolExecutionResult getToolExecutionResult();

    boolean hasError();

    boolean hasGetAgentInfoResponse();

    boolean hasGetStoreRequest();

    boolean hasHookExecutionResult();

    boolean hasToolExecutionResult();
}
