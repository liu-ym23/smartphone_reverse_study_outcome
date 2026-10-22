package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RecordDataListLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ax implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f22792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f22793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f22794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f22795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OButton f22796e;
    public final OFloatingTitleBar f;
    private final ConstraintLayout g;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ax(ConstraintLayout r1, View r2, LinearLayout r3, RecyclerView r4, OTextView r5, OButton r6, OFloatingTitleBar r7) {
        this.g = r1;
        this.f22792a = r2;
        this.f22793b = r3;
        this.f22794c = r4;
        this.f22795d = r5;
        this.f22796e = r6;
        this.f = r7;
    }

    public ConstraintLayout b() {
        return this.g;
    }

    public static ax a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static ax a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.record_data_list_layout, "layout", "record_data_list_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ax a(View r10) {
        int r0 = ZeusTransformUtils.mapRes(R.id.border, DbHelper.COL_ID, "border");
        View r4 = r10.findViewById(r0);
        if (r4 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.bottom_container, DbHelper.COL_ID, "bottom_container");
        LinearLayout r5 = (LinearLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.data_list, DbHelper.COL_ID, "data_list");
        RecyclerView r6 = (RecyclerView) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.license_tv, DbHelper.COL_ID, "license_tv");
        OTextView r7 = (OTextView) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.start_upload_btn, DbHelper.COL_ID, "start_upload_btn");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r9 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        return new ax((ConstraintLayout) ZeusTransformUtils.preCheckCast(r10, ConstraintLayout.class, "com.obric.aiagent.plugin"), r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
