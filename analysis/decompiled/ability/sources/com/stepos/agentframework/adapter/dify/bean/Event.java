package com.stepos.agentframework.adapter.dify.bean;

import K7.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/Event;", "", NotificationCompat.CATEGORY_EVENT, "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "MESSAGE_END", "MESSAGE", "AGENT_THOUGHT", "AGENT_MESSAGE", "MESSAGE_REPLACE", "ERROR", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Event {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ Event[] $VALUES;
    private final String event;

    @SerializedName("message_end")
    public static final Event MESSAGE_END = new Event("MESSAGE_END", 0, "message_end");

    @SerializedName("message")
    public static final Event MESSAGE = new Event("MESSAGE", 1, "message");

    @SerializedName("agent_thought")
    public static final Event AGENT_THOUGHT = new Event("AGENT_THOUGHT", 2, "agent_thought");

    @SerializedName("agent_message")
    public static final Event AGENT_MESSAGE = new Event("AGENT_MESSAGE", 3, "agent_message");

    @SerializedName("message_replace")
    public static final Event MESSAGE_REPLACE = new Event("MESSAGE_REPLACE", 4, "message_replace");

    @SerializedName("error")
    public static final Event ERROR = new Event("ERROR", 5, "error");

    private static final /* synthetic */ Event[] $values() {
        return new Event[]{MESSAGE_END, MESSAGE, AGENT_THOUGHT, AGENT_MESSAGE, MESSAGE_REPLACE, ERROR};
    }

    static {
        Event[] eventArr$values = $values();
        $VALUES = eventArr$values;
        $ENTRIES = kotlin.enums.a.a(eventArr$values);
    }

    private Event(String str, int i, String str2) {
        this.event = str2;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static Event valueOf(String str) {
        return (Event) Enum.valueOf(Event.class, str);
    }

    public static Event[] values() {
        return (Event[]) $VALUES.clone();
    }

    public final String getEvent() {
        return this.event;
    }
}
