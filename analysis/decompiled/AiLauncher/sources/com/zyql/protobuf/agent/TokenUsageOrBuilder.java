package com.zyql.protobuf.agent;

import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface TokenUsageOrBuilder extends MessageLiteOrBuilder {
    int getCompletionTokens();

    int getPromptTokens();

    int getTotalTokens();
}
