package a4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u000bR%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001a"}, d2 = {"La4/z;", "", "", "name", "", "payload", "sessionId", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "c", Const.INTENT_KEY_UMID, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.z, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class StepClawEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> payload;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sessionId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String runId;

    public StepClawEvent(String name, Map<String, ? extends Object> payload, String str, String str2) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(payload, "payload");
        this.name = name;
        this.payload = payload;
        this.sessionId = str;
        this.runId = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> b() {
        return this.payload;
    }

    /* renamed from: c, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: d, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StepClawEvent)) {
            return false;
        }
        StepClawEvent stepClawEvent = (StepClawEvent) other;
        return kotlin.jvm.internal.p.d(this.name, stepClawEvent.name) && kotlin.jvm.internal.p.d(this.payload, stepClawEvent.payload) && kotlin.jvm.internal.p.d(this.sessionId, stepClawEvent.sessionId) && kotlin.jvm.internal.p.d(this.runId, stepClawEvent.runId);
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.payload.hashCode()) * 31;
        String str = this.sessionId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.runId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "StepClawEvent(name=" + this.name + ", payload=" + this.payload + ", sessionId=" + this.sessionId + ", runId=" + this.runId + ")";
    }
}
