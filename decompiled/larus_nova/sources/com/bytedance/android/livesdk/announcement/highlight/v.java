package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f103495a = null;

    static {
        f103495a = new v();
    }

    public v() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f2.c("当前网络不佳，请稍后重试", 0);
        x8.a.c("anchor_highlight", (Throwable) r100, false);
    }
}
