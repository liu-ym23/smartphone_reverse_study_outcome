package com.bytedance.android.livesdk.pannel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import pn2.c;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "", "radius", "", "setRoundDp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panel_release"}, k = 1, mv = {1, 4, 0})
public final class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f154366a;

    public final int getMaxHeight() {
        return this.f154366a;
    }

    public RadiusLayout(Context r100) {
        super(r100);
        c.a(getContext(), 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
    }

    public final void setMaxHeight(int r100) {
        this.f154366a = r100;
    }

    public final void setRoundDp(int r100) {
        c.a(getContext(), r100);
    }

    public RadiusLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        c.a(getContext(), 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        int r103 = this.f154366a;
        if (1 > r103) goto L7;
        if (r102 <= r103) goto L7;
        r101 = View.MeasureSpec.makeMeasureSpec(r103, Integer.MIN_VALUE);
    L7:
        super.onMeasure(r100, r101);
    }

    public RadiusLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        c.a(getContext(), 8);
    }
}
