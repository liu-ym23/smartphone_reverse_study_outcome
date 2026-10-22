package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002R*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/RVIndicator;", "Landroid/view/View;", "", "color", "", "setBgColor", "setIndicatorColor", "", "value", RXScreenCaptureService.KEY_INDEX, FaceService.girlLabel, "getRatio", "()F", "setRatio", "(F)V", MapBundleKey.OfflineMapKey.OFFLINE_RATION, ce.f26395j, "getProgress", "setProgress", "progress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RVIndicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f177935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f177936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f177937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f177938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f177939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f177940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f177941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f177942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f177943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f177944j;

    public RVIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RVIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getProgress() {
        return this.f177944j;
    }

    public final float getRatio() {
        return this.f177943i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        RectF r101 = this.f177936b;
        float r102 = this.f177937c;
        r100.drawRoundRect(r101, r102, r102, this.f177935a);
        int r103 = this.f177940f;
        float r104 = this.f177943i;
        float r105 = (r103 * (1.0f - r104)) * this.f177944j;
        RectF r106 = this.f177936b;
        float r107 = r106.left + r105;
        this.f177939e.set(r107, r106.top, (r103 * r104) + r107, r106.bottom);
        RectF r108 = this.f177939e;
        float r109 = this.f177937c;
        r100.drawRoundRect(r108, r109, r109, this.f177938d);
    }

    public final void setBgColor(int r100) {
        this.f177935a.setColor(r100);
        invalidate();
    }

    public final void setIndicatorColor(int r100) {
        this.f177938d.setColor(r100);
        invalidate();
    }

    public final void setProgress(float r100) {
        this.f177944j = r100;
        invalidate();
    }

    public final void setRatio(float r100) {
        this.f177943i = r100;
        invalidate();
    }

    public RVIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        this.f177935a = r103;
        this.f177936b = new RectF();
        Paint r104 = new Paint(1);
        this.f177938d = r104;
        this.f177939e = new RectF();
        int r105 = ColorProtector.parseColor("#1F161823");
        int r106 = ColorProtector.parseColor("#BF161823");
        this.f177941g = 10;
        this.f177943i = 0.4f;
        r103.setColor(r105);
        r103.setStyle(Paint.Style.FILL);
        r104.setColor(r106);
        r104.setStyle(Paint.Style.FILL);
    }

    public /* synthetic */ RVIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f177940f = r100;
        float r104 = r101;
        this.f177936b.set(0.0f, 0.0f, r100 * 1.0f, 1.0f * r104);
        this.f177937c = r104 / 2.0f;
    }
}
