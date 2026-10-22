package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CheckViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f180073a = 0;

    static {
    }

    public static void b(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "ev");
        if (ECAppInfoService.f48114e.i() == true) goto L5;
        return;
    L5:
        final View r102 = a(new Point((int) r101.getRawX(), (int) r101.getRawY()), r100, 1);
        final View r103 = a(new Point((int) r101.getRawX(), (int) r101.getRawY()), r100, -1);
        Lazy r104 = OrderCommonLog.f179948a;
        OrderCommonLog.a("CheckViewHelper", new CheckViewHelper$debugCheck$1(r102, r103));
    }

    public static View a(Point r100, View r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "point");
        Intrinsics.checkNotNullParameter(r110, "view");
        if ((r110 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        Iterator<T> r112 = com.bytedance.commerce.base.view.b.a(r110).iterator();
    L7:
        if (r112.hasNext() == false) goto L49;
        View r101 = (View) r112.next();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        int[] r102 = new int[2];
        r101.getLocationOnScreen(r102);
        boolean r103 = false;
        int r104 = r102[0];
        int r105 = r102[1];
        int r106 = r101.getWidth() + r104;
        int r107 = r101.getHeight() + r105;
        int r108 = r100.x;
        if (r104 > r108) goto L19;
        if (r106 < r108) goto L19;
        int r109 = r100.y;
        if (r105 > r109) goto L19;
        if (r107 < r109) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == false) goto L7;
        if ((r101 instanceof ViewPager2) == false) goto L44;
        ViewPager2 r114 = (ViewPager2) r101;
        if (r114.getOrientation() == 0) goto L26;
    L41:
        if (r103 == false) goto L44;
        return r101;
    L26:
        if (r114.isUserInputEnabled() == false) goto L41;
        RecyclerView.Adapter r115 = r114.getAdapter();
        if (r115 == null) goto L31;
        int r116 = r115.getItemCount();
    L32:
        int r117 = r114.getCurrentItem();
        if (r111 == (-1)) goto L39;
        if (r111 != 1) goto L41;
        if (r117 >= (r116 - 1)) goto L41;
    L40:
        r103 = true;
        goto L41
    L39:
        if (r117 <= 0) goto L41;
    L31:
        r116 = 0;
    L44:
        if (r101.canScrollHorizontally(r111) == true) goto L45;
        View r118 = a(r100, r101, r111);
        if (r118 == null) goto L7;
        return r118;
    L45:
        return r101;
    L19:
        r113 = false;
        goto L20
    L49:
        return null;
    }
}
