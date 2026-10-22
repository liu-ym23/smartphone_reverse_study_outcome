package com.stepos.core.ota.process;

import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.domain.TriggerSourcePolicy;
import com.stepos.core.ota.process.InterruptedResumeDecision;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InterruptedResumeGuardKt {
    public static final InterruptedResumeDecision decideInterruptedResume(boolean z, Set<? extends TriggerSource> sources, boolean z3, boolean z10) {
        g.f(sources, "sources");
        if (z) {
            return new InterruptedResumeDecision.Skip("task already active");
        }
        if (!z3 && !z10) {
            return new InterruptedResumeDecision.Skip("waiting for wifi");
        }
        TriggerSource triggerSourcePrimary = TriggerSourcePolicy.INSTANCE.primary(sources);
        if (triggerSourcePrimary == null) {
            triggerSourcePrimary = TriggerSource.SILENT;
        }
        return new InterruptedResumeDecision.Resume(triggerSourcePrimary);
    }

    public static final boolean isInterruptedResumeCandidate(PauseReason reason) {
        g.f(reason, "reason");
        return reason == PauseReason.INTERRUPTED;
    }
}
