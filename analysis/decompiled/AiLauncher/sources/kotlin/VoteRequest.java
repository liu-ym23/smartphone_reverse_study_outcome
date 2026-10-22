package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"LK6/O;", "", "", "msgId", "taskId", "toolCallId", "", "voteType", "sessionId", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "I", Const.INTENT_KEY_UMID, "getSessionId", "getTraceId", "getQuestionType", "getQuestionDesc", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.O, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class VoteRequest {

    @SerializedName("msg_id")
    private final String msgId;

    @SerializedName("question_desc")
    private final String questionDesc;

    @SerializedName("question_type")
    private final String questionType;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("tool_call_id")
    private final String toolCallId;

    @SerializedName("trace_id")
    private final String traceId;

    @SerializedName("vote_type")
    private final int voteType;

    public VoteRequest(String str, String taskId, String str2, int i10, String str3, String str4, String str5, String str6) {
        p.i(taskId, "taskId");
        this.msgId = str;
        this.taskId = taskId;
        this.toolCallId = str2;
        this.voteType = i10;
        this.sessionId = str3;
        this.traceId = str4;
        this.questionType = str5;
        this.questionDesc = str6;
    }

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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoteRequest)) {
            return false;
        }
        VoteRequest voteRequest = (VoteRequest) other;
        return p.d(this.msgId, voteRequest.msgId) && p.d(this.taskId, voteRequest.taskId) && p.d(this.toolCallId, voteRequest.toolCallId) && this.voteType == voteRequest.voteType && p.d(this.sessionId, voteRequest.sessionId) && p.d(this.traceId, voteRequest.traceId) && p.d(this.questionType, voteRequest.questionType) && p.d(this.questionDesc, voteRequest.questionDesc);
    }

    public int hashCode() {
        String str = this.msgId;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.taskId.hashCode()) * 31;
        String str2 = this.toolCallId;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.voteType)) * 31;
        String str3 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.traceId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.questionType;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.questionDesc;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "VoteRequest(msgId=" + this.msgId + ", taskId=" + this.taskId + ", toolCallId=" + this.toolCallId + ", voteType=" + this.voteType + ", sessionId=" + this.sessionId + ", traceId=" + this.traceId + ", questionType=" + this.questionType + ", questionDesc=" + this.questionDesc + ")";
    }

    public /* synthetic */ VoteRequest(String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, int i11, i iVar) {
        this((i11 & 1) != 0 ? null : str, str2, (i11 & 4) != 0 ? null : str3, i10, (i11 & 16) != 0 ? "" : str4, (i11 & 32) != 0 ? "" : str5, (i11 & 64) != 0 ? null : str6, (i11 & 128) != 0 ? null : str7);
    }
}
