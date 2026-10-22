package com.obric.autoaction.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActivityIslandDebugBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OButton f24583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f24584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OButton f24585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OButton f24586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OButton f24587e;
    private final ConstraintLayout f;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private a(ConstraintLayout r1, OButton r2, OButton r3, OButton r4, OButton r5, OButton r6) {
        this.f = r1;
        this.f24583a = r2;
        this.f24584b = r3;
        this.f24585c = r4;
        this.f24586d = r5;
        this.f24587e = r6;
    }

    public ConstraintLayout b() {
        return this.f;
    }

    public static a a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static a a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_island_debug, "layout", "activity_island_debug"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static a a(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.clarify, DbHelper.COL_ID, "clarify");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.create, DbHelper.COL_ID, "create");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.dismiss, DbHelper.COL_ID, "dismiss");
        OButton r9 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.done, DbHelper.COL_ID, "done");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.op, DbHelper.COL_ID, "op");
        OButton r11 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        return new a((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
