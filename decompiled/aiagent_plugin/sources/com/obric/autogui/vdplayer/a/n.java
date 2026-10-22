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

/* JADX INFO: compiled from: VdViewPrivacyBadgeBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f31643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f31644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f31645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f31646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f31647e;
    public final OTextView f;
    public final OTextView g;
    private final LinearLayout h;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private n(LinearLayout r1, LinearLayout r2, ImageView r3, OTextView r4, LinearLayout r5, LinearLayout r6, OTextView r7, OTextView r8) {
        this.h = r1;
        this.f31643a = r2;
        this.f31644b = r3;
        this.f31645c = r4;
        this.f31646d = r5;
        this.f31647e = r6;
        this.f = r7;
        this.g = r8;
    }

    public LinearLayout b() {
        return this.h;
    }

    public static n a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_view_privacy_badge, "layout", "vd_view_privacy_badge"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static n a(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.privacy_badge_content, DbHelper.COL_ID, "privacy_badge_content");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.privacy_badge_icon, DbHelper.COL_ID, "privacy_badge_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.privacy_badge_text, DbHelper.COL_ID, "privacy_badge_text");
        OTextView r9 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14, LinearLayout.class, "com.obric.aiagent.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.security_badge_content, DbHelper.COL_ID, "security_badge_content");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.security_badge_icon, DbHelper.COL_ID, "security_badge_icon");
        OTextView r12 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.security_badge_text, DbHelper.COL_ID, "security_badge_text");
        OTextView r13 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L17;
        return new n((LinearLayout) ZeusTransformUtils.preCheckCast(r14, LinearLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
