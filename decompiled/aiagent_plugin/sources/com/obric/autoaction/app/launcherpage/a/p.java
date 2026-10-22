package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDiscoveryListBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OPageStatus f22847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f22848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FrameLayout f22849c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private p(FrameLayout r1, OPageStatus r2, RecyclerView r3) {
        this.f22849c = r1;
        this.f22847a = r2;
        this.f22848b = r3;
    }

    public FrameLayout b() {
        return this.f22849c;
    }

    public static p a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_discovery_list, "layout", "autoaction_discovery_list"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static p a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.empty_state_view, DbHelper.COL_ID, "empty_state_view");
        OPageStatus r2 = (OPageStatus) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_discovery_list, DbHelper.COL_ID, "rv_discovery_list");
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new p((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
