package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionHistoryDetailItemContentCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f22867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinearLayout f22868b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private v(LinearLayout r1, TextView r2) {
        this.f22868b = r1;
        this.f22867a = r2;
    }

    public LinearLayout b() {
        return this.f22868b;
    }

    public static v a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_history_detail_item_content_cell, "layout", "autoaction_history_detail_item_content_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static v a(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.content_tv, DbHelper.COL_ID, "content_tv");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return new v((LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.aiagent.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
