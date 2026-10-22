package com.bytedance.android.gamecp.business.gamedetail.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/ProcessView;", "Landroid/view/View;", "", "colorRes", "", "setColor", "", "width", "setStrokeWidth", "Landroid/graphics/Paint;", "b", "Lkotlin/Lazy;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "c", "getLoadingAnimator", "()Landroid/animation/ObjectAnimator;", "loadingAnimator", "Landroid/graphics/RectF;", "d", "getOval", "()Landroid/graphics/RectF;", "oval", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProcessView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f55723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f55724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f55725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f55726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f55727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f55728f;

    public ProcessView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProcessView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ObjectAnimator getLoadingAnimator() {
        return (ObjectAnimator) this.f55725c.getValue();
    }

    private final RectF getOval() {
        return (RectF) this.f55726d.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.f55724b.getValue();
    }

    public final void a() {
        this.f55723a = true;
        if (getLoadingAnimator().isRunning() == false) goto L5;
        return;
    L5:
        getLoadingAnimator().start();
    }

    public final void b() {
        this.f55723a = false;
        getLoadingAnimator().cancel();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f55723a == false) goto L6;
        a();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLoadingAnimator().cancel();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawArc(getOval(), this.f55727e, this.f55728f, false, getPaint());
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 != 0) goto L6;
        b();
        return;
    L6:
        if (this.f55723a == false) goto L10;
        a();
        return;
    }

    public final void setColor(int r100) {
        getPaint().setColor(r100);
    }

    public final void setStrokeWidth(float r100) {
        getPaint().setStrokeWidth(r100);
    }

    public ProcessView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f55724b = LazyKt.lazy(ProcessView$paint$2.INSTANCE);
        this.f55725c = LazyKt.lazy(new ProcessView$loadingAnimator$2(this));
        this.f55726d = LazyKt.lazy(ProcessView$oval$2.INSTANCE);
        this.f55727e = 45.0f;
        this.f55728f = 292.5f;
    }

    public /* synthetic */ ProcessView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = Math.min(r100, r101);
        float r105 = getPaint().getStrokeWidth() / 2;
        float r106 = 0.0f;
        if (r100 <= r101) goto L5;
        r106 = (r100 / 2.0f) - (r101 / 2.0f);
        float r107 = 0.0f;
    L6:
        float r108 = r104;
        getOval().set(r106 + r105, r107 + r105, (r106 + r108) - r105, (r107 + r108) - r105);
        return;
    L5:
        r107 = (r101 / 2.0f) - (r100 / 2.0f);
        goto L6
    }
}
