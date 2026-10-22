package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface UnregisterHookRequestOrBuilder extends MessageLiteOrBuilder {
    String getHookId();

    ByteString getHookIdBytes();

    String getSessionId();

    ByteString getSessionIdBytes();
}
