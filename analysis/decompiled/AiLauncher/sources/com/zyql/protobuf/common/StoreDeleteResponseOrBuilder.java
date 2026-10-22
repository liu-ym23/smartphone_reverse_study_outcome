package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreDeleteResponseOrBuilder extends MessageLiteOrBuilder {
    boolean getDeleted();

    String getPreviousValue();

    ByteString getPreviousValueBytes();

    boolean hasPreviousValue();
}
