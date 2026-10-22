package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskList;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionTaskHistoryLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ag implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OIconButtonFloating f22729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OPageStatus f22730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OPageStatus f22731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AutoActionTaskList f22732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OFloatingTitleBar f22733e;
    public final OSearchBar f;
    public final LinearLayout g;
    private final FrameLayout h;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ag(FrameLayout r1, OIconButtonFloating r2, OPageStatus r3, OPageStatus r4, AutoActionTaskList r5, OFloatingTitleBar r6, OSearchBar r7, LinearLayout r8) {
        this.h = r1;
        this.f22729a = r2;
        this.f22730b = r3;
        this.f22731c = r4;
        this.f22732d = r5;
        this.f22733e = r6;
        this.f = r7;
        this.g = r8;
    }

    public FrameLayout b() {
        return this.h;
    }

    public static ag a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_task_history_layout, "layout", "autoaction_task_history_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ag a(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cancel_button, DbHelper.COL_ID, "cancel_button");
        OIconButtonFloating r7 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OIconButtonFloating.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.empty_search, DbHelper.COL_ID, "empty_search");
        OPageStatus r8 = (OPageStatus) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_empty_state_view, DbHelper.COL_ID, "lp_empty_state_view");
        OPageStatus r9 = (OPageStatus) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_task_list, DbHelper.COL_ID, "lp_task_list");
        AutoActionTaskList r10 = (AutoActionTaskList) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), AutoActionTaskList.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_title_bar, DbHelper.COL_ID, "lp_title_bar");
        OFloatingTitleBar r11 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.searchbar, DbHelper.COL_ID, "searchbar");
        OSearchBar r12 = (OSearchBar) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OSearchBar.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.searchbar_container, DbHelper.COL_ID, "searchbar_container");
        LinearLayout r13 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L19;
        return new ag((FrameLayout) ZeusTransformUtils.preCheckCast(r14, FrameLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
