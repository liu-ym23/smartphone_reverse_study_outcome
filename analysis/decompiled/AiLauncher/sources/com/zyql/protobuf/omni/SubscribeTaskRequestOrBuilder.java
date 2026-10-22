package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface SubscribeTaskRequestOrBuilder extends MessageLiteOrBuilder {
    boolean getNeedTts();

    String getTaskEventId();

    ByteString getTaskEventIdBytes();

    String getTaskId();

    ByteString getTaskIdBytes();
}
