package com.stepos.core.common.notification;

import ai.onnxruntime.a;
import com.tencent.mmkv.MMKV;
import gc.q;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.d;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NotificationDismissStore {
    private static final String MMKV_ID = "notif_dismiss_store";
    private static final long SUPPRESS_WINDOW_MS = 86400000;
    public static final NotificationDismissStore INSTANCE = new NotificationDismissStore();
    private static final d kv$delegate = b.b(new a9.b(13));

    private NotificationDismissStore() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    private final String key(String str) {
        return a.k("dismiss_", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public final void clear(String modelType) {
        g.f(modelType, "modelType");
        if (q.t0(modelType)) {
            return;
        }
        try {
            getKv().p(key(modelType));
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public final boolean isSuppressed(String modelType) {
        Object objA;
        g.f(modelType, "modelType");
        try {
            long jF = getKv().f(0L, key(modelType));
            objA = Boolean.valueOf(jF > 0 && System.currentTimeMillis() - jF < SUPPRESS_WINDOW_MS);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void markDismissed(String modelType) {
        g.f(modelType, "modelType");
        if (q.t0(modelType)) {
            return;
        }
        try {
            getKv().j(System.currentTimeMillis(), key(modelType));
        } catch (Throwable th) {
            c.a(th);
        }
    }
}
