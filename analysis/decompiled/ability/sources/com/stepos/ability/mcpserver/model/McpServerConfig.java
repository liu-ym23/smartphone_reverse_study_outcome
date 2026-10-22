package com.stepos.ability.mcpserver.model;

import androidx.compose.foundation.b;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.zyql.common.utils.upload.TOSUploader;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b=\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0013HÆ\u0003J\t\u0010G\u001a\u00020\u0013HÆ\u0003J\t\u0010H\u001a\u00020\u0013HÆ\u0003J\t\u0010I\u001a\u00020\u0013HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003Jï\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0005HÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!¨\u0006U"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpServerConfig;", "", "bindHost", "", "port", "", "maxConcurrency", "maxConnections", "maxBatchTasks", "maxLayerConcurrency", "rateLimitPerMinute", "rateLimitBurst", "rateLimitMaxBuckets", "verifyMaxConcurrent", "verifyRatePerMinute", "verifyBurst", "verifyCacheMaxValid", "verifyCacheMaxInvalid", "keyPositiveTtlMs", "", "keyMaxStaleAgeMs", "defaultTimeoutMs", "sessionIdleTimeoutMs", "sessionMaxEntries", "handshakeRatePerMinute", "handshakeBurst", "handshakeBindingsPerUid", "statsLogEveryRequests", AppAgent.CONSTRUCT, "(Ljava/lang/String;IIIIIIIIIIIIIJJJJIIIII)V", "getBindHost", "()Ljava/lang/String;", "getPort", "()I", "getMaxConcurrency", "getMaxConnections", "getMaxBatchTasks", "getMaxLayerConcurrency", "getRateLimitPerMinute", "getRateLimitBurst", "getRateLimitMaxBuckets", "getVerifyMaxConcurrent", "getVerifyRatePerMinute", "getVerifyBurst", "getVerifyCacheMaxValid", "getVerifyCacheMaxInvalid", "getKeyPositiveTtlMs", "()J", "getKeyMaxStaleAgeMs", "getDefaultTimeoutMs", "getSessionIdleTimeoutMs", "getSessionMaxEntries", "getHandshakeRatePerMinute", "getHandshakeBurst", "getHandshakeBindingsPerUid", "getStatsLogEveryRequests", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "equals", "", "other", "hashCode", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class McpServerConfig {
    private final String bindHost;
    private final long defaultTimeoutMs;
    private final int handshakeBindingsPerUid;
    private final int handshakeBurst;
    private final int handshakeRatePerMinute;
    private final long keyMaxStaleAgeMs;
    private final long keyPositiveTtlMs;
    private final int maxBatchTasks;
    private final int maxConcurrency;
    private final int maxConnections;
    private final int maxLayerConcurrency;
    private final int port;
    private final int rateLimitBurst;
    private final int rateLimitMaxBuckets;
    private final int rateLimitPerMinute;
    private final long sessionIdleTimeoutMs;
    private final int sessionMaxEntries;
    private final int statsLogEveryRequests;
    private final int verifyBurst;
    private final int verifyCacheMaxInvalid;
    private final int verifyCacheMaxValid;
    private final int verifyMaxConcurrent;
    private final int verifyRatePerMinute;

    public McpServerConfig() {
        this(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L, 0, 0, 0, 0, 0, 8388607, null);
    }

    public static /* synthetic */ McpServerConfig copy$default(McpServerConfig mcpServerConfig, String str, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, long j5, long j6, long j10, long j11, int i21, int i22, int i23, int i24, int i25, int i26, Object obj) {
        int i27;
        int i28;
        String str2 = (i26 & 1) != 0 ? mcpServerConfig.bindHost : str;
        int i29 = (i26 & 2) != 0 ? mcpServerConfig.port : i;
        int i30 = (i26 & 4) != 0 ? mcpServerConfig.maxConcurrency : i6;
        int i31 = (i26 & 8) != 0 ? mcpServerConfig.maxConnections : i10;
        int i32 = (i26 & 16) != 0 ? mcpServerConfig.maxBatchTasks : i11;
        int i33 = (i26 & 32) != 0 ? mcpServerConfig.maxLayerConcurrency : i12;
        int i34 = (i26 & 64) != 0 ? mcpServerConfig.rateLimitPerMinute : i13;
        int i35 = (i26 & 128) != 0 ? mcpServerConfig.rateLimitBurst : i14;
        int i36 = (i26 & 256) != 0 ? mcpServerConfig.rateLimitMaxBuckets : i15;
        int i37 = (i26 & 512) != 0 ? mcpServerConfig.verifyMaxConcurrent : i16;
        int i38 = (i26 & 1024) != 0 ? mcpServerConfig.verifyRatePerMinute : i17;
        int i39 = (i26 & 2048) != 0 ? mcpServerConfig.verifyBurst : i18;
        int i40 = (i26 & 4096) != 0 ? mcpServerConfig.verifyCacheMaxValid : i19;
        int i41 = (i26 & 8192) != 0 ? mcpServerConfig.verifyCacheMaxInvalid : i20;
        String str3 = str2;
        long j12 = (i26 & 16384) != 0 ? mcpServerConfig.keyPositiveTtlMs : j5;
        long j13 = (i26 & 32768) != 0 ? mcpServerConfig.keyMaxStaleAgeMs : j6;
        long j14 = (i26 & 65536) != 0 ? mcpServerConfig.defaultTimeoutMs : j10;
        long j15 = (i26 & 131072) != 0 ? mcpServerConfig.sessionIdleTimeoutMs : j11;
        int i42 = (i26 & 262144) != 0 ? mcpServerConfig.sessionMaxEntries : i21;
        int i43 = (i26 & 524288) != 0 ? mcpServerConfig.handshakeRatePerMinute : i22;
        int i44 = i42;
        int i45 = (i26 & 1048576) != 0 ? mcpServerConfig.handshakeBurst : i23;
        int i46 = (i26 & 2097152) != 0 ? mcpServerConfig.handshakeBindingsPerUid : i24;
        if ((i26 & 4194304) != 0) {
            i28 = i46;
            i27 = mcpServerConfig.statsLogEveryRequests;
        } else {
            i27 = i25;
            i28 = i46;
        }
        return mcpServerConfig.copy(str3, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, j12, j13, j14, j15, i44, i43, i45, i28, i27);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBindHost() {
        return this.bindHost;
    }

    /* renamed from: component10, reason: from getter */
    public final int getVerifyMaxConcurrent() {
        return this.verifyMaxConcurrent;
    }

    /* renamed from: component11, reason: from getter */
    public final int getVerifyRatePerMinute() {
        return this.verifyRatePerMinute;
    }

    /* renamed from: component12, reason: from getter */
    public final int getVerifyBurst() {
        return this.verifyBurst;
    }

    /* renamed from: component13, reason: from getter */
    public final int getVerifyCacheMaxValid() {
        return this.verifyCacheMaxValid;
    }

    /* renamed from: component14, reason: from getter */
    public final int getVerifyCacheMaxInvalid() {
        return this.verifyCacheMaxInvalid;
    }

    /* renamed from: component15, reason: from getter */
    public final long getKeyPositiveTtlMs() {
        return this.keyPositiveTtlMs;
    }

    /* renamed from: component16, reason: from getter */
    public final long getKeyMaxStaleAgeMs() {
        return this.keyMaxStaleAgeMs;
    }

    /* renamed from: component17, reason: from getter */
    public final long getDefaultTimeoutMs() {
        return this.defaultTimeoutMs;
    }

    /* renamed from: component18, reason: from getter */
    public final long getSessionIdleTimeoutMs() {
        return this.sessionIdleTimeoutMs;
    }

    /* renamed from: component19, reason: from getter */
    public final int getSessionMaxEntries() {
        return this.sessionMaxEntries;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component20, reason: from getter */
    public final int getHandshakeRatePerMinute() {
        return this.handshakeRatePerMinute;
    }

    /* renamed from: component21, reason: from getter */
    public final int getHandshakeBurst() {
        return this.handshakeBurst;
    }

    /* renamed from: component22, reason: from getter */
    public final int getHandshakeBindingsPerUid() {
        return this.handshakeBindingsPerUid;
    }

    /* renamed from: component23, reason: from getter */
    public final int getStatsLogEveryRequests() {
        return this.statsLogEveryRequests;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxConcurrency() {
        return this.maxConcurrency;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMaxConnections() {
        return this.maxConnections;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMaxBatchTasks() {
        return this.maxBatchTasks;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxLayerConcurrency() {
        return this.maxLayerConcurrency;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRateLimitPerMinute() {
        return this.rateLimitPerMinute;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRateLimitBurst() {
        return this.rateLimitBurst;
    }

    /* renamed from: component9, reason: from getter */
    public final int getRateLimitMaxBuckets() {
        return this.rateLimitMaxBuckets;
    }

    public final McpServerConfig copy(String bindHost, int port, int maxConcurrency, int maxConnections, int maxBatchTasks, int maxLayerConcurrency, int rateLimitPerMinute, int rateLimitBurst, int rateLimitMaxBuckets, int verifyMaxConcurrent, int verifyRatePerMinute, int verifyBurst, int verifyCacheMaxValid, int verifyCacheMaxInvalid, long keyPositiveTtlMs, long keyMaxStaleAgeMs, long defaultTimeoutMs, long sessionIdleTimeoutMs, int sessionMaxEntries, int handshakeRatePerMinute, int handshakeBurst, int handshakeBindingsPerUid, int statsLogEveryRequests) {
        k.f(bindHost, "bindHost");
        return new McpServerConfig(bindHost, port, maxConcurrency, maxConnections, maxBatchTasks, maxLayerConcurrency, rateLimitPerMinute, rateLimitBurst, rateLimitMaxBuckets, verifyMaxConcurrent, verifyRatePerMinute, verifyBurst, verifyCacheMaxValid, verifyCacheMaxInvalid, keyPositiveTtlMs, keyMaxStaleAgeMs, defaultTimeoutMs, sessionIdleTimeoutMs, sessionMaxEntries, handshakeRatePerMinute, handshakeBurst, handshakeBindingsPerUid, statsLogEveryRequests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpServerConfig)) {
            return false;
        }
        McpServerConfig mcpServerConfig = (McpServerConfig) other;
        return k.b(this.bindHost, mcpServerConfig.bindHost) && this.port == mcpServerConfig.port && this.maxConcurrency == mcpServerConfig.maxConcurrency && this.maxConnections == mcpServerConfig.maxConnections && this.maxBatchTasks == mcpServerConfig.maxBatchTasks && this.maxLayerConcurrency == mcpServerConfig.maxLayerConcurrency && this.rateLimitPerMinute == mcpServerConfig.rateLimitPerMinute && this.rateLimitBurst == mcpServerConfig.rateLimitBurst && this.rateLimitMaxBuckets == mcpServerConfig.rateLimitMaxBuckets && this.verifyMaxConcurrent == mcpServerConfig.verifyMaxConcurrent && this.verifyRatePerMinute == mcpServerConfig.verifyRatePerMinute && this.verifyBurst == mcpServerConfig.verifyBurst && this.verifyCacheMaxValid == mcpServerConfig.verifyCacheMaxValid && this.verifyCacheMaxInvalid == mcpServerConfig.verifyCacheMaxInvalid && this.keyPositiveTtlMs == mcpServerConfig.keyPositiveTtlMs && this.keyMaxStaleAgeMs == mcpServerConfig.keyMaxStaleAgeMs && this.defaultTimeoutMs == mcpServerConfig.defaultTimeoutMs && this.sessionIdleTimeoutMs == mcpServerConfig.sessionIdleTimeoutMs && this.sessionMaxEntries == mcpServerConfig.sessionMaxEntries && this.handshakeRatePerMinute == mcpServerConfig.handshakeRatePerMinute && this.handshakeBurst == mcpServerConfig.handshakeBurst && this.handshakeBindingsPerUid == mcpServerConfig.handshakeBindingsPerUid && this.statsLogEveryRequests == mcpServerConfig.statsLogEveryRequests;
    }

    public final String getBindHost() {
        return this.bindHost;
    }

    public final long getDefaultTimeoutMs() {
        return this.defaultTimeoutMs;
    }

    public final int getHandshakeBindingsPerUid() {
        return this.handshakeBindingsPerUid;
    }

    public final int getHandshakeBurst() {
        return this.handshakeBurst;
    }

    public final int getHandshakeRatePerMinute() {
        return this.handshakeRatePerMinute;
    }

    public final long getKeyMaxStaleAgeMs() {
        return this.keyMaxStaleAgeMs;
    }

    public final long getKeyPositiveTtlMs() {
        return this.keyPositiveTtlMs;
    }

    public final int getMaxBatchTasks() {
        return this.maxBatchTasks;
    }

    public final int getMaxConcurrency() {
        return this.maxConcurrency;
    }

    public final int getMaxConnections() {
        return this.maxConnections;
    }

    public final int getMaxLayerConcurrency() {
        return this.maxLayerConcurrency;
    }

    public final int getPort() {
        return this.port;
    }

    public final int getRateLimitBurst() {
        return this.rateLimitBurst;
    }

    public final int getRateLimitMaxBuckets() {
        return this.rateLimitMaxBuckets;
    }

    public final int getRateLimitPerMinute() {
        return this.rateLimitPerMinute;
    }

    public final long getSessionIdleTimeoutMs() {
        return this.sessionIdleTimeoutMs;
    }

    public final int getSessionMaxEntries() {
        return this.sessionMaxEntries;
    }

    public final int getStatsLogEveryRequests() {
        return this.statsLogEveryRequests;
    }

    public final int getVerifyBurst() {
        return this.verifyBurst;
    }

    public final int getVerifyCacheMaxInvalid() {
        return this.verifyCacheMaxInvalid;
    }

    public final int getVerifyCacheMaxValid() {
        return this.verifyCacheMaxValid;
    }

    public final int getVerifyMaxConcurrent() {
        return this.verifyMaxConcurrent;
    }

    public final int getVerifyRatePerMinute() {
        return this.verifyRatePerMinute;
    }

    public int hashCode() {
        return Integer.hashCode(this.statsLogEveryRequests) + a.a(this.handshakeBindingsPerUid, a.a(this.handshakeBurst, a.a(this.handshakeRatePerMinute, a.a(this.sessionMaxEntries, androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(a.a(this.verifyCacheMaxInvalid, a.a(this.verifyCacheMaxValid, a.a(this.verifyBurst, a.a(this.verifyRatePerMinute, a.a(this.verifyMaxConcurrent, a.a(this.rateLimitMaxBuckets, a.a(this.rateLimitBurst, a.a(this.rateLimitPerMinute, a.a(this.maxLayerConcurrency, a.a(this.maxBatchTasks, a.a(this.maxConnections, a.a(this.maxConcurrency, a.a(this.port, this.bindHost.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31, this.keyPositiveTtlMs), 31, this.keyMaxStaleAgeMs), 31, this.defaultTimeoutMs), 31, this.sessionIdleTimeoutMs), 31), 31), 31), 31);
    }

    public String toString() {
        String str = this.bindHost;
        int i = this.port;
        int i6 = this.maxConcurrency;
        int i10 = this.maxConnections;
        int i11 = this.maxBatchTasks;
        int i12 = this.maxLayerConcurrency;
        int i13 = this.rateLimitPerMinute;
        int i14 = this.rateLimitBurst;
        int i15 = this.rateLimitMaxBuckets;
        int i16 = this.verifyMaxConcurrent;
        int i17 = this.verifyRatePerMinute;
        int i18 = this.verifyBurst;
        int i19 = this.verifyCacheMaxValid;
        int i20 = this.verifyCacheMaxInvalid;
        long j5 = this.keyPositiveTtlMs;
        long j6 = this.keyMaxStaleAgeMs;
        long j10 = this.defaultTimeoutMs;
        long j11 = this.sessionIdleTimeoutMs;
        int i21 = this.sessionMaxEntries;
        int i22 = this.handshakeRatePerMinute;
        int i23 = this.handshakeBurst;
        int i24 = this.handshakeBindingsPerUid;
        int i25 = this.statsLogEveryRequests;
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "McpServerConfig(bindHost=", str, ", port=", ", maxConcurrency=");
        a.y(sbT, i6, ", maxConnections=", i10, ", maxBatchTasks=");
        a.y(sbT, i11, ", maxLayerConcurrency=", i12, ", rateLimitPerMinute=");
        a.y(sbT, i13, ", rateLimitBurst=", i14, ", rateLimitMaxBuckets=");
        a.y(sbT, i15, ", verifyMaxConcurrent=", i16, ", verifyRatePerMinute=");
        a.y(sbT, i17, ", verifyBurst=", i18, ", verifyCacheMaxValid=");
        a.y(sbT, i19, ", verifyCacheMaxInvalid=", i20, ", keyPositiveTtlMs=");
        sbT.append(j5);
        b.y(j6, ", keyMaxStaleAgeMs=", ", defaultTimeoutMs=", sbT);
        sbT.append(j10);
        b.y(j11, ", sessionIdleTimeoutMs=", ", sessionMaxEntries=", sbT);
        a.y(sbT, i21, ", handshakeRatePerMinute=", i22, ", handshakeBurst=");
        a.y(sbT, i23, ", handshakeBindingsPerUid=", i24, ", statsLogEveryRequests=");
        return androidx.appfunctions.metadata.a.o(sbT, ")", i25);
    }

    public McpServerConfig(String bindHost, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, long j5, long j6, long j10, long j11, int i21, int i22, int i23, int i24, int i25) {
        k.f(bindHost, "bindHost");
        this.bindHost = bindHost;
        this.port = i;
        this.maxConcurrency = i6;
        this.maxConnections = i10;
        this.maxBatchTasks = i11;
        this.maxLayerConcurrency = i12;
        this.rateLimitPerMinute = i13;
        this.rateLimitBurst = i14;
        this.rateLimitMaxBuckets = i15;
        this.verifyMaxConcurrent = i16;
        this.verifyRatePerMinute = i17;
        this.verifyBurst = i18;
        this.verifyCacheMaxValid = i19;
        this.verifyCacheMaxInvalid = i20;
        this.keyPositiveTtlMs = j5;
        this.keyMaxStaleAgeMs = j6;
        this.defaultTimeoutMs = j10;
        this.sessionIdleTimeoutMs = j11;
        this.sessionMaxEntries = i21;
        this.handshakeRatePerMinute = i22;
        this.handshakeBurst = i23;
        this.handshakeBindingsPerUid = i24;
        this.statsLogEveryRequests = i25;
    }

    public /* synthetic */ McpServerConfig(String str, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, long j5, long j6, long j10, long j11, int i21, int i22, int i23, int i24, int i25, int i26, e eVar) {
        this((i26 & 1) != 0 ? "127.0.0.1" : str, (i26 & 2) != 0 ? 8765 : i, (i26 & 4) != 0 ? 32 : i6, (i26 & 8) != 0 ? 64 : i10, (i26 & 16) == 0 ? i11 : 32, (i26 & 32) != 0 ? 8 : i12, (i26 & 64) != 0 ? MenuKt.InTransitionDuration : i13, (i26 & 128) != 0 ? 20 : i14, (i26 & 256) != 0 ? 512 : i15, (i26 & 512) != 0 ? 4 : i16, (i26 & 1024) != 0 ? 300 : i17, (i26 & 2048) != 0 ? 10 : i18, (i26 & 4096) != 0 ? 256 : i19, (i26 & 8192) != 0 ? 1024 : i20, (i26 & 16384) != 0 ? 3600000L : j5, (i26 & 32768) != 0 ? CalendarModelKt.MillisecondsIn24Hours : j6, (i26 & 65536) != 0 ? 30000L : j10, (i26 & 131072) != 0 ? TOSUploader.EXPIRED_TIMES : j11, (i26 & 262144) != 0 ? 256 : i21, (i26 & 524288) != 0 ? 30 : i22, (i26 & 1048576) != 0 ? 5 : i23, (i26 & 2097152) != 0 ? 4 : i24, (i26 & 4194304) != 0 ? 500 : i25);
    }
}
