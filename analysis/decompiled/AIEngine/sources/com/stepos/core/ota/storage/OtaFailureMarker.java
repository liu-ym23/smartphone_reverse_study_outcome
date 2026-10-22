package com.stepos.core.ota.storage;

import ai.onnxruntime.a;
import com.tencent.mmkv.MMKV;
import gc.q;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaFailureMarker {
    private static final String KEY_PREFIX = "fail_";
    private static final String MMKV_ID = "ota_failure_marker";
    private static final String SILENT_KEY_PREFIX = "silentfail_";
    private static final String VER_KEY_PREFIX = "failver_";
    public static final OtaFailureMarker INSTANCE = new OtaFailureMarker();
    private static final d kv$delegate = b.b(new a9.b(26));

    private OtaFailureMarker() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    private final String key(String str) {
        return a.k(KEY_PREFIX, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public static /* synthetic */ void mark$default(OtaFailureMarker otaFailureMarker, String str, boolean z, boolean z3, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z3 = false;
        }
        if ((i11 & 8) != 0) {
            i10 = 0;
        }
        otaFailureMarker.mark(str, z, z3, i10);
    }

    private final String silentKey(String str) {
        return a.k(SILENT_KEY_PREFIX, str);
    }

    private final String verKey(String str) {
        return a.k(VER_KEY_PREFIX, str);
    }

    public final void clear(String otaId) {
        g.f(otaId, "otaId");
        if (q.t0(otaId)) {
            return;
        }
        getKv().p(key(otaId));
        getKv().p(silentKey(otaId));
        getKv().p(verKey(otaId));
    }

    public final int failedVersion(String otaId) {
        g.f(otaId, "otaId");
        if (q.t0(otaId)) {
            return 0;
        }
        return getKv().e(0, verKey(otaId));
    }

    public final boolean isMarked(String otaId) {
        g.f(otaId, "otaId");
        return !q.t0(otaId) && getKv().c(key(otaId));
    }

    public final boolean isSilentFailure(String otaId) {
        g.f(otaId, "otaId");
        return !q.t0(otaId) && getKv().d(silentKey(otaId), false);
    }

    public final boolean isStaleAgainst(String otaId, int i10) {
        g.f(otaId, "otaId");
        return !q.t0(otaId) && isStaleVersion(failedVersion(otaId), i10);
    }

    public final boolean isStaleVersion(int i10, int i11) {
        return 1 <= i10 && i10 < i11;
    }

    public final void mark(String otaId, boolean z, boolean z3, int i10) {
        g.f(otaId, "otaId");
        if (q.t0(otaId)) {
            return;
        }
        getKv().i(z ? 2 : 1, key(otaId));
        MMKV kv = getKv();
        if (z3) {
            kv.k(silentKey(otaId), true);
        } else {
            kv.p(silentKey(otaId));
        }
        MMKV kv2 = getKv();
        String strVerKey = verKey(otaId);
        if (i10 > 0) {
            kv2.i(i10, strVerKey);
        } else {
            kv2.p(strVerKey);
        }
    }

    public final boolean requiresCleanRedownload(String otaId) {
        g.f(otaId, "otaId");
        return getKv().e(0, key(otaId)) == 2;
    }
}
