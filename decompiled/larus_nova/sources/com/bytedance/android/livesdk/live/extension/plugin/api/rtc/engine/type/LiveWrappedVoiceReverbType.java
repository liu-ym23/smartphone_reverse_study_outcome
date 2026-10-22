package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedVoiceReverbType;", "", "", "value", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VOICE_REVERB_ORIGINAL", "VOICE_REVERB_ECHO", "VOICE_REVERB_CONCERT", "VOICE_REVERB_ETHEREAL", "VOICE_REVERB_KTV", "VOICE_REVERB_STUDIO", "VOICE_REVERB_VIRTUAL_STEREO", "VOICE_REVERB_SPACIOUS", "VOICE_REVERB_3D", "VOICE_REVERB_POP", "VOICE_REVERB_DISCO", "VOICE_REVERB_OLDRECORD", "VOICE_REVERB_HARMONY", "VOICE_REVERB_ROCK", "VOICE_REVERB_BLUES", "VOICE_REVERB_JAZZ", "VOICE_REVERB_ELECTRONIC", "VOICE_REVERB_VINYL", "VOICE_REVERB_CHAMBER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVoiceReverbType extends Enum<LiveWrappedVoiceReverbType> {
    public static final a Companion = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_3D = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_BLUES = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_CHAMBER = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_CONCERT = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_DISCO = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ECHO = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ELECTRONIC = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ETHEREAL = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_HARMONY = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_JAZZ = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_KTV = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_OLDRECORD = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ORIGINAL = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_POP = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ROCK = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_SPACIOUS = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_STUDIO = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_VINYL = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_VIRTUAL_STEREO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVoiceReverbType[] f147457a = null;
    private final int value;

    public static LiveWrappedVoiceReverbType valueOf(String r100) {
        return (LiveWrappedVoiceReverbType) r27.a.a(LiveWrappedVoiceReverbType.class, r100);
    }

    public static LiveWrappedVoiceReverbType[] values() {
        return (LiveWrappedVoiceReverbType[]) f147457a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedVoiceReverbType$a] */
    static {
        LiveWrappedVoiceReverbType r100 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ORIGINAL", 0, 0);
        VOICE_REVERB_ORIGINAL = r100;
        LiveWrappedVoiceReverbType r101 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ECHO", 1, 1);
        VOICE_REVERB_ECHO = r101;
        LiveWrappedVoiceReverbType r102 = new LiveWrappedVoiceReverbType("VOICE_REVERB_CONCERT", 2, 2);
        VOICE_REVERB_CONCERT = r102;
        LiveWrappedVoiceReverbType r103 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ETHEREAL", 3, 3);
        VOICE_REVERB_ETHEREAL = r103;
        LiveWrappedVoiceReverbType r104 = new LiveWrappedVoiceReverbType("VOICE_REVERB_KTV", 4, 4);
        VOICE_REVERB_KTV = r104;
        LiveWrappedVoiceReverbType r105 = new LiveWrappedVoiceReverbType("VOICE_REVERB_STUDIO", 5, 5);
        VOICE_REVERB_STUDIO = r105;
        LiveWrappedVoiceReverbType r106 = new LiveWrappedVoiceReverbType("VOICE_REVERB_VIRTUAL_STEREO", 6, 6);
        VOICE_REVERB_VIRTUAL_STEREO = r106;
        LiveWrappedVoiceReverbType r107 = new LiveWrappedVoiceReverbType("VOICE_REVERB_SPACIOUS", 7, 7);
        VOICE_REVERB_SPACIOUS = r107;
        LiveWrappedVoiceReverbType r108 = new LiveWrappedVoiceReverbType("VOICE_REVERB_3D", 8, 8);
        VOICE_REVERB_3D = r108;
        LiveWrappedVoiceReverbType r109 = new LiveWrappedVoiceReverbType("VOICE_REVERB_POP", 9, 9);
        VOICE_REVERB_POP = r109;
        LiveWrappedVoiceReverbType r110 = new LiveWrappedVoiceReverbType("VOICE_REVERB_DISCO", 10, 10);
        VOICE_REVERB_DISCO = r110;
        LiveWrappedVoiceReverbType r111 = new LiveWrappedVoiceReverbType("VOICE_REVERB_OLDRECORD", 11, 11);
        VOICE_REVERB_OLDRECORD = r111;
        LiveWrappedVoiceReverbType r112 = new LiveWrappedVoiceReverbType("VOICE_REVERB_HARMONY", 12, 12);
        VOICE_REVERB_HARMONY = r112;
        LiveWrappedVoiceReverbType r113 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ROCK", 13, 13);
        VOICE_REVERB_ROCK = r113;
        LiveWrappedVoiceReverbType r114 = new LiveWrappedVoiceReverbType("VOICE_REVERB_BLUES", 14, 14);
        VOICE_REVERB_BLUES = r114;
        LiveWrappedVoiceReverbType r115 = new LiveWrappedVoiceReverbType("VOICE_REVERB_JAZZ", 15, 15);
        VOICE_REVERB_JAZZ = r115;
        LiveWrappedVoiceReverbType r116 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ELECTRONIC", 16, 16);
        VOICE_REVERB_ELECTRONIC = r116;
        LiveWrappedVoiceReverbType r117 = new LiveWrappedVoiceReverbType("VOICE_REVERB_VINYL", 17, 17);
        VOICE_REVERB_VINYL = r117;
        LiveWrappedVoiceReverbType r118 = new LiveWrappedVoiceReverbType("VOICE_REVERB_CHAMBER", 18, 18);
        VOICE_REVERB_CHAMBER = r118;
        f147457a = new LiveWrappedVoiceReverbType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVoiceReverbType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
