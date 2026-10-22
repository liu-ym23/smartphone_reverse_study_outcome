package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionHistoryDetailThoughtStartEndCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f22875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f22876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f22877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f22878d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private y(LinearLayout r1, ImageView r2, LinearLayout r3, OTextView r4) {
        this.f22878d = r1;
        this.f22875a = r2;
        this.f22876b = r3;
        this.f22877c = r4;
    }

    public LinearLayout b() {
        return this.f22878d;
    }

    public static y a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_history_detail_thought_start_end_cell, "layout", "autoaction_history_detail_thought_start_end_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static y a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_thought_end_icon, DbHelper.COL_ID, "detail_thought_end_icon");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        LinearLayout r1 = (LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.aiagent.plugin");
        int r3 = ZeusTransformUtils.mapRes(R.id.detail_thought_end_title, DbHelper.COL_ID, "detail_thought_end_title");
        OTextView r4 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r3), OTextView.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        r0 = r3;
        goto L10
    L7:
        return new y((LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r1, r4);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
