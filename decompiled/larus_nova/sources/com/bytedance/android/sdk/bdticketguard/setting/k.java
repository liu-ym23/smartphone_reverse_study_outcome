package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class k<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f163993a;

    @Override // com.bytedance.android.sdk.bdticketguard.setting.d
    public final T a() {
        return this.f163993a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function0<? extends T> r100) {
        this.f163993a = r100;
    }
}
