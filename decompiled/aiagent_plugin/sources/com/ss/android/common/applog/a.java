package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLog.java */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class a {
    static volatile g A = null;
    static final SimpleDateFormat B = null;
    public static int C = 0;
    static volatile boolean D = false;
    static volatile aa E = null;
    private static volatile boolean F = false;
    private static boolean G = false;
    private static volatile String H = null;
    private static long I = -1;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static int f37110J = -1;
    private static volatile boolean K = false;
    private static boolean L = false;
    private static String P = null;
    private static volatile int Q = 0;
    private static volatile com.ss.android.common.applog.a.a R = null;
    private static volatile com.ss.android.common.applog.a.a S = null;
    private static volatile AtomicInteger T = null;
    private static final String TAG = "AppLog";
    private static volatile boolean U;
    private static volatile boolean V;
    private static volatile boolean W;
    private static volatile boolean X;
    private static volatile boolean Y;
    private static volatile boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile com.ss.android.common.applog.j f37111a;
    private static boolean aU;
    private static com.ss.android.common.a aV;
    private static volatile boolean aW;
    private static volatile boolean aX;
    private static volatile f aY;
    private static volatile long aZ;
    private static volatile long aa;
    private static volatile int ab;
    private static volatile com.bytedance.applog.m ac;
    private static long ad;
    private static volatile boolean ae;
    private static volatile boolean af;
    private static boolean ag;
    private static com.ss.android.common.applog.l ah;
    private static boolean ai;
    private static boolean aj;
    private static boolean ak;
    private static boolean al;
    private static boolean am;
    private static boolean an;
    private static volatile boolean ao;
    private static ae ap;
    private static final Object aq = null;
    private static volatile a ar;
    private static volatile JSONObject as;
    private static volatile Integer at;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile com.service.middleware.applog.a f37112b;
    private static final ConcurrentHashMap<String, String> bd = null;
    private static final Bundle be = null;
    private static final SimpleDateFormat bh = null;
    private static final SimpleDateFormat bi = null;
    private static final SimpleDateFormat bj = null;
    private static final Object bk = null;
    private static final ThreadLocal<Boolean> bl = null;
    private static WeakReference<d> bn;
    private static volatile boolean bo;
    private static volatile boolean bp;
    private static long bq;
    private static long br;
    private static volatile boolean bs;
    private static volatile boolean bt;
    private static volatile IBDAccountCallback bu;
    private static volatile boolean bv;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile com.bytedance.applog.sampling.c f37113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile long f37114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile int f37115e;
    protected static volatile boolean f;
    protected static volatile af g;
    static final AtomicLong h = null;
    public static final String[] i = null;
    public static volatile int j;
    static volatile boolean k;
    public static AtomicLong l;
    static volatile long m;
    static volatile int n;
    static volatile int o;
    static volatile int p;
    static String q;
    static final List<j> r = null;
    static i s;
    static h t;
    static String u;
    static int z;
    private int M;
    private boolean N;
    private boolean O;
    private boolean aA;
    private boolean aB;
    private final HashSet<Integer> aC;
    private String aD;
    private volatile boolean aE;
    private final AtomicBoolean aF;
    private x aG;
    private long aH;
    private long aI;
    private volatile long aJ;
    private int aK;
    private int aL;
    private JSONObject aM;
    private AtomicInteger aN;
    private AtomicInteger aO;
    private LinkedList<k> aP;
    private long aQ;
    private volatile long aR;
    private volatile long aS;
    private volatile boolean aT;
    private int au;
    private final com.bytedance.common.utility.a av;
    private long aw;
    private final Context ax;
    private final JSONObject ay;
    private boolean az;
    private final ConcurrentHashMap<String, String> ba;
    private final ConcurrentHashMap<String, String> bb;
    private final ConcurrentHashMap<String, String> bc;
    private final AtomicLong bf;
    private final AtomicLong bg;
    private volatile long bm;
    volatile boolean v;
    final LinkedList<C1015a> w;
    final LinkedList<t> x;
    volatile w y;

    /* JADX INFO: renamed from: com.ss.android.common.applog.a$5, reason: invalid class name */
    /* JADX INFO: compiled from: AppLog.java */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37125a = null;

        static {
            int[] r0 = new int[b.values().length];
            f37125a = r0;
            r0[b.f37133c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L64:
            f37125a[b.j.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L48:
            f37125a[b.f37131a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L60:
            f37125a[b.f37132b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L66:
            f37125a[b.f37134d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L50:
            f37125a[b.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L54:
            f37125a[b.f37135e.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L78:
            f37125a[b.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L44:
            f37125a[b.h.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L70:
            f37125a[b.i.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L74:
            f37125a[b.l.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L56:
            f37125a[b.k.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L62:
            f37125a[b.m.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L46:
            f37125a[b.n.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L52:
            f37125a[b.o.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L76:
            f37125a[b.p.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L42:
            f37125a[b.q.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L68:
            f37125a[b.r.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L72:
            f37125a[b.s.ordinal()] = 19;     // Catch: NoSuchFieldError -> L41
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.common.applog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppLog.java */
    static class C1015a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f37126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f37127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f37128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f37129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CountDownLatch f37130e;

        public C1015a(b r1) {
            this.f37126a = r1;
        }
    }

    /* JADX INFO: compiled from: AppLog.java */
    static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f37131a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f37132b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f37133c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f37134d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f37135e = null;
        public static final b f = null;
        public static final b g = null;
        public static final b h = null;
        public static final b i = null;
        public static final b j = null;
        public static final b k = null;
        public static final b l = null;
        public static final b m = null;
        public static final b n = null;
        public static final b o = null;
        public static final b p = null;
        public static final b q = null;
        public static final b r = null;
        public static final b s = null;
        private static final /* synthetic */ b[] u = null;
        final int t;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(u.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("PAGE_START", 0, 0);
            f37131a = r0;
            b r1 = new b("PAGE_END", 1, 1);
            f37132b = r1;
            b r3 = new b("EVENT", 2, 2);
            f37133c = r3;
            b r5 = new b("IMAGE_SAMPLE", 3, 3);
            f37134d = r5;
            b r7 = new b("CONFIG_UPDATE", 4, 4);
            f37135e = r7;
            b r9 = new b("API_SAMPLE", 5, 5);
            f = r9;
            b r11 = new b("UA_UPDATE", 6, 6);
            g = r11;
            b r13 = new b("SAVE_ANR_TAG", 7, 7);
            h = r13;
            b r15 = new b("SAVE_DNS_REPORT", 8, 8);
            i = r15;
            b r14 = new b("SAVE_MISC_LOG", 9, 9);
            j = r14;
            b r12 = new b("DEVICE_ID_UPDATE", 10, 10);
            k = r12;
            b r10 = new b("CUSTOMER_HEADER_UPDATE", 11, 11);
            l = r10;
            b r8 = new b("UPDATE_GOOGLE_AID", 12, 12);
            m = r8;
            b r6 = new b("UPDATE_APP_LANGUAGE_REGION", 13, 13);
            n = r6;
            b r4 = new b("CLEAR_WHEN_SWITCH_CHILD_MODE", 14, 14);
            o = r4;
            b r2 = new b("RESET_WHEN_SWITCH_CHILD_MODE", 15, 15);
            p = r2;
            b r16 = new b("FLUSH_EVENT", 16, 16);
            q = r16;
            b r17 = new b("UPDATE_USER_UNIQUE_ID", 17, 17);
            r = r17;
            b r18 = new b("DELAY_START_LOG_REAPER", 18, 18);
            s = r18;
            u = new b[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.t = r3;
        }
    }

    /* JADX INFO: compiled from: AppLog.java */
    private class c extends Thread implements com.ss.android.deviceregister.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f37136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37137b;

        public c(a r1) {
            this.f37136a = r1;
            super("ActionReaper");
            this.f37137b = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a();
            if (a.a(this.f37136a) == true) goto L6;
            com.ss.android.common.util.e.e("AppLog can not setup LogReaper");
            return;
        L6:
            a.b(this.f37136a);
            this.f37136a.t();
        L7:
            C1015a r0 = null;
            LinkedList<C1015a> r1 = this.f37136a.w;
            monitor-enter(r1);
        L36:
            th = move-exception;
            throw th;
        L10:
            if (a.k == true) goto L11;
            if (this.f37136a.w.isEmpty() == true) goto L41;
            r0 = (C1015a) ZeusTransformUtils.preCheckCast(this.f37136a.w.poll(), C1015a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L36
            if (r0 == null) goto L33;
            this.f37136a.b(r0);
            this.f37137b = true;
        L35:
            this.f37136a.a(true, false);
            goto L7
        L33:
            if (this.f37137b == false) goto L35;
            this.f37137b = false;
            this.f37136a.t();
            goto L35
        L41:
            if (this.f37137b == false) goto L18;
            this.f37136a.w.wait(this.f37136a.j());     // Catch: InterruptedException -> L39 Throwable -> L36
            goto L20
        L18:
            this.f37136a.w.wait();     // Catch: InterruptedException -> L39 Throwable -> L36
        L20:
            if (a.k == true) goto L21;
            if (this.f37136a.w.isEmpty() == true) goto L28;
            r0 = (C1015a) ZeusTransformUtils.preCheckCast(this.f37136a.w.poll(), C1015a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            goto L28
        L21:
            monitor-exit(r1);     // Catch: Throwable -> L36
        L22:
            com.ss.android.common.util.e.b("AppLog ActionReadper quit");
            return;
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L36
            goto L22
        }

        private void a() {
            com.ss.android.deviceregister.g.a(this);
        }

        @Override // com.ss.android.deviceregister.g.a
        public void a(final String r4, final String r5) {
            C1015a r0 = new C1015a(b.k);
            JSONObject r1 = new JSONObject();
            r1.put("device_id", r4);     // Catch: JSONException -> L5
            r1.put("install_id", r5);     // Catch: JSONException -> L5
            r0.f37127b = r1;     // Catch: JSONException -> L5
        L7:
            this.f37136a.a(r0);
            a.a(this.f37136a, true);
            if (com.bytedance.applog.log.l.a() == true) goto L13;
            com.bytedance.applog.log.l.a("device_register_end", new AnonymousClass1(this, r4, r5));
            return;
        L13:
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        @Override // com.ss.android.deviceregister.g.a
        public void a(boolean r3, boolean r4) {
            if (a.c(this.f37136a) == false) goto L6;
            a.a(this.f37136a, false);
            return;
        L6:
            if (r3 == true) goto L8;
            return;
        L8:
            if (a.O() == false) goto L12;
            a.a(this.f37136a, false, true, r4);
            return;
        }

        @Override // com.ss.android.deviceregister.g.a
        public void a(boolean r4) {
            monitor-enter(a.class);
            a.a(true);     // Catch: Throwable -> L13
            if (a.P() == false) goto L8;
            a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.d(this.f37136a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        L8:
            monitor-exit(a.class);     // Catch: Throwable -> L13
            if (com.bytedance.applog.log.l.a() == true) goto L18;
            com.bytedance.applog.log.l.a("local_did_load", new AnonymousClass2(this));
            return;
        L18:
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: AppLog.java */
    public interface d {
        void a();

        void a(boolean r1);
    }

    /* JADX INFO: compiled from: AppLog.java */
    public interface e extends d {
        void a(JSONObject r1);
    }

    /* JADX INFO: compiled from: AppLog.java */
    public interface f {
        JSONObject a();
    }

    /* JADX INFO: compiled from: AppLog.java */
    public interface g {
        String a(String r1);
    }

    /* JADX INFO: compiled from: AppLog.java */
    public interface h extends com.ss.android.deviceregister.base.i {
    }

    /* JADX INFO: compiled from: AppLog.java */
    public interface i {
        boolean a();

        boolean b();

        boolean c();
    }

    /* JADX INFO: compiled from: AppLog.java */
    public interface j {
        void a(long r1);

        void a(long r1, String r3, JSONObject r4);

        void b(long r1, String r3, JSONObject r4);
    }

    /* JADX INFO: compiled from: AppLog.java */
    static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f37143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f37144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f37145d;

        public k(String r1, int r2, long r3, long r5) {
            this.f37142a = r1;
            this.f37143b = r2;
            this.f37144c = r3;
            this.f37145d = r5;
        }
    }

    /* JADX INFO: compiled from: AppLog.java */
    private static class l implements com.ss.android.common.applog.l {
        private l() {
        }

        /* synthetic */ l(AnonymousClass1 r1) {
            this();
        }

        @Override // com.ss.android.common.applog.l
        public String a() {
            return String.valueOf(a.l.get());
        }

        @Override // com.ss.android.common.applog.l
        public String b() {
            if (a.Q() != null) goto L5;
            return null;
        L5:
            return com.ss.android.deviceregister.g.i();
        }

        @Override // com.ss.android.common.applog.l
        public boolean a(String r1) {
            return y.a(r1);
        }

        @Override // com.ss.android.common.applog.l
        public void a(Context r13, String r14, String r15, String r16, long r17, long r19, boolean r21, JSONObject r22) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
            a r1 = a.Q();
            if (r1 != null) goto L7;
            com.ss.android.common.applog.b.a().a(r14, r15, r16, r17, r19, r21, r22);
            com.ss.android.common.util.e.d("AppLog null context when onEvent");
            return;
        L7:
            if (com.bytedance.common.utility.j.a(r14) == false) goto L9;
        L14:
            LogTrace.a(1, 0, null);
            return;
        L9:
            if (com.bytedance.common.utility.j.a(r15) == true) goto L14;
            if (r1 == null) goto L16;
            r1.a(r14, r15, r16, r17, r19, r21, r22);
            return;
        }

        @Override // com.ss.android.common.applog.l
        public String c() {
            a r1 = a.Q();
            if (r1 != null) goto L5;
            return null;
        L5:
            if (a.e(r1) != null) goto L7;
            return null;
        L7:
            return a.e(r1).f37251b;
        }

        @Override // com.ss.android.common.applog.l
        public a a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            a.a(r2, com.ss.android.deviceregister.base.v.d());
            Object r4 = a.R();
            monitor-enter(r4);
            AnonymousClass1 r1 = null;
            if (a.k == false) goto L9;
            monitor-exit(r4);     // Catch: Throwable -> L16
            return null;
        L9:
            if (a.Q() != null) goto L13;
            a.f(new a(r2, r1));     // Catch: Throwable -> L16
            if (Logger.debug() == false) goto L13;
            com.ss.android.common.util.e.b("Process AppLog = " + a.Q().toString() + " pid = " + Process.myPid());     // Catch: Throwable -> L16
        L13:
            monitor-exit(r4);     // Catch: Throwable -> L16
            return a.Q();
        L16:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.common.applog.l
        public JSONObject d() {
            return a.S();
        }

        @Override // com.ss.android.common.applog.l
        public JSONObject e() {
            a r0 = a.Q();
            if (r0 != null) goto L5;
            return null;
        L5:
            return a.g(r0);
        }

        @Override // com.ss.android.common.applog.l
        public String f() {
            g r3 = a.A;
            if (r3 == null) goto L10;
            long r0 = a.l.get();
            IBDAccountCallback r2 = a.T();
            if (r2 == null) goto L8;
            r0 = ((Long) ZeusTransformUtils.preCheckCast(r2.getOdinUserInfo().second, Long.class, "com.obric.aiagent.plugin")).longValue();
        L8:
            return r3.a(String.valueOf(r0));
        L10:
            return a.U();
        }

        @Override // com.ss.android.common.applog.l
        public void a(com.service.middleware.applog.a r2) {
            a.f37112b = (com.service.middleware.applog.a) ZeusTransformUtils.wrapperContextForParams(r2, com.service.middleware.applog.a.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.common.applog.l
        public com.service.middleware.applog.a g() {
            return a.f37112b;
        }

        @Override // com.ss.android.common.applog.l
        public String h() {
            return com.ss.android.deviceregister.g.d();
        }

        @Override // com.ss.android.common.applog.l
        public String i() {
            return a.V();
        }

        @Override // com.ss.android.common.applog.l
        public com.bytedance.applog.m j() {
            return a.W();
        }
    }

    static boolean c(long r2) {
        if (r2 >= 10000) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 300000) goto L7;
        return true;
    }

    /* synthetic */ a(Context r2, AnonymousClass1 r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ boolean O() {
        return aW;
    }

    static /* synthetic */ boolean P() {
        return bp;
    }

    static /* synthetic */ a Q() {
        return ar;
    }

    static /* synthetic */ Object R() {
        return aq;
    }

    static /* synthetic */ JSONObject S() {
        return as;
    }

    static /* synthetic */ IBDAccountCallback T() {
        return bu;
    }

    static /* synthetic */ String U() {
        return H;
    }

    static /* synthetic */ String V() {
        return P;
    }

    static /* synthetic */ com.bytedance.applog.m W() {
        return ac;
    }

    static /* synthetic */ void a(a r0, boolean r1, boolean r2, boolean r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.aa();
    }

    static /* synthetic */ boolean a(a r0, String r1) {
        return r0.f(r1);
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.O = r1;
        return r1;
    }

    static /* synthetic */ boolean a(boolean r0) {
        bo = r0;
        return r0;
    }

    static /* synthetic */ void b(Context r2) {
        d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void b(a r0) {
        r0.Y();
    }

    static /* synthetic */ boolean c(a r0) {
        return r0.O;
    }

    static /* synthetic */ Context d(a r0) {
        return r0.ax;
    }

    static /* synthetic */ x e(a r0) {
        return r0.aG;
    }

    static /* synthetic */ a f(a r0) {
        ar = r0;
        return r0;
    }

    static /* synthetic */ JSONObject g(a r0) {
        return r0.aM;
    }

    static {
        T = new AtomicInteger(0);
        U = false;
        V = false;
        W = true;
        f37114d = 432000000;
        f37115e = 10;
        X = false;
        Y = false;
        Z = true;
        ab = -1;
        ae = true;
        af = false;
        f = false;
        ag = false;
        h = new AtomicLong(System.currentTimeMillis());
        ah = new l(null);
        ai = true;
        aj = true;
        ak = true;
        al = true;
        am = true;
        an = false;
        ao = false;
        i = new String[]{"klink_egdi", "appkey", "openudid", "sdk_version", "package", "channel", "display_name", WsConstants.KEY_APP_VERSION, "version_code", "timezone", "access", RomInfo.KEY_OS_TYPE, RomInfo.KEY_ROM_OS_VERSION, RomInfo.KEY_ROM_OS_API, HardwareInfo.KEY_HW_VENDOR_MODEL, HardwareInfo.KEY_HW_VENDOR_BRAND, HardwareInfo.KEY_HW_VENDOR_MANUFACTURER, "language", HardwareInfo.KEY_HW_DISPLAY_RESOLUTION, HardwareInfo.KEY_HW_DISPLAY_DENSITY, HardwareInfo.KEY_HW_DENSITY_DPI, "carrier", "mcc_mnc", "clientudid", "install_id", "device_id", "sig_hash", WsConstants.KEY_APP_ID, "push_sdk", "rom", "release_build", "update_version_code", "manifest_version_code", "app_version_minor", HardwareInfo.KEY_HW_CPU_ABI, "app_track", "not_request_sender", "rom_version", "region", "tz_name", "tz_offset", "sim_region", MonitorConstants.CUSTOM, "google_aid", "app_language", "app_region", "device_category", "ab_sdk_version", "user_unique_id", WsConstants.KEY_PLATFORM, "harmony_os_api", "harmony_os_version", "harmony_release_type", "cdid", "sys_region", "carrier_region", "timezone_offset", "timezone_name"};
        j = DownloadErrorCode.ERROR_CRONET_ERROR_BASE;
        aq = new Object();
        k = false;
        l = new AtomicLong();
        m = 0;
        n = 0;
        o = 0;
        p = 0;
        q = "";
        r = new ArrayList(2);
        u = null;
        as = null;
        aU = false;
        z = 0;
        bd = new ConcurrentHashMap();
        be = new Bundle();
        B = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        bh = ad.a("yyyy-MM-dd HH:mm:ss");
        bi = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        bj = ad.a("yyyy-MM-dd");
        bk = new Object();
        bl = new ThreadLocal();
        bn = null;
        bo = false;
        bp = false;
        bq = 0;
        br = -1;
        bs = false;
        D = false;
        bt = false;
        bv = false;
    }

    public static boolean a() {
        if (ab >= 0) goto L6;
        com.ss.android.common.util.e.d("AppLog SwitchToBdtracker has not been set!");
    L6:
        if (ab <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static long b() {
        return I;
    }

    public static boolean c() {
        return af;
    }

    static String[] d() {
        return ap.f37154e;
    }

    static String[] e() {
        return ap.f37152c;
    }

    static String f() {
        return ap.f37153d;
    }

    static String g() {
        return ap.i;
    }

    static String[] h() {
        return ap.f;
    }

    public static SimpleDateFormat i() {
        return bj;
    }

    public long j() {
        if (ag == false) goto L6;
        return 500;
    L6:
        return this.aH;
    }

    public static int k() {
        return com.ss.android.deviceregister.g.l();
    }

    public static String l() {
        return ah.a();
    }

    @Deprecated
    public static String m() {
        return ah.b();
    }

    public static boolean a(String r1) {
        return ah.a(r1);
    }

    static boolean n() {
        i r0 = s;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a();
    }

    static boolean o() {
        i r0 = s;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.b();
    }

    static boolean p() {
        i r0 = s;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.c();
    }

    public static void a(Context r12, String r13, String r14, String r15, long r16, long r18, boolean r20, JSONObject r21) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        b(r21);
        ah.a(r2, r13, r14, r15, r16, r18, r20, r21);
    }

    public static String q() {
        return ah.c();
    }

    private static void b(JSONObject r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.has("ab_sdk_version") == true) goto L15;
        String r1 = B();
        if (TextUtils.isEmpty(r1) == true) goto L16;
        r3.put("ab_sdk_version", r1);     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    }

    public static void a(Context r11, String r12, String r13, String r14, long r15, long r17, JSONObject r19) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), r12, r13, r14, r15, r17, false, r19);
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return ah.a(r3);
    }

    private boolean a(JSONObject r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L24
        if (ai == false) goto L7;
        r0.put(1);     // Catch: Exception -> L24
    L7:
        if (aj == false) goto L10;
        r0.put(2);     // Catch: Exception -> L24
    L10:
        if (ak == false) goto L13;
        r0.put(7);     // Catch: Exception -> L24
    L13:
        if (al == false) goto L16;
        r0.put(8);     // Catch: Exception -> L24
    L16:
        if (am == false) goto L18;
        r0.put(9);     // Catch: Exception -> L24
    L18:
        r3.put("push_sdk", r0);     // Catch: Exception -> L24
        String r1 = E();     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r1) == true) goto L21;
        r3.put("user_unique_id", r1);     // Catch: Exception -> L24
    L21:
        c(r3);     // Catch: Exception -> L24
    L23:
        return com.ss.android.deviceregister.g.a(r5, r3, K);
    }

    private void c(JSONObject r4) {
        boolean r0 = com.ss.android.deviceregister.c.e.w();
        if (r0 == false) goto L6;
        String r2 = "Harmony";
    L18:
        r4.put(WsConstants.KEY_PLATFORM, r2);     // Catch: JSONException -> L9
    L11:
        if (r0 == true) goto L20;
        return;
    L20:
        r4.put("harmony_os_api", com.bytedance.bdinstall.j.u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r4.put("harmony_os_version", com.bytedance.bdinstall.j.u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r4.put("harmony_release_type", com.bytedance.bdinstall.j.u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        com.ss.android.common.util.e.d("AppLog loadHarmonyInfo ", th);
        return;
    L9:
        e = move-exception;
        com.ss.android.common.util.e.e("AppLog loadHarmonyInfo ", e);
        goto L11
    L6:
        r2 = "Android";
        goto L18
    }

    public static String a(long r2) {
        return B.format(new Date(r2));
    }

    private void c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        z();
        X();
        boolean r1 = false;
        if (this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).getInt("forbid_report_phone_detail_info", 0) <= 0) goto L5;
        r1 = true;
    L5:
        this.N = r1;
        if (F() <= 0) goto L9;
        f37113c = com.bytedance.applog.sampling.d.a(this.ax, null);
        return;
    }

    private a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        this.N = false;
        this.O = false;
        this.au = 1;
        this.v = false;
        this.w = new LinkedList();
        this.x = new LinkedList();
        this.y = null;
        this.aw = 0;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = new HashSet();
        this.aD = "";
        this.aE = false;
        this.aF = new AtomicBoolean();
        this.aH = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.aI = 60000;
        this.aJ = 21600000;
        this.aK = 1;
        this.aL = 0;
        this.aM = null;
        this.aN = new AtomicInteger();
        this.aO = new AtomicInteger();
        this.aP = new LinkedList();
        this.aQ = System.currentTimeMillis();
        this.aR = 0;
        this.aS = 0;
        this.aT = false;
        this.ba = new ConcurrentHashMap();
        this.bb = new ConcurrentHashMap();
        this.bc = new ConcurrentHashMap();
        this.bf = new AtomicLong();
        this.bg = new AtomicLong();
        com.ss.android.deviceregister.g.a("2.14.0");
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.ax = r0;
        com.ss.android.deviceregister.g.a(r0);
        this.ay = new JSONObject();
        c(r10);
        this.v = true;
        new c(this).start();
        this.av = new com.bytedance.common.utility.a(r0);
        com.bytedance.applog.log.l.a("init_end", String.valueOf(com.ss.android.deviceregister.g.l()));
    }

    void a(C1015a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        LinkedList<C1015a> r0 = this.w;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (k == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        if (this.w.size() < j) goto L13;
        c((C1015a) ZeusTransformUtils.preCheckCast(this.w.poll(), C1015a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L13:
        this.w.add(r5);     // Catch: Throwable -> L16
        this.w.notify();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    private void c(C1015a r1) {
        if (r1 == null) goto L10;
        int r0 = AnonymousClass5.f37125a[r1.f37126a.ordinal()];
        if (r0 != 1) goto L6;
    L8:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.m);
        return;
    L6:
        if (r0 == 2) goto L8;
        return;
    }

    void a(t r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.aQ = System.currentTimeMillis();
        LinkedList<t> r0 = this.x;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.x.size() < j) goto L11;
        t r1 = (t) ZeusTransformUtils.preCheckCast(this.x.poll(), t.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        com.ss.android.common.util.e.e("log queue poll out: " + r1);     // Catch: Throwable -> L14
    L11:
        this.x.add(r5);     // Catch: Throwable -> L14
        this.x.notify();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    void r() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.aQ) <= 60000) goto L12;
        this.aQ = r0;
        LinkedList<t> r1 = this.x;
        monitor-enter(r1);
        this.x.notify();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public com.bytedance.applog.sampling.j s() {
        com.bytedance.applog.sampling.j r5 = new com.bytedance.applog.sampling.j(String.valueOf(k()), m(), E());
        IBDAccountCallback r0 = bu;
        if (r0 == null) goto L10;
        Pair<Integer, Long> r1 = r0.getOdinUserInfo();
        if (((Long) ZeusTransformUtils.preCheckCast(r1.second, Long.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L8;
        r5.a(String.valueOf(r1.second));
        r5.b(String.valueOf(r1.first));
    L11:
        return r5;
    L8:
        if (o != 0) goto L11;
        r5.a(String.valueOf(m));
        r5.b(String.valueOf(n));
        goto L11
    L10:
        r5.a(String.valueOf(l.get()));
        goto L11
    }

    void a(String r20, String r21, String r22, long r23, long r25, boolean r27, JSONObject r28) {
        JSONObject r0 = r28;
        if (this.v == true) goto L6;
        LogTrace.a(1, 3, null);
        return;
    L6:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.f5824a);
        if (p() == false) goto L35;
        if ("event_v3".equalsIgnoreCase(r20) == false) goto L22;
        ConcurrentHashMap<String, String> r14 = this.bb;     // Catch: Throwable -> L144
        if (r14 == null) goto L35;
        if (r14.size() <= 0) goto L35;
        if (com.bytedance.common.utility.j.a(r21) == true) goto L35;
        if (this.bb.containsKey(r21) == false) goto L35;
        com.ss.android.common.util.e.d("AppLog hit block event v3");     // Catch: Throwable -> L144
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.n);     // Catch: Throwable -> L144
        LogTrace.a(1, 2, null);     // Catch: Throwable -> L144
        return;
    L22:
        ConcurrentHashMap<String, String> r15 = this.ba;     // Catch: Throwable -> L144
        if (r15 == null) goto L35;
        if (r15.size() <= 0) goto L35;
        if (com.bytedance.common.utility.j.a(r22) == true) goto L29;
        String r16 = r21 + r22;     // Catch: Throwable -> L144
    L31:
        if (this.ba.containsKey(r16) == false) goto L35;
        com.ss.android.common.util.e.d("AppLog hit block event v1");     // Catch: Throwable -> L144
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.n);     // Catch: Throwable -> L144
        LogTrace.a(1, 2, null);     // Catch: Throwable -> L144
        return;
    L29:
        r16 = r21;
    L35:
        if (Q > 0) goto L37;
    L44:
        com.ss.android.common.applog.a.a r11 = S;     // Catch: Throwable -> L144
        if (r11 == null) goto L51;
        if (r11.a(r21, r0) == true) goto L51;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.n);     // Catch: Throwable -> L144
        return;
    L51:
        if (F() <= 0) goto L60;
        if ("event_v3".equalsIgnoreCase(r20) == false) goto L60;
        com.bytedance.applog.sampling.c r12 = f37113c;     // Catch: Throwable -> L144
        if (r12 == null) goto L60;
        if (r12.a(s(), r21, r0) == false) goto L60;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.n);     // Catch: Throwable -> L144
        return;
    L37:
        if ("event_v3".equalsIgnoreCase(r20) == false) goto L44;
        com.ss.android.common.applog.a.a r13 = R;     // Catch: Throwable -> L144
        if (r13 == null) goto L44;
        if (r13.a(r21, r0) == true) goto L44;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.n);     // Catch: Throwable -> L144
        return;
    L60:
        p r17 = new p();
        r17.f37197a = h.incrementAndGet();
        r17.f37198b = r20;
        r17.f37199c = r21;
        r17.f37200d = r22;
        r17.f37201e = r23;
        r17.f = r25;
        r17.l = at;
        com.bytedance.common.utility.i.b r18 = this.av.a();
        if (r18 == null) goto L65;
        if (r0 != null) goto L154;
        r0 = new JSONObject();
    L154:
        r0.put("nt", r18.a());     // Catch: Exception -> L145
    L65:
        JSONObject r19 = r0;
        long r110 = l.get();
        IBDAccountCallback r1 = bu;
        if (bt == false) goto L74;
        if (r1 == null) goto L74;
        Pair<Integer, Long> r2 = r1.getOdinUserInfo();
        if (((Long) ZeusTransformUtils.preCheckCast(r2.second, Long.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L72;
        r17.h = ((Long) ZeusTransformUtils.preCheckCast(r2.second, Long.class, "com.obric.aiagent.plugin")).longValue();
        r17.j = 1;
        r17.k = 1;
        r17.g = ((Integer) ZeusTransformUtils.preCheckCast(r2.first, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r17.i = ((Long) ZeusTransformUtils.preCheckCast(r2.second, Long.class, "com.obric.aiagent.plugin")).longValue();
    L76:
        if (bv == false) goto L86;
        if (r19 == null) goto L86;
        String r3 = H;
        g r10 = A;
        if (r10 == null) goto L152;
        r3 = r10.a(String.valueOf(r17.h));
    L152:
        if (TextUtils.isEmpty(r3) == true) goto L85;
        r19.put("ab_sdk_version", r3);     // Catch: JSONException -> L146
    L151:
        goto L86
    L85:
        r19.remove("ab_sdk_version");     // Catch: JSONException -> L146
    L86:
        if (r19 != null) goto L88;
    L94:
        r17.m = System.currentTimeMillis();
    L96:
        if (r19 == null) goto L120;
        com.ss.android.common.a r4 = aV;
        if (r4 != null) goto L100;
    L102:
        boolean r111 = false;
    L158:
        r17.o = r19.toString();     // Catch: StackOverflowError -> L105 ConcurrentModificationException -> L111
    L105:
        e = move-exception;
        if (r111 == true) goto L110;
        com.ss.android.common.util.e.e("ext json toString stack overflow tag: " + r21 + ", label: " + r22, e);
        goto L120
    L110:
        throw new RuntimeException("ext json toString stack overflow tag: " + r21 + ", label: " + r22, e);
    L111:
        r17.o = r19.toString();     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        if (r111 == true) goto L118;
        com.ss.android.common.util.e.e("ext json exception tag: " + r21 + ", label: " + r22, th);
        goto L120
    L118:
        throw new RuntimeException("ext json exception tag: " + r21 + ", label: " + r22, th);
    L100:
        if ("local_test".equalsIgnoreCase(r4.c()) == false) goto L102;
        r111 = true;
    L120:
        if (r17.o != null) goto L122;
    L124:
        r17.p = r27;
        r17.q = false;
        if (Logger.debug() == false) goto L149;
        StringBuilder r5 = new StringBuilder();
        r5.append("onEvent ").append(r20).append(" ").append(r21).append(" ").append(r22);
        if (r23 == 0) goto L129;
    L131:
        r5.append(" ").append(r23);
    L133:
        if (r25 != 0) goto L135;
        if (r19 != null) goto L135;
    L136:
        if (r19 == null) goto L138;
        r5.append(" ").append(r19);
    L138:
        com.ss.android.common.util.e.a("AppLog " + r5);
    L135:
        r5.append(" ").append(r25);
        goto L136
    L129:
        if (r25 != 0) goto L131;
        if (r19 == null) goto L133;
    L149:
        if (com.ss.android.common.applog.g.a().b() == false) goto L142;
        com.ss.android.common.applog.g.a().a(r20, r21, r22, r23, r25, r17.h, r17.m, r19);     // Catch: Exception -> L147
    L142:
        com.ss.android.common.util.a.b(com.ss.android.common.util.a.a(r17.f37198b), r17);
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.f5828e);
        C1015a r6 = new C1015a(b.f37133c);
        r6.f37127b = r17;
        a(r6);
        return;
    L122:
        if (r17.o.length() <= 50000) goto L124;
        LogTrace.a(5, 0, new Object[]{r20, r21, r22, Integer.valueOf(r17.o.length())});
        goto L124
    L88:
        if (r19.has("event_v3_reserved_field_time_stamp") == false) goto L94;
        r17.m = r19.getLong("event_v3_reserved_field_time_stamp");     // Catch: Throwable -> L91
    L93:
        r19.remove("event_v3_reserved_field_time_stamp");
    L91:
        th = move-exception;
        th.printStackTrace();
        r17.m = System.currentTimeMillis();
        goto L93
    L72:
        if (o != 0) goto L76;
        r17.j = o;
        r17.k = p;
        r17.g = n;
        r17.i = m;
    L74:
        r17.h = r110;
        goto L76
    }

    void b(String r1) {
        com.ss.android.deviceregister.g.c(this.ax, r1);
    }

    void b(long r3) {
        SharedPreferences.Editor r2 = this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit();
        r2.putLong("dns_report_time", r3);
        r2.commit();
    }

    void a(String r13, JSONObject r14) {
        x r0 = this.aG;     // Catch: Exception -> L23
        if (r0 == null) goto L5;
        long r6 = r0.f37250a;     // Catch: Exception -> L23
    L7:
        if (this.v == true) goto L9;
        return;
    L9:
        if (r6 > 0) goto L11;
        return;
    L11:
        if (com.bytedance.common.utility.j.a(r13) == true) goto L27;
        if (r14 == null) goto L28;
        String r1 = r14.toString();     // Catch: Exception -> L23
        long r3 = DBHelper.a(this.ax).a(r6, r13, r1, r14.optLong("event_id"));     // Catch: Exception -> L23
        if (r1 == null) goto L19;
        if (r1.length() <= 50000) goto L19;
        LogTrace.a(5, 0, new Object[]{"misc", r13, "", Integer.valueOf(r1.length())});     // Catch: Exception -> L23
    L19:
        if (r3 >= 0) goto L21;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Exception -> L23
        return;
    L21:
        com.ss.android.common.util.a.a(r13, r14);     // Catch: Exception -> L23
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r6 = 0;
        goto L7
    }

    void b(C1015a r11) {
        if (V == false) goto L16;
        if (W == true) goto L16;
        if (b.f37131a != r11.f37126a) goto L9;
        return;
    L9:
        if (b.f37132b != r11.f37126a) goto L11;
        return;
    L11:
        if (b.f37133c != r11.f37126a) goto L13;
        return;
    L13:
        if (b.j != r11.f37126a) goto L16;
        return;
    L16:
        if (this.v == true) goto L19;
        return;
    L19:
        if (k == false) goto L21;
        return;
    L21:
        BlockHelper.tryBlock();
        String r1 = "";
        boolean r2 = true;
        boolean r5 = false;
        switch(AnonymousClass5.f37125a[r11.f37126a.ordinal()]) {
            case 1: goto L101;
            case 2: goto L96;
            case 3: goto L90;
            case 4: goto L82;
            case 5: goto L80;
            case 6: goto L141;
            case 7: goto L71;
            case 8: goto L68;
            case 9: goto L141;
            case 10: goto L65;
            case 11: goto L62;
            case 12: goto L59;
            case 13: goto L56;
            case 14: goto L53;
            case 15: goto L46;
            case 16: goto L34;
            case 17: goto L33;
            case 18: goto L32;
            case 19: goto L25;
            default: goto L141;
        };
    L32:
        g((String) ZeusTransformUtils.preCheckCast(r11.f37127b, String.class, "com.obric.aiagent.plugin"));
        return;
    L33:
        ac();
        return;
    L34:
        com.ss.android.deviceregister.t r0 = null;
        if (ZeusTransformUtils.instanceOf(r11.f37127b, Pair.class) == false) goto L37;
        r0 = (com.ss.android.deviceregister.t) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r11.f37127b, Pair.class, "com.obric.aiagent.plugin")).first, com.ss.android.deviceregister.t.class, "com.obric.aiagent.plugin");
        long r6 = ((Long) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r11.f37127b, Pair.class, "com.obric.aiagent.plugin")).second, Long.class, "com.obric.aiagent.plugin")).longValue();
    L39:
        if (r11.f37128c > 0) goto L42;
        r2 = false;
    L42:
        a(r2, r6, r0);
        if (r11.f37130e == null) goto L116;
        r11.f37130e.countDown();
        return;
    L116:
        return;
    L37:
        r6 = 0;
        goto L39
    L82:
        long r3 = r11.f37128c;
        x r4 = this.aG;
        if (r4 == null) goto L86;
        r1 = r4.f37251b;
    L86:
        com.ss.android.common.applog.task.c.a(this.ax).b(r3, r1);
        if (ZeusTransformUtils.instanceOf(r11.f37127b, r.class) == false) goto L89;
        a((r) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.preCheckCast(r11.f37127b, r.class, "com.obric.aiagent.plugin"), r.class, "com.obric.aiagent.plugin"), r11.f37128c);
    L89:
        r();
        return;
    L90:
        a(r11.f37128c, false);
        long r7 = r11.f37128c;
        x r12 = this.aG;
        if (r12 == null) goto L94;
        r1 = r12.f37251b;
    L94:
        com.ss.android.common.applog.task.c.a(this.ax).a(r7, r1);
        r();
        return;
    L141:
        return;
    L25:
        if (this.y != null) goto L27;
        return;
    L27:
        if (this.y.isAlive() == true) goto L112;
        this.y.start();     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        com.ss.android.common.util.e.e("AppLog delay start LogReaper", th);
        return;
    L112:
        return;
    L46:
        if (r11.f37128c > 0) goto L49;
        r2 = false;
    L49:
        c(r2);
        if (r11.f37130e == null) goto L118;
        r11.f37130e.countDown();
        return;
    L118:
        return;
    L53:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, JSONObject.class) == false) goto L120;
        d((JSONObject) ZeusTransformUtils.preCheckCast(r11.f37127b, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L120:
        return;
    L56:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, String.class) == false) goto L122;
        c((String) ZeusTransformUtils.preCheckCast(r11.f37127b, String.class, "com.obric.aiagent.plugin"));
        return;
    L122:
        return;
    L59:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, JSONObject.class) == false) goto L124;
        e((JSONObject) ZeusTransformUtils.preCheckCast(r11.f37127b, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L124:
        return;
    L62:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, Bundle.class) == false) goto L126;
        a((Bundle) ZeusTransformUtils.preCheckCast(r11.f37127b, Bundle.class, "com.obric.aiagent.plugin"));
        return;
    L126:
        return;
    L65:
        if (r11.f37128c <= 0) goto L128;
        b(r11.f37128c);
        return;
    L128:
        return;
    L68:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, String.class) == false) goto L130;
        b((String) ZeusTransformUtils.preCheckCast(r11.f37127b, String.class, "com.obric.aiagent.plugin"));
        return;
    L130:
        return;
    L71:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, JSONObject.class) == true) goto L104;
    L78:
        b(true);
        return;
    L104:
        r5 = Boolean.valueOf(r11.f37129d).booleanValue();     // Catch: Exception -> L75
    L77:
        a((JSONObject) ZeusTransformUtils.preCheckCast(r11.f37127b, JSONObject.class, "com.obric.aiagent.plugin"), r5);
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L77
    L80:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, k.class) == false) goto L133;
        a((k) ZeusTransformUtils.preCheckCast(r11.f37127b, k.class, "com.obric.aiagent.plugin"));
        return;
    L133:
        return;
    L96:
        if (com.bytedance.common.utility.j.a(r11.f37129d) == false) goto L98;
        return;
    L98:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, JSONObject.class) == false) goto L138;
        a(r11.f37129d, (JSONObject) ZeusTransformUtils.preCheckCast(r11.f37127b, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L138:
        return;
    L101:
        if (ZeusTransformUtils.instanceOf(r11.f37127b, p.class) == false) goto L140;
        a((p) ZeusTransformUtils.preCheckCast((p) ZeusTransformUtils.preCheckCast(r11.f37127b, p.class, "com.obric.aiagent.plugin"), p.class, "com.obric.aiagent.plugin"));
        return;
    }

    private void c(String r5) {
        if (com.bytedance.common.utility.j.a(r5) == false) goto L6;
        return;
    L6:
        if (this.y == null) goto L19;
        if (r5.equals(this.ay.optString("google_aid", null)) == false) goto L10;
        return;
    L10:
        if (K == true) goto L14;
        this.ay.put("google_aid", r5);     // Catch: Throwable -> L16
        if (this.y == null) goto L14;
        JSONObject r1 = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: Throwable -> L16
        this.y.b(r1);     // Catch: Throwable -> L16
    L14:
        this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit().putString("google_aid", r5).commit();     // Catch: Throwable -> L16
        return;
    L21:
        return;
    }

    private void d(JSONObject r4) {
        String r0 = r4.optString("app_language", null);
        String r5 = r4.optString("app_region", null);
        if (d(r0) == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        com.ss.android.deviceregister.g.m();
        com.ss.android.common.util.e.b("AppLog updateDeviceInfo call device_register");
        return;
    L12:
        return;
    L5:
        if (e(r5) == true) goto L8;
        r3 = false;
        goto L9
    }

    private boolean d(String r6) {
        if (com.bytedance.common.utility.j.a(r6) == false) goto L15;
        return false;
    L15:
        if (r6.equals(this.ay.optString("app_language", null)) == true) goto L13;
        this.ay.put("app_language", r6);     // Catch: Throwable -> L14
        if (this.y == null) goto L10;
        JSONObject r1 = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: Throwable -> L14
        this.y.b(r1);     // Catch: Throwable -> L14
    L10:
        this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit().putString("app_language", r6).commit();     // Catch: Throwable -> L14
        return true;
    L13:
        return false;
    }

    private boolean e(String r6) {
        if (com.bytedance.common.utility.j.a(r6) == false) goto L15;
        return false;
    L15:
        if (r6.equals(this.ay.optString("app_region", null)) == true) goto L13;
        this.ay.put("app_region", r6);     // Catch: Throwable -> L14
        if (this.y == null) goto L10;
        JSONObject r1 = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: Throwable -> L14
        this.y.b(r1);     // Catch: Throwable -> L14
    L10:
        this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit().putString("app_region", r6).commit();     // Catch: Throwable -> L14
        return true;
    L13:
        return false;
    }

    private void a(Bundle r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.size() > 0) goto L8;
        return;
    L8:
        if (this.y == null) goto L26;
        JSONObject r1 = this.ay.optJSONObject(MonitorConstants.CUSTOM);     // Catch: Throwable -> L21
        if (r1 != null) goto L12;
        r1 = new JSONObject();     // Catch: Throwable -> L21
    L12:
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r2.hasNext() == false) goto L16;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        r1.put(r3, r7.get(r3));     // Catch: Throwable -> L21
        goto L14
    L16:
        this.ay.put(MonitorConstants.CUSTOM, r1);     // Catch: Throwable -> L21
        if (this.y == null) goto L19;
        JSONObject r8 = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: Throwable -> L21
        this.y.b(r8);     // Catch: Throwable -> L21
    L19:
        Y();     // Catch: Throwable -> L21
        return;
    L28:
        return;
    }

    private void e(JSONObject r6) {
        a(TAG, "updateDid " + r6);
        if (r6 != null) goto L5;
        return;
    L5:
        boolean r0 = a(this.ay.optString("device_id", null));
        String r3 = r6.optString("device_id", null);
        String r7 = r6.optString("install_id", null);
        if (com.bytedance.common.utility.j.a(r3) == true) goto L12;
        this.ay.put("device_id", r3);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        if (com.bytedance.common.utility.j.a(r7) == true) goto L18;
        this.ay.put("install_id", r7);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    L18:
        if (this.y != null) goto L25;
    L23:
        Y();
        a(true, true, r0);
        return;
    L25:
        this.y.b(new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b));     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    void t() {
        x r0 = this.aG;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.i == true) goto L16;
        long r1 = System.currentTimeMillis();
        if (this.aG.k == false) goto L10;
        return;
    L10:
        if ((r1 - this.aG.h) < j()) goto L17;
        x r2 = this.aG;
        u();
        this.aG = null;
        v r3 = new v();
        r3.f37236a = r2;
        a(r3);
        return;
    L17:
        return;
    }

    void u() {
        x r0 = this.aG;
        if (r0 != null) goto L5;
        return;
    L5:
        DBHelper r1 = DBHelper.a(this.ax);
        int r3 = 0;
        int r2 = this.aN.getAndSet(0);
        int r4 = this.aO.getAndSet(0);
        if (r0 != null) goto L8;
    L21:
        this.aP.clear();
        return;
    L8:
        if (r0.f37250a <= 0) goto L21;
        if (r2 > 0) goto L12;
        if (r4 > 0) goto L12;
    L14:
        if (this.aE == true) goto L16;
        this.aP.clear();
    L16:
        Iterator<k> r5 = this.aP.iterator();
    L18:
        if (r5.hasNext() == false) goto L21;
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.aiagent.plugin");
        p r7 = new p();
        r7.f37198b = "image";
        r7.f37199c = "sample";
        r7.f37200d = r6.f37142a;
        r7.f37201e = r6.f37143b;
        r7.f = r6.f37144c;
        r7.m = r6.f37145d;
        r7.n = r0.f37250a;
        r1.a(r7);
        r3 = r3 + 1;
        if (r3 < 5) goto L18;
    L12:
        p r8 = new p();
        r8.f37198b = "image";
        r8.f37199c = "stats";
        r8.f37201e = r2;
        r8.f = r4;
        r8.m = r0.h;
        r8.n = r0.f37250a;
        r1.a(r8);
        goto L14
    }

    void a(long r9, boolean r11) {
        DBHelper r0 = DBHelper.a(this.ax);
        x r1 = this.aG;
        if (r1 != null) goto L5;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L18;
        if (r11 == true) goto L39;
        this.aG.k = true;
        this.aG.h = r9;
        return;
    L39:
        return;
    L18:
        u();
        x r3 = this.aG;
        x r4 = new x();
        r4.f37251b = y();
        r4.f37252c = r9;
        v();
        r4.f37253d = this.bf.getAndIncrement();
        r4.h = r4.f37252c;
        r4.f37254e = 0;
        r4.f = com.ss.android.deviceregister.base.v.e();
        r4.g = com.ss.android.deviceregister.base.v.c();
        r4.i = r11;
        if (r11 == true) goto L21;
        r4.k = true;
    L21:
        long r5 = r0.a(r4);
        if (r5 <= 0) goto L24;
        r4.f37250a = r5;
        this.aG = r4;
        com.ss.android.common.util.e.c("AppLog start new session " + r4.f37251b);
        d(r5);
    L25:
        if (r3 == null) goto L27;
    L28:
        v r6 = new v();
        r6.f37236a = r3;
        if (C > 0) goto L31;
        C = 6;
    L31:
        x r7 = this.aG;
        if (r7 != null) goto L34;
    L36:
        a(r6);
    L37:
        n.a().a(String.valueOf(r5), r9, r11);
        return;
    L34:
        if (r7.i == true) goto L36;
        r6.f37237b = this.aG;
        goto L36
    L27:
        if (this.aG == null) goto L37;
    L24:
        this.aG = null;
        goto L25
    L5:
        if (r1.k == true) goto L9;
        if ((r9 - this.aG.h) >= j()) goto L13;
    L9:
        if (this.aG.i == false) goto L12;
        if (r11 == false) goto L13;
    L12:
        r2 = false;
        goto L14
    }

    private void d(long r5) {
        List<j> r4 = r;
        if (r4 != null) goto L5;
        return;
    L5:
        monitor-enter(r4);
        Iterator<j> r0 = r4.iterator();     // Catch: Throwable -> L12
    L8:
        if (r0.hasNext() == false) goto L10;
        ((j) ZeusTransformUtils.preCheckCast(r0.next(), j.class, "com.obric.aiagent.plugin")).a(r5);     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void a(r r7, long r8) {
        x r0 = this.aG;
        if (r0 != null) goto L7;
        com.ss.android.common.util.e.d("AppLog no session when onPause: " + r7.f37207a);
        return;
    L7:
        if (r0.i == false) goto L10;
        com.ss.android.common.util.e.d("AppLog non-page session when onPause: " + r7.f37207a);
        return;
    L10:
        this.aG.k = false;
        this.aG.h = r8;
        r7.f37209c = this.aG.f37250a;
        DBHelper.a(this.ax).a(r7, r8);
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L20
        int r10 = this.aN.get();     // Catch: Exception -> L20
        int r11 = this.aO.get();     // Catch: Exception -> L20
        r9.put("session_id", this.aG.f37251b);     // Catch: Exception -> L20
        r9.put("cnt_success", r10);     // Catch: Exception -> L20
        r9.put("cnt_failure", r11);     // Catch: Exception -> L20
        JSONArray r12 = new JSONArray();     // Catch: Exception -> L20
        Iterator<k> r13 = this.aP.iterator();     // Catch: Exception -> L20
    L13:
        if (r13.hasNext() == false) goto L16;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r13.next(), k.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L20
        r2.put("url", r1.f37142a);     // Catch: Exception -> L20
        r2.put("networktype", r1.f37143b);     // Catch: Exception -> L20
        r2.put("time", r1.f37144c);     // Catch: Exception -> L20
        r2.put(com.bytedance.apm.battery.dao.DBHelper.COL_TIME, r1.f37145d);     // Catch: Exception -> L20
        r12.put(r2);     // Catch: Exception -> L20
        goto L13
    L16:
        if (r12.length() <= 0) goto L18;
        r9.put("samples", r12);     // Catch: Exception -> L20
    L18:
        SharedPreferences.Editor r6 = this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit();     // Catch: Exception -> L20
        r6.putString("stats_value", r9.toString());     // Catch: Exception -> L20
        r6.commit();     // Catch: Exception -> L20
        return;
    }

    private void X() {
        this.bf.set(0);
        this.bg.set(0);
    }

    static void a(JSONObject r3) {
        a r0 = ar;
        if (r0 != null) goto L10;
        return;
    L10:
        r3.put("tea_event_index", r0.bf.getAndIncrement());     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    static void v() {
        a r0 = ar;
        if (r0 == null) goto L6;
        r0.bf.set(0);
        r0.bg.set(0);
        return;
    }

    static long w() {
        a r0 = ar;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.bf.getAndIncrement();
    }

    void a(p r5) {
        b(r5);
        a(r5.m, true);
        if (this.aG != null) goto L7;
        LogTrace.a(1, 4, null);
        return;
    L7:
        if ("event_v3".equalsIgnoreCase(r5.f37198b) == false) goto L9;
        r5.r = this.bf.getAndIncrement();
    L10:
        r5.n = this.aG.f37250a;
        if (a(r5, this.aG.f37251b) == false) goto L13;
        return;
    L13:
        long r0 = DBHelper.a(this.ax).a(r5);
        if (r0 <= 0) goto L16;
        com.ss.android.common.util.a.a(com.ss.android.common.util.a.a(r5.f37198b), r5);
        r();
    L16:
        if (r0 >= 0) goto L19;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);
        return;
    L19:
        return;
    L9:
        r5.r = this.bg.getAndIncrement();
        goto L10
    }

    private void b(p r11) {
        if (f37111a == null) goto L6;
        f37111a.a(r11.f37198b, r11.f37199c, r11.f37200d, r11.f37201e, r11.f, r11.p, r11.o);
        return;
    }

    private boolean a(final p r13, String r14) {
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L40
        if (r13 == null) goto L39;
        if (r13.q == true) goto L39;
        if ((r4 - this.bm) < 900000) goto L39;
        if ("event_v3".equalsIgnoreCase(r13.f37198b) == false) goto L39;
        ConcurrentHashMap<String, String> r5 = this.bc;     // Catch: Throwable -> L40
        if (r5 == null) goto L39;
        if (r5.size() <= 0) goto L39;
        if (com.bytedance.common.utility.j.a(r13.f37199c) == true) goto L39;
        if (this.bc.containsKey(r13.f37199c) == false) goto L39;
        if (com.bytedance.common.utility.j.a(r13.o) == true) goto L39;
        JSONObject r6 = new JSONObject(r13.o);     // Catch: Throwable -> L40
        if (r6.optInt("_event_v3", 0) != 1) goto L39;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.p);     // Catch: Throwable -> L40
        com.ss.android.common.util.a.a(r13);     // Catch: Throwable -> L40
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L40
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L40
        if (r6.has("nt") == false) goto L28;
        r8.put("nt", r6.optInt("nt"));     // Catch: Throwable -> L40
    L28:
        if (r13.h <= 0) goto L30;
        r8.put("user_id", r13.h);     // Catch: Throwable -> L40
        r8.put("user_is_login", r13.j);     // Catch: Throwable -> L40
        r8.put("user_type", r13.g);     // Catch: Throwable -> L40
        r8.put("user_is_auth", r13.k);     // Catch: Throwable -> L40
    L30:
        r6.remove("nt");     // Catch: Throwable -> L40
        r6.remove("_event_v3");     // Catch: Throwable -> L40
        r8.put("event", r13.f37199c);     // Catch: Throwable -> L40
        r8.put("params", r6);     // Catch: Throwable -> L40
        if (F == false) goto L33;
        Object r15 = r14;
    L34:
        r8.put("session_id", r15);     // Catch: Throwable -> L40
        r8.put("datetime", a(r13.m));     // Catch: Throwable -> L40
        r8.put("local_time_ms", r13.m);     // Catch: Throwable -> L40
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L40
        r16.put(r8);     // Catch: Throwable -> L40
        r7.put("event_v3", r16);     // Catch: Throwable -> L40
        JSONObject r17 = this.aM;     // Catch: Throwable -> L40
        if (r17 == null) goto L37;
        r7.put("time_sync", r17);     // Catch: Throwable -> L40
    L37:
        r7.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L40
        JSONObject r18 = com.ss.android.common.applog.d.b(this.ax, this.ay);     // Catch: Throwable -> L40
        r18.optString("device_id");     // Catch: Throwable -> L40
        r7.put("header", r18);     // Catch: Throwable -> L40
        r7.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L40
        final String r19 = r7.toString();     // Catch: Throwable -> L40
        new AnonymousClass1(this, r19, r13).a();     // Catch: Throwable -> L40
        return true;
    L33:
        r15 = Long.valueOf(r13.n);     // Catch: Throwable -> L40
    L39:
        return false;
    }

    private boolean f(String r23) {
        com.ss.android.common.util.e.b("AppLog app_log_config: " + r23);     // Catch: Throwable -> L35
        byte[] r14 = r23.getBytes("UTF-8");     // Catch: Throwable -> L35
        if (d() != null) goto L6;
    L44:
        return false;
    L6:
        if (d().length == 0) goto L44;
        String[] r15 = d();     // Catch: Throwable -> L35
        int r11 = r15.length;     // Catch: Throwable -> L35
        int r10 = 0;
    L8:
        if (r10 >= r11) goto L44;
        String r16 = z.a(y.a(r15[r10], true), z.f37260c);     // Catch: Throwable -> L35
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r14.clone(), byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        Map<String, String> r17 = G();     // Catch: Throwable -> L35
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.v);     // Catch: Throwable -> L35
        if (this.ax != null) goto L12;
    L19:
        boolean r20 = true;
        int r21 = r10;
        int r18 = r11;
        String r2 = y.a(N(), r16, r14, true, "application/octet-stream;tt-data=b", false, r17, false, true);     // Catch: Throwable -> L35
    L20:
        if (r2 != null) goto L22;
    L33:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.w);     // Catch: Throwable -> L35
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L35
        r10 = r21 + 1;
        r11 = r18;
        goto L8
    L22:
        if (r2.length() == 0) goto L33;
        JSONObject r0 = new JSONObject(r2);     // Catch: Throwable -> L35
        if ("ss_app_log".equals(r0.optString("magic_tag")) == true) goto L27;
    L29:
        boolean r9 = false;
    L30:
        if (r9 == true) goto L32;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.w);     // Catch: Throwable -> L35
    L32:
        return r9;
    L27:
        if ("success".equals(r0.optString("message")) == false) goto L29;
        r9 = r20;
        goto L30
    L12:
        if (n() == false) goto L19;
        r20 = true;
        r21 = r10;
        r18 = r11;
        r2 = y.a(N(), r16, r4, this.ax, false, null, r17, r23, false, true);     // Catch: RuntimeException -> L45 Throwable -> L35
    L18:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L35
        r2 = y.a(N(), r16, r14, true, "application/octet-stream;tt-data=b", false, r17, false, true);     // Catch: Throwable -> L35
    L17:
        r20 = true;
        r21 = r10;
        r18 = r11;
    L35:
        th = move-exception;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.common.utility.b.class) == false) goto L43;
        int r3 = ((com.bytedance.common.utility.b) ZeusTransformUtils.preCheckCast(th, com.bytedance.common.utility.b.class, "com.obric.aiagent.plugin")).a();
        if (r3 < 500) goto L43;
        if (r3 >= 600) goto L43;
        this.bm = System.currentTimeMillis();
    L43:
        com.ss.android.common.util.e.e("AppLog updateConfig exception: ", th);
        goto L44
    }

    void a(k r3) {
        if (this.aP.size() < 5) goto L5;
        this.aP.removeFirst();
    L5:
        this.aP.add(r3);
    }

    private static boolean a(JSONObject r2, String r3, boolean r4) {
        if (r2 != null) goto L4;
    L14:
        return r4;
    L4:
        if (r2.isNull(r3) == true) goto L14;
        int r0 = r2.optInt(r3, -1);
        if (r0 < 1) goto L9;
        return true;
    L9:
        if (r0 != 0) goto L13;
        return false;
    L13:
        return r2.optBoolean(r3, r4);
    }

    public static JSONObject x() {
        return ah.d();
    }

    private synchronized void Y() {
        monitor-enter(this);
        as = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: Throwable -> L5 JSONException -> L7
    L9:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        com.ss.android.common.util.e.e("ensureHeaderCopy error", e);     // Catch: Throwable -> L5
        goto L9
    }

    void a(JSONObject r14, boolean r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        this.aR = System.currentTimeMillis();
        this.M = this.au;
        long r4 = r14.optLong("server_time");     // Catch: Exception -> L121
        if (r4 <= 0) goto L10;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L121
        r6.put("server_time", r4);     // Catch: Exception -> L121
        r6.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L121
        this.aM = r6;     // Catch: Exception -> L121
        if (this.y == null) goto L10;
        this.y.a(this.aM);     // Catch: Exception -> L121
    L10:
        JSONObject r16 = r14.optJSONObject("config");
        if (r16 != null) goto L13;
        r16 = new JSONObject();
    L13:
        String r5 = null;
        JSONArray r7 = r16.optJSONArray("allow_push_list");     // Catch: Exception -> L122
        if (r7 == null) goto L25;
        Object r8 = aq;     // Catch: Exception -> L122
        monitor-enter(r8);     // Catch: Exception -> L122
        a(this.aC, r7);     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        r5 = r7.toString();     // Catch: Exception -> L122
        this.aD = r5;     // Catch: Exception -> L122
        goto L25
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L122
    L25:
        boolean r9 = a(r16, "allow_old_image_sample", false);
        if (r9 == this.aE) goto L28;
        this.aE = r9;
        boolean r10 = true;
    L29:
        long r0 = r16.optLong("session_interval", 0);
        if (r0 >= 15) goto L32;
    L36:
        boolean r1 = false;
    L37:
        long r11 = r16.optLong("batch_event_interval", 60) * 1000;
        if (c(r11) == true) goto L40;
    L49:
        long r12 = r16.optLong("fetch_interval", 21600) * 1000;
        if (r12 >= 1800000) goto L52;
    L53:
        r12 = 21600000;
    L55:
        if (r12 == this.aJ) goto L57;
        this.aJ = r12;
        r1 = true;
    L57:
        int r2 = r16.optInt("send_launch_timely");
        if (r2 == this.aK) goto L63;
        this.aK = r2;
        if (this.y == null) goto L62;
        this.y.a(this.aK);
    L62:
        r1 = true;
    L63:
        int r3 = r16.optInt("http_monitor_port");
        if (r3 > 0) goto L66;
    L68:
        boolean r13 = false;
    L70:
        if (r16.optInt("device_register_throttle", 0) == 0) goto L72;
        boolean r17 = true;
    L73:
        com.ss.android.common.util.e.b("AppLog get_deviceRegisterThrottle: " + r17);
        if (r17 == com.ss.android.deviceregister.a.e.f37328a) goto L76;
        com.ss.android.common.util.e.b("AppLog change_deviceRegisterThrottle: " + com.ss.android.deviceregister.a.e.f37328a);
        com.ss.android.deviceregister.a.e.f37328a = r17;
        boolean r18 = true;
    L78:
        if (Q <= 0) goto L80;
        R = com.ss.android.common.applog.a.a.a(this.ax, r16);
    L80:
        int r19 = r16.optInt("forbid_report_phone_detail_info", -1);
        SharedPreferences.Editor r20 = this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit();
        if (r19 < 0) goto L89;
        r20.putInt("forbid_report_phone_detail_info", r19);
        if (r19 <= 0) goto L85;
        boolean r21 = true;
    L86:
        this.N = r21;
        com.ss.android.deviceregister.g.b(r21);
        com.ss.android.deviceregister.base.v.a(this.ay);
        Y();
        if (this.y == null) goto L89;
        this.y.a();
        goto L89
    L85:
        r21 = false;
    L89:
        if (r1 == false) goto L91;
        r20.putLong("session_interval", this.aH);
        r20.putLong("batch_event_interval", this.aI);
        r20.putLong("fetch_interval", this.aJ);
        r20.putInt("send_launch_timely", this.aK);
    L91:
        if (r5 == null) goto L93;
        r20.putString("allow_push_list", r5);
    L93:
        if (r10 == false) goto L95;
        r20.putBoolean("allow_old_image_sample", this.aE);
    L95:
        if (r13 == false) goto L97;
        r20.putInt("http_monitor_port", this.aL);
    L97:
        if (r18 == false) goto L99;
        com.ss.android.common.util.e.b("AppLog save_deviceRegisterThrottle: " + r17);
        r20.putBoolean("device_register_throttle", r17);
    L99:
        r20.putLong("app_log_last_config_time", this.aR);
        r20.putInt("app_log_last_config_version", this.M);
        JSONArray r22 = r16.optJSONArray("real_time_events");     // Catch: Throwable -> L113
        this.bc.clear();     // Catch: Throwable -> L113
        if (r22 != null) goto L103;
    L111:
        r20.remove("real_time_events");     // Catch: Throwable -> L113
    L115:
        r20.putInt("content_encode_method", r16.optInt("content_encode_method", 0));
        r20.apply();
        f(r16);
        Z();
        if (r15 == true) goto L118;
        return;
    L118:
        if (this.aB == true) goto L133;
        this.aB = true;
        a(true, true, false);
        return;
    L133:
        return;
    L103:
        if (r22.length() <= 0) goto L111;
        int r23 = r22.length();     // Catch: Throwable -> L113
        int r24 = 0;
    L105:
        if (r24 >= r23) goto L110;
        String r25 = r22.getString(r24);     // Catch: Throwable -> L113
        if (com.bytedance.common.utility.j.a(r25) == true) goto L109;
        this.bc.put(r25, "timely");     // Catch: Throwable -> L113
    L109:
        r24 = r24 + 1;     // Catch: Throwable -> L113
        goto L105
    L110:
        r20.putString("real_time_events", r22.toString());     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        th.printStackTrace();
        goto L115
    L76:
        r18 = false;
        goto L78
    L72:
        r17 = false;
        goto L73
    L66:
        if (r3 == this.aL) goto L68;
        this.aL = r3;
        r13 = true;
        goto L70
    L52:
        if (r12 <= 172800000) goto L55;
    L40:
        if (r11 == this.aI) goto L49;
        this.aI = r11;
        if (this.y == null) goto L48;
        w r26 = this.y;
        if (c(br) == false) goto L46;
        long r27 = br;
    L47:
        r26.a(r27);
        goto L48
    L46:
        r27 = this.aI;
    L48:
        r1 = true;
        goto L49
    L32:
        if (r0 > 300) goto L36;
        long r28 = r0 * 1000;
        if (r28 == this.aH) goto L36;
        this.aH = r28;
        r1 = true;
        goto L37
    L28:
        r10 = false;
        goto L29
    }

    private void Z() {
        WeakReference<d> r2 = bn;
        if (r2 == null) goto L11;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.get(), d.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L12;
        r3.a();     // Catch: Exception -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    private void f(JSONObject r3) {
        WeakReference<d> r2 = bn;
        if (r2 == null) goto L11;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2.get(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L12;
        ((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin")).a(r3);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    private void b(boolean r3) {
        WeakReference<d> r2 = bn;
        if (r2 == null) goto L11;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2.get(), d.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        r4.a(r3);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    void a(HashSet<Integer> r3, JSONArray r4) {
        if (r3 == null) goto L11;
        if (r4 == null) goto L15;
        r3.clear();
        int r2 = r4.length();
        int r0 = 0;
    L6:
        if (r0 >= r2) goto L16;
        int r1 = r4.getInt(r0);
        if (r1 <= 0) goto L10;
        r3.add(Integer.valueOf(r1));
    L10:
        r0 = r0 + 1;
        goto L6
    L16:
        return;
    L15:
        return;
    }

    public static String y() {
        return UUID.randomUUID().toString();
    }

    void z() {
        com.ss.android.common.a r0 = aV;     // Catch: Exception -> L39
        if (r0 == null) goto L5;
        this.au = r0.e();     // Catch: Exception -> L39
    L5:
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L39
        int r4 = 0;
        SharedPreferences r2 = this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0);     // Catch: Exception -> L39
        int r3 = r2.getInt("app_log_last_config_version", 0);     // Catch: Exception -> L39
        this.M = r3;     // Catch: Exception -> L39
        if (r3 != this.au) goto L43;
        long r5 = r2.getLong("app_log_last_config_time", 0);     // Catch: Exception -> L39
        if (r5 > r1) goto L11;
        r1 = r5;
    L11:
        this.aR = r1;     // Catch: Exception -> L39
    L43:
        String r6 = r2.getString("allow_push_list", null);     // Catch: Exception -> L23
        this.aD = r6;     // Catch: Exception -> L23
        if (r6 == null) goto L25;
        Object r7 = aq;     // Catch: Exception -> L23
        monitor-enter(r7);     // Catch: Exception -> L23
        a(this.aC, new JSONArray(r6));     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L23
    L25:
        this.aE = r2.getBoolean("allow_old_image_sample", false);     // Catch: Exception -> L39
        String r8 = r2.getString("real_time_events", null);     // Catch: Throwable -> L36
        if (com.bytedance.common.utility.j.a(r8) == true) goto L49;
        JSONArray r9 = new JSONArray(r8);     // Catch: Throwable -> L36
        if (r9.length() <= 0) goto L50;
        int r10 = r9.length();     // Catch: Throwable -> L36
    L31:
        if (r4 >= r10) goto L52;
        String r11 = r9.getString(r4);     // Catch: Throwable -> L36
        if (com.bytedance.common.utility.j.a(r11) == true) goto L35;
        this.bc.put(r11, "timely");     // Catch: Throwable -> L36
    L35:
        r4 = r4 + 1;
        goto L31
    L52:
        return;
    L50:
        return;
    L49:
        return;
    L36:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L39
        return;
    L23:
        e = move-exception;
        com.ss.android.common.util.e.e("AppLog load allow_push_list exception: ", e);     // Catch: Exception -> L39
    }

    void a(x r13) {
        this.aP.clear();     // Catch: Exception -> L42
        int r3 = 0;
        SharedPreferences r1 = this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0);     // Catch: Exception -> L42
        long r4 = r1.getLong("session_interval", OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);     // Catch: Exception -> L42
        if (r4 >= 15000) goto L6;
    L8:
        this.aI = r1.getLong("batch_event_interval", 60000);     // Catch: Exception -> L42
        if (c(br) == false) goto L13;
        long r5 = this.aI;     // Catch: Exception -> L42
        long r6 = br;     // Catch: Exception -> L42
        if (r5 == r6) goto L13;
        this.aI = r6;     // Catch: Exception -> L42
    L13:
        this.aK = r1.getInt("send_launch_timely", 1);     // Catch: Exception -> L42
        this.aJ = r1.getLong("fetch_interval", 21600000);     // Catch: Exception -> L42
        this.aL = r1.getInt("http_monitor_port", 0);     // Catch: Exception -> L42
        com.ss.android.deviceregister.a.e.f37328a = r1.getBoolean("device_register_throttle", false);     // Catch: Exception -> L42
        if (r13 != null) goto L16;
        return;
    L16:
        String r2 = r1.getString("stats_value", null);     // Catch: Exception -> L42
        if (com.bytedance.common.utility.j.a(r2) == false) goto L19;
        return;
    L19:
        JSONObject r7 = new JSONObject(r2);     // Catch: Exception -> L42
        String r8 = r7.optString("session_id", null);     // Catch: Exception -> L42
        if (r8 != null) goto L22;
        return;
    L22:
        if (r8.equals(r13.f37251b) == false) goto L49;
        int r14 = r7.optInt("cnt_success", 0);     // Catch: Exception -> L42
        int r9 = r7.optInt("cnt_failure", 0);     // Catch: Exception -> L42
        if (r14 <= 0) goto L27;
        this.aN.addAndGet(r14);     // Catch: Exception -> L42
    L27:
        if (r9 <= 0) goto L30;
        this.aO.addAndGet(r9);     // Catch: Exception -> L42
    L30:
        if (r7.isNull("samples") == false) goto L32;
        return;
    L32:
        JSONArray r15 = r7.getJSONArray("samples");     // Catch: Exception -> L42
        int r0 = r15.length();     // Catch: Exception -> L42
        if (r0 <= 5) goto L35;
        r0 = 5;
    L35:
        if (r3 >= r0) goto L51;
        JSONObject r10 = r15.getJSONObject(r3);     // Catch: Exception -> L42
        String r11 = r10.optString("url", null);     // Catch: Exception -> L42
        int r12 = r10.getInt("networktype");     // Catch: Exception -> L42
        long r16 = r10.getLong("time");     // Catch: Exception -> L42
        long r17 = r10.getLong(com.bytedance.apm.battery.dao.DBHelper.COL_TIME);     // Catch: Exception -> L42
        if (com.bytedance.common.utility.j.a(r11) == true) goto L40;
        this.aP.add(new k(r11, r12, r16, r17));     // Catch: Exception -> L42
    L40:
        r3 = r3 + 1;
        goto L35
    L51:
        return;
    L49:
        return;
    L6:
        if (r4 > 300000) goto L8;
        this.aH = r4;     // Catch: Exception -> L42
    }

    boolean a(String r3, boolean r4, long r5) {
        bl.set(Boolean.TRUE);
        boolean r6 = a(r3, r4);
        if (r6 == true) goto L5;
    L7:
        Object r7 = bk;
        monitor-enter(r7);
        this.aT = false;     // Catch: Throwable -> L17
        r7.notifyAll();     // Catch: Exception -> L20 Throwable -> L17
    L12:
        monitor-exit(r7);     // Catch: Throwable -> L17
        bl.remove();
        if (r6 == true) goto L16;
        b(false);
    L16:
        return r6;
    L17:
        th = move-exception;
        throw th;
    L5:
        if (aa <= 0) goto L7;
        aa = 0;
        goto L7
    }

    boolean a(String r22, boolean r23) {
        JSONObject r0 = new JSONObject(r22);     // Catch: Throwable -> L64
        String[] r14 = b(r0, false);     // Catch: Throwable -> L64
        String r1 = r0.toString();     // Catch: Throwable -> L64
        com.ss.android.common.util.e.b("AppLog app_log_config: " + r1);     // Catch: Throwable -> L64
        byte[] r15 = r1.getBytes("UTF-8");     // Catch: Throwable -> L64
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L64
        boolean r13 = true;
        if ((r4 - aZ) >= 600000) goto L6;
        boolean r16 = true;
    L7:
        aZ = r4;     // Catch: Throwable -> L64
        String r17 = null;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.x);     // Catch: Throwable -> L64
        boolean r2 = false;
        int r12 = 0;
    L9:
        if (r12 >= 2) goto L49;
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r15.clone(), byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        String r5 = f();     // Catch: Throwable -> L64
        if (r2 == false) goto L13;
        r5 = g();     // Catch: Throwable -> L64
    L13:
        String r3 = z.a(y.a(r5, r13), z.f37259b);     // Catch: Throwable -> L64
    L35:
        th = th;
        int r18 = r12;
        boolean r19 = r13;
    L37:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L64
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.common.utility.b.class) == false) goto L46;
        int r7 = ((com.bytedance.common.utility.b) ZeusTransformUtils.preCheckCast(th, com.bytedance.common.utility.b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L64
        if (r7 < 500) goto L46;
        if (r7 >= 600) goto L46;
        this.aR = System.currentTimeMillis();     // Catch: Throwable -> L64
        this.M = this.au;     // Catch: Throwable -> L64
        SharedPreferences.Editor r8 = this.ax.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit();     // Catch: Throwable -> L64
        r8.putLong("app_log_last_config_time", this.aR);     // Catch: Throwable -> L64
        r8.putInt("app_log_last_config_version", this.M);     // Catch: Throwable -> L64
        r8.commit();     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L46:
        if (r18 > 0) goto L48;
        r12 = r18 + 1;     // Catch: Throwable -> L64
        r2 = r19;
        r13 = r2;
        goto L9
    L48:
        throw th;     // Catch: Throwable -> L64
    L74:
        if (this.ax == null) goto L28;
        if (n() == false) goto L28;
    L20:
        boolean r110 = r13;
        String r9 = y.a(N(), r3, r6, this.ax, r16, r14, null, null, false, false);     // Catch: RuntimeException -> L67 Throwable -> L33
    L32:
        r17 = r9;
    L50:
        String r10 = r17;
        if (r10 != null) goto L53;
    L61:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L64
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.y);     // Catch: Throwable -> L64
        return false;
    L53:
        if (r10.length() == 0) goto L61;
        com.ss.android.common.util.e.b("AppLog app_log_config response: " + r10);     // Catch: Throwable -> L64
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L64
        if ("ss_app_log".equals(r11.optString("magic_tag")) == true) goto L59;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.y);     // Catch: Throwable -> L64
        return false;
    L59:
        C1015a r20 = new C1015a(b.f37135e);     // Catch: Throwable -> L64
        r20.f37127b = r11;     // Catch: Throwable -> L64
        r20.f37129d = String.valueOf(r23);     // Catch: Throwable -> L64
        a(r20);     // Catch: Throwable -> L64
        return r110;
    L24:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L33
        if (r16 == false) goto L27;
        r3 = r3 + "&config_retry=b";     // Catch: Throwable -> L33
    L27:
        r9 = y.a(null, r3, r15, true, "application/octet-stream;tt-data=b", false, null, false, false);     // Catch: Throwable -> L33
    L23:
        r110 = r13;
    L28:
        r110 = r13;
        if (r16 == false) goto L31;
        r3 = r3 + "&config_retry=b";     // Catch: Throwable -> L33
    L31:
        r9 = y.a(null, r3, r15, true, "application/octet-stream;tt-data=b", false, null, false, false);     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L37
    L49:
        r110 = r13;
        goto L50
    L6:
        r16 = false;
    L64:
        th = move-exception;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);
        com.ss.android.common.util.e.e("AppLog updateConfig exception: ", th);
        return false;
    }

    void a(boolean r2, boolean r3) {
        a(r2, false, r3);
    }

    private void a(boolean r15, boolean r16, final boolean r17) {
        if (this.aT == false) goto L5;
        return;
    L5:
        JSONObject r0 = this.ay;
        if (r0 != null) goto L9;
        return;
    L9:
        if (a(r0.optString("device_id", null)) == false) goto L13;
        b(TAG, "tryUpdateConfig no did");
        return;
    L13:
        if (com.bytedance.common.utility.j.a(this.ay.optString("install_id", null)) == false) goto L16;
        b(TAG, "tryUpdateConfig no iid");
        return;
    L16:
        long r2 = System.currentTimeMillis();
        long r4 = this.aJ;
        long r6 = 60000;
        if (this.M != this.au) goto L19;
        boolean r1 = true;
    L21:
        if (aU == false) goto L23;
    L26:
        if (r1 == false) goto L28;
        r6 = 180000;
    L28:
        if (r16 == true) goto L37;
        if ((r2 - this.aR) >= r4) goto L33;
        return;
    L33:
        if ((r2 - this.aS) >= r6) goto L67;
        com.ss.android.common.util.e.b("AppLog next query time : " + DateFormat.getDateTimeInstance().format(new Date(this.aS + r6)));
        return;
    L67:
        final long r5 = System.currentTimeMillis();     // Catch: Exception -> L66
        if (aa > 0) goto L45;
        aa = r5;     // Catch: Exception -> L66
    L45:
        if (bs == false) goto L48;
        return;
    L48:
        if (com.bytedance.common.utility.i.b(this.ax) == true) goto L51;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.K);     // Catch: Exception -> L66
        return;
    L51:
        this.aS = r2;     // Catch: Exception -> L66
        this.aT = true;     // Catch: Exception -> L66
        JSONObject r3 = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: Exception -> L66
        String r7 = com.ss.android.deviceregister.base.v.b(this.ax);     // Catch: Exception -> L66
        if (com.bytedance.common.utility.j.a(r7) == true) goto L54;
        r3.put("user_agent", r7);     // Catch: Exception -> L66
    L54:
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L66
        r8.put("magic_tag", "ss_app_log");     // Catch: Exception -> L66
        r8.put("header", r3);     // Catch: Exception -> L66
        r8.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L66
        if (aX == false) goto L61;
        f r9 = aY;     // Catch: Exception -> L66
        if (r9 == null) goto L61;
        JSONObject r10 = r9.a();     // Catch: Exception -> L66
        if (r10 == null) goto L61;
        r8.put("photoinfo", r10);     // Catch: Exception -> L66
    L61:
        final String r11 = r8.toString();     // Catch: Exception -> L66
        if (r15 == false) goto L64;
        new AnonymousClass2(this, r11, r17, r5).start();     // Catch: Exception -> L66
        return;
    L64:
        a(r11, r17, r5);     // Catch: Exception -> L66
        return;
    L69:
        return;
    L37:
        if (this.aS <= this.aR) goto L67;
        if ((r2 - this.aS) >= r6) goto L67;
        return;
    L23:
        if (this.aw >= 0) goto L26;
        if (r1 == false) goto L26;
        r4 = 2 * this.aJ;
        goto L26
    L19:
        r1 = false;
        goto L21
    }

    private boolean aa() {
        Context r2 = this.ax;     // Catch: Exception -> L9
        boolean r3 = this.N;     // Catch: Exception -> L9
        com.ss.android.deviceregister.base.j r4 = new AnonymousClass3(this);     // Catch: Exception -> L9
        boolean r5 = G;     // Catch: Exception -> L9
        boolean r6 = aU;     // Catch: Exception -> L9
        boolean r7 = K;     // Catch: Exception -> L9
        if (an == true) goto L6;
        boolean r8 = true;
    L7:
        com.ss.android.deviceregister.f.a(r2, r3, r4, r5, r6, r7, r8);     // Catch: Exception -> L9
    L12:
        this.v = a(this.ay, this.ax);     // Catch: Exception -> L43
        this.aG = DBHelper.a(this.ax).c(0);     // Catch: Exception -> L43
        ab();     // Catch: Exception -> L43
        a(this.aG);     // Catch: Exception -> L43
        Z();     // Catch: Exception -> L43
        if (this.aG == null) goto L53;
        com.ss.android.common.util.e.b("AppLog start with last session " + this.aG.f37251b);     // Catch: Exception -> L43
        s r9 = new s();     // Catch: Exception -> L43
        r9.f37210a = this.aG.f37250a;     // Catch: Exception -> L43
        a(r9);     // Catch: Exception -> L43
    L53:
        Bundle r10 = new Bundle();     // Catch: Throwable -> L30
        Bundle r11 = be;     // Catch: Throwable -> L30
        monitor-enter(r11);     // Catch: Throwable -> L30
        r10.putAll(r11);     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
    L20:
        if (r10.size() <= 0) goto L31;
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L30
        Iterator<String> r13 = r10.keySet().iterator();     // Catch: Throwable -> L30
    L23:
        if (r13.hasNext() == false) goto L25;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        r12.put(r14, r10.get(r14));     // Catch: Throwable -> L30
        goto L23
    L25:
        this.ay.put(MonitorConstants.CUSTOM, r12);     // Catch: Throwable -> L30
    L31:
        this.y = new w(this.ax, new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b), this.x, this.aF, r, this.aG, this.ba, this.bb);     // Catch: Exception -> L43
        this.y.a(this.aI);     // Catch: Exception -> L43
        this.y.a(this.aK);     // Catch: Exception -> L43
        if (ad <= 0) goto L34;
        TeaThread.getInst().postDelay(new AnonymousClass4(this), ad);     // Catch: Exception -> L43
    L36:
        if (Q > 0) goto L38;
    L41:
        return true;
    L38:
        if (this.M != this.au) goto L40;
        R = com.ss.android.common.applog.a.a.a(this.ax);     // Catch: Exception -> L43
        goto L41
    L40:
        this.aR = 0;     // Catch: Exception -> L43
        R = com.ss.android.common.applog.a.a.a(this.ax, null);     // Catch: Exception -> L43
        goto L41
    L34:
        this.y.start();     // Catch: Exception -> L43
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);     // Catch: Exception -> L43
        goto L31
    L6:
        r8 = false;
    L9:
        e = move-exception;
        if (Logger.debug() == false) goto L12;
        throw e;     // Catch: Exception -> L43
    L43:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SQLiteException.class) == false) goto L47;
        com.ss.android.common.applog.c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);
    L47:
        com.ss.android.common.util.e.e("failed to start LogReaper", e);
        return false;
    }

    private void ab() {
        if (ao == false) goto L23;
        boolean r2 = true;
        com.bytedance.applog.monitor.v3.d.a r0 = new com.bytedance.applog.monitor.v3.d.a().a(String.valueOf(k())).b(com.ss.android.deviceregister.g.c(this.ax)).e("2.14.0").f(com.bytedance.bdinstall.n.a(this.ax)).e(!com.bytedance.applog.log.l.a());
        if (Q > 0) goto L8;
        r2 = false;
    L8:
        com.bytedance.applog.monitor.v3.d.a r1 = r0.d(r2);
        com.ss.android.common.a r3 = aV;
        if (r3 == null) goto L11;
        r1.d(r3.a()).c(aV.b()).a(aV.g());
    L11:
        i r4 = s;
        if (r4 == null) goto L14;
        r1.c(r4.c());
    L14:
        MonitorV3Helper r5 = com.ss.android.common.applog.c.a();
        com.bytedance.applog.monitor.v3.e.a r6 = new com.bytedance.applog.monitor.v3.e.a().a(r1.a()).a(this.aI).a(new com.ss.android.common.applog.e());
        ae r7 = ap;
        if (r7 != null) goto L17;
    L21:
        String r8 = null;
    L22:
        r5.init(r6.a(r8).a(this.ax).a(com.bytedance.applog.c.a.b()).a());
        return;
    L17:
        if (r7.f37152c == null) goto L21;
        if (ap.f37152c.length <= 0) goto L21;
        r8 = ap.f37152c[0];
        goto L22
    L23:
        com.ss.android.common.applog.c.a().init(new com.bytedance.applog.monitor.v3.e.a().a());
    }

    public JSONObject A() {
        return ah.e();
    }

    public static void a(Context r2, String r3) {
        com.ss.android.deviceregister.g.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    private static void d(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (bo == false) goto L5;
    L16:
        bp = false;
        long r0 = System.currentTimeMillis();
        if ((r0 - bq) >= 900000) goto L19;
        return;
    L19:
        if (com.bytedance.common.utility.i.b(r7) == false) goto L25;
        bq = r0;
        com.ss.android.common.a.a.a(r7, h(), K, L);
        return;
    L25:
        return;
    L5:
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (bo == true) goto L11;
        bp = true;     // Catch: Throwable -> L13
        monitor-exit(a.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L13
        goto L16
    }

    public static String B() {
        return ah.f();
    }

    public static void a(com.service.middleware.applog.a r2) {
        com.service.middleware.applog.a r3 = (com.service.middleware.applog.a) ZeusTransformUtils.wrapperContextForParams(r2, com.service.middleware.applog.a.class, "com.obric.aiagent.plugin");
        ah.a(r3);
    }

    public static com.service.middleware.applog.a C() {
        return ah.g();
    }

    public static String D() {
        return ah.h();
    }

    public static String E() {
        return ah.i();
    }

    private void g(String r3) {
        if (this.y == null) goto L14;
        if (TextUtils.isEmpty(r3) == false) goto L8;
        this.ay.remove("user_unique_id");     // Catch: Exception -> L11
    L9:
        JSONObject r4 = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: Exception -> L11
        this.y.b(r4);     // Catch: Exception -> L11
        return;
    L8:
        this.ay.put("user_unique_id", r3);     // Catch: Exception -> L11
    L15:
        return;
    }

    public static int F() {
        return T.get();
    }

    private void c(boolean r3) {
        com.ss.android.deviceregister.g.d(r3);
        if (r3 == false) goto L5;
        this.ay.remove("openudid");
        this.ay.remove("google_aid");
        this.ay.remove("device_id");
        this.ay.remove("install_id");
    L5:
        a(this.ax, r3);
        DBHelper.a(this.ax).b();
        x r4 = this.aG;
        if (r4 == null) goto L8;
        boolean r5 = r4.i;
    L9:
        this.aG = null;
        a(System.currentTimeMillis(), r5);
        return;
    L8:
        r5 = true;
        goto L9
    }

    private void a(boolean r4, long r5, com.ss.android.deviceregister.t r7) {
        com.ss.android.deviceregister.t r8 = (com.ss.android.deviceregister.t) ZeusTransformUtils.wrapperContextForParams(r7, com.ss.android.deviceregister.t.class, "com.obric.aiagent.plugin");
        com.ss.android.common.a.a.a(this.ax, h(), r4, false);
        com.ss.android.deviceregister.g.a(r4, r5, r8);
        a(this.ax, r4);
    }

    private void a(Context r3, boolean r4) {
        com.ss.android.deviceregister.base.v.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), this.ay, r4);
        if (this.y == null) goto L11;
        JSONObject r5 = new JSONObject(this.ay, com.ss.android.common.applog.d.f37164b);     // Catch: JSONException -> L6
        this.y.b(r5);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        com.ss.android.common.util.e.e("AppLog updateHeader", e);
        return;
    }

    public static Map<String, String> G() {
        return bd;
    }

    public static boolean H() {
        return bt;
    }

    static String[] b(JSONObject r8, boolean r9) {
        String[] r3 = null;
        if (r9 == false) goto L21;
        if (bt == false) goto L7;
        r8.put("uid_enable", 1);     // Catch: JSONException -> L31
        boolean r10 = true;
    L9:
        if (F() <= 0) goto L24;
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L31
        r4.put("capability", F());     // Catch: JSONException -> L31
        com.bytedance.applog.sampling.c r5 = f37113c;     // Catch: JSONException -> L31
        if (r5 != null) goto L13;
    L16:
        JSONObject r6 = r8.optJSONObject("options");     // Catch: JSONException -> L31
        if (r6 != null) goto L19;
        r6 = new JSONObject();     // Catch: JSONException -> L31
    L19:
        r6.put("event_sampling", r4);     // Catch: JSONException -> L31
        r8.put("options", r6);     // Catch: JSONException -> L31
        goto L24
    L13:
        if (r5.b() != F()) goto L15;
        r4.put("version", r5.a());     // Catch: JSONException -> L31
    L15:
        r4.put("config_ids", r5.c());     // Catch: JSONException -> L31
    L24:
        if (r10 == true) goto L26;
    L33:
        return r3;
    L26:
        if (n() == false) goto L33;
        r3 = com.ss.android.deviceregister.a.a.a.c.b();     // Catch: JSONException -> L31
        if (com.ss.android.deviceregister.a.a.a.c.a(r3) == false) goto L33;
        r8.put("key", r3[0]);     // Catch: JSONException -> L31
        r8.put("iv", r3[1]);     // Catch: JSONException -> L31
        goto L33
    L7:
        r10 = false;
        goto L9
    L21:
        if (Q <= 0) goto L23;
        r8.put("event_filter", Q);     // Catch: JSONException -> L31
        r10 = true;
        goto L24
    L23:
        r10 = false;
    L31:
        e = move-exception;
        com.ss.android.common.util.e.e("AppLog fillKeyIvForEncryptResp", e);
        goto L33
    }

    static boolean I() {
        return U;
    }

    public static boolean J() {
        return V;
    }

    public static boolean K() {
        return W;
    }

    private void ac() {
        if (this.aG == null) goto L6;
        v r0 = new v();
        r0.f37236a = this.aG;
        r0.f37240e = true;
        a(r0);
        return;
    }

    public static boolean L() {
        return X;
    }

    public static boolean M() {
        return Y;
    }

    public static com.bytedance.applog.m N() {
        return ah.j();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
