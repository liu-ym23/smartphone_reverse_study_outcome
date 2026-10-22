package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;
import com.zyql.protobuf.common.Content;
import java.util.List;

/* loaded from: classes4.dex */
public interface StartAgentRequestOrBuilder extends MessageLiteOrBuilder {
    String getAgentId();

    ByteString getAgentIdBytes();

    Content getMessages(int i10);

    int getMessagesCount();

    List<Content> getMessagesList();

    Struct getMetadata();

    ExecutionOptions getOptions();

    String getSessionId();

    ByteString getSessionIdBytes();

    String getUserId();

    ByteString getUserIdBytes();

    boolean hasMetadata();

    boolean hasOptions();

    boolean hasSessionId();
}
