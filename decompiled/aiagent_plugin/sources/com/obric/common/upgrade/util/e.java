package com.obric.common.upgrade.util;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.w;
import okhttp3.z;

/* JADX INFO: compiled from: OkHttpUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f32653a = null;

    static {
        f32653a = new e();
    }

    public static /* synthetic */ ad lambda$GwXfXx0YI_D4o_iXdLukb3Jtve8(w.a r0) {
        return a(r0);
    }

    private e() {
    }

    public final z a() {
        z r3 = new z.a().a(60, TimeUnit.SECONDS).b(300, TimeUnit.SECONDS).c(300, TimeUnit.SECONDS).a(true).a($$Lambda$e$GwXfXx0YI_D4o_iXdLukb3Jtve8.INSTANCE).E();
        o.c(r3, "Builder()\n            .c…  })\n            .build()");
        return r3;
    }

    private static final ad a(w.a r8) {
        w.a r9 = (w.a) ZeusTransformUtils.wrapperContextForParams(r8, w.a.class, "com.obric.aiagent.plugin");
        ab r0 = r9.a();
        String r2 = r0.a().toString();
        o.c(r2, "httpUrl.toString()");
        long r3 = SystemClock.elapsedRealtime();
        c.f32650a.b("Sending request " + r2);
        ad r10 = r9.a(r0);     // Catch: IOException -> L6
        c r1 = c.f32650a;
        d.h.b.ad r4 = d.h.b.ad.f38485a;
        String r5 = String.format("Received response for %s in %dms", Arrays.copyOf(new Object[]{r2, Long.valueOf(SystemClock.elapsedRealtime() - r3)}, 2));
        o.c(r5, "format(format, *args)");
        r1.b(r5);
        return r10;
    L6:
        e = move-exception;
        c.f32650a.c("Sending request " + r2);
        throw new IOException("proceed failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
