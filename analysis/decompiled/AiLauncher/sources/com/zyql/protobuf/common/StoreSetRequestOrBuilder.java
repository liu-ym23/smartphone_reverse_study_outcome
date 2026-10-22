package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreSetRequestOrBuilder extends MessageLiteOrBuilder {
    String getAppId();

    ByteString getAppIdBytes();

    boolean getIfExists();

    boolean getIfNotExists();

    String getKey();

    ByteString getKeyBytes();

    StoreScope getScope();

    int getScopeValue();

    String getSessionId();

    ByteString getSessionIdBytes();

    long getTtlSeconds();

    String getUserId();

    ByteString getUserIdBytes();

    String getValue();

    ByteString getValueBytes();
}
