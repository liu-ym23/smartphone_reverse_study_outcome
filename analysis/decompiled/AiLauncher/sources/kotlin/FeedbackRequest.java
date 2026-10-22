package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"LK6/s;", "", "", "secretKey", "conversationId", "messageId", "", "voteType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_UMID, "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.s, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FeedbackRequest {
    private final String conversationId;
    private final String messageId;
    private final String secretKey;
    private final int voteType;

    public FeedbackRequest(String secretKey, String conversationId, String messageId, int i10) {
        p.i(secretKey, "secretKey");
        p.i(conversationId, "conversationId");
        p.i(messageId, "messageId");
        this.secretKey = secretKey;
        this.conversationId = conversationId;
        this.messageId = messageId;
        this.voteType = i10;
    }

    /* renamed from: a, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: b, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: c, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    /* renamed from: d, reason: from getter */
    public final int getVoteType() {
        return this.voteType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackRequest)) {
            return false;
        }
        FeedbackRequest feedbackRequest = (FeedbackRequest) other;
        return p.d(this.secretKey, feedbackRequest.secretKey) && p.d(this.conversationId, feedbackRequest.conversationId) && p.d(this.messageId, feedbackRequest.messageId) && this.voteType == feedbackRequest.voteType;
    }

    public int hashCode() {
        return (((((this.secretKey.hashCode() * 31) + this.conversationId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + Integer.hashCode(this.voteType);
    }

    public String toString() {
        return "FeedbackRequest(secretKey=" + this.secretKey + ", conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", voteType=" + this.voteType + ")";
    }
}
