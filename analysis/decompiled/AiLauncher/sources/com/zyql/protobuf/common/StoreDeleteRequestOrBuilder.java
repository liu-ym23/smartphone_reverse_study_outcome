package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreDeleteRequestOrBuilder extends MessageLiteOrBuilder {
    String getAppId();

    ByteString getAppIdBytes();

    String getKey();

    ByteString getKeyBytes();

    StoreScope getScope();

    int getScopeValue();

    String getSessionId();

    ByteString getSessionIdBytes();

    String getUserId();

    ByteString getUserIdBytes();
}
