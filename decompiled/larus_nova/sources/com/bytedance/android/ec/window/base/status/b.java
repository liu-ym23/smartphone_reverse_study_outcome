package com.bytedance.android.ec.window.base.status;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StructType f49699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f49700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f49701c;

    public final StructType getType() {
        return this.f49699a;
    }

    public b(StructType r100, a r101) {
        a r102 = new a(0, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "paddingParams");
        Intrinsics.checkNotNullParameter(r101, "marginParams");
        this.f49699a = r100;
        this.f49700b = r102;
        this.f49701c = r101;
    }
}
