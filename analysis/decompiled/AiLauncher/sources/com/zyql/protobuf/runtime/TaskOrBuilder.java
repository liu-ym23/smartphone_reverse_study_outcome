package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.common.LogNotification;
import com.zyql.protobuf.runtime.Task;

/* loaded from: classes4.dex */
public interface TaskOrBuilder extends MessageLiteOrBuilder {
    AgentTaskStateNotification getAgentTaskState();

    String getId();

    ByteString getIdBytes();

    InputMessageStateNotification getInputMessageState();

    LLMResponse getLlmResponse();

    LogNotification getLogNotification();

    Task.OutputCase getOutputCase();

    TaskError getTaskError();

    long getTimestamp();

    boolean hasAgentTaskState();

    boolean hasInputMessageState();

    boolean hasLlmResponse();

    boolean hasLogNotification();

    boolean hasTaskError();
}
