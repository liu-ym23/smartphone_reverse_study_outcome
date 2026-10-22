package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DonationQuestionSortItemBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class aq implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f22768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f22769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f22770d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private aq(ConstraintLayout r1, OCardListItem r2, RecyclerView r3, ConstraintLayout r4) {
        this.f22770d = r1;
        this.f22767a = r2;
        this.f22768b = r3;
        this.f22769c = r4;
    }

    public ConstraintLayout b() {
        return this.f22770d;
    }

    public static aq a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.donation_question_sort_item, "layout", "donation_question_sort_item"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static aq a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.list_title, DbHelper.COL_ID, "list_title");
        OCardListItem r2 = (OCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.question_list, DbHelper.COL_ID, "question_list");
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        ConstraintLayout r3 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.aiagent.plugin");
        return new aq((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.aiagent.plugin"), r2, r1, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
