package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayReconnectDiagnostics;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lb5/a0;", "markDisconnect", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "elapsedRealtimeMs", "markAutoStart", "(J)V", "resetSession", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "summary", "()Ljava/lang/String;", "Lcom/stepos/stepclaw/gateway/GatewayReconnectDiagnosticsSnapshot;", "toSnapshot", "()Lcom/stepos/stepclaw/gateway/GatewayReconnectDiagnosticsSnapshot;", "Ljava/util/concurrent/atomic/AtomicLong;", "invocations", "Ljava/util/concurrent/atomic/AtomicLong;", "getInvocations", "()Ljava/util/concurrent/atomic/AtomicLong;", "skippedNotTrigger", "getSkippedNotTrigger", "skippedCooldown", "getSkippedCooldown", "autoStarts", "getAutoStarts", "value", "lastDisconnectWallMs", "J", "getLastDisconnectWallMs", "()J", "lastAutoStartElapsedMs", "getLastAutoStartElapsedMs", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayReconnectDiagnostics {
    public static final int ATTEMPT_TRIGGER_INTERVAL = 5;
    public static final long AUTO_START_COOLDOWN_MS = 15000;
    public static final long SAMPLE_EVERY_INVOCATIONS = 25;
    private long lastAutoStartElapsedMs;
    private long lastDisconnectWallMs;
    private final AtomicLong invocations = new AtomicLong(0);
    private final AtomicLong skippedNotTrigger = new AtomicLong(0);
    private final AtomicLong skippedCooldown = new AtomicLong(0);
    private final AtomicLong autoStarts = new AtomicLong(0);

    public final AtomicLong getAutoStarts() {
        return this.autoStarts;
    }

    public final AtomicLong getInvocations() {
        return this.invocations;
    }

    public final long getLastAutoStartElapsedMs() {
        return this.lastAutoStartElapsedMs;
    }

    public final long getLastDisconnectWallMs() {
        return this.lastDisconnectWallMs;
    }

    public final AtomicLong getSkippedCooldown() {
        return this.skippedCooldown;
    }

    public final AtomicLong getSkippedNotTrigger() {
        return this.skippedNotTrigger;
    }

    public final void markAutoStart(long elapsedRealtimeMs) {
        this.lastAutoStartElapsedMs = elapsedRealtimeMs;
    }

    public final void markDisconnect() {
        this.lastDisconnectWallMs = System.currentTimeMillis();
    }

    public final void resetSession() {
        this.invocations.set(0L);
        this.skippedNotTrigger.set(0L);
        this.skippedCooldown.set(0L);
        this.autoStarts.set(0L);
        this.lastDisconnectWallMs = 0L;
        this.lastAutoStartElapsedMs = 0L;
    }

    public final String summary() {
        return "inv=" + this.invocations.get() + " skipTrig=" + this.skippedNotTrigger.get() + " skipCd=" + this.skippedCooldown.get() + " autoStart=" + this.autoStarts.get();
    }

    public final GatewayReconnectDiagnosticsSnapshot toSnapshot() {
        return new GatewayReconnectDiagnosticsSnapshot(this.invocations.get(), this.skippedNotTrigger.get(), this.skippedCooldown.get(), this.autoStarts.get(), this.lastDisconnectWallMs, this.lastAutoStartElapsedMs, AUTO_START_COOLDOWN_MS, 5);
    }
}
