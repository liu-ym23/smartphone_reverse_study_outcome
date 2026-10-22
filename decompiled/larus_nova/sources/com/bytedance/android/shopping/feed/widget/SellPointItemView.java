package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/SellPointItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "color", "", "setBorderColor", "setBorderAndTextColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SellPointItemView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f175991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f175992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f175993c;

    public SellPointItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SellPointItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static DisplayMetrics x(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        RectF r101 = this.f175991a;
        float r102 = this.f175992b;
        r101.set(r102, r102, getWidth() - this.f175992b, getHeight() - this.f175992b);
        float r103 = 2;
        r100.drawRoundRect(this.f175991a, MathKt.roundToInt(TypedValue.applyDimension(1, r103, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, x(Resources.getSystem()))), this.f175993c);
    }

    public final void setBorderAndTextColor(int r100) {
        this.f175993c.setColor(r100);
        setTextColor(r100);
        invalidate();
    }

    public final void setBorderColor(int r100) {
        this.f175993c.setColor(r100);
        invalidate();
    }

    public SellPointItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175991a = new RectF();
        new Path();
        float r103 = 2;
        this.f175992b = MathKt.roundToInt(TypedValue.applyDimension(1, 1, x(Resources.getSystem()))) / r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(r104.getStrokeWidth());
        r104.setColor(-65536);
        Unit r105 = Unit.INSTANCE;
        this.f175993c = r104;
        float r106 = 4;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r106, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r106, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, x(Resources.getSystem()))));
        setTextSize(1, 10.0f);
    }

    public /* synthetic */ SellPointItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
