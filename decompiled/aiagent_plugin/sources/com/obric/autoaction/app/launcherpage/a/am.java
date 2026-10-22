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

/* JADX INFO: compiled from: DataDonationLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class am implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f22752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OPageStatus f22753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f22754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OFloatingTitleBar f22755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f22756e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private am(ConstraintLayout r1, ConstraintLayout r2, OPageStatus r3, RecyclerView r4, OFloatingTitleBar r5) {
        this.f22756e = r1;
        this.f22752a = r2;
        this.f22753b = r3;
        this.f22754c = r4;
        this.f22755d = r5;
    }

    public ConstraintLayout b() {
        return this.f22756e;
    }

    public static am a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.data_donation_layout, "layout", "data_donation_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static am a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container");
        ConstraintLayout r7 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.page_status, DbHelper.COL_ID, "page_status");
        OPageStatus r8 = (OPageStatus) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.question_list, DbHelper.COL_ID, "question_list");
        RecyclerView r9 = (RecyclerView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r10 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new am((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
