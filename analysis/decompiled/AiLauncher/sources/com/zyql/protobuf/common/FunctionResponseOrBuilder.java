package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;

/* loaded from: classes4.dex */
public interface FunctionResponseOrBuilder extends MessageLiteOrBuilder {
    String getId();

    ByteString getIdBytes();

    String getName();

    ByteString getNameBytes();

    Struct getResponse();

    boolean hasResponse();
}
