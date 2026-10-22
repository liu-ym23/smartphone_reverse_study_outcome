package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.agent.RuntimeMessage;

/* loaded from: classes4.dex */
public interface RuntimeMessageOrBuilder extends MessageLiteOrBuilder {
    Error getError();

    ExecuteToolTask getExecuteToolTask();

    GetAgentInfoRequest getGetAgentInfoRequest();

    GetStoreResponse getGetStoreResponse();

    String getId();

    ByteString getIdBytes();

    InvokeHookTask getInvokeHookTask();

    RuntimeMessage.RequestCase getRequestCase();

    RuntimeMessage.ResponseCase getResponseCase();

    long getTimestamp();

    boolean hasError();

    boolean hasExecuteToolTask();

    boolean hasGetAgentInfoRequest();

    boolean hasGetStoreResponse();

    boolean hasInvokeHookTask();
}
