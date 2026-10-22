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

/* JADX INFO: compiled from: VdLegacyViewPrivacyBadgeBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f31639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f31640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f31641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f31642d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private m(LinearLayout r1, LinearLayout r2, ImageView r3, OTextView r4) {
        this.f31642d = r1;
        this.f31639a = r2;
        this.f31640b = r3;
        this.f31641c = r4;
    }

    public LinearLayout b() {
        return this.f31642d;
    }

    public static m a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_legacy_view_privacy_badge, "layout", "vd_legacy_view_privacy_badge"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static m a(View r6) {
        LinearLayout r0 = (LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.aiagent.plugin");
        int r2 = ZeusTransformUtils.mapRes(R.id.privacy_badge_icon, DbHelper.COL_ID, "privacy_badge_icon");
        ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r2), ImageView.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        r2 = ZeusTransformUtils.mapRes(R.id.privacy_badge_text, DbHelper.COL_ID, "privacy_badge_text");
        OTextView r3 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r2), OTextView.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        return new m((LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.aiagent.plugin"), r0, r4, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r2)));
    }
}
