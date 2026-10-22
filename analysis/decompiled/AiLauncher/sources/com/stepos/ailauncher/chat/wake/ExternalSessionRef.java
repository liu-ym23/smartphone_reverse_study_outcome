package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u0017\u0010\u0015\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/p;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "deviceId", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "agentType", Const.INTENT_KEY_APIKEY, "sessionId", "f", "deviceName", "c", "deviceOnline", "Z", Const.INTENT_KEY_UMID, "()Z", "Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "entrySource", "Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "e", "()Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.p, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class ExternalSessionRef {
    private final String agentType;
    private final String deviceId;
    private final String deviceName;
    private final boolean deviceOnline;
    private final ChatEntrySource entrySource;
    private final String sessionId;

    /* renamed from: a, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
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
    public final boolean getDeviceOnline() {
        return this.deviceOnline;
    }

    /* renamed from: e, reason: from getter */
    public final ChatEntrySource getEntrySource() {
        return this.entrySource;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalSessionRef)) {
            return false;
        }
        ExternalSessionRef externalSessionRef = (ExternalSessionRef) other;
        return kotlin.jvm.internal.p.d(this.deviceId, externalSessionRef.deviceId) && kotlin.jvm.internal.p.d(this.agentType, externalSessionRef.agentType) && kotlin.jvm.internal.p.d(this.sessionId, externalSessionRef.sessionId) && kotlin.jvm.internal.p.d(this.deviceName, externalSessionRef.deviceName) && this.deviceOnline == externalSessionRef.deviceOnline && this.entrySource == externalSessionRef.entrySource;
    }

    /* renamed from: f, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (((((((((this.deviceId.hashCode() * 31) + this.agentType.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.deviceName.hashCode()) * 31) + Boolean.hashCode(this.deviceOnline)) * 31) + this.entrySource.hashCode();
    }

    public String toString() {
        return "ExternalSessionRef(deviceId=" + this.deviceId + ", agentType=" + this.agentType + ", sessionId=" + this.sessionId + ", deviceName=" + this.deviceName + ", deviceOnline=" + this.deviceOnline + ", entrySource=" + this.entrySource + ")";
    }
}
