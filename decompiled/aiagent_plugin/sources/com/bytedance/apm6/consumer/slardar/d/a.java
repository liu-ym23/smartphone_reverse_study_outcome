package com.bytedance.apm6.consumer.slardar.d;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DiskFileHelper.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f5110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, b> f5111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5112e;
    private volatile boolean f;
    private ArrayList<String> g;

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskFileHelper.java */
    private static class C0124a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f5114a;

        static /* synthetic */ a a() {
            return f5114a;
        }

        static {
            f5114a = new a(null);
        }
    }

    /* JADX INFO: compiled from: DiskFileHelper.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f5116b;

        static /* synthetic */ int a(b r0) {
            return r0.f5115a;
        }

        static /* synthetic */ long b(b r2) {
            return r2.f5116b;
        }

        public b(int r1, long r2) {
            this.f5115a = r1;
            this.f5116b = r2;
        }

        void update(int r1, long r2) {
            this.f5115a = r1;
            this.f5116b = r2;
        }

        public static b a(String r4) {
            String[] r5 = r4.split("_");     // Catch: Exception -> L4
            return new b(Integer.parseInt(r5[0]), Long.parseLong(r5[1]));
        L4:
            return null;
        }

        public int a() {
            return this.f5115a;
        }

        public String b() {
            return this.f5115a + "_" + this.f5116b;
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    private a() {
        this.f5111d = new ConcurrentHashMap();
        this.f5112e = 0;
        this.f = false;
        this.g = new ArrayList();
    }

    static a a() {
        return C0124a.a();
    }

    synchronized boolean a(byte[] r7, String r8, int r9, long r10) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L27
        if (this.f5110c != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        String r11 = String.format("%d%s%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".", r8});     // Catch: Throwable -> L27
        File r0 = new File(this.f5110c, r11);     // Catch: Throwable -> L27
        FileChannel r2 = null;
        a(r0, r9, r10);     // Catch: Throwable -> L19
        r2 = new FileOutputStream(r0).getChannel();     // Catch: Throwable -> L19
        r2.write(ByteBuffer.wrap(r7));     // Catch: Throwable -> L19
        if (this.g.contains(r11) == true) goto L14;
        b(r11);     // Catch: Throwable -> L19
    L14:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L16;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "saveFile:" + r0.getName());     // Catch: Throwable -> L19
    L16:
        com.bytedance.apm6.util.d.a(r2);     // Catch: Throwable -> L27
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "saveFile", th);     // Catch: Throwable -> L24
        com.bytedance.apm6.util.d.a(r2);     // Catch: Throwable -> L27
        return false;
    L24:
        th = move-exception;
        com.bytedance.apm6.util.d.a(r2);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    synchronized void a(File r3) {
        monitor-enter(this);
        if (r3 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.g.remove(r3.getName());     // Catch: Throwable -> L9
        d();     // Catch: Throwable -> L9
        com.bytedance.apm6.util.c.c(r3);     // Catch: Throwable -> L9
        this.f5111d.remove(r3.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r0 = this.f5108a.edit();     // Catch: Throwable -> L9
        r0.remove(r3.getName());     // Catch: Throwable -> L9
        r0.commit();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    synchronized File a(String r9) {
        monitor-enter(this);
        String r10 = "." + r9;     // Catch: Throwable -> L43
        e();     // Catch: Throwable -> L43
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L7;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "failedFiles:" + this.g + " " + r10);     // Catch: Throwable -> L43
    L7:
        File r1 = null;
        if (this.g.size() != 0) goto L11;
        monitor-exit(this);
        return null;
    L11:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L43
        Iterator<String> r2 = this.g.iterator();     // Catch: Throwable -> L43
    L13:
        if (r2.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r3.endsWith(r10) == false) goto L13;
        r0.add(r3);     // Catch: Throwable -> L43
        goto L13
    L18:
        if (com.bytedance.apm6.util.f.a(r0) == false) goto L21;
        monitor-exit(this);
        return null;
    L21:
        Collections.sort(r0, new AnonymousClass1(this));     // Catch: Throwable -> L43
        Iterator r11 = r0.iterator();     // Catch: Throwable -> L43
        b r4 = null;
    L22:
        if (r11.hasNext() == false) goto L41;
        File r5 = new File(a().b(), (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L43
        b r6 = b(r5);     // Catch: Throwable -> L43
        if (r6 == null) goto L40;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L31;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "list send file:" + r5.getName() + " " + b.a(r6) + " " + b.b(r6) + " " + System.currentTimeMillis());     // Catch: Throwable -> L43
    L31:
        if (b.a(r6) == 0) goto L40;
        if (b.b(r6) < System.currentTimeMillis()) goto L40;
        if (r4 == null) goto L39;
        if (b.b(r4) <= b.b(r6)) goto L22;
    L39:
        r4 = r6;
        r1 = r5;
    L40:
        r1 = r5;
    L41:
        monitor-exit(this);
        return r1;
    L43:
        th = move-exception;
        throw th;
    }

    File b() {
        d();
        return this.f5110c;
    }

    File[] c() {
        d();
        File r0 = this.f5110c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.listFiles();
    }

    b b(File r4) {
        b r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        d();
        String r5 = r4.getName();
        if (this.f5111d.containsKey(r5) == false) goto L10;
        return (b) ZeusTransformUtils.preCheckCast(this.f5111d.get(r5), b.class, "com.obric.aiagent.plugin");
    L10:
        if (this.f5108a.contains(r5) == false) goto L16;
        String r1 = this.f5108a.getString(r5, "");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0 = b.a(r1);
    L14:
        if (r0 == null) goto L16;
        this.f5111d.put(r5, r0);
    L16:
        return r0;
    }

    void a(File r4, int r5, long r6) {
        if (r4 != null) goto L13;
        return;
    L13:
        d();     // Catch: Throwable -> L10
        SharedPreferences.Editor r0 = this.f5108a.edit();     // Catch: Throwable -> L10
        String r7 = r4.getName();     // Catch: Throwable -> L10
        if (this.f5111d.containsKey(r7) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f5111d.get(r7), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L8:
        r3.update(r5, r6);     // Catch: Throwable -> L10
        r0.putString(r7, r3.b());     // Catch: Throwable -> L10
        r0.commit();     // Catch: Throwable -> L10
        return;
    L7:
        b r1 = new b(r5, r6);     // Catch: Throwable -> L10
        this.f5111d.put(r7, r1);     // Catch: Throwable -> L10
        r3 = r1;
    L10:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "updateRetryMessage", th);
    }

    static long c(File r4) {
        String[] r5 = r4.getName().split("_");     // Catch: Throwable -> L8
        if (r5.length == 2) goto L6;
        return -1;
    L6:
        return Long.parseLong(r5[0]);
    L11:
        return -1;
    }

    private synchronized void d() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f5109b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        File r0 = new File(com.bytedance.apm6.consumer.slardar.b.b(), "log");     // Catch: Throwable -> L13
        if (r0.exists() == true) goto L10;
        r0.mkdirs();     // Catch: Throwable -> L13
    L10:
        this.f5110c = r0;     // Catch: Throwable -> L13
        this.f5108a = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSharedPreferences("log_report_message", 0);     // Catch: Throwable -> L13
        this.f5109b = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private synchronized void e() {
        monitor-enter(this);
        int r1 = 0;
        if (this.f == true) goto L13;
        String[] r0 = a().b().list();     // Catch: Throwable -> L25
        int r2 = r0.length;     // Catch: Throwable -> L25
    L6:
        if (r1 >= r2) goto L11;
        String r3 = r0[r1];     // Catch: Throwable -> L25
        if (this.g.contains(r3) == true) goto L10;
        b(r3);     // Catch: Throwable -> L25
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L6
    L11:
        this.f = true;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L13:
        if (this.f5112e <= 0) goto L23;
        if (this.g.size() != 0) goto L23;
        String[] r4 = a().b().list();     // Catch: Throwable -> L25
        int r5 = r4.length;     // Catch: Throwable -> L25
    L17:
        if (r1 >= r5) goto L22;
        String r6 = r4[r1];     // Catch: Throwable -> L25
        if (this.g.contains(r6) == true) goto L21;
        b(r6);     // Catch: Throwable -> L25
    L21:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L17
    L22:
        this.f5112e -= (long) this.g.size();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private void b(String r5) {
        if (this.g.size() <= 5000) goto L6;
        this.f5112e++;
        return;
    L6:
        this.g.add(r5);
    }
}
