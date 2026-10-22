package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f84479a;

    public f(Function1 r100) {
        this.f84479a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = qo0.a.f534145a;
        qo0.a.b("MemoryContextService", "fetch preset data fail, error: " + r101, null);
        this.f84479a.invoke(r101);
    }
}
