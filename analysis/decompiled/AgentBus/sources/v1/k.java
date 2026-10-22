package v1;

import com.stepos.account.oauth.OAuthConstants;
import d7.s;
import java.util.List;
import m.x;

/* loaded from: classes.dex */
public final class k implements Comparable {

    /* renamed from: g, reason: collision with root package name */
    public static final k f10357g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f10358h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f10359i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f10360j;

    /* renamed from: k, reason: collision with root package name */
    public static final k f10361k;

    /* renamed from: l, reason: collision with root package name */
    public static final List f10362l;

    /* renamed from: f, reason: collision with root package name */
    public final int f10363f;

    static {
        k kVar = new k(100);
        k kVar2 = new k(OAuthConstants.RESPONSE_CODE_OK);
        k kVar3 = new k(300);
        k kVar4 = new k(400);
        k kVar5 = new k(500);
        k kVar6 = new k(600);
        f10357g = kVar6;
        k kVar7 = new k(700);
        k kVar8 = new k(800);
        k kVar9 = new k(900);
        f10358h = kVar4;
        f10359i = kVar5;
        f10360j = kVar6;
        f10361k = kVar7;
        f10362l = s.u0(kVar, kVar2, kVar3, kVar4, kVar5, kVar6, kVar7, kVar8, kVar9);
    }

    public k(int i2) {
        this.f10363f = i2;
        boolean z4 = false;
        if (1 <= i2 && i2 < 1001) {
            z4 = true;
        }
        if (z4) {
            return;
        }
        x1.a.a("Font weight can be in range [1, 1000]. Current value: " + i2);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return q7.k.f(this.f10363f, ((k) obj).f10363f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return this.f10363f == ((k) obj).f10363f;
        }
        return false;
    }

    public final int hashCode() {
        return this.f10363f;
    }

    public final String toString() {
        return x.m(new StringBuilder("FontWeight(weight="), this.f10363f, ')');
    }
}
