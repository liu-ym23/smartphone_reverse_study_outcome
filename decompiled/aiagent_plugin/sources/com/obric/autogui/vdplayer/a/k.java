package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdLegacyComponentPanelExpandedAutoExitBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f31629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f31630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f31631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f31632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RelativeLayout f31633e;
    private final RelativeLayout f;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private k(RelativeLayout r1, TextView r2, Button r3, AppCompatImageView r4, TextView r5, RelativeLayout r6) {
        this.f = r1;
        this.f31629a = r2;
        this.f31630b = r3;
        this.f31631c = r4;
        this.f31632d = r5;
        this.f31633e = r6;
    }

    public RelativeLayout b() {
        return this.f;
    }

    public static k a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_legacy_component_panel_expanded_auto_exit, "layout", "vd_legacy_component_panel_expanded_auto_exit"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static k a(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.content, DbHelper.COL_ID, "content");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.exit_button, DbHelper.COL_ID, "exit_button");
        Button r8 = (Button) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), Button.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.id_icon, DbHelper.COL_ID, "id_icon");
        AppCompatImageView r9 = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), AppCompatImageView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE);
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.title_layout, DbHelper.COL_ID, "title_layout");
        RelativeLayout r11 = (RelativeLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), RelativeLayout.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        return new k((RelativeLayout) ZeusTransformUtils.preCheckCast(r12, RelativeLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
