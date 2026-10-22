package com.stepos.ailauncher.homegesture;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilitySnapshot;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/homegesture/T;", "", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "snapshot", "", "peekOwns", "<init>", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "Z", Const.INTENT_KEY_APIKEY, "()Z", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.T, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PeekEpoch {
    private final boolean peekOwns;
    private final HomeGestureEligibilitySnapshot snapshot;

    public PeekEpoch(HomeGestureEligibilitySnapshot snapshot, boolean z10) {
        kotlin.jvm.internal.p.i(snapshot, "snapshot");
        this.snapshot = snapshot;
        this.peekOwns = z10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getPeekOwns() {
        return this.peekOwns;
    }

    /* renamed from: b, reason: from getter */
    public final HomeGestureEligibilitySnapshot getSnapshot() {
        return this.snapshot;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PeekEpoch)) {
            return false;
        }
        PeekEpoch peekEpoch = (PeekEpoch) other;
        return kotlin.jvm.internal.p.d(this.snapshot, peekEpoch.snapshot) && this.peekOwns == peekEpoch.peekOwns;
    }

    public int hashCode() {
        return (this.snapshot.hashCode() * 31) + Boolean.hashCode(this.peekOwns);
    }

    public String toString() {
        return "PeekEpoch(snapshot=" + this.snapshot + ", peekOwns=" + this.peekOwns + ")";
    }
}
