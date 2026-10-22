package com.bytedance.android.ec.opt.asynctask;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o extends s implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f48045c;

    @Override // com.bytedance.android.ec.opt.asynctask.i
    public final String name() {
        return "nonTimeliness";
    }

    @Override // com.bytedance.android.ec.opt.asynctask.s, com.bytedance.android.ec.opt.asynctask.i
    public final s a() {
        if (this.f48044b == false) goto L6;
        return this.f48045c;
    L6:
        return this;
    }

    public o(i r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
        this.f48045c = new n(this);
    }
}
