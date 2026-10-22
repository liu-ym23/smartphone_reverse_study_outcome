package com.bytedance.android.shopping.anchorv4.ai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f[] f165682a;

    @Override // com.bytedance.android.shopping.anchorv4.ai.f
    public final void dispose() {
        f[] r100 = this.f165682a;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].dispose();
        r102 = r102 + 1;
        goto L3
    }

    public r(f... r100) {
        Intrinsics.checkNotNullParameter(r100, "disposables");
        this.f165682a = r100;
    }
}
