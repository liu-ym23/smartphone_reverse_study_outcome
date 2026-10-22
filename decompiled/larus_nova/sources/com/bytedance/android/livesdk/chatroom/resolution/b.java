package com.bytedance.android.livesdk.chatroom.resolution;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f110469a = null;

    static {
        f110469a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.d("audience_resolution", "handlePullStreamUpdate request failed");
        ((Throwable) r100).printStackTrace();
    }
}
