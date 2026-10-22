package com.obric.aiagent.executionengine.utils;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: HandlerUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SoftReference<Handler> f18565b;

    static {
        f18564a = new a();
    }

    private a() {
    }

    public final Handler a() {
        SoftReference<Handler> r2 = f18565b;
        if (r2 == null) goto L7;
        o.a(r2);
        Handler r3 = (Handler) ZeusTransformUtils.preCheckCast(r2.get(), Handler.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return r3;
    L7:
        Handler r4 = new Handler(Looper.getMainLooper());
        f18565b = new SoftReference(r4);
        return r4;
    }
}
