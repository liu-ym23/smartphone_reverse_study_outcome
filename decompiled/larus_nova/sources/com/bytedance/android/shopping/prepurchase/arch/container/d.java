package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.ContainerTrackAbility;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.i;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.k;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.n;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.p;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.j;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d<STATE extends h, STORE> implements c<STATE, STORE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j<STORE> f180767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f180768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.ability.f f180769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final og3.b<STATE> f180770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f180771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.ability.j f180772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f180773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.b f180774h;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final l b() {
        l r100 = this.f180768b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("prefAbility");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final j<STORE> d() {
        j<STORE> r100 = this.f180767a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentFetchAbility");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final com.bytedance.android.shopping.prepurchase.arch.container.ability.f e() {
        com.bytedance.android.shopping.prepurchase.arch.container.ability.f r100 = this.f180769c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sliceYataAbility");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final i a() {
        return this.f180771e;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final k c() {
        return this.f180773g;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final og3.b<STATE> f() {
        return this.f180770d;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.b getContainerAbility() {
        return this.f180774h;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.c
    public final com.bytedance.android.shopping.prepurchase.arch.container.ability.j w7() {
        return this.f180772f;
    }

    public d(og3.b r100, ContainerTrackAbility r101, n r102, p r103, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r104) {
        Intrinsics.checkNotNullParameter(r100, "globalStateStore");
        Intrinsics.checkNotNullParameter(r101, "trackAbility");
        Intrinsics.checkNotNullParameter(r102, "logAbility");
        Intrinsics.checkNotNullParameter(r103, "monitorAbility");
        Intrinsics.checkNotNullParameter(r104, "dependencies");
        this.f180770d = r100;
        this.f180771e = r101;
        this.f180772f = r102;
        this.f180773g = r103;
        this.f180774h = r104;
    }
}
