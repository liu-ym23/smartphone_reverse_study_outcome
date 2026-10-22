package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.view.ViewGroup;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements g<ViewGroup.MarginLayoutParams, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f49300a = null;

    public d() {
    }

    static {
        f49300a = new d();
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final ViewGroup.LayoutParams b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "uiParam");
        ViewGroup.MarginLayoutParams r101 = new ViewGroup.MarginLayoutParams(r100.f49307a, r100.f49308b);
        com.bytedance.android.ec.window.base.dynamicview.common.a.b(r101, r100.f49312f);
        return r101;
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final void a(Object r100, ViewGroup.LayoutParams r101, List r102) {
        Intrinsics.checkNotNullParameter((ViewGroup.MarginLayoutParams) r101, "lp");
        Intrinsics.checkNotNullParameter(r102, "allElements");
    }
}
