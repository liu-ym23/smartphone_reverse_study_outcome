package com.stepos.core.ota.push;

import com.tencent.mmkv.MMKV;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NoNetworkPromptStore {
    public static final int DECISION_DECLINED = 1;
    public static final int DECISION_NONE = 0;
    public static final int DECISION_SCHEDULED = 2;
    private static final String MMKV_ID = "ota_no_net_prompt";
    private static final String PREFIX_AT = "prompt_at_";
    private static final String PREFIX_DECISION = "decision_";
    public static final long WINDOW_MS = 604800000;
    public static final NoNetworkPromptStore INSTANCE = new NoNetworkPromptStore();
    private static final d kv$delegate = b.b(new a9.a(24));

    private NoNetworkPromptStore() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public final void clear(String otaId) {
        g.f(otaId, "otaId");
        getKv().p(PREFIX_DECISION.concat(otaId));
        getKv().p(PREFIX_AT.concat(otaId));
    }

    public final int recentDecision(String otaId, long j10) {
        g.f(otaId, "otaId");
        int iE = getKv().e(0, PREFIX_DECISION.concat(otaId));
        if (iE == 0) {
            return 0;
        }
        long jF = getKv().f(0L, PREFIX_AT.concat(otaId));
        if (jF <= 0 || j10 - jF >= WINDOW_MS) {
            return 0;
        }
        return iE;
    }

    public final void recordDecision(String otaId, int i10, long j10) {
        g.f(otaId, "otaId");
        getKv().i(i10, PREFIX_DECISION.concat(otaId));
        getKv().j(j10, PREFIX_AT.concat(otaId));
    }
}
