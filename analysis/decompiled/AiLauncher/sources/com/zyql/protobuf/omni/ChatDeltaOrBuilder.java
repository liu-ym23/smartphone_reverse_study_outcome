package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.skull.Message;

/* loaded from: classes4.dex */
public interface ChatDeltaOrBuilder extends MessageLiteOrBuilder {
    Audio getAudio();

    String getChatId();

    ByteString getChatIdBytes();

    Error getError();

    String getEventId();

    ByteString getEventIdBytes();

    Message getMessage();

    MessageDelta getMessageDelta();

    String getMessageId();

    ByteString getMessageIdBytes();

    TaskStatus getStatus();

    int getStatusValue();

    String getTaskId();

    ByteString getTaskIdBytes();

    boolean hasAudio();

    boolean hasError();

    boolean hasMessage();

    boolean hasMessageDelta();
}
