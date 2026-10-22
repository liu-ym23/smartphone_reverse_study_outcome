package com.zyql.protobuf.runtime;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.common.LogLevel;

/* loaded from: classes4.dex */
public interface ExecutionOptionsOrBuilder extends MessageLiteOrBuilder {
    boolean getIncludeFunctionCallOutput();

    boolean getIncludeSubAgentOutput();

    LogLevel getLogLevel();

    int getLogLevelValue();

    boolean getObserverMode();

    boolean getSendCompleteMessage();

    boolean hasIncludeFunctionCallOutput();

    boolean hasIncludeSubAgentOutput();

    boolean hasLogLevel();

    boolean hasObserverMode();

    boolean hasSendCompleteMessage();
}
