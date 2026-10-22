package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6375j;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/G;", "Ly7/s;", "Lz7/j$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/j$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/j$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class G implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6375j.c token;

    public G(C6375j.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    public static final Y8.t c(C0746n c0746n, C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.x0(c0746n.getRadius());
        c10.H0(c0746n.getTintColor());
        c10.V(c0746n.getOverlay() ? 3 : 2);
        c10.U(c0746n.getBlendColor());
        c10.m0(c0746n.getFrost());
        c10.I0(c0746n.getUseAospBlur());
        if (c0746n instanceof B) {
            B b10 = (B) c0746n;
            c10.X(b10.getDirection().getMode());
            c10.Y(b10.getGradientScale());
            c10.d0(b10.getStartColor());
            c10.a0(b10.getMiddleColor());
            c10.Z(b10.getEndColor());
            c10.b0(b10.getColorMidpoint());
            c10.c0(C0745m.b(b10));
        } else {
            c10.X(0);
            c10.Y(0.0f);
            c10.d0(0);
            c10.a0(0);
            c10.Z(0);
            c10.b0(0.5f);
            c10.c0(0);
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
        this.token.b(new InterfaceC5074l() { // from class: A7.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return G.c(c0746n, (C6375j.a) obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        C6375j.c.d(this.token, null, 1, null);
    }
}
