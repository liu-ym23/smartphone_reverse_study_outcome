package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.common.FunctionCall;
import java.util.List;

/* loaded from: classes4.dex */
public interface CompletionResponseOrBuilder extends MessageLiteOrBuilder {
    String getFinishReason();

    ByteString getFinishReasonBytes();

    ChatMessage getMessage();

    String getProviderError();

    ByteString getProviderErrorBytes();

    TokenUsage getTokenUsage();

    FunctionCall getToolCalls(int i10);

    int getToolCallsCount();

    List<FunctionCall> getToolCallsList();

    boolean hasMessage();

    boolean hasProviderError();

    boolean hasTokenUsage();
}
