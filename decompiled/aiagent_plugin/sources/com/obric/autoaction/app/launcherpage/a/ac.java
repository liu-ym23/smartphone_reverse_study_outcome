package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskList;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionRepeatTaskHistroyLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ac implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OPageStatus f22711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f22712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AutoActionTaskList f22713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OFloatingTitleBar f22714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OCardListItem f22715e;
    private final ConstraintLayout f;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ac(ConstraintLayout r1, OPageStatus r2, View r3, AutoActionTaskList r4, OFloatingTitleBar r5, OCardListItem r6) {
        this.f = r1;
        this.f22711a = r2;
        this.f22712b = r3;
        this.f22713c = r4;
        this.f22714d = r5;
        this.f22715e = r6;
    }

    public ConstraintLayout b() {
        return this.f;
    }

    public static ac a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_repeat_task_histroy_layout, "layout", "autoaction_repeat_task_histroy_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ac a(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.lp_empty_state_view, DbHelper.COL_ID, "lp_empty_state_view");
        OPageStatus r7 = (OPageStatus) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_sep_title_area, DbHelper.COL_ID, "lp_sep_title_area");
        View r8 = r12.findViewById(r0);
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_task_list, DbHelper.COL_ID, "lp_task_list");
        AutoActionTaskList r9 = (AutoActionTaskList) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), AutoActionTaskList.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.lp_title_bar, DbHelper.COL_ID, "lp_title_bar");
        OFloatingTitleBar r10 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.task_query, DbHelper.COL_ID, "task_query");
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        return new ac((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
