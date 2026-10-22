package com.bytedance.android.ec.window.base.dynamicview.common;

import android.view.View;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class h<T> implements Consumer {
    public h(String r100) {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        io.b r101 = (io.b) CollectionsKt.firstOrNull((List) r100);
        if (r101 == null) goto L5;
        WindowDynamicViewCache r102 = WindowDynamicViewCache.f49239g;
        r102.getClass();
        String r103 = r101.f490649a;
        ConcurrentHashMap<String, k<? extends View, ?>> r104 = WindowDynamicViewCache.f49235c;
        if (r104 == null) goto L16;
        if (r104.containsKey(r103) == true) goto L19;
        r102.d(CollectionsKt.listOf(new nq3.a(r101.f490649a, r101.f490651c, r101.f490650b)));
        return;
    L19:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L5:
        if (c.f49250a == false) goto L17;
        return;
    }
}
