package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveWrappedVideoEncoderConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f147308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f147309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f147310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f147311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f147312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveWrappedEncoderPreference f147313f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoEncoderConfig$LiveWrappedCodecMode;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CODEC_MODE_AUTO", "CODEC_MODE_HARDWARE", "CODEC_MODE_SOFTWARE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedCodecMode extends Enum<LiveWrappedCodecMode> {
        public static final LiveWrappedCodecMode CODEC_MODE_AUTO = null;
        public static final LiveWrappedCodecMode CODEC_MODE_HARDWARE = null;
        public static final LiveWrappedCodecMode CODEC_MODE_SOFTWARE = null;
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveWrappedCodecMode[] f147314a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedCodecMode r100 = new LiveWrappedCodecMode("CODEC_MODE_AUTO", 0, 0);
            CODEC_MODE_AUTO = r100;
            LiveWrappedCodecMode r101 = new LiveWrappedCodecMode("CODEC_MODE_HARDWARE", 1, 1);
            CODEC_MODE_HARDWARE = r101;
            LiveWrappedCodecMode r102 = new LiveWrappedCodecMode("CODEC_MODE_SOFTWARE", 2, 2);
            CODEC_MODE_SOFTWARE = r102;
            f147314a = new LiveWrappedCodecMode[]{r100, r101, r102};
            Companion = new a();
        }

        public static LiveWrappedCodecMode valueOf(String r100) {
            return (LiveWrappedCodecMode) r27.a.a(LiveWrappedCodecMode.class, r100);
        }

        public static LiveWrappedCodecMode[] values() {
            return (LiveWrappedCodecMode[]) f147314a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedCodecMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoEncoderConfig$LiveWrappedEncoderPreference;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DISABLED", "MAINTAIN_FRAMERATE", "MAINTAIN_QUALITY", "AUTO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedEncoderPreference extends Enum<LiveWrappedEncoderPreference> {
        public static final LiveWrappedEncoderPreference AUTO = null;
        public static final a Companion = null;
        public static final LiveWrappedEncoderPreference DISABLED = null;
        public static final LiveWrappedEncoderPreference MAINTAIN_FRAMERATE = null;
        public static final LiveWrappedEncoderPreference MAINTAIN_QUALITY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveWrappedEncoderPreference[] f147315a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedEncoderPreference r100 = new LiveWrappedEncoderPreference("DISABLED", 0, 0);
            DISABLED = r100;
            LiveWrappedEncoderPreference r101 = new LiveWrappedEncoderPreference("MAINTAIN_FRAMERATE", 1, 1);
            MAINTAIN_FRAMERATE = r101;
            LiveWrappedEncoderPreference r102 = new LiveWrappedEncoderPreference("MAINTAIN_QUALITY", 2, 2);
            MAINTAIN_QUALITY = r102;
            LiveWrappedEncoderPreference r103 = new LiveWrappedEncoderPreference("AUTO", 3, 3);
            AUTO = r103;
            f147315a = new LiveWrappedEncoderPreference[]{r100, r101, r102, r103};
            Companion = new a();
        }

        public static LiveWrappedEncoderPreference valueOf(String r100) {
            return (LiveWrappedEncoderPreference) r27.a.a(LiveWrappedEncoderPreference.class, r100);
        }

        public static LiveWrappedEncoderPreference[] values() {
            return (LiveWrappedEncoderPreference[]) f147315a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedEncoderPreference(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoEncoderConfig$LiveWrappedVideoCodecType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CODEC_TYPE_AUTO", "CODEC_TYPE_H264", "CODEC_TYPE_BYTEVC1", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedVideoCodecType extends Enum<LiveWrappedVideoCodecType> {
        public static final LiveWrappedVideoCodecType CODEC_TYPE_AUTO = null;
        public static final LiveWrappedVideoCodecType CODEC_TYPE_BYTEVC1 = null;
        public static final LiveWrappedVideoCodecType CODEC_TYPE_H264 = null;
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveWrappedVideoCodecType[] f147316a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedVideoCodecType r100 = new LiveWrappedVideoCodecType("CODEC_TYPE_AUTO", 0, 0);
            CODEC_TYPE_AUTO = r100;
            LiveWrappedVideoCodecType r101 = new LiveWrappedVideoCodecType("CODEC_TYPE_H264", 1, 1);
            CODEC_TYPE_H264 = r101;
            LiveWrappedVideoCodecType r102 = new LiveWrappedVideoCodecType("CODEC_TYPE_BYTEVC1", 2, 2);
            CODEC_TYPE_BYTEVC1 = r102;
            f147316a = new LiveWrappedVideoCodecType[]{r100, r101, r102};
            Companion = new a();
        }

        public static LiveWrappedVideoCodecType valueOf(String r100) {
            return (LiveWrappedVideoCodecType) r27.a.a(LiveWrappedVideoCodecType.class, r100);
        }

        public static LiveWrappedVideoCodecType[] values() {
            return (LiveWrappedVideoCodecType[]) f147316a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedVideoCodecType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "VideoEncoderConfig{width=" + this.f147308a + "height=" + this.f147309b + ", frameRate=" + this.f147310c + ", maxBitrate=" + this.f147311d + ", minBitrate=" + this.f147312e + ", encodePreference=" + this.f147313f + '}';
    }

    public LiveWrappedVideoEncoderConfig(int r100, int r101, int r102, int r103, int r104) {
        this.f147311d = -1;
        this.f147313f = LiveWrappedEncoderPreference.MAINTAIN_FRAMERATE;
        LiveWrappedVideoCodecType r105 = LiveWrappedVideoCodecType.CODEC_TYPE_AUTO;
        LiveWrappedCodecMode r106 = LiveWrappedCodecMode.CODEC_MODE_AUTO;
        this.f147308a = r100;
        this.f147309b = r101;
        this.f147310c = r102;
        this.f147311d = r103;
        this.f147312e = r104;
    }
}
