package com.bytedance.android.livesdk.feedback.light;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f124728a = null;

    static {
        f124728a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LiveLightFeedbackWidget", "hide feedback page fail on anim end", (Throwable) r100);
    }
}
