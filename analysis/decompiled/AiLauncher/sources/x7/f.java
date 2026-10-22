package x7;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.EasingType;
import kotlin.C5583a;
import kotlin.C5585d;
import kotlin.C5586e;
import kotlin.Function1;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import s7.w;
import v9.C5684m;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Ls7/e;", Const.INTENT_KEY_APIKEY, "Ls7/e;", "k", "()Ls7/e;", "EdgeBlurDispersion", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final EffectDefinition f43567a = new EffectDefinition("EdgeBlurDispersion", "edge_blur_dispersion.agsl", null, C1173v.p(new w.b("blurStrength", 18.0f, C5684m.c(0.0f, 40.0f), "模糊强度(px)"), new w.b("dispersion", 3.0f, C5684m.c(0.0f, 30.0f), "色散强度(px)"), new w.b("edgeStart", 0.7f, C5684m.c(0.0f, 1.0f), "边缘起始"), new w.b("vignetteStrength", 0.06f, C5684m.c(0.0f, 0.5f), "暗角强度"), new w.b("progress", 0.0f, C5684m.c(0.0f, 1.0f), "动画进度"), new w.b(ConstConfig.KEY_VIEW_SCALE_PROPERTY, 1.0f, C5684m.c(0.9f, 1.1f), "缩放")), BackendHint.SF, true, Function1.a(new InterfaceC5074l() { // from class: x7.a
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return f.f((C5583a) obj);
        }
    }), 4, null);

    public static final Y8.t f(C5583a animation) {
        kotlin.jvm.internal.p.i(animation, "$this$animation");
        C5583a.c(animation, "progress", 0, new InterfaceC5074l() { // from class: x7.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.g((C5586e) obj);
            }
        }, 2, null);
        C5583a.c(animation, ConstConfig.KEY_VIEW_SCALE_PROPERTY, 0, new InterfaceC5074l() { // from class: x7.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.i((C5586e) obj);
            }
        }, 2, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t g(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.g(new InterfaceC5074l() { // from class: x7.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.h((C5585d) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t h(C5585d sequence) {
        kotlin.jvm.internal.p.i(sequence, "$this$sequence");
        C5585d c5585dB = sequence.b(sequence.e(0.0f, 1.0f), 300L);
        EasingType easingType = EasingType.EASE_IN_OUT;
        sequence.c(c5585dB, easingType);
        sequence.c(sequence.b(sequence.e(1.0f, 0.0f), 400L), easingType);
        return Y8.t.f7040a;
    }

    public static final Y8.t i(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.g(new InterfaceC5074l() { // from class: x7.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.j((C5585d) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t j(C5585d sequence) {
        kotlin.jvm.internal.p.i(sequence, "$this$sequence");
        C5585d c5585dB = sequence.b(sequence.e(1.0f, 1.025f), 300L);
        EasingType easingType = EasingType.EASE_IN_OUT;
        sequence.c(c5585dB, easingType);
        sequence.c(sequence.b(sequence.e(1.025f, 1.0f), 400L), easingType);
        return Y8.t.f7040a;
    }

    public static final EffectDefinition k() {
        return f43567a;
    }
}
