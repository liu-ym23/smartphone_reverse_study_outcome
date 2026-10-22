package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/view/t8;", "", "", "deviceId", "agentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAgentId", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.t8, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class SidebarAgentKey {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String agentId;
    private final String deviceId;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/view/t8$a;", "", "<init>", "()V", "", "deviceId", "agentId", "Lcom/stepos/ailauncher/chat/view/t8;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/chat/view/t8;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.t8$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SidebarAgentKey a(String deviceId, String agentId) {
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            kotlin.jvm.internal.p.i(agentId, "agentId");
            return new SidebarAgentKey(H8.E(deviceId), H8.E(agentId));
        }

        public Companion() {
        }
    }

    public SidebarAgentKey(String deviceId, String agentId) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        this.deviceId = deviceId;
        this.agentId = agentId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SidebarAgentKey)) {
            return false;
        }
        SidebarAgentKey sidebarAgentKey = (SidebarAgentKey) other;
        return kotlin.jvm.internal.p.d(this.deviceId, sidebarAgentKey.deviceId) && kotlin.jvm.internal.p.d(this.agentId, sidebarAgentKey.agentId);
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.agentId.hashCode();
    }

    public String toString() {
        return "SidebarAgentKey(deviceId=" + this.deviceId + ", agentId=" + this.agentId + ")";
    }
}
