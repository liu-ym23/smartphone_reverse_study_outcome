package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionUtils;", "", "()V", "calculateStartRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "photoWidth", "", "photoHeight", "fix", "", "photoWidthHeight", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionUtils {
    public static final TransitionUtils INSTANCE = null;

    private TransitionUtils() {
    }

    static {
        INSTANCE = new TransitionUtils();
    }

    @JvmStatic
    public static final Rect calculateStartRect(View r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "photoWidthHeight");
        return calculateStartRect$default(r100, r101[0], r101[1], false, 8, null);
    }

    @JvmStatic
    public static final Rect calculateStartRect(View r100, int r101, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int[] r102 = new int[2];
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        r100.getLocationOnScreen(r102);
        int[] r105 = {r102[0] + (r103 / 2), r102[1] + (r104 / 2)};
        Rect r106 = new Rect();
        if (r111 == false) goto L6;
        if (r110 <= r101) goto L6;
        boolean r112 = true;
    L7:
        if (r112 == false) goto L9;
        int r107 = r105[0];
        int r108 = ((int) (r104 * (r101 / r110))) / 2;
        int r113 = r102[1];
        r106.set(r107 - r108, r113, r107 + r108, r104 + r113);
    L10:
        return r106;
    L9:
        int r109 = (int) (r103 * (r110 / r101));
        int r114 = r102[0];
        int r115 = r105[1];
        int r116 = r109 / 2;
        r106.set(r114, r115 - r116, r103 + r114, r115 + r116);
    L6:
        r112 = false;
        goto L7
    }

    public static /* synthetic */ Rect calculateStartRect$default(View r100, int r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L6;
        r103 = false;
    L6:
        return calculateStartRect(r100, r101, r102, r103);
    }
}
