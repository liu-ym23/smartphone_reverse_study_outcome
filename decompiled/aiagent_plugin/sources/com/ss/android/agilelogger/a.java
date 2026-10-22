package com.ss.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.alog.Alog;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ALog.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.ss.android.agilelogger.b f37047a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f37048b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f37049c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Set<String> f37050d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f37051e = false;
    private static volatile c f;
    private static volatile List<d> g;
    private static ScheduledExecutorService h;
    private static Alog i;
    private static ArrayList<WeakReference<Alog>> j;
    private static ExecutorService k;
    private static HandlerThread l;
    private static Handler m;
    private static boolean n;
    private static Object o;
    private static final ThreadLocal<Long> p = null;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.a$3, reason: invalid class name */
    /* JADX INFO: compiled from: ALog.java */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37057a = null;

        static {
            int[] r0 = new int[com.ss.android.agilelogger.b.b.a.values().length];
            f37057a = r0;
            r0[com.ss.android.agilelogger.b.b.a.f37084a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f37057a[com.ss.android.agilelogger.b.b.a.i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f37057a[com.ss.android.agilelogger.b.b.a.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f37057a[com.ss.android.agilelogger.b.b.a.f37085b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f37057a[com.ss.android.agilelogger.b.b.a.f37086c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f37057a[com.ss.android.agilelogger.b.b.a.f37087d.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f37057a[com.ss.android.agilelogger.b.b.a.f37088e.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f37057a[com.ss.android.agilelogger.b.b.a.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f37057a[com.ss.android.agilelogger.b.b.a.g.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.agilelogger.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ALog.java */
    private static class C1013a {
        private static final Object j = null;
        private static C1013a k;
        private static int l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f37066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f37067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f37068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.ss.android.agilelogger.b.b.a f37069e;
        public Object f;
        public long g;
        public long h;
        public C1013a i;

        private C1013a() {
            this.f37069e = null;
        }

        static {
            j = new Object();
        }

        public static C1013a a() {
            Object r0 = j;
            monitor-enter(r0);
            C1013a r1 = k;     // Catch: Throwable -> L12
            if (r1 == null) goto L9;
            k = r1.i;     // Catch: Throwable -> L12
            r1.i = null;     // Catch: Throwable -> L12
            l--;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return new C1013a();
        L12:
            th = move-exception;
            throw th;
        }

        public void b() {
            this.f37066b = null;
            this.f37067c = null;
            this.f37068d = null;
            this.f37069e = null;
            this.f = null;
            this.g = -1;
            this.h = 0;
            this.i = null;
            Object r0 = j;
            monitor-enter(r0);
            int r1 = l;     // Catch: Throwable -> L9
            if (r1 >= 50) goto L7;
            this.i = k;     // Catch: Throwable -> L9
            k = this;     // Catch: Throwable -> L9
            l = r1 + 1;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: ALog.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Alog f37070a;

        b(Alog r1) {
            this.f37070a = r1;
        }

        public void a(String r2, String r3) {
            if (a.a(2, r2) == false) goto L6;
            this.f37070a.a(r2, r3);
            return;
        }

        public void b(String r2, String r3) {
            if (a.a(3, r2) == false) goto L6;
            this.f37070a.b(r2, r3);
            return;
        }

        public void c(String r2, String r3) {
            if (a.a(4, r2) == false) goto L6;
            this.f37070a.c(r2, r3);
            return;
        }

        public void d(String r2, String r3) {
            if (a.a(5, r2) == false) goto L6;
            this.f37070a.d(r2, r3);
            return;
        }

        public void e(String r2, String r3) {
            if (a.a(6, r2) == false) goto L6;
            this.f37070a.e(r2, r3);
            return;
        }
    }

    private static int b(int r0) {
        return r0 - 2;
    }

    static /* synthetic */ int a(int r0) {
        return b(r0);
    }

    static /* synthetic */ void a(C1013a r0) {
        b(r0);
    }

    static /* synthetic */ void a(Queue r2) {
        b((Queue) ZeusTransformUtils.wrapperContextForParams(r2, Queue.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ c f() {
        return f;
    }

    static /* synthetic */ void f(String r0, String r1) {
        g(r0, r1);
    }

    static {
        g = new ArrayList();
        h = null;
        i = null;
        j = new ArrayList();
        k = null;
        n = false;
        o = new Object();
        p = new AnonymousClass1();
    }

    public static boolean a(com.ss.android.agilelogger.b r11) {
        boolean r0 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        f37047a = r11;
        Alog.a(new e());     // Catch: Throwable -> L96
        Object r1 = o;
        monitor-enter(r1);
    L93:
        th = move-exception;
        throw th;
    L10:
        if (n == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L93
        return false;
    L13:
        n = true;     // Catch: Throwable -> L93
        monitor-exit(r1);     // Catch: Throwable -> L93
        f37048b = r11.i();
        boolean r2 = g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        boolean r3 = r11.l();
        if (r3 == false) goto L18;
    L21:
        boolean r4 = false;
    L22:
        boolean r5 = r11.m();
        boolean r6 = r11.p();
        if (r2 == true) goto L25;
        r11.b((int) (r11.b() * r11.c()));
    L25:
        Alog.b r7 = new Alog.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(DownloadSettingKeys.BugFix.DEFAULT).a(b(r11.i())).a(f37049c).b(r11.f()).b(r11.d());
        if (r4 == false) goto L28;
        int r8 = (r11.b() / 3) * 2;
    L29:
        Alog.b r9 = r7.c(r8).d(r11.a()).c(r11.e());
        if (r2 == false) goto L32;
        int r10 = r11.q() * 1024;
    L33:
        Alog.b r12 = r9.e(r10);
        if (r2 == false) goto L36;
        int r13 = (r11.q() * 3) * 1024;
    L37:
        Alog.b r14 = r12.f(r13).a(Alog.d.f4081b).a(Alog.g.f4093a).a(Alog.e.f4085b);
        if (r11.g() == false) goto L40;
        Alog.c r15 = Alog.c.f4077c;
    L41:
        Alog.b r16 = r14.a(r15);
        if (r11.h() == false) goto L44;
        Alog.f r17 = Alog.f.f4089b;
    L45:
        Alog.b r18 = r16.a(r17);
        if (r11.h() == false) goto L48;
        Alog.a r19 = Alog.a.f4066b;
    L49:
        com.bytedance.android.alog.d.a(r18.a(r19).d(r11.j()).b(r11.o()).a());
        if (r3 == false) goto L56;
        if (r5 == true) goto L53;
        if (r2 == false) goto L56;
    L53:
        if (r6 == false) goto L55;
        k = Executors.newSingleThreadExecutor(new AnonymousClass4());
        goto L56
    L55:
        HandlerThread r20 = new HandlerThread("Alog_main_delegate");
        l = r20;
        r20.start();
        final Looper r21 = l.getLooper();
        m = new ALog$3(r21);
    L56:
        if (r4 == false) goto L70;
        Alog.b r22 = new Alog.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(InitTaskProcess.MAIN).a(b(r11.i())).a(f37049c).b(r11.f()).b(r11.d() / 2).c(r11.b() / 3).d(r11.a()).c(r11.e()).e(32768).f(98304).a(Alog.d.f4081b).a(Alog.g.f4093a).a(Alog.e.f4085b);
        if (r11.g() == false) goto L60;
        Alog.c r23 = Alog.c.f4077c;
    L61:
        Alog.b r24 = r22.a(r23);
        if (r11.h() == false) goto L64;
        Alog.f r25 = Alog.f.f4089b;
    L65:
        Alog.b r26 = r24.a(r25);
        if (r11.h() == false) goto L68;
        Alog.a r27 = Alog.a.f4066b;
    L69:
        i = r26.a(r27).d(r11.j()).b(r11.o()).a();
        goto L70
    L68:
        r27 = Alog.a.f4065a;
        goto L69
    L64:
        r25 = Alog.f.f4088a;
        goto L65
    L60:
        r23 = Alog.c.f4075a;
    L70:
        final String r28 = r11.e();
        final String r110 = r11.f();
        final Queue<f> r29 = null;
        if (f == null) goto L78;
        Queue<f> r30 = f.a();
        if (r30 != null) goto L75;
    L77:
        r29 = r30;
        goto L78
    L75:
        if (r30.size() != 0) goto L77;
    L78:
        if (r29 == null) goto L80;
    L81:
        Runnable r31 = new AnonymousClass5(r29, r28, r110);
        ScheduledExecutorService r32 = h;
        if (r32 != null) goto L84;
        new Thread(r31, "_ALOG_OPT_").start();
    L85:
        r0 = true;
    L86:
        if (r0 == true) goto L91;
        ScheduledExecutorService r33 = h;
        if (r33 != null) goto L90;
        new Timer("_ALOG_OPT_").schedule(new AnonymousClass6(r28, r110), 15000);
        goto L91
    L90:
        r33.schedule(new AnonymousClass7(r28, r110), 15, TimeUnit.SECONDS);
    L91:
        f37051e = true;
        return true;
    L84:
        r32.execute(r31);
        goto L85
    L80:
        if (b().size() <= 0) goto L86;
    L48:
        r19 = Alog.a.f4065a;
        goto L49
    L44:
        r17 = Alog.f.f4088a;
        goto L45
    L40:
        r15 = Alog.c.f4075a;
        goto L41
    L36:
        r13 = 65536;
        goto L37
    L32:
        r10 = 32768;
        goto L33
    L28:
        r8 = r11.b();
        goto L29
    L18:
        if (r11.k() == false) goto L21;
        if (r2 == false) goto L21;
        r4 = true;
    L96:
        return false;
    }

    private static void g(String r4, String r5) {
        File r0 = new File(r4);
        int r1 = 0;
        if (r0.exists() == false) goto L9;
        File[] r6 = r0.listFiles(new AnonymousClass8());
        if (r6 == null) goto L9;
        int r2 = r6.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r6[r3].delete();
        r3 = r3 + 1;
    L9:
        File r7 = new File(r5);
        if (r7.exists() == false) goto L16;
        File[] r8 = r7.listFiles(new AnonymousClass9());
        if (r8 == null) goto L19;
        int r9 = r8.length;
    L14:
        if (r1 >= r9) goto L20;
        r8[r1].delete();
        r1 = r1 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    private static void b(Queue<f> r4) {
        Iterator r5 = ((Queue) ZeusTransformUtils.wrapperContextForParams(r4, Queue.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r5.next(), f.class, "com.obric.aiagent.plugin");
        if (a(r0.f37092b, r0.f37093c) == false) goto L4;
        a(r0);
        com.bytedance.android.alog.d.a(b(r0.f37092b), r0.f37093c, r0.f37094d);
        goto L4
    }

    private static void a(f r4) {
        switch(AnonymousClass3.f37057a[r4.f37095e.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r0 = "";
    L16:
        r4.f37094d = r0;
        return;
    L5:
        r0 = com.ss.android.agilelogger.b.b.a(r4.f37095e, (StackTraceElement[]) ZeusTransformUtils.preCheckCast((StackTraceElement[]) ZeusTransformUtils.preCheckCast(r4.f, StackTraceElement[].class, "com.obric.aiagent.plugin"), StackTraceElement[].class, "com.obric.aiagent.plugin"));
        goto L16
    L6:
        r0 = com.ss.android.agilelogger.b.b.a(r4.f37095e, (Thread) ZeusTransformUtils.preCheckCast(r4.f, Thread.class, "com.obric.aiagent.plugin"));
        goto L16
    L7:
        r0 = com.ss.android.agilelogger.b.b.a(r4.f37095e, (Throwable) ZeusTransformUtils.preCheckCast(r4.f, Throwable.class, "com.obric.aiagent.plugin"));
        goto L16
    L8:
        r0 = com.ss.android.agilelogger.b.b.a(r4.f37095e, (Intent) ZeusTransformUtils.preCheckCast(r4.f, Intent.class, "com.obric.aiagent.plugin"));
        goto L16
    L9:
        r0 = com.ss.android.agilelogger.b.b.a(r4.f37095e, (Bundle) ZeusTransformUtils.preCheckCast(r4.f, Bundle.class, "com.obric.aiagent.plugin"));
        goto L16
    L10:
        r0 = com.ss.android.agilelogger.b.b.a(r4.f37095e, (String) ZeusTransformUtils.preCheckCast(r4.f, String.class, "com.obric.aiagent.plugin"));
        goto L16
    L15:
        r0 = (String) ZeusTransformUtils.preCheckCast(r4.f, String.class, "com.obric.aiagent.plugin");
        goto L16
    L12:
        if (r4.g != null) goto L14;
        r0 = com.ss.android.agilelogger.b.d.a((Throwable) ZeusTransformUtils.preCheckCast(r4.f, Throwable.class, "com.obric.aiagent.plugin"));
        goto L16
    L14:
        r0 = r4.g + com.ss.android.agilelogger.b.d.a((Throwable) ZeusTransformUtils.preCheckCast(r4.f, Throwable.class, "com.obric.aiagent.plugin"));
        goto L16
    }

    public static void a(boolean r1) {
        f37049c = r1;
        com.bytedance.android.alog.d.a(f37049c);
        Alog r2 = i;
        if (r2 == null) goto L6;
        r2.a(f37049c);
        return;
    }

    public static boolean a() {
        return f37051e;
    }

    public static void a(d r2) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        g.add(r3);
    }

    public static List<d> b() {
        return g;
    }

    public static boolean a(int r2, String r3) {
        if (r2 >= f37048b) goto L5;
        return false;
    L5:
        Set<String> r4 = f37050d;
        if (r4 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return true;
    L10:
        if (r4.contains(r3) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static void a(String r3, String r4) {
        if (a(2, r3) == false) goto L37;
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 != null) goto L7;
    L12:
        com.ss.android.agilelogger.b r2 = f37047a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.a(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.a(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(2, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(2, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(2, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(2, r3, r4);
        return;
    }

    public static void b(String r3, String r4) {
        if (a(3, r3) == false) goto L37;
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 != null) goto L7;
    L12:
        com.ss.android.agilelogger.b r2 = f37047a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.b(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.b(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(3, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(3, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(3, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(3, r3, r4);
        return;
    }

    public static void c(String r3, String r4) {
        if (a(4, r3) == false) goto L37;
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 != null) goto L7;
    L12:
        com.ss.android.agilelogger.b r2 = f37047a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.c(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.c(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(4, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(4, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(4, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(4, r3, r4);
        return;
    }

    public static void d(String r3, String r4) {
        if (a(5, r3) == false) goto L37;
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 != null) goto L7;
    L12:
        com.ss.android.agilelogger.b r2 = f37047a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.d(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.d(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(5, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(5, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(5, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(5, r3, r4);
        return;
    }

    public static void a(String r8, String r9, Throwable r10) {
        if (a(5, r8) == false) goto L37;
        com.ss.android.agilelogger.b r0 = f37047a;
        if (r0 != null) goto L7;
    L12:
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = g.a();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + com.ss.android.agilelogger.b.d.a(r10);
        Alog r12 = i;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.d(r8, r11);
        return;
    L35:
        com.bytedance.android.alog.d.d(r8, r11);
        return;
    L28:
        if (m == null) goto L31;
        b(5, r8, r9, r10, null, null);
        return;
    L23:
        if (k == null) goto L26;
        a(5, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.n() == false) goto L20;
        if (m == null) goto L20;
        b(5, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.n() == false) goto L12;
        if (k == null) goto L12;
        a(5, r8, r9, r10, null, null);
        return;
    }

    public static void e(String r3, String r4) {
        if (a(6, r3) == false) goto L37;
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 != null) goto L7;
    L12:
        com.ss.android.agilelogger.b r2 = f37047a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.e(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.e(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(6, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(6, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(6, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(6, r3, r4);
        return;
    }

    public static void b(String r8, String r9, Throwable r10) {
        if (a(6, r8) == false) goto L37;
        com.ss.android.agilelogger.b r0 = f37047a;
        if (r0 != null) goto L7;
    L12:
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = g.a();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + com.ss.android.agilelogger.b.d.a(r10);
        Alog r12 = i;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.e(r8, r11);
        return;
    L35:
        com.bytedance.android.alog.d.e(r8, r11);
        return;
    L28:
        if (m == null) goto L31;
        b(6, r8, r9, r10, null, null);
        return;
    L23:
        if (k == null) goto L26;
        a(6, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.n() == false) goto L20;
        if (m == null) goto L20;
        b(6, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.n() == false) goto L12;
        if (k == null) goto L12;
        a(6, r8, r9, r10, null, null);
        return;
    }

    public static void c() {
        ExecutorService r0 = k;
        if (r0 == null) goto L5;
        r0.execute(new AnonymousClass10());
    L8:
        com.bytedance.android.alog.d.a();
        Alog r1 = i;
        if (r1 == null) goto L11;
        r1.b();
    L11:
        Iterator<WeakReference<Alog>> r2 = j.iterator();
    L13:
        if (r2.hasNext() == false) goto L20;
        WeakReference r3 = (WeakReference) ZeusTransformUtils.preCheckCast(r2.next(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L13;
        Alog r4 = (Alog) ZeusTransformUtils.preCheckCast(r3.get(), Alog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        r4.b();
        goto L13
    L20:
        return;
    L5:
        Handler r5 = m;
        if (r5 == null) goto L8;
        r5.sendEmptyMessage(2);
        goto L8
    }

    public static List<String> a(long r7, long r9) {
        ArrayList r0 = new ArrayList();
        File[] r8 = com.bytedance.android.alog.d.a(null, null, r7 * 1000, r9 * 1000);     // Catch: Exception -> L8
        int r10 = r8.length;     // Catch: Exception -> L8
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L7;
        r0.add(r8[r11].getAbsolutePath());     // Catch: Exception -> L8
        r11 = r11 + 1;
    L7:
        return r0;
    }

    public static HashMap<String, String> d() {
        return com.bytedance.android.alog.d.b();
    }

    public static long e() {
        return com.bytedance.android.alog.d.c();
    }

    private static void a(int r6, String r7, String r8) {
        a(r6, r7, r8, null, null, null);
    }

    private static void a(final int r13, final String r14, final String r15, final Throwable r16, final com.ss.android.agilelogger.b.b.a r17, final Object r18) {
        final long r7 = g();
        final long r9 = System.currentTimeMillis();
        k.execute(new AnonymousClass2(r13, r17, r16, r15, r18, r14, r7, r9));
    }

    private static void b(int r6, String r7, String r8) {
        b(r6, r7, r8, null, null, null);
    }

    private static void b(int r1, String r2, String r3, Throwable r4, com.ss.android.agilelogger.b.b.a r5, Object r6) {
        C1013a r0 = C1013a.a();
        r0.f37065a = r1;
        r0.f37066b = r2;
        r0.f37067c = r3;
        r0.f37068d = r4;
        r0.f37069e = r5;
        r0.f = r6;
        r0.g = g();
        r0.h = System.currentTimeMillis();
        Message r7 = Message.obtain();
        r7.what = 1;
        r7.obj = r0;
        m.sendMessage(r7);
    }

    private static long g() {
        return ((Long) ZeusTransformUtils.preCheckCast(p.get(), Long.class, "com.obric.aiagent.plugin")).longValue();
    }

    private static void b(C1013a r8) {
        int r1 = b(r8.f37065a);
        String r2 = "";
        if (r8.f37069e != null) goto L13;
        if (r8.f37068d != null) goto L8;
        String r0 = r8.f37067c;
    L15:
        String r3 = r0;
    L35:
        com.bytedance.android.alog.d.a(r1, r8.f37066b, r3, r8.g, r8.h);
        r8.b();
        return;
    L8:
        if (r8.f37067c == null) goto L11;
        r2 = r8.f37067c + "\n";
    L11:
        r0 = r2 + com.ss.android.agilelogger.b.d.a(r8.f37068d);
        goto L15
    L13:
        if (r8.f37069e != com.ss.android.agilelogger.b.b.a.f) goto L17;
        r0 = com.ss.android.agilelogger.b.b.a(com.ss.android.agilelogger.b.b.a.f, r8.f37067c);
        goto L15
    L17:
        if (r8.f37069e != com.ss.android.agilelogger.b.b.a.f37085b) goto L20;
        r0 = com.ss.android.agilelogger.b.b.a(com.ss.android.agilelogger.b.b.a.f37085b, r8.f37067c);
        goto L15
    L20:
        if (r8.f37069e != com.ss.android.agilelogger.b.b.a.f37086c) goto L23;
        r0 = com.ss.android.agilelogger.b.b.a(com.ss.android.agilelogger.b.b.a.f37086c, (Bundle) ZeusTransformUtils.preCheckCast(r8.f, Bundle.class, "com.obric.aiagent.plugin"));
        goto L15
    L23:
        if (r8.f37069e != com.ss.android.agilelogger.b.b.a.f37087d) goto L26;
        r0 = com.ss.android.agilelogger.b.b.a(com.ss.android.agilelogger.b.b.a.f37087d, (Intent) ZeusTransformUtils.preCheckCast(r8.f, Intent.class, "com.obric.aiagent.plugin"));
        goto L15
    L26:
        if (r8.f37069e != com.ss.android.agilelogger.b.b.a.f37088e) goto L29;
        r0 = com.ss.android.agilelogger.b.b.a(com.ss.android.agilelogger.b.b.a.f37088e, (Throwable) ZeusTransformUtils.preCheckCast(r8.f, Throwable.class, "com.obric.aiagent.plugin"));
        goto L15
    L29:
        if (r8.f37069e != com.ss.android.agilelogger.b.b.a.h) goto L32;
        r0 = com.ss.android.agilelogger.b.b.a(com.ss.android.agilelogger.b.b.a.h, (Thread) ZeusTransformUtils.preCheckCast(r8.f, Thread.class, "com.obric.aiagent.plugin"));
        goto L15
    L32:
        if (r8.f37069e != com.ss.android.agilelogger.b.b.a.g) goto L34;
        r0 = com.ss.android.agilelogger.b.b.a(com.ss.android.agilelogger.b.b.a.g, (StackTraceElement[]) ZeusTransformUtils.preCheckCast((StackTraceElement[]) ZeusTransformUtils.preCheckCast(r8.f, StackTraceElement[].class, "com.obric.aiagent.plugin"), StackTraceElement[].class, "com.obric.aiagent.plugin"));
        goto L15
    L34:
        r3 = "";
        goto L35
    }

    public static b a(String r5, com.ss.android.agilelogger.b r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (f37051e == false) goto L35;
    L10:
        Alog.b r7 = new Alog.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r5).a(b(r6.i())).a(f37049c);
        com.ss.android.agilelogger.b r1 = f37047a;
        if (r1 == null) goto L13;
        String r2 = r1.f();
    L14:
        Alog.b r8 = r7.b(r2).b(r6.d()).c(r6.b()).d(r6.a());
        com.ss.android.agilelogger.b r3 = f37047a;
        if (r3 == null) goto L17;
        String r4 = r3.e();
    L18:
        Alog.b r9 = r8.c(r4).e(65536).f(196608).a(Alog.d.f4081b).a(Alog.g.f4093a).a(Alog.e.f4085b);
        if (r6.g() == false) goto L21;
        Alog.c r10 = Alog.c.f4077c;
    L22:
        Alog.b r11 = r9.a(r10);
        if (r6.h() == false) goto L25;
        Alog.f r12 = Alog.f.f4089b;
    L26:
        Alog.b r13 = r11.a(r12);
        if (r6.h() == false) goto L29;
        Alog.a r14 = Alog.a.f4066b;
    L30:
        Alog r15 = r13.a(r14).d(r6.j()).b(r6.o()).a();
        if (r15 != null) goto L33;
        return null;
    L33:
        j.add(new WeakReference(r15));
        return new b(r15);
    L29:
        r14 = Alog.a.f4065a;
        goto L30
    L25:
        r12 = Alog.f.f4088a;
        goto L26
    L21:
        r10 = Alog.c.f4075a;
        goto L22
    L17:
        r4 = r6.e();
        goto L18
    L13:
        r2 = r6.f();
        goto L14
    L35:
        Alog.a(new e());     // Catch: Throwable -> L9
    L9:
        return null;
    }
}
