package com.bytedance.android.livesdk.feedback.light;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f124734a = null;

    static {
        f124734a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LiveLightFeedbackWidget", "show feedback page fail on anim start", (Throwable) r100);
    }
}
