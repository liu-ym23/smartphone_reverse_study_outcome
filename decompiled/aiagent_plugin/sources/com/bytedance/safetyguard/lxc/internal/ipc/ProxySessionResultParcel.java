package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxySessionResultParcel implements Parcelable {
    public static final Parcelable.Creator<ProxySessionResultParcel> CREATOR = null;
    private final long bytesFromGateway;
    private final long bytesToGateway;
    private final int closeReason;
    private final int errorCode;
    private final String message;
    private final long openedStreamCount;
    private final int protocolVersion;
    private final long rejectedStreamCount;
    private final String sessionId;
    private final ActionFinishResultParcel terminalActionResult;
    private final ActionContextTokenParcel terminalActionToken;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ProxySessionResultParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxySessionResultParcel createFromParcel(Parcel r21) {
            o.e(r21, "parcel");
            int r3 = r21.readInt();
            String r4 = r21.readString();
            int r5 = r21.readInt();
            int r6 = r21.readInt();
            String r7 = r21.readString();
            long r8 = r21.readLong();
            long r10 = r21.readLong();
            long r12 = r21.readLong();
            long r14 = r21.readLong();
            ActionFinishResultParcel r16 = null;
            if (r21.readInt() != 0) goto L5;
            ActionContextTokenParcel r2 = null;
        L6:
            ActionContextTokenParcel r19 = (ActionContextTokenParcel) ZeusTransformUtils.preCheckCast(r2, ActionContextTokenParcel.class, "com.obric.aiagent.plugin");
            if (r21.readInt() == 0) goto L11;
            r16 = ActionFinishResultParcel.CREATOR.createFromParcel(r21);
        L11:
            return new ProxySessionResultParcel(r3, r4, r5, r6, r7, r8, r10, r12, r14, r19, (ActionFinishResultParcel) ZeusTransformUtils.preCheckCast(r16, ActionFinishResultParcel.class, "com.obric.aiagent.plugin"));
        L5:
            r2 = ActionContextTokenParcel.CREATOR.createFromParcel(r21);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxySessionResultParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxySessionResultParcel[] newArray(int r1) {
            return new ProxySessionResultParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxySessionResultParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ProxySessionResultParcel copy$default(ProxySessionResultParcel r16, int r17, String r18, int r19, int r20, String r21, long r22, long r24, long r26, long r28, ActionContextTokenParcel r30, ActionFinishResultParcel r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        int r2 = r16.protocolVersion;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = r16.sessionId;
    L11:
        if ((r32 & 4) == 0) goto L13;
        int r4 = r16.closeReason;
    L15:
        if ((r32 & 8) == 0) goto L17;
        int r5 = r16.errorCode;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r6 = r16.message;
    L23:
        if ((r32 & 32) == 0) goto L25;
        long r7 = r16.openedStreamCount;
    L27:
        if ((r32 & 64) == 0) goto L29;
        long r9 = r16.rejectedStreamCount;
    L31:
        if ((r32 & 128) == 0) goto L33;
        long r11 = r16.bytesFromGateway;
    L35:
        if ((r32 & 256) == 0) goto L37;
        long r13 = r16.bytesToGateway;
    L39:
        if ((r32 & 512) == 0) goto L41;
        ActionContextTokenParcel r15 = r16.terminalActionToken;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        ActionFinishResultParcel r1 = r16.terminalActionResult;
    L47:
        return r16.copy(r2, r3, r4, r5, r6, r7, r9, r11, r13, r15, r1);
    L45:
        r1 = r31;
        goto L47
    L41:
        r15 = r30;
        goto L43
    L37:
        r13 = r28;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final ActionContextTokenParcel component10() {
        return this.terminalActionToken;
    }

    public final ActionFinishResultParcel component11() {
        return this.terminalActionResult;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final int component3() {
        return this.closeReason;
    }

    public final int component4() {
        return this.errorCode;
    }

    public final String component5() {
        return this.message;
    }

    public final long component6() {
        return this.openedStreamCount;
    }

    public final long component7() {
        return this.rejectedStreamCount;
    }

    public final long component8() {
        return this.bytesFromGateway;
    }

    public final long component9() {
        return this.bytesToGateway;
    }

    public final ProxySessionResultParcel copy(int r18, String r19, int r20, int r21, String r22, long r23, long r25, long r27, long r29, ActionContextTokenParcel r31, ActionFinishResultParcel r32) {
        o.e(r19, ObricMemoryConstants.KEY_SESSION_ID);
        return new ProxySessionResultParcel(r18, r19, r20, r21, r22, r23, r25, r27, r29, r31, r32);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProxySessionResultParcel.class) == true) goto L8;
        return false;
    L8:
        ProxySessionResultParcel r10 = (ProxySessionResultParcel) ZeusTransformUtils.preCheckCast(r9, ProxySessionResultParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r10.protocolVersion) goto L12;
        return false;
    L12:
        if (o.a(this.sessionId, r10.sessionId) == true) goto L15;
        return false;
    L15:
        if (this.closeReason == r10.closeReason) goto L18;
        return false;
    L18:
        if (this.errorCode == r10.errorCode) goto L21;
        return false;
    L21:
        if (o.a(this.message, r10.message) == true) goto L24;
        return false;
    L24:
        if (this.openedStreamCount == r10.openedStreamCount) goto L27;
        return false;
    L27:
        if (this.rejectedStreamCount == r10.rejectedStreamCount) goto L30;
        return false;
    L30:
        if (this.bytesFromGateway == r10.bytesFromGateway) goto L33;
        return false;
    L33:
        if (this.bytesToGateway == r10.bytesToGateway) goto L36;
        return false;
    L36:
        if (o.a(this.terminalActionToken, r10.terminalActionToken) == true) goto L39;
        return false;
    L39:
        if (o.a(this.terminalActionResult, r10.terminalActionResult) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Integer.hashCode(this.protocolVersion) * 31) + this.sessionId.hashCode()) * 31) + Integer.hashCode(this.closeReason)) * 31) + Integer.hashCode(this.errorCode)) * 31;
        String r1 = this.message;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((r0 + r3) * 31) + Long.hashCode(this.openedStreamCount)) * 31) + Long.hashCode(this.rejectedStreamCount)) * 31) + Long.hashCode(this.bytesFromGateway)) * 31) + Long.hashCode(this.bytesToGateway)) * 31;
        ActionContextTokenParcel r5 = this.terminalActionToken;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        ActionFinishResultParcel r8 = this.terminalActionResult;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ProxySessionResultParcel(protocolVersion=").append(this.protocolVersion).append(", sessionId=").append(this.sessionId).append(", closeReason=").append(this.closeReason).append(", errorCode=").append(this.errorCode).append(", message=").append(this.message).append(", openedStreamCount=").append(this.openedStreamCount).append(", rejectedStreamCount=").append(this.rejectedStreamCount).append(", bytesFromGateway=").append(this.bytesFromGateway).append(", bytesToGateway=").append(this.bytesToGateway).append(", terminalActionToken=").append(this.terminalActionToken).append(", terminalActionResult=").append(this.terminalActionResult).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "out");
        r4.writeInt(this.protocolVersion);
        r4.writeString(this.sessionId);
        r4.writeInt(this.closeReason);
        r4.writeInt(this.errorCode);
        r4.writeString(this.message);
        r4.writeLong(this.openedStreamCount);
        r4.writeLong(this.rejectedStreamCount);
        r4.writeLong(this.bytesFromGateway);
        r4.writeLong(this.bytesToGateway);
        ActionContextTokenParcel r0 = this.terminalActionToken;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        ActionFinishResultParcel r3 = this.terminalActionResult;
        if (r3 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    public ProxySessionResultParcel(int r4, String r5, int r6, int r7, String r8, long r9, long r11, long r13, long r15, ActionContextTokenParcel r17, ActionFinishResultParcel r18) {
        o.e(r5, ObricMemoryConstants.KEY_SESSION_ID);
        this.protocolVersion = r4;
        this.sessionId = r5;
        this.closeReason = r6;
        this.errorCode = r7;
        this.message = r8;
        this.openedStreamCount = r9;
        this.rejectedStreamCount = r11;
        this.bytesFromGateway = r13;
        this.bytesToGateway = r15;
        this.terminalActionToken = r17;
        this.terminalActionResult = r18;
    }

    public /* synthetic */ ProxySessionResultParcel(int r19, String r20, int r21, int r22, String r23, long r24, long r26, long r28, long r30, ActionContextTokenParcel r32, ActionFinishResultParcel r33, int r34, h r35) {
        if ((r34 & 1) == 0) goto L5;
        int r3 = 3;
    L7:
        if ((r34 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r34 & 32) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r34 & 64) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r34 & 128) == 0) goto L21;
        long r12 = 0;
    L23:
        if ((r34 & 256) == 0) goto L25;
        long r14 = 0;
    L27:
        if ((r34 & 512) == 0) goto L29;
        ActionContextTokenParcel r16 = null;
    L31:
        if ((r34 & 1024) == 0) goto L33;
        ActionFinishResultParcel r17 = null;
    L34:
        this(r3, r20, r21, r22, r7, r8, r10, r12, r14, r16, r17);
        return;
    L33:
        r17 = r33;
        goto L34
    L29:
        r16 = r32;
        goto L31
    L25:
        r14 = r30;
        goto L27
    L21:
        r12 = r28;
        goto L23
    L17:
        r10 = r26;
        goto L19
    L13:
        r8 = r24;
        goto L15
    L9:
        r7 = r23;
        goto L11
    L5:
        r3 = r19;
        goto L7
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getCloseReason() {
        return this.closeReason;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getOpenedStreamCount() {
        return this.openedStreamCount;
    }

    public final long getRejectedStreamCount() {
        return this.rejectedStreamCount;
    }

    public final long getBytesFromGateway() {
        return this.bytesFromGateway;
    }

    public final long getBytesToGateway() {
        return this.bytesToGateway;
    }

    public final ActionContextTokenParcel getTerminalActionToken() {
        return this.terminalActionToken;
    }

    public final ActionFinishResultParcel getTerminalActionResult() {
        return this.terminalActionResult;
    }
}
