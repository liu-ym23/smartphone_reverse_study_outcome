package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.x8;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends g {
    public b() {
    }

    public static View q(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void r(Dialog r100) {
        View r101 = r100.findViewById(R.id.ttlive_design_bottom_sheet);
        View r102 = null;
        if (r101 == null) goto L31;
        int r103 = -1;
        if (d() == false) goto L11;
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (g() == true) goto L10;
        r103 = t.j();
    L10:
        r104.height = r103;
        r101.getLayoutParams().width = -2;
    L12:
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        r105 = null;
    L15:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L19;
        r106.setMargins(0, 0, 0, 0);
    L19:
        if ((r101 instanceof RadiusLayout) == true) goto L21;
        View r107 = null;
    L22:
        RadiusLayout r108 = (RadiusLayout) r107;
        if (r108 == null) goto L25;
        r108.setMaxHeight(0);
    L25:
        ViewGroup.LayoutParams r109 = r101.getLayoutParams();
        if ((r109 instanceof CoordinatorLayout.LayoutParams) == true) goto L28;
        r109 = null;
    L28:
        CoordinatorLayout.LayoutParams r110 = (CoordinatorLayout.LayoutParams) r109;
        if (r110 == null) goto L31;
        r110.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        goto L31
    L21:
        r107 = r101;
        goto L22
    L11:
        r101.getLayoutParams().height = -1;
        r101.getLayoutParams().width = -1;
    L31:
        Window r111 = r100.getWindow();
        if (r111 == null) goto L35;
        r111.setNavigationBarColor(s1.h(R.color.transparent));
    L35:
        if (d() == false) goto L61;
        View r112 = r100.findViewById(R.id.ttlive_bottom_sheet_container);
        if (r112 == null) goto L39;
        r112.setFitsSystemWindows(false);
        r112.setPadding(0, 0, 0, 0);
    L39:
        View r113 = r100.findViewById(R.id.ttlive_design_bottom_sheet);
        if (r113 == null) goto L42;
        r113.setFitsSystemWindows(false);
        r113.setPadding(0, 0, 0, 0);
    L42:
        Window r114 = r100.getWindow();
        if (r114 == null) goto L47;
        View r115 = q(r114);
        if (r115 == null) goto L47;
        r115.setFitsSystemWindows(false);
        r115.setPadding(0, 0, 0, 0);
    L47:
        Window r116 = r100.getWindow();
        if (r116 == null) goto L50;
        View r117 = q(r116);
    L52:
        if ((r117 instanceof ViewGroup) == false) goto L55;
        r102 = r117;
    L55:
        ViewGroup r118 = (ViewGroup) r102;
        if (r118 == null) goto L60;
        View r119 = r118.getChildAt(0);
        if (r119 == null) goto L60;
        r119.setFitsSystemWindows(false);
        r119.setPadding(0, 0, 0, 0);
    L60:
        x8.b(r100);
        goto L61
    L50:
        r117 = null;
    L61:
        Window r120 = r100.getWindow();
        if (r120 == null) goto L64;
        r120.setGravity(VideoPlayDataContext.PLAYING_GRAVITY);
    L64:
        Window r121 = r100.getWindow();
        if (r121 == null) goto L70;
        View r122 = q(r121);
        if (r122 == null) goto L71;
        r122.invalidate();
        return;
    L71:
        return;
    }
}
