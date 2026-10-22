package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f84474a = null;

    static {
        f84474a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.b("MemoryContextService", "updateMemoryAbilityStatus fail", (Throwable) r100);
    }
}
