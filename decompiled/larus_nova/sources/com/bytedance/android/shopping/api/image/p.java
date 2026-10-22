package com.bytedance.android.shopping.api.image;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class p implements q, o, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f170199a;

    @Override // com.bytedance.android.shopping.api.image.s
    public final int a() {
        return this.f170199a.a();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String c() {
        return this.f170199a.c();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final int e() {
        return this.f170199a.e();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final boolean f(String r100, String r101) {
        return this.f170199a.f(r100, r101);
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getDomain() {
        return this.f170199a.getDomain();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getFlag() {
        return this.f170199a.getFlag();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getImageUri() {
        return this.f170199a.getImageUri();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final u getQuery() {
        return this.f170199a.getQuery();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getServiceId() {
        return this.f170199a.getServiceId();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final Pair<Integer, Integer> h() {
        return this.f170199a.h();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final boolean isHierarchical() {
        return this.f170199a.isHierarchical();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final boolean j() {
        return this.f170199a.j();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String l() {
        return this.f170199a.l();
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final t n() {
        return this.f170199a.n();
    }

    public abstract void o(String r100);

    public p(r r100) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
        this.f170199a = r100;
    }
}
