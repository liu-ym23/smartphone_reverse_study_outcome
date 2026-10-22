package com.bytedance.android.live.profit.livepet.container;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f87867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f87868b;

    public n() {
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getLeft() {
        return 0;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final a getRoot() {
        return this;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getTop() {
        return 0;
    }

    public final String toString() {
        return "RootRegion(width=" + this.f87867a + ", height=" + this.f87868b + ')';
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getBottom() {
        return this.f87868b;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getRight() {
        return this.f87867a;
    }
}
