package com.bytedance.android.shopping.buynow.utils;

import android.content.Context;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171224a = 0;

    static {
    }

    public static boolean c(Context r100) {
        if (r100 == null) goto L14;
        Object r101 = r100.getSystemService("accessibility");
        if (r101 == null) goto L13;
        AccessibilityManager r102 = (AccessibilityManager) r101;
        if (r102.isEnabled() == true) goto L9;
        return false;
    L9:
        if (r102.isTouchExplorationEnabled() == false) goto L16;
        return true;
    L16:
        return false;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    L14:
        return false;
    }

    public static Window a(Context r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        boolean r102 = r100 instanceof com.bytedance.android.shopping.buynow.container.o;
        Object r103 = r100;
        if (r102 == true) goto L5;
        r103 = null;
    L5:
        com.bytedance.android.shopping.buynow.container.o r104 = (com.bytedance.android.shopping.buynow.container.o) r103;
        if (r104 != null) goto L11;
        ActivityResultCaller r105 = r101.getParentFragment();
        if ((r105 instanceof com.bytedance.android.shopping.buynow.container.o) == true) goto L10;
        r105 = null;
    L10:
        r104 = (com.bytedance.android.shopping.buynow.container.o) r105;
    L11:
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.Ou();
    }

    public static Window b(Context r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        boolean r102 = r100 instanceof com.bytedance.android.shopping.buynow.container.o;
        Object r103 = r100;
        if (r102 == true) goto L5;
        r103 = null;
    L5:
        com.bytedance.android.shopping.buynow.container.o r104 = (com.bytedance.android.shopping.buynow.container.o) r103;
        if (r104 != null) goto L11;
        ActivityResultCaller r105 = r101.getParentFragment();
        if ((r105 instanceof com.bytedance.android.shopping.buynow.container.o) == true) goto L10;
        r105 = null;
    L10:
        r104 = (com.bytedance.android.shopping.buynow.container.o) r105;
    L11:
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.TR();
    }
}
