package com.bytedance.android.livesdk.slideuptip;

import android.os.Handler;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSlideUpTipsGuideStrategy f158406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f158407b;

    public e(LiveSlideUpTipsGuideStrategy r100, int r101) {
        this.f158406a = r100;
        this.f158407b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        int r102 = this.f158407b;
        LiveSlideUpTipsGuideStrategy r103 = this.f158406a;
        if (r102 != r103.f158377k) goto L38;
        String r104 = null;
        if (r101 == null) goto L7;
        a r105 = (a) r101.data;
    L8:
        r103.f158381o = r105;
        boolean r106 = false;
        if (r105 == null) goto L21;
        if (r105.feedSlideGuide != true) goto L21;
        String r107 = r105.slideGuideText;
        if (r107 == null) goto L21;
        if (r107.length() <= 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 != true) goto L21;
        r106 = true;
        goto L21
    L17:
        r108 = false;
    L21:
        if (r106 == false) goto L34;
        LiveSlideUpTipsGuideStrategy r109 = this.f158406a;
        r109.getClass();
        String r110 = r109.f158368b + '_' + r109.f158369c;
        if (LiveSlideUpTipsGuideUtil.a(r110) == false) goto L33;
        LiveSlideUpTipsGuideStrategy.b("postDelayAction, " + r109.f158368b + ", " + r109.f158369c);
        Handler r111 = r109.f158372f;
        d r112 = new d(r109, r110);
        a r113 = r109.f158381o;
        long r114 = 0;
        if (r113 == null) goto L27;
        long r115 = r113.slideDelayTime;
    L29:
        if (r115 < 0) goto L32;
        r114 = r115;
    L32:
        r111.postDelayed(r112, r114 * 1000);
        goto L34
    L27:
        r115 = 0;
        goto L29
    L33:
        LiveSlideUpTipsGuideStrategy.b("postDelayAction source not support, " + r109.f158368b + ", " + r109.f158369c);
    L34:
        LiveSlideUpTipsGuideStrategy r116 = this.f158406a;
        StringBuilder r117 = new StringBuilder("getSlideUpTips success ");
        a r118 = this.f158406a.f158381o;
        if (r118 == null) goto L37;
        r104 = r118.feedSlideGuide + ", " + r118.slideDelayTime + ", " + r118.slideGuideText;
    L37:
        r117.append(r104);
        String r119 = r117.toString();
        r116.getClass();
        LiveSlideUpTipsGuideStrategy.b(r119);
        return;
    L7:
        r105 = null;
        goto L8
    L38:
        LiveSlideUpTipsGuideStrategy.b("getSlideUpTips success but page changed, so ignore");
    }
}
