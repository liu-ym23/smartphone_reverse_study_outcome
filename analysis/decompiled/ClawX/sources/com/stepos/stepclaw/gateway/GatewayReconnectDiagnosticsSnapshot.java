package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayReconnectDiagnosticsSnapshot;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "invocations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "skippedNotTrigger", "skippedCooldown", "autoStarts", "lastDisconnectWallMs", "lastAutoStartElapsedMs", "cooldownMs", "attemptTriggerInterval", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(JJJJJJJI)V", "getInvocations", "()J", "getSkippedNotTrigger", "getSkippedCooldown", "getAutoStarts", "getLastDisconnectWallMs", "getLastAutoStartElapsedMs", "getCooldownMs", "getAttemptTriggerInterval", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayReconnectDiagnosticsSnapshot {
    private final int attemptTriggerInterval;
    private final long autoStarts;
    private final long cooldownMs;
    private final long invocations;
    private final long lastAutoStartElapsedMs;
    private final long lastDisconnectWallMs;
    private final long skippedCooldown;
    private final long skippedNotTrigger;

    public GatewayReconnectDiagnosticsSnapshot(long j4, long j8, long j9, long j10, long j11, long j12, long j13, int i8) {
        this.invocations = j4;
        this.skippedNotTrigger = j8;
        this.skippedCooldown = j9;
        this.autoStarts = j10;
        this.lastDisconnectWallMs = j11;
        this.lastAutoStartElapsedMs = j12;
        this.cooldownMs = j13;
        this.attemptTriggerInterval = i8;
    }

    /* renamed from: component1, reason: from getter */
    public final long getInvocations() {
        return this.invocations;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSkippedNotTrigger() {
        return this.skippedNotTrigger;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSkippedCooldown() {
        return this.skippedCooldown;
    }

    /* renamed from: component4, reason: from getter */
    public final long getAutoStarts() {
        return this.autoStarts;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLastDisconnectWallMs() {
        return this.lastDisconnectWallMs;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLastAutoStartElapsedMs() {
        return this.lastAutoStartElapsedMs;
    }

    /* renamed from: component7, reason: from getter */
    public final long getCooldownMs() {
        return this.cooldownMs;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAttemptTriggerInterval() {
        return this.attemptTriggerInterval;
    }

    public final GatewayReconnectDiagnosticsSnapshot copy(long invocations, long skippedNotTrigger, long skippedCooldown, long autoStarts, long lastDisconnectWallMs, long lastAutoStartElapsedMs, long cooldownMs, int attemptTriggerInterval) {
        return new GatewayReconnectDiagnosticsSnapshot(invocations, skippedNotTrigger, skippedCooldown, autoStarts, lastDisconnectWallMs, lastAutoStartElapsedMs, cooldownMs, attemptTriggerInterval);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayReconnectDiagnosticsSnapshot)) {
            return false;
        }
        GatewayReconnectDiagnosticsSnapshot gatewayReconnectDiagnosticsSnapshot = (GatewayReconnectDiagnosticsSnapshot) other;
        return this.invocations == gatewayReconnectDiagnosticsSnapshot.invocations && this.skippedNotTrigger == gatewayReconnectDiagnosticsSnapshot.skippedNotTrigger && this.skippedCooldown == gatewayReconnectDiagnosticsSnapshot.skippedCooldown && this.autoStarts == gatewayReconnectDiagnosticsSnapshot.autoStarts && this.lastDisconnectWallMs == gatewayReconnectDiagnosticsSnapshot.lastDisconnectWallMs && this.lastAutoStartElapsedMs == gatewayReconnectDiagnosticsSnapshot.lastAutoStartElapsedMs && this.cooldownMs == gatewayReconnectDiagnosticsSnapshot.cooldownMs && this.attemptTriggerInterval == gatewayReconnectDiagnosticsSnapshot.attemptTriggerInterval;
    }

    public final int getAttemptTriggerInterval() {
        return this.attemptTriggerInterval;
    }

    public final long getAutoStarts() {
        return this.autoStarts;
    }

    public final long getCooldownMs() {
        return this.cooldownMs;
    }

    public final long getInvocations() {
        return this.invocations;
    }

    public final long getLastAutoStartElapsedMs() {
        return this.lastAutoStartElapsedMs;
    }

    public final long getLastDisconnectWallMs() {
        return this.lastDisconnectWallMs;
    }

    public final long getSkippedCooldown() {
        return this.skippedCooldown;
    }

    public final long getSkippedNotTrigger() {
        return this.skippedNotTrigger;
    }

    public int hashCode() {
        return Integer.hashCode(this.attemptTriggerInterval) + a8.b.e(a8.b.e(a8.b.e(a8.b.e(a8.b.e(a8.b.e(Long.hashCode(this.invocations) * 31, 31, this.skippedNotTrigger), 31, this.skippedCooldown), 31, this.autoStarts), 31, this.lastDisconnectWallMs), 31, this.lastAutoStartElapsedMs), 31, this.cooldownMs);
    }

    public String toString() {
        long j4 = this.invocations;
        long j8 = this.skippedNotTrigger;
        long j9 = this.skippedCooldown;
        long j10 = this.autoStarts;
        long j11 = this.lastDisconnectWallMs;
        long j12 = this.lastAutoStartElapsedMs;
        long j13 = this.cooldownMs;
        int i8 = this.attemptTriggerInterval;
        StringBuilder sb = new StringBuilder("GatewayReconnectDiagnosticsSnapshot(invocations=");
        sb.append(j4);
        sb.append(", skippedNotTrigger=");
        sb.append(j8);
        sb.append(", skippedCooldown=");
        sb.append(j9);
        sb.append(", autoStarts=");
        sb.append(j10);
        sb.append(", lastDisconnectWallMs=");
        sb.append(j11);
        sb.append(", lastAutoStartElapsedMs=");
        sb.append(j12);
        sb.append(", cooldownMs=");
        sb.append(j13);
        sb.append(", attemptTriggerInterval=");
        return m0.f.e(sb, i8, ")");
    }
}
