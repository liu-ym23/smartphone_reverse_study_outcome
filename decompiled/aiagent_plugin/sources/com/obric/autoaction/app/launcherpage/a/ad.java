package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskList;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionRepeatTaskManagementLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ad implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OPageStatus f22716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f22717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AutoActionTaskList f22718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OCTitleBar f22719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f22720e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ad(ConstraintLayout r1, OPageStatus r2, View r3, AutoActionTaskList r4, OCTitleBar r5) {
        this.f22720e = r1;
        this.f22716a = r2;
        this.f22717b = r3;
        this.f22718c = r4;
        this.f22719d = r5;
    }

    public ConstraintLayout b() {
        return this.f22720e;
    }

    public static ad a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_repeat_task_management_layout, "layout", "autoaction_repeat_task_management_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ad a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.lp_empty_state_view, DbHelper.COL_ID, "lp_empty_state_view");
        OPageStatus r7 = (OPageStatus) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_sep_title_area, DbHelper.COL_ID, "lp_sep_title_area");
        View r8 = r11.findViewById(r0);
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_task_list, DbHelper.COL_ID, "lp_task_list");
        AutoActionTaskList r9 = (AutoActionTaskList) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), AutoActionTaskList.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_title_bar, DbHelper.COL_ID, "lp_title_bar");
        OCTitleBar r10 = (OCTitleBar) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCTitleBar.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new ad((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
