package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionConditionConfigureSheetBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f22799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f22800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OFloatingTitleBar f22801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f22802d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private b(ConstraintLayout r1, RecyclerView r2, FrameLayout r3, OFloatingTitleBar r4) {
        this.f22802d = r1;
        this.f22799a = r2;
        this.f22800b = r3;
        this.f22801c = r4;
    }

    public ConstraintLayout b() {
        return this.f22802d;
    }

    public static b a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static b a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_condition_configure_sheet, "layout", "autoaction_condition_configure_sheet"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static b a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.condition_list, DbHelper.COL_ID, "condition_list");
        RecyclerView r2 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_list_container, DbHelper.COL_ID, "condition_list_container");
        FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.titlebar, DbHelper.COL_ID, "titlebar");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        return new b((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.aiagent.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
