package re;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.p;
import com.bytedance.android.alog.Alog;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.agilelogger.ILogCacheCallback;
import com.ss.android.agilelogger.INativeFuncAddrCallback;
import com.ss.android.agilelogger.utils.FormatUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f23900a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static re.b f23901b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f23902c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Set f23903d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f23904e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile ILogCacheCallback f23905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile List f23906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ScheduledExecutorService f23907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Alog f23908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ArrayList f23909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static HandlerThread f23910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Handler f23911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f23912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f23913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Object f23914o;

    /* JADX INFO: renamed from: re.a$a, reason: collision with other inner class name */
    public static class HandlerC0353a extends Handler {
        public HandlerC0353a(Looper r10) {
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 1) goto L5;
            Object r12 = r10.obj;
            if (r12 != null) goto L11;
            return;
        L11:
            if ((r12 instanceof g) == false) goto L16;
            a.a((g) r12);
            return;
        L16:
            return;
        L5:
            if (r11 != 2) goto L17;
            p0.b.a();
            return;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Queue f23915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f23916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f23917c;

        public b(Queue r10, String r11, String r12) {
            this.f23915a = r10;
            this.f23916b = r11;
            this.f23917c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            Queue r10 = this.f23915a;
            if (r10 == null) goto L5;
            a.b(r10);
            a.c().notifyCacheLogConsumed();
        L5:
            Iterator r11 = a.o().iterator();
        L7:
            if (r11.hasNext() == false) goto L16;
            INativeFuncAddrCallback r12 = (INativeFuncAddrCallback) r11.next();
            if (r12 == null) goto L7;
            r12.onNativeFuncReady(p0.b.c());
            goto L7
        L16:
            Thread.sleep(TraceStatsConsts.APP_START_MAX_LIMIT_MS);     // Catch: Exception -> L15
        L13:
            a.d(this.f23916b, this.f23917c);
        }
    }

    public static class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f23919b;

        public c(String r10, String r11) {
            this.f23918a = r10;
            this.f23919b = r11;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.d(this.f23918a, this.f23919b);
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f23921b;

        public d(String r10, String r11) {
            this.f23920a = r10;
            this.f23921b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d(this.f23920a, this.f23921b);
        }
    }

    public static class e implements FilenameFilter {
        public e() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return r11.startsWith(".logCache_");
        }
    }

    public static class f implements FilenameFilter {
        public f() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            if (r11.endsWith(".hoting") == false) goto L6;
            return true;
        L6:
            if (r11.endsWith(".hot") == true) goto L8;
            return false;
        L8:
            if (r11.endsWith(".alog.hot") == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Object f23922j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static g f23923k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f23924l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f23926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f23927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f23928d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public FormatUtils.TYPE f23929e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f23930f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f23931g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f23932h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public g f23933i;

        static {
            f23922j = new Object();
        }

        public g() {
            this.f23929e = null;
        }

        public static g a() {
            Object r10 = f23922j;
            monitor-enter(r10);
            g r11 = f23923k;     // Catch: Throwable -> L9
            if (r11 == null) goto L11;
            f23923k = r11.f23933i;     // Catch: Throwable -> L9
            r11.f23933i = null;     // Catch: Throwable -> L9
            f23924l--;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r11;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return new g();
        L9:
            th = move-exception;
            throw th;
        }

        public void b() {
            this.f23926b = null;
            this.f23927c = null;
            this.f23928d = null;
            this.f23929e = null;
            this.f23930f = null;
            this.f23931g = -1;
            this.f23932h = 0;
            this.f23933i = null;
            Object r10 = f23922j;
            monitor-enter(r10);
            int r11 = f23924l;     // Catch: Throwable -> L7
            if (r11 >= 50) goto L9;
            this.f23933i = f23923k;     // Catch: Throwable -> L7
            f23923k = this;     // Catch: Throwable -> L7
            f23924l = r11 + 1;     // Catch: Throwable -> L7
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Alog f23934a;

        public h(Alog r10) {
            this.f23934a = r10;
        }

        public void a(String r10, String r11) {
            if (a.e(3, r10) == false) goto L6;
            this.f23934a.j(r10, r11);
            return;
        }

        public void b(String r10, String r11) {
            if (a.e(6, r10) == false) goto L6;
            this.f23934a.k(r10, r11);
            return;
        }

        public void c(String r10, String r11) {
            if (a.e(4, r10) == false) goto L6;
            this.f23934a.o(r10, r11);
            return;
        }

        public void d(String r10, String r11) {
            if (a.e(2, r10) == false) goto L6;
            this.f23934a.r(r10, r11);
            return;
        }

        public void e(String r10, String r11) {
            if (a.e(5, r10) == false) goto L6;
            this.f23934a.s(r10, r11);
            return;
        }
    }

    static {
        f23906g = new ArrayList();
        f23907h = null;
        f23908i = null;
        f23909j = new ArrayList();
        f23912m = -1;
        f23913n = false;
        f23914o = new Object();
    }

    public static /* synthetic */ void a(g r10) {
        p(r10);
    }

    public static /* synthetic */ void b(Queue r10) {
        y(r10);
    }

    public static /* synthetic */ ILogCacheCallback c() {
        return f23905f;
    }

    public static /* synthetic */ void d(String r10, String r11) {
        w(r10, r11);
    }

    public static /* synthetic */ boolean e(int r10, String r11) {
        return h(r10, r11);
    }

    public static void f(INativeFuncAddrCallback r10) {
        f23906g.add(r10);
    }

    public static void g() {
        Handler r10 = f23911l;
        if (r10 == null) goto L5;
        r10.sendEmptyMessage(2);
    L5:
        p0.b.a();
        Alog r11 = f23908i;
        if (r11 == null) goto L8;
        r11.h();
    L8:
        Iterator r12 = f23909j.iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Alog r13 = (Alog) ((WeakReference) r12.next()).get();
        if (r13 == null) goto L10;
        r13.h();
        goto L10
    }

    public static boolean h(int r10, String r11) {
        if (r10 >= f23900a) goto L6;
        return false;
    L6:
        if (f23903d != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return true;
    L10:
        if (f23903d.contains(r11) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static h i(String r10, Context r11) {
        if (r11 != null) goto L6;
        return null;
    L6:
        return j(r10, new re.b.C0354b(r11).a());
    }

    public static h j(String r10, re.b r11) {
        if (r11 != null) goto L6;
        return null;
    L6:
        if (f23904e == false) goto L35;
    L10:
        Alog.a r12 = new Alog.a(r11.c()).g(r10).h(t(r11.d())).q(f23902c);
        re.b r13 = f23901b;
        if (r13 == null) goto L13;
        String r14 = r13.e();
    L14:
        Alog.a r15 = r12.i(r14).k(r11.h()).l(r11.g()).j(r11.f());
        re.b r16 = f23901b;
        if (r16 == null) goto L17;
        String r17 = r16.b();
    L18:
        Alog.a r18 = r15.c(r17).d(65536).e(196608).m(Alog.Mode.SAFE).r(Alog.TimeFormat.RAW).n(Alog.PrefixFormat.LEGACY);
        if (r11.j() == false) goto L21;
        Alog.Compress r19 = Alog.Compress.ZSTD;
    L22:
        Alog.a r20 = r18.f(r19);
        if (r11.k() == false) goto L25;
        Alog.SymCrypt r21 = Alog.SymCrypt.TEA_16;
    L26:
        Alog.a r22 = r20.p(r21);
        if (r11.k() == false) goto L29;
        Alog.AsymCrypt r23 = Alog.AsymCrypt.EC_SECP256K1;
    L30:
        Alog r24 = r22.b(r23).o(r11.i()).a();
        if (r24 != null) goto L33;
        return null;
    L33:
        f23909j.add(new WeakReference(r24));
        return new h(r24);
    L29:
        r23 = Alog.AsymCrypt.NONE;
        goto L30
    L25:
        r21 = Alog.SymCrypt.NONE;
        goto L26
    L21:
        r19 = Alog.Compress.NONE;
        goto L22
    L17:
        r17 = r11.b();
        goto L18
    L13:
        r14 = r11.e();
        goto L14
    L35:
        Alog.p(new re.c());     // Catch: Throwable -> L9
    L9:
        return null;
    }

    public static void k(String r10, String r11, Throwable r12) {
        if (h(6, r10) == false) goto L16;
        boolean r13 = re.e.c();
        if (r13 == true) goto L7;
    L10:
        String r14 = r11 + "\n" + ze.c.a(r12);
        Alog r15 = f23908i;
        if (r15 == null) goto L14;
        if (r13 == false) goto L14;
        r15.k(r10, r14);
        return;
    L14:
        p0.b.b(r10, r14);
        return;
    L7:
        if (f23911l == null) goto L10;
        v(6, r10, r11, r12, null, null);
        return;
    }

    public static void l(String r10, Throwable r11) {
        if (h(6, r10) == false) goto L16;
        boolean r12 = re.e.c();
        if (r12 == true) goto L7;
    L10:
        String r13 = ze.c.a(r11);
        Alog r14 = f23908i;
        if (r14 == null) goto L14;
        if (r12 == false) goto L14;
        r14.k(r10, r13);
        return;
    L14:
        p0.b.b(r10, r13);
        return;
    L7:
        if (f23911l == null) goto L10;
        v(6, r10, null, r11, null, null);
        return;
    }

    public static List m(long r10, long r11) {
        ArrayList r12 = new ArrayList();
        File[] r13 = p0.b.d(null, null, r10 * 1000, r11 * 1000);     // Catch: Exception -> L8
        int r14 = r13.length;     // Catch: Exception -> L8
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L7;
        r12.add(r13[r15].getAbsolutePath());     // Catch: Exception -> L8
        r15 = r15 + 1;
    L7:
        return r12;
    }

    public static long n() {
        return p0.b.c();
    }

    public static List o() {
        return f23906g;
    }

    public static void p(g r10) {
        int r11 = t(r10.f23925a);
        FormatUtils.TYPE r12 = r10.f23929e;
        String r13 = "";
        if (r12 == null) goto L5;
        FormatUtils.TYPE r14 = FormatUtils.TYPE.BORDER;
        if (r12 != r14) goto L16;
        String r15 = FormatUtils.c(r14, r10.f23927c);
    L7:
        String r16 = r15;
    L35:
        p0.b.i(r11, r10.f23926b, r16, r10.f23931g, r10.f23932h);
        r10.b();
        return;
    L16:
        FormatUtils.TYPE r17 = FormatUtils.TYPE.JSON;
        if (r12 != r17) goto L19;
        r15 = FormatUtils.c(r17, r10.f23927c);
        goto L7
    L19:
        FormatUtils.TYPE r18 = FormatUtils.TYPE.BUNDLE;
        if (r12 != r18) goto L22;
        r15 = FormatUtils.b(r18, (Bundle) r10.f23930f);
        goto L7
    L22:
        FormatUtils.TYPE r19 = FormatUtils.TYPE.INTENT;
        if (r12 != r19) goto L25;
        r15 = FormatUtils.a(r19, (Intent) r10.f23930f);
        goto L7
    L25:
        FormatUtils.TYPE r20 = FormatUtils.TYPE.THROWABLE;
        if (r12 != r20) goto L28;
        r15 = FormatUtils.e(r20, (Throwable) r10.f23930f);
        goto L7
    L28:
        FormatUtils.TYPE r21 = FormatUtils.TYPE.THREAD;
        if (r12 != r21) goto L31;
        r15 = FormatUtils.d(r21, (Thread) r10.f23930f);
        goto L7
    L31:
        FormatUtils.TYPE r22 = FormatUtils.TYPE.STACKTRACE;
        if (r12 != r22) goto L34;
        r15 = FormatUtils.f(r22, (StackTraceElement[]) r10.f23930f);
        goto L7
    L34:
        r16 = "";
        goto L35
    L5:
        if (r10.f23928d != null) goto L9;
        r15 = r10.f23927c;
        goto L7
    L9:
        if (r10.f23927c == null) goto L12;
        r13 = r10.f23927c + "\n";
    L12:
        r15 = r13 + ze.c.a(r10.f23928d);
        goto L7
    }

    public static void q(String r10, String r11) {
        if (h(4, r10) == false) goto L16;
        boolean r12 = re.e.c();
        if (r12 == true) goto L7;
    L10:
        Alog r13 = f23908i;
        if (r13 == null) goto L14;
        if (r12 == false) goto L14;
        r13.o(r10, r11);
        return;
    L14:
        p0.b.e(r10, r11);
        return;
    L7:
        if (f23911l == null) goto L10;
        u(4, r10, r11);
        return;
    }

    public static boolean r(re.b r11) {
        boolean r10 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        f23901b = r11;
        Alog.p(new re.c());     // Catch: Throwable -> L89
        Object r12 = f23914o;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L10:
        if (f23913n == false) goto L15;
        monitor-exit(r12);     // Catch: Throwable -> L13
        return false;
    L15:
        f23913n = true;     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        f23900a = r11.d();
        boolean r13 = re.e.b(r11.c());
        boolean r14 = r11.m();
        if (r14 == false) goto L20;
    L23:
        boolean r15 = r11.a();
        Alog.a r16 = new Alog.a(r11.c()).g("default").h(t(r11.d())).q(f23902c).i(r11.e()).k(r11.h());
        if (r10 == false) goto L26;
        int r17 = (r11.g() / 3) * 2;
    L27:
        Alog.a r18 = r16.l(r17).j(r11.f()).c(r11.b());
        int r19 = 65536;
        if (r13 == false) goto L30;
        int r20 = 65536;
    L31:
        Alog.a r21 = r18.d(r20);
        if (r13 == false) goto L34;
        r19 = 196608;
    L34:
        Alog.a r22 = r21.e(r19);
        Alog.Mode r23 = Alog.Mode.SAFE;
        Alog.a r24 = r22.m(r23);
        Alog.TimeFormat r25 = Alog.TimeFormat.RAW;
        Alog.a r26 = r24.r(r25);
        Alog.PrefixFormat r27 = Alog.PrefixFormat.LEGACY;
        Alog.a r28 = r26.n(r27);
        if (r11.j() == false) goto L37;
        Alog.Compress r110 = Alog.Compress.ZSTD;
    L38:
        Alog.a r29 = r28.f(r110);
        if (r11.k() == false) goto L41;
        Alog.SymCrypt r111 = Alog.SymCrypt.TEA_16;
    L42:
        Alog.a r30 = r29.p(r111);
        if (r11.k() == false) goto L45;
        Alog.AsymCrypt r112 = Alog.AsymCrypt.EC_SECP256K1;
    L46:
        p0.b.f(r30.b(r112).o(r11.i()).a());
        if (r14 == false) goto L51;
        if (r15 == true) goto L50;
        if (r13 == false) goto L51;
    L50:
        HandlerThread r31 = new HandlerThread("Alog_main_delegate");
        f23910k = r31;
        r31.start();
        f23911l = new HandlerC0353a(f23910k.getLooper());
    L51:
        if (r10 == false) goto L65;
        Alog.a r32 = new Alog.a(r11.c()).g("main").h(t(r11.d())).q(f23902c).i(r11.e()).k(r11.h() / 2).l(r11.g() / 3).j(r11.f()).c(r11.b()).d(UiType.FLAG_SETTINGS_CARD).e(98304).m(r23).r(r25).n(r27);
        if (r11.j() == false) goto L55;
        Alog.Compress r33 = Alog.Compress.ZSTD;
    L56:
        Alog.a r34 = r32.f(r33);
        if (r11.k() == false) goto L59;
        Alog.SymCrypt r35 = Alog.SymCrypt.TEA_16;
    L60:
        Alog.a r36 = r34.p(r35);
        if (r11.k() == false) goto L63;
        Alog.AsymCrypt r37 = Alog.AsymCrypt.EC_SECP256K1;
    L64:
        f23908i = r36.b(r37).o(r11.i()).a();
        goto L65
    L63:
        r37 = Alog.AsymCrypt.NONE;
        goto L64
    L59:
        r35 = Alog.SymCrypt.NONE;
        goto L60
    L55:
        r33 = Alog.Compress.NONE;
    L65:
        String r38 = r11.b();
        String r113 = r11.e();
        Queue<re.d> r39 = null;
        if (f23905f == null) goto L73;
        Queue<re.d> r40 = f23905f.getCachedLog();
        if (r40 != null) goto L70;
    L72:
        r39 = r40;
        goto L73
    L70:
        if (r40.size() != 0) goto L72;
    L73:
        if (r39 == null) goto L75;
    L81:
        b r41 = new b(r39, r38, r113);
        ScheduledExecutorService r114 = f23907h;
        if (r114 != null) goto L84;
        new Thread(r41, "_ALOG_OPT_").start();
    L85:
        f23904e = true;
        return true;
    L84:
        r114.execute(r41);
        goto L85
    L75:
        if (o().size() > 0) goto L81;
        ScheduledExecutorService r42 = f23907h;
        if (r42 != null) goto L80;
        new Timer("_ALOG_OPT_").schedule(new c(r38, r113), TraceStatsConsts.APP_START_MAX_LIMIT_MS);
        goto L85
    L80:
        r42.schedule(new d(r38, r113), 15, TimeUnit.SECONDS);
        goto L85
    L45:
        r112 = Alog.AsymCrypt.NONE;
        goto L46
    L41:
        r111 = Alog.SymCrypt.NONE;
        goto L42
    L37:
        r110 = Alog.Compress.NONE;
        goto L38
    L30:
        r20 = 32768;
        goto L31
    L26:
        r17 = r11.g();
        goto L27
    L20:
        if (r11.l() == false) goto L23;
        if (r13 == false) goto L23;
        r10 = true;
    L89:
        return false;
    }

    public static void s() {
        if (f23912m != (-1)) goto L6;
        f23912m = Process.myTid();
        return;
    }

    public static int t(int r10) {
        return r10 - 2;
    }

    public static void u(int r10, String r11, String r12) {
        v(r10, r11, r12, null, null, null);
    }

    public static void v(int r10, String r11, String r12, Throwable r13, FormatUtils.TYPE r14, Object r15) {
        s();
        g r16 = g.a();
        r16.f23925a = r10;
        r16.f23926b = r11;
        r16.f23927c = r12;
        r16.f23928d = r13;
        r16.f23929e = r14;
        r16.f23930f = r15;
        r16.f23931g = f23912m;
        r16.f23932h = System.currentTimeMillis();
        Message r17 = Message.obtain();
        r17.what = 1;
        r17.obj = r16;
        f23911l.sendMessage(r17);
    }

    public static void w(String r10, String r11) {
        File r12 = new File(r10);
        int r13 = 0;
        if (r12.exists() == false) goto L9;
        File[] r14 = r12.listFiles(new e());
        if (r14 == null) goto L9;
        int r15 = r14.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L9;
        r14[r16].delete();
        r16 = r16 + 1;
    L9:
        File r17 = new File(r11);
        if (r17.exists() == false) goto L16;
        File[] r18 = r17.listFiles(new f());
        if (r18 == null) goto L19;
        int r19 = r18.length;
    L14:
        if (r13 >= r19) goto L20;
        r18[r13].delete();
        r13 = r13 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void x(boolean r10) {
        f23902c = r10;
        p0.b.g(f23902c);
        Alog r11 = f23908i;
        if (r11 == null) goto L6;
        r11.q(f23902c);
        return;
    }

    public static void y(Queue r10) {
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == true) goto L5;
        return;
    L5:
        p.a(r11.next());
        throw null;
    }
}
