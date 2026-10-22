package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/DividerView;", "Landroid/view/View;", "", "b", "I", "getOrientation", "()I", "setOrientation", "(I)V", "orientation", "value", "c", "getColor", "setColor", "color", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DividerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f165508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f165509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f165510c;

    public static final class a {
    }

    static {
    }

    public DividerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DividerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getColor() {
        return this.f165510c;
    }

    public final int getOrientation() {
        return this.f165509b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f165508a.setColor(this.f165510c);
        if (this.f165509b != 0) goto L5;
        float r101 = getMeasuredHeight() * 0.5f;
        r100.drawLine(0.0f, r101, getMeasuredWidth(), r101, this.f165508a);
        return;
    L5:
        float r102 = getMeasuredWidth() * 0.5f;
        r100.drawLine(r102, 0.0f, r102, getMeasuredHeight(), this.f165508a);
    }

    public final void setColor(int r100) {
        this.f165510c = r100;
        invalidate();
    }

    public final void setOrientation(int r100) {
        this.f165509b = r100;
    }

    public DividerView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        Paint r102 = new Paint();
        this.f165508a = r102;
        this.f165509b = 1;
        this.f165510c = getResources().getColor(R.color.TextSecondary);
        r102.setAntiAlias(true);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeCap(Paint.Cap.ROUND);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r103 = r100.getResources();
        double r104 = 1.0d * ((double) WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density);
        double r105 = 0.5f;
        r102.setStrokeWidth((int) (r104 + r105));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r106 = r100.getResources();
        float r107 = (int) ((3.0d * ((double) WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density)) + r105);
        r102.setPathEffect(new DashPathEffect(new float[]{r107, r107, r107, r107}, r107));
        setLayerType(1, r102);
    }

    public /* synthetic */ DividerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
