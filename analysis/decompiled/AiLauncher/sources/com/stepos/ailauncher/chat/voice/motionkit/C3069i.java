package com.stepos.ailauncher.chat.voice.motionkit;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import kotlin.Metadata;
import s7.EffectDefinition;
import s7.w;
import v9.C5684m;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ls7/e;", VoiceListenAnimation.GLOW, "Ls7/e;", Const.INTENT_KEY_APIKEY, "()Ls7/e;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3069i {
    private static final EffectDefinition Glow = new EffectDefinition(VoiceListenAnimation.GLOW, "key_glow_ripple.agsl", null, C1173v.p(new w.b("uEnterDur", 0.36f, C5684m.c(0.05f, 2.0f), "Enter s"), new w.b("uExitDur", 0.25f, C5684m.c(0.05f, 2.0f), "Exit s"), new w.b("uEnterX", -20.67f, C5684m.c(-80.0f, 80.0f), "Enter X dp"), new w.b("uEnterY", 0.0f, C5684m.c(-80.0f, 80.0f), "Enter Y dp"), new w.b("uExitX", 20.67f, C5684m.c(0.0f, 80.0f), "Exit X dp"), new w.b("uExitY", 0.0f, C5684m.c(-80.0f, 80.0f), "Exit Y dp"), new w.b("uHoldMs", 0.0f, C5684m.c(0.0f, 4000.0f), "Hold ms"), new w.b("uReleaseAt", -1.0f, C5684m.c(-1.0f, 8.0f), "Release at s"), new w.b("uSide", 0.98f, C5684m.c(0.0f, 1.0f), "左右 0=左 1=右"), new w.b("uCenterY", 0.5f, C5684m.c(0.05f, 0.95f), "垂直位置"), new w.b("uHeight", 0.29f, C5684m.c(0.15f, 1.2f), "高度（屏高占比）"), new w.b("uIntensity", 3.0f, C5684m.c(0.0f, 3.0f), "亮度")), BackendHint.RUNTIME_SHADER, false, null, 100, null);

    public static final EffectDefinition a() {
        return Glow;
    }
}
