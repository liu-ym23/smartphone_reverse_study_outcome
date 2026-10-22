package com.bytedance.android.shopping.yata.business.function;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class f<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f187583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f187584b;

    public f(e r100, Ref.ObjectRef r101) {
        this.f187583a = r100;
        this.f187584b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) this.f187583a.f187582a.d().a(((com.bytedance.kmp.ec.yata.store.node.c) r101).s(), ((String) this.f187584b.element) + ".validate_priority", null), (Integer) this.f187583a.f187582a.d().a(((com.bytedance.kmp.ec.yata.store.node.c) r100).s(), ((String) this.f187584b.element) + ".validate_priority", null));
    }
}
