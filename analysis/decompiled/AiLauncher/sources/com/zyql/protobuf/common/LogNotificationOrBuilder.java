package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface LogNotificationOrBuilder extends MessageLiteOrBuilder {
    LogMessage getLog();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean hasLog();
}
