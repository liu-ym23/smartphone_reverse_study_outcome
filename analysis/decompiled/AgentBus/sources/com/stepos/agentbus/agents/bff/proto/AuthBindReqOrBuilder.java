package com.stepos.agentbus.agents.bff.proto;

import com.google.protobuf.MessageLite;
import com.google.protobuf.l;
import java.util.Map;

/* loaded from: classes.dex */
public interface AuthBindReqOrBuilder {
    boolean containsReserved(String str);

    String getAppVersion();

    l getAppVersionBytes();

    String getChannel();

    l getChannelBytes();

    /* synthetic */ MessageLite getDefaultInstanceForType();

    String getDevice();

    l getDeviceBytes();

    String getDid();

    l getDidBytes();

    int getPlatform();

    String getProduct();

    l getProductBytes();

    @Deprecated
    Map<String, String> getReserved();

    int getReservedCount();

    Map<String, String> getReservedMap();

    String getReservedOrDefault(String str, String str2);

    String getReservedOrThrow(String str);

    String getToken();

    l getTokenBytes();

    String getTokenType();

    l getTokenTypeBytes();

    String getUid();

    l getUidBytes();

    /* synthetic */ boolean isInitialized();
}
