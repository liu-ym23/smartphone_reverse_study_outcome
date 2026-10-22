package fa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.p;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.android.agilelogger.ILogCacheCallback;
import com.obric.android.agilelogger.INativeFuncAddrCallback;
import com.obric.android.agilelogger.utils.FormatUtils;
import com.obric.android.alog.Alog;
import com.obric.capabilitykit.common.UiType;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19548a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static fa.b f19549b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f19550c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Set f19551d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f19552e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile ILogCacheCallback f19553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile List f19554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ScheduledExecutorService f19555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Alog f19556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ArrayList f19557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static ExecutorService f19558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static HandlerThread f19559l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Handler f19560m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f19561n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Object f19562o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ThreadLocal f19563p = null;

    /* JADX INFO: renamed from: fa.a$a, reason: collision with other inner class name */
    public class RunnableC0250a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FormatUtils.TYPE f19565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f19566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f19567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f19568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f19569f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f19570g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f19571h;

        public RunnableC0250a(int r10, FormatUtils.TYPE r11, Throwable r12, String r13, Object r14, String r15, long r16, long r17) {
            this.f19564a = r10;
            this.f19565b = r11;
            this.f19566c = r12;
            this.f19567d = r13;
            this.f19568e = r14;
            this.f19569f = r15;
            this.f19570g = r16;
            this.f19571h = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = a.e(this.f19564a);
            FormatUtils.TYPE r11 = this.f19565b;
            if (r11 == null) goto L5;
            FormatUtils.TYPE r12 = FormatUtils.TYPE.BORDER;
            if (r11 != r12) goto L15;
            FormatUtils.c(r12, this.f19567d);
        L33:
            oa.a.h(r10, this.f19569f, this.f19567d, this.f19570g, this.f19571h);
            return;
        L15:
            FormatUtils.TYPE r13 = FormatUtils.TYPE.JSON;
            if (r11 != r13) goto L18;
            FormatUtils.c(r13, this.f19567d);
            goto L33
        L18:
            FormatUtils.TYPE r14 = FormatUtils.TYPE.BUNDLE;
            if (r11 != r14) goto L21;
            FormatUtils.b(r14, (Bundle) this.f19568e);
            goto L33
        L21:
            FormatUtils.TYPE r15 = FormatUtils.TYPE.INTENT;
            if (r11 != r15) goto L24;
            FormatUtils.a(r15, (Intent) this.f19568e);
            goto L33
        L24:
            FormatUtils.TYPE r16 = FormatUtils.TYPE.THROWABLE;
            if (r11 != r16) goto L27;
            FormatUtils.e(r16, (Throwable) this.f19568e);
            goto L33
        L27:
            FormatUtils.TYPE r17 = FormatUtils.TYPE.THREAD;
            if (r11 != r17) goto L30;
            FormatUtils.d(r17, (Thread) this.f19568e);
            goto L33
        L30:
            FormatUtils.TYPE r18 = FormatUtils.TYPE.STACKTRACE;
            if (r11 != r18) goto L33;
            FormatUtils.f(r18, (StackTraceElement[]) this.f19568e);
            goto L33
        L5:
            if (this.f19566c == null) goto L33;
            if (this.f19567d == null) goto L11;
            StringBuilder r19 = new StringBuilder();
            r19.append(this.f19567d);
            r19.append("\n");
        L11:
            na.c.a(this.f19566c);
            goto L33
        }
    }

    public class b extends ThreadLocal {
        public b() {
        }

        public Long a() {
            return Long.valueOf(Process.myTid());
        }

        @Override // java.lang.ThreadLocal
        public /* bridge */ /* synthetic */ Object initialValue() {
            return a();
        }
    }

    public class c implements ThreadFactory {
        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(r10);
            r11.setName("Alog_newthreadpoolimpl");
            return r11;
        }
    }

    public class d extends Handler {
        public d(Looper r10) {
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
            if ((r12 instanceof j) == false) goto L16;
            a.a((j) r12);
            return;
        L16:
            return;
        L5:
            if (r11 != 2) goto L17;
            oa.a.a();
            return;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Queue f19572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f19573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f19574c;

        public e(Queue r10, String r11, String r12) {
            this.f19572a = r10;
            this.f19573b = r11;
            this.f19574c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            Queue r10 = this.f19572a;
            if (r10 == null) goto L5;
            a.b(r10);
            a.c().notifyCacheLogConsumed();
        L5:
            Iterator r11 = a.j().iterator();
        L7:
            if (r11.hasNext() == false) goto L16;
            INativeFuncAddrCallback r12 = (INativeFuncAddrCallback) r11.next();
            if (r12 == null) goto L7;
            r12.onNativeFuncReady(oa.a.b());
            goto L7
        L16:
            Thread.sleep(TraceStatsConsts.APP_START_MAX_LIMIT_MS);     // Catch: Exception -> L15
        L13:
            a.d(this.f19573b, this.f19574c);
        }
    }

    public class f extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f19576b;

        public f(String r10, String r11) {
            this.f19575a = r10;
            this.f19576b = r11;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.d(this.f19575a, this.f19576b);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f19578b;

        public g(String r10, String r11) {
            this.f19577a = r10;
            this.f19578b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d(this.f19577a, this.f19578b);
        }
    }

    public class h implements FilenameFilter {
        public h() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return r11.startsWith(".logCache_");
        }
    }

    public class i implements FilenameFilter {
        public i() {
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

    public static class j {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Object f19579j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static j f19580k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f19581l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f19583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f19584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f19585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public FormatUtils.TYPE f19586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f19587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f19588g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f19589h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public j f19590i;

        static {
            f19579j = new Object();
        }

        public j() {
            this.f19586e = null;
        }

        public static j a() {
            Object r10 = f19579j;
            monitor-enter(r10);
            j r11 = f19580k;     // Catch: Throwable -> L9
            if (r11 == null) goto L11;
            f19580k = r11.f19590i;     // Catch: Throwable -> L9
            r11.f19590i = null;     // Catch: Throwable -> L9
            f19581l--;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r11;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return new j();
        L9:
            th = move-exception;
            throw th;
        }

        public void b() {
            this.f19583b = null;
            this.f19584c = null;
            this.f19585d = null;
            this.f19586e = null;
            this.f19587f = null;
            this.f19588g = -1;
            this.f19589h = 0;
            this.f19590i = null;
            Object r10 = f19579j;
            monitor-enter(r10);
            int r11 = f19581l;     // Catch: Throwable -> L7
            if (r11 >= 50) goto L9;
            this.f19590i = f19580k;     // Catch: Throwable -> L7
            f19580k = this;     // Catch: Throwable -> L7
            f19581l = r11 + 1;     // Catch: Throwable -> L7
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f19554g = new ArrayList();
        f19555h = null;
        f19556i = null;
        f19557j = new ArrayList();
        f19558k = null;
        f19561n = false;
        f19562o = new Object();
        f19563p = new b();
    }

    public static /* synthetic */ void a(j r10) {
        l(r10);
    }

    public static /* synthetic */ void b(Queue r10) {
        w(r10);
    }

    public static /* synthetic */ ILogCacheCallback c() {
        return f19553f;
    }

    public static /* synthetic */ void d(String r10, String r11) {
        t(r10, r11);
    }

    public static /* synthetic */ int e(int r10) {
        return o(r10);
    }

    public static void f(int r10) {
        f19548a = r10;
        oa.a.j(o(r10));
        Alog r11 = f19556i;
        if (r11 == null) goto L6;
        r11.p(o(r10));
        return;
    }

    public static boolean g(int r10, String r11) {
        if (r10 >= f19548a) goto L5;
        return false;
    L5:
        Set r12 = f19551d;
        if (r12 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return true;
    L10:
        if (r12.contains(r11) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static void h(String r10, String r11) {
        if (g(3, r10) == false) goto L37;
        fa.b r12 = f19549b;
        if (r12 != null) goto L7;
    L12:
        fa.b r13 = f19549b;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = fa.e.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = f19556i;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.j(r10, r11);
        return;
    L35:
        oa.a.c(r10, r11);
        return;
    L28:
        if (f19560m == null) goto L31;
        p(3, r10, r11);
        return;
    L23:
        if (f19558k == null) goto L26;
        r(3, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (f19560m == null) goto L20;
        p(3, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (f19558k == null) goto L12;
        r(3, r10, r11);
        return;
    }

    public static void i(String r10, String r11) {
        if (g(6, r10) == false) goto L37;
        fa.b r12 = f19549b;
        if (r12 != null) goto L7;
    L12:
        fa.b r13 = f19549b;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = fa.e.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = f19556i;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.k(r10, r11);
        return;
    L35:
        oa.a.d(r10, r11);
        return;
    L28:
        if (f19560m == null) goto L31;
        p(6, r10, r11);
        return;
    L23:
        if (f19558k == null) goto L26;
        r(6, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (f19560m == null) goto L20;
        p(6, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (f19558k == null) goto L12;
        r(6, r10, r11);
        return;
    }

    public static List j() {
        return f19554g;
    }

    public static long k() {
        return ((Long) f19563p.get()).longValue();
    }

    public static void l(j r10) {
        int r11 = o(r10.f19582a);
        FormatUtils.TYPE r12 = r10.f19586e;
        String r13 = "";
        if (r12 == null) goto L5;
        FormatUtils.TYPE r14 = FormatUtils.TYPE.BORDER;
        if (r12 != r14) goto L16;
        String r15 = FormatUtils.c(r14, r10.f19584c);
    L7:
        String r16 = r15;
    L35:
        oa.a.h(r11, r10.f19583b, r16, r10.f19588g, r10.f19589h);
        r10.b();
        return;
    L16:
        FormatUtils.TYPE r17 = FormatUtils.TYPE.JSON;
        if (r12 != r17) goto L19;
        r15 = FormatUtils.c(r17, r10.f19584c);
        goto L7
    L19:
        FormatUtils.TYPE r18 = FormatUtils.TYPE.BUNDLE;
        if (r12 != r18) goto L22;
        r15 = FormatUtils.b(r18, (Bundle) r10.f19587f);
        goto L7
    L22:
        FormatUtils.TYPE r19 = FormatUtils.TYPE.INTENT;
        if (r12 != r19) goto L25;
        r15 = FormatUtils.a(r19, (Intent) r10.f19587f);
        goto L7
    L25:
        FormatUtils.TYPE r20 = FormatUtils.TYPE.THROWABLE;
        if (r12 != r20) goto L28;
        r15 = FormatUtils.e(r20, (Throwable) r10.f19587f);
        goto L7
    L28:
        FormatUtils.TYPE r21 = FormatUtils.TYPE.THREAD;
        if (r12 != r21) goto L31;
        r15 = FormatUtils.d(r21, (Thread) r10.f19587f);
        goto L7
    L31:
        FormatUtils.TYPE r22 = FormatUtils.TYPE.STACKTRACE;
        if (r12 != r22) goto L34;
        r15 = FormatUtils.f(r22, (StackTraceElement[]) r10.f19587f);
        goto L7
    L34:
        r16 = "";
        goto L35
    L5:
        if (r10.f19585d != null) goto L9;
        r15 = r10.f19584c;
        goto L7
    L9:
        if (r10.f19584c == null) goto L12;
        r13 = r10.f19584c + "\n";
    L12:
        r15 = r13 + na.c.a(r10.f19585d);
        goto L7
    }

    public static void m(String r10, String r11) {
        if (g(4, r10) == false) goto L37;
        fa.b r12 = f19549b;
        if (r12 != null) goto L7;
    L12:
        fa.b r13 = f19549b;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = fa.e.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = f19556i;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.n(r10, r11);
        return;
    L35:
        oa.a.e(r10, r11);
        return;
    L28:
        if (f19560m == null) goto L31;
        p(4, r10, r11);
        return;
    L23:
        if (f19558k == null) goto L26;
        r(4, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (f19560m == null) goto L20;
        p(4, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (f19558k == null) goto L12;
        r(4, r10, r11);
        return;
    }

    public static boolean n(fa.b r12) {
        boolean r10 = false;
        if (r12 != null) goto L5;
        return false;
    L5:
        f19549b = r12;
        Alog.o(new fa.c());     // Catch: Throwable -> L95
        Object r11 = f19562o;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L10:
        if (f19561n == false) goto L15;
        monitor-exit(r11);     // Catch: Throwable -> L13
        return false;
    L15:
        f19561n = true;     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        f19548a = r12.f();
        boolean r13 = fa.e.b(r12.e());
        boolean r14 = r12.q();
        if (r14 == false) goto L20;
    L23:
        boolean r15 = r12.a();
        boolean r16 = r12.p();
        if (r13 == true) goto L26;
        r12.C((int) (r12.i() * r12.l()));
    L26:
        Alog.a r17 = new Alog.a(r12.e()).g("default").h(o(r12.f())).q(f19550c).i(r12.g()).k(r12.j());
        if (r10 == false) goto L29;
        int r18 = (r12.i() / 3) * 2;
    L30:
        Alog.a r19 = r17.l(r18).j(r12.h()).c(r12.c());
        if (r13 == false) goto L33;
        int r20 = r12.d() * 1024;
    L34:
        Alog.a r21 = r19.d(r20);
        if (r13 == false) goto L37;
        int r22 = r12.d() * 3072;
    L38:
        Alog.a r23 = r21.e(r22);
        Alog.Mode r24 = Alog.Mode.SAFE;
        Alog.a r25 = r23.m(r24);
        Alog.TimeFormat r26 = Alog.TimeFormat.RAW;
        Alog.a r27 = r25.r(r26);
        Alog.PrefixFormat r110 = Alog.PrefixFormat.LEGACY;
        Alog.a r28 = r27.n(r110);
        if (r12.m() == false) goto L41;
        Alog.Compress r111 = Alog.Compress.ZSTD;
    L42:
        Alog.a r29 = r28.f(r111);
        if (r12.n() == false) goto L45;
        Alog.SymCrypt r112 = Alog.SymCrypt.TEA_16;
    L46:
        Alog.a r30 = r29.p(r112);
        if (r12.n() == false) goto L49;
        Alog.AsymCrypt r113 = Alog.AsymCrypt.EC_SECP256K1;
    L50:
        oa.a.i(r30.b(r113).o(r12.k()).a());
        if (r14 == false) goto L57;
        if (r15 == true) goto L54;
        if (r13 == false) goto L57;
    L54:
        if (r16 == false) goto L56;
        f19558k = Executors.newSingleThreadExecutor(new c());
        goto L57
    L56:
        HandlerThread r31 = new HandlerThread("Alog_main_delegate");
        f19559l = r31;
        r31.start();
        f19560m = new d(f19559l.getLooper());
    L57:
        if (r10 == false) goto L71;
        Alog.a r32 = new Alog.a(r12.e()).g("main").h(o(r12.f())).q(f19550c).i(r12.g()).k(r12.j() / 2).l(r12.i() / 3).j(r12.h()).c(r12.c()).d(UiType.FLAG_SETTINGS_CARD).e(98304).m(r24).r(r26).n(r110);
        if (r12.m() == false) goto L61;
        Alog.Compress r33 = Alog.Compress.ZSTD;
    L62:
        Alog.a r34 = r32.f(r33);
        if (r12.n() == false) goto L65;
        Alog.SymCrypt r35 = Alog.SymCrypt.TEA_16;
    L66:
        Alog.a r36 = r34.p(r35);
        if (r12.n() == false) goto L69;
        Alog.AsymCrypt r37 = Alog.AsymCrypt.EC_SECP256K1;
    L70:
        f19556i = r36.b(r37).o(r12.k()).a();
        goto L71
    L69:
        r37 = Alog.AsymCrypt.NONE;
        goto L70
    L65:
        r35 = Alog.SymCrypt.NONE;
        goto L66
    L61:
        r33 = Alog.Compress.NONE;
    L71:
        String r38 = r12.c();
        String r114 = r12.g();
        Queue<fa.d> r39 = null;
        if (f19553f == null) goto L79;
        Queue<fa.d> r40 = f19553f.getCachedLog();
        if (r40 != null) goto L76;
    L78:
        r39 = r40;
        goto L79
    L76:
        if (r40.size() != 0) goto L78;
    L79:
        if (r39 == null) goto L81;
    L87:
        e r41 = new e(r39, r38, r114);
        ScheduledExecutorService r115 = f19555h;
        if (r115 != null) goto L90;
        new Thread(r41, "_ALOG_OPT_").start();
    L91:
        f19552e = true;
        return true;
    L90:
        r115.execute(r41);
        goto L91
    L81:
        if (j().size() > 0) goto L87;
        ScheduledExecutorService r42 = f19555h;
        if (r42 != null) goto L86;
        new Timer("_ALOG_OPT_").schedule(new f(r38, r114), TraceStatsConsts.APP_START_MAX_LIMIT_MS);
        goto L91
    L86:
        r42.schedule(new g(r38, r114), 15, TimeUnit.SECONDS);
        goto L91
    L49:
        r113 = Alog.AsymCrypt.NONE;
        goto L50
    L45:
        r112 = Alog.SymCrypt.NONE;
        goto L46
    L41:
        r111 = Alog.Compress.NONE;
        goto L42
    L37:
        r22 = 65536;
        goto L38
    L33:
        r20 = 32768;
        goto L34
    L29:
        r18 = r12.i();
        goto L30
    L20:
        if (r12.o() == false) goto L23;
        if (r13 == false) goto L23;
        r10 = true;
    L95:
        return false;
    }

    public static int o(int r10) {
        return r10 - 2;
    }

    public static void p(int r10, String r11, String r12) {
        q(r10, r11, r12, null, null, null);
    }

    public static void q(int r10, String r11, String r12, Throwable r13, FormatUtils.TYPE r14, Object r15) {
        j r16 = j.a();
        r16.f19582a = r10;
        r16.f19583b = r11;
        r16.f19584c = r12;
        r16.f19585d = r13;
        r16.f19586e = r14;
        r16.f19587f = r15;
        r16.f19588g = k();
        r16.f19589h = System.currentTimeMillis();
        Message r17 = Message.obtain();
        r17.what = 1;
        r17.obj = r16;
        f19560m.sendMessage(r17);
    }

    public static void r(int r10, String r11, String r12) {
        s(r10, r11, r12, null, null, null);
    }

    public static void s(int r13, String r14, String r15, Throwable r16, FormatUtils.TYPE r17, Object r18) {
        long r10 = k();
        long r11 = System.currentTimeMillis();
        f19558k.execute(new RunnableC0250a(r13, r17, r16, r15, r18, r14, r10, r11));
    }

    public static void t(String r10, String r11) {
        File r12 = new File(r10);
        int r13 = 0;
        if (r12.exists() == false) goto L9;
        File[] r14 = r12.listFiles(new h());
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
        File[] r18 = r17.listFiles(new i());
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

    public static void u(String r10, String r11) {
        if (g(2, r10) == false) goto L37;
        fa.b r12 = f19549b;
        if (r12 != null) goto L7;
    L12:
        fa.b r13 = f19549b;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = fa.e.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = f19556i;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.q(r10, r11);
        return;
    L35:
        oa.a.f(r10, r11);
        return;
    L28:
        if (f19560m == null) goto L31;
        p(2, r10, r11);
        return;
    L23:
        if (f19558k == null) goto L26;
        r(2, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (f19560m == null) goto L20;
        p(2, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (f19558k == null) goto L12;
        r(2, r10, r11);
        return;
    }

    public static void v(String r10, String r11) {
        if (g(5, r10) == false) goto L37;
        fa.b r12 = f19549b;
        if (r12 != null) goto L7;
    L12:
        fa.b r13 = f19549b;
        if (r13 != null) goto L15;
    L20:
        boolean r14 = fa.e.c();
        if (r14 == true) goto L23;
    L26:
        if (r14 == true) goto L28;
    L31:
        Alog r15 = f19556i;
        if (r15 == null) goto L35;
        if (r14 == false) goto L35;
        r15.r(r10, r11);
        return;
    L35:
        oa.a.g(r10, r11);
        return;
    L28:
        if (f19560m == null) goto L31;
        p(5, r10, r11);
        return;
    L23:
        if (f19558k == null) goto L26;
        r(5, r10, r11);
        return;
    L15:
        if (r13.b() == false) goto L20;
        if (f19560m == null) goto L20;
        p(5, r10, r11);
        return;
    L7:
        if (r12.b() == false) goto L12;
        if (f19558k == null) goto L12;
        r(5, r10, r11);
        return;
    }

    public static void w(Queue r10) {
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == true) goto L5;
        return;
    L5:
        p.a(r11.next());
        throw null;
    }
}
