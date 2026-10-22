package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionConditionGroupCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f22803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f22804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f22805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f22806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f22807e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private c(RelativeLayout r1, ImageView r2, LinearLayout r3, OTextView r4, OTextView r5) {
        this.f22807e = r1;
        this.f22803a = r2;
        this.f22804b = r3;
        this.f22805c = r4;
        this.f22806d = r5;
    }

    public RelativeLayout b() {
        return this.f22807e;
    }

    public static c a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static c a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_condition_group_cell, "layout", "autoaction_condition_group_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static c a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.manage_arrow, DbHelper.COL_ID, "manage_arrow");
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.manage_entry, DbHelper.COL_ID, "manage_entry");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.manage_text, DbHelper.COL_ID, "manage_text");
        OTextView r9 = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.text, DbHelper.COL_ID, "text");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new c((RelativeLayout) ZeusTransformUtils.preCheckCast(r11, RelativeLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
