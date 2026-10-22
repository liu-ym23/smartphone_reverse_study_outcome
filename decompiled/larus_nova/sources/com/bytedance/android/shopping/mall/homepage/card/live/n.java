package com.bytedance.android.shopping.mall.homepage.card.live;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f178005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f178006b;

    public n() {
        this.f178005a = new CopyOnWriteArrayList();
        this.f178006b = new CopyOnWriteArrayList();
    }

    public final void a(boolean r100) {
        Iterator<T> r101 = this.f178005a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).j(r100);
        goto L4
    }
}
