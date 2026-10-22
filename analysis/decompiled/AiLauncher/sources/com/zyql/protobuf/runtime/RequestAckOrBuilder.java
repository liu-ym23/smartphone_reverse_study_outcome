package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.runtime.RequestAck;

/* loaded from: classes4.dex */
public interface RequestAckOrBuilder extends MessageLiteOrBuilder {
    RequestAck.AckTypeCase getAckTypeCase();

    CancelAck getCancelAck();

    int getErrorCode();

    String getErrorMessage();

    ByteString getErrorMessageBytes();

    long getRequestId();

    SendInputAck getSendInputAck();

    StartAgentAck getStartAgentAck();

    boolean hasCancelAck();

    boolean hasErrorCode();

    boolean hasErrorMessage();

    boolean hasSendInputAck();

    boolean hasStartAgentAck();
}
