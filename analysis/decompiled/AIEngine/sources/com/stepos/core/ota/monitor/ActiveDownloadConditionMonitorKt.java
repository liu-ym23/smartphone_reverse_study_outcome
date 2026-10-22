package com.stepos.core.ota.monitor;

import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.PauseReason;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ActiveDownloadConditionMonitorKt {
    public static final boolean decideConditionInFlight(boolean z, OtaState state) {
        g.f(state, "state");
        if (!z) {
            return false;
        }
        if (state.isActive()) {
            return true;
        }
        return (state instanceof OtaState.Paused) && ((OtaState.Paused) state).getReason() != PauseReason.USER;
    }
}
