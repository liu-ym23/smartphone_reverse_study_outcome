package b48;

import com.larus.account.saas.model.AccountLoginType;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f17614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f17615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccountLoginType f17616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f17618e;

    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f17614a, r101.f17614a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17615b, r101.f17615b) == true) goto L15;
        return false;
    L15:
        if (this.f17616c == r101.f17616c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17617d, r101.f17617d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f17618e, r101.f17618e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f17614a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.f17615b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f17616c.hashCode()) * 31;
        String r107 = this.f17617d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f17618e.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountLoginResult(isNewUserLogin=" + this.f17614a + ", accountInfo=" + this.f17615b + ", loginType=" + this.f17616c + ", businessScene=" + this.f17617d + ", extra=" + this.f17618e + ')';
    }

    public f(Boolean r100, b r101, AccountLoginType r102, String r103) {
        Map<String, Object> r104 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r102, "loginType");
        Intrinsics.checkNotNullParameter(r104, "extra");
        this.f17614a = r100;
        this.f17615b = r101;
        this.f17616c = r102;
        this.f17617d = r103;
        this.f17618e = r104;
    }
}
