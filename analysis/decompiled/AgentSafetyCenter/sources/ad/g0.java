package ad;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends h0 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f504f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f505g;

    /* renamed from: h, reason: collision with root package name */
    public Object f506h;
    public od.k i;

    public g0(String str, long j10, od.c0 c0Var) {
        this.f506h = str;
        this.f505g = j10;
        this.i = c0Var;
    }

    @Override // ad.h0
    public final long d() {
        switch (this.f504f) {
        }
        return this.f505g;
    }

    @Override // ad.h0
    public final s e() {
        switch (this.f504f) {
            case 0:
                return (s) this.f506h;
            default:
                String str = (String) this.f506h;
                if (str == null) {
                    return null;
                }
                Pattern pattern = s.f568d;
                try {
                    return id.k.t(str);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
        }
    }

    @Override // ad.h0
    public final od.k g() {
        switch (this.f504f) {
            case 0:
                return (od.i) this.i;
            default:
                return (od.c0) this.i;
        }
    }

    public /* synthetic */ g0() {
    }
}
