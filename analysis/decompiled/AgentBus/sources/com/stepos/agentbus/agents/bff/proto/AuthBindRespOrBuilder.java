package com.stepos.agentbus.agents.bff.proto;

import com.google.protobuf.MessageLite;
import com.google.protobuf.l;

/* loaded from: classes.dex */
public interface AuthBindRespOrBuilder {
    int getCode();

    String getConn();

    l getConnBytes();

    /* synthetic */ MessageLite getDefaultInstanceForType();

    String getError();

    l getErrorBytes();

    int getLogined();

    boolean getNew();

    String getUid();

    l getUidBytes();

    /* synthetic */ boolean isInitialized();
}
