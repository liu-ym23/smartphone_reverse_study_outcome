package com.bytedance.android.shopping.widget.rittag.viewimpl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.RitTagPart;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class RitTagSplitView extends View implements com.bytedance.android.shopping.widget.rittag.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f187460f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RitTagUI.RitTagUIItem.SplitItem.SplitStyle f187461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f187462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f187463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f187464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f187465e;

    public static final class a {
    }

    static {
    }

    private final Paint getDashPaint() {
        return (Paint) this.f187463c.getValue();
    }

    private final int getDefaultStrokeSize() {
        return ((Number) this.f187465e.getValue()).intValue();
    }

    private final Paint getPointPaint() {
        return (Paint) this.f187464d.getValue();
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final View i() {
        return this;
    }

    public RitTagSplitView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f187461a = RitTagUI.RitTagUIItem.SplitItem.SplitStyle.NONE;
        this.f187463c = LazyKt.lazy(new RitTagSplitView$dashPaint$2(this));
        this.f187464d = LazyKt.lazy(RitTagSplitView$pointPaint$2.INSTANCE);
        this.f187465e = LazyKt.lazy(RitTagSplitView$defaultStrokeSize$2.INSTANCE);
    }

    public static final /* synthetic */ int a(RitTagSplitView r100) {
        return r100.getDefaultStrokeSize();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = b.f187469a[this.f187461a.ordinal()];
        if (r100 != 1) goto L5;
        r110.drawColor(0);
        Unit r111 = Unit.INSTANCE;
        return;
    L5:
        if (r100 != 2) goto L7;
        r110.drawColor(this.f187462b);
        Unit r112 = Unit.INSTANCE;
        return;
    L7:
        if (r100 == 3) goto L16;
        if (r100 != 4) goto L15;
        int r101 = this.f187462b;
        if (r110 == null) goto L13;
        getPointPaint().setColor(r101);
        getPointPaint().setStrokeWidth(getWidth() / 2.0f);
        r110.drawPoint(getWidth() / 2.0f, getHeight() / 2.0f, getPointPaint());
    L13:
        Unit r113 = Unit.INSTANCE;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        int r102 = this.f187462b;
        if (r110 == null) goto L24;
        getDashPaint().setColor(r102);
        float r103 = getPaddingTop();
        float r104 = getHeight() - r103;
        int r105 = RangesKt.coerceAtLeast(getHeight() / 4, 2);
        float r114 = getWidth() / 2.0f;
        float r115 = r105;
        int r106 = (int) ((0.7f * r115) / 2.0f);
        int r107 = r105 / 2;
        r110.drawLine(r114, r103, r114, r103 + r106, getDashPaint());
        float r108 = r103 + (r106 + r107);
    L21:
        if (r108 >= r104) goto L23;
        r110.drawLine(r114, r108, r114, r108 + r107, getDashPaint());
        r108 = r108 + r115;
        goto L21
    L23:
        float r109 = r104 - getDefaultStrokeSize();
        r110.drawLine(r114, r109, r114, r109 + getDefaultStrokeSize(), getDashPaint());
    L24:
        Unit r116 = Unit.INSTANCE;
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final void l(RitTagUI.RitTagUIItem r100, RitTagPart r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "part");
        RitTagUI.RitTagUIItem.SplitItem r102 = r100.getSplit();
        if (r102 == null) goto L6;
        RitTagUI.RitTagUIItem.SplitItem.SplitStyle r103 = r102.getSplitStyle();
        if (r103 == null) goto L6;
    L7:
        int r104 = s.f45717a;
        RitTagUI.RitTagUIItem.SplitItem r105 = r100.getSplit();
        if (r105 == null) goto L10;
        String r106 = r105.getColor();
    L11:
        int r107 = s.a(r106, 0);
        if (this.f187461a == r103) goto L14;
    L16:
        this.f187461a = r103;
        this.f187462b = r107;
        invalidate();
        return;
    L14:
        if (this.f187462b != r107) goto L16;
        return;
    L10:
        r106 = null;
    L6:
        r103 = RitTagUI.RitTagUIItem.SplitItem.SplitStyle.NONE;
        goto L7
    }
}
