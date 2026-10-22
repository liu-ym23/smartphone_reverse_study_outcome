package com.obric.autoaction.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.avatar.OCircleImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FloatingIconBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f24599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f24600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OCircleImageView f24601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OCircleImageView f24602e;
    private final FrameLayout f;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private d(FrameLayout r1, LinearLayout r2, TextView r3, FrameLayout r4, OCircleImageView r5, OCircleImageView r6) {
        this.f = r1;
        this.f24598a = r2;
        this.f24599b = r3;
        this.f24600c = r4;
        this.f24601d = r5;
        this.f24602e = r6;
    }

    public FrameLayout b() {
        return this.f;
    }

    public static d a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static d a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.floating_icon, "layout", "floating_icon"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static d a(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.expanded_content, DbHelper.COL_ID, "expanded_content");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.expanded_text, DbHelper.COL_ID, "expanded_text");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.floating_icon_layout, DbHelper.COL_ID, "floating_icon_layout");
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon");
        OCircleImageView r10 = (OCircleImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OCircleImageView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.icon_expanded, DbHelper.COL_ID, "icon_expanded");
        OCircleImageView r11 = (OCircleImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OCircleImageView.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        return new d((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
