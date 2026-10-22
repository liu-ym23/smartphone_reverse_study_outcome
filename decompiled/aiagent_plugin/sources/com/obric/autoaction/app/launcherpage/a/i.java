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

/* JADX INFO: compiled from: AutoactionDetailRepeatCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OCardListItem f22825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f22826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OCardListItem f22827e;
    public final OCardListItem f;
    private final LinearLayout g;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private i(LinearLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, OTextView r5, OCardListItem r6, OCardListItem r7) {
        this.g = r1;
        this.f22823a = r2;
        this.f22824b = r3;
        this.f22825c = r4;
        this.f22826d = r5;
        this.f22827e = r6;
        this.f = r7;
    }

    public LinearLayout b() {
        return this.g;
    }

    public static i a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_repeat_cell, "layout", "autoaction_detail_repeat_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static i a(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.condition_event_monthly_picker, DbHelper.COL_ID, "condition_event_monthly_picker");
        OCardListItem r7 = (OCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_event_repeat_mode_item, DbHelper.COL_ID, "condition_event_repeat_mode_item");
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_event_repeat_time, DbHelper.COL_ID, "condition_event_repeat_time");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_event_trigger_setting, DbHelper.COL_ID, "condition_event_trigger_setting");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_event_weekly_picker, DbHelper.COL_ID, "condition_event_weekly_picker");
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_event_yearly_picker, DbHelper.COL_ID, "condition_event_yearly_picker");
        OCardListItem r12 = (OCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L17;
        return new i((LinearLayout) ZeusTransformUtils.preCheckCast(r13, LinearLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
