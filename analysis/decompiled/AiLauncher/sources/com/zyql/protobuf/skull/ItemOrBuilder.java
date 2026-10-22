package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.skull.Item;

/* loaded from: classes4.dex */
public interface ItemOrBuilder extends MessageLiteOrBuilder {
    AskInput getAskInput();

    Item.DataCase getDataCase();

    Handoff getHandoff();

    Interrupt getInterrupt();

    String getItemId();

    ByteString getItemIdBytes();

    Message getMessage();

    String getStatus();

    ByteString getStatusBytes();

    String getTaskId();

    ByteString getTaskIdBytes();

    ToolCall getToolCall();

    String getType();

    ByteString getTypeBytes();

    boolean hasAskInput();

    boolean hasHandoff();

    boolean hasInterrupt();

    boolean hasMessage();

    boolean hasToolCall();
}
