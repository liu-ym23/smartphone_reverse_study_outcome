package com.bytedance.android.ec.common.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/view/RoundCornerLinearlayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/common/impl/view/b;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundCornerLinearlayout extends LinearLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f43592a;

    public RoundCornerLinearlayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundCornerLinearlayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ec.common.impl.view.b
    public final void h() {
        invalidate();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        c r101 = this.f43592a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (r101.f43605a == 0) goto L5;
    L11:
        int r102 = r100.saveLayer(r101.f43609e, r101.f43612h);
        r101.f43611g.reset();
        r101.f43611g.addRoundRect(r101.f43609e, r101.f43610f, Path.Direction.CW);
        r100.drawPath(r101.f43611g, r101.f43612h);
        r101.f43612h.setXfermode(r101.f43613i);
        r100.saveLayer(r101.f43609e, r101.f43612h);
        r101.f43614j.g(r100);
        r101.f43612h.setXfermode(null);
        r101.f43612h.setColorFilter(null);
        r100.restoreToCount(r102);
        return;
    L5:
        if (r101.f43607c != 0) goto L11;
        if (r101.f43606b != 0) goto L11;
        if (r101.f43608d != 0) goto L11;
        r101.f43614j.g(r100);
    }

    @Override // com.bytedance.android.ec.common.impl.view.b
    public final void g(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
    }

    public RoundCornerLinearlayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        c r100 = new c(this);
        this.f43592a = r100;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.ec_allRadius, R.attr.ec_leftBottomRadius, R.attr.ec_leftTopRadius, R.attr.ec_rightBottomRadius, R.attr.ec_rightTopRadius}, r112, 0);
        if (r113 == null) goto L17;
        int r114 = r113.getDimensionPixelSize(0, 0);
        int r101 = r113.getDimensionPixelSize(2, r114);
        int r102 = r113.getDimensionPixelSize(1, r114);
        int r103 = r113.getDimensionPixelSize(4, r114);
        int r115 = r113.getDimensionPixelSize(3, r114);
        r100.f43605a = r101;
        r100.f43606b = r102;
        r100.f43607c = r103;
        r100.f43608d = r115;
        float[] r104 = r100.f43610f;
        float r116 = r101;
        r104[0] = r116;
        r104[1] = r116;
        float r105 = r103;
        r104[2] = r105;
        r104[3] = r105;
        float r117 = r115;
        r104[4] = r117;
        r104[5] = r117;
        float r118 = r102;
        r104[6] = r118;
        r104[7] = r118;
        if (r102 > 0) goto L9;
        if (r101 > 0) goto L9;
        if (r103 > 0) goto L9;
        if (r115 > 0) goto L9;
    L15:
        r100.f43614j.h();
        r113.recycle();
        return;
    L9:
        Object r119 = r100.f43614j;
        if ((r119 instanceof ViewGroup) == true) goto L12;
        r119 = null;
    L12:
        ViewGroup r120 = (ViewGroup) r119;
        if (r120 == null) goto L15;
        r120.setWillNotDraw(false);
        goto L15
    }

    public /* synthetic */ RoundCornerLinearlayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        c r104 = this.f43592a;
        int r105 = getWidth();
        int r106 = getHeight();
        if (r104.f43605a == 0) goto L5;
    L10:
        if (r105 == 0) goto L16;
        if (r106 == 0) goto L17;
        r104.f43609e.set(0.0f, 0.0f, r105, r106);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (r104.f43607c != 0) goto L10;
        if (r104.f43608d != 0) goto L10;
        if (r104.f43606b != 0) goto L10;
    }
}
