package com.bytedance.android.livesdk.popup.manager;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f156308a = null;

    static {
        f156308a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        om0.c.c();
        ALogger.e("LivePopupWindowManager", "error: " + ((Throwable) r100).getMessage());
    }
}
