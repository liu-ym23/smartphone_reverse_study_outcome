package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedMediaStreamType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RTC_MEDIA_STREAM_TYPE_AUDIO", "RTC_MEDIA_STREAM_TYPE_VIDEO", "RTC_MEDIA_STREAM_TYPE_BOTH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMediaStreamType extends Enum<LiveWrappedMediaStreamType> {
    public static final a Companion = null;
    public static final LiveWrappedMediaStreamType RTC_MEDIA_STREAM_TYPE_AUDIO = null;
    public static final LiveWrappedMediaStreamType RTC_MEDIA_STREAM_TYPE_BOTH = null;
    public static final LiveWrappedMediaStreamType RTC_MEDIA_STREAM_TYPE_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMediaStreamType[] f147428a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType$a] */
    static {
        LiveWrappedMediaStreamType r100 = new LiveWrappedMediaStreamType("RTC_MEDIA_STREAM_TYPE_AUDIO", 0, 1);
        RTC_MEDIA_STREAM_TYPE_AUDIO = r100;
        LiveWrappedMediaStreamType r101 = new LiveWrappedMediaStreamType("RTC_MEDIA_STREAM_TYPE_VIDEO", 1, 2);
        RTC_MEDIA_STREAM_TYPE_VIDEO = r101;
        LiveWrappedMediaStreamType r102 = new LiveWrappedMediaStreamType("RTC_MEDIA_STREAM_TYPE_BOTH", 2, 3);
        RTC_MEDIA_STREAM_TYPE_BOTH = r102;
        f147428a = new LiveWrappedMediaStreamType[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedMediaStreamType valueOf(String r100) {
        return (LiveWrappedMediaStreamType) r27.a.a(LiveWrappedMediaStreamType.class, r100);
    }

    public static LiveWrappedMediaStreamType[] values() {
        return (LiveWrappedMediaStreamType[]) f147428a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMediaStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
