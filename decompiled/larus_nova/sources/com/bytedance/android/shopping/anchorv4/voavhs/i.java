package com.bytedance.android.shopping.anchorv4.voavhs;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
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
public final class i implements com.bytedance.android.ecom.arch.slice.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, Function0<List<com.bytedance.android.ecom.arch.slice.g>>> f169916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f169917b;

    @Override // com.bytedance.android.ecom.arch.slice.d
    public final List<com.bytedance.android.ecom.arch.slice.g> F() {
        Collection<Function0<List<com.bytedance.android.ecom.arch.slice.g>>> r100 = this.f169916a.values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        CollectionsKt.addAll(r101, (List) ((Function0) r102.next()).invoke());
        goto L4
    L7:
        if (r101.isEmpty() == false) goto L12;
        com.bytedance.android.ecom.arch.slice.adapter.d r103 = a();
        if (r103 != null) goto L20;
        return null;
    L20:
        return r103.Z1();
    L12:
        com.bytedance.android.ecom.arch.slice.adapter.d r104 = a();
        if (r104 == null) goto L16;
        List<com.bytedance.android.ecom.arch.slice.g> r105 = r104.Z1();
        if (r105 == null) goto L16;
    L17:
        ArrayList r106 = new ArrayList(r101.size() + r105.size());
        r106.addAll(r101);
        r106.addAll(r105);
        return r106;
    L16:
        r105 = CollectionsKt.emptyList();
        goto L17
    }

    public final com.bytedance.android.ecom.arch.slice.adapter.d a() {
        RecyclerView r100 = this.f169917b;
        Object r101 = null;
        if (r100 == null) goto L5;
        RecyclerView.Adapter r102 = r100.getAdapter();
    L7:
        if ((r102 instanceof com.bytedance.android.ecom.arch.slice.adapter.d) == false) goto L11;
        r101 = r102;
    L11:
        return (com.bytedance.android.ecom.arch.slice.adapter.d) r101;
    L5:
        r102 = null;
        goto L7
    }

    public i(RecyclerView r100) {
        this.f169917b = r100;
        this.f169916a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.ecom.arch.slice.d
    public final void G(String r100, Function0<? extends List<? extends com.bytedance.android.ecom.arch.slice.g>> r101) {
        Intrinsics.checkNotNullParameter(r100, "componentKey");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f169916a.put(r100, r101);
    }

    @Override // com.bytedance.android.ecom.arch.slice.d
    public final boolean m(boolean r100, Function1<? super com.bytedance.android.ecom.arch.slice.g, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "filter");
        com.bytedance.android.ecom.arch.slice.adapter.d r102 = a();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.m(r100, r101) != true) goto L7;
        return true;
    }
}
