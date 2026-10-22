package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class AvatarScaleView extends View {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f137752i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f137753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f137754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f137755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f137756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f137757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f137758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f137759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f137760h;

    public static final class a {
    }

    static {
    }

    private final ValueAnimator getAlphaAnimator() {
        return (ValueAnimator) this.f137760h.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.f137757e.getValue();
    }

    private final ValueAnimator getScaleAnimator() {
        return (ValueAnimator) this.f137759g.getValue();
    }

    public final boolean getRunning() {
        return this.f137758f;
    }

    public AvatarScaleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f137753a = 1.0f;
        this.f137754b = 255;
        this.f137756d = new RectF();
        this.f137757e = InfraKotlinExtsKt.mainThreadLazy(AvatarScaleView$paint$2.INSTANCE);
        this.f137759g = InfraKotlinExtsKt.mainThreadLazy(new AvatarScaleView$scaleAnimator$2(this));
        this.f137760h = InfraKotlinExtsKt.mainThreadLazy(new AvatarScaleView$alphaAnimator$2(this));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Bitmap r101 = this.f137755c;
        if (r101 == null) goto L6;
        getPaint().setAlpha(this.f137754b);
        RectF r102 = this.f137756d;
        float r103 = 1;
        float r104 = 2;
        r102.left = (getWidth() * (r103 - this.f137753a)) / r104;
        r102.top = (getHeight() * (r103 - this.f137753a)) / r104;
        r102.right = r102.left + (getWidth() * this.f137753a);
        r102.bottom = r102.top + (getHeight() * this.f137753a);
        Unit r105 = Unit.INSTANCE;
        r100.drawBitmap(r101, null, r102, getPaint());
        return;
    }
}
