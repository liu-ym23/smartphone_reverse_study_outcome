package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f139562a;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void clear() {
        ((ArrayDeque) this.f139562a).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final int size() {
        return ((ArrayDeque) this.f139562a).size();
    }

    public c() {
        this.f139562a = new ArrayDeque();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> a(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Iterator r101 = ((ArrayDeque) this.f139562a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (r100.invoke(r102).booleanValue() == false) goto L4;
    L10:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) r102;
    L8:
        r102 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        return com.bytedance.android.livesdk.interactivity.common.utils.k.c(this.f139562a, r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> e(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        return com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.f139562a, r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> c(k r100, boolean r101) {
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.f139562a).poll();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void d(int r100, com.bytedance.android.livesdk.interactivity.api.entity.f<?> r101, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        com.bytedance.android.livesdk.interactivity.common.utils.k.a(this.f139562a, r100, r101, r102);
    }
}
