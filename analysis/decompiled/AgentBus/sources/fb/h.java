package fb;

import ab.b0;
import ab.r;
import java.util.regex.Pattern;
import ob.e0;
import ob.j;

/* loaded from: classes.dex */
public final class h extends b0 {

    /* renamed from: f, reason: collision with root package name */
    public final String f3658f;

    /* renamed from: g, reason: collision with root package name */
    public final long f3659g;

    /* renamed from: h, reason: collision with root package name */
    public final e0 f3660h;

    public h(String str, long j2, e0 e0Var) {
        this.f3658f = str;
        this.f3659g = j2;
        this.f3660h = e0Var;
    }

    @Override // ab.b0
    public final long a() {
        return this.f3659g;
    }

    @Override // ab.b0
    public final r b() {
        String str = this.f3658f;
        if (str != null) {
            Pattern pattern = r.f597c;
            try {
                return w7.e0.x(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    @Override // ab.b0
    public final j d() {
        return this.f3660h;
    }
}
