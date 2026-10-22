package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface UnregisterHookResponseOrBuilder extends MessageLiteOrBuilder {
    String getError();

    ByteString getErrorBytes();

    boolean getSuccess();
}
