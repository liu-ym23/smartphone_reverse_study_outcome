package com.bytedance.android.shopping.sku.inner.tracker;

import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f182979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<a> f182980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<a, Unit> f182981c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f182981c = r100;
        this.f182980b = new ArrayDeque();
    }
}
