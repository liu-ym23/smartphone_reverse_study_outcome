package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class EventProcessorDispatch<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<T>> f95197a;

    /* JADX WARN: Multi-variable type inference failed */
    public EventProcessorDispatch(List<? extends a<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "processorList");
        this.f95197a = r100;
    }

    public final void a(T r100) {
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = r100;
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = false;
        Iterator<T> r103 = this.f95197a.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        ((a) r103.next()).a(r101.element, new EventProcessorDispatch$dispatch$$inlined$forEach$lambda$1(r101, r102), new EventProcessorDispatch$dispatch$$inlined$forEach$lambda$2(r101, r102));
        if (r102.element == false) goto L4;
        return;
    }
}
