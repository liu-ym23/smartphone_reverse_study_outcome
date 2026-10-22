package com.stepos.core.common.notification;

import ai.onnxruntime.a;
import com.tencent.mmkv.MMKV;
import gc.q;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDownloadNotificationRegistry {
    private static final String KEY_PREFIX = "last_id_";
    private static final String MMKV_ID = "model_dl_notif_registry";
    public static final ModelDownloadNotificationRegistry INSTANCE = new ModelDownloadNotificationRegistry();
    private static final d kv$delegate = b.b(new a9.b(12));

    private ModelDownloadNotificationRegistry() {
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

    public final int checkIdFor(String modelType) {
        g.f(modelType, "modelType");
        return (modelType.hashCode() & 65535) + 1000000;
    }

    public final void clear(String modelType) {
        g.f(modelType, "modelType");
        if (q.t0(modelType)) {
            return;
        }
        getKv().p(key(modelType));
    }

    public final int downloadIdFor(String modelType) {
        g.f(modelType, "modelType");
        return (modelType.hashCode() & 524287) + 10000;
    }

    public final Integer lastShownId(String modelType) {
        g.f(modelType, "modelType");
        if (q.t0(modelType)) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(getKv().e(-1, key(modelType)));
        if (numValueOf.intValue() > 0) {
            return numValueOf;
        }
        return null;
    }

    public final void recordShown(String modelType, int i10) {
        g.f(modelType, "modelType");
        if (q.t0(modelType) || i10 <= 0) {
            return;
        }
        getKv().i(i10, key(modelType));
    }
}
