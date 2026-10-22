package com.bytedance.apm6.consumer.slardar.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: HeaderStoreManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f5076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f5077b;

    /* JADX INFO: compiled from: HeaderStoreManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5079a = null;

        static /* synthetic */ c a() {
            return f5079a;
        }

        static {
            f5079a = new c();
        }
    }

    public c() {
    }

    public static c a() {
        return a.a();
    }

    void a(String r3, com.bytedance.apm6.consumer.slardar.b.a r4) {
        c();
        if (this.f5077b != null) goto L5;
        return;
    L5:
        JSONObject r5 = d.a(r4);
        if (r5 != null) goto L8;
        return;
    L8:
        File r0 = new File(this.f5077b, b(r3));
        FileChannel r2 = null;
        r2 = new FileOutputStream(r0).getChannel();     // Catch: Throwable -> L11
        r2.write(ByteBuffer.wrap(r5.toString().getBytes()));     // Catch: Throwable -> L11
    L10:
        com.bytedance.apm6.util.d.a(r2);
        return;
    L11:
        th = move-exception;
        a("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.bytedance.apm6.util.d.a(r2);
        throw th;
    }

    com.bytedance.apm6.consumer.slardar.b.a a(String r4) {
        c();
        if (this.f5077b != null) goto L5;
        return null;
    L5:
        byte[] r3 = com.bytedance.apm6.util.c.a(new File(this.f5077b, b(r4)));
        if (r3 != null) goto L8;
        return null;
    L8:
        return d.a(r3);
    }

    private String b(String r1) {
        return r1 + ".bin";
    }

    void b() {
        c();
        File r0 = this.f5077b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.listFiles(new AnonymousClass1(this));
    }

    private synchronized void c() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f5076a == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        File r0 = new File(com.bytedance.apm6.consumer.slardar.b.b(), "header");     // Catch: Throwable -> L11
        this.f5077b = r0;     // Catch: Throwable -> L11
        if (r0.exists() == true) goto L13;
        this.f5077b.mkdirs();     // Catch: Throwable -> L11
    L13:
        this.f5076a = true;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        com.bytedance.apm6.util.c.b.d("APM", "header store init error " + th.toString());     // Catch: Throwable -> L16
        goto L13
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
