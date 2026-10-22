package com.zyql.protobuf.agent;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes4.dex */
public interface CompletionRequestOrBuilder extends MessageLiteOrBuilder {
    ModelConfig getConfig();

    ChatMessage getMessages(int i10);

    int getMessagesCount();

    List<ChatMessage> getMessagesList();

    ToolDefinition getTools(int i10);

    int getToolsCount();

    List<ToolDefinition> getToolsList();

    boolean hasConfig();
}
