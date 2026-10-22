package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/LynxNodeView;", "Landroid/widget/FrameLayout;", "Lti/k;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxNodeView extends FrameLayout implements ti.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yd3.k f175273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ti.l f175274b;

    public LynxNodeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LynxNodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        yd3.k r103 = this.f175273a;
        if (r103 == null) goto L8;
        int r104 = r103.f();
        yd3.k r105 = this.f175273a;
        if (r105 == null) goto L9;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) Math.ceil((r105.d() / r104) * r102), 1073741824));
        return;
    L9:
        return;
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    public LynxNodeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public /* synthetic */ LynxNodeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
