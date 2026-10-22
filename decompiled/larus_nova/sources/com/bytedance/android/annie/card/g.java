package com.bytedance.android.annie.card;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements y6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y6.e f39145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<WeakReference<f>> f39146b;

    @Override // y6.d
    public final void fZ() {
        Iterator<T> r100 = this.f39146b.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        f r101 = (f) ((WeakReference) r100.next()).get();
        if (r101 == null) goto L4;
        r101.onRefresh();
        goto L4
    }

    public g() {
        this.f39146b = new ArrayList();
    }

    @Override // y6.d
    public final y6.e w1() {
        return this.f39145a;
    }

    @Override // y6.d
    public final void DY(y6.e r100) {
        this.f39145a = r100;
        Iterator r101 = ((ArrayList) this.f39146b).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        f r102 = (f) ((WeakReference) r101.next()).get();
        if (r102 == null) goto L4;
        r102.onInjectShareInfo(r100);
        goto L4
    }

    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<WeakReference<f>> r101 = this.f39146b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new WeakReference(r100));
    }
}
