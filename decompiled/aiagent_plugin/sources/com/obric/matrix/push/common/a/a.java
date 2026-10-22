package com.obric.matrix.push.common.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AndroidLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.obric.matrix.push.common.a.b
    public void a(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        b(r1, r2);
    }

    @Override // com.obric.matrix.push.common.a.b
    public void c(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        d(r1, r2);
    }

    @Override // com.obric.matrix.push.common.a.b
    public void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        b(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
