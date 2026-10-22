package x7;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.motionkit.BackendHint;
import kotlin.C5583a;
import kotlin.C5586e;
import kotlin.Function1;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import s7.w;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Ls7/e;", Const.INTENT_KEY_APIKEY, "Ls7/e;", "y", "()Ls7/e;", "WaveGlow", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final EffectDefinition f43571a = new EffectDefinition("WaveGlow", "sf_wave_glow.agsl", null, C1173v.p(new w.b("enableWave", 1.0f, null, null, 12, null), new w.b("enableGlow", 1.0f, null, null, 12, null), new w.b("horizontal", 0.0f, null, null, 12, null), new w.b("circleCenterLocationRatio", 0.4f, null, null, 12, null), new w.b("waveTime", 0.0f, null, null, 12, null), new w.b("circleRadius", 0.0f, null, null, 12, null), new w.b("percent", 0.0f, null, null, 12, null), new w.c("circleOffset", 0.0f, 250.0f, null, 8, null), new w.b("feather", 300.0f, null, null, 12, null), new w.b(ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 0.0f, null, null, 12, null), new w.b("alphaValue", 0.0f, null, null, 12, null), new w.b("displacement", 0.0f, null, null, 12, null), new w.d("colorSet1", 1.0f, 0.306f, 0.0f, null, 16, null), new w.d("colorSet2", 0.102f, 0.251f, 1.0f, null, 16, null), new w.d("colorSet3", 0.4f, 0.102f, 1.0f, null, 16, null), new w.d("colorSet4", 1.0f, 0.549f, 0.102f, null, 16, null), new w.d("colorSet5", 1.0f, 0.749f, 0.063f, null, 16, null), new w.b("time", 0.0f, null, null, 12, null), new w.b(Const.JSON_KEY_SPEED, 0.55f, null, null, 12, null), new w.b("glowIntensity", 1.8f, null, null, 12, null), new w.b("radiusRatio", 0.1f, null, null, 12, null), new w.b("glowRadiusRatio", 1.0f, null, null, 12, null), new w.b("innerGlowStrength", 1.0f, null, null, 12, null), new w.b("innerGlowSpread", 0.0f, null, null, 12, null), new w.b("noiseStrength", 0.5f, null, null, 12, null), new w.b("inner", 1.0f, null, null, 12, null), new w.e("color1", 0.443f, 0.388f, 0.992f, 1.0f, null, 32, null), new w.e("color2", 0.176f, 0.149f, 0.973f, 1.0f, null, 32, null), new w.e("color3", 0.486f, 0.169f, 0.98f, 1.0f, null, 32, null), new w.e("color4", 0.988f, 0.267f, 0.71f, 1.0f, null, 32, null), new w.e("color5", 1.0f, 0.749f, 0.063f, 1.0f, null, 32, null), new w.b("maskSizeX", 0.78f, null, null, 12, null), new w.b("maskSizeY", 0.88f, null, null, 12, null), new w.b("cornerRadius", 0.1f, null, null, 12, null), new w.b("edgeBlur", 110.0f, null, null, 12, null), new w.b("visibleHeight", 0.0f, null, null, 12, null), new w.b("glowAlpha", 0.0f, null, null, 12, null), new w.b("fadeAlpha", 1.0f, null, null, 12, null)), BackendHint.SF, true, Function1.a(new InterfaceC5074l() { // from class: x7.n
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return z.m((C5583a) obj);
        }
    }), 4, null);

    public static final Y8.t m(C5583a animation) {
        kotlin.jvm.internal.p.i(animation, "$this$animation");
        C5583a.c(animation, "waveTime", 0, new InterfaceC5074l() { // from class: x7.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.n((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "circleRadius", 0, new InterfaceC5074l() { // from class: x7.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.o((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "percent", 0, new InterfaceC5074l() { // from class: x7.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.q((C5586e) obj);
            }
        }, 2, null);
        animation.b("circleOffset", 1, new InterfaceC5074l() { // from class: x7.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.r((C5586e) obj);
            }
        });
        C5583a.c(animation, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 0, new InterfaceC5074l() { // from class: x7.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.s((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "alphaValue", 0, new InterfaceC5074l() { // from class: x7.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.t((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "displacement", 0, new InterfaceC5074l() { // from class: x7.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.u((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "time", 0, new InterfaceC5074l() { // from class: x7.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.v((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "glowIntensity", 0, new InterfaceC5074l() { // from class: x7.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.w((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "glowAlpha", 0, new InterfaceC5074l() { // from class: x7.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.x((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, "visibleHeight", 0, new InterfaceC5074l() { // from class: x7.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.p((C5586e) obj);
            }
        }, 2, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t n(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.d(2.0f);
        return Y8.t.f7040a;
    }

    public static final Y8.t o(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.f(0.0f, 3200.0f, 2200L);
        return Y8.t.f7040a;
    }

    public static final Y8.t p(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.c(track.h(0.0f, 0.35f), 600L);
        return Y8.t.f7040a;
    }

    public static final Y8.t q(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.f(0.0f, 1.0f, 2200L);
        return Y8.t.f7040a;
    }

    public static final Y8.t r(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.f(250.0f, -1200.0f, 2200L);
        return Y8.t.f7040a;
    }

    public static final Y8.t s(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.c(track.h(0.0f, 0.9f), 600L);
        return Y8.t.f7040a;
    }

    public static final Y8.t t(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.c(track.h(0.0f, 0.65f), 600L);
        return Y8.t.f7040a;
    }

    public static final Y8.t u(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.c(track.h(0.0f, 18.0f), 600L);
        return Y8.t.f7040a;
    }

    public static final Y8.t v(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.d(1.0f);
        return Y8.t.f7040a;
    }

    public static final Y8.t w(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.i(1.8f, 2.2f, 3000L);
        return Y8.t.f7040a;
    }

    public static final Y8.t x(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.b(track.c(track.h(0.0f, 1.0f), 600L), 200L);
        return Y8.t.f7040a;
    }

    public static final EffectDefinition y() {
        return f43571a;
    }
}
