package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreClearRequestOrBuilder extends MessageLiteOrBuilder {
    String getAppId();

    ByteString getAppIdBytes();

    String getPrefix();

    ByteString getPrefixBytes();

    StoreScope getScope();

    int getScopeValue();

    String getSessionId();

    ByteString getSessionIdBytes();

    String getUserId();

    ByteString getUserIdBytes();
}
