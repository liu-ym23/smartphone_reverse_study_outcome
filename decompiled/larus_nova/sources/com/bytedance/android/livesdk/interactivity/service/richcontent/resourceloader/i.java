package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.bytedance.live.richcontent.model.style.ImageStyle;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements LottieListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f140980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ek6.d f140981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ob2.e f140982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ hk6.b.a f140983d;

    public i(h r100, ek6.d r101, ob2.e r102, hk6.d r103) {
        this.f140980a = r100;
        this.f140981b = r101;
        this.f140982c = r102;
        this.f140983d = r103;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(Object r110) {
        LottieComposition r111 = (LottieComposition) r110;
        LottieDrawable r100 = new LottieDrawable();
        h r101 = this.f140980a;
        ek6.d r102 = this.f140981b;
        r101.getClass();
        boolean r103 = r102 instanceof fk6.a;
        if (r103 == true) goto L5;
        ek6.d r104 = null;
    L6:
        fk6.a r105 = (fk6.a) r104;
        float r106 = 1.0f;
        if (r105 == null) goto L58;
        ImageStyle r107 = r105.e();
        if (r107 == null) goto L58;
        ImageStyle.AdjustType r108 = r107.f255752a;
        if (r108 == null) goto L58;
        if (r103 == true) goto L15;
        ek6.d r109 = null;
    L16:
        fk6.a r112 = (fk6.a) r109;
        if (r112 == null) goto L58;
        ImageStyle r113 = r112.e();
        if (r113 == null) goto L58;
        int r114 = r113.f255753b;
        if (r103 == true) goto L23;
        ek6.d r115 = null;
    L24:
        fk6.a r116 = (fk6.a) r115;
        if (r116 == null) goto L58;
        ImageStyle r117 = r116.e();
        if (r117 == null) goto L58;
        int r118 = r117.f255754c;
        if (r103 == true) goto L31;
        r102 = null;
    L31:
        fk6.a r119 = (fk6.a) r102;
        if (r119 == null) goto L58;
        ImageStyle r120 = r119.e();
        if (r120 == null) goto L58;
        float r121 = r120.f255755d;
        int r122 = r111.getBounds().height();
        int r123 = r111.getBounds().width();
        if (r108 == ImageStyle.AdjustType.ORIGIN) goto L58;
        if (r108 != ImageStyle.AdjustType.SCALE) goto L44;
        if (r121 <= 0) goto L44;
        r106 = r121;
    L44:
        if (r108 != ImageStyle.AdjustType.ADJUST_HEIGHT) goto L46;
    L47:
        if (r122 <= 0) goto L51;
        if (r114 <= 0) goto L51;
        float r124 = r114 * 1.0f;
        float r125 = r122;
    L57:
        r106 = r124 / r125;
    L51:
        if (r108 != ImageStyle.AdjustType.ADJUST_WIDTH) goto L53;
    L54:
        if (r123 <= 0) goto L58;
        if (r118 <= 0) goto L58;
        r124 = r118 * 1.0f;
        r125 = r123;
        goto L57
    L53:
        if (r108 != ImageStyle.AdjustType.EXACTLY) goto L58;
    L46:
        if (r108 != ImageStyle.AdjustType.EXACTLY) goto L51;
    L23:
        r115 = r102;
        goto L24
    L15:
        r109 = r102;
    L58:
        r100.f24727d = r106;
        r100.x();
        r100.m(r111);
        r100.w(-1);
        r100.f24726c.setRepeatMode(1);
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.info("LiveLottieResourceLoader, load lottie resource success " + this.f140982c);
        this.f140983d.b(r100);
        return;
    L5:
        r104 = r102;
        goto L6
    }
}
