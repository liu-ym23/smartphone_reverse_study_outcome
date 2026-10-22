package q5;

import com.stepos.account.oauth.OAuthConstants;

/* loaded from: classes.dex */
public final class z extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8782a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8783b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8784c;

    public z(String str, String str2, boolean z4) {
        q7.k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        this.f8782a = str;
        this.f8783b = str2;
        this.f8784c = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return q7.k.a(this.f8782a, zVar.f8782a) && q7.k.a(this.f8783b, zVar.f8783b) && this.f8784c == zVar.f8784c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f8784c) + m.x.g(this.f8783b, this.f8782a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("Reject(errorCode=", this.f8782a, ", message=", this.f8783b, ", retryable=");
        sbP.append(this.f8784c);
        sbP.append(")");
        return sbP.toString();
    }
}
