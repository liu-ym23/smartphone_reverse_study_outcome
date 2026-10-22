package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.widget.OAutoTipContainer;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionV2ShortcutDetailLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ak implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f22744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f22745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f22746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrollView f22747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OFloatingTitleBar f22748e;
    public final OFloatingTitleBar f;
    public final OAutoTipContainer g;
    private final ConstraintLayout h;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ak(ConstraintLayout r1, LinearLayout r2, ConstraintLayout r3, View r4, ScrollView r5, OFloatingTitleBar r6, OFloatingTitleBar r7, OAutoTipContainer r8) {
        this.h = r1;
        this.f22744a = r2;
        this.f22745b = r3;
        this.f22746c = r4;
        this.f22747d = r5;
        this.f22748e = r6;
        this.f = r7;
        this.g = r8;
    }

    public ConstraintLayout b() {
        return this.h;
    }

    public static ak a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_v2_shortcut_detail_layout, "layout", "autoaction_v2_shortcut_detail_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ak a(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cell_container, DbHelper.COL_ID, "cell_container");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_content_container, DbHelper.COL_ID, "detail_content_container");
        ConstraintLayout r8 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_mask_view, DbHelper.COL_ID, "detail_mask_view");
        View r9 = r14.findViewById(r0);
        if (r9 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_scroll_view, DbHelper.COL_ID, "detail_scroll_view");
        ScrollView r10 = (ScrollView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ScrollView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.event_detail_title_bar, DbHelper.COL_ID, "event_detail_title_bar");
        OFloatingTitleBar r11 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.event_detail_title_bar_for_sheet, DbHelper.COL_ID, "event_detail_title_bar_for_sheet");
        OFloatingTitleBar r12 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.permission_tip_container, DbHelper.COL_ID, "permission_tip_container");
        OAutoTipContainer r13 = (OAutoTipContainer) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OAutoTipContainer.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L19;
        return new ak((ConstraintLayout) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
