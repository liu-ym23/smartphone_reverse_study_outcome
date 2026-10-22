package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface InvokeReqOrBuilder extends MessageLiteOrBuilder {
    ByteString getBody();

    String getCommand();

    ByteString getCommandBytes();

    String getModule();

    ByteString getModuleBytes();

    String getMsgId();

    ByteString getMsgIdBytes();
}
