package com.stepos.agentframework.adapter.dify.bean;

import B7.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008a\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\fHÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0019R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015¨\u00069"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/ChatEventData;", "", NotificationCompat.CATEGORY_EVENT, "Lcom/stepos/agentframework/adapter/dify/bean/Event;", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", "id", AgentBusWakeContract.EXTRA_TRACE_ID, "uid", "answer", "messageId", "createdAt", "", "conversationId", "thought", "observation", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/dify/bean/Event;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEvent", "()Lcom/stepos/agentframework/adapter/dify/bean/Event;", "getTaskId", "()Ljava/lang/String;", "getId", "getTraceId", "setTraceId", "(Ljava/lang/String;)V", "getUid", "setUid", "getAnswer", "setAnswer", "getMessageId", "getCreatedAt", "()Ljava/lang/Integer;", "setCreatedAt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getConversationId", "getThought", "getObservation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Lcom/stepos/agentframework/adapter/dify/bean/Event;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/adapter/dify/bean/ChatEventData;", "equals", "", "other", "hashCode", "toString", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatEventData {

    @SerializedName("answer")
    private String answer;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("created_at")
    private Integer createdAt;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final Event event;

    @SerializedName("id")
    private final String id;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("observation")
    private final String observation;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("thought")
    private final String thought;

    @SerializedName(Key.KEY_TRACE_ID)
    private String traceId;

    @SerializedName("uid")
    private String uid;

    public ChatEventData(Event event, String taskId, String id, String str, String str2, String str3, String messageId, Integer num, String conversationId, String str4, String str5) {
        k.f(taskId, "taskId");
        k.f(id, "id");
        k.f(messageId, "messageId");
        k.f(conversationId, "conversationId");
        this.event = event;
        this.taskId = taskId;
        this.id = id;
        this.traceId = str;
        this.uid = str2;
        this.answer = str3;
        this.messageId = messageId;
        this.createdAt = num;
        this.conversationId = conversationId;
        this.thought = str4;
        this.observation = str5;
    }

    public static /* synthetic */ ChatEventData copy$default(ChatEventData chatEventData, Event event, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            event = chatEventData.event;
        }
        if ((i & 2) != 0) {
            str = chatEventData.taskId;
        }
        if ((i & 4) != 0) {
            str2 = chatEventData.id;
        }
        if ((i & 8) != 0) {
            str3 = chatEventData.traceId;
        }
        if ((i & 16) != 0) {
            str4 = chatEventData.uid;
        }
        if ((i & 32) != 0) {
            str5 = chatEventData.answer;
        }
        if ((i & 64) != 0) {
            str6 = chatEventData.messageId;
        }
        if ((i & 128) != 0) {
            num = chatEventData.createdAt;
        }
        if ((i & 256) != 0) {
            str7 = chatEventData.conversationId;
        }
        if ((i & 512) != 0) {
            str8 = chatEventData.thought;
        }
        if ((i & 1024) != 0) {
            str9 = chatEventData.observation;
        }
        String str10 = str8;
        String str11 = str9;
        Integer num2 = num;
        String str12 = str7;
        String str13 = str5;
        String str14 = str6;
        String str15 = str4;
        String str16 = str2;
        return chatEventData.copy(event, str, str16, str3, str15, str13, str14, num2, str12, str10, str11);
    }

    /* renamed from: component1, reason: from getter */
    public final Event getEvent() {
        return this.event;
    }

    /* renamed from: component10, reason: from getter */
    public final String getThought() {
        return this.thought;
    }

    /* renamed from: component11, reason: from getter */
    public final String getObservation() {
        return this.observation;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component9, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    public final ChatEventData copy(Event event, String taskId, String id, String traceId, String uid, String answer, String messageId, Integer createdAt, String conversationId, String thought, String observation) {
        k.f(taskId, "taskId");
        k.f(id, "id");
        k.f(messageId, "messageId");
        k.f(conversationId, "conversationId");
        return new ChatEventData(event, taskId, id, traceId, uid, answer, messageId, createdAt, conversationId, thought, observation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatEventData)) {
            return false;
        }
        ChatEventData chatEventData = (ChatEventData) other;
        return this.event == chatEventData.event && k.b(this.taskId, chatEventData.taskId) && k.b(this.id, chatEventData.id) && k.b(this.traceId, chatEventData.traceId) && k.b(this.uid, chatEventData.uid) && k.b(this.answer, chatEventData.answer) && k.b(this.messageId, chatEventData.messageId) && k.b(this.createdAt, chatEventData.createdAt) && k.b(this.conversationId, chatEventData.conversationId) && k.b(this.thought, chatEventData.thought) && k.b(this.observation, chatEventData.observation);
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Integer getCreatedAt() {
        return this.createdAt;
    }

    public final Event getEvent() {
        return this.event;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getObservation() {
        return this.observation;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getThought() {
        return this.thought;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        Event event = this.event;
        int iC = a.c(a.c((event == null ? 0 : event.hashCode()) * 31, 31, this.taskId), 31, this.id);
        String str = this.traceId;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uid;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.answer;
        int iC2 = a.c((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31, 31, this.messageId);
        Integer num = this.createdAt;
        int iC3 = a.c((iC2 + (num == null ? 0 : num.hashCode())) * 31, 31, this.conversationId);
        String str4 = this.thought;
        int iHashCode3 = (iC3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.observation;
        return iHashCode3 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAnswer(String str) {
        this.answer = str;
    }

    public final void setCreatedAt(Integer num) {
        this.createdAt = num;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        Event event = this.event;
        String str = this.taskId;
        String str2 = this.id;
        String str3 = this.traceId;
        String str4 = this.uid;
        String str5 = this.answer;
        String str6 = this.messageId;
        Integer num = this.createdAt;
        String str7 = this.conversationId;
        String str8 = this.thought;
        String str9 = this.observation;
        StringBuilder sb = new StringBuilder("ChatEventData(event=");
        sb.append(event);
        sb.append(", taskId=");
        sb.append(str);
        sb.append(", id=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", traceId=", str3, ", uid=");
        androidx.constraintlayout.core.dsl.a.A(sb, str4, ", answer=", str5, ", messageId=");
        sb.append(str6);
        sb.append(", createdAt=");
        sb.append(num);
        sb.append(", conversationId=");
        androidx.constraintlayout.core.dsl.a.A(sb, str7, ", thought=", str8, ", observation=");
        return a.q(sb, str9, ")");
    }

    public /* synthetic */ ChatEventData(Event event, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, int i, e eVar) {
        this(event, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, str6, (i & 128) != 0 ? null : num, str7, str8, str9);
    }
}
