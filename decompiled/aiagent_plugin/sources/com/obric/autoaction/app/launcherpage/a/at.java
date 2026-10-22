package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarusAutoactionDetailKnowledgeCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class at implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinearLayout f22778b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private at(LinearLayout r1, OCardListItem r2) {
        this.f22778b = r1;
        this.f22777a = r2;
    }

    public LinearLayout b() {
        return this.f22778b;
    }

    public static at a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.larus_autoaction_detail_knowledge_cell, "layout", "larus_autoaction_detail_knowledge_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static at a(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_knowledge_item, DbHelper.COL_ID, "detail_knowledge_item");
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return new at((LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.aiagent.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
