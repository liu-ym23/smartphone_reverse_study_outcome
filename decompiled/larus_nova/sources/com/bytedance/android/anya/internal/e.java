package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes43.dex */
public final class e<STATE extends MVIState<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<BaseMVIDataStore<?>> f41686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, com.bytedance.android.anya.j<?>> f41687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0<STATE> f41688c;

    public final void a(com.bytedance.android.anya.t r100) {
        Set<BaseMVIDataStore<?>> r101 = this.f41686a;
        if (r100 == null) goto L10;
        n r102 = (n) r100;
        if (r101.contains(r102.f41698b) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Selecting property " + r100 + " is not permitted: owner " + r102.f41698b + " is not in dataStores " + this.f41686a).toString());
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIDataPropertyImpl<*, *>");
    }

    public final com.bytedance.android.anya.j b(com.bytedance.android.anya.t r100) {
        if (r100 == null) goto L12;
        n r101 = (n) r100;
        com.bytedance.android.anya.j<?> r102 = this.f41687b.get(r100);
        if ((r102 instanceof com.bytedance.android.anya.j) == true) goto L6;
        r102 = null;
    L6:
        com.bytedance.android.anya.j<?> r103 = r102;
        if (r103 == null) goto L10;
        return r103;
    L10:
        return new com.bytedance.android.anya.j(null, r101.a(), false);
    L12:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIDataPropertyImpl<DATA_STORE, T>");
    }

    public final void e(com.bytedance.android.anya.t r100, Function2 r101) {
        Map<Object, com.bytedance.android.anya.j<?>> r102 = this.f41687b;
        a(r100);
        if (r102.containsKey(r100) == false) goto L6;
        r101.invoke(this.f41688c, b(r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Set<? extends BaseMVIDataStore<?>> r100, Map<Object, ? extends com.bytedance.android.anya.j<?>> r101, l0<STATE> r102) {
        this.f41686a = r100;
        this.f41687b = r101;
        this.f41688c = r102;
    }

    public final void d(com.bytedance.android.anya.t r100, com.bytedance.android.anya.t r101, Function3 r102) {
        Map<Object, com.bytedance.android.anya.j<?>> r103 = this.f41687b;
        a(r100);
        if (r103.containsKey(r100) == true) goto L6;
        Map<Object, com.bytedance.android.anya.j<?>> r104 = this.f41687b;
        a(r101);
        if (r104.containsKey(r101) == true) goto L6;
        return;
    L6:
        r102.invoke(this.f41688c, b(r100), b(r101));
    }

    public final void c(com.bytedance.android.anya.t r100, com.bytedance.android.anya.t r101, com.bytedance.android.anya.t r102, Function4 r103) {
        Map<Object, com.bytedance.android.anya.j<?>> r104 = this.f41687b;
        a(r100);
        if (r104.containsKey(r100) == true) goto L8;
        Map<Object, com.bytedance.android.anya.j<?>> r105 = this.f41687b;
        a(r101);
        if (r105.containsKey(r101) == true) goto L8;
        Map<Object, com.bytedance.android.anya.j<?>> r106 = this.f41687b;
        a(r102);
        if (r106.containsKey(r102) == true) goto L8;
        return;
    L8:
        r103.invoke(this.f41688c, b(r100), b(r101), b(r102));
    }
}
