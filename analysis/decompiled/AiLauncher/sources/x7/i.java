package x7;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import kotlin.C5583a;
import kotlin.C5586e;
import kotlin.Function1;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import s7.w;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Ls7/e;", Const.INTENT_KEY_APIKEY, "Ls7/e;", "e", "()Ls7/e;", "EdgeGlow", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final EffectDefinition f43568a = new EffectDefinition("EdgeGlow", "edge_glow.agsl", null, C1173v.p(new w.b("glowIntensity", 1.5f, null, null, 12, null), new w.b("glowWidth", 0.045f, null, null, 12, null), new w.e("glowColor", 0.3f, 0.7f, 1.0f, 1.0f, null, 32, null)), BackendHint.RUNTIME_SHADER, false, Function1.a(new InterfaceC5074l() { // from class: x7.g
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return i.c((C5583a) obj);
        }
    }), 36, null);

    public static final Y8.t c(C5583a animation) {
        kotlin.jvm.internal.p.i(animation, "$this$animation");
        C5583a.c(animation, "glowIntensity", 0, new InterfaceC5074l() { // from class: x7.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return i.d((C5586e) obj);
            }
        }, 2, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t d(C5586e track) {
        kotlin.jvm.internal.p.i(track, "$this$track");
        track.e(1.3f, 1.7f, 3500L);
        return Y8.t.f7040a;
    }

    public static final EffectDefinition e() {
        return f43568a;
    }
}
