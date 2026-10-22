package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.runtime.AgentTaskStateNotification;

/* loaded from: classes4.dex */
public interface AgentTaskStateNotificationOrBuilder extends MessageLiteOrBuilder {
    String getDetails();

    ByteString getDetailsBytes();

    AgentTaskStateNotification.State getState();

    int getStateValue();

    boolean hasDetails();
}
