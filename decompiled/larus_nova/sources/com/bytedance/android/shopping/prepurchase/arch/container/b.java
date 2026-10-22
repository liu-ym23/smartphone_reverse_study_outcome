package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.i;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.m;
import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b<STATE extends h, STORE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.intf.h f180729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xi.b f180730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f180731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public pg3.c<STATE, STORE> f180732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.intf.f f180733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final og3.c f180734f;

    public final f<STATE, STORE> a() {
        boolean r100 = false;
        if (this.f180729a == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f180729a = new com.bytedance.android.shopping.prepurchase.arch.container.intf.d();
    L9:
        if (this.f180730b == null) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        Biz r103 = this.f180734f.f523189a;
        this.f180730b = new m(r103, new com.bytedance.android.shopping.prepurchase.arch.container.intf.c(r103));
    L15:
        if (this.f180731c == null) goto L17;
        r100 = true;
    L17:
        if (r100 == true) goto L20;
        this.f180731c = new com.bytedance.android.shopping.prepurchase.arch.container.intf.e();
    L20:
        return new f(this);
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public b(og3.c r100) {
        Intrinsics.checkNotNullParameter(r100, "pageInfo");
        this.f180734f = r100;
    }
}
