package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import kotlin.Unit;
import pn0.f;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f71357a;

    public c(a r100) {
        this.f71357a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        a r102 = this.f71357a;
        if (r102.f71340d == false) goto L41;
        ViewGroup r103 = (ViewGroup) r102.f71344h.findViewById(R.id.single_input_mode_container);
        if (r103 == null) goto L42;
        int r104 = 0;
        View r105 = r103.getChildAt(0);
        if (r105 == null) goto L43;
        DataCenter r106 = r102.f71343g;
        FrameLayout.LayoutParams r107 = null;
        if (r106 == null) goto L13;
        m r108 = (m) r106.get("cmd_link_window_layout_config_changed");
    L14:
        if (r108 == null) goto L18;
        f r109 = r108.f75842d;
        if (r109 == null) goto L18;
        f.a r110 = r109.f529922b;
    L19:
        ViewGroup.LayoutParams r111 = r105.getLayoutParams();
        if ((r111 instanceof FrameLayout.LayoutParams) == true) goto L22;
        r111 = null;
    L22:
        FrameLayout.LayoutParams r112 = (FrameLayout.LayoutParams) r111;
        if (r112 == null) goto L39;
        if (r110 == null) goto L26;
        int r113 = r110.f529927c;
    L27:
        r112.width = r113;
        if (r110 == null) goto L30;
        int r114 = r110.f529928d;
    L31:
        r112.height = r114;
        if (r110 == null) goto L34;
        int r115 = r110.f529926b;
    L35:
        r112.topMargin = r115;
        if (r110 == null) goto L38;
        r104 = r110.f529925a;
    L38:
        r112.leftMargin = r104;
        Unit r116 = Unit.INSTANCE;
        r107 = r112;
        goto L39
    L34:
        r115 = 0;
        goto L35
    L30:
        r114 = r103.getHeight();
        goto L31
    L26:
        r113 = r103.getWidth();
    L39:
        r105.setLayoutParams(r107);
        return;
    L18:
        r110 = null;
        goto L19
    L13:
        r108 = null;
        goto L14
    L43:
        return;
    L42:
        return;
    }
}
