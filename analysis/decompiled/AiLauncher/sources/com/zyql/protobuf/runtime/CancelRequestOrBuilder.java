package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface CancelRequestOrBuilder extends MessageLiteOrBuilder {
    String getReason();

    ByteString getReasonBytes();

    String getSessionId();

    ByteString getSessionIdBytes();
}
