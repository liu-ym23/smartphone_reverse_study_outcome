package com.bytedance.android.live.core.cache;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class c implements Function {
    public /* synthetic */ c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return Integer.valueOf(r100.hashCode());
    }
}
