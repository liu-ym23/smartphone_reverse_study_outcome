package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/card/widget/ViewWrapper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "value", "", "height", "getHeight", "()I", "setHeight", "(I)V", "marginLayoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "getMarginLayoutParams", "()Landroid/view/ViewGroup$MarginLayoutParams;", "getView", "()Landroid/view/View;", "width", "getWidth", "setWidth", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewWrapper {
    private final View view;

    public final int getHeight() {
        return this.view.getLayoutParams().height;
    }

    public final ViewGroup.MarginLayoutParams getMarginLayoutParams() {
        if ((this.view.getParent() instanceof FrameLayout) == false) goto L9;
        ViewGroup.LayoutParams r100 = this.view.getLayoutParams();
        if (r100 == null) goto L8;
        return (FrameLayout.LayoutParams) r100;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L9:
        ViewGroup.LayoutParams r101 = this.view.getLayoutParams();
        if (r101 == null) goto L14;
        return (ViewGroup.MarginLayoutParams) r101;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final int getWidth() {
        return this.view.getLayoutParams().width;
    }

    public final View getView() {
        return this.view;
    }

    public ViewWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.view = r100;
    }

    public final void setHeight(int r100) {
        this.view.getLayoutParams().height = r100;
        this.view.requestLayout();
    }

    public final void setWidth(int r100) {
        this.view.getLayoutParams().width = r100;
        this.view.requestLayout();
    }
}
