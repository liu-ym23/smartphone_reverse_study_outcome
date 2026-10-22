package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdComponentPanelBubbleBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f31599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f31600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f31601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f31602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f31603e;
    public final View f;
    public final View g;
    public final ImageButton h;
    private final FrameLayout i;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private d(FrameLayout r1, LinearLayout r2, ImageView r3, FrameLayout r4, OTextView r5, FrameLayout r6, View r7, View r8, ImageButton r9) {
        this.i = r1;
        this.f31599a = r2;
        this.f31600b = r3;
        this.f31601c = r4;
        this.f31602d = r5;
        this.f31603e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public FrameLayout b() {
        return this.i;
    }

    public static d a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_component_panel_bubble, "layout", "vd_component_panel_bubble"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static d a(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bubble_content, DbHelper.COL_ID, "bubble_content");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.bubble_icon, DbHelper.COL_ID, "bubble_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r15, FrameLayout.class, "com.obric.aiagent.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.bubble_text, DbHelper.COL_ID, "bubble_text");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.bubble_top_handle, DbHelper.COL_ID, "bubble_top_handle");
        FrameLayout r11 = (FrameLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.bubble_top_handle_line_bottom, DbHelper.COL_ID, "bubble_top_handle_line_bottom");
        View r12 = r15.findViewById(r0);
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.bubble_top_handle_line_top, DbHelper.COL_ID, "bubble_top_handle_line_top");
        View r13 = r15.findViewById(r0);
        if (r13 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.bubble_trailing_button, DbHelper.COL_ID, "bubble_trailing_button");
        ImageButton r14 = (ImageButton) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ImageButton.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L19;
        return new d((FrameLayout) ZeusTransformUtils.preCheckCast(r15, FrameLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13, r14);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
