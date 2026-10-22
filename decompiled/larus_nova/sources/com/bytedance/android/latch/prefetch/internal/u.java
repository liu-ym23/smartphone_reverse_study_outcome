package com.bytedance.android.latch.prefetch.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class u extends f0<String> implements f0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58493b;

    @Override // com.bytedance.android.latch.prefetch.internal.f0.a
    public final String getDataType() {
        return this.f58493b;
    }

    public u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter("string", "dataType");
        super(r100);
        this.f58493b = "string";
    }
}
