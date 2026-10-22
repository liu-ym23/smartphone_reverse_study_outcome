package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6375j;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/c;", "Ly7/s;", "Lz7/j$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/j$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/j$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0735c implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6375j.c token;

    public C0735c(C6375j.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    public static final Y8.t d(C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.o0(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(L l10, C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.o0(l10.getX5.d.EXTRA_ENABLED java.lang.String());
        c10.n0(l10.getColor());
        c10.s0(l10.getRadius());
        c10.q0(l10.getOffsetX());
        c10.r0(l10.getOffsetY());
        c10.p0(l10.getIntensity());
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        final L l10 = params instanceof L ? (L) params : null;
        if (l10 == null) {
            return;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0735c.e(l10, (C6375j.a) obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        this.token.c(new InterfaceC5074l() { // from class: A7.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0735c.d((C6375j.a) obj);
            }
        });
    }
}
