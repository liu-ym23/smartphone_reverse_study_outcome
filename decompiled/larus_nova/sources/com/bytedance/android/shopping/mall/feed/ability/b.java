package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.list.ability.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECHybridDataEngine f176856a;

    @Override // com.bytedance.android.ec.hybrid.list.ability.s
    public final void release() {
    }

    public b(ECHybridDataEngine r100) {
        this.f176856a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.t
    public final String TS(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ECHybridDataEngine r101 = this.f176856a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.m(r100);
    }
}
