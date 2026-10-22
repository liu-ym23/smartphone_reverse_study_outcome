package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;
import com.zyql.protobuf.common.Content;

/* loaded from: classes4.dex */
public interface LLMResponseOrBuilder extends MessageLiteOrBuilder {
    Content getContent();

    String getFinishReason();

    ByteString getFinishReasonBytes();

    Struct getMetadata();

    boolean getPartial();

    long getSequenceIndex();

    boolean getTurnComplete();

    boolean hasContent();

    boolean hasFinishReason();

    boolean hasMetadata();

    boolean hasSequenceIndex();
}
