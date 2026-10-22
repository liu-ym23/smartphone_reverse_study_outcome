package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.runtime.InputMessageStateNotification;

/* loaded from: classes4.dex */
public interface InputMessageStateNotificationOrBuilder extends MessageLiteOrBuilder {
    String getDetails();

    ByteString getDetailsBytes();

    InputMessageStateNotification.State getState();

    int getStateValue();

    boolean hasDetails();
}
