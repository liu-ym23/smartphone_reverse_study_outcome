package com.stepos.core.ota.storage;

import a9.a;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.tencent.mmkv.MMKV;
import gc.q;
import java.util.Iterator;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UserUninstallStore {
    private static final String KEY_PREFIX = "uninst_";
    private static final String MMKV_ID = "ota_user_uninstall";
    private static final String TAG = "UserUninstallStore";
    public static final UserUninstallStore INSTANCE = new UserUninstallStore();
    private static final d kv$delegate = b.b(new a(29));

    private UserUninstallStore() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    private final String key(String str) {
        return ai.onnxruntime.a.k(KEY_PREFIX, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public final void clear(String otaId) {
        g.f(otaId, "otaId");
        if (!q.t0(otaId) && getKv().c(key(otaId))) {
            getKv().p(key(otaId));
            AIEngineLogger.i(LogModule.OTA, TAG, "clear uninstall mark: ".concat(otaId));
        }
    }

    public final void clearAll(Iterable<String> otaIds) {
        g.f(otaIds, "otaIds");
        Iterator<String> it = otaIds.iterator();
        while (it.hasNext()) {
            INSTANCE.clear(it.next());
        }
    }

    public final boolean contains(String otaId) {
        g.f(otaId, "otaId");
        return !q.t0(otaId) && getKv().d(key(otaId), false);
    }

    public final void mark(String otaId) {
        g.f(otaId, "otaId");
        if (q.t0(otaId)) {
            return;
        }
        getKv().k(key(otaId), true);
        AIEngineLogger.i(LogModule.OTA, TAG, "mark uninstalled: ".concat(otaId));
    }

    public final void markAll(Iterable<String> otaIds) {
        g.f(otaIds, "otaIds");
        Iterator<String> it = otaIds.iterator();
        while (it.hasNext()) {
            INSTANCE.mark(it.next());
        }
    }
}
