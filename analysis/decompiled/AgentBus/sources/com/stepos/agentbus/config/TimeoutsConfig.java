package com.stepos.agentbus.config;

import fi.iki.elonen.NanoHTTPD;
import kotlin.Metadata;
import m.x;
import q7.f;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00065"}, d2 = {"Lcom/stepos/agentbus/config/TimeoutsConfig;", "", "connectTimeoutMs", "", "lsConnectTimeoutMs", "readTimeoutMs", "upstreamConnectTimeoutMs", "upstreamFirstByteTimeoutMs", "upstreamStreamIdleMs", "upstreamCallTimeoutMs", "invokeTimeoutMs", "llmRunTimeoutMs", "delegateTimeoutMs", "offlineFrameTTL", "watchdogTickMs", "gracefulShutdownMs", "<init>", "(JJJJJJJJJJJJJ)V", "getConnectTimeoutMs", "()J", "getLsConnectTimeoutMs", "getReadTimeoutMs", "getUpstreamConnectTimeoutMs", "getUpstreamFirstByteTimeoutMs", "getUpstreamStreamIdleMs", "getUpstreamCallTimeoutMs", "getInvokeTimeoutMs", "getLlmRunTimeoutMs", "getDelegateTimeoutMs", "getOfflineFrameTTL", "getWatchdogTickMs", "getGracefulShutdownMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TimeoutsConfig {
    private final long connectTimeoutMs;
    private final long delegateTimeoutMs;
    private final long gracefulShutdownMs;
    private final long invokeTimeoutMs;
    private final long llmRunTimeoutMs;
    private final long lsConnectTimeoutMs;
    private final long offlineFrameTTL;
    private final long readTimeoutMs;
    private final long upstreamCallTimeoutMs;
    private final long upstreamConnectTimeoutMs;
    private final long upstreamFirstByteTimeoutMs;
    private final long upstreamStreamIdleMs;
    private final long watchdogTickMs;

    public TimeoutsConfig() {
        this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 8191, null);
    }

    public static /* synthetic */ TimeoutsConfig copy$default(TimeoutsConfig timeoutsConfig, long j2, long j4, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, int i2, Object obj) {
        long j21;
        long j22;
        long j23 = (i2 & 1) != 0 ? timeoutsConfig.connectTimeoutMs : j2;
        long j24 = (i2 & 2) != 0 ? timeoutsConfig.lsConnectTimeoutMs : j4;
        long j25 = (i2 & 4) != 0 ? timeoutsConfig.readTimeoutMs : j10;
        long j26 = (i2 & 8) != 0 ? timeoutsConfig.upstreamConnectTimeoutMs : j11;
        long j27 = (i2 & 16) != 0 ? timeoutsConfig.upstreamFirstByteTimeoutMs : j12;
        long j28 = (i2 & 32) != 0 ? timeoutsConfig.upstreamStreamIdleMs : j13;
        long j29 = (i2 & 64) != 0 ? timeoutsConfig.upstreamCallTimeoutMs : j14;
        long j30 = j23;
        long j31 = (i2 & 128) != 0 ? timeoutsConfig.invokeTimeoutMs : j15;
        long j32 = (i2 & 256) != 0 ? timeoutsConfig.llmRunTimeoutMs : j16;
        long j33 = (i2 & 512) != 0 ? timeoutsConfig.delegateTimeoutMs : j17;
        long j34 = (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? timeoutsConfig.offlineFrameTTL : j18;
        long j35 = (i2 & 2048) != 0 ? timeoutsConfig.watchdogTickMs : j19;
        if ((i2 & 4096) != 0) {
            j22 = j35;
            j21 = timeoutsConfig.gracefulShutdownMs;
        } else {
            j21 = j20;
            j22 = j35;
        }
        return timeoutsConfig.copy(j30, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j22, j21);
    }

    /* renamed from: component1, reason: from getter */
    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    /* renamed from: component10, reason: from getter */
    public final long getDelegateTimeoutMs() {
        return this.delegateTimeoutMs;
    }

    /* renamed from: component11, reason: from getter */
    public final long getOfflineFrameTTL() {
        return this.offlineFrameTTL;
    }

    /* renamed from: component12, reason: from getter */
    public final long getWatchdogTickMs() {
        return this.watchdogTickMs;
    }

    /* renamed from: component13, reason: from getter */
    public final long getGracefulShutdownMs() {
        return this.gracefulShutdownMs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLsConnectTimeoutMs() {
        return this.lsConnectTimeoutMs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    /* renamed from: component4, reason: from getter */
    public final long getUpstreamConnectTimeoutMs() {
        return this.upstreamConnectTimeoutMs;
    }

    /* renamed from: component5, reason: from getter */
    public final long getUpstreamFirstByteTimeoutMs() {
        return this.upstreamFirstByteTimeoutMs;
    }

    /* renamed from: component6, reason: from getter */
    public final long getUpstreamStreamIdleMs() {
        return this.upstreamStreamIdleMs;
    }

    /* renamed from: component7, reason: from getter */
    public final long getUpstreamCallTimeoutMs() {
        return this.upstreamCallTimeoutMs;
    }

    /* renamed from: component8, reason: from getter */
    public final long getInvokeTimeoutMs() {
        return this.invokeTimeoutMs;
    }

    /* renamed from: component9, reason: from getter */
    public final long getLlmRunTimeoutMs() {
        return this.llmRunTimeoutMs;
    }

    public final TimeoutsConfig copy(long connectTimeoutMs, long lsConnectTimeoutMs, long readTimeoutMs, long upstreamConnectTimeoutMs, long upstreamFirstByteTimeoutMs, long upstreamStreamIdleMs, long upstreamCallTimeoutMs, long invokeTimeoutMs, long llmRunTimeoutMs, long delegateTimeoutMs, long offlineFrameTTL, long watchdogTickMs, long gracefulShutdownMs) {
        return new TimeoutsConfig(connectTimeoutMs, lsConnectTimeoutMs, readTimeoutMs, upstreamConnectTimeoutMs, upstreamFirstByteTimeoutMs, upstreamStreamIdleMs, upstreamCallTimeoutMs, invokeTimeoutMs, llmRunTimeoutMs, delegateTimeoutMs, offlineFrameTTL, watchdogTickMs, gracefulShutdownMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeoutsConfig)) {
            return false;
        }
        TimeoutsConfig timeoutsConfig = (TimeoutsConfig) other;
        return this.connectTimeoutMs == timeoutsConfig.connectTimeoutMs && this.lsConnectTimeoutMs == timeoutsConfig.lsConnectTimeoutMs && this.readTimeoutMs == timeoutsConfig.readTimeoutMs && this.upstreamConnectTimeoutMs == timeoutsConfig.upstreamConnectTimeoutMs && this.upstreamFirstByteTimeoutMs == timeoutsConfig.upstreamFirstByteTimeoutMs && this.upstreamStreamIdleMs == timeoutsConfig.upstreamStreamIdleMs && this.upstreamCallTimeoutMs == timeoutsConfig.upstreamCallTimeoutMs && this.invokeTimeoutMs == timeoutsConfig.invokeTimeoutMs && this.llmRunTimeoutMs == timeoutsConfig.llmRunTimeoutMs && this.delegateTimeoutMs == timeoutsConfig.delegateTimeoutMs && this.offlineFrameTTL == timeoutsConfig.offlineFrameTTL && this.watchdogTickMs == timeoutsConfig.watchdogTickMs && this.gracefulShutdownMs == timeoutsConfig.gracefulShutdownMs;
    }

    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final long getDelegateTimeoutMs() {
        return this.delegateTimeoutMs;
    }

    public final long getGracefulShutdownMs() {
        return this.gracefulShutdownMs;
    }

    public final long getInvokeTimeoutMs() {
        return this.invokeTimeoutMs;
    }

    public final long getLlmRunTimeoutMs() {
        return this.llmRunTimeoutMs;
    }

    public final long getLsConnectTimeoutMs() {
        return this.lsConnectTimeoutMs;
    }

    public final long getOfflineFrameTTL() {
        return this.offlineFrameTTL;
    }

    public final long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    public final long getUpstreamCallTimeoutMs() {
        return this.upstreamCallTimeoutMs;
    }

    public final long getUpstreamConnectTimeoutMs() {
        return this.upstreamConnectTimeoutMs;
    }

    public final long getUpstreamFirstByteTimeoutMs() {
        return this.upstreamFirstByteTimeoutMs;
    }

    public final long getUpstreamStreamIdleMs() {
        return this.upstreamStreamIdleMs;
    }

    public final long getWatchdogTickMs() {
        return this.watchdogTickMs;
    }

    public int hashCode() {
        return Long.hashCode(this.gracefulShutdownMs) + x.f(this.watchdogTickMs, x.f(this.offlineFrameTTL, x.f(this.delegateTimeoutMs, x.f(this.llmRunTimeoutMs, x.f(this.invokeTimeoutMs, x.f(this.upstreamCallTimeoutMs, x.f(this.upstreamStreamIdleMs, x.f(this.upstreamFirstByteTimeoutMs, x.f(this.upstreamConnectTimeoutMs, x.f(this.readTimeoutMs, x.f(this.lsConnectTimeoutMs, Long.hashCode(this.connectTimeoutMs) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "TimeoutsConfig(connectTimeoutMs=" + this.connectTimeoutMs + ", lsConnectTimeoutMs=" + this.lsConnectTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", upstreamConnectTimeoutMs=" + this.upstreamConnectTimeoutMs + ", upstreamFirstByteTimeoutMs=" + this.upstreamFirstByteTimeoutMs + ", upstreamStreamIdleMs=" + this.upstreamStreamIdleMs + ", upstreamCallTimeoutMs=" + this.upstreamCallTimeoutMs + ", invokeTimeoutMs=" + this.invokeTimeoutMs + ", llmRunTimeoutMs=" + this.llmRunTimeoutMs + ", delegateTimeoutMs=" + this.delegateTimeoutMs + ", offlineFrameTTL=" + this.offlineFrameTTL + ", watchdogTickMs=" + this.watchdogTickMs + ", gracefulShutdownMs=" + this.gracefulShutdownMs + ")";
    }

    public TimeoutsConfig(long j2, long j4, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20) {
        this.connectTimeoutMs = j2;
        this.lsConnectTimeoutMs = j4;
        this.readTimeoutMs = j10;
        this.upstreamConnectTimeoutMs = j11;
        this.upstreamFirstByteTimeoutMs = j12;
        this.upstreamStreamIdleMs = j13;
        this.upstreamCallTimeoutMs = j14;
        this.invokeTimeoutMs = j15;
        this.llmRunTimeoutMs = j16;
        this.delegateTimeoutMs = j17;
        this.offlineFrameTTL = j18;
        this.watchdogTickMs = j19;
        this.gracefulShutdownMs = j20;
    }

    public /* synthetic */ TimeoutsConfig(long j2, long j4, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, int i2, f fVar) {
        this((i2 & 1) != 0 ? 10000L : j2, (i2 & 2) != 0 ? 5000L : j4, (i2 & 4) != 0 ? 90000L : j10, (i2 & 8) != 0 ? 15000L : j11, (i2 & 16) != 0 ? 30000L : j12, (i2 & 32) != 0 ? 30000L : j13, (i2 & 64) != 0 ? 180000L : j14, (i2 & 128) != 0 ? 1260000L : j15, (i2 & 256) != 0 ? 120000L : j16, (i2 & 512) == 0 ? j17 : 1260000L, (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? 86400000L : j18, (i2 & 2048) == 0 ? j19 : 30000L, (i2 & 4096) != 0 ? 5000L : j20);
    }
}
