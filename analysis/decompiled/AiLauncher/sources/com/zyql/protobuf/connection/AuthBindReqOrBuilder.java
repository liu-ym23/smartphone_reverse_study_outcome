package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface AuthBindReqOrBuilder extends MessageLiteOrBuilder {
    boolean containsReserved(String str);

    String getAppVersion();

    ByteString getAppVersionBytes();

    String getChannel();

    ByteString getChannelBytes();

    String getDevice();

    ByteString getDeviceBytes();

    String getDid();

    ByteString getDidBytes();

    int getPlatform();

    String getProduct();

    ByteString getProductBytes();

    @Deprecated
    Map<String, String> getReserved();

    int getReservedCount();

    Map<String, String> getReservedMap();

    String getReservedOrDefault(String str, String str2);

    String getReservedOrThrow(String str);

    String getToken();

    ByteString getTokenBytes();

    String getTokenType();

    ByteString getTokenTypeBytes();

    String getUid();

    ByteString getUidBytes();
}
