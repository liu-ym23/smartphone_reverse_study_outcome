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

/* JADX INFO: compiled from: AutoactionDetailDateCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f22813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OCardListItem f22815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f22816d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private f(LinearLayout r1, OTextView r2, OCardListItem r3, OCardListItem r4) {
        this.f22816d = r1;
        this.f22813a = r2;
        this.f22814b = r3;
        this.f22815c = r4;
    }

    public LinearLayout b() {
        return this.f22816d;
    }

    public static f a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_date_cell, "layout", "autoaction_detail_date_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static f a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.condition_event_date_setting, DbHelper.COL_ID, "condition_event_date_setting");
        OTextView r2 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_event_repeat_mode_expire_date, DbHelper.COL_ID, "condition_event_repeat_mode_expire_date");
        OCardListItem r3 = (OCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_event_repeat_mode_start_date, DbHelper.COL_ID, "condition_event_repeat_mode_start_date");
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        return new f((LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
