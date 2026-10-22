package com.obric.agent.utils;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: HandlerUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f16060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SoftReference<Handler> f16061b;

    static {
        f16060a = new q();
    }

    private q() {
    }

    public final Handler a() {
        SoftReference<Handler> r2 = f16061b;
        if (r2 == null) goto L7;
        d.h.b.o.a(r2);
        Handler r3 = (Handler) ZeusTransformUtils.preCheckCast(r2.get(), Handler.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return r3;
    L7:
        Handler r4 = new Handler(Looper.getMainLooper());
        f16061b = new SoftReference(r4);
        return r4;
    }

    public final void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "action");
        a().post(r4);
    }
}
