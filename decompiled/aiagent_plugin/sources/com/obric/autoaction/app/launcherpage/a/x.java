package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionHistoryDetailThoughtProcessCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f22872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f22873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinearLayout f22874c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private x(LinearLayout r1, TextView r2, ImageView r3) {
        this.f22874c = r1;
        this.f22872a = r2;
        this.f22873b = r3;
    }

    public LinearLayout b() {
        return this.f22874c;
    }

    public static x a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_history_detail_thought_process_cell, "layout", "autoaction_history_detail_thought_process_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static x a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_thought_process_content, DbHelper.COL_ID, "detail_thought_process_content");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_thought_process_icon, DbHelper.COL_ID, "detail_thought_process_icon");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new x((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
