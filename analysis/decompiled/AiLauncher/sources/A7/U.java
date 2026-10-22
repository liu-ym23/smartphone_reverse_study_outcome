package A7;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6370e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/U;", "Ly7/s;", "Lz7/e$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/e$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/e$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class U implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6370e.c token;

    public U(C6370e.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    public static final Y8.t c(C0746n c0746n, Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C6370e c6370e = C6370e.f45191a;
        c6370e.g(d10, "setBlurRadius", new Class[]{c6370e.l()}, Integer.valueOf((int) c0746n.getRadius()));
        c6370e.g(d10, "setColor", new Class[]{c6370e.l()}, Integer.valueOf(c0746n.getTintColor()));
        c6370e.g(d10, "setFrost", new Class[]{c6370e.k()}, Float.valueOf(c0746n.getFrost()));
        if (c0746n.getOverlay()) {
            c6370e.g(d10, "setOverlay", new Class[]{c6370e.k()}, Float.valueOf(c0746n.getBlendColor()));
        } else {
            c6370e.g(d10, "setDodge", new Class[]{c6370e.k()}, Float.valueOf(c0746n.getBlendColor()));
        }
        if (c0746n instanceof B) {
            B b10 = (B) c0746n;
            Log.d("MotionKitGradientBlur", "reflect setBlurGradient mode=" + b10.getDirection().getMode() + " scale=" + b10.getGradientScale());
            c6370e.g(d10, "setBlurGradient", new Class[]{c6370e.l(), c6370e.l()}, Integer.valueOf(b10.getDirection().getMode()), Integer.valueOf(b10.getGradientScale()));
            c6370e.g(d10, "setColorGradient", new Class[]{c6370e.l(), c6370e.l(), c6370e.l(), c6370e.k(), c6370e.l()}, Integer.valueOf(b10.getStartColor()), Integer.valueOf(b10.getMiddleColor()), Integer.valueOf(b10.getEndColor()), Float.valueOf(b10.getColorMidpoint()), Integer.valueOf(C0745m.b(b10)));
        } else {
            c6370e.g(d10, "setBlurGradient", new Class[]{c6370e.l(), c6370e.l()}, 0, 0);
            c6370e.g(d10, "setColorGradient", new Class[]{c6370e.l(), c6370e.l(), c6370e.l(), c6370e.k(), c6370e.l()}, 0, 0, 0, Float.valueOf(0.5f), 0);
        }
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        final C0746n c0746n = params instanceof C0746n ? (C0746n) params : null;
        if (c0746n == null) {
            return;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return U.c(c0746n, obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        C6370e.c.d(this.token, null, 1, null);
    }
}
