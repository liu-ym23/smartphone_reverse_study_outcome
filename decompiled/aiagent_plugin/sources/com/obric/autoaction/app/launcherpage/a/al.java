package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BannerImageItemLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class al implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f22749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OTextView f22750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RelativeLayout f22751c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private al(RelativeLayout r1, ImageView r2, OTextView r3) {
        this.f22751c = r1;
        this.f22749a = r2;
        this.f22750b = r3;
    }

    public RelativeLayout b() {
        return this.f22751c;
    }

    public static al a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.banner_image_item_layout, "layout", "banner_image_item_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static al a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.image, DbHelper.COL_ID, "image");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.operation, DbHelper.COL_ID, "operation");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new al((RelativeLayout) ZeusTransformUtils.preCheckCast(r5, RelativeLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
