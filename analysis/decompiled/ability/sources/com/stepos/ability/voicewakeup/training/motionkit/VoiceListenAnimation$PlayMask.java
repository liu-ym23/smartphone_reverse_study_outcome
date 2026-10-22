package com.stepos.ability.voicewakeup.training.motionkit;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/stepos/ability/voicewakeup/training/motionkit/VoiceListenAnimation$PlayMask", "", "Lcom/stepos/ability/voicewakeup/training/motionkit/VoiceListenAnimation$PlayMask;", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceListenAnimation$PlayMask {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceListenAnimation$PlayMask[] f3398a;

    static {
        VoiceListenAnimation$PlayMask[] voiceListenAnimation$PlayMaskArr = {new VoiceListenAnimation$PlayMask("LISTEN", 0), new VoiceListenAnimation$PlayMask("KEY_FEEDBACK", 1), new VoiceListenAnimation$PlayMask("BOTH", 2)};
        f3398a = voiceListenAnimation$PlayMaskArr;
        kotlin.enums.a.a(voiceListenAnimation$PlayMaskArr);
    }

    public static VoiceListenAnimation$PlayMask valueOf(String str) {
        return (VoiceListenAnimation$PlayMask) Enum.valueOf(VoiceListenAnimation$PlayMask.class, str);
    }

    public static VoiceListenAnimation$PlayMask[] values() {
        return (VoiceListenAnimation$PlayMask[]) f3398a.clone();
    }
}
