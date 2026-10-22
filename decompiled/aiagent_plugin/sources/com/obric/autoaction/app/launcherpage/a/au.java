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

/* JADX INFO: compiled from: LarusAutoactionDetailModelExtraCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class au implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OTextView f22780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OCardListItem f22781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OCardListItem f22782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f22783e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private au(LinearLayout r1, OCardListItem r2, OTextView r3, OCardListItem r4, OCardListItem r5) {
        this.f22783e = r1;
        this.f22779a = r2;
        this.f22780b = r3;
        this.f22781c = r4;
        this.f22782d = r5;
    }

    public LinearLayout b() {
        return this.f22783e;
    }

    public static au a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.larus_autoaction_detail_model_extra_cell, "layout", "larus_autoaction_detail_model_extra_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static au a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_frequency_control_item, DbHelper.COL_ID, "detail_frequency_control_item");
        OCardListItem r7 = (OCardListItem) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_model_extra_title, DbHelper.COL_ID, "detail_model_extra_title");
        OTextView r8 = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_model_select_item, DbHelper.COL_ID, "detail_model_select_item");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_run_history_item, DbHelper.COL_ID, "detail_run_history_item");
        OCardListItem r10 = (OCardListItem) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new au((LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
