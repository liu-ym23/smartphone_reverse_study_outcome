package b8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f18232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f18234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f18235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f18237l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f18238m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f18239n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f18240o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f18241p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f18226a, r101.f18226a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18227b, r101.f18227b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18228c, r101.f18228c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18229d, r101.f18229d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f18230e, r101.f18230e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f18231f, r101.f18231f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f18232g, r101.f18232g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f18233h, r101.f18233h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f18234i, r101.f18234i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f18235j, r101.f18235j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f18236k, r101.f18236k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f18237l, r101.f18237l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f18238m, r101.f18238m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f18239n, r101.f18239n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f18240o, r101.f18240o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f18241p, r101.f18241p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((((((((this.f18226a.hashCode() * 31) + this.f18227b.hashCode()) * 31) + this.f18228c.hashCode()) * 31) + this.f18229d.hashCode()) * 31) + this.f18230e.hashCode()) * 31) + this.f18231f.hashCode()) * 31) + this.f18232g.hashCode()) * 31) + this.f18233h.hashCode()) * 31) + this.f18234i.hashCode()) * 31) + this.f18235j.hashCode()) * 31) + this.f18236k.hashCode()) * 31) + this.f18237l.hashCode()) * 31) + this.f18238m.hashCode()) * 31) + this.f18239n.hashCode()) * 31) + this.f18240o.hashCode()) * 31;
        String r101 = this.f18241p;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ThirdSdkKeys(weiboShareAppKey=" + this.f18226a + ", wechatShareAppKey=" + this.f18227b + ", qQShareKey=" + this.f18228c + ", miPushAppId=" + this.f18229d + ", miPushAppKey=" + this.f18230e + ", meizuAppId=" + this.f18231f + ", meizuAppKey=" + this.f18232g + ", oppoPushAppKey=" + this.f18233h + ", oppoPushSecret=" + this.f18234i + ", umengPushAppKey=" + this.f18235j + ", umengPushMessageSecret=" + this.f18236k + ", matrixAppKey=" + this.f18237l + ", matrixAppSecret=" + this.f18238m + ", lenovoPushAppKey=" + this.f18239n + ", lenovoPushAppSecret=" + this.f18240o + ", specificAMapKey=" + this.f18241p + ')';
    }

    public c() {
        Intrinsics.checkNotNullParameter("1426943654", "weiboShareAppKey");
        Intrinsics.checkNotNullParameter("wx2dccad7bcdbdab7e", "wechatShareAppKey");
        Intrinsics.checkNotNullParameter("1107733183", "qQShareKey");
        Intrinsics.checkNotNullParameter("2882303761520457517", "miPushAppId");
        Intrinsics.checkNotNullParameter("5682045751517", "miPushAppKey");
        Intrinsics.checkNotNullParameter("156308", "meizuAppId");
        Intrinsics.checkNotNullParameter("3eef9da123df437e8e95e162841ce438", "meizuAppKey");
        Intrinsics.checkNotNullParameter("457c4a0d7c804931b1f4cabcb2667c87", "oppoPushAppKey");
        Intrinsics.checkNotNullParameter("25939c1fe3254b51b098fd98805ebf65", "oppoPushSecret");
        Intrinsics.checkNotNullParameter("68d4bb39ef272756f7a0cb0f", "umengPushAppKey");
        Intrinsics.checkNotNullParameter("f0a7ddcdcae3b5b95e96819df8f73ca3", "umengPushMessageSecret");
        Intrinsics.checkNotNullParameter("lark", "matrixAppKey");
        Intrinsics.checkNotNullParameter("6rHDjFphS16oTL24RiyY57hstQk0uEGW", "matrixAppSecret");
        Intrinsics.checkNotNullParameter("mRoDHhwAwY7H4Hw5hxxMx4", "lenovoPushAppKey");
        Intrinsics.checkNotNullParameter("8wJRFHYXZv6sam9w4bM4G3", "lenovoPushAppSecret");
        this.f18226a = "1426943654";
        this.f18227b = "wx2dccad7bcdbdab7e";
        this.f18228c = "1107733183";
        this.f18229d = "2882303761520457517";
        this.f18230e = "5682045751517";
        this.f18231f = "156308";
        this.f18232g = "3eef9da123df437e8e95e162841ce438";
        this.f18233h = "457c4a0d7c804931b1f4cabcb2667c87";
        this.f18234i = "25939c1fe3254b51b098fd98805ebf65";
        this.f18235j = "68d4bb39ef272756f7a0cb0f";
        this.f18236k = "f0a7ddcdcae3b5b95e96819df8f73ca3";
        this.f18237l = "lark";
        this.f18238m = "6rHDjFphS16oTL24RiyY57hstQk0uEGW";
        this.f18239n = "mRoDHhwAwY7H4Hw5hxxMx4";
        this.f18240o = "8wJRFHYXZv6sam9w4bM4G3";
        this.f18241p = null;
    }
}
