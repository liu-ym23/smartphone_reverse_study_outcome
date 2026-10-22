package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.i;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f<STATE extends h, STORE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final og3.c f180775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.b f180776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.h f180777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f180778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pg3.c<STATE, STORE> f180779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.f f180780f;

    public f(b<STATE, STORE> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f180775a = r100.f180734f;
        xi.b r101 = r100.f180730b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("logService");
    L5:
        this.f180776b = r101;
        com.bytedance.android.shopping.prepurchase.arch.container.intf.h r102 = r100.f180729a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("eventTrackerService");
    L8:
        this.f180777c = r102;
        i r103 = r100.f180731c;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("monitorService");
    L11:
        this.f180778d = r103;
        pg3.c<STATE, STORE> r104 = r100.f180732d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startFlowFactory");
    L14:
        this.f180779e = r104;
        com.bytedance.android.shopping.prepurchase.arch.container.intf.f r105 = r100.f180733e;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
    L17:
        this.f180780f = r105;
    }
}
