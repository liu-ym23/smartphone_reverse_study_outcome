package com.stepos.core.ota.storage;

import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaTaskSnapshotStoreKt {
    public static final boolean isCheckpointCarryForwardState(OtaState state) {
        g.f(state, "state");
        return (state instanceof OtaState.Queued) || (state instanceof OtaState.Checking) || (state instanceof OtaState.Verifying) || (state instanceof OtaState.Installing) || (state instanceof OtaState.Activating);
    }

    public static final boolean needsFreshInterruptedCheckpoint(OtaStateSnapshot snapshot) {
        g.f(snapshot, "snapshot");
        return isCheckpointCarryForwardState(snapshot.getState()) && snapshot.getWantsDownload();
    }
}
