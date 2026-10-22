package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamAudioCodecType;", "", "", "<set-?>", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MIXED_STREAM_AUDIO_CODEC_TYPE_AAC", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamAudioCodecType extends Enum<LiveWrappedMixedStreamAudioCodecType> {
    public static final LiveWrappedMixedStreamAudioCodecType MIXED_STREAM_AUDIO_CODEC_TYPE_AAC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamAudioCodecType[] f147390a = null;
    private String value;

    static {
        LiveWrappedMixedStreamAudioCodecType r100 = new LiveWrappedMixedStreamAudioCodecType();
        MIXED_STREAM_AUDIO_CODEC_TYPE_AAC = r100;
        f147390a = new LiveWrappedMixedStreamAudioCodecType[]{r100};
    }

    public static LiveWrappedMixedStreamAudioCodecType valueOf(String r100) {
        return (LiveWrappedMixedStreamAudioCodecType) a.a(LiveWrappedMixedStreamAudioCodecType.class, r100);
    }

    public static LiveWrappedMixedStreamAudioCodecType[] values() {
        return (LiveWrappedMixedStreamAudioCodecType[]) f147390a.clone();
    }

    public LiveWrappedMixedStreamAudioCodecType() {
        super("MIXED_STREAM_AUDIO_CODEC_TYPE_AAC", 0);
        this.value = "AAC";
    }

    public final String getValue() {
        return this.value;
    }
}
