package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionHistoryDetailLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OFloatingTitleBar f22869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f22870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FrameLayout f22871c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private w(FrameLayout r1, OFloatingTitleBar r2, RecyclerView r3) {
        this.f22871c = r1;
        this.f22869a = r2;
        this.f22870b = r3;
    }

    public FrameLayout b() {
        return this.f22871c;
    }

    public static w a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_history_detail_layout, "layout", "autoaction_history_detail_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static w a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_title_bar, DbHelper.COL_ID, "detail_title_bar");
        OFloatingTitleBar r2 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.history_detail_rv, DbHelper.COL_ID, "history_detail_rv");
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new w((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
