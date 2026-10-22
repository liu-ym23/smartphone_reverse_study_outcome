package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"LK6/J;", "", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "agentId", "endsideDeviceId", "endsideTraceId", "", "LK6/L;", "events", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.J, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TranscriptAppendRequest {
    private final String agentId;
    private final String endsideDeviceId;
    private final String endsideTraceId;
    private final List<TranscriptEvent> events;
    private final String sessionKey;

    public TranscriptAppendRequest(String sessionKey, String str, String str2, String str3, List<TranscriptEvent> events) {
        p.i(sessionKey, "sessionKey");
        p.i(events, "events");
        this.sessionKey = sessionKey;
        this.agentId = str;
        this.endsideDeviceId = str2;
        this.endsideTraceId = str3;
        this.events = events;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getEndsideDeviceId() {
        return this.endsideDeviceId;
    }

    /* renamed from: c, reason: from getter */
    public final String getEndsideTraceId() {
        return this.endsideTraceId;
    }

    public final List<TranscriptEvent> d() {
        return this.events;
    }

    /* renamed from: e, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranscriptAppendRequest)) {
            return false;
        }
        TranscriptAppendRequest transcriptAppendRequest = (TranscriptAppendRequest) other;
        return p.d(this.sessionKey, transcriptAppendRequest.sessionKey) && p.d(this.agentId, transcriptAppendRequest.agentId) && p.d(this.endsideDeviceId, transcriptAppendRequest.endsideDeviceId) && p.d(this.endsideTraceId, transcriptAppendRequest.endsideTraceId) && p.d(this.events, transcriptAppendRequest.events);
    }

    public int hashCode() {
        int iHashCode = this.sessionKey.hashCode() * 31;
        String str = this.agentId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.endsideDeviceId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.endsideTraceId;
        return ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.events.hashCode();
    }

    public String toString() {
        return "TranscriptAppendRequest(sessionKey=" + this.sessionKey + ", agentId=" + this.agentId + ", endsideDeviceId=" + this.endsideDeviceId + ", endsideTraceId=" + this.endsideTraceId + ", events=" + this.events + ")";
    }
}
