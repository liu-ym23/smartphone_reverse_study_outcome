package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDiscoveryErrorPageLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f22839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f22840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConstraintLayout f22841c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private n(ConstraintLayout r1, OTextView r2, OButton r3) {
        this.f22841c = r1;
        this.f22839a = r2;
        this.f22840b = r3;
    }

    public ConstraintLayout b() {
        return this.f22841c;
    }

    public static n a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_discovery_error_page_layout, "layout", "autoaction_discovery_error_page_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static n a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.error_msg, DbHelper.COL_ID, "error_msg");
        OTextView r2 = (OTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.try_again_btn, DbHelper.COL_ID, "try_again_btn");
        OButton r1 = (OButton) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new n((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
