package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDetailInstructInfoCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSectionSupportiveText f22817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinearLayout f22819c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private g(LinearLayout r1, OSectionSupportiveText r2, OCardListItem r3) {
        this.f22819c = r1;
        this.f22817a = r2;
        this.f22818b = r3;
    }

    public LinearLayout b() {
        return this.f22819c;
    }

    public static g a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_instruct_info_cell, "layout", "autoaction_detail_instruct_info_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static g a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bottom_tip, DbHelper.COL_ID, "bottom_tip");
        OSectionSupportiveText r2 = (OSectionSupportiveText) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OSectionSupportiveText.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.query_content, DbHelper.COL_ID, "query_content");
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new g((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
