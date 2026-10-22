package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f83877a = null;

    static {
        f83877a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        RxUtil.getNoOpThrowable();
    }
}
