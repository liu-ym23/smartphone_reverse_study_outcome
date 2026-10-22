package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f103492a = null;

    static {
        f103492a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f2.c("当前网络不佳，请稍后重试", 0);
        x8.a.c("anchor_highlight", (Throwable) r100, false);
    }
}
