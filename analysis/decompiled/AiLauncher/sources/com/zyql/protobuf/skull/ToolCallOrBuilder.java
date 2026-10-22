package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface ToolCallOrBuilder extends MessageLiteOrBuilder {
    String getCallId();

    ByteString getCallIdBytes();

    ToolCallParams getParams();

    ToolCallResult getResult();

    Tool getTool();

    boolean hasParams();

    boolean hasResult();

    boolean hasTool();
}
