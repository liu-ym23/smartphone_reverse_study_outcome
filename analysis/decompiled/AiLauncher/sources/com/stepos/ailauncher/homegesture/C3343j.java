package com.stepos.ailauncher.homegesture;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilitySnapshot;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.homegesture.AbstractC3334a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00140\u00140\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/homegesture/j;", "", "<init>", "()V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "snapshot", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;)V", "c", "Lcom/stepos/ailauncher/homegesture/T;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/homegesture/T;", "", "expectedGeneration", "currentGeneration", "", "currentConsumable", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "currentRootToken", "", "fingerprint", "Lcom/stepos/ailauncher/homegesture/a;", Const.INTENT_KEY_PKGNAME, "(JJZLcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Ljava/lang/String;)Lcom/stepos/ailauncher/homegesture/a;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastClaimedGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "lastUngeneratedConsumeAt", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "lastUngeneratedFingerprint", "Ljava/util/concurrent/atomic/AtomicReference;", "peekEpoch", "Companion", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3343j {
    public static final long UNGENERATED_DEDUP_MS = 300;
    private final AtomicLong lastClaimedGeneration = new AtomicLong(-1);
    private final AtomicLong lastUngeneratedConsumeAt = new AtomicLong(0);
    private final AtomicReference<String> lastUngeneratedFingerprint = new AtomicReference<>("");
    private final AtomicReference<PeekEpoch> peekEpoch = new AtomicReference<>(null);

    public final void a(HomeGestureEligibilitySnapshot snapshot) {
        kotlin.jvm.internal.p.i(snapshot, "snapshot");
        this.peekEpoch.set(new PeekEpoch(snapshot, snapshot.getConsumable()));
    }

    public final AbstractC3334a b(long expectedGeneration, long currentGeneration, boolean currentConsumable, HomeRootToken currentRootToken, String fingerprint) {
        kotlin.jvm.internal.p.i(currentRootToken, "currentRootToken");
        kotlin.jvm.internal.p.i(fingerprint, "fingerprint");
        PeekEpoch peekEpoch = this.peekEpoch.get();
        boolean z10 = peekEpoch != null && peekEpoch.getPeekOwns() && expectedGeneration == peekEpoch.getSnapshot().getGeneration() && expectedGeneration >= 0 && (peekEpoch.getSnapshot().getRootToken() == currentRootToken || !currentConsumable);
        if (expectedGeneration < 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = this.lastUngeneratedConsumeAt.get();
            String str = this.lastUngeneratedFingerprint.get();
            if (jElapsedRealtime - j10 < 300 && kotlin.jvm.internal.p.d(str, fingerprint)) {
                return new AbstractC3334a.Rejected("ungenerated-dup");
            }
            long j11 = this.lastClaimedGeneration.get();
            if (currentGeneration <= 0 || j11 != currentGeneration) {
                this.lastClaimedGeneration.set(currentGeneration);
                this.lastUngeneratedConsumeAt.set(jElapsedRealtime);
                this.lastUngeneratedFingerprint.set(fingerprint);
                return new AbstractC3334a.Accepted(currentGeneration, false);
            }
            return new AbstractC3334a.Rejected("already-claimed-current gen=" + currentGeneration);
        }
        boolean z11 = expectedGeneration == currentGeneration;
        if (!z11 && !z10) {
            if (currentConsumable) {
                return new AbstractC3334a.Rejected("gen-mismatch expected=" + expectedGeneration + " cur=" + currentGeneration);
            }
            return new AbstractC3334a.Rejected("stale-gen expected=" + expectedGeneration + " cur=" + currentGeneration);
        }
        if (z11) {
            expectedGeneration = currentGeneration;
        }
        long j12 = this.lastClaimedGeneration.get();
        if (j12 == expectedGeneration) {
            return new AbstractC3334a.Rejected("already-claimed gen=" + expectedGeneration);
        }
        if (this.lastClaimedGeneration.compareAndSet(j12, expectedGeneration)) {
            return new AbstractC3334a.Accepted(expectedGeneration, z10 && !z11);
        }
        return new AbstractC3334a.Rejected("cas-lost gen=" + expectedGeneration);
    }

    public final void c() {
        this.peekEpoch.set(null);
    }

    public final PeekEpoch d() {
        return this.peekEpoch.get();
    }
}
