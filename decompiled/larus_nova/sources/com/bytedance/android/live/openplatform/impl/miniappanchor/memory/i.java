package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f84486a = null;

    static {
        f84486a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = qo0.a.f534145a;
        qo0.a.b("MemoryContextService", "upgrade fail, error: " + ((Throwable) r100), null);
    }
}
