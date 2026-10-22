package com.bytedance.android.ec.hybrid.popup;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f47613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f47615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f47616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f47617e;

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final boolean a() {
        return this.f47615c;
    }

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final h getGroup() {
        return this.f47613a;
    }

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final int getPriority() {
        return this.f47614b;
    }

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final int getZIndex() {
        return this.f47616d;
    }

    public o(m r100, int r101, boolean r102, int r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r104, "limitDesc");
        this.f47613a = r100;
        this.f47614b = r101;
        this.f47615c = r102;
        this.f47616d = r103;
        this.f47617e = r105;
    }
}
