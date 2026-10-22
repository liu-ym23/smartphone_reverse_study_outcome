package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdComponentPanelAppHistoryPopupBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f31594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f31595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OUIConstraintLayout f31596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f31597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f31598e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private c(FrameLayout r1, View r2, RecyclerView r3, OUIConstraintLayout r4, OTextView r5) {
        this.f31598e = r1;
        this.f31594a = r2;
        this.f31595b = r3;
        this.f31596c = r4;
        this.f31597d = r5;
    }

    public FrameLayout b() {
        return this.f31598e;
    }

    public static c a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_component_panel_app_history_popup, "layout", "vd_component_panel_app_history_popup"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static c a(View r8) {
        int r0 = ZeusTransformUtils.mapRes(R.id.popup_divider, DbHelper.COL_ID, "popup_divider");
        View r4 = r8.findViewById(r0);
        if (r4 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.popup_list_recycler, DbHelper.COL_ID, "popup_list_recycler");
        RecyclerView r5 = (RecyclerView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.popup_root, DbHelper.COL_ID, "popup_root");
        OUIConstraintLayout r6 = (OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), OUIConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.popup_title, DbHelper.COL_ID, "popup_title");
        OTextView r7 = (OTextView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        return new c((FrameLayout) ZeusTransformUtils.preCheckCast(r8, FrameLayout.class, "com.obric.aiagent.plugin"), r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
