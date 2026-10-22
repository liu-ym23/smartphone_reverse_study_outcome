package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.common.Part;

/* loaded from: classes4.dex */
public interface PartOrBuilder extends MessageLiteOrBuilder {
    Part.ContentCase getContentCase();

    FileData getFileData();

    FunctionCall getFunctionCall();

    FunctionResponse getFunctionResponse();

    Blob getInlineData();

    String getText();

    ByteString getTextBytes();

    boolean getThought();

    boolean hasFileData();

    boolean hasFunctionCall();

    boolean hasFunctionResponse();

    boolean hasInlineData();

    boolean hasText();
}
