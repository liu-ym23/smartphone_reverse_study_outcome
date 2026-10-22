package com.bytedance.android.ui.ec.widget.tools;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a,\u0010\n\u001a\u00020\u0001*\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¨\u0006\r"}, d2 = {"expandTouchArea", "", "Landroid/view/View;", "expectedSize", "", "expectedWidth", "expectedHeight", "forceSet", "", "expandTouchAreaForTopRightCorner", "increaseHitAreaForViews", "views", "", "ui-ec-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ViewExtensionsKt {
    public static final void expandTouchArea(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$expandTouchArea");
        expandTouchArea$default(r100, r101, r101, false, 4, null);
    }

    public static final void expandTouchAreaForTopRightCorner(final View r100, final int r101, final int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$expandTouchAreaForTopRightCorner");
        if (r100.getParent() == null) goto L9;
        ViewParent r103 = r100.getParent();
        if (r103 == null) goto L8;
        final ViewGroup r104 = (ViewGroup) r103;
    L10:
        if (r104 != null) goto L12;
        return;
    L12:
        r104.post(new RunnableC104121(r100, r101, r102, r104));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r104 = null;
        goto L10
    }

    public static final void expandTouchArea(final View r100, final int r101, final int r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$expandTouchArea");
        if (r100.getParent() == null) goto L9;
        ViewParent r102 = r100.getParent();
        if (r102 == null) goto L8;
        ViewGroup r103 = (ViewGroup) r102;
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        final ViewGroup r104 = r103;
        r103.post(new AnonymousClass1(r100, r101, r110, r111, r104));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r103 = null;
        goto L10
    }

    public static final void increaseHitAreaForViews(final View r100, final List<? extends View> r101, final int r102, final int r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$increaseHitAreaForViews");
        Intrinsics.checkNotNullParameter(r101, "views");
        final TouchDelegateComposite r103 = new TouchDelegateComposite(r100, null, 2, null);
        r100.post(new RunnableC104131(r100, r101, r102, r110, r103));
    }

    public static /* synthetic */ void expandTouchArea$default(View r100, int r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        expandTouchArea(r100, r101, r102, r103);
    }

    public static /* synthetic */ void increaseHitAreaForViews$default(View r100, List r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = (int) r100.getResources().getDimension(R.dimen.ec_dux_touch_target_default_size);
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = (int) r100.getResources().getDimension(R.dimen.ec_dux_touch_target_default_size);
    L8:
        increaseHitAreaForViews(r100, r101, r102, r103);
    }
}
