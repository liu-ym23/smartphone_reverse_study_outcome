package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f60740a = null;

    static {
        f60740a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.d("OpenPlatformPerfReporter", "/data/upload/ error: " + ((Throwable) r100).getMessage());
    }
}
