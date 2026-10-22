package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f84473a;

    public c(Function0 r100) {
        this.f84473a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        int r102 = qo0.a.f534145a;
        qo0.a.c("MemoryContextService", "updateMemoryAbilityStatus success, result: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.j) r101.data).a());
        if (((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.j) r101.data).a() == false) goto L6;
        this.f84473a.invoke();
        return;
    }
}
