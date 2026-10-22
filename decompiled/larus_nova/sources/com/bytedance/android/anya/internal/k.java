package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class k<OWNER extends BaseMVIDataStore<?>, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<OWNER, T> f41694a;

    public k(n<OWNER, T> r100) {
        this.f41694a = r100;
    }

    public final h a(KProperty r100) {
        n<OWNER, T> r101 = this.f41694a;
        r101.f41697a = r100.getName();
        return new h(r101);
    }
}
