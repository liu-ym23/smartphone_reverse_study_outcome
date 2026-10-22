package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface GetStoreResponseOrBuilder extends MessageLiteOrBuilder {
    String getError();

    ByteString getErrorBytes();

    String getKey();

    ByteString getKeyBytes();

    String getStoreId();

    ByteString getStoreIdBytes();

    boolean getSuccess();

    ByteString getValue();
}
