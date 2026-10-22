package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6375j;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/f;", "Ly7/s;", "Lz7/j$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/j$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/j$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0738f implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6375j.c token;

    public C0738f(C6375j.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t d(C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.y0(false);
        c10.j0(0.0f);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(S s10, C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.y0(s10.getX5.d.EXTRA_ENABLED java.lang.String());
        c10.z0(Q.c(s10.getStrength()));
        c10.A0(Q.d(s10.getWidth()));
        c10.j0(s10.getDispersion());
        c10.i0(s10.getDepthEffect());
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        final S s10 = params instanceof S ? (S) params : null;
        if (s10 == null) {
            return;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0738f.e(s10, (C6375j.a) obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        this.token.c(new InterfaceC5074l() { // from class: A7.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0738f.d((C6375j.a) obj);
            }
        });
    }
}
