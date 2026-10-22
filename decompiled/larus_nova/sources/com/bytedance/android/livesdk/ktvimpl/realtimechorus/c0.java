package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f146517a = null;

    static {
        f146517a = new c0();
    }

    public c0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("RealTimeChorusMainViewWidget", "waitingUserMergeDataListObservable, size: " + ((ch0.m) r100).f23754a);
    }
}
