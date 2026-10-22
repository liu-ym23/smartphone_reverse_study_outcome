package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.ability.n0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f185001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f185002b;

    @Override // com.bytedance.android.ec.hybrid.list.ability.n0
    public final Object a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r100.getClass(), this.f185001a) == true) goto L8;
        Object r101 = u0.b(r100, this.f185001a);
        if (r101 != null) goto L13;
        return null;
    L13:
        return this.f185002b.invoke(r101, r100);
    L8:
        return this.f185002b.invoke(r100, r100);
    }

    public c(Class r100, Function2 r101) {
        this.f185001a = r100;
        this.f185002b = r101;
    }
}
