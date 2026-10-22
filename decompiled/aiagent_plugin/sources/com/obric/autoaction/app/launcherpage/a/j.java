package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDetailShortInstructCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f22828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OCardListItem f22830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f22831d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private j(LinearLayout r1, OTextView r2, OCardListItem r3, OCardListItem r4) {
        this.f22831d = r1;
        this.f22828a = r2;
        this.f22829b = r3;
        this.f22830c = r4;
    }

    public LinearLayout b() {
        return this.f22831d;
    }

    public static j a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_detail_short_instruct_cell, "layout", "autoaction_detail_short_instruct_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static j a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.detail_event_trigger_other, DbHelper.COL_ID, "detail_event_trigger_other");
        OTextView r2 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_shortcut_instruct_input, DbHelper.COL_ID, "detail_shortcut_instruct_input");
        OCardListItem r3 = (OCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.detail_shortcut_instruct_item, DbHelper.COL_ID, "detail_shortcut_instruct_item");
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        return new j((LinearLayout) ZeusTransformUtils.preCheckCast(r6, LinearLayout.class, "com.obric.aiagent.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
