package com.bytedance.android.ecom.live.adapter.impl;

import com.bytedance.android.live.base.model.user.UserEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f51175a = null;

    static {
        f51175a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UserEvent r101 = (UserEvent) r100;
        ECSdkAbInitializer.b(false);
    }
}
