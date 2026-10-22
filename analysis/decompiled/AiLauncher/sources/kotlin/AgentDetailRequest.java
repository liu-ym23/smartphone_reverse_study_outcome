package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"LK6/b;", "", "", "secretKey", "agentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AgentDetailRequest {
    private final String agentId;
    private final String secretKey;

    public AgentDetailRequest(String secretKey, String agentId) {
        p.i(secretKey, "secretKey");
        p.i(agentId, "agentId");
        this.secretKey = secretKey;
        this.agentId = agentId;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentDetailRequest)) {
            return false;
        }
        AgentDetailRequest agentDetailRequest = (AgentDetailRequest) other;
        return p.d(this.secretKey, agentDetailRequest.secretKey) && p.d(this.agentId, agentDetailRequest.agentId);
    }

    public int hashCode() {
        return (this.secretKey.hashCode() * 31) + this.agentId.hashCode();
    }

    public String toString() {
        return "AgentDetailRequest(secretKey=" + this.secretKey + ", agentId=" + this.agentId + ")";
    }
}
