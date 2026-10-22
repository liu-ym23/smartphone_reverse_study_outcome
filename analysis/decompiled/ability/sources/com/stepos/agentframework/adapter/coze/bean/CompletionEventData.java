package com.stepos.agentframework.adapter.coze.bean;

import B7.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\nHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u00062"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/CompletionEventData;", "", NotificationCompat.CATEGORY_EVENT, "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "id", AgentBusWakeContract.EXTRA_TRACE_ID, "uid", "answer", "createdAt", "", "conversationId", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "getTaskId", "setTaskId", "getId", "setId", "getTraceId", "setTraceId", "getUid", "setUid", "getAnswer", "setAnswer", "getCreatedAt", "()Ljava/lang/Integer;", "setCreatedAt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getConversationId", "setConversationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stepos/agentframework/adapter/coze/bean/CompletionEventData;", "equals", "", "other", "hashCode", "toString", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CompletionEventData {

    @SerializedName("answer")
    private String answer;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("created_at")
    private Integer createdAt;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private String event;

    @SerializedName("id")
    private String id;

    @SerializedName("task_id")
    private String taskId;

    @SerializedName(Key.KEY_TRACE_ID)
    private String traceId;

    @SerializedName("uid")
    private String uid;

    public CompletionEventData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ CompletionEventData copy$default(CompletionEventData completionEventData, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = completionEventData.event;
        }
        if ((i & 2) != 0) {
            str2 = completionEventData.taskId;
        }
        if ((i & 4) != 0) {
            str3 = completionEventData.id;
        }
        if ((i & 8) != 0) {
            str4 = completionEventData.traceId;
        }
        if ((i & 16) != 0) {
            str5 = completionEventData.uid;
        }
        if ((i & 32) != 0) {
            str6 = completionEventData.answer;
        }
        if ((i & 64) != 0) {
            num = completionEventData.createdAt;
        }
        if ((i & 128) != 0) {
            str7 = completionEventData.conversationId;
        }
        Integer num2 = num;
        String str8 = str7;
        String str9 = str5;
        String str10 = str6;
        return completionEventData.copy(str, str2, str3, str4, str9, str10, num2, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEvent() {
        return this.event;
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
    public final Integer getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component8, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    public final CompletionEventData copy(String event, String taskId, String id, String traceId, String uid, String answer, Integer createdAt, String conversationId) {
        return new CompletionEventData(event, taskId, id, traceId, uid, answer, createdAt, conversationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletionEventData)) {
            return false;
        }
        CompletionEventData completionEventData = (CompletionEventData) other;
        return k.b(this.event, completionEventData.event) && k.b(this.taskId, completionEventData.taskId) && k.b(this.id, completionEventData.id) && k.b(this.traceId, completionEventData.traceId) && k.b(this.uid, completionEventData.uid) && k.b(this.answer, completionEventData.answer) && k.b(this.createdAt, completionEventData.createdAt) && k.b(this.conversationId, completionEventData.conversationId);
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

    public final String getEvent() {
        return this.event;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        String str = this.event;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.taskId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.id;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.traceId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.uid;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.answer;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.createdAt;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.conversationId;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setAnswer(String str) {
        this.answer = str;
    }

    public final void setConversationId(String str) {
        this.conversationId = str;
    }

    public final void setCreatedAt(Integer num) {
        this.createdAt = num;
    }

    public final void setEvent(String str) {
        this.event = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        String str = this.event;
        String str2 = this.taskId;
        String str3 = this.id;
        String str4 = this.traceId;
        String str5 = this.uid;
        String str6 = this.answer;
        Integer num = this.createdAt;
        String str7 = this.conversationId;
        StringBuilder sbW = a.w("CompletionEventData(event=", str, ", taskId=", str2, ", id=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", traceId=", str4, ", uid=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", answer=", str6, ", createdAt=");
        sbW.append(num);
        sbW.append(", conversationId=");
        sbW.append(str7);
        sbW.append(")");
        return sbW.toString();
    }

    public CompletionEventData(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7) {
        this.event = str;
        this.taskId = str2;
        this.id = str3;
        this.traceId = str4;
        this.uid = str5;
        this.answer = str6;
        this.createdAt = num;
        this.conversationId = str7;
    }

    public /* synthetic */ CompletionEventData(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, int i, e eVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : str7);
    }
}
