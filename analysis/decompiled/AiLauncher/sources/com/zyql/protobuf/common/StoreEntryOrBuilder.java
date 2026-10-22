package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreEntryOrBuilder extends MessageLiteOrBuilder {
    String getAppId();

    ByteString getAppIdBytes();

    long getCreatedAt();

    long getExpiresAt();

    String getKey();

    ByteString getKeyBytes();

    StoreScope getScope();

    int getScopeValue();

    String getSessionId();

    ByteString getSessionIdBytes();

    long getTtlSeconds();

    long getUpdatedAt();

    String getUserId();

    ByteString getUserIdBytes();

    String getValue();

    ByteString getValueBytes();
}
