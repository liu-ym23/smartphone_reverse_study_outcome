package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDetailQueryCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OTextView f22821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinearLayout f22822c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private h(LinearLayout r1, OCardListItem r2, OTextView r3) {
        this.f22822c = r1;
        this.f22820a = r2;
        this.f22821b = r3;
    }

    public LinearLayout b() {
        return this.f22822c;
    }

    public static h a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_query_cell, "layout", "autoaction_detail_query_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static h a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_query_input_card, DbHelper.COL_ID, "detail_query_input_card");
        OCardListItem r2 = (OCardListItem) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_query_title, DbHelper.COL_ID, "detail_query_title");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new h((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
