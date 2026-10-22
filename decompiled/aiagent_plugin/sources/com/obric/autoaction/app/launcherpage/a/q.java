package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.discovery.view.DiscoveryErrorView;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.tab.OTabLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDiscoveryPageLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OBlurMaskView f22850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OTabLayout f22851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager2 f22852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DiscoveryErrorView f22853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f22854e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private q(ConstraintLayout r1, OBlurMaskView r2, OTabLayout r3, ViewPager2 r4, DiscoveryErrorView r5) {
        this.f22854e = r1;
        this.f22850a = r2;
        this.f22851b = r3;
        this.f22852c = r4;
        this.f22853d = r5;
    }

    public ConstraintLayout b() {
        return this.f22854e;
    }

    public static q a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_discovery_page_layout, "layout", "autoaction_discovery_page_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static q a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.category_tab_blur_mask, DbHelper.COL_ID, "category_tab_blur_mask");
        OBlurMaskView r7 = (OBlurMaskView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OBlurMaskView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.category_tab_layout, DbHelper.COL_ID, "category_tab_layout");
        OTabLayout r8 = (OTabLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTabLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.discovery_view_pager, DbHelper.COL_ID, "discovery_view_pager");
        ViewPager2 r9 = (ViewPager2) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ViewPager2.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.error_view, DbHelper.COL_ID, "error_view");
        DiscoveryErrorView r10 = (DiscoveryErrorView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), DiscoveryErrorView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new q((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
