package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.view.ExpandableTextLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionTaskListItemSimpleFutureBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class aj implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExpandableTextLayout f22742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OUILinearLayout f22743b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private aj(OUILinearLayout r1, ExpandableTextLayout r2) {
        this.f22743b = r1;
        this.f22742a = r2;
    }

    public OUILinearLayout b() {
        return this.f22743b;
    }

    public static aj a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_task_list_item_simple_future, "layout", "autoaction_task_list_item_simple_future"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static aj a(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.txt_tli_task_query, DbHelper.COL_ID, "txt_tli_task_query");
        ExpandableTextLayout r1 = (ExpandableTextLayout) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), ExpandableTextLayout.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return new aj((OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.aiagent.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
