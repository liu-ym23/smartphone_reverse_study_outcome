package com.bytedance.safetyguard.lxc.api;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxySessionModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxySessionResult {
    private final long bytesFromGateway;
    private final long bytesToGateway;
    private final ProxySessionCloseReason closeReason;
    private final ProxySessionErrorCode errorCode;
    private final String message;
    private final int openedStreamCount;
    private final int rejectedStreamCount;
    private final String sessionId;

    public static /* synthetic */ ProxySessionResult copy$default(ProxySessionResult r12, String r13, ProxySessionCloseReason r14, ProxySessionErrorCode r15, String r16, int r17, int r18, long r19, long r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        String r2 = r12.sessionId;
    L7:
        if ((r23 & 2) == 0) goto L9;
        ProxySessionCloseReason r3 = r12.closeReason;
    L11:
        if ((r23 & 4) == 0) goto L13;
        ProxySessionErrorCode r4 = r12.errorCode;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r5 = r12.message;
    L19:
        if ((r23 & 16) == 0) goto L21;
        int r6 = r12.openedStreamCount;
    L23:
        if ((r23 & 32) == 0) goto L25;
        int r7 = r12.rejectedStreamCount;
    L27:
        if ((r23 & 64) == 0) goto L29;
        long r8 = r12.bytesFromGateway;
    L31:
        if ((r23 & 128) == 0) goto L33;
        long r10 = r12.bytesToGateway;
    L35:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r10);
    L33:
        r10 = r21;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.sessionId;
    }

    public final ProxySessionCloseReason component2() {
        return this.closeReason;
    }

    public final ProxySessionErrorCode component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.message;
    }

    public final int component5() {
        return this.openedStreamCount;
    }

    public final int component6() {
        return this.rejectedStreamCount;
    }

    public final long component7() {
        return this.bytesFromGateway;
    }

    public final long component8() {
        return this.bytesToGateway;
    }

    public final ProxySessionResult copy(String r13, ProxySessionCloseReason r14, ProxySessionErrorCode r15, String r16, int r17, int r18, long r19, long r21) {
        o.e(r13, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r14, "closeReason");
        return new ProxySessionResult(r13, r14, r15, r16, r17, r18, r19, r21);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProxySessionResult.class) == true) goto L8;
        return false;
    L8:
        ProxySessionResult r10 = (ProxySessionResult) ZeusTransformUtils.preCheckCast(r9, ProxySessionResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionId, r10.sessionId) == true) goto L12;
        return false;
    L12:
        if (this.closeReason == r10.closeReason) goto L15;
        return false;
    L15:
        if (this.errorCode == r10.errorCode) goto L18;
        return false;
    L18:
        if (o.a(this.message, r10.message) == true) goto L21;
        return false;
    L21:
        if (this.openedStreamCount == r10.openedStreamCount) goto L24;
        return false;
    L24:
        if (this.rejectedStreamCount == r10.rejectedStreamCount) goto L27;
        return false;
    L27:
        if (this.bytesFromGateway == r10.bytesFromGateway) goto L30;
        return false;
    L30:
        if (this.bytesToGateway == r10.bytesToGateway) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.sessionId.hashCode() * 31) + this.closeReason.hashCode()) * 31;
        ProxySessionErrorCode r1 = this.errorCode;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.message;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((r4 + r2) * 31) + Integer.hashCode(this.openedStreamCount)) * 31) + Integer.hashCode(this.rejectedStreamCount)) * 31) + Long.hashCode(this.bytesFromGateway)) * 31) + Long.hashCode(this.bytesToGateway);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ProxySessionResult(sessionId=" + this.sessionId + ", closeReason=" + this.closeReason + ", errorCode=" + this.errorCode + ", message=" + this.message + ", openedStreamCount=" + this.openedStreamCount + ", rejectedStreamCount=" + this.rejectedStreamCount + ", bytesFromGateway=" + this.bytesFromGateway + ", bytesToGateway=" + this.bytesToGateway + ')';
    }

    public ProxySessionResult(String r2, ProxySessionCloseReason r3, ProxySessionErrorCode r4, String r5, int r6, int r7, long r8, long r10) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r3, "closeReason");
        this.sessionId = r2;
        this.closeReason = r3;
        this.errorCode = r4;
        this.message = r5;
        this.openedStreamCount = r6;
        this.rejectedStreamCount = r7;
        this.bytesFromGateway = r8;
        this.bytesToGateway = r10;
    }

    public /* synthetic */ ProxySessionResult(String r15, ProxySessionCloseReason r16, ProxySessionErrorCode r17, String r18, int r19, int r20, long r21, long r23, int r25, h r26) {
        if ((r25 & 4) == 0) goto L5;
        ProxySessionErrorCode r6 = null;
    L7:
        if ((r25 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r25 & 16) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r25 & 32) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r25 & 64) == 0) goto L21;
        long r10 = 0;
    L23:
        if ((r25 & 128) == 0) goto L25;
        long r12 = 0;
    L26:
        this(r15, r16, r6, r7, r8, r9, r10, r12);
        return;
    L25:
        r12 = r23;
        goto L26
    L21:
        r10 = r21;
        goto L23
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
        r6 = r17;
        goto L7
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final ProxySessionCloseReason getCloseReason() {
        return this.closeReason;
    }

    public final ProxySessionErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getOpenedStreamCount() {
        return this.openedStreamCount;
    }

    public final int getRejectedStreamCount() {
        return this.rejectedStreamCount;
    }

    public final long getBytesFromGateway() {
        return this.bytesFromGateway;
    }

    public final long getBytesToGateway() {
        return this.bytesToGateway;
    }
}
