package com.ttnet.org.chromium.net.impl;

import android.net.TrafficStats;
import android.util.Log;
import com.android.volley.toolbox.HttpClientStack;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.b0;
import com.ttnet.org.chromium.net.x;
import com.ttnet.org.chromium.net.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends UrlRequestBase {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f18807s = "j";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f18808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f18811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f18812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f18813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f18814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VersionSafeCallbacks.f f18817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Executor f18818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f18819l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18820m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ReadableByteChannel f18821n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public t f18822o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f18823p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HttpURLConnection f18824q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public o f18825r;

    public class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f18826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f18827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f18828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f18829d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ j f18830e;

        /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.j$a$a, reason: collision with other inner class name */
        public class RunnableC0226a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f18831a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f18832b;

            public RunnableC0226a(a r10, Runnable r11) {
                this.f18832b = r10;
                this.f18831a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                int r10 = TrafficStats.getThreadStatsTag();
                TrafficStats.setThreadStatsTag(this.f18832b.f18827b);
                a r11 = this.f18832b;
                if (r11.f18828c == false) goto L17;
                x.b(r11.f18829d);
            L17:
                this.f18831a.run();     // Catch: Throwable -> L11
                if (this.f18832b.f18828c == false) goto L9;
                x.a();
            L9:
                TrafficStats.setThreadStatsTag(r10);
                return;
            L11:
                th = move-exception;
                if (this.f18832b.f18828c == false) goto L15;
                x.a();
            L15:
                TrafficStats.setThreadStatsTag(r10);
                throw th;
            }
        }

        public a(j r10, Executor r11, int r12, boolean r13, int r14) {
            this.f18830e = r10;
            this.f18826a = r11;
            this.f18827b = r12;
            this.f18828c = r13;
            this.f18829d = r14;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            this.f18826a.execute(new RunnableC0226a(this, r10));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JavaUrlRequestUtils$CheckedRunnable f18833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f18834b;

        public b(j r10, JavaUrlRequestUtils$CheckedRunnable r11) {
            this.f18834b = r10;
            this.f18833a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18833a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            j.c0(this.f18834b, th);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f18835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f18836b;

        public class a implements JavaUrlRequestUtils$CheckedRunnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f18837a;

            public a(c r10) {
                this.f18837a = r10;
            }

            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
            public void run() {
                if (j.C(this.f18837a.f18836b) != null) goto L5;
                int r10 = -1;
            L6:
                c r11 = this.f18837a;
                j.S(r11.f18836b, r10, r11.f18835a);
                return;
            L5:
                r10 = j.C(this.f18837a.f18836b).read(this.f18837a.f18835a);
                goto L6
            }
        }

        public c(j r10, ByteBuffer r11) {
            this.f18836b = r10;
            this.f18835a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.P(this.f18836b).execute(j.a0(this.f18836b, new a(this)));
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18838a;

        public d(j r10) {
            this.f18838a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.M(this.f18838a) == null) goto L9;
            j.M(this.f18838a).x();     // Catch: IOException -> L6
        L6:
            e = move-exception;
            Log.e(j.T(), "Exception when closing OutputChannel", e);
        L9:
            if (j.w(this.f18838a) == null) goto L14;
            j.w(this.f18838a).disconnect();
            j.x(this.f18838a, null);
            return;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18839a;

        public e(j r10) {
            this.f18839a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.C(this.f18839a) == null) goto L12;
            j.C(this.f18839a).close();     // Catch: IOException -> L6
        L8:
            j.D(this.f18839a, null);
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18840a;

        public f(j r10) {
            this.f18840a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.s(this.f18840a).add(j.d0(this.f18840a));
            j.t(this.f18840a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18841a;

        public g(j r10) {
            this.f18841a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            j r10 = this.f18841a;
            j.e0(r10, j.u(r10));
            j.v(this.f18841a, null);
            j.t(this.f18841a);
        }
    }

    public class h implements JavaUrlRequestUtils$CheckedRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18842a;

        public h(j r10) {
            this.f18842a = r10;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
        public void run() {
            if (j.w(this.f18842a) != null) goto L5;
            return;
        L5:
            ArrayList r10 = new ArrayList();
            String r11 = "http/1.1";
            int r12 = 0;
        L6:
            String r13 = j.w(this.f18842a).getHeaderFieldKey(r12);
            if (r13 == null) goto L15;
            if ("X-Android-Selected-Transport".equalsIgnoreCase(r13) == false) goto L12;
            r11 = j.w(this.f18842a).getHeaderField(r12);
        L12:
            if (r13.startsWith("X-Android") == true) goto L14;
            r10.add(new AbstractMap.SimpleEntry(r13, j.w(this.f18842a).getHeaderField(r12)));
        L14:
            r12 = r12 + 1;
            goto L6
        L15:
            int r14 = j.w(this.f18842a).getResponseCode();
            j.z(this.f18842a, new t(new ArrayList(j.s(this.f18842a)), r14, j.w(this.f18842a).getResponseMessage(), Collections.unmodifiableList(r10), false, r11, "", 0));
            if (r14 < 300) goto L22;
            if (r14 >= 400) goto L22;
            List r15 = (List) j.y(this.f18842a).a().get("location");
            if (r15 == null) goto L22;
            j.A(this.f18842a, (String) r15.get(0));
            return;
        L22:
            j.B(this.f18842a);
            if (r14 < 400) goto L29;
            InputStream r16 = j.w(this.f18842a).getErrorStream();
            j r17 = this.f18842a;
            if (r16 != null) goto L27;
            ReadableByteChannel r18 = null;
        L28:
            j.D(r17, r18);
            j.E(this.f18842a).f(j.y(this.f18842a));
            return;
        L27:
            r18 = com.ttnet.org.chromium.net.impl.i.a(r16);
            goto L28
        L29:
            j r19 = this.f18842a;
            j.D(r19, com.ttnet.org.chromium.net.impl.i.a(j.w(r19).getInputStream()));
            j.E(this.f18842a).f(j.y(this.f18842a));
        }
    }

    public class i implements JavaUrlRequestUtils$CheckedRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18843a;

        public i(j r10) {
            this.f18843a = r10;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
        public void run() {
            j.F(this.f18843a).close();
        }
    }

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.j$j, reason: collision with other inner class name */
    public class RunnableC0227j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f18845b;

        /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.j$j$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RunnableC0227j f18846a;

            public a(RunnableC0227j r10) {
                this.f18846a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                j.E(this.f18846a.f18845b).e(j.y(this.f18846a.f18845b), j.u(this.f18846a.f18845b));
            }
        }

        public RunnableC0227j(j r10, String r11) {
            this.f18845b = r10;
            this.f18844a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            j r10 = this.f18845b;
            j.v(r10, URI.create(j.d0(r10)).resolve(this.f18844a).toString());
            j.s(this.f18845b).add(j.u(this.f18845b));
            j.G(this.f18845b, 2, 3, new a(this));
        }
    }

    public class k implements JavaUrlRequestUtils$CheckedRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f18847a;

        public k(j r10) {
            this.f18847a = r10;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
        public void run() {
            if (((Integer) j.H(this.f18847a).get()).intValue() != 8) goto L5;
            return;
        L5:
            URL r10 = new URL(j.d0(this.f18847a));
            if (j.w(this.f18847a) == null) goto L8;
            j.w(this.f18847a).disconnect();
            j.x(this.f18847a, null);
        L8:
            j.x(this.f18847a, (HttpURLConnection) r10.openConnection());
            boolean r11 = false;
            j.w(this.f18847a).setInstanceFollowRedirects(false);
            if (j.I(this.f18847a).containsKey("User-Agent") == true) goto L11;
            j.I(this.f18847a).put("User-Agent", j.J(this.f18847a));
        L11:
            Iterator r12 = j.I(this.f18847a).entrySet().iterator();
        L13:
            if (r12.hasNext() == false) goto L16;
            Map.Entry r13 = (Map.Entry) r12.next();
            j.w(this.f18847a).setRequestProperty((String) r13.getKey(), (String) r13.getValue());
            goto L13
        L16:
            if (j.K(this.f18847a) != null) goto L18;
            j.L(this.f18847a, "GET");
        L18:
            j.w(this.f18847a).setRequestMethod(j.K(this.f18847a));
            if (j.F(this.f18847a) == null) goto L24;
            j r14 = this.f18847a;
            j.N(r14, new o(r14, j.O(r14), j.P(this.f18847a), j.w(this.f18847a), j.F(this.f18847a)));
            o r15 = j.M(this.f18847a);
            if (j.s(this.f18847a).size() != 1) goto L23;
            r11 = true;
        L23:
            r15.v(r11);
            return;
        L24:
            j.Y(this.f18847a, 10);
            j.w(this.f18847a).connect();
            j.Z(this.f18847a);
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JavaUrlRequestUtils$CheckedRunnable f18848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f18849b;

        public l(j r10, JavaUrlRequestUtils$CheckedRunnable r11) {
            this.f18849b = r10;
            this.f18848a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18848a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            j.Q(this.f18849b, th);
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JavaUrlRequestUtils$CheckedRunnable f18850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f18851b;

        public m(j r10, JavaUrlRequestUtils$CheckedRunnable r11) {
            this.f18851b = r10;
            this.f18850a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18850a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            j.R(this.f18851b, th);
        }
    }

    public final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VersionSafeCallbacks.g f18852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f18853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Executor f18854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f18855d;

        public class a implements JavaUrlRequestUtils$CheckedRunnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f18856a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f18857b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ n f18858c;

            public a(n r10, b0 r11, String r12) {
                this.f18858c = r10;
                this.f18856a = r11;
                this.f18857b = r12;
            }

            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
            public void run() {
                n r10 = this.f18858c;
                r10.f18852a.e(r10.f18855d, this.f18856a, this.f18857b, "");
            }
        }

        public class b implements JavaUrlRequestUtils$CheckedRunnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f18859a;

            public b(n r10) {
                this.f18859a = r10;
            }

            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
            public void run() {
                if (androidx.lifecycle.p.a(j.H(this.f18859a.f18855d), 1, 4) == false) goto L6;
                n r10 = this.f18859a;
                VersionSafeCallbacks.g r11 = r10.f18852a;
                j r12 = r10.f18855d;
                r11.g(r12, j.y(r12), "");
                return;
            }
        }

        public class c implements JavaUrlRequestUtils$CheckedRunnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f18860a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f18861b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ n f18862c;

            public c(n r10, b0 r11, ByteBuffer r12) {
                this.f18862c = r10;
                this.f18860a = r11;
                this.f18861b = r12;
            }

            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
            public void run() {
                if (androidx.lifecycle.p.a(j.H(this.f18862c.f18855d), 5, 4) == false) goto L6;
                n r10 = this.f18862c;
                r10.f18852a.d(r10.f18855d, this.f18860a, this.f18861b);
                return;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f18863a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n f18864b;

            public d(n r10, b0 r11) {
                this.f18864b = r10;
                this.f18863a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                n r10 = this.f18864b;     // Catch: Exception -> L4
                r10.f18852a.a(r10.f18855d, this.f18863a);     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                Log.e(j.T(), "Exception in onCanceled method", e);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f18865a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n f18866b;

            public e(n r10, b0 r11) {
                this.f18866b = r10;
                this.f18865a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                n r10 = this.f18866b;     // Catch: Exception -> L4
                r10.f18852a.h(r10.f18855d, this.f18865a);     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                Log.e(j.T(), "Exception in onSucceeded method", e);
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f18867a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CronetException f18868b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ n f18869c;

            public f(n r10, b0 r11, CronetException r12) {
                this.f18869c = r10;
                this.f18867a = r11;
                this.f18868b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                n r10 = this.f18869c;     // Catch: Exception -> L4
                r10.f18852a.b(r10.f18855d, this.f18867a, this.f18868b);     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                Log.e(j.T(), "Exception in onFailed method", e);
            }
        }

        public n(j r10, a0.b r11, Executor r12) {
            this.f18855d = r10;
            this.f18852a = new VersionSafeCallbacks.g(r11);
            if (j.U(r10) == false) goto L5;
            this.f18853b = r12;
            this.f18854c = null;
            return;
        L5:
            this.f18853b = new com.ttnet.org.chromium.net.impl.l(r12);
            this.f18854c = r12;
        }

        public void a(JavaUrlRequestUtils$CheckedRunnable r10) {
            this.f18853b.execute(j.V(this.f18855d, r10));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            j.W(this.f18855d, new CronetExceptionImpl("Exception posting task to executor", e));
        }

        public void b(b0 r10) {
            j.X(this.f18855d);
            this.f18853b.execute(new d(this, r10));
        }

        public void c(b0 r10, CronetException r11) {
            j.X(this.f18855d);
            f r12 = new f(this, r10, r11);
            this.f18853b.execute(r12);     // Catch: InlineExecutionProhibitedException -> L5
            return;
        L5:
            Executor r13 = this.f18854c;
            if (r13 == null) goto L11;
            r13.execute(r12);
            return;
        }

        public void d(b0 r10, ByteBuffer r11) {
            a(new c(this, r10, r11));
        }

        public void e(b0 r10, String r11) {
            a(new a(this, r10, r11));
        }

        public void f(b0 r10) {
            a(new b(this));
        }

        public void g(b0 r10) {
            this.f18853b.execute(new e(this, r10));
        }
    }

    public final class o extends JavaUploadDataSinkBase {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final HttpURLConnection f18870h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AtomicBoolean f18871i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public WritableByteChannel f18872j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public OutputStream f18873k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ j f18874l;

        public o(j r10, Executor r11, Executor r12, HttpURLConnection r13, VersionSafeCallbacks.f r14) {
            this.f18874l = r10;
            super(r11, r12, r14);
            this.f18871i = new AtomicBoolean(false);
            this.f18870h = r13;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        public void o() {
            x();
            j.Z(this.f18874l);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        public Runnable p(JavaUrlRequestUtils$CheckedRunnable r10) {
            return j.a0(this.f18874l, r10);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        public Runnable q(JavaUrlRequestUtils$CheckedRunnable r10) {
            return j.b0(this.f18874l, r10);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        public void r() {
            if (this.f18872j != null) goto L6;
            j.Y(this.f18874l, 10);
            this.f18870h.setDoOutput(true);
            this.f18870h.connect();
            j.Y(this.f18874l, 12);
            OutputStream r10 = this.f18870h.getOutputStream();
            this.f18873k = r10;
            this.f18872j = Channels.newChannel(r10);
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        public void s(long r10) {
            if (r10 <= 0) goto L8;
            if (r10 > 2147483647L) goto L8;
            this.f18870h.setFixedLengthStreamingMode((int) r10);
            return;
        L8:
            if (r10 <= 2147483647L) goto L10;
            this.f18870h.setFixedLengthStreamingMode(r10);
            return;
        L10:
            this.f18870h.setChunkedStreamingMode(8192);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        public int t(ByteBuffer r10) {
            int r11 = 0;
        L4:
            if (r10.hasRemaining() == false) goto L6;
            r11 = r11 + this.f18872j.write(r10);
            goto L4
        L6:
            this.f18873k.flush();
            return r11;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        public void u(Throwable r10) {
            j.c0(this.f18874l, r10);
        }

        public void x() {
            if (this.f18872j != null) goto L5;
            return;
        L5:
            if (this.f18871i.compareAndSet(false, true) == false) goto L9;
            this.f18872j.close();
            return;
        }
    }

    public static final class p implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f18875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f18876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayDeque f18877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18878d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f18879a;

            public a(p r10) {
                this.f18879a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayDeque r10 = p.a(this.f18879a);
                monitor-enter(r10);
            L8:
                th = move-exception;
                throw th;
            L5:
                if (p.b(this.f18879a) == false) goto L10;
                monitor-exit(r10);     // Catch: Throwable -> L8
                return;
            L10:
                Runnable r11 = (Runnable) p.a(this.f18879a).pollFirst();     // Catch: Throwable -> L8
                p r12 = this.f18879a;     // Catch: Throwable -> L8
                if (r11 == null) goto L13;
                boolean r13 = true;
            L14:
                p.c(r12, r13);     // Catch: Throwable -> L8
                monitor-exit(r10);     // Catch: Throwable -> L8
            L16:
                if (r11 == null) goto L42;
                r11.run();     // Catch: Throwable -> L30
                ArrayDeque r14 = p.a(this.f18879a);
                monitor-enter(r14);
                r11 = (Runnable) p.a(this.f18879a).pollFirst();     // Catch: Throwable -> L27
                p r15 = this.f18879a;     // Catch: Throwable -> L27
                if (r11 == null) goto L23;
                boolean r16 = true;
            L24:
                p.c(r15, r16);     // Catch: Throwable -> L27
                monitor-exit(r14);     // Catch: Throwable -> L27
                goto L16
            L23:
                r16 = false;
            L27:
                th = move-exception;
                throw th;
            L30:
                th = move-exception;
                monitor-enter(p.a(this.f18879a));
                p.c(this.f18879a, false);     // Catch: Throwable -> L36
                p.e(this.f18879a).execute(p.d(this.f18879a));     // Catch: Throwable -> L36 RejectedExecutionException -> L45
            L38:
                throw th;
            L36:
                th = move-exception;
                throw th;
            L42:
                return;
            L13:
                r13 = false;
                goto L14
            }
        }

        public p(Executor r10) {
            this.f18876b = new a(this);
            this.f18877c = new ArrayDeque();
            this.f18875a = r10;
        }

        public static /* synthetic */ ArrayDeque a(p r10) {
            return r10.f18877c;
        }

        public static /* synthetic */ boolean b(p r10) {
            return r10.f18878d;
        }

        public static /* synthetic */ boolean c(p r10, boolean r11) {
            r10.f18878d = r11;
            return r11;
        }

        public static /* synthetic */ Runnable d(p r10) {
            return r10.f18876b;
        }

        public static /* synthetic */ Executor e(p r10) {
            return r10.f18875a;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            ArrayDeque r11 = this.f18877c;
            monitor-enter(r11);
            this.f18877c.addLast(r10);     // Catch: Throwable -> L7
            this.f18875a.execute(this.f18876b);     // Catch: Throwable -> L7 RejectedExecutionException -> L9
        L10:
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L9:
            this.f18877c.removeLast();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public j(a0.b r11, Executor r12, Executor r13, String r14, String r15, boolean r16, boolean r17, int r18, boolean r19, int r20) {
        this.f18811d = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.f18812e = new ArrayList();
        this.f18813f = new AtomicReference(0);
        this.f18814g = new AtomicBoolean(false);
        this.f18819l = -1;
        if (r14 == null) goto L20;
        if (r11 == null) goto L18;
        if (r12 == null) goto L16;
        if (r13 == null) goto L14;
        this.f18815h = r16;
        this.f18808a = new n(this, r11, r13);
        if (r17 == false) goto L10;
        int r10 = r18;
    L11:
        this.f18809b = new p(new a(this, r12, r10, r19, r20));
        this.f18820m = r14;
        this.f18810c = r15;
        return;
    L10:
        r10 = TrafficStats.getThreadStatsTag();
        goto L11
    L14:
        throw new NullPointerException("userExecutor is required");
    L16:
        throw new NullPointerException("Executor is required");
    L18:
        throw new NullPointerException("Listener is required");
    L20:
        throw new NullPointerException("URL is required");
    }

    public static /* synthetic */ void A(j r10, String r11) {
        r10.q0(r11);
    }

    public static /* synthetic */ void B(j r10) {
        r10.m0();
    }

    public static /* synthetic */ ReadableByteChannel C(j r10) {
        return r10.f18821n;
    }

    public static /* synthetic */ ReadableByteChannel D(j r10, ReadableByteChannel r11) {
        r10.f18821n = r11;
        return r11;
    }

    public static /* synthetic */ n E(j r10) {
        return r10.f18808a;
    }

    public static /* synthetic */ VersionSafeCallbacks.f F(j r10) {
        return r10.f18817j;
    }

    public static /* synthetic */ void G(j r10, int r11, int r12, Runnable r13) {
        r10.u0(r11, r12, r13);
    }

    public static /* synthetic */ AtomicReference H(j r10) {
        return r10.f18813f;
    }

    public static /* synthetic */ Map I(j r10) {
        return r10.f18811d;
    }

    public static /* synthetic */ String J(j r10) {
        return r10.f18810c;
    }

    public static /* synthetic */ String K(j r10) {
        return r10.f18816i;
    }

    public static /* synthetic */ String L(j r10, String r11) {
        r10.f18816i = r11;
        return r11;
    }

    public static /* synthetic */ o M(j r10) {
        return r10.f18825r;
    }

    public static /* synthetic */ o N(j r10, o r11) {
        r10.f18825r = r11;
        return r11;
    }

    public static /* synthetic */ Executor O(j r10) {
        return r10.f18818k;
    }

    public static /* synthetic */ Executor P(j r10) {
        return r10.f18809b;
    }

    public static /* synthetic */ void Q(j r10, Throwable r11) {
        r10.h0(r11);
    }

    public static /* synthetic */ void R(j r10, Throwable r11) {
        r10.k0(r11);
    }

    public static /* synthetic */ void S(j r10, int r11, ByteBuffer r12) {
        r10.s0(r11, r12);
    }

    public static /* synthetic */ String T() {
        return f18807s;
    }

    public static /* synthetic */ boolean U(j r10) {
        return r10.f18815h;
    }

    public static /* synthetic */ Runnable V(j r10, JavaUrlRequestUtils$CheckedRunnable r11) {
        return r10.w0(r11);
    }

    public static /* synthetic */ void W(j r10, CronetException r11) {
        r10.i0(r11);
    }

    public static /* synthetic */ void X(j r10) {
        r10.g0();
    }

    public static /* synthetic */ int Y(j r10, int r11) {
        r10.f18819l = r11;
        return r11;
    }

    public static /* synthetic */ void Z(j r10) {
        r10.o0();
    }

    public static /* synthetic */ Runnable a0(j r10, JavaUrlRequestUtils$CheckedRunnable r11) {
        return r10.l0(r11);
    }

    public static /* synthetic */ Runnable b0(j r10, JavaUrlRequestUtils$CheckedRunnable r11) {
        return r10.v0(r11);
    }

    public static /* synthetic */ void c0(j r10, Throwable r11) {
        r10.j0(r11);
    }

    public static /* synthetic */ String d0(j r10) {
        return r10.f18820m;
    }

    public static /* synthetic */ String e0(j r10, String r11) {
        r10.f18820m = r11;
        return r11;
    }

    private void f0() {
        int r10 = ((Integer) this.f18813f.get()).intValue();
        if (r10 != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Request is already started. State is: " + r10);
    }

    public static /* synthetic */ List s(j r10) {
        return r10.f18812e;
    }

    public static /* synthetic */ void t(j r10) {
        r10.p0();
    }

    public static /* synthetic */ String u(j r10) {
        return r10.f18823p;
    }

    public static /* synthetic */ String v(j r10, String r11) {
        r10.f18823p = r11;
        return r11;
    }

    public static /* synthetic */ HttpURLConnection w(j r10) {
        return r10.f18824q;
    }

    public static /* synthetic */ HttpURLConnection x(j r10, HttpURLConnection r11) {
        r10.f18824q = r11;
        return r11;
    }

    public static /* synthetic */ t y(j r10) {
        return r10.f18822o;
    }

    public static /* synthetic */ t z(j r10, t r11) {
        r10.f18822o = r11;
        return r11;
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void a(String r10, String r11) {
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void b() {
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void d() {
        int r10 = ((Integer) this.f18813f.getAndSet(8)).intValue();
        if (r10 != 1) goto L5;
    L13:
        n0();
        m0();
        this.f18808a.b(this.f18822o);
        return;
    L5:
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        if (r10 == 5) goto L13;
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void e() {
        u0(3, 1, new g(this));
    }

    @Override // com.ttnet.org.chromium.net.a0
    public String f() {
        return "";
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void g(ByteBuffer r10) {
        com.ttnet.org.chromium.net.impl.o.a(r10);
        com.ttnet.org.chromium.net.impl.o.b(r10);
        u0(4, 5, new c(this, r10));
    }

    public final void g0() {
        this.f18809b.execute(new e(this));
    }

    public final void h0(Throwable r10) {
        i0(new CronetExceptionImpl("System error", r10));
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void i(long r10) {
    }

    public final void i0(CronetException r10) {
        if (t0(6) == false) goto L6;
        n0();
        m0();
        this.f18808a.c(this.f18822o, r10);
        return;
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void j() {
        this.f18819l = 10;
        u0(0, 1, new f(this));
    }

    public final void j0(Throwable r10) {
        i0(new CallbackExceptionImpl("Exception received from UploadDataProvider", r10));
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void k(String r10, String r11) {
        f0();
        if (r0(r10) == false) goto L12;
        if (r11.contains("\r\n") == true) goto L12;
        if (this.f18811d.containsKey(r10) == false) goto L9;
        this.f18811d.remove(r10);
    L9:
        this.f18811d.put(r10, r11);
        return;
    L12:
        throw new IllegalArgumentException("Invalid header " + r10 + "=" + r11);
    }

    public final void k0(Throwable r10) {
        i0(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r10));
    }

    public final Runnable l0(JavaUrlRequestUtils$CheckedRunnable r10) {
        return new l(this, r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void m(String r10) {
        f0();
        if (r10 == null) goto L26;
        if ("OPTIONS".equalsIgnoreCase(r10) == false) goto L7;
    L23:
        this.f18816i = r10;
        return;
    L7:
        if ("GET".equalsIgnoreCase(r10) == true) goto L23;
        if ("HEAD".equalsIgnoreCase(r10) == true) goto L23;
        if ("POST".equalsIgnoreCase(r10) == true) goto L23;
        if ("PUT".equalsIgnoreCase(r10) == true) goto L23;
        if ("DELETE".equalsIgnoreCase(r10) == true) goto L23;
        if ("TRACE".equalsIgnoreCase(r10) == true) goto L23;
        if (HttpClientStack.HttpPatch.METHOD_NAME.equalsIgnoreCase(r10) == true) goto L23;
        throw new IllegalArgumentException("Invalid http method " + r10);
    L26:
        throw new NullPointerException("Method is required.");
    }

    public final void m0() {
        if (this.f18817j != null) goto L5;
        return;
    L5:
        if (this.f18814g.compareAndSet(false, true) == false) goto L14;
        this.f18818k.execute(v0(new i(this)));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(f18807s, "Exception when closing uploadDataProvider", e);
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void n(int r10) {
    }

    public final void n0() {
        this.f18809b.execute(new d(this));
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void o(int r10) {
    }

    public final void o0() {
        this.f18819l = 13;
        this.f18809b.execute(l0(new h(this)));
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void p(int r10) {
    }

    public final void p0() {
        this.f18809b.execute(l0(new k(this)));
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void q(int r10) {
    }

    public final void q0(String r10) {
        u0(1, 2, new RunnableC0227j(this, r10));
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void r(y r10, Executor r11) {
        if (r10 == null) goto L16;
        if (this.f18811d.containsKey("Content-Type") == false) goto L14;
        f0();
        if (this.f18816i != null) goto L8;
        this.f18816i = "POST";
    L8:
        this.f18817j = new VersionSafeCallbacks.f(r10);
        if (this.f18815h == false) goto L11;
        this.f18818k = r11;
        return;
    L11:
        this.f18818k = new com.ttnet.org.chromium.net.impl.l(r11);
        return;
    L14:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
    L16:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    public final boolean r0(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L23;
        char r12 = r10.charAt(r11);
        if (r12 == ',') goto L22;
        if (r12 == '/') goto L22;
        if (r12 == '{') goto L22;
        if (r12 == '}') goto L22;
        switch(r12) {
            case 39: goto L22;
            case 40: goto L22;
            case 41: goto L22;
            default: goto L14;
        };
    L14:
        switch(r12) {
            case 58: goto L22;
            case 59: goto L22;
            case 60: goto L22;
            case 61: goto L22;
            case 62: goto L22;
            case 63: goto L22;
            case 64: goto L22;
            default: goto L15;
        };
    L15:
        switch(r12) {
            case 91: goto L22;
            case 92: goto L22;
            case 93: goto L22;
            default: goto L17;
        };
    L17:
        if (Character.isISOControl(r12) == true) goto L22;
        if (Character.isWhitespace(r12) == true) goto L22;
        r11 = r11 + 1;
    L22:
        return false;
    L23:
        return true;
    }

    public final void s0(int r10, ByteBuffer r11) {
        if (r10 == (-1)) goto L5;
        this.f18808a.d(this.f18822o, r11);
        return;
    L5:
        ReadableByteChannel r12 = this.f18821n;
        if (r12 == null) goto L9;
        r12.close();
    L9:
        if (androidx.lifecycle.p.a(this.f18813f, 5, 7) == false) goto L13;
        n0();
        this.f18808a.g(this.f18822o);
        return;
    }

    public final boolean t0(int r10) {
    L2:
        Integer r11 = (Integer) this.f18813f.get();
        int r12 = r11.intValue();
        if (r12 == 0) goto L17;
        if (r12 == 6) goto L14;
        if (r12 == 7) goto L24;
        if (r12 == 8) goto L25;
        if (androidx.lifecycle.p.a(this.f18813f, r11, Integer.valueOf(r10)) == false) goto L2;
        return true;
    L25:
        return false;
    L24:
        return false;
    L14:
        return false;
    L17:
        throw new IllegalStateException("Can't enter error state before start");
    }

    public final void u0(int r10, int r11, Runnable r12) {
        if (androidx.lifecycle.p.a(this.f18813f, Integer.valueOf(r10), Integer.valueOf(r11)) == true) goto L11;
        int r13 = ((Integer) this.f18813f.get()).intValue();
        if (r13 != 8) goto L7;
        return;
    L7:
        if (r13 != 6) goto L10;
        return;
    L10:
        throw new IllegalStateException("Invalid state transition - expected " + r10 + " but was " + r13);
    L11:
        r12.run();
    }

    public final Runnable v0(JavaUrlRequestUtils$CheckedRunnable r10) {
        return new b(this, r10);
    }

    public final Runnable w0(JavaUrlRequestUtils$CheckedRunnable r10) {
        return new m(this, r10);
    }
}
