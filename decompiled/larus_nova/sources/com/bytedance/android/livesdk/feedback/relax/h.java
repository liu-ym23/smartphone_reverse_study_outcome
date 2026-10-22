package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f124800a = null;

    static {
        f124800a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("LiveLightFeedbackWidget", "hide feedback page fail on anim end", (Throwable) r100);
    }
}
