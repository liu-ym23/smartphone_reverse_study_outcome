package O6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sla.G;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LO6/e;", "", "", "deviceId", "deviceName", "agent", "", G.NETWORK_ONLINE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_UMID, "()Z", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: O6.e, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ExternalDeviceInfo {
    private final String agent;
    private final String deviceId;
    private final String deviceName;
    private final boolean online;

    public ExternalDeviceInfo(String deviceId, String deviceName, String agent, boolean z10) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(deviceName, "deviceName");
        kotlin.jvm.internal.p.i(agent, "agent");
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.agent = agent;
        this.online = z10;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* renamed from: b, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: c, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getOnline() {
        return this.online;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalDeviceInfo)) {
            return false;
        }
        ExternalDeviceInfo externalDeviceInfo = (ExternalDeviceInfo) other;
        return kotlin.jvm.internal.p.d(this.deviceId, externalDeviceInfo.deviceId) && kotlin.jvm.internal.p.d(this.deviceName, externalDeviceInfo.deviceName) && kotlin.jvm.internal.p.d(this.agent, externalDeviceInfo.agent) && this.online == externalDeviceInfo.online;
    }

    public int hashCode() {
        return (((((this.deviceId.hashCode() * 31) + this.deviceName.hashCode()) * 31) + this.agent.hashCode()) * 31) + Boolean.hashCode(this.online);
    }

    public String toString() {
        return "ExternalDeviceInfo(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", agent=" + this.agent + ", online=" + this.online + ")";
    }
}
