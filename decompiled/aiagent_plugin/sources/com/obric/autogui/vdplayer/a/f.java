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

/* JADX INFO: compiled from: VdComponentPanelExpandedAutoExitBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f31609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f31610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f31611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f31612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f31613e;
    public final RelativeLayout f;
    private final RelativeLayout g;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private f(RelativeLayout r1, View r2, TextView r3, Button r4, AppCompatImageView r5, TextView r6, RelativeLayout r7) {
        this.g = r1;
        this.f31609a = r2;
        this.f31610b = r3;
        this.f31611c = r4;
        this.f31612d = r5;
        this.f31613e = r6;
        this.f = r7;
    }

    public RelativeLayout b() {
        return this.g;
    }

    public static f a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_component_panel_expanded_auto_exit, "layout", "vd_component_panel_expanded_auto_exit"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static f a(View r10) {
        int r0 = ZeusTransformUtils.mapRes(R.id.auto_exit_divider, DbHelper.COL_ID, "auto_exit_divider");
        View r4 = r10.findViewById(r0);
        if (r4 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.content, DbHelper.COL_ID, "content");
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.exit_button, DbHelper.COL_ID, "exit_button");
        Button r6 = (Button) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), Button.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.id_icon, DbHelper.COL_ID, "id_icon");
        AppCompatImageView r7 = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), AppCompatImageView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE);
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.title_layout, DbHelper.COL_ID, "title_layout");
        RelativeLayout r9 = (RelativeLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), RelativeLayout.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        return new f((RelativeLayout) ZeusTransformUtils.preCheckCast(r10, RelativeLayout.class, "com.obric.aiagent.plugin"), r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
