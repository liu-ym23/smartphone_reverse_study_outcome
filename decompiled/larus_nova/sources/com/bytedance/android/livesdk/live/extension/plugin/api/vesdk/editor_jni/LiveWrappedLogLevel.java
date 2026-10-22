package com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.editor_jni;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/vesdk/editor_jni/LiveWrappedLogLevel;", "", "", "swigValue", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LEVEL_VERBOSE", "LEVEL_DEBUG", "LEVEL_INFO", "LEVEL_WARNING", "LEVEL_ERROR", "LEVEL_ASSERT", "LEVEL_OFF", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLogLevel extends Enum<LiveWrappedLogLevel> {
    public static final LiveWrappedLogLevel LEVEL_ASSERT = null;
    public static final LiveWrappedLogLevel LEVEL_DEBUG = null;
    public static final LiveWrappedLogLevel LEVEL_ERROR = null;
    public static final LiveWrappedLogLevel LEVEL_INFO = null;
    public static final LiveWrappedLogLevel LEVEL_OFF = null;
    public static final LiveWrappedLogLevel LEVEL_VERBOSE = null;
    public static final LiveWrappedLogLevel LEVEL_WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedLogLevel[] f147471a = null;
    private final int swigValue;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f147472a = 0;

        static {
        }
    }

    static {
        LiveWrappedLogLevel r100 = new LiveWrappedLogLevel("LEVEL_VERBOSE", 0, 0);
        LEVEL_VERBOSE = r100;
        LiveWrappedLogLevel r101 = new LiveWrappedLogLevel("LEVEL_DEBUG", 1, 1);
        LEVEL_DEBUG = r101;
        LiveWrappedLogLevel r102 = new LiveWrappedLogLevel("LEVEL_INFO", 2, 2);
        LEVEL_INFO = r102;
        LiveWrappedLogLevel r103 = new LiveWrappedLogLevel("LEVEL_WARNING", 3, 3);
        LEVEL_WARNING = r103;
        LiveWrappedLogLevel r104 = new LiveWrappedLogLevel("LEVEL_ERROR", 4, 4);
        LEVEL_ERROR = r104;
        LiveWrappedLogLevel r105 = new LiveWrappedLogLevel("LEVEL_ASSERT", 5, 5);
        LEVEL_ASSERT = r105;
        LiveWrappedLogLevel r106 = new LiveWrappedLogLevel("LEVEL_OFF", 6, 6);
        LEVEL_OFF = r106;
        f147471a = new LiveWrappedLogLevel[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static LiveWrappedLogLevel valueOf(String r100) {
        return (LiveWrappedLogLevel) r27.a.a(LiveWrappedLogLevel.class, r100);
    }

    public static LiveWrappedLogLevel[] values() {
        return (LiveWrappedLogLevel[]) f147471a.clone();
    }

    public LiveWrappedLogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.swigValue = r102;
        int r103 = a.f147472a;
    }
}
