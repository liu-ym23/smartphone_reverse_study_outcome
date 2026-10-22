package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoCodecType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO_CODEC_TYPE_UNKNOWN", "VIDEO_CODEC_TYPE_H264", "VIDEO_CODEC_TYPE_BYTEVC1", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoCodecType extends Enum<LiveWrappedVideoCodecType> {
    public static final a Companion = null;
    public static final LiveWrappedVideoCodecType VIDEO_CODEC_TYPE_BYTEVC1 = null;
    public static final LiveWrappedVideoCodecType VIDEO_CODEC_TYPE_H264 = null;
    public static final LiveWrappedVideoCodecType VIDEO_CODEC_TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoCodecType[] f147365a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoCodecType$a] */
    static {
        LiveWrappedVideoCodecType r100 = new LiveWrappedVideoCodecType("VIDEO_CODEC_TYPE_UNKNOWN", 0, 0);
        VIDEO_CODEC_TYPE_UNKNOWN = r100;
        LiveWrappedVideoCodecType r101 = new LiveWrappedVideoCodecType("VIDEO_CODEC_TYPE_H264", 1, 1);
        VIDEO_CODEC_TYPE_H264 = r101;
        LiveWrappedVideoCodecType r102 = new LiveWrappedVideoCodecType("VIDEO_CODEC_TYPE_BYTEVC1", 2, 2);
        VIDEO_CODEC_TYPE_BYTEVC1 = r102;
        f147365a = new LiveWrappedVideoCodecType[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedVideoCodecType valueOf(String r100) {
        return (LiveWrappedVideoCodecType) r27.a.a(LiveWrappedVideoCodecType.class, r100);
    }

    public static LiveWrappedVideoCodecType[] values() {
        return (LiveWrappedVideoCodecType[]) f147365a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final int value() {
        return this.value;
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public LiveWrappedVideoCodecType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
