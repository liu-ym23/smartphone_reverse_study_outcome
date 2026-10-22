package com.bytedance.android.live.core.tetris;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements f70.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f65493a;

    public b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "masterView");
        this.f65493a = r100;
    }

    @Override // f70.a
    public final ViewGroup a(f70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "layerType");
        return this.f65493a;
    }
}
