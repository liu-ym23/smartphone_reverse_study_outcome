package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f184176a = null;

    static {
        f184176a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        EnsureManager.ensureNotReachHere((Throwable) r100, "collapseHeaderIfNeed error");
    }
}
