package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6370e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/J;", "Ly7/s;", "Lz7/e$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/e$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/e$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class J implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6370e.c token;

    public J(C6370e.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t d(Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C6370e c6370e = C6370e.f45191a;
        Class<?>[] clsArr = {c6370e.j(), c6370e.l(), c6370e.k(), c6370e.k(), c6370e.k(), c6370e.k()};
        Boolean bool = Boolean.FALSE;
        Float fValueOf = Float.valueOf(0.0f);
        c6370e.g(d10, "setInnerShadow", clsArr, bool, 0, fValueOf, fValueOf, fValueOf, fValueOf);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(L l10, Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C6370e c6370e = C6370e.f45191a;
        c6370e.g(d10, "setInnerShadow", new Class[]{c6370e.j(), c6370e.l(), c6370e.k(), c6370e.k(), c6370e.k(), c6370e.k()}, Boolean.valueOf(l10.getX5.d.EXTRA_ENABLED java.lang.String()), Integer.valueOf(l10.getColor()), Float.valueOf(l10.getRadius()), Float.valueOf(l10.getOffsetX()), Float.valueOf(l10.getOffsetY()), Float.valueOf(l10.getIntensity()));
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        final L l10 = params instanceof L ? (L) params : null;
        if (l10 == null) {
            return;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return J.e(l10, obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        this.token.c(new InterfaceC5074l() { // from class: A7.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return J.d(obj);
            }
        });
    }
}
