package com.zyql.protobuf.runtime;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.runtime.ChatRequest;

/* loaded from: classes4.dex */
public interface ChatRequestOrBuilder extends MessageLiteOrBuilder {
    CancelRequest getCancelRequest();

    long getId();

    ChatRequest.PayloadCase getPayloadCase();

    SendInputRequest getSendInputRequest();

    StartAgentRequest getStartAgentRequest();

    boolean hasCancelRequest();

    boolean hasSendInputRequest();

    boolean hasStartAgentRequest();
}
