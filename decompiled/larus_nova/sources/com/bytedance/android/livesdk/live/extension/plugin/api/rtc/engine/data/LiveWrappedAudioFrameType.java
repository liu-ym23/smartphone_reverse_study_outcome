package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioFrameType;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FRAME_TYPE_PCM16", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioFrameType extends Enum<LiveWrappedAudioFrameType> {
    public static final a Companion = null;
    public static final LiveWrappedAudioFrameType FRAME_TYPE_PCM16 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioFrameType[] f147322a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameType$a] */
    static {
        LiveWrappedAudioFrameType r100 = new LiveWrappedAudioFrameType();
        FRAME_TYPE_PCM16 = r100;
        f147322a = new LiveWrappedAudioFrameType[]{r100};
        Companion = new a();
    }

    public static LiveWrappedAudioFrameType valueOf(String r100) {
        return (LiveWrappedAudioFrameType) r27.a.a(LiveWrappedAudioFrameType.class, r100);
    }

    public static LiveWrappedAudioFrameType[] values() {
        return (LiveWrappedAudioFrameType[]) f147322a.clone();
    }

    public LiveWrappedAudioFrameType() {
        super("FRAME_TYPE_PCM16", 0);
        this.value = 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != FRAME_TYPE_PCM16) goto L5;
        return "kFrameTypePCM16";
    L5:
        return "kFrameTypeUnknown";
    }

    public final int value() {
        return this.value;
    }
}
