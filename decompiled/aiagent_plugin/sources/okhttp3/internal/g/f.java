package okhttp3.internal.g;

import androidx.core.internal.view.SupportMenu;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements Closeable {
    private static final m D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f39991a = null;
    private final okhttp3.internal.g.j A;
    private final d B;
    private final Set<Integer> C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f39993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Integer, okhttp3.internal.g.i> f39994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f39995e;
    private int f;
    private int g;
    private boolean h;
    private final okhttp3.internal.c.d i;
    private final okhttp3.internal.c.c j;
    private final okhttp3.internal.c.c k;
    private final okhttp3.internal.c.c l;
    private final okhttp3.internal.g.l m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private final m t;
    private m u;
    private long v;
    private long w;
    private long x;
    private long y;
    private final Socket z;

    /* JADX INFO: compiled from: Http2Connection.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Socket f39996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f39997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e.g f39998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e.f f39999d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f40000e;
        private final okhttp3.internal.c.d f;
        private c g;
        private okhttp3.internal.g.l h;
        private int i;

        public a(boolean r2, okhttp3.internal.c.d r3) {
            o.e(r3, "taskRunner");
            this.f40000e = r2;
            this.f = r3;
            this.g = c.f40002c;
            this.h = okhttp3.internal.g.l.f40082b;
        }

        public final boolean a() {
            return this.f40000e;
        }

        public final okhttp3.internal.c.d b() {
            return this.f;
        }

        public final void a(Socket r2) {
            o.e(r2, "<set-?>");
            this.f39996a = r2;
        }

        public final Socket c() {
            Socket r0 = this.f39996a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            o.c("socket");
            return null;
        }

        public final void a(String r2) {
            o.e(r2, "<set-?>");
            this.f39997b = r2;
        }

        public final String d() {
            String r0 = this.f39997b;
            if (r0 == null) goto L5;
            return r0;
        L5:
            o.c("connectionName");
            return null;
        }

        public final void a(e.g r3) {
            e.g r4 = (e.g) ZeusTransformUtils.wrapperContextForParams(r3, e.g.class, "com.obric.aiagent.plugin");
            o.e(r4, "<set-?>");
            this.f39998c = r4;
        }

        public final e.g e() {
            e.g r0 = this.f39998c;
            if (r0 == null) goto L5;
            return r0;
        L5:
            o.c(DBHelper.BATTERY_COL_SOURCE);
            return null;
        }

        public final void a(e.f r3) {
            e.f r4 = (e.f) ZeusTransformUtils.wrapperContextForParams(r3, e.f.class, "com.obric.aiagent.plugin");
            o.e(r4, "<set-?>");
            this.f39999d = r4;
        }

        public final e.f f() {
            e.f r0 = this.f39999d;
            if (r0 == null) goto L5;
            return r0;
        L5:
            o.c("sink");
            return null;
        }

        public final c g() {
            return this.g;
        }

        public final okhttp3.internal.g.l h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final a a(Socket r5, String r6, e.g r7, e.f r8) {
            e.g r9 = (e.g) ZeusTransformUtils.wrapperContextForParams(r7, e.g.class, "com.obric.aiagent.plugin");
            e.f r10 = (e.f) ZeusTransformUtils.wrapperContextForParams(r8, e.f.class, "com.obric.aiagent.plugin");
            o.e(r5, "socket");
            o.e(r6, "peerName");
            o.e(r9, DBHelper.BATTERY_COL_SOURCE);
            o.e(r10, "sink");
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r1.a(r5);
            if (r1.f40000e == false) goto L5;
            String r11 = okhttp3.internal.c.g + ' ' + r6;
        L6:
            r1.a(r11);
            r1.a(r9);
            r1.a(r10);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L5:
            r11 = "MockWebServer " + r6;
            goto L6
        }

        public final a a(c r4) {
            o.e(r4, "listener");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).g = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(int r4) {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).i = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final f j() {
            return new f(this);
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final m a() {
            return f.m();
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f40001b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f40002c = null;

        /* JADX INFO: compiled from: Http2Connection.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }
        }

        /* JADX INFO: compiled from: Http2Connection.kt */
        public static final class b extends c {
            b() {
            }

            @Override // okhttp3.internal.g.f.c
            public void a(okhttp3.internal.g.i r2) {
                o.e(r2, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
                r2.a(okhttp3.internal.g.b.i, null);
            }
        }

        public void a(f r1, m r2) {
            o.e(r1, WsConstants.KEY_CONNECTION);
            o.e(r2, "settings");
        }

        public abstract void a(okhttp3.internal.g.i r1);

        public c() {
        }

        static {
            f40001b = new a(null);
            f40002c = (c) ZeusTransformUtils.preCheckCast(new b(), c.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    public final class d implements d.h.a.a<x>, okhttp3.internal.g.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final okhttp3.internal.g.h f40004b;

        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class a extends okhttp3.internal.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f40005a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f f40006b;

            public a(String r1, boolean r2, f r3, z.f r4) {
                this.f40005a = r3;
                this.f40006b = r4;
                super(r1, r2);
            }

            @Override // okhttp3.internal.c.a
            public long a() {
                this.f40005a.b().a(this.f40005a, (m) ZeusTransformUtils.preCheckCast(this.f40006b.f38504a, m.class, "com.obric.aiagent.plugin"));
                return -1;
            }
        }

        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class b extends okhttp3.internal.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f40007a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ okhttp3.internal.g.i f40008b;

            public b(String r1, boolean r2, f r3, okhttp3.internal.g.i r4) {
                this.f40007a = r3;
                this.f40008b = r4;
                super(r1, r2);
            }

            @Override // okhttp3.internal.c.a
            public long a() {
                this.f40007a.b().a(this.f40008b);     // Catch: IOException -> L4
                return -1;
            L4:
                e = move-exception;
                okhttp3.internal.i.h.f40147b.a().a("Http2Connection.Listener failure for " + this.f40007a.d(), 4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
                this.f40008b.a(okhttp3.internal.g.b.f39965c, e);     // Catch: IOException -> L9
                return -1;
            L15:
                return -1;
            }
        }

        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class c extends okhttp3.internal.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f40009a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f40010b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f40011c;

            public c(String r1, boolean r2, f r3, int r4, int r5) {
                this.f40009a = r3;
                this.f40010b = r4;
                this.f40011c = r5;
                super(r1, r2);
            }

            @Override // okhttp3.internal.c.a
            public long a() {
                this.f40009a.a(true, this.f40010b, this.f40011c);
                return -1;
            }
        }

        /* JADX INFO: renamed from: okhttp3.internal.g.f$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class C1078d extends okhttp3.internal.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f40012a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f40013b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ m f40014c;

            public C1078d(String r1, boolean r2, d r3, boolean r4, m r5) {
                this.f40012a = r3;
                this.f40013b = r4;
                this.f40014c = r5;
                super(r1, r2);
            }

            @Override // okhttp3.internal.c.a
            public long a() {
                this.f40012a.b(this.f40013b, this.f40014c);
                return -1;
            }
        }

        @Override // okhttp3.internal.g.h.c
        public void a(int r1, int r2, int r3, boolean r4) {
        }

        @Override // okhttp3.internal.g.h.c
        public void b() {
        }

        public d(f r2, okhttp3.internal.g.h r3) {
            o.e(r3, "reader");
            this.f40003a = r2;
            this.f40004b = r3;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [okhttp3.internal.g.b] */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Class, java.lang.Class<java.io.Closeable>] */
        /* JADX WARN: Type inference failed for: r1v6, types: [okhttp3.internal.g.b] */
        /* JADX WARN: Type inference failed for: r7v7, types: [java.io.Closeable] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void a() {
            okhttp3.internal.g.b r1 = okhttp3.internal.g.b.f39966d;
            okhttp3.internal.g.b r2 = okhttp3.internal.g.b.f39966d;
            IOException e2 = null;
            this.f40004b.a((okhttp3.internal.g.h.c) ZeusTransformUtils.preCheckCast(this, okhttp3.internal.g.h.c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8 IOException -> L10
        L5:
            if (this.f40004b.a(false, (okhttp3.internal.g.h.c) ZeusTransformUtils.preCheckCast(this, okhttp3.internal.g.h.c.class, "com.obric.aiagent.plugin")) == true) goto L5;
            r1 = okhttp3.internal.g.b.f39964b;     // Catch: Throwable -> L8 IOException -> L10
            r2 = okhttp3.internal.g.b.j;     // Catch: Throwable -> L8 IOException -> L10
            okhttp3.internal.g.b r3 = r1;
        L12:
            this.f40003a.a(r3, r2, e2);
            r1 = Closeable.class;
            d this = (Closeable) ZeusTransformUtils.preCheckCast(this.f40004b, r1, "com.obric.aiagent.plugin");
            okhttp3.internal.c.a(this);
            return;
        L8:
            th = move-exception;
            this.f40003a.a(r1, r2, e2);
            okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(this.f40004b, Closeable.class, "com.obric.aiagent.plugin"));
            throw th;
        L10:
            e2 = e;
            okhttp3.internal.g.b r4 = okhttp3.internal.g.b.f39965c;     // Catch: Throwable -> L8
            r2 = okhttp3.internal.g.b.f39965c;     // Catch: Throwable -> L8
            r3 = r4;
            goto L12
        }

        @Override // okhttp3.internal.g.h.c
        public void a(boolean r3, int r4, e.g r5, int r6) {
            e.g r7 = (e.g) ZeusTransformUtils.wrapperContextForParams(r5, e.g.class, "com.obric.aiagent.plugin");
            o.e(r7, DBHelper.BATTERY_COL_SOURCE);
            if (this.f40003a.d(r4) == false) goto L6;
            this.f40003a.a(r4, r7, r6, r3);
            return;
        L6:
            okhttp3.internal.g.i r0 = this.f40003a.b(r4);
            if (r0 != null) goto L10;
            this.f40003a.a(r4, okhttp3.internal.g.b.f39965c);
            long r8 = r6;
            this.f40003a.a(r8);
            r7.h(r8);
            return;
        L10:
            r0.a(r7, r6);
            if (r3 == false) goto L14;
            r0.a(okhttp3.internal.c.f39834b, true);
            return;
        }

        @Override // okhttp3.internal.g.h.c
        public void a(boolean r7, int r8, int r9, List<okhttp3.internal.g.c> r10) {
            List<okhttp3.internal.g.c> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
            o.e(r11, "headerBlock");
            if (this.f40003a.d(r8) == false) goto L6;
            this.f40003a.a(r8, r11, r7);
            return;
        L6:
            f r6 = this.f40003a;
            monitor-enter(r6);
            okhttp3.internal.g.i r12 = r6.b(r8);     // Catch: Throwable -> L29
            if (r12 == null) goto L11;
            x r13 = x.f38692a;     // Catch: Throwable -> L29
            monitor-exit(r6);
            r12.a(okhttp3.internal.c.a(r11), r7);
            return;
        L11:
            if (f.b(r6) == false) goto L15;
            monitor-exit(r6);
            return;
        L15:
            if (r8 > r6.e()) goto L19;
            monitor-exit(r6);
            return;
        L19:
            if ((r8 % 2) != (r6.f() % 2)) goto L22;
            monitor-exit(r6);
            return;
        L22:
            okhttp3.internal.g.i r14 = new okhttp3.internal.g.i(r8, r6, false, r7, okhttp3.internal.c.a(r11));     // Catch: Throwable -> L29
            r6.a(r8);     // Catch: Throwable -> L29
            r6.c().put(Integer.valueOf(r8), r14);     // Catch: Throwable -> L29
            f.c(r6).c().a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new b(r6.d() + '[' + r8 + "] onStream", true, r6, r14), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L29
            monitor-exit(r6);
            return;
        L29:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.g.h.c
        public void a(int r2, okhttp3.internal.g.b r3) {
            o.e(r3, "errorCode");
            if (this.f40003a.d(r2) == false) goto L6;
            this.f40003a.c(r2, r3);
            return;
        L6:
            okhttp3.internal.g.i r1 = this.f40003a.c(r2);
            if (r1 == null) goto L10;
            r1.b(r3);
            return;
        }

        @Override // okhttp3.internal.g.h.c
        public void a(boolean r9, m r10) {
            o.e(r10, "settings");
            f.a(this.f40003a).a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new C1078d(this.f40003a.d() + " applyAndAckSettings", true, this, r9, r10), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(boolean r11, m r12) {
            o.e(r12, "settings");
            z.f r0 = new z.f();
            okhttp3.internal.g.j r1 = this.f40003a.j();
            f r10 = this.f40003a;
            monitor-enter(r1);
            monitor-enter(r10);     // Catch: Throwable -> L39
            m r2 = r10.h();     // Catch: Throwable -> L36
            if (r11 == false) goto L8;
            T r13 = r12;
        L9:
            r0.f38504a = r13;     // Catch: Throwable -> L36
            long r14 = ((long) ((m) ZeusTransformUtils.preCheckCast(r0.f38504a, m.class, "com.obric.aiagent.plugin")).b()) - ((long) r2.b());     // Catch: Throwable -> L36
            int r5 = 0;
            if (r14 != 0) goto L12;
        L15:
            okhttp3.internal.g.i[] r4 = null;
        L16:
            r10.a((m) ZeusTransformUtils.preCheckCast(r0.f38504a, m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L36
            f.d(r10).a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new a(r10.d() + " onSettings", true, r10, r0), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L36
            x r3 = x.f38692a;     // Catch: Throwable -> L36
            monitor-exit(r10);     // Catch: Throwable -> L39
            r10.j().a((m) ZeusTransformUtils.preCheckCast(r0.f38504a, m.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L20 Throwable -> L39
        L22:
            x r15 = x.f38692a;     // Catch: Throwable -> L39
            monitor-exit(r1);
            if (r4 == null) goto L35;
            int r16 = r4.length;
        L26:
            if (r5 >= r16) goto L50;
            okhttp3.internal.g.i r6 = r4[r5];
            monitor-enter(r6);
            r6.d(r14);     // Catch: Throwable -> L32
            x r7 = x.f38692a;     // Catch: Throwable -> L32
            monitor-exit(r6);
            r5 = r5 + 1;
        L32:
            th = move-exception;
            throw th;
        L50:
            return;
        L35:
            return;
        L20:
            e = move-exception;
            f.a(r10, e);     // Catch: Throwable -> L39
            goto L22
        L12:
            if (r10.c().isEmpty() == true) goto L15;
            r4 = (okhttp3.internal.g.i[]) ZeusTransformUtils.preCheckCast(r10.c().values().toArray(new okhttp3.internal.g.i[0]), okhttp3.internal.g.i[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            goto L16
        L8:
            m r17 = new m();     // Catch: Throwable -> L36
            r17.a(r2);     // Catch: Throwable -> L36
            r17.a(r12);     // Catch: Throwable -> L36
            r13 = r17;
        L36:
            th = move-exception;
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.g.h.c
        public void a(boolean r10, int r11, int r12) {
            if (r10 == false) goto L20;
            f r9 = this.f40003a;
            monitor-enter(r9);
            if (r11 != 1) goto L8;
            long r13 = f.e(r9);     // Catch: Throwable -> L17
            f.a(r9, 1 + r13);     // Catch: Throwable -> L17
            Long.valueOf(r13);     // Catch: Throwable -> L17
        L15:
            monitor-exit(r9);
            return;
        L8:
            if (r11 != 2) goto L10;
            long r14 = f.f(r9);     // Catch: Throwable -> L17
            f.b(r9, 1 + r14);     // Catch: Throwable -> L17
            Long.valueOf(r14);     // Catch: Throwable -> L17
            goto L15
        L10:
            if (r11 == 3) goto L12;
        L11:
            x r15 = x.f38692a;     // Catch: Throwable -> L17
            goto L15
        L12:
            f.c(r9, f.g(r9) + 1);     // Catch: Throwable -> L17
            o.a(r9, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L17
            ZeusTransformUtils.preCheckCast(r9, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L20:
            f.a(this.f40003a).a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new c(this.f40003a.d() + " ping", true, this.f40003a, r11, r12), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
        }

        @Override // okhttp3.internal.g.h.c
        public void a(int r4, okhttp3.internal.g.b r5, e.h r6) {
            o.e(r5, "errorCode");
            o.e(r6, "debugData");
            r6.k();
            f r7 = this.f40003a;
            monitor-enter(r7);
            int r0 = 0;
            Object[] r8 = r7.c().values().toArray(new okhttp3.internal.g.i[0]);     // Catch: Throwable -> L15
            f.a(r7, true);     // Catch: Throwable -> L15
            x r1 = x.f38692a;     // Catch: Throwable -> L15
            monitor-exit(r7);
            okhttp3.internal.g.i[] r9 = (okhttp3.internal.g.i[]) ZeusTransformUtils.preCheckCast(r8, okhttp3.internal.g.i[].class, "com.obric.aiagent.plugin");
            int r10 = r9.length;
        L7:
            if (r0 >= r10) goto L14;
            okhttp3.internal.g.i r2 = r9[r0];
            if (r2.a() <= r4) goto L13;
            if (r2.n() == false) goto L13;
            r2.b(okhttp3.internal.g.b.i);
            this.f40003a.c(r2.a());
        L13:
            r0 = r0 + 1;
            goto L7
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.g.h.c
        public void a(int r3, long r4) {
            if (r3 != 0) goto L11;
            f r2 = this.f40003a;
            monitor-enter(r2);
            f.d(r2, r2.i() + r4);     // Catch: Throwable -> L8
            o.a(r2, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L8
            ZeusTransformUtils.preCheckCast(r2, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L8
            x r5 = x.f38692a;     // Catch: Throwable -> L8
            monitor-exit(r2);
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            okhttp3.internal.g.i r6 = this.f40003a.b(r3);
            if (r6 == null) goto L20;
            monitor-enter(r6);
            r6.d(r4);     // Catch: Throwable -> L17
            x r7 = x.f38692a;     // Catch: Throwable -> L17
            monitor-exit(r6);
            return;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.g.h.c
        public void a(int r2, int r3, List<okhttp3.internal.g.c> r4) {
            List<okhttp3.internal.g.c> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r5, "requestHeaders");
            this.f40003a.a(r3, r5);
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class e extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f40016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e.e f40017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f40018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f40019e;

        public e(String r1, boolean r2, f r3, int r4, e.e r5, int r6, boolean r7) {
            this.f40015a = r3;
            this.f40016b = r4;
            this.f40017c = r5;
            this.f40018d = r6;
            this.f40019e = r7;
            super(r1, r2);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            boolean r0 = f.j(this.f40015a).a(this.f40016b, (e.g) ZeusTransformUtils.preCheckCast(this.f40017c, e.g.class, "com.obric.aiagent.plugin"), this.f40018d, this.f40019e);     // Catch: IOException -> L18
            if (r0 == false) goto L5;
            this.f40015a.j().a(this.f40016b, okhttp3.internal.g.b.j);     // Catch: IOException -> L18
        L5:
            if (r0 == false) goto L7;
        L8:
            f r1 = this.f40015a;     // Catch: IOException -> L18
            monitor-enter(r1);     // Catch: IOException -> L18
            f.i(this.f40015a).remove(Integer.valueOf(this.f40016b));     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: IOException -> L18
            return -1;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L18
        L7:
            if (this.f40019e == true) goto L8;
            return -1;
        L23:
            return -1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.g.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class C1079f extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f40021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f40022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f40023d;

        public C1079f(String r3, boolean r4, f r5, int r6, List r7, boolean r8) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            this.f40020a = r5;
            this.f40021b = r6;
            this.f40022c = r9;
            this.f40023d = r8;
            super(r3, r4);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            boolean r0 = f.j(this.f40020a).a(this.f40021b, this.f40022c, this.f40023d);
            if (r0 == true) goto L21;
        L5:
            if (r0 == false) goto L7;
        L8:
            f r1 = this.f40020a;     // Catch: IOException -> L18
            monitor-enter(r1);     // Catch: IOException -> L18
            f.i(this.f40020a).remove(Integer.valueOf(this.f40021b));     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: IOException -> L18
            return -1;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L18
        L23:
            return -1;
        L7:
            if (this.f40023d == true) goto L8;
            return -1;
        L21:
            this.f40020a.j().a(this.f40021b, okhttp3.internal.g.b.j);     // Catch: IOException -> L18
            goto L5
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class g extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f40025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f40026c;

        public g(String r3, boolean r4, f r5, int r6, List r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            this.f40024a = r5;
            this.f40025b = r6;
            this.f40026c = r8;
            super(r3, r4);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            if (f.j(this.f40024a).a(this.f40025b, this.f40026c) == true) goto L17;
            return -1;
        L17:
            this.f40024a.j().a(this.f40025b, okhttp3.internal.g.b.j);     // Catch: IOException -> L14
            f r0 = this.f40024a;     // Catch: IOException -> L14
            monitor-enter(r0);     // Catch: IOException -> L14
            f.i(this.f40024a).remove(Integer.valueOf(this.f40025b));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: IOException -> L14
            return -1;
        L9:
            th = move-exception;
            throw th;     // Catch: IOException -> L14
        L19:
            return -1;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class h extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f40028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.g.b f40029c;

        public h(String r1, boolean r2, f r3, int r4, okhttp3.internal.g.b r5) {
            this.f40027a = r3;
            this.f40028b = r4;
            this.f40029c = r5;
            super(r1, r2);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            f.j(this.f40027a).a(this.f40028b, this.f40029c);
            f r0 = this.f40027a;
            monitor-enter(r0);
            f.i(this.f40027a).remove(Integer.valueOf(this.f40028b));     // Catch: Throwable -> L8
            x r3 = x.f38692a;     // Catch: Throwable -> L8
            monitor-exit(r0);
            return -1;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class i extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40030a;

        public i(String r1, boolean r2, f r3) {
            this.f40030a = r3;
            super(r1, r2);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            this.f40030a.a(false, 2, 0);
            return -1;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class j extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f40032b;

        public j(String r1, f r2, long r3) {
            this.f40031a = r2;
            this.f40032b = r3;
            super(r1, false, 2, null);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            f r0 = this.f40031a;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (f.e(this.f40031a) >= f.h(this.f40031a)) goto L7;
            boolean r1 = true;
        L9:
            monitor-exit(r0);
            if (r1 == false) goto L12;
            f.a(this.f40031a, null);
            return -1;
        L12:
            this.f40031a.a(false, 1, 0);
            return this.f40032b;
        L7:
            f.e(this.f40031a, f.h(this.f40031a) + 1);     // Catch: Throwable -> L14
            r1 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class k extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f40034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.g.b f40035c;

        public k(String r1, boolean r2, f r3, int r4, okhttp3.internal.g.b r5) {
            this.f40033a = r3;
            this.f40034b = r4;
            this.f40035c = r5;
            super(r1, r2);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            this.f40033a.b(this.f40034b, this.f40035c);     // Catch: IOException -> L4
            return -1;
        L4:
            e = move-exception;
            f.a(this.f40033a, e);
            return -1;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class l extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f40036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f40037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f40038c;

        public l(String r1, boolean r2, f r3, int r4, long r5) {
            this.f40036a = r3;
            this.f40037b = r4;
            this.f40038c = r5;
            super(r1, r2);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            this.f40036a.j().a(this.f40037b, this.f40038c);     // Catch: IOException -> L4
            return -1;
        L4:
            e = move-exception;
            f.a(this.f40036a, e);
            return -1;
        }
    }

    public final boolean d(int r1) {
        if (r1 != 0) goto L5;
    L7:
        return false;
    L5:
        if ((r1 & 1) != 0) goto L7;
        return true;
    }

    public f(a r8) {
        o.e(r8, "builder");
        boolean r0 = r8.a();
        this.f39992b = r0;
        this.f39993c = r8.g();
        this.f39994d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        String r1 = r8.d();
        this.f39995e = r1;
        if (r8.a() == false) goto L5;
        int r2 = 3;
    L6:
        this.g = r2;
        okhttp3.internal.c.d r3 = r8.b();
        this.i = r3;
        okhttp3.internal.c.c r4 = r3.c();
        this.j = r4;
        this.k = r3.c();
        this.l = r3.c();
        this.m = r8.h();
        m r5 = new m();
        if (r8.a() == false) goto L9;
        r5.a(7, 16777216);
    L9:
        this.t = r5;
        m r6 = D;
        this.u = r6;
        this.y = r6.b();
        this.z = r8.c();
        this.A = new okhttp3.internal.g.j(r8.f(), r0);
        this.B = new d(this, new okhttp3.internal.g.h(r8.e(), r0));
        this.C = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        if (r8.i() == 0) goto L13;
        long r7 = TimeUnit.MILLISECONDS.toNanos(r8.i());
        r4.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new j(r1 + " ping", this, r7), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), r7);
        return;
    L13:
        return;
    L5:
        r2 = 2;
        goto L6
    }

    public static final /* synthetic */ okhttp3.internal.c.c a(f r0) {
        return r0.j;
    }

    public static final /* synthetic */ void a(f r0, long r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void a(f r0, IOException r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(f r0, boolean r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ void b(f r0, long r1) {
        r0.q = r1;
    }

    public static final /* synthetic */ boolean b(f r0) {
        return r0.h;
    }

    public static final /* synthetic */ okhttp3.internal.c.d c(f r0) {
        return r0.i;
    }

    public static final /* synthetic */ void c(f r0, long r1) {
        r0.r = r1;
    }

    public static final /* synthetic */ okhttp3.internal.c.c d(f r0) {
        return r0.l;
    }

    public static final /* synthetic */ void d(f r0, long r1) {
        r0.y = r1;
    }

    public static final /* synthetic */ long e(f r2) {
        return r2.o;
    }

    public static final /* synthetic */ void e(f r0, long r1) {
        r0.n = r1;
    }

    public static final /* synthetic */ long f(f r2) {
        return r2.q;
    }

    public static final /* synthetic */ long g(f r2) {
        return r2.r;
    }

    public static final /* synthetic */ long h(f r2) {
        return r2.n;
    }

    public static final /* synthetic */ Set i(f r0) {
        return r0.C;
    }

    public static final /* synthetic */ okhttp3.internal.g.l j(f r0) {
        return r0.m;
    }

    public static final /* synthetic */ m m() {
        return D;
    }

    public final boolean a() {
        return this.f39992b;
    }

    public final c b() {
        return this.f39993c;
    }

    public final Map<Integer, okhttp3.internal.g.i> c() {
        return this.f39994d;
    }

    public final String d() {
        return this.f39995e;
    }

    public final void a(int r1) {
        this.f = r1;
    }

    public final int e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final m g() {
        return this.t;
    }

    public final void a(m r2) {
        o.e(r2, "<set-?>");
        this.u = r2;
    }

    public final m h() {
        return this.u;
    }

    public final long i() {
        return this.y;
    }

    public final okhttp3.internal.g.j j() {
        return this.A;
    }

    public final synchronized okhttp3.internal.g.i b(int r3) {
        monitor-enter(this);
        okhttp3.internal.g.i r4 = (okhttp3.internal.g.i) ZeusTransformUtils.preCheckCast(this.f39994d.get(Integer.valueOf(r3)), okhttp3.internal.g.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized okhttp3.internal.g.i c(int r3) {
        monitor-enter(this);
        okhttp3.internal.g.i r4 = (okhttp3.internal.g.i) ZeusTransformUtils.preCheckCast(this.f39994d.remove(Integer.valueOf(r3)), okhttp3.internal.g.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L6
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(long r3) {
        monitor-enter(this);
        long r0 = this.v + r3;     // Catch: Throwable -> L8
        this.v = r0;     // Catch: Throwable -> L8
        long r1 = r0 - this.w;     // Catch: Throwable -> L8
        if (r1 < (this.t.b() / 2)) goto L6;
        a(0, r1);     // Catch: Throwable -> L8
        this.w += r1;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final okhttp3.internal.g.i a(List<okhttp3.internal.g.c> r3, boolean r4) {
        List<okhttp3.internal.g.c> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "requestHeaders");
        return b(0, r5, r4);
    }

    private final okhttp3.internal.g.i b(int r11, List<okhttp3.internal.g.c> r12, boolean r13) {
        List<okhttp3.internal.g.c> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        boolean r6 = !r13;
        okhttp3.internal.g.j r7 = this.A;
        monitor-enter(r7);
        monitor-enter(this);     // Catch: Throwable -> L41
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L6:
        if (this.g <= 1073741823) goto L9;
        a(okhttp3.internal.g.b.i);     // Catch: Throwable -> L38
    L9:
        if (this.h == true) goto L37;
        int r8 = this.g;     // Catch: Throwable -> L38
        this.g = r8 + 2;     // Catch: Throwable -> L38
        okhttp3.internal.g.i r9 = new okhttp3.internal.g.i(r8, this, r6, false, null);     // Catch: Throwable -> L38
        if (r13 == true) goto L13;
    L18:
        boolean r15 = true;
    L20:
        if (r9.m() == false) goto L22;
        this.f39994d.put(Integer.valueOf(r8), r9);     // Catch: Throwable -> L38
    L22:
        x r1 = x.f38692a;     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L41
        if (r11 != 0) goto L27;
        this.A.a(r6, r8, r14);     // Catch: Throwable -> L41
    L29:
        x r16 = x.f38692a;     // Catch: Throwable -> L41
        monitor-exit(r7);
        if (r15 == false) goto L33;
        this.A.b();
    L33:
        return r9;
    L27:
        if ((true ^ this.f39992b) == false) goto L35;
        this.A.a(r11, r8, r14);     // Catch: Throwable -> L41
        goto L29
    L35:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());     // Catch: Throwable -> L41
    L13:
        if (this.x >= this.y) goto L18;
        if (r9.e() >= r9.f()) goto L18;
        r15 = false;
        goto L20
    L37:
        throw new okhttp3.internal.g.a();     // Catch: Throwable -> L38
    L41:
        th = move-exception;
        throw th;
    }

    public final void a(int r3, boolean r4, List<okhttp3.internal.g.c> r5) {
        List<okhttp3.internal.g.c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "alternating");
        this.A.a(r4, r3, r6);
    }

    public final void a(int r9, boolean r10, e.e r11, long r12) {
        if (r12 != 0) goto L7;
        this.A.a(r10, r9, r11, 0);
        return;
    L7:
        if (r12 <= 0) goto L32;
        monitor-enter(this);
    L33:
        long r4 = this.x;     // Catch: Throwable -> L26 InterruptedException -> L28
        long r6 = this.y;     // Catch: Throwable -> L26 InterruptedException -> L28
        if (r4 < r6) goto L17;
        if (this.f39994d.containsKey(Integer.valueOf(r9)) == false) goto L15;
        o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L26 InterruptedException -> L28
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").wait();     // Catch: Throwable -> L26 InterruptedException -> L28
        goto L33
    L15:
        throw new IOException("stream closed");     // Catch: Throwable -> L26 InterruptedException -> L28
    L17:
        int r2 = Math.min((int) Math.min(r12, r6 - r4), this.A.c());     // Catch: Throwable -> L26
        long r7 = r2;
        this.x += r7;     // Catch: Throwable -> L26
        x r5 = x.f38692a;     // Catch: Throwable -> L26
        monitor-exit(this);
        r12 = r12 - r7;
        okhttp3.internal.g.j r8 = this.A;
        if (r10 == true) goto L22;
    L24:
        boolean r13 = false;
    L25:
        r8.a(r13, r9, r11, r2);
        goto L7
    L22:
        if (r12 != 0) goto L24;
        r13 = true;
    L28:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L26
        throw new InterruptedIOException();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final void a(int r9, okhttp3.internal.g.b r10) {
        o.e(r10, "errorCode");
        this.j.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new k(this.f39995e + '[' + r9 + "] writeSynReset", true, this, r9, r10), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
    }

    public final void b(int r2, okhttp3.internal.g.b r3) {
        o.e(r3, "statusCode");
        this.A.a(r2, r3);
    }

    public final void a(int r10, long r11) {
        this.j.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new l(this.f39995e + '[' + r10 + "] windowUpdate", true, this, r10, r11), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
    }

    public final void a(boolean r2, int r3, int r4) {
        this.A.a(r2, r3, r4);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        a(e);
    }

    public final void k() {
        this.A.b();
    }

    public final void a(okhttp3.internal.g.b r4) {
        o.e(r4, "statusCode");
        okhttp3.internal.g.j r0 = this.A;
        monitor-enter(r0);
        z.d r1 = new z.d();     // Catch: Throwable -> L20
        monitor-enter(this);     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L7:
        if (this.h == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L12:
        this.h = true;     // Catch: Throwable -> L17
        r1.f38502a = this.f;     // Catch: Throwable -> L17
        x r2 = x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L20
        this.A.a(r1.f38502a, r4, okhttp3.internal.c.f39833a);     // Catch: Throwable -> L20
        x r3 = x.f38692a;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(okhttp3.internal.g.b.f39964b, okhttp3.internal.g.b.j, null);
    }

    private final void a(IOException r3) {
        a(okhttp3.internal.g.b.f39965c, okhttp3.internal.g.b.f39965c, r3);
    }

    public static /* synthetic */ void a(f r0, boolean r1, okhttp3.internal.c.d r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = okhttp3.internal.c.d.f39849b;
    L8:
        r0.a(r1, r2);
    }

    public final void a(boolean r6, okhttp3.internal.c.d r7) {
        o.e(r7, "taskRunner");
        if (r6 == false) goto L7;
        this.A.a();
        this.A.b(this.t);
        int r8 = this.t.b();
        if (r8 == 65535) goto L7;
        this.A.a(0, r8 - SupportMenu.USER_MASK);
    L7:
        r7.c().a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new okhttp3.internal.c.c.a(this.f39995e, true, (d.h.a.a) ZeusTransformUtils.preCheckCast(this.B, d.h.a.a.class, "com.obric.aiagent.plugin")), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
    }

    public final synchronized boolean b(long r7) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.h == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.q >= this.p) goto L16;
        if (r7 < this.s) goto L16;
        monitor-exit(this);
        return false;
    L16:
        monitor-exit(this);
        return true;
    }

    public final void l() {
        monitor-enter(this);
        long r0 = this.q;     // Catch: Throwable -> L13
        long r2 = this.p;     // Catch: Throwable -> L13
        if (r0 >= r2) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.p = r2 + 1;     // Catch: Throwable -> L13
        this.s = System.nanoTime() + ((long) 1000000000);     // Catch: Throwable -> L13
        x r1 = x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(this);
        this.j.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new i(this.f39995e + " ping", true, this), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(int r10, List<okhttp3.internal.g.c> r11) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "requestHeaders");
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.C.contains(Integer.valueOf(r10)) == false) goto L9;
        a(r10, okhttp3.internal.g.b.f39965c);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L9:
        this.C.add(Integer.valueOf(r10));     // Catch: Throwable -> L13
        monitor-exit(this);
        this.k.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new g(this.f39995e + '[' + r10 + "] onRequest", true, this, r10, r5), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
    }

    public final void a(int r10, List<okhttp3.internal.g.c> r11, boolean r12) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "requestHeaders");
        this.k.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new C1079f(this.f39995e + '[' + r10 + "] onHeaders", true, this, r10, r7, r12), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
    }

    public final void a(int r11, e.g r12, int r13, boolean r14) {
        e.g r15 = (e.g) ZeusTransformUtils.wrapperContextForParams(r12, e.g.class, "com.obric.aiagent.plugin");
        o.e(r15, DBHelper.BATTERY_COL_SOURCE);
        e.e r7 = new e.e();
        long r2 = r13;
        r15.b(r2);
        r15.a(r7, r2);
        this.k.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new e(this.f39995e + '[' + r11 + "] onData", true, this, r11, r7, r13, r14), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
    }

    public final void c(int r9, okhttp3.internal.g.b r10) {
        o.e(r10, "errorCode");
        this.k.a((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(new h(this.f39995e + '[' + r9 + "] onReset", true, this, r9, r10), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0);
    }

    static {
        f39991a = new b(null);
        m r0 = new m();
        r0.a(7, SupportMenu.USER_MASK);
        r0.a(5, 16384);
        D = r0;
    }

    public final void a(okhttp3.internal.g.b r4, okhttp3.internal.g.b r5, IOException r6) {
        o.e(r4, "connectionCode");
        o.e(r5, "streamCode");
        if (okhttp3.internal.c.f == true) goto L5;
    L41:
        a(r4);     // Catch: IOException -> L31
    L10:
        Object[] r7 = null;
        monitor-enter(this);
        int r1 = 0;
        if ((!this.f39994d.isEmpty()) == false) goto L15;
        r7 = this.f39994d.values().toArray(new okhttp3.internal.g.i[0]);     // Catch: Throwable -> L28
        this.f39994d.clear();     // Catch: Throwable -> L28
    L15:
        x r0 = x.f38692a;     // Catch: Throwable -> L28
        monitor-exit(this);
        okhttp3.internal.g.i[] r8 = (okhttp3.internal.g.i[]) ZeusTransformUtils.preCheckCast(r7, okhttp3.internal.g.i[].class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L43;
        int r2 = r8.length;
    L20:
        if (r1 >= r2) goto L43;
        r8[r1].a(r5, r6);     // Catch: IOException -> L32
    L23:
        r1 = r1 + 1;
    L43:
        this.A.close();     // Catch: IOException -> L33
    L37:
        this.z.close();     // Catch: IOException -> L34
    L26:
        this.j.h();
        this.k.h();
        this.l.h();
        return;
    L28:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L41;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
