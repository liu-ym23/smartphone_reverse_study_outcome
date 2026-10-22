package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedChorusCacheSyncMode;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CHORUS_CACHE_SYNC_MODE_PRODUCER", "CHORUS_CACHE_SYNC_MODE_RETRANSMITTER", "CHORUS_CACHE_SYNC_MODE_CONSUMER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedChorusCacheSyncMode extends Enum<LiveWrappedChorusCacheSyncMode> {
    public static final LiveWrappedChorusCacheSyncMode CHORUS_CACHE_SYNC_MODE_CONSUMER = null;
    public static final LiveWrappedChorusCacheSyncMode CHORUS_CACHE_SYNC_MODE_PRODUCER = null;
    public static final LiveWrappedChorusCacheSyncMode CHORUS_CACHE_SYNC_MODE_RETRANSMITTER = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedChorusCacheSyncMode[] f147387a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedChorusCacheSyncMode$a] */
    static {
        LiveWrappedChorusCacheSyncMode r100 = new LiveWrappedChorusCacheSyncMode("CHORUS_CACHE_SYNC_MODE_PRODUCER", 0, 0);
        CHORUS_CACHE_SYNC_MODE_PRODUCER = r100;
        LiveWrappedChorusCacheSyncMode r101 = new LiveWrappedChorusCacheSyncMode("CHORUS_CACHE_SYNC_MODE_RETRANSMITTER", 1, 1);
        CHORUS_CACHE_SYNC_MODE_RETRANSMITTER = r101;
        LiveWrappedChorusCacheSyncMode r102 = new LiveWrappedChorusCacheSyncMode("CHORUS_CACHE_SYNC_MODE_CONSUMER", 2, 2);
        CHORUS_CACHE_SYNC_MODE_CONSUMER = r102;
        f147387a = new LiveWrappedChorusCacheSyncMode[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedChorusCacheSyncMode valueOf(String r100) {
        return (LiveWrappedChorusCacheSyncMode) r27.a.a(LiveWrappedChorusCacheSyncMode.class, r100);
    }

    public static LiveWrappedChorusCacheSyncMode[] values() {
        return (LiveWrappedChorusCacheSyncMode[]) f147387a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedChorusCacheSyncMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
