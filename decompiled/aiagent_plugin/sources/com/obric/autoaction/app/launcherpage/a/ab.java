package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.widget.OAutoTipContainer;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionMainFragmentBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ab implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OBottomNavigationBar f22706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OAutoTipContainer f22707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OFloatingTitleBar f22708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewPager2 f22709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f22710e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ab(ConstraintLayout r1, OBottomNavigationBar r2, OAutoTipContainer r3, OFloatingTitleBar r4, ViewPager2 r5) {
        this.f22710e = r1;
        this.f22706a = r2;
        this.f22707b = r3;
        this.f22708c = r4;
        this.f22709d = r5;
    }

    public ConstraintLayout b() {
        return this.f22710e;
    }

    public static ab a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static ab a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_main_fragment, "layout", "autoaction_main_fragment"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ab a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bottom_tab_layout, DbHelper.COL_ID, "bottom_tab_layout");
        OBottomNavigationBar r7 = (OBottomNavigationBar) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OBottomNavigationBar.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.tip_container, DbHelper.COL_ID, "tip_container");
        OAutoTipContainer r8 = (OAutoTipContainer) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OAutoTipContainer.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r9 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.view_pager, DbHelper.COL_ID, "view_pager");
        ViewPager2 r10 = (ViewPager2) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ViewPager2.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new ab((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
