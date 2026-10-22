package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamMediaType;", "", "", "value", "I", "getValue", "()I", "MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO", "MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY", "MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamMediaType extends Enum<LiveWrappedMixedStreamMediaType> {
    public static final LiveWrappedMixedStreamMediaType MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO = null;
    public static final LiveWrappedMixedStreamMediaType MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY = null;
    public static final LiveWrappedMixedStreamMediaType MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamMediaType[] f147395a = null;
    private final int value;

    static {
        LiveWrappedMixedStreamMediaType r100 = new LiveWrappedMixedStreamMediaType("MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO", 0, 0);
        MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO = r100;
        LiveWrappedMixedStreamMediaType r101 = new LiveWrappedMixedStreamMediaType("MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY", 1, 1);
        MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY = r101;
        LiveWrappedMixedStreamMediaType r102 = new LiveWrappedMixedStreamMediaType("MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY", 2, 2);
        MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY = r102;
        f147395a = new LiveWrappedMixedStreamMediaType[]{r100, r101, r102};
    }

    public static LiveWrappedMixedStreamMediaType valueOf(String r100) {
        return (LiveWrappedMixedStreamMediaType) a.a(LiveWrappedMixedStreamMediaType.class, r100);
    }

    public static LiveWrappedMixedStreamMediaType[] values() {
        return (LiveWrappedMixedStreamMediaType[]) f147395a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamMediaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
