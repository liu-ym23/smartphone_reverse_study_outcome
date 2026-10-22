package com.stepos.core.ota.storage;

import ai.onnxruntime.a;
import com.tencent.mmkv.MMKV;
import gc.q;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SilentInstallFailureStore {
    private static final String KEY_PREFIX = "sif_";
    private static final String MMKV_ID = "ota_silent_install_fail";
    public static final SilentInstallFailureStore INSTANCE = new SilentInstallFailureStore();
    private static final d kv$delegate = b.b(new a9.b(28));

    private SilentInstallFailureStore() {
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

    public final void clear(String otaId) {
        g.f(otaId, "otaId");
        if (q.t0(otaId)) {
            return;
        }
        getKv().p(key(otaId));
    }

    public final boolean isFailedVersion(String otaId, int i10) {
        g.f(otaId, "otaId");
        return !q.t0(otaId) && i10 > 0 && getKv().e(0, key(otaId)) == i10;
    }

    public final void mark(String otaId, int i10) {
        g.f(otaId, "otaId");
        if (q.t0(otaId) || i10 <= 0) {
            return;
        }
        getKv().i(i10, key(otaId));
    }
}
