package j4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.agentframework.adapter.dify.bean.Event;
import com.stepos.agentframework.chatcore.agents.y;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0004R$\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0004¨\u0006."}, d2 = {"Lj4/a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/adapter/dify/bean/Event;", "event", "Lcom/stepos/agentframework/adapter/dify/bean/Event;", "c", "()Lcom/stepos/agentframework/adapter/dify/bean/Event;", "taskId", "Ljava/lang/String;", "getTaskId", "id", "getId", DidiCardProvider.KEY_TRACE_ID, "getTraceId", "setTraceId", "(Ljava/lang/String;)V", "uid", "getUid", "setUid", "answer", Const.INTENT_KEY_APIKEY, "setAnswer", "messageId", Const.INTENT_KEY_UMID, "createdAt", "Ljava/lang/Integer;", "getCreatedAt", "()Ljava/lang/Integer;", "setCreatedAt", "(Ljava/lang/Integer;)V", "conversationId", Const.INTENT_KEY_PKGNAME, "thought", "getThought", "observation", "getObservation", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: j4.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ChatEventData {

    @SerializedName("answer")
    private String answer;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName(c.a.COL_CREATED_AT)
    private Integer createdAt;

    @SerializedName("event")
    private final Event event;

    @SerializedName("id")
    private final String id;

    @SerializedName(y.META_KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("observation")
    private final String observation;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("thought")
    private final String thought;

    @SerializedName("trace_id")
    private String traceId;

    @SerializedName("uid")
    private String uid;

    /* renamed from: a, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: b, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: c, reason: from getter */
    public final Event getEvent() {
        return this.event;
    }

    /* renamed from: d, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatEventData)) {
            return false;
        }
        ChatEventData chatEventData = (ChatEventData) other;
        return this.event == chatEventData.event && p.d(this.taskId, chatEventData.taskId) && p.d(this.id, chatEventData.id) && p.d(this.traceId, chatEventData.traceId) && p.d(this.uid, chatEventData.uid) && p.d(this.answer, chatEventData.answer) && p.d(this.messageId, chatEventData.messageId) && p.d(this.createdAt, chatEventData.createdAt) && p.d(this.conversationId, chatEventData.conversationId) && p.d(this.thought, chatEventData.thought) && p.d(this.observation, chatEventData.observation);
    }

    public int hashCode() {
        Event event = this.event;
        int iHashCode = (((((event == null ? 0 : event.hashCode()) * 31) + this.taskId.hashCode()) * 31) + this.id.hashCode()) * 31;
        String str = this.traceId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uid;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.answer;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.messageId.hashCode()) * 31;
        Integer num = this.createdAt;
        int iHashCode5 = (((iHashCode4 + (num == null ? 0 : num.hashCode())) * 31) + this.conversationId.hashCode()) * 31;
        String str4 = this.thought;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.observation;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ChatEventData(event=" + this.event + ", taskId=" + this.taskId + ", id=" + this.id + ", traceId=" + this.traceId + ", uid=" + this.uid + ", answer=" + this.answer + ", messageId=" + this.messageId + ", createdAt=" + this.createdAt + ", conversationId=" + this.conversationId + ", thought=" + this.thought + ", observation=" + this.observation + ")";
    }
}
