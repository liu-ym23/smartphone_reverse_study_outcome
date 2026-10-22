package com.bytedance.android.gamecp.live_impl.toolbar;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f58002a = null;

    static {
        f58002a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Logger.e("introduce-card", "上传小手柄点击事件 Fail," + ((Throwable) r100));
    }
}
