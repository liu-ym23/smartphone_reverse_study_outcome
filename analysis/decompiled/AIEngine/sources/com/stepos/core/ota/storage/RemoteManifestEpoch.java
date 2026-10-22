package com.stepos.core.ota.storage;

import a9.a;
import android.os.SystemClock;
import com.tencent.mmkv.MMKV;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RemoteManifestEpoch {
    private static final String KEY_EPOCH = "epoch";
    private static final String MMKV_ID = "ota_remote_manifest_epoch";
    public static final RemoteManifestEpoch INSTANCE = new RemoteManifestEpoch();
    private static final d kv$delegate = b.b(new a(28));

    private RemoteManifestEpoch() {
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    public final long bump() {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            getKv().j(jElapsedRealtimeNanos, KEY_EPOCH);
            return jElapsedRealtimeNanos;
        } catch (Throwable th) {
            c.a(th);
            return jElapsedRealtimeNanos;
        }
    }

    public final long current() {
        Object objA;
        try {
            objA = Long.valueOf(getKv().f(0L, KEY_EPOCH));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        return ((Number) objA).longValue();
    }
}
