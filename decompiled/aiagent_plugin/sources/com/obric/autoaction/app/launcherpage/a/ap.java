package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DonationQuestionItemBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ap implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f22764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FrameLayout f22766c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ap(FrameLayout r1, FrameLayout r2, OCardListItem r3) {
        this.f22766c = r1;
        this.f22764a = r2;
        this.f22765b = r3;
    }

    public FrameLayout b() {
        return this.f22766c;
    }

    public static ap a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.donation_question_item, "layout", "donation_question_item"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ap a(View r5) {
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin");
        int r2 = ZeusTransformUtils.mapRes(R.id.question_item, DbHelper.COL_ID, "question_item");
        OCardListItem r3 = (OCardListItem) ZeusTransformUtils.preCheckCast(r5.findViewById(r2), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return new ap((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin"), r0, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r2)));
    }
}
