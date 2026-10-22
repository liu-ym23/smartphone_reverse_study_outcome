package com.bytedance.android.ec.hybrid.popup;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47600b;

    @Override // com.bytedance.android.ec.hybrid.popup.h
    public final String getName() {
        return this.f47599a;
    }

    @Override // com.bytedance.android.ec.hybrid.popup.h
    public final int getStrategy() {
        return this.f47600b;
    }

    public m(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f47599a = r100;
        this.f47600b = r101;
    }
}
