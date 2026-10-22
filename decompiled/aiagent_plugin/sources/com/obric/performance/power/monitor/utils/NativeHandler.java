package com.obric.performance.power.monitor.utils;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NativeHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NativeHandler {
    private static final String TAG = "NativeHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NativeHandler f37018a = null;

    public final native void setDebugger(boolean r1);

    private NativeHandler() {
    }

    static {
        f37018a = new NativeHandler();
        EnsureLoad.f37016a.init();
    }

    public static final void getStack() {
        a(TAG, Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException(Thread.currentThread().getName()), Throwable.class, "com.obric.aiagent.plugin")));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
