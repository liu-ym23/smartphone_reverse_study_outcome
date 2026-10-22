package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: AutoactionConditionCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f22699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinearLayout f22700b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private a(LinearLayout r1, LinearLayout r2) {
        this.f22700b = r1;
        this.f22699a = r2;
    }

    public LinearLayout b() {
        return this.f22700b;
    }

    public static a a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_condition_cell, "layout", "autoaction_condition_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static a a(View r4) {
        Objects.requireNonNull(r4, "rootView");
        LinearLayout r0 = (LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.aiagent.plugin");
        return new a((LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.aiagent.plugin"), r0);
    }
}
