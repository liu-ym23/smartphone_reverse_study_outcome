package com.bytedance.android.livesdk.feedback.condition.observer;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f124646a = null;

    static {
        f124646a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LiveRoomFeedbackConditionObserver getLiveRoomFeedbackCard failed", (Throwable) r100);
    }
}
