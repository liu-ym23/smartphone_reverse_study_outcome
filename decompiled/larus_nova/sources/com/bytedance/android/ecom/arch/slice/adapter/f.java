package com.bytedance.android.ecom.arch.slice.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f50013a;

    public f() {
        this.f50013a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.c
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Iterator<T> r101 = this.f50013a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).onViewRecycled(r100);
        goto L4
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.c
    public final void a(RecyclerView.ViewHolder r100, b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Iterator<T> r103 = this.f50013a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).a(r100, r101, r102);
        goto L4
    }
}
