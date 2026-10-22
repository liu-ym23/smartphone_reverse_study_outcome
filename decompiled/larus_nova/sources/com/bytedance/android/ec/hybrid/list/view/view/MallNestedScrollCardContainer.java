package com.bytedance.android.ec.hybrid.list.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/view/view/MallNestedScrollCardContainer;", "Landroid/widget/FrameLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "contentContainer", "b", "getLoadingContainer", "loadingContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallNestedScrollCardContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f47439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f47440b;

    public final FrameLayout getContentContainer() {
        return this.f47439a;
    }

    public final FrameLayout getLoadingContainer() {
        return this.f47440b;
    }

    public MallNestedScrollCardContainer(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
    }

    public MallNestedScrollCardContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        FrameLayout r102 = new FrameLayout(r100);
        this.f47439a = r102;
        FrameLayout r103 = new FrameLayout(r100);
        this.f47440b = r103;
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        addView(r103, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }
}
