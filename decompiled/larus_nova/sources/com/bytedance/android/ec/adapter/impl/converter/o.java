package com.bytedance.android.ec.adapter.impl.converter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class o<Source, Target> extends a<Source, Target> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Target f42791b;

    public o() {
    }

    @Override // com.bytedance.android.ec.adapter.impl.converter.a
    public final Target a(Source r100) {
        if (this.f42791b != null) goto L5;
        this.f42791b = c(r100);
    L5:
        Target r101 = this.f42791b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("singleTon");
    L8:
        return r101;
    }
}
