package com.bytedance.android.live.profit.format.voicechat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/CircleProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "Landroid/graphics/Path$Direction;", "direction", "setProgressDirection", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f87708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f87709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path.Direction f87710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f87711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f87712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f87713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f87714g;

    public CircleProgressView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CircleProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f87711d.setStrokeWidth(this.f87709b / getScaleX());
        int r101 = b.f87784a[this.f87710c.ordinal()];
        if (r101 != 1) goto L5;
        float r102 = 360;
        float r103 = this.f87708a;
    L10:
        r100.drawArc(this.f87712e, -90.0f, r102 * r103, false, this.f87711d);
        return;
    L5:
        if (r101 != 2) goto L8;
        r102 = -360;
        r103 = this.f87708a;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void setProgress(float r100) {
        if (r100 == this.f87708a) goto L6;
        this.f87708a = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
        return;
    }

    public final void setProgressDirection(Path.Direction r100) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        if (this.f87710c == r100) goto L6;
        this.f87710c = r100;
        invalidate();
        return;
    }

    public CircleProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f87710c = Path.Direction.CW;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeCap(Paint.Cap.ROUND);
        r103.setColor(-1);
        r103.setShadowLayer(10.0f, 0.0f, 0.0f, ColorProtector.parseColor("#99FFFFFF"));
        Unit r104 = Unit.INSTANCE;
        this.f87711d = r103;
        this.f87712e = new RectF();
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.currentProgress, R.attr.progressColor, R.attr.progressDirection, R.attr.progressWidth}, 0, 0);
        this.f87708a = r105.getFloat(0, 0.0f);
        this.f87709b = r105.getDimension(3, 0.0f);
        r103.setColor(r105.getColor(1, -1));
        if (r105.getInt(2, 0) != 0) goto L5;
        Path.Direction r106 = Path.Direction.CW;
    L6:
        this.f87710c = r106;
        r105.recycle();
        return;
    L5:
        r106 = Path.Direction.CCW;
        goto L6
    }

    public /* synthetic */ CircleProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f87713f = getWidth() / 2.0f;
        this.f87714g = getHeight() / 2.0f;
        float r104 = (Math.min(getWidth(), getHeight()) / 2.0f) - (this.f87709b / 2);
        RectF r105 = this.f87712e;
        float r106 = this.f87713f;
        float r107 = this.f87714g;
        r105.set(r106 - r104, r107 - r104, r106 + r104, r107 + r104);
    }
}
