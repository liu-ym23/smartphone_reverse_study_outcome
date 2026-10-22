package com.bytedance.android.ec.store.status;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StructType f48658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f48659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f48660c;

    public final StructType getType() {
        return this.f48658a;
    }

    public e(StructType r100, a r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        a r103 = new a(0, 0, 0, 0);
    L7:
        if ((r102 & 4) == 0) goto L9;
        r101 = new a(0, 0, 0, 0);
    L9:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r103, "paddingParams");
        Intrinsics.checkNotNullParameter(r101, "marginParams");
        this.f48658a = r100;
        this.f48659b = r103;
        this.f48660c = r101;
        return;
    L5:
        r103 = null;
        goto L7
    }
}
