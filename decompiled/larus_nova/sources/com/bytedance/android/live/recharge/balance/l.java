package com.bytedance.android.live.recharge.balance;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f89665a;

    public l(f r100) {
        this.f89665a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Iterator<T> r102 = CollectionsKt.toList(g.f89660a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((g.a) r102.next()).e(this.f89665a, r101);
        goto L4
    }
}
