package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveWrappedVideoCaptureConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedCapturePreference f147463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f147464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f147465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f147466d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/video/LiveWrappedVideoCaptureConfig$LiveWrappedCapturePreference;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUTO", "MANUAL", "AUTO_PERFORMANCE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedCapturePreference extends Enum<LiveWrappedCapturePreference> {
        public static final LiveWrappedCapturePreference AUTO = null;
        public static final LiveWrappedCapturePreference AUTO_PERFORMANCE = null;
        public static final a Companion = null;
        public static final LiveWrappedCapturePreference MANUAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveWrappedCapturePreference[] f147467a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedCapturePreference r100 = new LiveWrappedCapturePreference("AUTO", 0, 0);
            AUTO = r100;
            LiveWrappedCapturePreference r101 = new LiveWrappedCapturePreference("MANUAL", 1, 1);
            MANUAL = r101;
            LiveWrappedCapturePreference r102 = new LiveWrappedCapturePreference("AUTO_PERFORMANCE", 2, 2);
            AUTO_PERFORMANCE = r102;
            f147467a = new LiveWrappedCapturePreference[]{r100, r101, r102};
            Companion = new a();
        }

        public static LiveWrappedCapturePreference valueOf(String r100) {
            return (LiveWrappedCapturePreference) r27.a.a(LiveWrappedCapturePreference.class, r100);
        }

        public static LiveWrappedCapturePreference[] values() {
            return (LiveWrappedCapturePreference[]) f147467a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedCapturePreference(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public final String toString() {
        return "VideoCaptureConfig{capturePreference=" + this.f147463a + "width=" + this.f147464b + ", height=" + this.f147465c + ", frameRate=" + this.f147466d + '}';
    }

    public LiveWrappedVideoCaptureConfig(int r100, int r101, int r102) {
        this.f147463a = LiveWrappedCapturePreference.AUTO;
        this.f147463a = LiveWrappedCapturePreference.MANUAL;
        this.f147464b = r100;
        this.f147465c = r101;
        this.f147466d = r102;
    }
}
