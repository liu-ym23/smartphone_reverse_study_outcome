package c5;

import com.stepos.account.oauth.OAuthConstants;
import q7.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f1900a;

    public e(String str) {
        k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        this.f1900a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && k.a(this.f1900a, ((e) obj).f1900a);
    }

    public final int hashCode() {
        return this.f1900a.hashCode() - 1621489841;
    }

    public final String toString() {
        return a1.a.j("ValidationFailure(code=STEPCLAW_INVALID_FRAME, message=", this.f1900a, ")");
    }
}
