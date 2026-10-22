package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StoreListRequestOrBuilder extends MessageLiteOrBuilder {
    String getAppId();

    ByteString getAppIdBytes();

    int getCount();

    String getCursor();

    ByteString getCursorBytes();

    String getPrefix();

    ByteString getPrefixBytes();

    StoreScope getScope();

    int getScopeValue();

    String getSessionId();

    ByteString getSessionIdBytes();

    String getUserId();

    ByteString getUserIdBytes();
}
