package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.avatar.OCircleImageView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdLegacyComponentPanelExpandedBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f31634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScrollView f31635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f31636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f31637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OCircleImageView f31638e;
    public final ImageView f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final OTextView k;
    public final OTextView l;
    public final OTextView m;
    public final OTextView n;
    private final LinearLayout o;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private l(LinearLayout r1, LinearLayout r2, ScrollView r3, LinearLayout r4, LinearLayout r5, OCircleImageView r6, ImageView r7, LinearLayout r8, LinearLayout r9, LinearLayout r10, LinearLayout r11, OTextView r12, OTextView r13, OTextView r14, OTextView r15) {
        this.o = r1;
        this.f31634a = r2;
        this.f31635b = r3;
        this.f31636c = r4;
        this.f31637d = r5;
        this.f31638e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }

    public LinearLayout b() {
        return this.o;
    }

    public static l a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_legacy_component_panel_expanded, "layout", "vd_legacy_component_panel_expanded"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static l a(View r22) {
        int r1 = ZeusTransformUtils.mapRes(R.id.bottom_bar, DbHelper.COL_ID, "bottom_bar");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.content_scroll_view, DbHelper.COL_ID, "content_scroll_view");
        ScrollView r9 = (ScrollView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ScrollView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.control_bar, DbHelper.COL_ID, "control_bar");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.header_group, DbHelper.COL_ID, "header_group");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon");
        OCircleImageView r12 = (OCircleImageView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OCircleImageView.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon");
        ImageView r13 = (ImageView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), ImageView.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.option_group, DbHelper.COL_ID, "option_group");
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.panel_content_layout, DbHelper.COL_ID, "panel_content_layout");
        LinearLayout r15 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.prefix_container, DbHelper.COL_ID, "prefix_container");
        LinearLayout r16 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.security_badge_layout, DbHelper.COL_ID, "security_badge_layout");
        LinearLayout r17 = (LinearLayout) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.text, DbHelper.COL_ID, "text");
        OTextView r18 = (OTextView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_content, DbHelper.COL_ID, "tv_content");
        OTextView r19 = (OTextView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_security_badge, DbHelper.COL_ID, "tv_security_badge");
        OTextView r20 = (OTextView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L33;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title");
        OTextView r21 = (OTextView) ZeusTransformUtils.preCheckCast(r22.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L33;
        return new l((LinearLayout) ZeusTransformUtils.preCheckCast(r22, LinearLayout.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r22, "com.obric.aiagent.plugin").getResourceName(r1)));
    }
}
