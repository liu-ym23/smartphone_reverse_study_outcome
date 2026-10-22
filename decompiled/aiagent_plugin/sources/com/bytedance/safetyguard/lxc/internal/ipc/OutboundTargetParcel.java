package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutboundTargetParcel implements Parcelable {
    public static final Parcelable.Creator<OutboundTargetParcel> CREATOR = null;
    private final String host;
    private final int ingressProxy;
    private final int port;
    private final int protocolVersion;
    private final int type;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<OutboundTargetParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OutboundTargetParcel createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            return new OutboundTargetParcel(r7.readInt(), r7.readString(), r7.readInt(), r7.readInt(), r7.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OutboundTargetParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OutboundTargetParcel[] newArray(int r1) {
            return new OutboundTargetParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OutboundTargetParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ OutboundTargetParcel copy$default(OutboundTargetParcel r3, int r4, String r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.protocolVersion;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.host;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.port;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.type;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.ingressProxy;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final String component2() {
        return this.host;
    }

    public final int component3() {
        return this.port;
    }

    public final int component4() {
        return this.type;
    }

    public final int component5() {
        return this.ingressProxy;
    }

    public final OutboundTargetParcel copy(int r7, String r8, int r9, int r10, int r11) {
        o.e(r8, "host");
        return new OutboundTargetParcel(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OutboundTargetParcel.class) == true) goto L8;
        return false;
    L8:
        OutboundTargetParcel r6 = (OutboundTargetParcel) ZeusTransformUtils.preCheckCast(r5, OutboundTargetParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r6.protocolVersion) goto L12;
        return false;
    L12:
        if (o.a(this.host, r6.host) == true) goto L15;
        return false;
    L15:
        if (this.port == r6.port) goto L18;
        return false;
    L18:
        if (this.type == r6.type) goto L21;
        return false;
    L21:
        if (this.ingressProxy == r6.ingressProxy) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.protocolVersion) * 31) + this.host.hashCode()) * 31) + Integer.hashCode(this.port)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.ingressProxy);
    }

    public String toString() {
        return "OutboundTargetParcel(protocolVersion=" + this.protocolVersion + ", host=" + this.host + ", port=" + this.port + ", type=" + this.type + ", ingressProxy=" + this.ingressProxy + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "out");
        r1.writeInt(this.protocolVersion);
        r1.writeString(this.host);
        r1.writeInt(this.port);
        r1.writeInt(this.type);
        r1.writeInt(this.ingressProxy);
    }

    public OutboundTargetParcel(int r2, String r3, int r4, int r5, int r6) {
        o.e(r3, "host");
        this.protocolVersion = r2;
        this.host = r3;
        this.port = r4;
        this.type = r5;
        this.ingressProxy = r6;
    }

    public /* synthetic */ OutboundTargetParcel(int r7, String r8, int r9, int r10, int r11, int r12, h r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 3;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public final int getType() {
        return this.type;
    }

    public final int getIngressProxy() {
        return this.ingressProxy;
    }
}
