package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class o1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f184258a = null;

    static {
        f184258a = new o1();
    }

    public o1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        EnsureManager.ensureNotReachHere((Throwable) r100, "addPitayaTaskIfNeed error");
    }
}
