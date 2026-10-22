package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyAttachRequestParcel implements Parcelable {
    public static final Parcelable.Creator<ProxyAttachRequestParcel> CREATOR = null;
    private final String attachmentId;
    private final ProxyServiceConfigParcel config;
    private final int protocolVersion;
    private final String sessionId;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ProxyAttachRequestParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyAttachRequestParcel createFromParcel(Parcel r6) {
            o.e(r6, "parcel");
            return new ProxyAttachRequestParcel(r6.readInt(), r6.readString(), r6.readString(), (ProxyServiceConfigParcel) ZeusTransformUtils.preCheckCast(ProxyServiceConfigParcel.CREATOR.createFromParcel(r6), ProxyServiceConfigParcel.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyAttachRequestParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyAttachRequestParcel[] newArray(int r1) {
            return new ProxyAttachRequestParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyAttachRequestParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ProxyAttachRequestParcel copy$default(ProxyAttachRequestParcel r0, int r1, String r2, String r3, ProxyServiceConfigParcel r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.protocolVersion;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.attachmentId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sessionId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.config;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final String component2() {
        return this.attachmentId;
    }

    public final String component3() {
        return this.sessionId;
    }

    public final ProxyServiceConfigParcel component4() {
        return this.config;
    }

    public final ProxyAttachRequestParcel copy(int r1, String r2, String r3, ProxyServiceConfigParcel r4) {
        o.e(r2, "attachmentId");
        o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r4, "config");
        return new ProxyAttachRequestParcel(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProxyAttachRequestParcel.class) == true) goto L8;
        return false;
    L8:
        ProxyAttachRequestParcel r6 = (ProxyAttachRequestParcel) ZeusTransformUtils.preCheckCast(r5, ProxyAttachRequestParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r6.protocolVersion) goto L12;
        return false;
    L12:
        if (o.a(this.attachmentId, r6.attachmentId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.sessionId, r6.sessionId) == true) goto L18;
        return false;
    L18:
        if (o.a(this.config, r6.config) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.protocolVersion) * 31) + this.attachmentId.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.config.hashCode();
    }

    public String toString() {
        return "ProxyAttachRequestParcel(protocolVersion=" + this.protocolVersion + ", attachmentId=" + this.attachmentId + ", sessionId=" + this.sessionId + ", config=" + this.config + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "out");
        r2.writeInt(this.protocolVersion);
        r2.writeString(this.attachmentId);
        r2.writeString(this.sessionId);
        this.config.writeToParcel(r2, r3);
    }

    public ProxyAttachRequestParcel(int r2, String r3, String r4, ProxyServiceConfigParcel r5) {
        o.e(r3, "attachmentId");
        o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r5, "config");
        this.protocolVersion = r2;
        this.attachmentId = r3;
        this.sessionId = r4;
        this.config = r5;
    }

    public /* synthetic */ ProxyAttachRequestParcel(int r1, String r2, String r3, ProxyServiceConfigParcel r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 3;
    L5:
        this(r1, r2, r3, r4);
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getAttachmentId() {
        return this.attachmentId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final ProxyServiceConfigParcel getConfig() {
        return this.config;
    }
}
