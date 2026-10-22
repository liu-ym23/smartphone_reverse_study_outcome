package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.g0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class n<OWNER extends BaseMVIDataStore<?>, T> implements com.bytedance.android.anya.t<OWNER, T>, ReadOnlyProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f41697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseMVIDataStore<?> f41698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f41699c;

    public final T a() {
        T r100 = (T) ((ConcurrentHashMap) this.f41698b.f41531d).get(this);
        if (this.f41699c == false) goto L11;
        if (Intrinsics.areEqual(r100, g0.f41616a) == true) goto L9;
        if (r100 != null) goto L11;
    L9:
        throw new NullPointerException("value of property [" + this.f41697a + "] is not set.");
    L11:
        if (Intrinsics.areEqual(r100, g0.f41616a) == false) goto L14;
        return null;
    L14:
        return r100;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        BaseMVIDataStore r102 = (BaseMVIDataStore) r100;
        return a();
    }

    public n(BaseMVIDataStore<?> r100, T r101, boolean r102) {
        this.f41698b = r100;
        this.f41699c = r102;
        this.f41697a = "unknown";
        Map<Object, Object> r103 = r100.f41531d;
        if (r101 != null) goto L6;
        r101 = (T) g0.f41616a;
    L6:
        ((ConcurrentHashMap) r103).put(this, r101);
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty r101, Object r102) {
        BaseMVIDataStore r103 = (BaseMVIDataStore) r100;
        Map<Object, Object> r104 = this.f41698b.f41531d;
        if (r102 != null) goto L6;
        r102 = g0.f41616a;
    L6:
        ((ConcurrentHashMap) r104).put(this, r102);
    }
}
