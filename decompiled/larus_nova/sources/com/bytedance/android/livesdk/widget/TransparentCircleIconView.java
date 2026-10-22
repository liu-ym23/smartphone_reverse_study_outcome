package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\n\u001a\u00020\u00042 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/widget/TransparentCircleIconView;", "Lcom/bytedance/android/livesdk/widget/roundcorner/RoundCornerImageView;", "", "radius", "", "setCircleRadius", "Lkotlin/Function3;", "Landroid/graphics/Canvas;", "Landroid/graphics/Paint;", "action", "setDrawAction", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransparentCircleIconView extends RoundCornerImageView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f161361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f161362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f161363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f161364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f161365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function3<? super TransparentCircleIconView, ? super Canvas, ? super Paint, Unit> f161366g;

    public TransparentCircleIconView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransparentCircleIconView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView, android.view.View
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f161362c.booleanValue() == false) goto L5;
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
    L6:
        super.draw(r110);
        float r101 = this.f161365f;
        if (r101 <= 0) goto L9;
        r110.drawCircle(this.f161363d, this.f161364e, r101, this.f161361b);
    L9:
        Function3<? super TransparentCircleIconView, ? super Canvas, ? super Paint, Unit> r102 = this.f161366g;
        if (r102 == null) goto L13;
        Unit r103 = r102.invoke(this, r110, this.f161361b);
    L13:
        if (this.f161362c.booleanValue() == false) goto L16;
        r110.restoreToCount(r100);
        return;
    L16:
        return;
    L5:
        r100 = 0;
        goto L6
    }

    public final void setCircleRadius(float r100) {
        this.f161365f = r100;
        requestLayout();
    }

    public final void setDrawAction(Function3<? super TransparentCircleIconView, ? super Canvas, ? super Paint, Unit> r100) {
        this.f161366g = r100;
        requestLayout();
    }

    public TransparentCircleIconView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Unit r104 = Unit.INSTANCE;
        this.f161361b = r103;
        this.f161362c = j40.e2.f497190a.getValue();
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.circleCenterLeftMargin, R.attr.circleCenterTopMargin, R.attr.circleRadius}, r102, 0);
        if (r105 == null) goto L5;
        this.f161365f = r105.getDimensionPixelSize(2, 0);
        this.f161363d = r105.getDimensionPixelSize(0, 0);
        this.f161364e = r105.getDimensionPixelSize(1, 0);
        return;
    L5:
        this.f161365f = 0.0f;
        this.f161363d = 0.0f;
        this.f161364e = 0.0f;
    }

    public /* synthetic */ TransparentCircleIconView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
