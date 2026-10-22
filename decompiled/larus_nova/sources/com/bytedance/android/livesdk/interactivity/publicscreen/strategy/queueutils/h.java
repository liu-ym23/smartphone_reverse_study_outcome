package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes9.dex */
public interface h {
    com.bytedance.android.livesdk.interactivity.api.entity.f<?> a(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100);

    List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100);

    com.bytedance.android.livesdk.interactivity.api.entity.f<?> c(k r100, boolean r101);

    void clear();

    void d(int r100, com.bytedance.android.livesdk.interactivity.api.entity.f<?> r101, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r102);

    List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> e(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100);

    int size();
}
