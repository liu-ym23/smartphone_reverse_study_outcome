package com.bytedance.android.ec.store.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020!¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR*\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R*\u0010 \u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R*\u0010(\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020!8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010+\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b)\u0010\u0007\"\u0004\b*\u0010\u000bR#\u00102\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R#\u00105\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R#\u00108\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010/\u001a\u0004\b7\u00101R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010/\u001a\u0004\b;\u0010<¨\u0006E"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECShopFlowLightMarqueeView;", "Landroid/view/View;", "", "value", "", "setCurrentCircleDegreeExternal", "e", FaceService.girlLabel, "getBorder", "()F", "setBorder", "(F)V", "border", "f", "getRadius", "setRadius", "radius", "", ce.f26391f, "J", "getFadeInDuration", "()J", "setFadeInDuration", "(J)V", "fadeInDuration", "h", "getFadeOutDuration", "setFadeOutDuration", "fadeOutDuration", RXScreenCaptureService.KEY_INDEX, "getRotationDuration", "setRotationDuration", "rotationDuration", "", ce.f26395j, "I", "getRotationCount", "()I", "setRotationCount", "(I)V", "rotationCount", ce.f26396k, "setCurrentCircleDegree", "currentCircleDegree", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "l", "Lkotlin/Lazy;", "getRotationAnimator", "()Landroid/animation/ObjectAnimator;", "rotationAnimator", "m", "getFadeInAnimator", "fadeInAnimator", OfficeSDKRequestTag.KEY_NEW_USER, "getFadeOutAnimator", "fadeOutAnimator", "Landroid/graphics/RectF;", "r", "getRectF", "()Landroid/graphics/RectF;", "rectF", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopFlowLightMarqueeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f48752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f48753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f48754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f48755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f48756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f48757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f48758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f48759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f48760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f48761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f48762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f48763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f48764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f48765n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SweepGradient f48766o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f48767p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f48768q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f48769r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f48770s;

    public ECShopFlowLightMarqueeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECShopFlowLightMarqueeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ObjectAnimator getFadeInAnimator() {
        return (ObjectAnimator) this.f48764m.getValue();
    }

    private final ObjectAnimator getFadeOutAnimator() {
        return (ObjectAnimator) this.f48765n.getValue();
    }

    private final RectF getRectF() {
        return (RectF) this.f48769r.getValue();
    }

    private final ObjectAnimator getRotationAnimator() {
        return (ObjectAnimator) this.f48763l.getValue();
    }

    public final void d() {
        if (this.f48766o != null) goto L5;
    L8:
        this.f48754c = getWidth();
        this.f48755d = getHeight();
        SweepGradient r100 = new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, this.f48752a, this.f48753b);
        this.f48766o = r100;
        this.f48767p.setShader(r100);
        return;
    L5:
        if (this.f48755d != getHeight()) goto L8;
        if (this.f48754c != getWidth()) goto L8;
    }

    public final float getBorder() {
        return this.f48756e;
    }

    public final long getFadeInDuration() {
        return this.f48758g;
    }

    public final long getFadeOutDuration() {
        return this.f48759h;
    }

    public final float getRadius() {
        return this.f48757f;
    }

    public final int getRotationCount() {
        return this.f48761j;
    }

    public final long getRotationDuration() {
        return this.f48760i;
    }

    public static final /* synthetic */ ObjectAnimator a(ECShopFlowLightMarqueeView r100) {
        return r100.getFadeInAnimator();
    }

    public static final /* synthetic */ ObjectAnimator b(ECShopFlowLightMarqueeView r100) {
        return r100.getFadeOutAnimator();
    }

    public static final /* synthetic */ ObjectAnimator c(ECShopFlowLightMarqueeView r100) {
        return r100.getRotationAnimator();
    }

    private final void setCurrentCircleDegree(float r100) {
        this.f48762k = r100;
        invalidate();
    }

    private final void setCurrentCircleDegreeExternal(float r100) {
        setCurrentCircleDegree(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f48770s == false) goto L10;
        int r101 = r100.save();
        float r102 = r100.getWidth() / 2.0f;     // Catch: Throwable -> L7
        float r103 = r100.getHeight() / 2.0f;     // Catch: Throwable -> L7
        r100.rotate(this.f48762k, r102, r103);     // Catch: Throwable -> L7
        d();     // Catch: Throwable -> L7
        r100.drawCircle(r102, r103, (float) Math.sqrt((r102 * r102) + (r103 * r103)), this.f48767p);     // Catch: Throwable -> L7
        r100.restoreToCount(r101);
        RectF r104 = getRectF();
        r104.left = 0.0f;
        r104.top = 0.0f;
        r104.right = getWidth();
        r104.bottom = getHeight();
        getRectF().inset(UIToolsKt.a(Float.valueOf(this.f48756e)), UIToolsKt.a(Float.valueOf(this.f48756e)));
        r100.drawRoundRect(getRectF(), UIToolsKt.a(Float.valueOf(this.f48757f)), UIToolsKt.a(Float.valueOf(this.f48757f)), this.f48768q);
        return;
    L7:
        th = move-exception;
        r100.restoreToCount(r101);
        throw th;
    }

    public final void setBorder(float r100) {
        this.f48756e = r100;
    }

    public final void setFadeInDuration(long r100) {
        this.f48758g = r100;
        getFadeInAnimator().setDuration(r100);
    }

    public final void setFadeOutDuration(long r100) {
        this.f48759h = r100;
        getFadeOutAnimator().setDuration(r100);
    }

    public final void setRadius(float r100) {
        this.f48757f = r100;
        TransitionAnimationHelper.e(this, r100, false);
    }

    public final void setRotationCount(int r100) {
        this.f48761j = r100;
        getRotationAnimator().setRepeatCount(RangesKt.coerceAtLeast(r100 - 1, 0));
    }

    public final void setRotationDuration(long r100) {
        this.f48760i = r100;
        getRotationAnimator().setDuration(r100);
    }

    public ECShopFlowLightMarqueeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48752a = new int[]{ColorProtector.parseColor("#FFAA00"), ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT), ColorProtector.parseColor("#FFB5BB"), ColorProtector.parseColor("#FF3344"), ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT), ColorProtector.parseColor("#FF3344"), ColorProtector.parseColor("#FFAA00")};
        this.f48753b = new float[]{0.0f, 0.17f, 0.19f, 0.58f, 0.6f, 0.84f, 1.0f};
        this.f48756e = 2.0f;
        this.f48757f = 12.0f;
        this.f48758g = 250;
        this.f48759h = 250;
        this.f48760i = 2000;
        this.f48761j = 1;
        this.f48763l = LazyKt.lazy(new ECShopFlowLightMarqueeView$rotationAnimator$2(this));
        this.f48764m = LazyKt.lazy(new ECShopFlowLightMarqueeView$fadeInAnimator$2(this));
        this.f48765n = LazyKt.lazy(new ECShopFlowLightMarqueeView$fadeOutAnimator$2(this));
        this.f48767p = new Paint(1);
        Paint r103 = new Paint(1);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f48768q = r103;
        this.f48769r = LazyKt.lazy(new ECShopFlowLightMarqueeView$rectF$2(this));
        setLayerType(1, null);
        Lazy r105 = TransitionAnimationHelper.f47620a;
        TransitionAnimationHelper.e(this, this.f48757f, false);
    }

    public /* synthetic */ ECShopFlowLightMarqueeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
