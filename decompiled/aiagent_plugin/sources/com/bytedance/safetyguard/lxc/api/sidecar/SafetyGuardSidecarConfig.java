package com.bytedance.safetyguard.lxc.api.sidecar;

import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SafetyGuardSidecarConfig {
    private final int connectTimeoutMillis;
    private final int maxRequestBodyBytes;
    private final int maxResponseBodyBytes;
    private final int readTimeoutMillis;
    private final long sessionTtlMillis;
    private final long timestampDriftMillis;

    public SafetyGuardSidecarConfig() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ SafetyGuardSidecarConfig copy$default(SafetyGuardSidecarConfig r9, long r10, long r12, int r14, int r15, int r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.sessionTtlMillis;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r3 = r9.timestampDriftMillis;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r5 = r9.maxRequestBodyBytes;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r6 = r9.maxResponseBodyBytes;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r7 = r9.connectTimeoutMillis;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r8 = r9.readTimeoutMillis;
    L27:
        return r9.copy(r1, r3, r5, r6, r7, r8);
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final long component1() {
        return this.sessionTtlMillis;
    }

    public final long component2() {
        return this.timestampDriftMillis;
    }

    public final int component3() {
        return this.maxRequestBodyBytes;
    }

    public final int component4() {
        return this.maxResponseBodyBytes;
    }

    public final int component5() {
        return this.connectTimeoutMillis;
    }

    public final int component6() {
        return this.readTimeoutMillis;
    }

    public final SafetyGuardSidecarConfig copy(long r11, long r13, int r15, int r16, int r17, int r18) {
        return new SafetyGuardSidecarConfig(r11, r13, r15, r16, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SafetyGuardSidecarConfig.class) == true) goto L8;
        return false;
    L8:
        SafetyGuardSidecarConfig r10 = (SafetyGuardSidecarConfig) ZeusTransformUtils.preCheckCast(r9, SafetyGuardSidecarConfig.class, "com.obric.aiagent.plugin");
        if (this.sessionTtlMillis == r10.sessionTtlMillis) goto L12;
        return false;
    L12:
        if (this.timestampDriftMillis == r10.timestampDriftMillis) goto L15;
        return false;
    L15:
        if (this.maxRequestBodyBytes == r10.maxRequestBodyBytes) goto L18;
        return false;
    L18:
        if (this.maxResponseBodyBytes == r10.maxResponseBodyBytes) goto L21;
        return false;
    L21:
        if (this.connectTimeoutMillis == r10.connectTimeoutMillis) goto L24;
        return false;
    L24:
        if (this.readTimeoutMillis == r10.readTimeoutMillis) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.sessionTtlMillis) * 31) + Long.hashCode(this.timestampDriftMillis)) * 31) + Integer.hashCode(this.maxRequestBodyBytes)) * 31) + Integer.hashCode(this.maxResponseBodyBytes)) * 31) + Integer.hashCode(this.connectTimeoutMillis)) * 31) + Integer.hashCode(this.readTimeoutMillis);
    }

    public String toString() {
        return "SafetyGuardSidecarConfig(sessionTtlMillis=" + this.sessionTtlMillis + ", timestampDriftMillis=" + this.timestampDriftMillis + ", maxRequestBodyBytes=" + this.maxRequestBodyBytes + ", maxResponseBodyBytes=" + this.maxResponseBodyBytes + ", connectTimeoutMillis=" + this.connectTimeoutMillis + ", readTimeoutMillis=" + this.readTimeoutMillis + ')';
    }

    public SafetyGuardSidecarConfig(long r1, long r3, int r5, int r6, int r7, int r8) {
        this.sessionTtlMillis = r1;
        this.timestampDriftMillis = r3;
        this.maxRequestBodyBytes = r5;
        this.maxResponseBodyBytes = r6;
        this.connectTimeoutMillis = r7;
        this.readTimeoutMillis = r8;
    }

    public /* synthetic */ SafetyGuardSidecarConfig(long r9, long r11, int r13, int r14, int r15, int r16, int r17, h r18) {
        if ((r17 & 1) == 0) goto L5;
        long r0 = 600000;
    L7:
        if ((r17 & 2) == 0) goto L9;
        long r2 = 60000;
    L10:
        int r5 = 33554432;
        if ((r17 & 4) == 0) goto L13;
        int r4 = 33554432;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r5 = r14;
    L19:
        if ((r17 & 16) == 0) goto L21;
        int r6 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L23:
        if ((r17 & 32) == 0) goto L25;
        int r7 = 30000;
    L26:
        this(r0, r2, r4, r5, r6, r7);
        return;
    L25:
        r7 = r16;
        goto L26
    L21:
        r6 = r15;
        goto L23
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r0 = r9;
        goto L7
    }

    public final long getSessionTtlMillis() {
        return this.sessionTtlMillis;
    }

    public final long getTimestampDriftMillis() {
        return this.timestampDriftMillis;
    }

    public final int getMaxRequestBodyBytes() {
        return this.maxRequestBodyBytes;
    }

    public final int getMaxResponseBodyBytes() {
        return this.maxResponseBodyBytes;
    }

    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }
}
