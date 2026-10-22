package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements com.bytedance.android.ecom.arch.slice.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WeakReference<com.bytedance.android.ecom.arch.slice.slices.b<List<com.bytedance.android.ecom.arch.slice.g>>>> f180970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, Function0<List<com.bytedance.android.ecom.arch.slice.g>>> f180971b;

    @Override // com.bytedance.android.ecom.arch.slice.d
    public final boolean m(boolean r100, Function1<? super com.bytedance.android.ecom.arch.slice.g, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "filter");
        return false;
    }

    @Override // com.bytedance.android.ecom.arch.slice.d
    public final List<com.bytedance.android.ecom.arch.slice.g> F() {
        Collection<Function0<List<com.bytedance.android.ecom.arch.slice.g>>> r100 = this.f180971b.values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        CollectionsKt.addAll(r101, (List) ((Function0) r102.next()).invoke());
        goto L4
    L6:
        List<WeakReference<com.bytedance.android.ecom.arch.slice.slices.b<List<com.bytedance.android.ecom.arch.slice.g>>>> r103 = this.f180970a;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L16;
        com.bytedance.android.ecom.arch.slice.slices.b r106 = (com.bytedance.android.ecom.arch.slice.slices.b) ((WeakReference) r105.next()).get();
        if (r106 == null) goto L13;
        List r107 = (List) r106.provide();
        if (r107 == null) goto L13;
    L14:
        CollectionsKt.addAll(r104, r107);
    L13:
        r107 = CollectionsKt.emptyList();
        goto L14
    L16:
        if (r101.isEmpty() == true) goto L24;
        ArrayList r108 = new ArrayList(r101.size() + r104.size());
        r108.addAll(r101);
        r108.addAll(r104);
        return r108;
    L24:
        return r104;
    }

    public m() {
        this.f180970a = new ArrayList();
        this.f180971b = new LinkedHashMap();
    }

    @Override // com.bytedance.android.ecom.arch.slice.d
    public final void G(String r100, Function0<? extends List<? extends com.bytedance.android.ecom.arch.slice.g>> r101) {
        Intrinsics.checkNotNullParameter(r100, "componentKey");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f180971b.put(r100, r101);
    }
}
