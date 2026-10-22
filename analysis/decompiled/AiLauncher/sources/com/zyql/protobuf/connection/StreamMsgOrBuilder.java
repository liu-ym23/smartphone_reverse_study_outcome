package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StreamMsgOrBuilder extends MessageLiteOrBuilder {
    ByteString getBody();

    Head getHead();

    boolean hasHead();
}
