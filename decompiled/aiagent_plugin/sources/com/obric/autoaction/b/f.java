package com.obric.autoaction.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.view.PrefixLabelEditText;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIConstraintLayout;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GlobalInputWindowV2Binding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUIConstraintLayout f24608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f24609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f24610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrollView f24611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f24612e;
    public final PrefixLabelEditText f;
    public final OButton g;
    public final TextView h;
    private final FrameLayout i;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private f(FrameLayout r1, OUIConstraintLayout r2, OButton r3, TextView r4, ScrollView r5, ImageView r6, PrefixLabelEditText r7, OButton r8, TextView r9) {
        this.i = r1;
        this.f24608a = r2;
        this.f24609b = r3;
        this.f24610c = r4;
        this.f24611d = r5;
        this.f24612e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public FrameLayout b() {
        return this.i;
    }

    public static f a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static f a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.global_input_window_v2, "layout", "global_input_window_v2"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static f a(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bg, DbHelper.COL_ID, "bg");
        OUIConstraintLayout r7 = (OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OUIConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.cancel_button, DbHelper.COL_ID, "cancel_button");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.content, DbHelper.COL_ID, "content");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.contentScroll, DbHelper.COL_ID, "contentScroll");
        ScrollView r10 = (ScrollView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ScrollView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.input_content, DbHelper.COL_ID, "input_content");
        PrefixLabelEditText r12 = (PrefixLabelEditText) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), PrefixLabelEditText.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.send_button, DbHelper.COL_ID, "send_button");
        OButton r13 = (OButton) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE);
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L21;
        return new f((FrameLayout) ZeusTransformUtils.preCheckCast(r15, FrameLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13, r14);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
