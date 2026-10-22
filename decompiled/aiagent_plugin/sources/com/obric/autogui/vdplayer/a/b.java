package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: VdComponentPanelAppHistoryItemBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f31589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f31590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f31591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f31592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f31593e;
    private final ConstraintLayout f;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private b(ConstraintLayout r1, ImageView r2, ImageView r3, OTextView r4, View r5, ConstraintLayout r6) {
        this.f = r1;
        this.f31589a = r2;
        this.f31590b = r3;
        this.f31591c = r4;
        this.f31592d = r5;
        this.f31593e = r6;
    }

    public ConstraintLayout b() {
        return this.f;
    }

    public static b a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_component_panel_app_history_item, "layout", "vd_component_panel_app_history_item"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static b a(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.app_check, DbHelper.COL_ID, "app_check");
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.app_icon, DbHelper.COL_ID, "app_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.app_name, DbHelper.COL_ID, IBdInstall.PARAM_APP_NAME);
        OTextView r9 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider");
        View r10 = r12.findViewById(r0);
        if (r10 == null) goto L13;
        ConstraintLayout r11 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.aiagent.plugin");
        return new b((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
