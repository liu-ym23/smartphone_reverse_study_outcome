package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f171131e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f171132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f171133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f171134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f171135d;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.ecom.arch.slice.render.context.b a() {
        float r100 = 1.0f;
        if (this.f171134c == false) goto L10;
        nj.d r101 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r101 == null) goto L7;
        r101.getSpiltWidth();
        float r102 = 0;
    L8:
        int r103 = com.bytedance.android.shopping.sku.common.utils.c.f182779a;
        float r104 = (com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.f48114e.getCurrentActivity()).f182786a * 375.0f) / r102;
        com.bytedance.android.ecom.arch.slice.render.context.b.f50238f.getClass();
        com.bytedance.android.ecom.arch.slice.render.context.b r105 = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r104, 1.0f, 1.0f);
    L22:
        Lazy r106 = BuyNowLog.f171168a;
        BuyNowLog.d("BuyNowPageConfig", "enableUiAdapt:" + this.f171132a);
        return r105;
    L7:
        r102 = 360.0f;
        goto L8
    L10:
        if (this.f171132a == false) goto L21;
        float r107 = this.f171135d;
        com.bytedance.android.ecom.arch.slice.render.context.b.a r108 = com.bytedance.android.ecom.arch.slice.render.context.b.f50238f;
        if (this.f171133b == false) goto L14;
        float r109 = com.bytedance.android.shopping.utils.o.a();
    L16:
        if (this.f171133b == false) goto L20;
        int r110 = com.bytedance.android.shopping.utils.o.f187155a;
        if (ECAppInfoService.f48114e.f() == false) goto L20;
        r100 = 1.15f;
    L20:
        r108.getClass();
        r105 = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r107, r100, r109);
        goto L22
    L14:
        r109 = 1.0f;
        goto L16
    L21:
        com.bytedance.android.ecom.arch.slice.render.context.b.a r111 = com.bytedance.android.ecom.arch.slice.render.context.b.f50238f;
        boolean r112 = this.f171133b;
        r111.getClass();
        r105 = com.bytedance.android.ecom.arch.slice.render.context.b.a.c(r112);
        goto L22
    }

    public b(boolean r100, boolean r101, boolean r102, float r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 375.0f;
    L14:
        this.f171132a = r100;
        this.f171133b = r101;
        this.f171134c = r102;
        this.f171135d = r103;
    }
}
