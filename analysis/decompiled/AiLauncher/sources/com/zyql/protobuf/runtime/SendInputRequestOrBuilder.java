package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;
import com.zyql.protobuf.common.Content;
import java.util.List;

/* loaded from: classes4.dex */
public interface SendInputRequestOrBuilder extends MessageLiteOrBuilder {
    Content getMessages(int i10);

    int getMessagesCount();

    List<Content> getMessagesList();

    Struct getMetadata();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean hasMetadata();
}
