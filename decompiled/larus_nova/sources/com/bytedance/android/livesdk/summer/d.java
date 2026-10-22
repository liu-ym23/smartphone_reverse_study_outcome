package com.bytedance.android.livesdk.summer;

import android.os.Handler;
import com.bytedance.android.livesdk.config.ms;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f158449a = null;

    static {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("AccelerateWorkThread");
        ThreadMethodProxy.start(r100);
        f158449a = new Handler(r100.getLooper());
    }

    public static void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (ms.f120779a.getValue().booleanValue() == false) goto L6;
        r100.getClass();
        f158449a.post(r100);
        return;
    }
}
