package com.stepos.core.ota.push;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.tencent.mmkv.MMKV;
import dc.g;
import dc.h;
import h0.e;
import kotlin.b;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AutoUpdateTunables {
    private static final long DEFAULT_MAX_BYTES = 2147483648L;
    private static final long DEFAULT_MAX_MS = 14400000;
    private static final long DEFAULT_MIN_INTERVAL_MS = 3600000;
    private static final String KEY_MAX_BYTES = "max_uncharged_session_bytes";
    private static final String KEY_MAX_MS = "max_uncharged_session_ms";
    private static final String KEY_MIN_INTERVAL_MS = "min_request_interval_ms";
    private static final String MMKV_ID = "ota_auto_update_tunables";
    private static final String TAG = "AutoUpdateTunables";
    public static final AutoUpdateTunables INSTANCE = new AutoUpdateTunables();
    private static final g BYTES_RANGE = new g(10485760, 4294967296L);
    private static final g MS_RANGE = new g(HysteresisStrategy.DEFAULT_DWELL_MS, 21600000);
    private static final g INTERVAL_RANGE = new g(HysteresisStrategy.DEFAULT_DWELL_MS, 86400000);
    private static final d kv$delegate = b.b(new a9.a(23));

    private AutoUpdateTunables() {
    }

    public static /* synthetic */ void applyOverrides$default(AutoUpdateTunables autoUpdateTunables, Long l10, Long l11, Long l12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        if ((i10 & 2) != 0) {
            l11 = null;
        }
        if ((i10 & 4) != 0) {
            l12 = null;
        }
        autoUpdateTunables.applyOverrides(l10, l11, l12);
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$0() {
        return MMKV.o(MMKV_ID);
    }

    private final long read(String str, long j10) {
        Long lValueOf = Long.valueOf(getKv().f(j10, str));
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        return lValueOf != null ? lValueOf.longValue() : j10;
    }

    public final void applyOverrides(Long l10, Long l11, Long l12) {
        if (l10 != null) {
            INSTANCE.getKv().j(h.c0(l10.longValue(), BYTES_RANGE), KEY_MAX_BYTES);
        }
        if (l11 != null) {
            INSTANCE.getKv().j(h.c0(l11.longValue(), MS_RANGE), KEY_MAX_MS);
        }
        if (l12 != null) {
            INSTANCE.getKv().j(h.c0(l12.longValue(), INTERVAL_RANGE), KEY_MIN_INTERVAL_MS);
        }
        e.k("applyOverrides → ", dump(), LogModule.OTA, TAG);
    }

    public final String dump() {
        long j10 = 1024;
        long maxUnchargedSessionBytes = (getMaxUnchargedSessionBytes() / j10) / j10;
        long j11 = 1000;
        long maxUnchargedSessionMs = getMaxUnchargedSessionMs() / j11;
        long minRequestIntervalMs = getMinRequestIntervalMs() / j11;
        StringBuilder sbQ = ai.onnxruntime.a.q(maxUnchargedSessionBytes, "maxUnchargedBytes=", "MB maxUnchargedMs=");
        sbQ.append(maxUnchargedSessionMs);
        return a0.a.d(minRequestIntervalMs, "s minRequestIntervalMs=", "s", sbQ);
    }

    public final long getMaxUnchargedSessionBytes() {
        return read(KEY_MAX_BYTES, 2147483648L);
    }

    public final long getMaxUnchargedSessionMs() {
        return read(KEY_MAX_MS, DEFAULT_MAX_MS);
    }

    public final long getMinRequestIntervalMs() {
        return read(KEY_MIN_INTERVAL_MS, 3600000L);
    }

    public final void reset() {
        getKv().clearAll();
        AIEngineLogger.i(LogModule.OTA, TAG, "reset to defaults");
    }
}
