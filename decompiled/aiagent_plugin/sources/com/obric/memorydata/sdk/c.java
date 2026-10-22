package com.obric.memorydata.sdk;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "MemoryDataSdk";

    public static final <T> T a(d.h.a.a<? extends T> r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "block");
        return (T) r3.invoke();
    L5:
        th = move-exception;
        a(TAG, "runSafely error", th);
        return null;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
