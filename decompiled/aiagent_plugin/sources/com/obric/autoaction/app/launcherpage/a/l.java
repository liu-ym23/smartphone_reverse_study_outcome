package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDetailTipCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSectionSupportiveText f22835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f22836b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private l(FrameLayout r1, OSectionSupportiveText r2) {
        this.f22836b = r1;
        this.f22835a = r2;
    }

    public FrameLayout b() {
        return this.f22836b;
    }

    public static l a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_tip_cell, "layout", "autoaction_detail_tip_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static l a(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bottom_tip, DbHelper.COL_ID, "bottom_tip");
        OSectionSupportiveText r1 = (OSectionSupportiveText) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), OSectionSupportiveText.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return new l((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.aiagent.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
