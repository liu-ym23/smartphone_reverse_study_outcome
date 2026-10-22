package com.stepos.ailauncher.chat.voice.motionkit;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import kotlin.Metadata;
import s7.EffectDefinition;
import s7.w;
import v9.C5684m;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ls7/e;", "AiAudioWave", "Ls7/e;", Const.INTENT_KEY_APIKEY, "()Ls7/e;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3061a {
    private static final EffectDefinition AiAudioWave = new EffectDefinition(VoiceListenAnimation.WAVE, "ai_audio_wave.agsl", null, C1173v.p(new w.b("uAmp", 191.0f, C5684m.c(0.0f, 600.0f), "Amplitude dp"), new w.b("uFreq", 0.4f, C5684m.c(0.1f, 6.0f), "Frequency humps"), new w.b("uSpeed", 3.0f, C5684m.c(0.0f, 8.0f), "Speed rad/s"), new w.b("uLen", 1.0f, C5684m.c(0.2f, 1.0f), "Length ×w"), new w.b("uTaper", 0.74f, C5684m.c(0.5f, 1.3f), "Taper"), new w.b("uFade", 1.2f, C5684m.c(0.0f, 3.0f), "Edge fade"), new w.b("uOffsetY", -0.51f, C5684m.c(-1.0f, 0.5f), "Y offset ×h"), new w.b("uPhase1", 3.0f, C5684m.c(0.0f, 32.0f), "Phase 1 rad"), new w.d("uCol1", 1.0f, 0.38f, 0.1f, "Stroke 1"), new w.d("uFillCol1", 1.0f, 0.38f, 0.08f, "Fill 1"), new w.b("uPhase2", 5.0f, C5684m.c(0.0f, 32.0f), "Phase 2 rad"), new w.d("uCol2", 0.99f, 0.93f, 0.61f, "Stroke 2"), new w.d("uFillCol2", 1.0f, 0.89f, 0.54f, "Fill 2"), new w.b("uPhase3", 26.0f, C5684m.c(0.0f, 32.0f), "Phase 3 rad"), new w.d("uCol3", 1.0f, 0.55f, 0.2f, "Stroke 3"), new w.d("uFillCol3", 0.93f, 0.63f, 0.34f, "Fill 3"), new w.b("uGlowUp", 15.0f, C5684m.c(1.0f, 200.0f), "Glow above dp"), new w.b("uGlowDn", 82.0f, C5684m.c(1.0f, 400.0f), "Glow below dp"), new w.b("uInten", 1.1f, C5684m.c(0.0f, 3.0f), "Glow inten"), new w.b("uFillSoft", 88.0f, C5684m.c(0.0f, 400.0f), "Fill softness dp"), new w.b("uFillOp", 0.97f, C5684m.c(0.0f, 1.0f), "Fill opacity"), new w.b("uFillAdd", 0.3f, C5684m.c(0.0f, 1.0f), "Additive fill"), new w.b("uExtEnergy", 0.0f, C5684m.c(0.0f, 1.0f), "External drive"), new w.b("uEnergyIn", 1.0f, C5684m.c(0.0f, 1.0f), "Energy in"), new w.b("uEnergySpeed", 1.0f, C5684m.c(0.1f, 2.0f), "Envelope rate (+)"), new w.b("uIntro", 0.0f, C5684m.c(0.0f, 1.0f), "Intro progress (+)"), new w.b("uIntroDur", 0.6f, C5684m.c(0.0f, 4.0f), "Intro dur s (+)"), new w.b("uIntroSpeedFrom", 5.0f, C5684m.c(0.0f, 8.0f), "Intro speed from (+)"), new w.b("uWaveTime", -2.0f, C5684m.c(-2.0f, 30.0f), "Scene clock s (+)"), new w.b("uStartAt", -1.0f, C5684m.c(-1.0f, 4.0f), "Start at s (+)"), new w.b("uReleaseAt", -1.0f, C5684m.c(-1.0f, 8.0f), "Release at s (+)"), new w.b("uExitDur", 0.433f, C5684m.c(0.05f, 2.0f), "退场时长（秒）"), new w.b("uMotionBlur", 0.0f, C5684m.c(0.0f, 2.0f), "Motion blur (+)"), new w.b("uDpRef", 1080.0f, C5684m.c(0.0f, 1200.0f), "dp reference (+)"), new w.b("uPxPerDp", 1.0f, C5684m.c(0.0f, 8.0f), "px per dp"), new w.b("uGpuReady", 0.0f, C5684m.c(0.0f, 1.0f), "gpu pack"), new w.b("uGpuEnergy", 0.0f, C5684m.c(0.0f, 4.0f), null, 8, null), new w.b("uGpuDrift", 0.0f, C5684m.c(-8.0f, 80.0f), null, 8, null), new w.b("uGpuCover", 1.0f, C5684m.c(0.0f, 1.0f), null, 8, null), new w.b("uGpuLiveAmp", 0.0f, C5684m.c(-20.0f, 600.0f), null, 8, null)), BackendHint.RUNTIME_SHADER, false, null, 100, null);

    public static final EffectDefinition a() {
        return AiAudioWave;
    }
}
