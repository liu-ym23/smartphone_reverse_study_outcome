package b48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f17626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f17627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f17628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f17629d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17631b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f17630a, r101.f17630a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f17631b, r101.f17631b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f17630a.hashCode() * 31) + this.f17631b.hashCode();
        }

        public final String toString() {
            return "DouyinConfig(platformAppId=" + this.f17630a + ", commentId=" + this.f17631b + ')';
        }

        public a() {
            Intrinsics.checkNotNullParameter("8943", "platformAppId");
            Intrinsics.checkNotNullParameter("@9VxThaOEDp4mJyWjdYosV87812DVAcS+B6lNlTaaE20indzEX5V+l7R1aGbk3MWd", "commentId");
            this.f17630a = "8943";
            this.f17631b = "@9VxThaOEDp4mJyWjdYosV87812DVAcS+B6lNlTaaE20indzEX5V+l7R1aGbk3MWd";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17632a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f17632a, ((b) r100).f17632a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f17632a.hashCode();
        }

        public final String toString() {
            return "PlatformConfig(platformAppId=" + this.f17632a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "platformAppId");
            this.f17632a = r100;
        }
    }

    public i() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f17626a, r101.f17626a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17627b, r101.f17627b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17628c, r101.f17628c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17629d, r101.f17629d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f17626a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.f17627b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f17628c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.f17629d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountThirdPartyAuthConfig(douyin=" + this.f17626a + ", google=" + this.f17627b + ", facebook=" + this.f17628c + ", line=" + this.f17629d + ')';
    }

    public i(a r100, b r101, b r102, b r103) {
        this.f17626a = r100;
        this.f17627b = r101;
        this.f17628c = r102;
        this.f17629d = r103;
    }
}
