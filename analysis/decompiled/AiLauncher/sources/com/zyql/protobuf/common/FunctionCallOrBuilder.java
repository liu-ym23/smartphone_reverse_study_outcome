package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;

/* loaded from: classes4.dex */
public interface FunctionCallOrBuilder extends MessageLiteOrBuilder {
    Struct getArgs();

    String getId();

    ByteString getIdBytes();

    String getName();

    ByteString getNameBytes();

    boolean hasArgs();
}
