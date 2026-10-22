package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface GetAgentInfoResponseOrBuilder extends MessageLiteOrBuilder {
    AgentInfo getAgentInfo();

    String getError();

    ByteString getErrorBytes();

    boolean getSuccess();

    boolean hasAgentInfo();
}
