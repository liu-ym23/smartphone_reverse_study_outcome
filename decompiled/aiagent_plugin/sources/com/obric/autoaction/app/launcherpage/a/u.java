package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionFrequentLocationManageLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSectionSupportiveText f22862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f22864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollView f22865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OFloatingTitleBar f22866e;
    private final FrameLayout f;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private u(FrameLayout r1, OSectionSupportiveText r2, OCardListItem r3, RecyclerView r4, NestedScrollView r5, OFloatingTitleBar r6) {
        this.f = r1;
        this.f22862a = r2;
        this.f22863b = r3;
        this.f22864c = r4;
        this.f22865d = r5;
        this.f22866e = r6;
    }

    public FrameLayout b() {
        return this.f;
    }

    public static u a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static u a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_frequent_location_manage_layout, "layout", "autoaction_frequent_location_manage_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static u a(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.auto_learn_desc, DbHelper.COL_ID, "auto_learn_desc");
        OSectionSupportiveText r7 = (OSectionSupportiveText) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OSectionSupportiveText.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.auto_learn_switch, DbHelper.COL_ID, "auto_learn_switch");
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.frequent_location_recycler_view, DbHelper.COL_ID, "frequent_location_recycler_view");
        RecyclerView r9 = (RecyclerView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.frequent_location_scroll_view, DbHelper.COL_ID, "frequent_location_scroll_view");
        NestedScrollView r10 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), NestedScrollView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r11 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        return new u((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
