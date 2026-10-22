package w4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\rR\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lw4/f;", "", "", "messageId", "", "partIndex", "partType", "payloadJson", "", "updatedAt", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "J", "e", "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.f, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class MessagePart {
    private final String messageId;
    private final int partIndex;
    private final String partType;
    private final String payloadJson;
    private final long updatedAt;

    public MessagePart(String messageId, int i10, String partType, String payloadJson, long j10) {
        p.i(messageId, "messageId");
        p.i(partType, "partType");
        p.i(payloadJson, "payloadJson");
        this.messageId = messageId;
        this.partIndex = i10;
        this.partType = partType;
        this.payloadJson = payloadJson;
        this.updatedAt = j10;
    }

    /* renamed from: a, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: b, reason: from getter */
    public final int getPartIndex() {
        return this.partIndex;
    }

    /* renamed from: c, reason: from getter */
    public final String getPartType() {
        return this.partType;
    }

    /* renamed from: d, reason: from getter */
    public final String getPayloadJson() {
        return this.payloadJson;
    }

    /* renamed from: e, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessagePart)) {
            return false;
        }
        MessagePart messagePart = (MessagePart) other;
        return p.d(this.messageId, messagePart.messageId) && this.partIndex == messagePart.partIndex && p.d(this.partType, messagePart.partType) && p.d(this.payloadJson, messagePart.payloadJson) && this.updatedAt == messagePart.updatedAt;
    }

    public int hashCode() {
        return (((((((this.messageId.hashCode() * 31) + Integer.hashCode(this.partIndex)) * 31) + this.partType.hashCode()) * 31) + this.payloadJson.hashCode()) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "MessagePart(messageId=" + this.messageId + ", partIndex=" + this.partIndex + ", partType=" + this.partType + ", payloadJson=" + this.payloadJson + ", updatedAt=" + this.updatedAt + ")";
    }
}
