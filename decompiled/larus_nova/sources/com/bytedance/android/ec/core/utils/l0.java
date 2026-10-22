package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class l0 {
    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final Activity b(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r100 instanceof Activity) == false) goto L11;
        return (Activity) r100;
    L11:
        return b(((ContextWrapper) r100).getBaseContext());
    }

    public static final FragmentActivity c(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r100 instanceof FragmentActivity) == false) goto L11;
        return (FragmentActivity) r100;
    L11:
        return c(((ContextWrapper) r100).getBaseContext());
    }

    public static final void d(Window r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$makeStatusBarTransparent");
        r100.clearFlags(67108864);
        r100.addFlags(Integer.MIN_VALUE);
        int r101 = a(r100).getSystemUiVisibility();
        a(r100).setSystemUiVisibility(r101 | 1280);
        r100.setStatusBarColor(0);
    }

    public static final int e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$navigationOrGestureBarHeight");
        Activity r101 = b(r100);
        if (r101 == null) goto L14;
        Rect r102 = new Rect();
        Window r103 = r101.getWindow();
        if (r103 == null) goto L14;
        View r104 = a(r103);
        if (r104 == null) goto L14;
        r104.getWindowVisibleDisplayFrame(r102);
        int r105 = r102.height();
        zh.b.f572118a.getClass();
        int r106 = zh.b.a(r100);
        Point r107 = f(r100);
        if (r107 == null) goto L11;
        int r108 = r107.y;
    L13:
        return RangesKt.coerceAtLeast((r108 - r106) - r105, 0);
    L11:
        r108 = 0;
    L14:
        return 0;
    }

    public static final Point f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$screenSize");
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r101 instanceof WindowManager) == true) goto L5;
        r101 = null;
    L5:
        WindowManager r102 = (WindowManager) r101;
        if (r102 == null) goto L15;
        Display r103 = r102.getDefaultDisplay();
        if (r103 == null) goto L16;
        Point r104 = new Point();
        r103.getRealSize(r104);
        if (r104.x > 0) goto L12;
        return null;
    L12:
        if (r104.y > 0) goto L14;
        return null;
    L14:
        return r104;
    L16:
        return null;
    L15:
        return null;
    }
}
