package com.bytedance.android.ec.hybrid.list.ability;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<q> f46999a;

    public r() {
        this.f46999a = new LinkedHashSet();
    }

    public final void a(q... r100) {
        Intrinsics.checkNotNullParameter(r100, "processors");
        CollectionsKt.addAll(this.f46999a, r100);
    }

    public final void b(BaseViewHolder r100, ECHybridListItemVO r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Iterator<T> r103 = this.f46999a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((q) r103.next()).a(r100, r101);
        goto L4
    }
}
