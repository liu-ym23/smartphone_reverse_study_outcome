package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface AuthBindRespOrBuilder extends MessageLiteOrBuilder {
    int getCode();

    String getConn();

    ByteString getConnBytes();

    String getError();

    ByteString getErrorBytes();

    int getLogined();

    boolean getNew();

    String getUid();

    ByteString getUidBytes();
}
