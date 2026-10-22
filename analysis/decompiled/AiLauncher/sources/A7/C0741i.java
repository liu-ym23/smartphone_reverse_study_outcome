package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6375j;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/i;", "Ly7/s;", "Lz7/j$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/j$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/j$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0741i implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6375j.c token;

    public C0741i(C6375j.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t d(C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.C0(false);
        c10.S(0.0f);
        c10.T(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(Z z10, C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.C0(z10.getX5.d.EXTRA_ENABLED java.lang.String());
        c10.G0(z10.getWidth());
        c10.E0(z10.getSoftness());
        c10.D0(z10.getIntensity());
        c10.F0(z10.getSpread());
        c10.B0(z10.getColor());
        c10.t0(z10.getLight0X());
        c10.u0(z10.getLight0Y());
        c10.v0(z10.getLight1X());
        c10.w0(z10.getLight1Y());
        c10.S(z10.getAmbient());
        c10.T(z10.getAnisotropicRim());
        c10.k0(z10.getEdgeColor());
        c10.g0(z10.getDarkColor());
        c10.h0(z10.getDarkWidth());
        c10.l0(z10.getEdgeWidth());
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        final Z z10 = params instanceof Z ? (Z) params : null;
        if (z10 == null) {
            return;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0741i.e(z10, (C6375j.a) obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        this.token.c(new InterfaceC5074l() { // from class: A7.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0741i.d((C6375j.a) obj);
            }
        });
    }
}
