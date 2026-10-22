package com.bytedance.reparo.core.i;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import okhttp3.ab;
import okhttp3.z;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f9285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f9286b;

    static {
    }

    private e() {
        this.f9286b = new z.a().a(2, TimeUnit.SECONDS).b(2, TimeUnit.SECONDS).c(2, TimeUnit.SECONDS).E();
    }

    public void a(ab.a r5, String r6, String r7, String r8) {
        String r4 = c();
        String r9 = d.a(r4, r8);
        r5.b("Authorization", "HMAC-SHA256 Credential=" + r7 + ",SignedHeaders=" + ("X-Mars-Date".toLowerCase() + ";") + ",Signature=" + d.a(("X-Mars-Date".toLowerCase() + ":" + r4.replaceAll("\\s", "") + "\n") + com.bytedance.reparo.core.a.b.a.a(r6), r9));
        r5.b("X-mars-date", r4);
    }

    public static e a() {
        if (f9285a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9285a != null) goto L9;
        f9285a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f9285a;
    }

    public z b() {
        return this.f9286b;
    }

    private String c() {
        SimpleDateFormat r1 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        r1.setTimeZone(TimeZone.getTimeZone("UTC"));
        return r1.format(new Date());
    }
}
