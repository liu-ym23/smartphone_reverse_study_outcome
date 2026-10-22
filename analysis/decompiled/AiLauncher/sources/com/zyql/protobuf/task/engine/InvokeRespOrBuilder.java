package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface InvokeRespOrBuilder extends MessageLiteOrBuilder {
    InvokeState getState();

    int getStateValue();

    String getTaskId();

    ByteString getTaskIdBytes();
}
