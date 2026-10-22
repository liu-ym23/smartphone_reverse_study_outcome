package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class h<OWNER extends BaseMVIDataStore<?>, P> implements ReadOnlyProperty<OWNER, P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P f41692a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(n r100) {
        this.f41692a = r100;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        BaseMVIDataStore r102 = (BaseMVIDataStore) r100;
        return this.f41692a;
    }
}
