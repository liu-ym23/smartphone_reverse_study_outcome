package aq5;

import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f15898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f15899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f15900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f15901e;

    public final String toString() {
        return "BannerContentParams{width=" + this.f15897a + ", height=" + this.f15898b + ", marginStart=" + this.f15899c + ", marginMid=" + this.f15900d + ", scrollOffset=" + this.f15901e + '}';
    }

    public a() {
        float r100 = n.v();
        float r101 = (0.8613333f * r100) / 3.1f;
        this.f15897a = r101;
        this.f15898b = (4.0f * r101) / 3.0f;
        this.f15899c = 0.042666666f * r100;
        float r102 = r100 * 0.032f;
        this.f15900d = r102;
        this.f15901e = -((r101 * 0.07f) + r102);
        tt5.a.h("BannerContentParams", "BannerContentParams init " + toString());
    }
}
