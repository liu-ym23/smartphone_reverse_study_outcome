package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreSetResponseOrBuilder extends MessageLiteOrBuilder {
    String getPreviousValue();

    ByteString getPreviousValueBytes();

    boolean getSuccess();

    boolean getUpdated();

    boolean hasPreviousValue();
}
