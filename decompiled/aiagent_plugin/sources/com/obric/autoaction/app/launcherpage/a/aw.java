package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RecordDataListHeaderLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class aw implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSectionTitleBar f22790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OUILinearLayout f22791c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private aw(OUILinearLayout r1, OCardListItem r2, OSectionTitleBar r3) {
        this.f22791c = r1;
        this.f22789a = r2;
        this.f22790b = r3;
    }

    public OUILinearLayout b() {
        return this.f22791c;
    }

    public static aw a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.record_data_list_header_layout, "layout", "record_data_list_header_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static aw a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.item_container, DbHelper.COL_ID, "item_container");
        OCardListItem r2 = (OCardListItem) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.query_title, DbHelper.COL_ID, "query_title");
        OSectionTitleBar r1 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OSectionTitleBar.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new aw((OUILinearLayout) ZeusTransformUtils.preCheckCast(r5, OUILinearLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
