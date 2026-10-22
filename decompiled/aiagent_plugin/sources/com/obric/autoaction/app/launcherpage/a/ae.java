package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionShortcutCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ae implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OIconButton f22721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f22722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f22723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f22724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final OUICardConstraintLayout f22725e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ae(OUICardConstraintLayout r1, OIconButton r2, ImageView r3, OTextView r4, OTextView r5) {
        this.f22725e = r1;
        this.f22721a = r2;
        this.f22722b = r3;
        this.f22723c = r4;
        this.f22724d = r5;
    }

    public OUICardConstraintLayout b() {
        return this.f22725e;
    }

    public static ae a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_shortcut_cell, "layout", "autoaction_shortcut_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ae a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.play, DbHelper.COL_ID, "play");
        OIconButton r7 = (OIconButton) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OIconButton.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.semantic_icon, DbHelper.COL_ID, "semantic_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.sub_title, DbHelper.COL_ID, "sub_title");
        OTextView r9 = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE);
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new ae((OUICardConstraintLayout) ZeusTransformUtils.preCheckCast(r11, OUICardConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
