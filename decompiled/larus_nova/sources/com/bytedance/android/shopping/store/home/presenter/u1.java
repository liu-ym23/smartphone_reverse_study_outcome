package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class u1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f184418a = null;

    static {
        f184418a = new u1();
    }

    public u1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        EnsureManager.ensureNotReachHere((Throwable) r100, "addPitayaTaskIfNeed error");
    }
}
