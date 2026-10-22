package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f70447a = null;

    static {
        f70447a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("LinkSpeechServerRecognizer", "room_song_changed api error");
    }
}
