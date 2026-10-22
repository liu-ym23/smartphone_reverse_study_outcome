package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.coachmark.OCoachmarkTipView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.markdown.OMarkdownView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DonationQuestionDescLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ao implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f22759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f22760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f22761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OMarkdownView f22762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OSectionTitleBar f22763e;
    public final OCoachmarkTipView f;
    public final OButton g;
    public final OCardListItem h;
    public final OFloatingTitleBar i;
    private final RelativeLayout j;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ao(RelativeLayout r1, View r2, LinearLayout r3, OTextView r4, OMarkdownView r5, OSectionTitleBar r6, OCoachmarkTipView r7, OButton r8, OCardListItem r9, OFloatingTitleBar r10) {
        this.j = r1;
        this.f22759a = r2;
        this.f22760b = r3;
        this.f22761c = r4;
        this.f22762d = r5;
        this.f22763e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public RelativeLayout b() {
        return this.j;
    }

    public static ao a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static ao a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.donation_question_desc_layout, "layout", "donation_question_desc_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ao a(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.border, DbHelper.COL_ID, "border");
        View r4 = r13.findViewById(r0);
        if (r4 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.bottom_action_container, DbHelper.COL_ID, "bottom_action_container");
        LinearLayout r5 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.license_tv, DbHelper.COL_ID, "license_tv");
        OTextView r6 = (OTextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.process_introduction_desc_tv, DbHelper.COL_ID, "process_introduction_desc_tv");
        OMarkdownView r7 = (OMarkdownView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OMarkdownView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.query_title, DbHelper.COL_ID, "query_title");
        OSectionTitleBar r8 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OSectionTitleBar.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.reward_desc, DbHelper.COL_ID, "reward_desc");
        OCoachmarkTipView r9 = (OCoachmarkTipView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OCoachmarkTipView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.start_btn, DbHelper.COL_ID, "start_btn");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.target_input_card, DbHelper.COL_ID, "target_input_card");
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L23;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r12 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L23;
        return new ao((RelativeLayout) ZeusTransformUtils.preCheckCast(r13, RelativeLayout.class, "com.obric.aiagent.plugin"), r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
