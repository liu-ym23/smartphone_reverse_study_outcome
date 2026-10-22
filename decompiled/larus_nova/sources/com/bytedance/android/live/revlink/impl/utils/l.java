package com.bytedance.android.live.revlink.impl.utils;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f97663a;

    public l(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "modes");
        this.f97663a = r100;
    }

    @Override // com.bytedance.android.live.revlink.impl.utils.k
    public final boolean a(int r100) {
        return !ArraysKt.contains(this.f97663a, r100);
    }
}
