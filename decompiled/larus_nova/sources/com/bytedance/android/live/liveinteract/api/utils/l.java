package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public class l implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f71523a = null;

    public l() {
    }

    static {
        f71523a = new l();
    }

    public void a(Throwable r100) throws Exception {
        if (r100 == null) goto L5;
        ALogger.stacktrace(6, "RxErrorConsumer", r100.getStackTrace());
        return;
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Throwable r100) throws Exception {
        a(r100);
    }
}
