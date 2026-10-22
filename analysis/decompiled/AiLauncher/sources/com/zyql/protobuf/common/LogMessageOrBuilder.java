package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface LogMessageOrBuilder extends MessageLiteOrBuilder {
    String getContent();

    ByteString getContentBytes();

    LogLevel getLevel();

    int getLevelValue();

    LogSender getSender();

    int getSenderValue();

    long getTimestamp();
}
