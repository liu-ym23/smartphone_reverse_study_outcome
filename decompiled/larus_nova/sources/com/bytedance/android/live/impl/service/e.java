package com.bytedance.android.live.impl.service;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.common.utility.concurrent.TTExecutors;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f69295a = null;

    static {
        f69295a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TTExecutors.getNormalExecutor().submit(new d((UserEvent) r100));
    }
}
