package com.bytedance.android.livesdk.live.listprovider;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f147560a = null;

    static {
        f147560a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
