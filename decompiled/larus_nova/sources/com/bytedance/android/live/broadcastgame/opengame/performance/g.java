package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f60738a;

    public g(Function0 r100) {
        this.f60738a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f60738a.invoke();
        if ((r101 instanceof CustomApiServerException) == false) goto L5;
        f2.c(((CustomApiServerException) r101).getPrompt(), 0);
    L6:
        ALogger.d("OpenPlatformPerfReporter", "/task/run/ error " + r101.getMessage());
        return;
    L5:
        f2.c("启动性能上报失败，请重新开启性能测试！", 0);
        goto L6
    }
}
