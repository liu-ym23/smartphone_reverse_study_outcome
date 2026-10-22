package bd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f18611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f18612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f18613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f18614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f18615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f18616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18620k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f18621l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f18622m;

    public final int hashCode() {
        int r100 = ((((((((((((Float.floatToIntBits(this.f18610a) * 31) + Float.floatToIntBits(this.f18611b)) * 31) + Float.floatToIntBits(this.f18612c)) * 31) + Float.floatToIntBits(this.f18613d)) * 31) + Float.floatToIntBits(this.f18614e)) * 31) + Float.floatToIntBits(this.f18615f)) * 31) + Float.floatToIntBits(this.f18616g)) * 31;
        Integer r101 = this.f18622m;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "{x:" + this.f18610a + ",y:" + this.f18611b + ",z:" + this.f18612c + ",width:" + this.f18613d + ",height:" + this.f18614e + ",nW:" + this.f18615f + ",nH:" + this.f18616g + ",uid:" + this.f18618i + "},url:" + this.f18619j + ",linkType:" + this.f18617h + ",position:" + this.f18622m;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L39;
        a r102 = (a) r100;
        if (this.f18610a == r102.f18610a) goto L17;
        return false;
    L17:
        if (this.f18611b == r102.f18611b) goto L20;
        return false;
    L20:
        if (this.f18612c == r102.f18612c) goto L23;
        return false;
    L23:
        if (this.f18613d == r102.f18613d) goto L26;
        return false;
    L26:
        if (this.f18614e == r102.f18614e) goto L29;
        return false;
    L29:
        if (this.f18615f == r102.f18615f) goto L32;
        return false;
    L32:
        if (this.f18616g == r102.f18616g) goto L35;
        return false;
    L35:
        if ((!Intrinsics.areEqual(this.f18622m, r102.f18622m)) == false) goto L37;
        return false;
    L37:
        return true;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.animation.universalwidget.model.HeadWordRenderInfo");
    L8:
        r101 = null;
        goto L10
    }

    public a(float r100, float r101, float r102, float r103, float r104, float r105, String r110, String r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r110, "linkType");
        Intrinsics.checkNotNullParameter("", "uid");
        Intrinsics.checkNotNullParameter("", "url");
        this.f18610a = r100;
        this.f18611b = r101;
        this.f18612c = 0.001f;
        this.f18613d = r102;
        this.f18614e = r103;
        this.f18615f = r104;
        this.f18616g = r105;
        this.f18617h = r110;
        this.f18618i = "";
        this.f18619j = "";
        this.f18620k = r111;
        this.f18621l = r112;
        this.f18622m = -1;
    }
}
