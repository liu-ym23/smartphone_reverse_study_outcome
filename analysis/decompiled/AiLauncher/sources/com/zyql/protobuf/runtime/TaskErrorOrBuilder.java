package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface TaskErrorOrBuilder extends MessageLiteOrBuilder {
    int getCode();

    String getMessage();

    ByteString getMessageBytes();
}
