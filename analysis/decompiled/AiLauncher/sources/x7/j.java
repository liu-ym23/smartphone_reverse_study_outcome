package x7;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import kotlin.Metadata;
import s7.EffectDefinition;
import s7.w;
import v9.C5684m;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003¨\u0006\u0005"}, d2 = {"Ls7/e;", Const.INTENT_KEY_APIKEY, "Ls7/e;", "()Ls7/e;", "Mesh", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final EffectDefinition f43569a = new EffectDefinition("Mesh", "mesh.agsl", null, C1173v.p(new w.b("u_originX", 0.5f, C5684m.c(0.0f, 1.0f), "起始点X"), new w.b("u_originY", 0.91f, C5684m.c(0.3f, 1.0f), "起始点Y"), new w.d("u_blendColor1", 0.157f, 0.2f, 1.0f, "color1"), new w.d("u_blendColor2", 1.0f, 0.569f, 0.216f, "color2")), BackendHint.AUTO, false, null, 100, null);

    public static final EffectDefinition a() {
        return f43569a;
    }
}
