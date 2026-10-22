package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamClientMixVideoFormat;", "", "", "value", "I", "getValue", "()I", "MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420", "MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_TEXTURE_2D", "MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_CVPIXEL_BUFFER_BGRA", "MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_NV12", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamClientMixVideoFormat extends Enum<LiveWrappedMixedStreamClientMixVideoFormat> {
    public static final LiveWrappedMixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_CVPIXEL_BUFFER_BGRA = null;
    public static final LiveWrappedMixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_TEXTURE_2D = null;
    public static final LiveWrappedMixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420 = null;
    public static final LiveWrappedMixedStreamClientMixVideoFormat MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_NV12 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamClientMixVideoFormat[] f147393a = null;
    private final int value;

    static {
        LiveWrappedMixedStreamClientMixVideoFormat r100 = new LiveWrappedMixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420", 0, 0);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420 = r100;
        LiveWrappedMixedStreamClientMixVideoFormat r101 = new LiveWrappedMixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_TEXTURE_2D", 1, 1);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_TEXTURE_2D = r101;
        LiveWrappedMixedStreamClientMixVideoFormat r102 = new LiveWrappedMixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_CVPIXEL_BUFFER_BGRA", 2, 2);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_CVPIXEL_BUFFER_BGRA = r102;
        LiveWrappedMixedStreamClientMixVideoFormat r103 = new LiveWrappedMixedStreamClientMixVideoFormat("MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_NV12", 3, 3);
        MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_NV12 = r103;
        f147393a = new LiveWrappedMixedStreamClientMixVideoFormat[]{r100, r101, r102, r103};
    }

    public static LiveWrappedMixedStreamClientMixVideoFormat valueOf(String r100) {
        return (LiveWrappedMixedStreamClientMixVideoFormat) a.a(LiveWrappedMixedStreamClientMixVideoFormat.class, r100);
    }

    public static LiveWrappedMixedStreamClientMixVideoFormat[] values() {
        return (LiveWrappedMixedStreamClientMixVideoFormat[]) f147393a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamClientMixVideoFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
