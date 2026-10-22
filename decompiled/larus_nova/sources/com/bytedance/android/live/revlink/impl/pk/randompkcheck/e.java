package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f96766a = null;

    static {
        f96766a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        jy0.b.c("random_pk_check_fragment", "on confirm autocheck error", null, 4);
    }
}
