package V4;

import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0005R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0005R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0005R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001c"}, d2 = {"LV4/I;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "msgId", "b", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "c", Key.KEY_TOOL_CALL_ID, "", "d", "I", "()I", "voteType", "e", "getSessionId", "sessionId", "f", "getTraceId", AgentBusWakeContract.EXTRA_TRACE_ID, "g", "getQuestionType", "questionType", "h", "getQuestionDesc", "questionDesc", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class I {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @SerializedName("msg_id")
    private final String msgId;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("task_id")
    private final String taskId;

    /* renamed from: c, reason: from kotlin metadata */
    @SerializedName(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID)
    private final String toolCallId;

    /* renamed from: d, reason: from kotlin metadata */
    @SerializedName("vote_type")
    private final int voteType;

    /* renamed from: e, reason: from kotlin metadata */
    @SerializedName("session_id")
    private final String sessionId;

    /* renamed from: f, reason: from kotlin metadata */
    @SerializedName(Key.KEY_TRACE_ID)
    private final String traceId;

    /* renamed from: g, reason: from kotlin metadata */
    @SerializedName("question_type")
    private final String questionType;

    /* renamed from: h, reason: from kotlin metadata */
    @SerializedName("question_desc")
    private final String questionDesc;

    /* renamed from: a, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* renamed from: b, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: c, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: d, reason: from getter */
    public final int getVoteType() {
        return this.voteType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return false;
        }
        I i = (I) obj;
        return kotlin.jvm.internal.k.b(this.msgId, i.msgId) && kotlin.jvm.internal.k.b(this.taskId, i.taskId) && kotlin.jvm.internal.k.b(this.toolCallId, i.toolCallId) && this.voteType == i.voteType && kotlin.jvm.internal.k.b(this.sessionId, i.sessionId) && kotlin.jvm.internal.k.b(this.traceId, i.traceId) && kotlin.jvm.internal.k.b(this.questionType, i.questionType) && kotlin.jvm.internal.k.b(this.questionDesc, i.questionDesc);
    }

    public final int hashCode() {
        String str = this.msgId;
        int iC = B7.a.c((str == null ? 0 : str.hashCode()) * 31, 31, this.taskId);
        String str2 = this.toolCallId;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.voteType, (iC + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        String str3 = this.sessionId;
        int iHashCode = (iA + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.traceId;
        int iHashCode2 = (iHashCode + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.questionType;
        int iHashCode3 = (iHashCode2 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.questionDesc;
        return iHashCode3 + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        String str = this.msgId;
        String str2 = this.taskId;
        String str3 = this.toolCallId;
        int i = this.voteType;
        String str4 = this.sessionId;
        String str5 = this.traceId;
        String str6 = this.questionType;
        String str7 = this.questionDesc;
        StringBuilder sbW = B7.a.w("VoteRequest(msgId=", str, ", taskId=", str2, ", toolCallId=");
        androidx.compose.foundation.b.B(sbW, str3, ", voteType=", i, ", sessionId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str4, ", traceId=", str5, ", questionType=");
        return androidx.appfunctions.metadata.a.p(sbW, str6, ", questionDesc=", str7, ")");
    }
}
