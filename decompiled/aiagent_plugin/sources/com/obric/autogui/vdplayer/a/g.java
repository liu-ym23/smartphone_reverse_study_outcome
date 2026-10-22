package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.components.panel.VDPlayerMarkdownView;
import com.obric.oui.avatar.OCircleImageView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdComponentPanelExpandedBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f31614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageButton f31615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageButton f31616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f31617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScrollView f31618e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final OCircleImageView i;
    public final ImageView j;
    public final VDPlayerMarkdownView k;
    public final LinearLayout l;
    public final LinearLayout m;
    public final LinearLayout n;
    public final OTextView o;
    public final OTextView p;
    public final OTextView q;
    private final FrameLayout r;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private g(FrameLayout r3, LinearLayout r4, ImageButton r5, ImageButton r6, ConstraintLayout r7, ScrollView r8, LinearLayout r9, LinearLayout r10, LinearLayout r11, OCircleImageView r12, ImageView r13, VDPlayerMarkdownView r14, LinearLayout r15, LinearLayout r16, LinearLayout r17, OTextView r18, OTextView r19, OTextView r20) {
        this.r = r3;
        this.f31614a = r4;
        this.f31615b = r5;
        this.f31616c = r6;
        this.f31617d = r7;
        this.f31618e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
    }

    public FrameLayout b() {
        return this.r;
    }

    public static g a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_component_panel_expanded, "layout", "vd_component_panel_expanded"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static g a(View r25) {
        int r1 = ZeusTransformUtils.mapRes(R.id.bottom_bar, DbHelper.COL_ID, "bottom_bar");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.collapse_button_floating, DbHelper.COL_ID, "collapse_button_floating");
        ImageButton r9 = (ImageButton) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), ImageButton.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.collapse_button_inline, DbHelper.COL_ID, "collapse_button_inline");
        ImageButton r10 = (ImageButton) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), ImageButton.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.content_body_container, DbHelper.COL_ID, "content_body_container");
        ConstraintLayout r11 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), ConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.content_scroll_view, DbHelper.COL_ID, "content_scroll_view");
        ScrollView r12 = (ScrollView) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), ScrollView.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.control_bar, DbHelper.COL_ID, "control_bar");
        LinearLayout r13 = (LinearLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.expanded_content_container, DbHelper.COL_ID, "expanded_content_container");
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.header_group, DbHelper.COL_ID, "header_group");
        LinearLayout r15 = (LinearLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon");
        OCircleImageView r16 = (OCircleImageView) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), OCircleImageView.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), ImageView.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.markdown_content_view, DbHelper.COL_ID, "markdown_content_view");
        VDPlayerMarkdownView r18 = (VDPlayerMarkdownView) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), VDPlayerMarkdownView.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.option_group, DbHelper.COL_ID, "option_group");
        LinearLayout r19 = (LinearLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.panel_content_layout, DbHelper.COL_ID, "panel_content_layout");
        LinearLayout r20 = (LinearLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.prefix_container, DbHelper.COL_ID, "prefix_container");
        LinearLayout r21 = (LinearLayout) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.text, DbHelper.COL_ID, "text");
        OTextView r22 = (OTextView) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_content, DbHelper.COL_ID, "tv_content");
        OTextView r23 = (OTextView) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L39;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title");
        OTextView r24 = (OTextView) ZeusTransformUtils.preCheckCast(r25.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L39;
        return new g((FrameLayout) ZeusTransformUtils.preCheckCast(r25, FrameLayout.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r25, "com.obric.aiagent.plugin").getResourceName(r1)));
    }
}
