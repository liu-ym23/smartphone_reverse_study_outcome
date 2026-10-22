package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreGetResponseOrBuilder extends MessageLiteOrBuilder {
    boolean getFound();

    long getTtlSeconds();

    long getUpdatedAt();

    String getValue();

    ByteString getValueBytes();
}
