package com.bytedance.android.sdk.bdticketguard.setting;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f163990a;

    @Override // com.bytedance.android.sdk.bdticketguard.setting.d
    public final T a() {
        return this.f163990a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function0<? extends T> r100) {
        this.f163990a = r100;
    }
}
