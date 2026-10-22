package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.view.ExpandableTextLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionTaskListItemNormalFutureBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ai implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f22739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExpandableTextLayout f22740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OUILinearLayout f22741c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ai(OUILinearLayout r1, ConstraintLayout r2, ExpandableTextLayout r3) {
        this.f22741c = r1;
        this.f22739a = r2;
        this.f22740b = r3;
    }

    public OUILinearLayout b() {
        return this.f22741c;
    }

    public static ai a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_task_list_item_normal_future, "layout", "autoaction_task_list_item_normal_future"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ai a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.first_line, DbHelper.COL_ID, "first_line");
        ConstraintLayout r2 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), ConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.txt_tli_task_query, DbHelper.COL_ID, "txt_tli_task_query");
        ExpandableTextLayout r1 = (ExpandableTextLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), ExpandableTextLayout.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new ai((OUILinearLayout) ZeusTransformUtils.preCheckCast(r5, OUILinearLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
