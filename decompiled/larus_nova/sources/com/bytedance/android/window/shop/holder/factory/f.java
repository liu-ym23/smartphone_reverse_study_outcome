package com.bytedance.android.window.shop.holder.factory;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.ability.n0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f187957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f187958b;

    @Override // com.bytedance.android.ec.hybrid.list.ability.n0
    public final Object a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = u0.b(r100, this.f187957a);
        if (r101 != null) goto L9;
        return null;
    L9:
        return this.f187958b.invoke(r101);
    }

    public f(Class r100, Function1 r101) {
        this.f187957a = r100;
        this.f187958b = r101;
    }
}
