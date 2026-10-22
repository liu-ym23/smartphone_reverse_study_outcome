package com.bytedance.android.live.profit.livepet.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f87862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f87863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f87864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f87865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f87866e;

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getLeft() {
        return this.f87866e.getLeft() + this.f87862a;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final a getRoot() {
        return this.f87866e.getRoot();
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getTop() {
        return this.f87866e.getTop() + this.f87863b;
    }

    public final String toString() {
        return "RectRegion(x=" + this.f87862a + ", y=" + this.f87863b + ", width=" + this.f87864c + ", height=" + this.f87865d + ')';
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getBottom() {
        return getTop() + this.f87865d;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getRight() {
        return getLeft() + this.f87864c;
    }

    public l(a r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f87866e = r100;
    }
}
