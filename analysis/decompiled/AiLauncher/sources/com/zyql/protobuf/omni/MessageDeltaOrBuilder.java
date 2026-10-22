package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface MessageDeltaOrBuilder extends MessageLiteOrBuilder {
    boolean getIsEnd();

    String getMessageId();

    ByteString getMessageIdBytes();

    String getRole();

    ByteString getRoleBytes();

    String getText();

    ByteString getTextBytes();
}
