package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f70442a = null;

    static {
        f70442a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LinkSpeechRecognizer", "onStart, interval exception: " + ((Throwable) r100).getMessage());
    }
}
