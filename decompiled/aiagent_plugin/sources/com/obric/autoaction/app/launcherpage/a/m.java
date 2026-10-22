package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDetailTopTipCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f22837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f22838b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private m(FrameLayout r1, OTextView r2) {
        this.f22838b = r1;
        this.f22837a = r2;
    }

    public FrameLayout b() {
        return this.f22838b;
    }

    public static m a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_top_tip_cell, "layout", "autoaction_detail_top_tip_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static m a(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_top_tip, DbHelper.COL_ID, "detail_top_tip");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return new m((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.aiagent.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
