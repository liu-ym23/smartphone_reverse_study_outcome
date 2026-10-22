package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class q implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f169702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f169703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f169704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f169705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f169706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f169707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f169708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f169709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f169710i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f169711j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f169712k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Function0 f169713l;

    public q(ValueAnimator r100, w r101, int r102, float r103, int r104, float r105, int r106, int r107, int r108, int r110, int r111, Function0 r112) {
        this.f169702a = r100;
        this.f169703b = r101;
        this.f169704c = r102;
        this.f169705d = r103;
        this.f169706e = r104;
        this.f169707f = r105;
        this.f169708g = r106;
        this.f169709h = r107;
        this.f169710i = r108;
        this.f169711j = r110;
        this.f169712k = r111;
        this.f169713l = r112;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = this.f169702a.getAnimatedFraction();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r102 = this.f169703b.f169809n;
        int r103 = com.bytedance.android.shopping.utils.x.f187159a;
        float r104 = this.f169704c;
        r102.f169186c = Integer.valueOf((int) (r104 + ((this.f169705d - r104) * r101)));
        w r105 = this.f169703b;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r106 = null;
    L5:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 != null) goto L8;
        r107 = new ViewGroup.MarginLayoutParams(-2, -2);
    L8:
        float r108 = this.f169706e;
        r107.height = (int) (r108 + ((this.f169707f - r108) * r101));
        float r109 = this.f169708g;
        r107.width = (int) (r109 + ((this.f169709h - r109) * r101));
        float r110 = this.f169710i;
        float r111 = 0;
        r107.leftMargin = (int) (r110 + ((r111 - r110) * r101));
        float r112 = this.f169711j;
        r107.topMargin = (int) (r112 + ((r111 - r112) * r101));
        float r113 = this.f169712k;
        r107.bottomMargin = (int) (r113 + ((r111 - r113) * r101));
        Unit r114 = Unit.INSTANCE;
        r105.setLayoutParams(r107);
    }
}
