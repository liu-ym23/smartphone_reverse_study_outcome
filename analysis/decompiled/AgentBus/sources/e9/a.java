package e9;

import com.stepos.account.oauth.OAuthConstants;
import ga.r;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final c f3182a;

    /* renamed from: b, reason: collision with root package name */
    public final f f3183b;

    static {
        c.j(h.f3205f);
    }

    public a(c cVar, f fVar) {
        k.e(cVar, OAuthConstants.FACTOR_PARAMS_PACKAGE_NAME);
        this.f3182a = cVar;
        this.f3183b = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f3182a, aVar.f3182a) && this.f3183b.equals(aVar.f3183b);
    }

    public final int hashCode() {
        return (this.f3183b.hashCode() + (this.f3182a.hashCode() * 961)) * 31;
    }

    public final String toString() {
        String str = r.d0(this.f3182a.b(), '.', '/') + "/" + this.f3183b;
        k.d(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }
}
