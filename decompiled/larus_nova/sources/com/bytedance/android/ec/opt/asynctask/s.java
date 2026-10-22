package com.bytedance.android.ec.opt.asynctask;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class s implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f48054a;

    @Override // com.bytedance.android.ec.opt.asynctask.i
    public s a() {
        return this;
    }

    @Override // com.bytedance.android.ec.opt.asynctask.i
    public final i parent() {
        return this.f48054a;
    }

    public s(i r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f48054a = r100;
    }
}
