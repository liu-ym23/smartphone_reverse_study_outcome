package com.bytedance.android.livesdk.monitor.trace;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f153985a;

    public d(Function0 r100) {
        this.f153985a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f153985a.invoke();
        r101.printStackTrace();
        ALogger.e("sendEvents_yzw", "sendByHttp error: " + r101.getMessage());
    }
}
