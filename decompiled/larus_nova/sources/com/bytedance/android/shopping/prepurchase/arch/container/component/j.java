package com.bytedance.android.shopping.prepurchase.arch.container.component;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public interface j {
    void a(f r100);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void b(T r100);

    void c(f r100);

    j d(String r100, Function0<? extends List<? extends Class<?>>> r101);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> Object e(Class<T> r100, Continuation<? super T> r101);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void f(Class<T> r100, T r101, boolean r102);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T getService(Class<T> r100);
}
