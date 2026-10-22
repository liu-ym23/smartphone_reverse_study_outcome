package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f152691a = null;

    static {
        f152691a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f.a().b("query pop error, " + ((Throwable) r100).getMessage(), null);
    }
}
