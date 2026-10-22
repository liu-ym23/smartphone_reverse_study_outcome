package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamVideoCodecType;", "", "", "getValue", "_value", "Ljava/lang/String;", "get_value", "()Ljava/lang/String;", "set_value", "(Ljava/lang/String;)V", "MIXED_STREAM_VIDEO_CODEC_TYPE_H264", "MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamVideoCodecType extends Enum<LiveWrappedMixedStreamVideoCodecType> {
    public static final LiveWrappedMixedStreamVideoCodecType MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1 = null;
    public static final LiveWrappedMixedStreamVideoCodecType MIXED_STREAM_VIDEO_CODEC_TYPE_H264 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamVideoCodecType[] f147404a = null;
    private String _value;

    static {
        LiveWrappedMixedStreamVideoCodecType r100 = new LiveWrappedMixedStreamVideoCodecType("MIXED_STREAM_VIDEO_CODEC_TYPE_H264", 0, "H264");
        MIXED_STREAM_VIDEO_CODEC_TYPE_H264 = r100;
        LiveWrappedMixedStreamVideoCodecType r101 = new LiveWrappedMixedStreamVideoCodecType("MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1", 1, "ByteVC1");
        MIXED_STREAM_VIDEO_CODEC_TYPE_BYTEVC1 = r101;
        f147404a = new LiveWrappedMixedStreamVideoCodecType[]{r100, r101};
    }

    public static LiveWrappedMixedStreamVideoCodecType valueOf(String r100) {
        return (LiveWrappedMixedStreamVideoCodecType) a.a(LiveWrappedMixedStreamVideoCodecType.class, r100);
    }

    public static LiveWrappedMixedStreamVideoCodecType[] values() {
        return (LiveWrappedMixedStreamVideoCodecType[]) f147404a.clone();
    }

    public final String getValue() {
        return this._value;
    }

    public final String get_value() {
        return this._value;
    }

    public final void set_value(String r100) {
        this._value = r100;
    }

    public LiveWrappedMixedStreamVideoCodecType(String r100, int r101, String r102) {
        super(r100, r101);
        this._value = r102;
    }
}
