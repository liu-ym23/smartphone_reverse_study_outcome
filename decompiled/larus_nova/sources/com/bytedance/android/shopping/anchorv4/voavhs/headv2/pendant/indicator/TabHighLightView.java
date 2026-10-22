package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class TabHighLightView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f169902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f169903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f169904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f169905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f169906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f169907f;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabHighLightView f169908a;

        public a(TabHighLightView r100) {
            this.f169908a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f169908a.a(r100, true);
        }
    }

    private final Paint getPaint() {
        return (Paint) this.f169906e.getValue();
    }

    public TabHighLightView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f169906e = LazyKt.lazy(TabHighLightView$paint$2.INSTANCE);
        this.f169907f = new a(this);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Integer r100 = this.f169903b;
        if (r100 == null) goto L17;
        int r101 = r100.intValue();
        Float r102 = this.f169905d;
        if (r102 == null) goto L7;
        float r103 = r102.floatValue();
    L9:
        if (r103 > 0) goto L11;
        return;
    L11:
        Float r104 = this.f169904c;
        if (r104 == null) goto L14;
        float r105 = r104.floatValue();
    L15:
        float r111 = r105;
        float r106 = (getHeight() - r103) / 2.0f;
        float r107 = (getHeight() + r103) / 2.0f;
        getPaint().setColor(r101);
        r110.drawRoundRect(0.0f, r106, getWidth(), r107, r111, r111, getPaint());
        return;
    L14:
        r105 = r103 / 2.0f;
        goto L15
    L7:
        r103 = getHeight();
        goto L9
    }

    public final void a(View r100, boolean r101) {
        if (r100.getHeight() != getHeight()) goto L7;
        if (r100.getWidth() != getWidth()) goto L7;
        return;
    L7:
        if (r100.isLaidOut() == true) goto L9;
        if (r101 == true) goto L9;
        return;
    L9:
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 != null) goto L12;
        r102 = new ViewGroup.LayoutParams(-2, -2);
    L12:
        r102.width = r100.getWidth();
        r102.height = r100.getHeight();
        Unit r103 = Unit.INSTANCE;
        setLayoutParams(r102);
        if (r101 == false) goto L18;
        setMeasuredDimension(r100.getWidth(), getMeasuredHeight());
        layout(0, r100.getTop(), r100.getWidth(), r100.getBottom());
        invalidate();
        return;
    }
}
