package com.bytedance.android.livesdk.bgService;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f104318a;

    public g(h r100) {
        this.f104318a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f104318a.f104319a;
        ALogger.e(r101, "LiveMediaSessionNotification### notification check error", (Throwable) r100);
    }
}
