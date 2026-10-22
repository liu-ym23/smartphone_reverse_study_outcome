package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdLegacyComponentPanelBubbleBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f31621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OTextView f31622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinearLayout f31623c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private i(LinearLayout r1, ImageView r2, OTextView r3) {
        this.f31623c = r1;
        this.f31621a = r2;
        this.f31622b = r3;
    }

    public LinearLayout b() {
        return this.f31623c;
    }

    public static i a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_legacy_component_panel_bubble, "layout", "vd_legacy_component_panel_bubble"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static i a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.bubble_icon, DbHelper.COL_ID, "bubble_icon");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.bubbleText, DbHelper.COL_ID, "bubbleText");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new i((LinearLayout) ZeusTransformUtils.preCheckCast(r5, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
