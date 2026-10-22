package com.stepos.ability.voicewakeup.training.motionkit;

import com.stepos.motionkit.fx.backend.sf.SfDrawableChannel;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/stepos/ability/voicewakeup/training/motionkit/VoiceListenAnimation$WaterBackend", "", "Lcom/stepos/ability/voicewakeup/training/motionkit/VoiceListenAnimation$WaterBackend;", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceListenAnimation$WaterBackend {

    /* renamed from: a, reason: collision with root package name */
    public static final VoiceListenAnimation$WaterBackend f3399a;
    public static final /* synthetic */ VoiceListenAnimation$WaterBackend[] b;

    static {
        VoiceListenAnimation$WaterBackend voiceListenAnimation$WaterBackend = new VoiceListenAnimation$WaterBackend(SfDrawableChannel.TAG, 0);
        f3399a = voiceListenAnimation$WaterBackend;
        VoiceListenAnimation$WaterBackend[] voiceListenAnimation$WaterBackendArr = {voiceListenAnimation$WaterBackend, new VoiceListenAnimation$WaterBackend("SURFACE_VIEW", 1), new VoiceListenAnimation$WaterBackend("TEXTURE_VIEW", 2)};
        b = voiceListenAnimation$WaterBackendArr;
        kotlin.enums.a.a(voiceListenAnimation$WaterBackendArr);
    }

    public static VoiceListenAnimation$WaterBackend valueOf(String str) {
        return (VoiceListenAnimation$WaterBackend) Enum.valueOf(VoiceListenAnimation$WaterBackend.class, str);
    }

    public static VoiceListenAnimation$WaterBackend[] values() {
        return (VoiceListenAnimation$WaterBackend[]) b.clone();
    }
}
