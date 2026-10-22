package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface StartAgentAckOrBuilder extends MessageLiteOrBuilder {
    String getAgentDescription();

    ByteString getAgentDescriptionBytes();

    String getAgentName();

    ByteString getAgentNameBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    long getTaskId();

    boolean hasAgentDescription();

    boolean hasAgentName();

    boolean hasTaskId();
}
