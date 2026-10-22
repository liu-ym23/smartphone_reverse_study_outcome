package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyServiceConfigParcel implements Parcelable {
    public static final Parcelable.Creator<ProxyServiceConfigParcel> CREATOR = null;
    private final List<String> allowedDomainRules;
    private final int[] allowedPorts;
    private final int connectTimeoutMillis;
    private final int helloTimeoutMillis;
    private final int maxPendingBytes;
    private final int maxStreams;
    private final int policyMode;
    private final int protocolVersion;
    private final int recoveryTimeoutMillis;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ProxyServiceConfigParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyServiceConfigParcel createFromParcel(Parcel r11) {
            o.e(r11, "parcel");
            return new ProxyServiceConfigParcel(r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt(), (List) ZeusTransformUtils.preCheckCast(r11.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), r11.createIntArray(), r11.readInt(), r11.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyServiceConfigParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyServiceConfigParcel[] newArray(int r1) {
            return new ProxyServiceConfigParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyServiceConfigParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ProxyServiceConfigParcel copy$default(ProxyServiceConfigParcel r10, int r11, int r12, int r13, int r14, int r15, List r16, int[] r17, int r18, int r19, int r20, Object r21) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        int r3 = r10.protocolVersion;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r4 = r10.connectTimeoutMillis;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r5 = r10.helloTimeoutMillis;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r6 = r10.maxStreams;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r7 = r10.maxPendingBytes;
    L23:
        if ((r20 & 32) == 0) goto L26;
        r2 = r10.allowedDomainRules;
    L26:
        if ((r20 & 64) == 0) goto L28;
        int[] r8 = r10.allowedPorts;
    L30:
        if ((r20 & 128) == 0) goto L32;
        int r9 = r10.policyMode;
    L34:
        if ((r20 & 256) == 0) goto L36;
        int r1 = r10.recoveryTimeoutMillis;
    L38:
        return r10.copy(r3, r4, r5, r6, r7, r2, r8, r9, r1);
    L36:
        r1 = r19;
        goto L38
    L32:
        r9 = r18;
        goto L34
    L28:
        r8 = r17;
        goto L30
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final int component2() {
        return this.connectTimeoutMillis;
    }

    public final int component3() {
        return this.helloTimeoutMillis;
    }

    public final int component4() {
        return this.maxStreams;
    }

    public final int component5() {
        return this.maxPendingBytes;
    }

    public final List<String> component6() {
        return this.allowedDomainRules;
    }

    public final int[] component7() {
        return this.allowedPorts;
    }

    public final int component8() {
        return this.policyMode;
    }

    public final int component9() {
        return this.recoveryTimeoutMillis;
    }

    public final ProxyServiceConfigParcel copy(int r12, int r13, int r14, int r15, int r16, List<String> r17, int[] r18, int r19, int r20) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "allowedDomainRules");
        o.e(r18, "allowedPorts");
        return new ProxyServiceConfigParcel(r12, r13, r14, r15, r16, r7, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProxyServiceConfigParcel.class) == true) goto L8;
        return false;
    L8:
        ProxyServiceConfigParcel r6 = (ProxyServiceConfigParcel) ZeusTransformUtils.preCheckCast(r5, ProxyServiceConfigParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r6.protocolVersion) goto L12;
        return false;
    L12:
        if (this.connectTimeoutMillis == r6.connectTimeoutMillis) goto L15;
        return false;
    L15:
        if (this.helloTimeoutMillis == r6.helloTimeoutMillis) goto L18;
        return false;
    L18:
        if (this.maxStreams == r6.maxStreams) goto L21;
        return false;
    L21:
        if (this.maxPendingBytes == r6.maxPendingBytes) goto L24;
        return false;
    L24:
        if (o.a(this.allowedDomainRules, r6.allowedDomainRules) == true) goto L27;
        return false;
    L27:
        if (o.a(this.allowedPorts, r6.allowedPorts) == true) goto L30;
        return false;
    L30:
        if (this.policyMode == r6.policyMode) goto L33;
        return false;
    L33:
        if (this.recoveryTimeoutMillis == r6.recoveryTimeoutMillis) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.protocolVersion) * 31) + Integer.hashCode(this.connectTimeoutMillis)) * 31) + Integer.hashCode(this.helloTimeoutMillis)) * 31) + Integer.hashCode(this.maxStreams)) * 31) + Integer.hashCode(this.maxPendingBytes)) * 31) + this.allowedDomainRules.hashCode()) * 31) + Arrays.hashCode(this.allowedPorts)) * 31) + Integer.hashCode(this.policyMode)) * 31) + Integer.hashCode(this.recoveryTimeoutMillis);
    }

    public String toString() {
        return "ProxyServiceConfigParcel(protocolVersion=" + this.protocolVersion + ", connectTimeoutMillis=" + this.connectTimeoutMillis + ", helloTimeoutMillis=" + this.helloTimeoutMillis + ", maxStreams=" + this.maxStreams + ", maxPendingBytes=" + this.maxPendingBytes + ", allowedDomainRules=" + this.allowedDomainRules + ", allowedPorts=" + Arrays.toString(this.allowedPorts) + ", policyMode=" + this.policyMode + ", recoveryTimeoutMillis=" + this.recoveryTimeoutMillis + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "out");
        r1.writeInt(this.protocolVersion);
        r1.writeInt(this.connectTimeoutMillis);
        r1.writeInt(this.helloTimeoutMillis);
        r1.writeInt(this.maxStreams);
        r1.writeInt(this.maxPendingBytes);
        r1.writeStringList(this.allowedDomainRules);
        r1.writeIntArray(this.allowedPorts);
        r1.writeInt(this.policyMode);
        r1.writeInt(this.recoveryTimeoutMillis);
    }

    public ProxyServiceConfigParcel(int r3, int r4, int r5, int r6, int r7, List<String> r8, int[] r9, int r10, int r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r12, "allowedDomainRules");
        o.e(r9, "allowedPorts");
        this.protocolVersion = r3;
        this.connectTimeoutMillis = r4;
        this.helloTimeoutMillis = r5;
        this.maxStreams = r6;
        this.maxPendingBytes = r7;
        this.allowedDomainRules = r12;
        this.allowedPorts = r9;
        this.policyMode = r10;
        this.recoveryTimeoutMillis = r11;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final int getHelloTimeoutMillis() {
        return this.helloTimeoutMillis;
    }

    public final int getMaxStreams() {
        return this.maxStreams;
    }

    public final int getMaxPendingBytes() {
        return this.maxPendingBytes;
    }

    public /* synthetic */ ProxyServiceConfigParcel(int r14, int r15, int r16, int r17, int r18, List r19, int[] r20, int r21, int r22, int r23, h r24) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        if ((r23 & 1) == 0) goto L5;
        int r4 = 3;
    L7:
        if ((r23 & 32) == 0) goto L9;
        r1 = p.b();
    L9:
        List r9 = r1;
        if ((r23 & 64) == 0) goto L12;
        int[] r10 = new int[0];
    L14:
        if ((r23 & 128) == 0) goto L16;
        int r11 = 0;
    L17:
        this(r4, r15, r16, r17, r18, r9, r10, r11, r22);
        return;
    L16:
        r11 = r21;
        goto L17
    L12:
        r10 = r20;
        goto L14
    L5:
        r4 = r14;
        goto L7
    }

    public final List<String> getAllowedDomainRules() {
        return this.allowedDomainRules;
    }

    public final int[] getAllowedPorts() {
        return this.allowedPorts;
    }

    public final int getPolicyMode() {
        return this.policyMode;
    }

    public final int getRecoveryTimeoutMillis() {
        return this.recoveryTimeoutMillis;
    }
}
