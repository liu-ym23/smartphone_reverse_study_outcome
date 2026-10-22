package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.privacy.av.impl;

import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/privacy/av/impl/FullScreenPageDetector;", "", "()V", "isCover", "", "topView", "Landroid/view/View;", "bottomViewRect", "Landroid/graphics/Rect;", "isCoveredByNewPage", "backRootView", "frontRootView", "frontContentView", "isRegionCovered", "view", "coveredRegion", "Landroid/graphics/Region;", "isViewTransparentNew", "traverseForResultNew", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullScreenPageDetector {
    public static final FullScreenPageDetector INSTANCE = null;

    private FullScreenPageDetector() {
    }

    static {
        INSTANCE = new FullScreenPageDetector();
    }

    private final boolean isViewTransparentNew(View r100) {
        if (r100.getAlpha() >= 1.0f) goto L5;
    L12:
        return true;
    L5:
        if (r100.getBackground() == null) goto L12;
        if (r100.getBackground().getOpacity() == (-2)) goto L12;
        if (r100.getBackground().getAlpha() < 255) goto L12;
        return false;
    }

    private final boolean isCover(View r100, Rect r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        int[] r103 = new int[2];     // Catch: Throwable -> L14
        r100.getLocationOnScreen(r103);     // Catch: Throwable -> L14
        int r104 = r103[0];     // Catch: Throwable -> L14
        int r105 = r103[1];     // Catch: Throwable -> L14
        int r106 = r100.getWidth() + r104;     // Catch: Throwable -> L14
        int r107 = r100.getHeight() + r105;     // Catch: Throwable -> L14
        if (r104 <= r101.left) goto L6;
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        return false;
    L6:
        if (r106 < r101.right) goto L12;
        if (r105 > r101.top) goto L12;
        if (r107 < r101.bottom) goto L12;
        return true;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private final boolean traverseForResultNew(View r100, Rect r101) {
        boolean r102 = false;
        if (r101 == null) goto L19;
        if (r100 == null) goto L19;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        if (r101.isEmpty() == true) goto L10;
        Region r104 = new Region();     // Catch: Throwable -> L12
        r102 = INSTANCE.isRegionCovered(r100, r104, r101);     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L12
    L14:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L18;
        r105 = r106;
    L18:
        return ((Boolean) r105).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        return false;
    }

    private final boolean isRegionCovered(View r100, Region r110, Rect r111) {
        if (r100.getVisibility() == 0) goto L6;
        return false;
    L6:
        if (isViewTransparentNew(r100) == true) goto L8;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        r110.op(new Rect(r102, r101[1], r100.getWidth() + r102, r101[1] + r100.getHeight()), Region.Op.UNION);
    L8:
        Region r103 = new Region(r111);
        r103.op(r110, Region.Op.DIFFERENCE);
        if (r103.isEmpty() == false) goto L12;
        return true;
    L12:
        if ((r100 instanceof ViewGroup) == false) goto L19;
        ViewGroup r104 = (ViewGroup) r100;
        int r105 = r104.getChildCount();
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L19;
        if (isRegionCovered(r104.getChildAt(r106), r110, r111) == true) goto L17;
        r106 = r106 + 1;
        goto L14
    L17:
        return true;
    L19:
        return false;
    }

    public final boolean isCoveredByNewPage(View r100, View r101, View r102) {
        if (r100 == null) goto L30;
        if (r101 == null) goto L30;
        if (r102 == null) goto L30;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L28
        Rect r104 = new Rect();     // Catch: Throwable -> L28
        r100.getWindowVisibleDisplayFrame(r104);     // Catch: Throwable -> L28
        if (r104.isEmpty() == false) goto L10;
        return false;
    L10:
        FullScreenPageDetector r105 = INSTANCE;     // Catch: Throwable -> L28
        if (r105.isCover(r101, r104) == false) goto L16;
        if (r105.isViewTransparentNew(r101) == true) goto L16;
    L33:
        return true;
    L16:
        if (r105.isCover(r101, r104) == true) goto L19;
        return false;
    L19:
        if (r105.isCover(r102, r104) == false) goto L24;
        if (r105.isViewTransparentNew(r102) == false) goto L33;
    L24:
        if (r105.isCover(r102, r104) == false) goto L35;
        return r105.traverseForResultNew(r102, r104);
    L35:
        return false;
    L28:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L30:
        return false;
    }
}
