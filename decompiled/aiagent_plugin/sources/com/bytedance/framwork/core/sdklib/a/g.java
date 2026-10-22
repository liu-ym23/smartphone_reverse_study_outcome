package com.bytedance.framwork.core.sdklib.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: LogSenderHelper.java */
/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f8625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, b> f8627c;

    /* JADX INFO: compiled from: LogSenderHelper.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f8629a = null;

        static /* synthetic */ g a() {
            return f8629a;
        }

        static {
            f8629a = new g(null);
        }
    }

    /* JADX INFO: compiled from: LogSenderHelper.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f8631b;

        static /* synthetic */ int a(b r0) {
            return r0.f8630a;
        }

        static /* synthetic */ long b(b r2) {
            return r2.f8631b;
        }

        public b(int r1, long r2) {
            this.f8630a = r1;
            this.f8631b = r2;
        }

        void update(int r1, long r2) {
            this.f8630a = r1;
            this.f8631b = r2;
        }

        public static b a(String r5) {
            String[] r0 = r5.split("_");     // Catch: Exception -> L8
            if (r0.length != 2) goto L7;
            return new b(Integer.parseInt(r0[0]), Long.parseLong(r0[1]));
        L7:
            return new b(0, 0);
        L8:
            e = move-exception;
            com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "parseRetryMessage " + r5, e);
            return null;
        }

        public int a() {
            return this.f8630a;
        }

        public String b() {
            return this.f8630a + "_" + this.f8631b;
        }
    }

    /* synthetic */ g(AnonymousClass1 r1) {
        this();
    }

    private g() {
        this.f8627c = new ConcurrentHashMap();
    }

    static g a() {
        return a.a();
    }

    synchronized boolean a(byte[] r7, int r8, long r9) {
        monitor-enter(this);
        c();     // Catch: Throwable -> L24
        if (com.bytedance.framwork.core.sdklib.a.a.f() != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        File r2 = new File(com.bytedance.framwork.core.sdklib.a.a.f(), String.format("%d%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".log"}));     // Catch: Throwable -> L24
        FileChannel r0 = null;
        a(r2, r8, r9);     // Catch: Throwable -> L16
        r0 = new FileOutputStream(r2).getChannel();     // Catch: Throwable -> L16
        r0.write(ByteBuffer.wrap(r7));     // Catch: Throwable -> L16
        if (k.d() == false) goto L13;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "saveFile:" + r2.getName());     // Catch: Throwable -> L16
    L13:
        com.bytedance.apm6.util.d.a(r0);     // Catch: Throwable -> L24
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "saveFile:" + r2.getName(), th);     // Catch: Throwable -> L21
        com.bytedance.apm6.util.d.a(r0);     // Catch: Throwable -> L24
        return false;
    L21:
        th = move-exception;
        com.bytedance.apm6.util.d.a(r0);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    synchronized void a(File r3) {
        monitor-enter(this);
        if (r3 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        c();     // Catch: Throwable -> L9
        com.bytedance.apm6.util.c.c(r3);     // Catch: Throwable -> L9
        this.f8627c.remove(r3.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r0 = this.f8625a.edit();     // Catch: Throwable -> L9
        r0.remove(r3.getName());     // Catch: Throwable -> L9
        r0.commit();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    synchronized File b() {
        monitor-enter(this);
        File r0 = com.bytedance.framwork.core.sdklib.a.a.f();     // Catch: Throwable -> L40
        File r1 = null;
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        String[] r2 = r0.list();     // Catch: Throwable -> L40
        if (r2 != null) goto L11;
    L38:
        monitor-exit(this);
        return null;
    L11:
        if (r2.length == 0) goto L38;
        List r3 = Arrays.asList(r2);     // Catch: Throwable -> L40
        Collections.sort(r3, new AnonymousClass1(this));     // Catch: Throwable -> L40
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L40
        b r5 = null;
    L14:
        if (r4.hasNext() == false) goto L36;
        File r6 = new File(r0, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
        b r7 = b(r6);     // Catch: Throwable -> L40
        if (r7 == null) goto L35;
        if (k.d() == false) goto L23;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "list send file:" + r6.getName() + " " + b.a(r7) + " " + b.b(r7) + " " + System.currentTimeMillis());     // Catch: Throwable -> L40
    L23:
        if (b.a(r7) > d.a().d()) goto L24;
        if (b.a(r7) == 0) goto L35;
        if (b.b(r7) < System.currentTimeMillis()) goto L35;
        if (r5 == null) goto L34;
        if (b.b(r5) <= b.b(r7)) goto L14;
    L34:
        r5 = r7;
        r1 = r6;
        goto L14
    L24:
        a(r6);     // Catch: Throwable -> L40
        com.bytedance.framwork.core.sdklib.a.c.d.c("APM-SDK", "retry count reached top");     // Catch: Throwable -> L40
    L35:
        r1 = r6;
    L36:
        monitor-exit(this);
        return r1;
    L40:
        th = move-exception;
        throw th;
    }

    b b(File r4) {
        b r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        c();
        String r5 = r4.getName();
        if (this.f8627c.containsKey(r5) == false) goto L10;
        return (b) ZeusTransformUtils.preCheckCast(this.f8627c.get(r5), b.class, "com.obric.aiagent.plugin");
    L10:
        if (this.f8625a.contains(r5) == false) goto L16;
        String r1 = this.f8625a.getString(r5, "");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0 = b.a(r1);
    L14:
        if (r0 == null) goto L16;
        this.f8627c.put(r5, r0);
    L16:
        return r0;
    }

    void a(File r4, int r5, long r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        c();
        SharedPreferences.Editor r0 = this.f8625a.edit();
        String r7 = r4.getName();
        if (this.f8627c.containsKey(r7) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f8627c.get(r7), b.class, "com.obric.aiagent.plugin");
    L8:
        r3.update(r5, r6);
        r0.putString(r7, r3.b());
        r0.commit();
        return;
    L7:
        b r1 = new b(r5, r6);
        this.f8627c.put(r7, r1);
        r3 = r1;
        goto L8
    }

    private synchronized void c() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f8626b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f8625a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(k.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("sdk_log_report_message", 0);     // Catch: Throwable -> L10
        this.f8626b = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
