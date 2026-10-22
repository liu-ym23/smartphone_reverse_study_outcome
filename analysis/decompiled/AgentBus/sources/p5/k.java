package p5;

import com.stepos.account.oauth.OAuthConstants;

/* loaded from: classes.dex */
public final class k extends n7.o {

    /* renamed from: b, reason: collision with root package name */
    public final String f8472b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str) {
        super(5);
        q7.k.e(str, OAuthConstants.FACTOR_PARAMS_PACKAGE_NAME);
        this.f8472b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && q7.k.a(this.f8472b, ((k) obj).f8472b);
    }

    @Override // n7.o
    public final int hashCode() {
        return this.f8472b.hashCode();
    }

    @Override // n7.o
    public final String toString() {
        return a1.a.j("ByPackage(packageName=", this.f8472b, ")");
    }
}
