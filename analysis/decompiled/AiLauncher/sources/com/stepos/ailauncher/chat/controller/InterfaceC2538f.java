package com.stepos.ailauncher.chat.controller;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0006\n\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u0082\u0001\u0003\f\r\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/f;", "", "", "getAgentId", "()Ljava/lang/String;", "agentId", Const.INTENT_KEY_APIKEY, "deviceId", "getDisplayName", "displayName", Const.INTENT_KEY_PKGNAME, "c", "Lcom/stepos/ailauncher/chat/controller/f$a;", "Lcom/stepos/ailauncher/chat/controller/f$b;", "Lcom/stepos/ailauncher/chat/controller/f$c;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.controller.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC2538f {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/f$a;", "Lcom/stepos/ailauncher/chat/controller/f;", "<init>", "()V", "", "agentId", "Ljava/lang/String;", "getAgentId", "()Ljava/lang/String;", "deviceId", Const.INTENT_KEY_APIKEY, "displayName", "getDisplayName", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.controller.f$a */
    public static final class a implements InterfaceC2538f {
        private static final String agentId = null;
        private static final String displayName = null;
        public static final a INSTANCE = new a();
        private static final String deviceId = "";

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        /* renamed from: a */
        public String getDeviceId() {
            return deviceId;
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        public String getAgentId() {
            return agentId;
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        public String getDisplayName() {
            return displayName;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/f$b;", "Lcom/stepos/ailauncher/chat/controller/f;", "", "agentId", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAgentId", "getDisplayName", "deviceId", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.controller.f$b, reason: from toString */
    public static final /* data */ class Installed implements InterfaceC2538f {
        private final String agentId;
        private final String deviceId;
        private final String displayName;

        public Installed(String agentId, String str) {
            kotlin.jvm.internal.p.i(agentId, "agentId");
            this.agentId = agentId;
            this.displayName = str;
            this.deviceId = "";
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        /* renamed from: a, reason: from getter */
        public String getDeviceId() {
            return this.deviceId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Installed)) {
                return false;
            }
            Installed installed = (Installed) other;
            return kotlin.jvm.internal.p.d(this.agentId, installed.agentId) && kotlin.jvm.internal.p.d(this.displayName, installed.displayName);
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        public String getAgentId() {
            return this.agentId;
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        public String getDisplayName() {
            return this.displayName;
        }

        public int hashCode() {
            int iHashCode = this.agentId.hashCode() * 31;
            String str = this.displayName;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Installed(agentId=" + this.agentId + ", displayName=" + this.displayName + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/f$c;", "Lcom/stepos/ailauncher/chat/controller/f;", "", "agentId", "deviceId", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAgentId", Const.INTENT_KEY_APIKEY, "getDisplayName", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.controller.f$c, reason: from toString */
    public static final /* data */ class Proxy implements InterfaceC2538f {
        private final String agentId;
        private final String deviceId;
        private final String displayName;

        public Proxy(String agentId, String deviceId, String str) {
            kotlin.jvm.internal.p.i(agentId, "agentId");
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            this.agentId = agentId;
            this.deviceId = deviceId;
            this.displayName = str;
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        /* renamed from: a, reason: from getter */
        public String getDeviceId() {
            return this.deviceId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Proxy)) {
                return false;
            }
            Proxy proxy = (Proxy) other;
            return kotlin.jvm.internal.p.d(this.agentId, proxy.agentId) && kotlin.jvm.internal.p.d(this.deviceId, proxy.deviceId) && kotlin.jvm.internal.p.d(this.displayName, proxy.displayName);
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        public String getAgentId() {
            return this.agentId;
        }

        @Override // com.stepos.ailauncher.chat.controller.InterfaceC2538f
        public String getDisplayName() {
            return this.displayName;
        }

        public int hashCode() {
            int iHashCode = ((this.agentId.hashCode() * 31) + this.deviceId.hashCode()) * 31;
            String str = this.displayName;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Proxy(agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", displayName=" + this.displayName + ")";
        }
    }

    /* renamed from: a */
    String getDeviceId();

    String getAgentId();

    String getDisplayName();
}
