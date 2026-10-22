package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDetailTestRunTaskCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinearLayout f22834c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private k(LinearLayout r1, OCardListItem r2, OCardListItem r3) {
        this.f22834c = r1;
        this.f22832a = r2;
        this.f22833b = r3;
    }

    public LinearLayout b() {
        return this.f22834c;
    }

    public static k a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_test_run_task_cell, "layout", "autoaction_detail_test_run_task_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static k a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_delete_item_btn, DbHelper.COL_ID, "detail_delete_item_btn");
        OCardListItem r2 = (OCardListItem) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_pilot_run_btn, DbHelper.COL_ID, "detail_pilot_run_btn");
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new k((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
