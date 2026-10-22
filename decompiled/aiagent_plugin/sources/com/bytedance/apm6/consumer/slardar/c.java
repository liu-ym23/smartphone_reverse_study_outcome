package com.bytedance.apm6.consumer.slardar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: LogReporter.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.apm6.consumer.slardar.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f5081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f5082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm6.util.a.a<com.bytedance.apm6.consumer.slardar.c.a> f5083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.bytedance.apm6.consumer.slardar.c.c f5084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile com.bytedance.apm6.util.e.a f5085e;
    private volatile boolean f;

    /* JADX INFO: compiled from: LogReporter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5090a = null;

        static /* synthetic */ c a() {
            return f5090a;
        }

        static {
            f5090a = new c();
        }
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public String c() {
        return "first_log_dir";
    }

    public c() {
        this.f5081a = 60000;
        this.f5082b = 1048576;
        this.f5083c = new com.bytedance.apm6.util.a.a(10);
        this.f = false;
    }

    static /* synthetic */ void a(c r0) {
        r0.e();
    }

    static /* synthetic */ void b(c r0) {
        r0.g();
    }

    public static c a() {
        return a.a();
    }

    public void a(com.bytedance.apm6.consumer.slardar.c.c r1) {
        this.f5084d = r1;
    }

    public void a(long r3) {
        if (r3 > 0) goto L5;
        return;
    L5:
        this.f5082b = r3;
    }

    public synchronized void b(long r7) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L7;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "setLoopInterval:" + this.f5081a);     // Catch: Throwable -> L20
    L7:
        if (r7 > 0) goto L9;
    L18:
        monitor-exit(this);
        return;
    L9:
        if (this.f5081a == r7) goto L18;
        this.f5081a = r7;     // Catch: Throwable -> L20
        if (this.f5085e != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5473a).b(this.f5085e);     // Catch: Throwable -> L20
        final long r2 = this.f5081a;     // Catch: Throwable -> L20
        final long r4 = this.f5081a;     // Catch: Throwable -> L20
        this.f5085e = new AnonymousClass1(this, r2, r4);     // Catch: Throwable -> L20
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5473a).a(this.f5085e);     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public synchronized void b() {
        monitor-enter(this);
        final long r2 = 0;
        final long r4 = this.f5081a;     // Catch: Throwable -> L8
        this.f5085e = new AnonymousClass2(this, r2, r4);     // Catch: Throwable -> L8
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5473a).a(this.f5085e);     // Catch: Throwable -> L8
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L6;
        final long r3 = 10000;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5473a).a(new AnonymousClass3(this, r3));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void e() {
        long r0 = System.currentTimeMillis();
        f();
        h();
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L8;
        if (this.f == true) goto L8;
        i();
    L8:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L11;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r0));
        return;
    }

    private void f() {
    L6:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "flushBuffer", th);
        return;
    L3:
        if (this.f5084d == null) goto L11;
        this.f5084d.a();     // Catch: Throwable -> L6
        return;
    }

    private void g() {
        File r13 = b.f();
        if (r13.exists() == true) goto L5;
        return;
    L5:
        File[] r14 = r13.listFiles();
        if (r14 != null) goto L8;
        return;
    L8:
        int r0 = r14.length;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L42;
        File r3 = r14[r2];
        if (r3 == null) goto L41;
        if (r3.exists() == false) goto L41;
        if (r3.length() <= 0) goto L41;
        if (Long.parseLong(r3.getName().split("_")[0]) >= com.bytedance.apm6.foundation.context.a.d()) goto L41;
        FileChannel r4 = null;
        r4 = new RandomAccessFile(r3, "rw").getChannel();     // Catch: Throwable -> L33
        FileLock r5 = r4.tryLock(0, Long.MAX_VALUE, false);     // Catch: Throwable -> L33
        if (r5 == null) goto L30;
        if (r5.isValid() == false) goto L30;
        File r6 = new File(b.e(), b.g());     // Catch: Throwable -> L33
        boolean r7 = com.bytedance.common.utility.c.b.a(r3.getAbsolutePath(), r6.getAbsolutePath());     // Catch: Throwable -> L33
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L28;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "moveInactiveSubProcessData: src:" + r3.getAbsolutePath() + " dst:" + r6.getAbsolutePath() + " isSuccess:" + r7);     // Catch: Throwable -> L33
    L28:
        r5.release();     // Catch: Throwable -> L33
    L37:
        com.bytedance.apm6.util.d.a(r4);
    L30:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L37;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "moveInactiveSubProcessData isValid is not true ");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
    L38:
        th = move-exception;
        com.bytedance.apm6.util.d.a(r4);
        throw th;
    L35:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L37;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "moveInactiveSubProcessData failed.", th);     // Catch: Throwable -> L38
    L41:
        r2 = r2 + 1;
        goto L9
    }

    private void h() {
        if (this.f5083c.b() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L7:
        if (this.f5083c.b() == true) goto L18;
        r0.add(this.f5083c.a());
        com.bytedance.apm6.consumer.slardar.c.a r3 = (com.bytedance.apm6.consumer.slardar.c.a) ZeusTransformUtils.preCheckCast(this.f5083c.a(), com.bytedance.apm6.consumer.slardar.c.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        int r4 = r3.c();
        if (r2 == 0) goto L17;
        if ((r2 + r4) < this.f5082b) goto L17;
        com.bytedance.apm6.consumer.slardar.d.d.a().a(r0, 0);
        r0.clear();
        r0.add(r3);
        r2 = r4;
    L17:
        r2 = r2 + r4;
        r0.add(r3);
        goto L7
    L18:
        com.bytedance.apm6.consumer.slardar.d.d.a().a(r0, 0);
    }

    private void i() {
        if (this.f5084d == null) goto L5;
        String[] r0 = this.f5084d.b();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length == 0) goto L48;
        List r1 = Arrays.asList(r0);
        Collections.sort(r1, new AnonymousClass4(this));
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L13;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "reportFile: parsing " + r1.size() + " files. fileNameList" + r1);
    L13:
        ArrayList r2 = new ArrayList();
        int r3 = 0;
        int r4 = 0;
    L15:
        if (r3 >= r1.size()) goto L38;
        File r7 = new File(b.e(), (String) ZeusTransformUtils.preCheckCast(r1.get(r3), String.class, "com.obric.aiagent.plugin"));
        if (r7.exists() == false) goto L36;
        com.bytedance.apm6.consumer.slardar.c.a r5 = com.bytedance.apm6.consumer.slardar.c.a.a(r7);
        if (r5 == null) goto L22;
        int r8 = r5.c();
        if (r4 != 0) goto L28;
    L35:
        r4 = r4 + r8;
        r2.add(r5);
        goto L36
    L28:
        if ((r4 + r8) < this.f5082b) goto L35;
        if (com.bytedance.apm.h.a.c() == null) goto L33;
        com.bytedance.apm.h.a.c().b(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendList:" + r1.toString());
    L33:
        com.bytedance.apm6.consumer.slardar.d.d.a().a(r2, r1.size() - r2.size());
        return;
    L22:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L24;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "logFile invalid. delete now.");
    L24:
        r7.delete();
    L36:
        r3 = r3 + 1;
        goto L15
    L38:
        if (com.bytedance.apm.h.a.c() == null) goto L40;
        com.bytedance.apm.h.a.c().b(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendList:" + r1.toString());
    L40:
        com.bytedance.apm6.consumer.slardar.d.d.a().a(r2, 0);
        return;
    L48:
        return;
    L5:
        com.bytedance.apm6.util.c.b.d(com.bytedance.apm6.consumer.slardar.a.f5054a, "persistentBuffer is null");
        r0 = null;
        goto L6
    }

    public void a(com.bytedance.apm6.consumer.slardar.c.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f5083c.a(r1);
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public void c(long r10) {
        if (this.f5084d != null) goto L5;
        return;
    L5:
        String[] r0 = this.f5084d.b();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length == 0) goto L24;
        int r1 = r0.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L25;
        String r3 = r0[r2];
        File r4 = new File(b.e(), r3);
        long r5 = a(r4);
        if (r5 != (-1)) goto L16;
        com.bytedance.apm6.util.c.c(r4);
    L18:
        r2 = r2 + 1;
        goto L11
    L16:
        if (r5 > r10) goto L18;
        com.bytedance.apm6.util.c.c(r4);
        goto L18
    L25:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public void d(long r11) {
        if (this.f5084d != null) goto L5;
        return;
    L5:
        String[] r10 = this.f5084d.b();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length == 0) goto L41;
        Arrays.sort(r10);
        int r0 = r10.length;
        int r1 = 0;
        long r2 = 0;
        int r4 = 0;
        long r5 = 0;
    L11:
        if (r4 >= r0) goto L18;
        File r8 = new File(b.e(), r10[r4]);
        if (r8.exists() == false) goto L17;
        if (r8.isFile() == false) goto L17;
        r5 = r5 + r8.length();
    L17:
        r4 = r4 + 1;
        goto L11
    L18:
        int r3 = r10.length;
    L19:
        if (r1 >= r3) goto L42;
        String r6 = r10[r1];
        if ((r5 - r2) <= r11) goto L43;
        File r7 = new File(b.e(), r6);
        if (r7.exists() == false) goto L29;
        if (r7.isFile() == false) goto L29;
        long r9 = r7.length();
        if (com.bytedance.apm6.util.c.b(r7) == false) goto L29;
        r2 = r2 + r9;
    L29:
        r1 = r1 + 1;
        goto L19
    L43:
        return;
    L42:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.e.d
    public long d() {
        String[] r7 = this.f5084d.b();
        long r0 = 0;
        if (r7 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r7.length == 0) goto L10;
        int r2 = r7.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L10;
        String r4 = r7[r3];
        r0 = r0 + new File(b.e(), r4).length();
        r3 = r3 + 1;
        goto L8
    }

    private long a(File r4) {
        String r3 = r4.getName();
        int r5 = r3.indexOf("_");
        if (r5 != (-1)) goto L9;
        return -1;
    L9:
        return Long.parseLong(r3.substring(0, r5));
    L8:
        return -1;
    }
}
