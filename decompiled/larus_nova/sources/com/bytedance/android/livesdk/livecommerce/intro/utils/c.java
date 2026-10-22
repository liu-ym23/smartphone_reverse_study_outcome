package com.bytedance.android.livesdk.livecommerce.intro.utils;

import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IntroCardLoadOpt f148520a;

    public c(IntroCardLoadOpt r100) {
        this.f148520a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OptCardUtil.b(null, "handleResponse invoke callback");     // Catch: Throwable -> L6
        IntroCardLoadOpt r100 = this.f148520a;     // Catch: Throwable -> L6
        Function1<? super LiveIntroResponse, Unit> r101 = r100.f148514d;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke(r100.f148511a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
