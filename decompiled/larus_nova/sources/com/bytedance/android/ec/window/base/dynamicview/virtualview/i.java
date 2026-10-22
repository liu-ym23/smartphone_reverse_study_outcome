package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i<V extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vo.a<V> f49306b;

    public i(String r100, vo.a<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewType");
        Intrinsics.checkNotNullParameter(r101, "viewMaker");
        this.f49305a = r100;
        this.f49306b = r101;
    }
}
