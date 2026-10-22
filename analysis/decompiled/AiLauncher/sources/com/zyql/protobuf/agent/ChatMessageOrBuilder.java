package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface ChatMessageOrBuilder extends MessageLiteOrBuilder {
    String getContent();

    ByteString getContentBytes();

    String getName();

    ByteString getNameBytes();

    String getRole();

    ByteString getRoleBytes();

    boolean hasName();
}
