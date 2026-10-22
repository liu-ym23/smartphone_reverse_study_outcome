package com.bytedance.android.live.profit.livepet.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f87857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f87858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f87859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f87860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f87861e;

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getBottom() {
        return this.f87861e.getBottom() - this.f87860d;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getLeft() {
        return this.f87861e.getLeft() + this.f87857a;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getRight() {
        return this.f87861e.getRight() - this.f87859c;
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final a getRoot() {
        return this.f87861e.getRoot();
    }

    @Override // com.bytedance.android.live.profit.livepet.container.a
    public final int getTop() {
        return this.f87861e.getTop() + this.f87858b;
    }

    public final String toString() {
        return "MarginRegion(leftMargin=" + this.f87857a + ", topMargin=" + this.f87858b + ", rightMargin=" + this.f87859c + ", bottomMargin=" + this.f87860d + ')';
    }

    public k(n r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f87861e = r100;
    }
}
