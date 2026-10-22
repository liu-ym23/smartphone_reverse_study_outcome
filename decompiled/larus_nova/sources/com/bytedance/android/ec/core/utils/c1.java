package com.bytedance.android.ec.core.utils;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataRecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<View> f45559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f45560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f45561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f45562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<MotionEvent, Boolean> f45563e;

    public final boolean a(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        if (this.f45562d.onFilterTouchEventForSecurity(r110) == false) goto L127;
        int r100 = r110.getAction();
        int r101 = r100 & 255;
        if (r101 != 0) goto L8;
        this.f45560b = null;
        this.f45562d.requestDisallowInterceptTouchEvent(false);
    L8:
        if (r101 == 0) goto L14;
        if (this.f45560b != null) goto L14;
        boolean r102 = true;
    L18:
        if (r101 != 3) goto L20;
        boolean r103 = true;
    L22:
        if (r110.getSource() != 8194) goto L24;
        boolean r104 = true;
    L26:
        if (this.f45562d.isMotionEventSplittingEnabled() == false) goto L29;
        if (r104 == true) goto L29;
        boolean r105 = true;
    L31:
        if (r103 == true) goto L98;
        if (r102 == true) goto L98;
        if (r101 == 0) goto L38;
        if (r105 == true) goto L36;
    L37:
        if (r101 != 7) goto L98;
    L36:
        if (r101 != 5) goto L37;
    L38:
        int r106 = r110.getActionIndex();
        int r111 = this.f45562d.getChildCount();
        if (r111 == 0) goto L92;
        int r112 = Build.VERSION.SDK_INT;
        if (r112 < 29) goto L43;
        float r113 = r110.getRawX(r106);
    L44:
        if (r112 < 29) goto L46;
        float r107 = r110.getRawY(r106);
    L47:
        int r114 = this.f45562d.getChildCount();
        if (r114 <= 1) goto L75;
        int r115 = this.f45562d.getChildCount();
        int r116 = 0;
    L51:
        if (r116 >= r115) goto L56;
        if (this.f45562d.getChildAt(r116).getZ() != 0.0f) goto L54;
        r116 = r116 + 1;
        goto L51
    L54:
        boolean r108 = true;
    L57:
        if (r108 == false) goto L75;
        ArrayList<View> r109 = this.f45559a;
        if (r109 != null) goto L62;
        ArrayList<View> r117 = new ArrayList(r114);
        this.f45559a = r117;
        List<View> r118 = r117;
    L63:
        int r119 = 0;
    L64:
        if (r119 >= r114) goto L76;
        View r120 = this.f45562d.getChildAt(r119);
        float r121 = r120.getZ();
        int r122 = r119;
    L66:
        if (r122 <= 0) goto L74;
        int r123 = r122 - 1;
        View r124 = (View) CollectionsKt.getOrNull(r118, r123);
        if (r124 == null) goto L70;
        float r125 = r124.getZ();
    L72:
        if (r125 <= r121) goto L74;
        r122 = r123;
        goto L66
    L70:
        r125 = 0.0f;
    L74:
        ListProtector.add(r118, r122, r120);
        r119 = r119 + 1;
    L76:
        if (r118 != null) goto L79;
        r118 = com.bytedance.commerce.base.view.b.a(this.f45562d);
    L79:
        int r126 = r111 - 1;
        View r127 = null;
    L80:
        if (r126 < 0) goto L93;
        View r128 = (View) CollectionsKt.getOrNull(r118, r126);
        if (r128 == null) goto L91;
        if (d(r113, r107, r128) == false) goto L91;
        if (b(r110, false, r128) == true) goto L89;
        r127 = r128;
        goto L91
    L89:
        this.f45560b = r128;
        r127 = r128;
        boolean r129 = true;
    L94:
        if (r127 != null) goto L99;
        View r130 = this.f45560b;
        if (r130 == null) goto L99;
        r127 = r130;
    L99:
        View r131 = this.f45560b;
        if (r131 != null) goto L102;
        boolean r132 = b(r110, r103, null);
    L110:
        if (r103 == true) goto L114;
        if (r101 == 1) goto L114;
        if (r101 == 7) goto L114;
    L116:
        return r132;
    L114:
        this.f45560b = null;
        this.f45562d.requestDisallowInterceptTouchEvent(false);
        goto L116
    L102:
        if (r129 == false) goto L107;
        if (Intrinsics.areEqual(r131, r127) == false) goto L107;
    L108:
        r132 = true;
    L107:
        if (b(r110, r102, r131) == true) goto L108;
        r132 = false;
    L91:
        r126 = r126 - 1;
    L93:
        r129 = false;
        goto L94
    L62:
        r109.clear();
        r109.ensureCapacity(r114);
        r118 = r109;
        goto L63
    L56:
        r108 = false;
    L75:
        r118 = null;
        goto L76
    L46:
        r107 = r110.getRawY();
        goto L47
    L43:
        r113 = r110.getRawX();
        goto L44
    L92:
        r127 = null;
    L98:
        r127 = null;
        r129 = false;
    L29:
        r105 = false;
        goto L31
    L24:
        r104 = false;
        goto L26
    L20:
        r103 = false;
    L14:
        if (this.f45561c == true) goto L16;
        r102 = this.f45562d.onInterceptTouchEvent(r110);
        r110.setAction(r100);
        goto L18
    L16:
        r102 = false;
        goto L18
    L127:
        return false;
    }

    public c1(OrderCommonYataRecyclerView r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        Intrinsics.checkNotNullParameter(r101, "superDispatchEvent");
        this.f45562d = r100;
        this.f45563e = r101;
    }

    public static boolean c(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int[] r103 = new int[2];
        r100.getLocationOnScreen(r103);
        int r104 = r103[0];
        if (r101 >= r104) goto L5;
        return false;
    L5:
        if (r102 > r103[1]) goto L7;
        return false;
    L7:
        if (r101 <= (r104 + r100.getWidth())) goto L9;
        return false;
    L9:
        if (r102 > (r103[1] + r100.getHeight())) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean b(MotionEvent r100, boolean r101, View r102) {
        int r103 = r100.getAction();
        if (r101 == true) goto L12;
        if (r103 == 3) goto L12;
        MotionEvent r104 = MotionEvent.obtain(r100);
        if (r102 != null) goto L9;
        boolean r105 = this.f45563e.invoke(r104).booleanValue();
    L10:
        r104.recycle();
        return r105;
    L9:
        r104.offsetLocation(this.f45562d.getScrollX() - r102.getLeft(), this.f45562d.getScrollY() - r102.getTop());
        r105 = r102.dispatchTouchEvent(r104);
    L12:
        r100.setAction(3);
        if (r102 == null) goto L15;
        boolean r106 = r102.dispatchTouchEvent(r100);
    L16:
        r100.setAction(r103);
        return r106;
    L15:
        r106 = this.f45563e.invoke(r100).booleanValue();
        goto L16
    }

    public final boolean d(float r100, float r101, View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (r110.getVisibility() != 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        return false;
    L12:
        if ((r110 instanceof ViewGroup) == false) goto L42;
        if (this.f45562d.getClipChildren() == true) goto L42;
        ViewGroup r103 = (ViewGroup) r110;
        int r104 = r103.getChildCount() - 1;
    L16:
        if (r104 < 0) goto L42;
        View r105 = r103.getChildAt(r104);
        if (r105 == null) goto L40;
        Intrinsics.checkNotNullParameter(r105, "view");
        if (r105.getVisibility() != 0) goto L22;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == false) goto L40;
        if ((r105 instanceof ViewGroup) == false) goto L38;
        if (c(r105, r100, r101) == true) goto L31;
        if (((ViewGroup) r105).getClipChildren() == true) goto L40;
        if (d(r100, r101, r105) == false) goto L40;
        return true;
    L31:
        return true;
    L38:
        if (c(r105, r100, r101) == false) goto L40;
        return true;
    L22:
        if (r105.getAnimation() != null) goto L25;
        r106 = false;
    L40:
        r104 = r104 - 1;
    L42:
        if (c(r110, r100, r101) == false) goto L44;
        return true;
    L44:
        return false;
    L5:
        if (r110.getAnimation() != null) goto L8;
        r102 = false;
        goto L9
    }
}
