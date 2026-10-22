package com.stepos.agentframework.adapter.coze.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/EventType;", "", AppAgent.CONSTRUCT, "()V", "CONVERSATION_CHAT_CREATED", "", "getCONVERSATION_CHAT_CREATED", "()Ljava/lang/String;", "CONVERSATION_CHAT_IN_PROGRESS", "getCONVERSATION_CHAT_IN_PROGRESS", "CONVERSATION_MESSAGE_DELTA", "getCONVERSATION_MESSAGE_DELTA", "CONVERSATION_MESSAGE_COMPLETED", "getCONVERSATION_MESSAGE_COMPLETED", "CONVERSATION_CHAT_COMPLETED", "getCONVERSATION_CHAT_COMPLETED", "CONVERSATION_CHAT_REQUIRES_ACTION", "getCONVERSATION_CHAT_REQUIRES_ACTION", "CONVERSATION_CHAT_FAILED", "getCONVERSATION_CHAT_FAILED", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EventType {
    public static final EventType INSTANCE = new EventType();
    private static final String CONVERSATION_CHAT_CREATED = "conversation.chat.created";
    private static final String CONVERSATION_CHAT_IN_PROGRESS = "conversation.chat.in_progress";
    private static final String CONVERSATION_MESSAGE_DELTA = "conversation.message.delta";
    private static final String CONVERSATION_MESSAGE_COMPLETED = "conversation.message.completed";
    private static final String CONVERSATION_CHAT_COMPLETED = "conversation.chat.completed";
    private static final String CONVERSATION_CHAT_REQUIRES_ACTION = "conversation.chat.requires_action";
    private static final String CONVERSATION_CHAT_FAILED = "conversation.chat.failed";

    private EventType() {
    }

    public final String getCONVERSATION_CHAT_COMPLETED() {
        return CONVERSATION_CHAT_COMPLETED;
    }

    public final String getCONVERSATION_CHAT_CREATED() {
        return CONVERSATION_CHAT_CREATED;
    }

    public final String getCONVERSATION_CHAT_FAILED() {
        return CONVERSATION_CHAT_FAILED;
    }

    public final String getCONVERSATION_CHAT_IN_PROGRESS() {
        return CONVERSATION_CHAT_IN_PROGRESS;
    }

    public final String getCONVERSATION_CHAT_REQUIRES_ACTION() {
        return CONVERSATION_CHAT_REQUIRES_ACTION;
    }

    public final String getCONVERSATION_MESSAGE_COMPLETED() {
        return CONVERSATION_MESSAGE_COMPLETED;
    }

    public final String getCONVERSATION_MESSAGE_DELTA() {
        return CONVERSATION_MESSAGE_DELTA;
    }
}
