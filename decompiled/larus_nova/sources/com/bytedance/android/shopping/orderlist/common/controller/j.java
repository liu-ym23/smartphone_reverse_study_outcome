package com.bytedance.android.shopping.orderlist.common.controller;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class j<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f179732a;

    public j(Function1 r100) {
        this.f179732a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Comparable) this.f179732a.invoke(r100), (Comparable) this.f179732a.invoke(r101));
    }
}
