package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.slice.PdpPageConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class PDPOverLayVG extends SlcRoundFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.context.b f183313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f183314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f183315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f183316f;

    private final int getDp16() {
        return ((Number) this.f183314d.getValue()).intValue();
    }

    private final int getDp24() {
        return ((Number) this.f183315e.getValue()).intValue();
    }

    public final com.bytedance.android.ecom.arch.slice.render.context.b getSlcDisplayMetrics() {
        return this.f183313c;
    }

    public PDPOverLayVG(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f183313c = (com.bytedance.android.ecom.arch.slice.render.context.b) PdpPageConfig.f183214a.getValue();
        this.f183314d = LazyKt.lazy(new PDPOverLayVG$dp16$2(this));
        this.f183315e = LazyKt.lazy(new PDPOverLayVG$dp24$2(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    public final void setSlcDisplayMetrics(com.bytedance.android.ecom.arch.slice.render.context.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f183313c = r100;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getChildCount() != 2) goto L14;
        View r105 = getChildAt(0);
        boolean r106 = true;
        View r107 = getChildAt(1);
        int r108 = r103 - r101;
        int r109 = r104 - r102;
        if (((r105.getMeasuredWidth() + (r107.getMeasuredWidth() - getDp24())) + getDp16()) > r108) goto L8;
        r106 = false;
    L8:
        if (r106 == false) goto L12;
        r107.layout(r108 - r107.getMeasuredWidth(), 0, r108, r109);
        f r110 = this.f183316f;
        if (r110 == null) goto L15;
        r110.a(r106);
        return;
    L15:
        return;
    L12:
        int r111 = (r105.getMeasuredWidth() + getDp16()) - getDp24();
        r107.layout(r111, 0, r107.getMeasuredWidth() + r111, r109);
        return;
    }
}
