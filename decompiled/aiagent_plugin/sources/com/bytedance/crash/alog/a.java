package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.f;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.p;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;
import com.bytedance.crash.z;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AlogManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0158a f7150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, b> f7151b = null;

    /* JADX INFO: renamed from: com.bytedance.crash.alog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlogManager.java */
    interface InterfaceC0158a {
        List<String> a(long r1, String r3);

        boolean a();

        void b();
    }

    /* JADX INFO: compiled from: AlogManager.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f7152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<Long> f7153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7154c;

        b(String r2, long r3, CrashType r5) {
            ArrayList r0 = new ArrayList();
            this.f7153b = r0;
            this.f7152a = r2;
            r0.add(Long.valueOf(r3));
            if (r5 != CrashType.LAUNCH) goto L6;
            this.f7154c = true;
            return;
        }

        void a(long r2, CrashType r4) {
            this.f7153b.add(Long.valueOf(r2));
            if (r4 != CrashType.LAUNCH) goto L6;
            this.f7154c = true;
            return;
        }
    }

    /* JADX INFO: compiled from: AlogManager.java */
    static class c implements InterfaceC0158a {
        c() {
        }

        @Override // com.bytedance.crash.alog.a.InterfaceC0158a
        public List<String> a(long r1, String r3) {
            return z.a(r1, r3);
        L4:
            return null;
        }

        @Override // com.bytedance.crash.alog.a.InterfaceC0158a
        public void b() {
            z.b();     // Catch: Throwable -> L4
            return;
        }

        @Override // com.bytedance.crash.alog.a.InterfaceC0158a
        public boolean a() {
            return z.d();
        L4:
            return false;
        }
    }

    /* JADX INFO: compiled from: AlogManager.java */
    static class d implements InterfaceC0158a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f7155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.crash.alog.c f7156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.crash.alog.d f7157c;

        @Override // com.bytedance.crash.alog.a.InterfaceC0158a
        public boolean a() {
            return true;
        }

        d(String r3, com.bytedance.crash.alog.c r4, com.bytedance.crash.alog.d r5) {
            com.bytedance.crash.alog.c r6 = (com.bytedance.crash.alog.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.crash.alog.c.class, "com.obric.aiagent.plugin");
            com.bytedance.crash.alog.d r7 = (com.bytedance.crash.alog.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.crash.alog.d.class, "com.obric.aiagent.plugin");
            this.f7155a = new File(r3);
            this.f7156b = r6;
            this.f7157c = r7;
        }

        @Override // com.bytedance.crash.alog.a.InterfaceC0158a
        public List<String> a(long r3, String r5) {
            if (this.f7155a.exists() == false) goto L9;
            com.bytedance.crash.alog.d r0 = this.f7157c;
            if (ZeusTransformUtils.instanceOf(r0, com.bytedance.crash.alog.b.class) == false) goto L12;
            r0 = new com.bytedance.crash.alog.b(r5);
        L12:
            return r0.a(this.f7155a.getAbsolutePath(), r3);
        L14:
            return null;
        L9:
            return null;
        }

        @Override // com.bytedance.crash.alog.a.InterfaceC0158a
        public void b() {
            com.bytedance.crash.alog.c r0 = this.f7156b;
            if (r0 == null) goto L11;
            r0.flushAlogDataToFile();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            com.bytedance.crash.c.b.a(th);
            return;
        }
    }

    /* JADX INFO: compiled from: AlogManager.java */
    static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.bytedance.crash.monitor.a f7160c;

        e(com.bytedance.crash.monitor.a r2) {
            this.f7158a = 60;
            this.f7159b = 0;
            this.f7160c = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.b() == true) goto L5;
        L8:
            int r0 = this.f7159b;
            this.f7159b = r0 + 1;
            if (r0 >= 60) goto L13;
            DefaultWorkThread.postDelayed(this, 2000);
            return;
        L13:
            return;
        L5:
            if (p.b() == false) goto L8;
            a.b(this.f7160c);
        }
    }

    static /* synthetic */ void b(com.bytedance.crash.monitor.a r0) {
        c(r0);
    }

    static {
        f7151b = new HashMap();
    }

    public static void a(String r2, com.bytedance.crash.alog.c r3, com.bytedance.crash.alog.d r4) {
        com.bytedance.crash.alog.c r5 = (com.bytedance.crash.alog.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.crash.alog.c.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.alog.d r6 = (com.bytedance.crash.alog.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.crash.alog.d.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (f7150a != null) goto L9;
        f7150a = new d(r2, r5, r6);
        return;
    }

    public static void a() {
        if (z.c() == true) goto L5;
        return;
    L5:
        if (z.a() == false) goto L9;
        f7150a = new c();
        return;
    }

    public static boolean b() {
        InterfaceC0158a r0 = f7150a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() == false) goto L7;
        return true;
    }

    public static void c() {
        if (b() == false) goto L6;
        f7150a.b();
        return;
    }

    public static List<String> a(long r1, String r3) {
        if (b() == true) goto L5;
        return null;
    L5:
        return f7150a.a(r1, r3);
    }

    public static void a(String r4, long r5, long r7, CrashType r9) {
        HashMap<String, b> r0 = f7151b;
        monitor-enter(r0);
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get(r4 + r5), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r0.put(r4 + r5, new b(r4, r7, r9));     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        r1.a(r7, r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private static void c(com.bytedance.crash.monitor.a r8) {
        HashMap<String, b> r0 = f7151b;
        monitor-enter(r0);
        HashMap r1 = new HashMap(r0);     // Catch: Throwable -> L32
        r0.clear();     // Catch: Throwable -> L32
        monitor-exit(r0);     // Catch: Throwable -> L32
        Iterator r2 = r1.keySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L31;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1.get((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        if (r3.f7153b.isEmpty() == true) goto L8;
        HashSet r4 = new HashSet();
        Iterator<Long> r5 = r3.f7153b.iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        List<String> r6 = a(((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.aiagent.plugin")).longValue(), r3.f7152a);
        if (r6 == null) goto L15;
        r4.addAll(r6);
        goto L15
    L20:
        if (r4.isEmpty() == true) goto L8;
        String r7 = a(r8, new ArrayList(r4), r3.f7152a);
        com.bytedance.crash.c.b.a r9 = new com.bytedance.crash.c.b.a("alog_check");
        Object[] r10 = new Object[6];
        r10[0] = "check_result";
        r10[1] = r7;
        r10[2] = "crash_type";
        if (r3.f7154c == false) goto L25;
        String r11 = "lunch";
    L26:
        r10[3] = r11;
        r10[4] = "alog_inited";
        if (b() == false) goto L29;
        String r12 = "true";
    L30:
        r10[5] = r12;
        r9.a(r10).a();
        goto L8
    L29:
        r12 = "uncertain";
        goto L30
    L25:
        r11 = "normal";
        goto L26
    L31:
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private static String a(com.bytedance.crash.monitor.a r8, List<String> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        int r0 = Integer.parseInt(r8.e());     // Catch: Throwable -> L5
    L6:
        if (r0 > 0) goto L21;
        return "no_aid";
    L21:
        String r7 = r8.a("0");     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r7) == false) goto L13;
        return "no_did";
    L13:
        int r2 = r0;
        if (com.bytedance.crash.upload.b.a(o.a(f.m(), r2, r7, r8.l(), r8.j()), r0, r7, r10, r11) == false) goto L25;
        return "success";
    L25:
        return SensitiveType.UNKNOWN;
    L17:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
        return SensitiveType.UNKNOWN;
    L5:
        r0 = 0;
        goto L6
    }

    public static void a(long r0) {
        NativeBridge.d(r0);
    }

    public static void a(com.bytedance.crash.monitor.a r1) {
        new e(r1).run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.c.b.b("NPTH_ANR_ERROR_AlogManager", e);
    }
}
