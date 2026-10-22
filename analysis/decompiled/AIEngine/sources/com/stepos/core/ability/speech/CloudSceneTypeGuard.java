package com.stepos.core.ability.speech;

import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.error.AIEngineError;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudSceneTypeGuard {
    public static final CloudSceneTypeGuard INSTANCE = new CloudSceneTypeGuard();

    private CloudSceneTypeGuard() {
    }

    public static /* synthetic */ String require$default(CloudSceneTypeGuard cloudSceneTypeGuard, p6.a aVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return cloudSceneTypeGuard.require(aVar, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String detailMessage(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r2 = "abilityId"
            kotlin.jvm.internal.g.f(r3, r2)
            java.lang.String r2 = "<unknown>"
            r0 = 0
            if (r4 == 0) goto L14
            boolean r1 = gc.q.t0(r4)
            if (r1 != 0) goto L11
            goto L12
        L11:
            r4 = r0
        L12:
            if (r4 != 0) goto L15
        L14:
            r4 = r2
        L15:
            boolean r1 = gc.q.t0(r3)
            if (r1 != 0) goto L1c
            goto L1d
        L1c:
            r3 = r0
        L1d:
            if (r3 != 0) goto L20
            goto L21
        L20:
            r2 = r3
        L21:
            java.lang.String r3 = " ability="
            java.lang.String r0 = "; apply to AIEngine with package name and ability id"
            java.lang.String r1 = "cloud scene_type not authorized: pkg="
            java.lang.String r2 = h0.e.c(r1, r4, r3, r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.CloudSceneTypeGuard.detailMessage(java.lang.String, java.lang.String):java.lang.String");
    }

    public final OrchestrationRejectedException rejectException(String abilityId, String str) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        return new OrchestrationRejectedException(AIEngineError.CLOUD_SCENE_TYPE_NOT_PERMITTED, detailMessage(abilityId, str));
    }

    public final String require(p6.a config, String str, String mode) throws OrchestrationRejectedException {
        kotlin.jvm.internal.g.f(config, "config");
        kotlin.jvm.internal.g.f(mode, "mode");
        String strD = config.d(str, mode);
        if (strD != null) {
            return strD;
        }
        throw rejectException(config.f11416a, str);
    }
}
