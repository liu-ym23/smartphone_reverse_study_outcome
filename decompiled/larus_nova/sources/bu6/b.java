package bu6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f20732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f20735f;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f20730a, r101.f20730a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20731b, r101.f20731b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20732c, r101.f20732c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f20733d, r101.f20733d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f20734e, r101.f20734e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f20735f, r101.f20735f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f20730a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f20731b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f20732c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f20733d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f20734e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f20735f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "LifeSearchParams(guessWordBusinessId=" + this.f20730a + ", guessWordPD=" + this.f20731b + ", guessWordCount=" + this.f20732c + ", guessWordPenetrateParams=" + this.f20733d + ", guessWordRefreshType=" + this.f20734e + ", searchGid=" + this.f20735f + ')';
    }

    public b(int r100) {
        this.f20730a = null;
        this.f20731b = null;
        this.f20732c = 0;
        this.f20733d = null;
        this.f20734e = null;
        this.f20735f = null;
    }
}
