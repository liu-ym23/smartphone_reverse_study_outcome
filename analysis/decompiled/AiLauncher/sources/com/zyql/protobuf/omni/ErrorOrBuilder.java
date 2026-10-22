package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface ErrorOrBuilder extends MessageLiteOrBuilder {
    long getErrorCode();

    String getErrorMsg();

    ByteString getErrorMsgBytes();
}
