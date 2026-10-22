package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface RegisterHookResponseOrBuilder extends MessageLiteOrBuilder {
    String getError();

    ByteString getErrorBytes();

    String getHookId();

    ByteString getHookIdBytes();

    boolean getSuccess();
}
