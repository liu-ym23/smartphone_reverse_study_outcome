package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6370e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/X;", "Ly7/s;", "Lz7/e$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/e$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/e$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class X implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6370e.c token;

    public X(C6370e.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t d(Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C6370e c6370e = C6370e.f45191a;
        Class<?>[] clsArr = {c6370e.j(), c6370e.k(), c6370e.k(), c6370e.k(), c6370e.l()};
        Boolean bool = Boolean.FALSE;
        Float fValueOf = Float.valueOf(0.0f);
        c6370e.g(d10, "setGlassStroke", clsArr, bool, fValueOf, fValueOf, fValueOf, 0);
        c6370e.g(d10, "setAmbient", new Class[]{c6370e.k()}, fValueOf);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(Z z10, Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C6370e c6370e = C6370e.f45191a;
        c6370e.g(d10, "setGlassStroke", new Class[]{c6370e.j(), c6370e.k(), c6370e.k(), c6370e.k(), c6370e.l()}, Boolean.valueOf(z10.getX5.d.EXTRA_ENABLED java.lang.String()), Float.valueOf(z10.getWidth()), Float.valueOf(z10.getSoftness()), Float.valueOf(z10.getIntensity()), Integer.valueOf(z10.getColor()));
        c6370e.g(d10, "setStrokeSpread", new Class[]{c6370e.k()}, Float.valueOf(z10.getSpread()));
        c6370e.g(d10, "setLightDirs", new Class[]{c6370e.k(), c6370e.k(), c6370e.k(), c6370e.k()}, Float.valueOf(z10.getLight0X()), Float.valueOf(z10.getLight0Y()), Float.valueOf(z10.getLight1X()), Float.valueOf(z10.getLight1Y()));
        c6370e.g(d10, "setAmbient", new Class[]{c6370e.k()}, Float.valueOf(z10.getAmbient()));
        c6370e.g(d10, "setAnisoRim", new Class[]{c6370e.j()}, Boolean.valueOf(z10.getAnisotropicRim()));
        c6370e.g(d10, "setEdgeColors", new Class[]{c6370e.l(), c6370e.l()}, Integer.valueOf(z10.getEdgeColor()), Integer.valueOf(z10.getDarkColor()));
        c6370e.g(d10, "setDarkWidth", new Class[]{c6370e.k()}, Float.valueOf(z10.getDarkWidth()));
        c6370e.g(d10, "setEdgeWidth", new Class[]{c6370e.k()}, Float.valueOf(z10.getEdgeWidth()));
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        final Z z10 = params instanceof Z ? (Z) params : null;
        if (z10 == null) {
            return;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.W
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return X.e(z10, obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        this.token.c(new InterfaceC5074l() { // from class: A7.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return X.d(obj);
            }
        });
    }
}
