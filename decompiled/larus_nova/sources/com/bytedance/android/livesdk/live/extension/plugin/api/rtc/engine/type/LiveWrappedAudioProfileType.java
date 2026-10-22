package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioProfileType;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_PROFILE_DEFAULT", "AUDIO_PROFILE_FLUENT", "AUDIO_PROFILE_STANDARD", "AUDIO_PROFILE_HD", "AUDIO_PROFILE_STANDARD_STEREO", "AUDIO_PROFILE_HD_MONO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioProfileType extends Enum<LiveWrappedAudioProfileType> {
    public static final LiveWrappedAudioProfileType AUDIO_PROFILE_DEFAULT = null;
    public static final LiveWrappedAudioProfileType AUDIO_PROFILE_FLUENT = null;
    public static final LiveWrappedAudioProfileType AUDIO_PROFILE_HD = null;
    public static final LiveWrappedAudioProfileType AUDIO_PROFILE_HD_MONO = null;
    public static final LiveWrappedAudioProfileType AUDIO_PROFILE_STANDARD = null;
    public static final LiveWrappedAudioProfileType AUDIO_PROFILE_STANDARD_STEREO = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioProfileType[] f147413a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioProfileType$a] */
    static {
        LiveWrappedAudioProfileType r100 = new LiveWrappedAudioProfileType("AUDIO_PROFILE_DEFAULT", 0, 0);
        AUDIO_PROFILE_DEFAULT = r100;
        LiveWrappedAudioProfileType r101 = new LiveWrappedAudioProfileType("AUDIO_PROFILE_FLUENT", 1, 1);
        AUDIO_PROFILE_FLUENT = r101;
        LiveWrappedAudioProfileType r102 = new LiveWrappedAudioProfileType("AUDIO_PROFILE_STANDARD", 2, 2);
        AUDIO_PROFILE_STANDARD = r102;
        LiveWrappedAudioProfileType r103 = new LiveWrappedAudioProfileType("AUDIO_PROFILE_HD", 3, 3);
        AUDIO_PROFILE_HD = r103;
        LiveWrappedAudioProfileType r104 = new LiveWrappedAudioProfileType("AUDIO_PROFILE_STANDARD_STEREO", 4, 4);
        AUDIO_PROFILE_STANDARD_STEREO = r104;
        LiveWrappedAudioProfileType r105 = new LiveWrappedAudioProfileType("AUDIO_PROFILE_HD_MONO", 5, 5);
        AUDIO_PROFILE_HD_MONO = r105;
        f147413a = new LiveWrappedAudioProfileType[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static LiveWrappedAudioProfileType valueOf(String r100) {
        return (LiveWrappedAudioProfileType) r27.a.a(LiveWrappedAudioProfileType.class, r100);
    }

    public static LiveWrappedAudioProfileType[] values() {
        return (LiveWrappedAudioProfileType[]) f147413a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioProfileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
