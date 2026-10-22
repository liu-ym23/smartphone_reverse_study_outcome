package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f169599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HeadMultiPreview f169600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f169601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f169602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f169603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f169604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f169605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f169606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f169607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f169608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f169609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f169610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f169611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Function0 f169612n;

    public c(ValueAnimator r100, HeadMultiPreview r101, int r102, float r103, int r104, float r105, int r106, int r107, int r108, int r110, int r111, int r112, View r113, Function0 r114) {
        this.f169599a = r100;
        this.f169600b = r101;
        this.f169601c = r102;
        this.f169602d = r103;
        this.f169603e = r104;
        this.f169604f = r105;
        this.f169605g = r106;
        this.f169606h = r107;
        this.f169607i = r108;
        this.f169608j = r110;
        this.f169609k = r111;
        this.f169610l = r112;
        this.f169611m = r113;
        this.f169612n = r114;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = this.f169599a.getAnimatedFraction();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r102 = this.f169600b.f169582i;
        int r103 = com.bytedance.android.shopping.utils.x.f187159a;
        float r104 = this.f169601c;
        r102.f169186c = Integer.valueOf((int) (r104 + ((this.f169602d - r104) * r101)));
        LinearLayout r105 = this.f169600b.f169574a;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r106 = null;
    L5:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 != null) goto L8;
        r107 = new ViewGroup.MarginLayoutParams(-2, -2);
    L8:
        float r108 = this.f169603e;
        r107.height = (int) (r108 + ((this.f169604f - r108) * r101));
        float r109 = this.f169605g;
        r107.width = (int) (r109 + ((this.f169606h - r109) * r101));
        Unit r110 = Unit.INSTANCE;
        r105.setLayoutParams(r107);
        HeadMultiPreview r111 = this.f169600b;
        r111.f169580g = true;
        float r112 = this.f169607i;
        float r113 = this.f169608j;
        float r114 = this.f169609k;
        float r115 = this.f169610l;
        r111.setPadding((int) (r112 + ((0.0f - r112) * r101)), (int) (r113 + ((0.0f - r113) * r101)), (int) (r114 + ((0.0f - r114) * r101)), (int) (r115 + ((0.0f - r115) * r101)));
    }
}
