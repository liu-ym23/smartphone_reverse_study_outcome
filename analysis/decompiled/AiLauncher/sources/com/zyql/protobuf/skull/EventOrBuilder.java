package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.skull.Event;

/* loaded from: classes4.dex */
public interface EventOrBuilder extends MessageLiteOrBuilder {
    Event.DataCase getDataCase();

    String getEventId();

    ByteString getEventIdBytes();

    Item getItem();

    MessageDelta getMessageDelta();

    Task getTask();

    String getTaskId();

    ByteString getTaskIdBytes();

    String getType();

    ByteString getTypeBytes();

    boolean hasItem();

    boolean hasMessageDelta();

    boolean hasTask();
}
