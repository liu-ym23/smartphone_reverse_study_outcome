package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDiscoveryTitleCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f22857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RelativeLayout f22858b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private s(RelativeLayout r1, OTextView r2) {
        this.f22858b = r1;
        this.f22857a = r2;
    }

    public RelativeLayout b() {
        return this.f22858b;
    }

    public static s a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_discovery_title_cell, "layout", "autoaction_discovery_title_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static s a(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return new s((RelativeLayout) ZeusTransformUtils.preCheckCast(r4, RelativeLayout.class, "com.obric.aiagent.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
