package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public final class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25018a;

    public h(Context r100) {
        this.f25018a = r100;
    }

    public static /* synthetic */ Context a(h r100) {
        return r100.f25018a;
    }

    @Override // com.alipay.android.phone.mrpc.core.w
    public final <T> T a(Class<T> r100, aa r101) {
        return (T) new x(new i(this, r101)).a(r100);
    }
}
