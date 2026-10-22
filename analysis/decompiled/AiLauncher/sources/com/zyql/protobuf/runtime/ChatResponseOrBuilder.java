package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.runtime.ChatResponse;

/* loaded from: classes4.dex */
public interface ChatResponseOrBuilder extends MessageLiteOrBuilder {
    RequestAck getAck();

    ChatResponse.ContentCase getContentCase();

    String getSessionId();

    ByteString getSessionIdBytes();

    Task getTask();

    boolean hasAck();

    boolean hasSessionId();

    boolean hasTask();
}
