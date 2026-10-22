package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/utils/LiveWrappedLogUtil$LogLevelWrapper", "", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/utils/LiveWrappedLogUtil$LogLevelWrapper;", "LOG_LEVEL_TRACE", "LOG_LEVEL_DEBUG", "LOG_LEVEL_INFO", "LOG_LEVEL_WARNING", "LOG_LEVEL_ERROR", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLogUtil$LogLevelWrapper extends Enum<LiveWrappedLogUtil$LogLevelWrapper> {
    public static final LiveWrappedLogUtil$LogLevelWrapper LOG_LEVEL_DEBUG = null;
    public static final LiveWrappedLogUtil$LogLevelWrapper LOG_LEVEL_ERROR = null;
    public static final LiveWrappedLogUtil$LogLevelWrapper LOG_LEVEL_INFO = null;
    public static final LiveWrappedLogUtil$LogLevelWrapper LOG_LEVEL_TRACE = null;
    public static final LiveWrappedLogUtil$LogLevelWrapper LOG_LEVEL_WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedLogUtil$LogLevelWrapper[] f147458a = null;

    static {
        LiveWrappedLogUtil$LogLevelWrapper r100 = new LiveWrappedLogUtil$LogLevelWrapper("LOG_LEVEL_TRACE", 0);
        LOG_LEVEL_TRACE = r100;
        LiveWrappedLogUtil$LogLevelWrapper r101 = new LiveWrappedLogUtil$LogLevelWrapper("LOG_LEVEL_DEBUG", 1);
        LOG_LEVEL_DEBUG = r101;
        LiveWrappedLogUtil$LogLevelWrapper r102 = new LiveWrappedLogUtil$LogLevelWrapper("LOG_LEVEL_INFO", 2);
        LOG_LEVEL_INFO = r102;
        LiveWrappedLogUtil$LogLevelWrapper r103 = new LiveWrappedLogUtil$LogLevelWrapper("LOG_LEVEL_WARNING", 3);
        LOG_LEVEL_WARNING = r103;
        LiveWrappedLogUtil$LogLevelWrapper r104 = new LiveWrappedLogUtil$LogLevelWrapper("LOG_LEVEL_ERROR", 4);
        LOG_LEVEL_ERROR = r104;
        f147458a = new LiveWrappedLogUtil$LogLevelWrapper[]{r100, r101, r102, r103, r104};
    }

    public static LiveWrappedLogUtil$LogLevelWrapper valueOf(String r100) {
        return (LiveWrappedLogUtil$LogLevelWrapper) a.a(LiveWrappedLogUtil$LogLevelWrapper.class, r100);
    }

    public static LiveWrappedLogUtil$LogLevelWrapper[] values() {
        return (LiveWrappedLogUtil$LogLevelWrapper[]) f147458a.clone();
    }

    public LiveWrappedLogUtil$LogLevelWrapper(String r100, int r101) {
        super(r100, r101);
    }
}
