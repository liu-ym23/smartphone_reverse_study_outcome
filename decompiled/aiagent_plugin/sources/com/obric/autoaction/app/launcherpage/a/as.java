package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DonationUploadRecordLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class as implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OPageStatus f22773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f22774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OFloatingTitleBar f22775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f22776d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private as(ConstraintLayout r1, OPageStatus r2, RecyclerView r3, OFloatingTitleBar r4) {
        this.f22776d = r1;
        this.f22773a = r2;
        this.f22774b = r3;
        this.f22775c = r4;
    }

    public ConstraintLayout b() {
        return this.f22776d;
    }

    public static as a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static as a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.donation_upload_record_layout, "layout", "donation_upload_record_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static as a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.page_status, DbHelper.COL_ID, "page_status");
        OPageStatus r2 = (OPageStatus) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.recycler_view, DbHelper.COL_ID, "recycler_view");
        RecyclerView r3 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        return new as((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.aiagent.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
