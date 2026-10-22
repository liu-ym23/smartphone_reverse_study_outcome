package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class HeartScaleView extends View {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f137882l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f137883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f137884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f137885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f137886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f137887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f137888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f137889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f137890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f137891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f137892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f137893k;

    public static final class a {
    }

    static {
    }

    private final AnimatorSet getHideLargeAnimatorSet() {
        return (AnimatorSet) this.f137893k.getValue();
    }

    private final AnimatorSet getHideNormalAnimatorSet() {
        return (AnimatorSet) this.f137892j.getValue();
    }

    private final ValueAnimator getShakeInfiniteAnimator() {
        return (ValueAnimator) this.f137889g.getValue();
    }

    private final ValueAnimator getShakeOnceAnimator() {
        return (ValueAnimator) this.f137888f.getValue();
    }

    private final AnimatorSet getShowAnimatorSet() {
        return (AnimatorSet) this.f137890h.getValue();
    }

    private final AnimatorSet getTurnLargeAnimatorSet() {
        return (AnimatorSet) this.f137891i.getValue();
    }

    public HeartScaleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        Unit r102 = Unit.INSTANCE;
        this.f137885c = r101;
        this.f137886d = new RectF();
        this.f137887e = BitmapFactory.decodeResource(r100.getResources(), R.drawable.ttlive_ic_digg_anim_heart);
        this.f137888f = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$shakeOnceAnimator$2(this));
        this.f137889g = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$shakeInfiniteAnimator$2(this));
        this.f137890h = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$showAnimatorSet$2(this));
        this.f137891i = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$turnLargeAnimatorSet$2(this));
        this.f137892j = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$hideNormalAnimatorSet$2(this));
        this.f137893k = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$hideLargeAnimatorSet$2(this));
    }

    public static final /* synthetic */ ValueAnimator a(HeartScaleView r100) {
        return r100.getShakeInfiniteAnimator();
    }

    public static final /* synthetic */ ValueAnimator b(HeartScaleView r100) {
        return r100.getShakeOnceAnimator();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        RectF r101 = this.f137886d;
        float r102 = 1;
        float r103 = 2;
        r101.left = (getWidth() * (r102 - this.f137883a)) / r103;
        r101.top = (getHeight() * (r102 - this.f137883a)) / r103;
        r101.right = r101.left + (getWidth() * this.f137883a);
        r101.bottom = r101.top + (getHeight() * this.f137883a);
        float r104 = this.f137884b;
        if (r104 == 0.0f) goto L5;
        r100.rotate(r104, this.f137886d.centerX(), this.f137886d.centerY());
    L5:
        r100.drawBitmap(this.f137887e, null, this.f137886d, this.f137885c);
        r100.restore();
    }
}
