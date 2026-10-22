package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f60736a;

    public e(Function1 r100) {
        this.f60736a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.d("OpenPlatformPerfReporter", "/task/finish/ error: " + ((Throwable) r100).getMessage());
        this.f60736a.invoke(1);
    }
}
