package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarCommandParcel implements Parcelable {
    public static final Parcelable.Creator<SidecarCommandParcel> CREATOR = null;
    private final String appId;
    private final String appSecret;
    private final String cliName;
    private final int command;
    private final String operationId;
    private final String production;
    private final int protocolVersion;
    private final List<String> scopes;
    private final long ttlSeconds;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<SidecarCommandParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SidecarCommandParcel createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            return new SidecarCommandParcel(r12.readInt(), r12.readString(), r12.readInt(), r12.readString(), r12.readString(), r12.readString(), (List) ZeusTransformUtils.preCheckCast(r12.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), r12.readString(), r12.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SidecarCommandParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SidecarCommandParcel[] newArray(int r1) {
            return new SidecarCommandParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SidecarCommandParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ SidecarCommandParcel copy$default(SidecarCommandParcel r12, int r13, String r14, int r15, String r16, String r17, String r18, List r19, String r20, long r21, int r23, Object r24) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        if ((r23 & 1) == 0) goto L5;
        int r3 = r12.protocolVersion;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r4 = r12.operationId;
    L11:
        if ((r23 & 4) == 0) goto L13;
        int r5 = r12.command;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r6 = r12.production;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r7 = r12.appId;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r8 = r12.appSecret;
    L27:
        if ((r23 & 64) == 0) goto L30;
        r2 = r12.scopes;
    L30:
        if ((r23 & 128) == 0) goto L32;
        String r9 = r12.cliName;
    L34:
        if ((r23 & 256) == 0) goto L36;
        long r10 = r12.ttlSeconds;
    L38:
        return r12.copy(r3, r4, r5, r6, r7, r8, r2, r9, r10);
    L36:
        r10 = r21;
        goto L38
    L32:
        r9 = r20;
        goto L34
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final String component2() {
        return this.operationId;
    }

    public final int component3() {
        return this.command;
    }

    public final String component4() {
        return this.production;
    }

    public final String component5() {
        return this.appId;
    }

    public final String component6() {
        return this.appSecret;
    }

    public final List<String> component7() {
        return this.scopes;
    }

    public final String component8() {
        return this.cliName;
    }

    public final long component9() {
        return this.ttlSeconds;
    }

    public final SidecarCommandParcel copy(int r13, String r14, int r15, String r16, String r17, String r18, List<String> r19, String r20, long r21) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        o.e(r14, "operationId");
        o.e(r8, "scopes");
        return new SidecarCommandParcel(r13, r14, r15, r16, r17, r18, r8, r20, r21);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, SidecarCommandParcel.class) == true) goto L8;
        return false;
    L8:
        SidecarCommandParcel r8 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r7, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r8.protocolVersion) goto L12;
        return false;
    L12:
        if (o.a(this.operationId, r8.operationId) == true) goto L15;
        return false;
    L15:
        if (this.command == r8.command) goto L18;
        return false;
    L18:
        if (o.a(this.production, r8.production) == true) goto L21;
        return false;
    L21:
        if (o.a(this.appId, r8.appId) == true) goto L24;
        return false;
    L24:
        if (o.a(this.appSecret, r8.appSecret) == true) goto L27;
        return false;
    L27:
        if (o.a(this.scopes, r8.scopes) == true) goto L30;
        return false;
    L30:
        if (o.a(this.cliName, r8.cliName) == true) goto L33;
        return false;
    L33:
        if (this.ttlSeconds == r8.ttlSeconds) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.protocolVersion) * 31) + this.operationId.hashCode()) * 31) + Integer.hashCode(this.command)) * 31;
        String r1 = this.production;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.appId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.appSecret;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.scopes.hashCode()) * 31;
        String r11 = this.cliName;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((r10 + r2) * 31) + Long.hashCode(this.ttlSeconds);
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SidecarCommandParcel(protocolVersion=" + this.protocolVersion + ", operationId=" + this.operationId + ", command=" + this.command + ", production=" + this.production + ", appId=" + this.appId + ", appSecret=" + this.appSecret + ", scopes=" + this.scopes + ", cliName=" + this.cliName + ", ttlSeconds=" + this.ttlSeconds + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "out");
        r3.writeInt(this.protocolVersion);
        r3.writeString(this.operationId);
        r3.writeInt(this.command);
        r3.writeString(this.production);
        r3.writeString(this.appId);
        r3.writeString(this.appSecret);
        r3.writeStringList(this.scopes);
        r3.writeString(this.cliName);
        r3.writeLong(this.ttlSeconds);
    }

    public SidecarCommandParcel(int r3, String r4, int r5, String r6, String r7, String r8, List<String> r9, String r10, long r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "operationId");
        o.e(r12, "scopes");
        this.protocolVersion = r3;
        this.operationId = r4;
        this.command = r5;
        this.production = r6;
        this.appId = r7;
        this.appSecret = r8;
        this.scopes = r12;
        this.cliName = r10;
        this.ttlSeconds = r11;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getProduction() {
        return this.production;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppSecret() {
        return this.appSecret;
    }

    public /* synthetic */ SidecarCommandParcel(int r15, String r16, int r17, String r18, String r19, String r20, List r21, String r22, long r23, int r25, h r26) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        if ((r25 & 1) == 0) goto L5;
        int r4 = 3;
    L7:
        if ((r25 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r25 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r25 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r25 & 64) == 0) goto L21;
        r1 = p.b();
    L21:
        List r10 = r1;
        if ((r25 & 128) == 0) goto L24;
        String r11 = null;
    L26:
        if ((r25 & 256) == 0) goto L28;
        long r12 = -1;
    L29:
        this(r4, r16, r17, r7, r8, r9, r10, r11, r12);
        return;
    L28:
        r12 = r23;
        goto L29
    L24:
        r11 = r22;
        goto L26
    L17:
        r9 = r20;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public final List<String> getScopes() {
        return this.scopes;
    }

    public final String getCliName() {
        return this.cliName;
    }

    public final long getTtlSeconds() {
        return this.ttlSeconds;
    }
}
