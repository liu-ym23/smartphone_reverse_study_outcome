package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface ExecuteToolTaskOrBuilder extends MessageLiteOrBuilder {
    String getArgumentsJson();

    ByteString getArgumentsJsonBytes();

    String getTaskId();

    ByteString getTaskIdBytes();

    int getTimeoutSeconds();

    String getToolCallId();

    ByteString getToolCallIdBytes();

    String getToolName();

    ByteString getToolNameBytes();
}
