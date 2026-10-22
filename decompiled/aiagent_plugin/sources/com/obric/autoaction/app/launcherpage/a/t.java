package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionEditKnowlegdeDialogLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OFloatingTitleBar f22860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FrameLayout f22861c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private t(FrameLayout r1, OCardListItem r2, OFloatingTitleBar r3) {
        this.f22861c = r1;
        this.f22859a = r2;
        this.f22860b = r3;
    }

    public FrameLayout b() {
        return this.f22861c;
    }

    public static t a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static t a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_edit_knowlegde_dialog_layout, "layout", "autoaction_edit_knowlegde_dialog_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static t a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.knowledge_input_card, DbHelper.COL_ID, "knowledge_input_card");
        OCardListItem r2 = (OCardListItem) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new t((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
