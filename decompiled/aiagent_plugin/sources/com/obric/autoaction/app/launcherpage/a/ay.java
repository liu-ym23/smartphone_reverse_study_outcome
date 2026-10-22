package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.banner.OBanner;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RecordedDataPreviewLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ay implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OBanner f22797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConstraintLayout f22798b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ay(ConstraintLayout r1, OBanner r2) {
        this.f22798b = r1;
        this.f22797a = r2;
    }

    public ConstraintLayout b() {
        return this.f22798b;
    }

    public static ay a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static ay a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.recorded_data_preview_layout, "layout", "recorded_data_preview_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ay a(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.banner, DbHelper.COL_ID, "banner");
        OBanner r1 = (OBanner) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), OBanner.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return new ay((ConstraintLayout) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.class, "com.obric.aiagent.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
