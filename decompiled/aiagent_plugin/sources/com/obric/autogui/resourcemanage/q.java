package com.obric.autogui.resourcemanage;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResourceDownloader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    private static final String TAG = "resource_downloader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f30653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f30654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f30655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<v, j> f30656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.b<String, Map<String, String>> f30657e;
    private final t f;
    private final d.h.a.b<o, d.x> g;
    private final d.h.a.b<o, d.x> h;
    private final d.h.a.m<o, File, d.x> i;
    private final d.h.a.m<o, File, d.x> j;
    private final d.h.a.b<JSONObject, d.x> k;
    private final AtomicReference<a> l;

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f30658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final v f30659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final w f30660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f30661d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b f30662e;
        private ca f;
        private int g;
        private int h;
        private x i;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f30658a, r6.f30658a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f30659b, r6.f30659b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f30660c, r6.f30660c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30658a.hashCode() * 31) + this.f30659b.hashCode()) * 31) + this.f30660c.hashCode();
        }

        public String toString() {
            return "ActiveRequest(policy=" + this.f30658a + ", requestParams=" + this.f30659b + ", completion=" + this.f30660c + ')';
        }

        public a(j r2, v r3, w r4) {
            d.h.b.o.e(r2, "policy");
            d.h.b.o.e(r3, "requestParams");
            d.h.b.o.e(r4, "completion");
            this.f30658a = r2;
            this.f30659b = r3;
            this.f30660c = r4;
            this.f30661d = new Object();
            this.f30662e = b.f30663a;
        }

        public final j a() {
            return this.f30658a;
        }

        public final v b() {
            return this.f30659b;
        }

        public final w c() {
            return this.f30660c;
        }

        public final boolean a(ca r5) {
            ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r5, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "job");
            Object r0 = this.f30661d;
            monitor-enter(r0);
            boolean r3 = false;
            if (this.f30662e != b.f30663a) goto L10;
            this.f = r6;     // Catch: Throwable -> L12
            if (this.i == null) goto L10;
            r3 = true;
        L10:
            monitor-exit(r0);
            return r3;
        L12:
            th = move-exception;
            throw th;
        }

        public final x b(ca r4) {
            ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "job");
            Object r0 = this.f30661d;
            monitor-enter(r0);
            x r2 = null;
            if (this.f != r5) goto L8;
            this.f = null;     // Catch: Throwable -> L14
        L8:
            if (this.f30662e != b.f30663a) goto L12;
            r2 = this.i;     // Catch: Throwable -> L14
            if (r2 != null) goto L12;
            r2 = x.f30693b;     // Catch: Throwable -> L14
        L12:
            monitor-exit(r0);
            return r2;
        L14:
            th = move-exception;
            throw th;
        }

        public final x d() {
            Object r0 = this.f30661d;
            monitor-enter(r0);
            x r1 = this.i;     // Catch: Throwable -> L13
            if (r1 == null) goto L7;
        L11:
            monitor-exit(r0);
            return r1;
        L7:
            if (this.f30662e != b.f30663a) goto L9;
            this.f30662e = b.f30665c;     // Catch: Throwable -> L13
            x r3 = null;
        L10:
            r1 = r3;
            goto L11
        L9:
            r3 = x.f30693b;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        public final f e() {
            Object r0 = this.f30661d;
            monitor-enter(r0);
            x r1 = this.i;     // Catch: Throwable -> L14
            if (this.f30662e != b.f30663a) goto L9;
            if (r1 != null) goto L9;
            this.f30662e = b.f30664b;     // Catch: Throwable -> L14
            f r4 = new f(true, null);     // Catch: Throwable -> L14
        L12:
            monitor-exit(r0);
            return r4;
        L9:
            if (r1 != null) goto L11;
            r1 = x.f30693b;     // Catch: Throwable -> L14
        L11:
            r4 = new f(false, r1);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public final boolean a(int r5) {
            boolean r0 = false;
            if (r5 > 0) goto L5;
            return false;
        L5:
            Object r1 = this.f30661d;
            monitor-enter(r1);
        L19:
            th = move-exception;
            throw th;
        L8:
            if (this.f30662e != b.f30665c) goto L10;
        L12:
            this.f30662e = b.f30666d;     // Catch: Throwable -> L19
            this.g = r5;     // Catch: Throwable -> L19
            if (this.i == null) goto L17;
            if (c(r5) == false) goto L17;
            r0 = true;
        L17:
            monitor-exit(r1);
            return r0;
        L10:
            if (this.f30662e == b.f30666d) goto L12;
            goto L12
        }

        public final d a(x r5) {
            d.h.b.o.e(r5, "result");
            Object r0 = this.f30661d;
            monitor-enter(r0);
            d r3 = null;
            r3 = null;
            ca r4 = null;
            if (this.f30662e != b.f30664b) goto L7;
        L25:
            monitor-exit(r0);
            return r3;
        L7:
            if (this.f30662e == b.f) goto L25;
            if (this.i != null) goto L13;
            this.i = r5;     // Catch: Throwable -> L27
        L13:
            if (this.f30662e != b.f30663a) goto L16;
            r4 = this.f;     // Catch: Throwable -> L27
        L16:
            if (this.f30662e == b.f30665c) goto L20;
            if (this.f30662e == b.f30666d) goto L20;
        L22:
            int r6 = 0;
        L23:
            r3 = new d(r4, r6);     // Catch: Throwable -> L27
        L20:
            if (c(this.g) == false) goto L22;
            r6 = this.g;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            throw th;
        }

        public final void b(int r3) {
            Object r0 = this.f30661d;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.h != r3) goto L7;
            this.h = 0;     // Catch: Throwable -> L10
        L7:
            d.x r2 = d.x.f38692a;     // Catch: Throwable -> L10
            monitor-exit(r0);
        }

        public final boolean f() {
            Object r0 = this.f30661d;
            monitor-enter(r0);
            if (this.i == null) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);
            return r1;
        L7:
            r1 = false;
        L10:
            th = move-exception;
            throw th;
        }

        public final x b(x r2) {
            d.h.b.o.e(r2, "fallback");
            Object r0 = this.f30661d;
            monitor-enter(r0);
            x r1 = this.i;     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            r2 = r1;
        L8:
            monitor-exit(r0);
            return r2;
        L10:
            th = move-exception;
            throw th;
        }

        public final c g() {
            Object r0 = this.f30661d;
            monitor-enter(r0);
            c r3 = null;
            if (this.f30662e != b.f30665c) goto L7;
        L9:
            this.g = 0;     // Catch: Throwable -> L16
            x r2 = this.i;     // Catch: Throwable -> L16
            if (r2 != null) goto L12;
            this.f30662e = b.f30667e;     // Catch: Throwable -> L16
            c r4 = new c(true, null);     // Catch: Throwable -> L16
        L13:
            r3 = r4;
        L14:
            monitor-exit(r0);
            return r3;
        L12:
            r4 = new c(false, r2);     // Catch: Throwable -> L16
            goto L13
        L7:
            if (this.f30662e == b.f30666d) goto L9;
        L16:
            th = move-exception;
            throw th;
        }

        public final x c(x r4) {
            d.h.b.o.e(r4, "fallback");
            Object r0 = this.f30661d;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.f30662e != b.f30665c) goto L7;
        L9:
            this.g = 0;     // Catch: Throwable -> L15
            x r3 = this.i;     // Catch: Throwable -> L15
            if (r3 == null) goto L13;
            r4 = r3;
        L13:
            monitor-exit(r0);
            return r4;
        L7:
            if (this.f30662e == b.f30666d) goto L9;
            r4 = null;
            goto L13
        }

        public final boolean h() {
            Object r0 = this.f30661d;
            monitor-enter(r0);
            boolean r3 = false;
            if (this.f30662e == b.f) goto L9;
            this.f30662e = b.f;     // Catch: Throwable -> L11
            this.f = null;     // Catch: Throwable -> L11
            this.g = 0;     // Catch: Throwable -> L11
            r3 = true;
        L9:
            monitor-exit(r0);
            return r3;
        L11:
            th = move-exception;
            throw th;
        }

        private final boolean c(int r2) {
            if (r2 > 0) goto L4;
            return false;
        L4:
            if (this.h == r2) goto L10;
            this.h = r2;
            return true;
        L10:
            return false;
        }
    }

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f30663a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f30664b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f30665c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f30666d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f30667e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] g = null;
        private static final /* synthetic */ d.d.a h = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f30663a, f30664b, f30665c, f30666d, f30667e, f};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f30663a = new b("CONFIG", 0);
            f30664b = new b("CONFIG_TERMINAL_OWNED", 1);
            f30665c = new b("BINARY_STARTING", 2);
            f30666d = new b("BINARY_ACTIVE", 3);
            f30667e = new b("INSTALLING", 4);
            f = new b("TERMINAL", 5);
            b[] r0 = a();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f30668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x f30669b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f30668a == r6.f30668a) goto L12;
            return false;
        L12:
            if (this.f30669b == r6.f30669b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f30668a) * 31;
            x r1 = this.f30669b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "BinarySuccessDecision(installAllowed=" + this.f30668a + ", cancellationResult=" + this.f30669b + ')';
        }

        public c(boolean r1, x r2) {
            this.f30668a = r1;
            this.f30669b = r2;
        }

        public final boolean a() {
            return this.f30668a;
        }

        public final x b() {
            return this.f30669b;
        }
    }

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ca f30670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30671b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f30670a, r6.f30670a) == true) goto L12;
            return false;
        L12:
            if (this.f30671b == r6.f30671b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            ca r0 = this.f30670a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Integer.hashCode(this.f30671b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "CancellationWork(configJob=" + this.f30670a + ", downloadId=" + this.f30671b + ')';
        }

        public d(ca r3, int r4) {
            this.f30670a = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
            this.f30671b = r4;
        }

        public final ca a() {
            return this.f30670a;
        }

        public final int b() {
            return this.f30671b;
        }
    }

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    public static final class e {
        public /* synthetic */ e(d.h.b.h r1) {
            this();
        }

        private e() {
        }
    }

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f30672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x f30673b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (this.f30672a == r6.f30672a) goto L12;
            return false;
        L12:
            if (this.f30673b == r6.f30673b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f30672a) * 31;
            x r1 = this.f30673b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ConfigTerminalDecision(sideEffectsAllowed=" + this.f30672a + ", cancellationResult=" + this.f30673b + ')';
        }

        public f(boolean r1, x r2) {
            this.f30672a = r1;
            this.f30673b = r2;
        }

        public final boolean a() {
            return this.f30672a;
        }

        public final x b() {
            return this.f30673b;
        }
    }

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    @d.c.b.a.f(b = "ResourceDownloader.kt", c = {366}, d = "invokeSuspend", e = "com.obric.autogui.resourcemanage.ResourceDownloader$fetchAndDownload$configJob$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f30675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f30676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f30677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f30678e;
        final /* synthetic */ com.obric.autogui.tools.api.net.a f;
        final /* synthetic */ Map<String, String> g;
        final /* synthetic */ String h;
        final /* synthetic */ k i;
        final /* synthetic */ long j;
        final /* synthetic */ v k;

        g(w r3, Context r4, q r5, a r6, com.obric.autogui.tools.api.net.a r7, Map<String, String> r8, String r9, k r10, long r11, v r13, d.c.d<? super g> r14) {
            Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            com.obric.autogui.tools.api.net.a r15 = (com.obric.autogui.tools.api.net.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.tools.api.net.a.class, "com.obric.aiagent.plugin");
            Map<String, String> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30675b = r3;
            this.f30676c = ZeusTransformUtils.wrapperContext(r12, "com.obric.aiagent.plugin");
            this.f30677d = r5;
            this.f30678e = r6;
            this.f = r15;
            this.g = r16;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r13;
            super(2, r17);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r17, d.c.d<?> r18) {
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f30675b, this.f30676c, this.f30677d, this.f30678e, this.f, this.g, this.h, this.i, this.j, this.k, r15), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30674a;
            boolean r2 = true;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            d.o.a(r13);     // Catch: Exception -> L7 CancellationException -> L9
        L25:
            com.obric.autogui.tools.api.net.a.InterfaceC0861a r14 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            if (this.f30675b.a() == false) goto L30;
            return d.x.f38692a;
        L30:
            if (com.obric.autogui.resourcemanage.g.f30624a.b(this.f30676c) == true) goto L34;
            q.a(this.f30677d, this.f30678e, x.f30695d);     // Catch: Exception -> L7 CancellationException -> L9
            return d.x.f38692a;
        L34:
            if (r14.a() == false) goto L36;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r14.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            v r15 = this.k;     // Catch: Exception -> L7 CancellationException -> L9
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L43;
            Loog.INSTANCE.d(q.TAG, "response data of " + r15.a() + ": " + r8);     // Catch: Exception -> L7 CancellationException -> L9
        L43:
            CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            if (r16 != null) goto L46;
        L49:
            if (r2 == true) goto L51;
            q.a(this.f30677d, this.f30676c, this.f30678e, r8, this.i, this.j);     // Catch: Exception -> L7 CancellationException -> L9
        L70:
            return d.x.f38692a;
        L51:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L53;
            Loog.INSTANCE.d(q.TAG, "response data is empty");     // Catch: Exception -> L7 CancellationException -> L9
        L53:
            q.a(this.f30677d, this.f30678e, x.f30693b);     // Catch: Exception -> L7 CancellationException -> L9
            return d.x.f38692a;
        L46:
            if (r16.length() == 0) goto L49;
            r2 = false;
            goto L49
        L36:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L38;
            Loog.INSTANCE.d(q.TAG, "config request failed: " + r14);     // Catch: Exception -> L7 CancellationException -> L9
        L38:
            q.a(this.f30677d, this.f30678e, x.f30693b);     // Catch: Exception -> L7 CancellationException -> L9
            return d.x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r13);
            if (this.f30675b.a() == false) goto L19;
            return d.x.f38692a;
        L19:
            if (com.obric.autogui.resourcemanage.g.f30624a.b(this.f30676c) == true) goto L22;
            q.a(this.f30677d, this.f30678e, x.f30695d);     // Catch: Exception -> L7 CancellationException -> L9
            return d.x.f38692a;
        L22:
            com.obric.autogui.tools.api.net.a r5 = this.f;     // Catch: Exception -> L7 CancellationException -> L9
            Map<String, String> r7 = this.g;     // Catch: Exception -> L7 CancellationException -> L9
            String r9 = this.h;     // Catch: Exception -> L7 CancellationException -> L9
            int r10 = (int) q.a(this.f30677d).c();     // Catch: Exception -> L7 CancellationException -> L9
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            this.f30674a = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r13 = r5.a("https://zeus-api.obriccloud.com/zeus/client/v2/query", r7, r9, r10, r11);     // Catch: Exception -> L7 CancellationException -> L9
            if (r13 != r0) goto L25;
            return r0;
        L9:
            e = move-exception;
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L65;
            Loog.INSTANCE.d(q.TAG, "config request canceled: " + e);
        L65:
            if (com.obric.autogui.resourcemanage.g.f30624a.b(this.f30676c) == false) goto L67;
            x r17 = x.f30693b;
        L68:
            q r3 = this.f30677d;
            a r12 = this.f30678e;
            q.a(r3, r12, r12.b(r17));
            goto L70
        L67:
            r17 = x.f30695d;
        L7:
            e = move-exception;
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L60;
            Loog.INSTANCE.d(q.TAG, "request download bean failed: " + e);
        L60:
            q.a(this.f30677d, this.f30678e, x.f30693b);
            goto L70
        }
    }

    /* JADX INFO: compiled from: ResourceDownloader.kt */
    public static final class h extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f30679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f30680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f30681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f30682d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ o f30683e;
        final /* synthetic */ File f;
        final /* synthetic */ boolean g;

        h(AtomicBoolean r3, q r4, Context r5, a r6, o r7, File r8, boolean r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            this.f30679a = r3;
            this.f30680b = r4;
            this.f30681c = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
            this.f30682d = r6;
            this.f30683e = r7;
            this.f = r8;
            this.g = r9;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo r5) {
            super.onStart(r5);
            if (this.f30679a.get() == false) goto L6;
            return;
        L6:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L8;
            Loog.INSTANCE.d(q.TAG, "onStart: " + r5);
        L8:
            q r0 = this.f30680b;
            Context r2 = this.f30681c;
            a r3 = this.f30682d;
            if (r5 == null) goto L11;
            int r6 = r5.getId();
        L13:
            if (q.a(r0, r2, r3, r6) == true) goto L15;
            return;
        L15:
            o r4 = this.f30683e;
            d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L18
            ah.f30609a.b(r4.g(), System.currentTimeMillis());     // Catch: Throwable -> L18
            Object r8 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L18
        L20:
            Throwable r9 = d.n.c(r8);
            if (r9 != null) goto L23;
            return;
        L23:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L29;
            Loog.INSTANCE.d(q.TAG, "resource metrics failed: " + r9);
            return;
        L29:
            return;
        L18:
            th = move-exception;
            d.n.a r10 = d.n.f38560a;
            r8 = d.n.f(d.o.a(th));
            goto L20
        L11:
            r6 = 0;
            goto L13
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo r4) {
            super.onProgress(r4);
            if (this.f30679a.get() == false) goto L5;
            return;
        L5:
            q r0 = this.f30680b;
            Context r1 = this.f30681c;
            a r3 = this.f30682d;
            if (r4 == null) goto L8;
            int r2 = r4.getId();
        L10:
            if (q.a(r0, r1, r3, r2) == true) goto L13;
            return;
        L13:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L16;
            Loog.INSTANCE.d(q.TAG, "onProgress: " + r4);
            return;
        L16:
            return;
        L8:
            r2 = 0;
            goto L10
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo r11) {
            super.onSuccessed(r11);
            if (this.f30679a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            c r0 = this.f30682d.g();
            if (r0 != null) goto L9;
            return;
        L9:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L12;
            Loog.INSTANCE.d(q.TAG, "onSuccessed: " + r11);
        L12:
            if (r0.a() == true) goto L18;
            q r12 = this.f30680b;
            a r1 = this.f30682d;
            o r10 = this.f30683e;
            x r2 = r0.b();
            if (r2 != null) goto L16;
            r2 = x.f30693b;
        L16:
            q.a(r12, r1, r10, r2);
            return;
        L18:
            if (r11 == null) goto L20;
            long r3 = r11.getTotalBytes();
        L21:
            long r7 = r3;
            o r13 = this.f30683e;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L24
            ah.f30609a.a(r13.g(), System.currentTimeMillis(), r7);     // Catch: Throwable -> L24
            Object r14 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L24
        L26:
            Throwable r15 = d.n.c(r14);
            if (r15 != null) goto L29;
        L31:
            q.a(this.f30680b, this.f30681c, this.f30682d, this.f30683e, this.f, false, this.g);
            return;
        L29:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L31;
            Loog.INSTANCE.d(q.TAG, "resource metrics failed: " + r15);
        L24:
            th = move-exception;
            d.n.a r5 = d.n.f38560a;
            r14 = d.n.f(d.o.a(th));
            goto L26
        L20:
            r3 = this.f.length();
            goto L21
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo r5, BaseException r6) {
            super.onFailed(r5, r6);
            if (this.f30679a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            x r0 = this.f30682d.c(x.f30696e);
            if (r0 != null) goto L9;
            return;
        L9:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L11;
            Loog.INSTANCE.d(q.TAG, "onFailed: " + r5 + ", " + r6);
        L11:
            q.a(this.f30680b, this.f30682d, this.f30683e, r0);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo r10) {
            super.onCanceled(r10);
            int r2 = 0;
            if (this.f30679a.compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L8;
            Loog.INSTANCE.d(q.TAG, "onCanceled: " + r10);
        L8:
            Context r1 = this.f30681c;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
            h r5 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            if (com.obric.autogui.resourcemanage.g.f30624a.b(r1) == false) goto L12;
            x r3 = x.f30696e;     // Catch: Throwable -> L15
        L13:
            Object r6 = d.n.f(r3);     // Catch: Throwable -> L15
        L17:
            o r7 = this.f30683e;
            Throwable r8 = d.n.c(r6);
            if (r8 != null) goto L20;
        L25:
            x r11 = x.f30696e;
            if (d.n.b(r6) == false) goto L28;
            r6 = r11;
        L28:
            x r12 = this.f30682d.c((x) ZeusTransformUtils.preCheckCast(r6, x.class, "com.obric.aiagent.plugin"));
            if (r12 != null) goto L31;
            return;
        L31:
            q.a(this.f30680b, this.f30682d, this.f30683e, r12);
            return;
        L20:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L25;
            Loog r9 = Loog.INSTANCE;
            StringBuilder r13 = new StringBuilder().append("classify canceled download failed, key=").append(r7.g()).append(", id=");
            if (r10 == null) goto L24;
            r2 = r10.getId();
        L24:
            r9.d(q.TAG, r13.append(r2).append(", error=").append(r8).toString());
            goto L25
        L12:
            r3 = x.f30695d;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            d.n.a r14 = d.n.f38560a;
            r6 = d.n.f(d.o.a(th));
            goto L17
        }
    }

    static {
        f30653a = new e(null);
    }

    public static /* synthetic */ d.x lambda$7k22xx7Dra7fWUAhOL0rfhlBoBw(a r0, ca r1, q r2, Throwable r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$J4DSYiQ2KjTrP-L1E8SsEdhD9fY, reason: not valid java name */
    public static /* synthetic */ d.x m879lambda$J4DSYiQ2KjTrPL1E8SsEdhD9fY(q r0, a r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$sArUfFxom213Ff_WqIhVdc_VYQw(j r0, v r1) {
        return a(r0, r1);
    }

    public q(u r3, p r4, d.h.a.b<? super v, j> r5, d.h.a.b<? super String, ? extends Map<String, String>> r6, t r7, d.h.a.b<? super o, d.x> r8, d.h.a.b<? super o, d.x> r9, d.h.a.m<? super o, ? super File, d.x> r10, d.h.a.m<? super o, ? super File, d.x> r11, d.h.a.b<? super JSONObject, d.x> r12) {
        u r13 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.aiagent.plugin");
        d.h.a.b<v, j> r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, Map<String, String>> r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        t r16 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.aiagent.plugin");
        d.h.a.b<o, d.x> r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<o, d.x> r18 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<o, File, d.x> r19 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m<o, File, d.x> r110 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b<JSONObject, d.x> r111 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "requestFactory");
        d.h.b.o.e(r4, "config");
        d.h.b.o.e(r14, "requestPolicyProvider");
        d.h.b.o.e(r16, "installer");
        this.f30654b = r13;
        this.f30655c = r4;
        this.f30656d = r14;
        this.f30657e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r110;
        this.k = r111;
        this.l = new AtomicReference(null);
    }

    public static final /* synthetic */ p a(q r0) {
        return r0.f30655c;
    }

    public static final /* synthetic */ void a(q r7, Context r8, a r9, o r10, File r11, boolean r12, boolean r13) {
        r7.a((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), r9, r10, r11, r12, r13);
    }

    public static final /* synthetic */ void a(q r7, Context r8, a r9, String r10, k r11, long r12) {
        r7.a((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), r9, r10, r11, r12);
    }

    public static final /* synthetic */ void a(q r0, a r1, o r2, x r3) {
        r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ void a(q r0, a r1, x r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(q r2, Context r3, a r4, int r5) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public final void a(Context r36, k r37, String r38, d.h.a.b<? super x, d.x> r39) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r36, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r39, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        d.h.b.o.e(r37, DBHelper.BATTERY_COL_SCENE);
        d.h.b.o.e(r38, "requestDeviceId");
        d.h.b.o.e(r2, "onComplete");
        w r3 = new w(r2);
        com.obric.autogui.tools.api.net.a r6 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r6 != null) goto L77;
        q r0 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.aiagent.plugin");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L7;
        Loog.INSTANCE.d(TAG, "no http client");
    L7:
        w.a(r3, x.f30693b, null, 2, null);
        return;
    L77:
        v r16 = this.f30654b.a();     // Catch: Exception -> L71
        if (r37 != k.g) goto L13;
        final v r10 = v.a(r16, null, 0, 0, "0", 0, 0, null, null, 0, null, null, null, null, 8181, null);     // Catch: Exception -> L71
    L85:
        final j r5 = (j) ZeusTransformUtils.preCheckCast(this.f30656d.invoke(r10), j.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L65
        if (r5.a(r13, r10, r37) == false) goto L18;
        a r11 = new a(r5, r10, r3);
        if (this.l.compareAndSet(null, r11) == false) goto L25;
    L52:
        e = e;
        final a r4 = r11;
        String r34 = TAG;
    L55:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L57;
        Loog.INSTANCE.d(r34, "prepare request failed: " + e);
    L57:
        a(r4, x.f30693b);
        return;
    L30:
        if (r3.a() == false) goto L32;
        return;
    L32:
        String r8 = r10.c();     // Catch: Exception -> L52
        Map<String, String> r7 = a(r8, r38);     // Catch: Exception -> L52
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L36;
        Loog.INSTANCE.d(TAG, "request headers: " + r7);     // Catch: Exception -> L52
    L36:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L38;
        Loog.INSTANCE.d(TAG, "request body: " + r8);     // Catch: Exception -> L52
    L38:
        long r17 = System.currentTimeMillis();     // Catch: Exception -> L52
        am r18 = an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L52
        v r1 = r10;
        r34 = TAG;
        final ca r9 = kotlinx.coroutines.i.a(r18, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r3, r13, this, r11, r6, r7, r8, r37, r17, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L50
        r4 = r11;
        r9.a_(new $$Lambda$q$7k22xx7Dra7fWUAhOL0rfhlBoBw(r4, r9, this));     // Catch: Exception -> L48
        if (r4.a(r9) == false) goto L45;
    L46:
        a(r13, r4, x.f30695d);     // Catch: Exception -> L48
        r9.a(new CancellationException("eligible wifi lost before config request started"));     // Catch: Exception -> L48
        return;
    L45:
        if (com.obric.autogui.resourcemanage.g.f30624a.b(r13) == false) goto L46;
        return;
    L48:
        e = e;
    L50:
        e = e;
        r4 = r11;
        goto L55
    L25:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L27;
        Loog.INSTANCE.d(TAG, "resource downloader already owns an active request");
    L27:
        r3.a(x.f30692a, new $$Lambda$q$sArUfFxom213Ff_WqIhVdc_VYQw(r5, r10));
        return;
    L18:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        Loog.INSTANCE.d(TAG, "request strategy rejected, skip. scene=" + r37 + ", key=" + r10.b());
    L20:
        w.a(r3, x.f30692a, null, 2, null);
        return;
    L59:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L63;
        Loog.INSTANCE.d(TAG, "validate request policy failed: " + e);
    L63:
        w.a(r3, x.f30693b, null, 2, null);
        return;
    L65:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L69;
        Loog.INSTANCE.d(TAG, "create request policy failed: " + e);
    L69:
        w.a(r3, x.f30693b, null, 2, null);
        return;
    L13:
        r10 = r16;
    L71:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L75;
        Loog.INSTANCE.d(TAG, "create request params failed: " + e);
    L75:
        w.a(r3, x.f30693b, null, 2, null);
    }

    private static final d.x a(j r0, v r1) {
        r0.a(r1);
        return d.x.f38692a;
    }

    private static final d.x a(a r1, ca r2, q r3, Throwable r4) {
        x r5 = r1.b((ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L6;
        r3.a(r1, r5);
    L6:
        return d.x.f38692a;
    }

    public final boolean a(Context r4, x r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        d.h.b.o.e(r5, "result");
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.l.get(), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return false;
    L7:
        return a(r6, r0, r5);
    }

    private final boolean a(Context r4, a r5, x r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d r8 = r5.a(r6);
        if (r8 != null) goto L6;
        return false;
    L6:
        ca r0 = r8.a();
        if (r0 == null) goto L10;
        r0.a(new CancellationException("resource request canceled"));
    L10:
        if (r8.b() <= 0) goto L14;
        a(r7, r5, r8.b());
        return true;
    L14:
        return true;
    }

    private final void a(Context r18, a r19, String r20, k r21, long r22) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        v r0 = r19.b();
        if (r19.c().a() == false) goto L5;
        return;
    L5:
        ab.a r4 = ab.f30594a.a(r20);
        if (r4 != null) goto L9;
        a(r19, x.f30693b);
        return;
    L9:
        DownloadBean r12 = r4.a();
        String r10 = r4.b();
        if (r12 != null) goto L20;
        x r2 = x.f30694c;
        f r5 = r19.e();
        if (r5.a() == true) goto L17;
        x r1 = r5.b();
        if (r1 != null) goto L16;
        r1 = x.f30693b;
    L16:
        a(r19, r1);
        return;
    L17:
        com.obric.autogui.resourcemanage.d.f30616a.b(r0, System.currentTimeMillis());
        a(r19, r2);
        return;
    L20:
        if (r12.isValid() == false) goto L22;
        o r14 = new o(r0, r12, null, 4, null);
        if (r12.isUnInstall() == false) goto L37;
        x r3 = x.h;
        f r6 = r19.e();
        if (r6.a() == true) goto L34;
        x r7 = r6.b();
        if (r7 != null) goto L33;
        r7 = x.f30693b;
    L33:
        a(r19, r7);
        return;
    L34:
        a(r11, r14);
        com.obric.autogui.resourcemanage.d.f30616a.b(r0, System.currentTimeMillis());
        a(r19, r3);
        return;
    L37:
        if (r12.isRevert() == false) goto L46;
        x r8 = x.i;
        f r9 = r19.e();
        if (r9.a() == true) goto L44;
        x r13 = r9.b();
        if (r13 != null) goto L43;
        r13 = x.f30693b;
    L43:
        a(r19, r13);
        return;
    L44:
        b(r11, r14);
        com.obric.autogui.resourcemanage.d.f30616a.b(r0, System.currentTimeMillis());
        a(r19, r8);
        return;
    L46:
        o r15 = com.obric.autogui.resourcemanage.d.f30616a.a(r14.d());
        File r16 = com.obric.autogui.resourcemanage.d.f30616a.a(r11, r14.d());
        if (r21 == k.g) goto L69;
        if (r15 != null) goto L50;
    L52:
        boolean r17 = false;
    L53:
        if (r17 == false) goto L69;
        if (d.h.b.o.a(r15.f(), r14.f()) == false) goto L69;
        if (r16 == null) goto L69;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L60;
        Loog.INSTANCE.d(TAG, "same version already installed, skip. pkg=" + r14.d() + ", version=" + r14.e());
    L60:
        x r23 = x.f30694c;
        f r24 = r19.e();
        if (r24.a() == true) goto L66;
        x r25 = r24.b();
        if (r25 != null) goto L65;
        r25 = x.f30693b;
    L65:
        a(r19, r25);
        return;
    L66:
        com.obric.autogui.resourcemanage.d.f30616a.b(r0, System.currentTimeMillis());
        a(r19, r23);
        return;
    L50:
        if (r15.e() != r14.e()) goto L52;
        r17 = true;
    L69:
        if (r12.shouldDownload() == false) goto L71;
        d.n.a r26 = d.n.f38560a;     // Catch: Throwable -> L83
        ah.f30609a.a(r14, r0, r21, r22, r10);     // Catch: Throwable -> L83
        ah.f30609a.a(r14.g(), System.currentTimeMillis());     // Catch: Throwable -> L83
        Object r27 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L83
    L85:
        Throwable r28 = d.n.c(r27);
        if (r28 != null) goto L88;
    L90:
        x r29 = r19.d();
        if (r29 == null) goto L95;
        b(r19, r14, r29);
        return;
    L95:
        if (r21 != k.g) goto L97;
        boolean r30 = true;
    L98:
        a(r11, r19, r14, r12, r30);
        return;
    L97:
        r30 = false;
        goto L98
    L88:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L90;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r28);
    L83:
        th = move-exception;
        d.n.a r31 = d.n.f38560a;
        r27 = d.n.f(d.o.a(th));
        goto L85
    L71:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L73;
        Loog.INSTANCE.d(TAG, "downloadBean.shouldDownload() = false, skip. bean=" + r12);
    L73:
        x r32 = x.f30694c;
        f r33 = r19.e();
        if (r33.a() == true) goto L79;
        x r34 = r33.b();
        if (r34 != null) goto L78;
        r34 = x.f30693b;
    L78:
        a(r19, r34);
        return;
    L79:
        com.obric.autogui.resourcemanage.d.f30616a.b(r0, System.currentTimeMillis());
        a(r19, r32);
        return;
    L22:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L24;
        Loog.INSTANCE.d(TAG, "download bean invalid: " + r12 + ", logId=" + r10);
    L24:
        a(r19, x.f30693b);
    }

    private final void a(Context r20, a r21, o r22, DownloadBean r23, boolean r24) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        String r1 = r23.getMUrl();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
    L85:
        e = e;
        String r4 = TAG;
    L88:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L90;
        Loog.INSTANCE.d(r4, "binary preflight failed, key=" + r22.g() + ", error=" + e);
    L90:
        a(r21, r22, x.f30693b);
        return;
    L17:
        if (com.obric.autogui.resourcemanage.g.f30624a.b(r14) == false) goto L19;
        File r5 = com.obric.autogui.resourcemanage.d.f30616a.a(r14, this.f30655c);     // Catch: Exception -> L85
        File r6 = r22.a(r5);     // Catch: Exception -> L85
        if (r6.exists() == true) goto L28;
    L56:
        AtomicBoolean r7 = new AtomicBoolean(false);
        int r0 = Downloader.with(r14).url(r1).name(r6.getName()).onlyWifi(true).savePath(r5.getAbsolutePath()).retryCount(this.f30655c.d()).mimeType(DownloadConstants.MIME_PLUGIN).subThreadListener((IDownloadListener) ZeusTransformUtils.preCheckCast(new h(r7, this, r14, r21, r22, r6, r24), IDownloadListener.class, "com.obric.aiagent.plugin")).backUpUrls(r23.getMBackupUrlList()).download();     // Catch: Exception -> L71
        if (r7.get() == true) goto L105;
        if (r0 <= 0) goto L65;
    L69:
        b(r14, r21, r0);
        return;
    L65:
        if (r7.compareAndSet(false, true) == false) goto L69;
        x r8 = r21.c(x.f30696e);
        if (r8 == null) goto L106;
        b(r21, r22, r8);
        return;
    L106:
        return;
    L105:
        return;
    L71:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L108;
        Loog.INSTANCE.d(TAG, "SocialBase registration outcome unknown; waiting for terminal callback, key=" + r22.g() + ", error=" + e);
        return;
    L108:
        return;
    L76:
        e = e;
        String r9 = ", error=";
        String r10 = TAG;
    L81:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L83;
        Loog.INSTANCE.d(r10, "prepare SocialBase download failed, key=" + r22.g() + r9 + e);
    L83:
        a(r21, r22, x.f30696e);
        return;
    L78:
        e = e;
        r10 = TAG;
        r9 = ", error=";
        goto L81
    L28:
        if (aj.f30612a.a(r6, r23) == false) goto L56;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L100;
        Loog.INSTANCE.d(TAG, "startDownload: reuse existing zip " + r6.getAbsolutePath());     // Catch: Exception -> L85
    L100:
        d.n.a r11 = d.n.f38560a;     // Catch: Throwable -> L34
        ah.f30609a.a(r22.g());     // Catch: Throwable -> L34
        Object r12 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L34
    L36:
        Throwable r13 = d.n.c(r12);     // Catch: Exception -> L85
        if (r13 != null) goto L39;
    L41:
        c r15 = r21.g();     // Catch: Exception -> L85
        if (r15 != null) goto L45;
        return;
    L45:
        if (r15.a() == true) goto L94;
        x r16 = r15.b();     // Catch: Exception -> L85
        if (r16 != null) goto L49;
        r16 = x.f30693b;     // Catch: Exception -> L85
    L49:
        b(r21, r22, r16);     // Catch: Exception -> L85
        return;
    L94:
        a(r14, r21, r22, r6, true, r24);     // Catch: Exception -> L54
        return;
    L54:
        e = e;
        r4 = TAG;
        goto L88
    L39:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L41;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r13);     // Catch: Exception -> L85
        goto L41
    L34:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;     // Catch: Exception -> L85
        r12 = d.n.f(d.o.a(th));     // Catch: Exception -> L85
        goto L36
    L19:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L21;
        Loog.INSTANCE.d(TAG, "startDownload: validated unmetered wifi is no longer available");     // Catch: Exception -> L85
    L21:
        x r18 = r21.c(x.f30695d);     // Catch: Exception -> L85
        if (r18 == null) goto L103;
        b(r21, r22, r18);     // Catch: Exception -> L85
        return;
    L103:
        return;
    L12:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L14;
        Loog.INSTANCE.d(TAG, "startDownload: url is empty, bean=" + r23);
    L14:
        b(r21, r22, x.f30693b);
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    private final void a(a r1, o r2, x r3) {
        x r4 = r1.c(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        b(r1, r2, r4);
    }

    private final boolean b(Context r7, a r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (r8.a(r9) == false) goto L22;
        a(r10, r8, r9);
    L22:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        q r1 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r2 = d.n.f(Boolean.valueOf(com.obric.autogui.resourcemanage.g.f30624a.b(r10)));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = d.n.c(r2);
        if (r3 == null) goto L15;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L15;
        Loog.INSTANCE.d(TAG, "binary network check outcome unknown; keeping transport owner, key=" + r8.b().b() + ", id=" + r9 + ", error=" + r3);
    L15:
        if (d.n.b(r2) == false) goto L18;
        r2 = null;
    L18:
        if (d.h.b.o.a((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin"), false) == false) goto L21;
        a(r10, r8, x.f30695d);
    L21:
        return !r8.f();
    L7:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L9
    }

    private final void a(Context r17, a r18, o r19, File r20, boolean r21, boolean r22) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        x r13 = x.f;
        if (r21 == false) goto L95;
    L13:
        boolean r5 = this.f.a(r6, r19, r20, this.f30655c, this.i, this.j, r.a(r21, r22));     // Catch: Throwable -> L47 Exception -> L49
        if (r5 == false) goto L97;
        r13 = x.g;     // Catch: Throwable -> L47 Exception -> L49
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L18
        q r1 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L18
        com.obric.autogui.resourcemanage.d.f30616a.d(r19.a(), r3);     // Catch: Throwable -> L18
        com.obric.autogui.resourcemanage.d.f30616a.b(r19.a(), r3);     // Catch: Throwable -> L18
        Object r2 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L18
    L20:
        Throwable r4 = d.n.c(r2);     // Catch: Throwable -> L47 Exception -> L49
        if (r4 == null) goto L97;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L97;
        Loog.INSTANCE.d(TAG, "save install success time failed: " + r4);     // Catch: Throwable -> L47 Exception -> L49
    L18:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L47 Exception -> L49
        r2 = d.n.f(d.o.a(th));     // Catch: Throwable -> L47 Exception -> L49
    L97:
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L27
        ah.f30609a.a(r19.g(), r5);     // Catch: Throwable -> L27
        Object r9 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L27
    L29:
        Throwable r10 = d.n.c(r9);     // Catch: Throwable -> L47 Exception -> L49
        if (r10 != null) goto L32;
    L103:
        d.n.a r11 = d.n.f38560a;     // Catch: Throwable -> L36
        ah.f30609a.b(r19.g(), this.k);     // Catch: Throwable -> L36
        Object r12 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L36
    L38:
        Throwable r14 = d.n.c(r12);     // Catch: Throwable -> L44
        if (r14 != null) goto L41;
    L43:
        a(r18, r13);
        return;
    L41:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L43;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r14);     // Catch: Throwable -> L44
        goto L43
    L36:
        th = move-exception;
        d.n.a r15 = d.n.f38560a;     // Catch: Throwable -> L44
        r12 = d.n.f(d.o.a(th));     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        a(r18, r13);
        throw th;
    L32:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L103;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r10);     // Catch: Throwable -> L47 Exception -> L49
    L49:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L105;
        Loog.INSTANCE.d(TAG, "install resource failed: " + e);     // Catch: Throwable -> L47
    L105:
        d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L55
        ah.f30609a.a(r19.g(), false);     // Catch: Throwable -> L55
        Object r23 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L55
    L57:
        Throwable r24 = d.n.c(r23);     // Catch: Throwable -> L47
        if (r24 != null) goto L60;
    L90:
        d.n.a r25 = d.n.f38560a;     // Catch: Throwable -> L64
        ah.f30609a.b(r19.g(), this.k);     // Catch: Throwable -> L64
        Object r26 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L64
    L66:
        Throwable r27 = d.n.c(r26);     // Catch: Throwable -> L73
        if (r27 == null) goto L43;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L43;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r27);     // Catch: Throwable -> L73
        goto L43
    L73:
        th = move-exception;
        a(r18, r13);
        throw th;
    L64:
        th = move-exception;
        d.n.a r28 = d.n.f38560a;     // Catch: Throwable -> L73
        r26 = d.n.f(d.o.a(th));     // Catch: Throwable -> L73
        goto L66
    L60:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L90;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r24);     // Catch: Throwable -> L47
        goto L90
    L55:
        th = move-exception;
        d.n.a r29 = d.n.f38560a;     // Catch: Throwable -> L47
        r23 = d.n.f(d.o.a(th));     // Catch: Throwable -> L47
    L27:
        th = move-exception;
        d.n.a r30 = d.n.f38560a;     // Catch: Throwable -> L47 Exception -> L49
        r9 = d.n.f(d.o.a(th));     // Catch: Throwable -> L47 Exception -> L49
        goto L29
    L95:
        d.n.a r31 = d.n.f38560a;     // Catch: Throwable -> L6
        q r32 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        com.obric.autogui.resourcemanage.d.f30616a.c(r19.a(), System.currentTimeMillis());     // Catch: Throwable -> L6
        Object r33 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L6
    L8:
        Throwable r34 = d.n.c(r33);     // Catch: Throwable -> L47 Exception -> L49
        if (r34 == null) goto L13;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L13;
        Loog.INSTANCE.d(TAG, "save download success time failed: " + r34);     // Catch: Throwable -> L47 Exception -> L49
        goto L13
    L6:
        th = move-exception;
        d.n.a r35 = d.n.f38560a;     // Catch: Throwable -> L47 Exception -> L49
        r33 = d.n.f(d.o.a(th));     // Catch: Throwable -> L47 Exception -> L49
    L47:
        th = move-exception;
        d.n.a r36 = d.n.f38560a;     // Catch: Throwable -> L78
        ah.f30609a.b(r19.g(), this.k);     // Catch: Throwable -> L78
        Object r37 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L78
    L80:
        Throwable r38 = d.n.c(r37);     // Catch: Throwable -> L87
        if (r38 != null) goto L83;
    L85:
        a(r18, r13);
        throw th;
    L83:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L85;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r38);     // Catch: Throwable -> L87
        goto L85
    L78:
        th = move-exception;
        d.n.a r39 = d.n.f38560a;     // Catch: Throwable -> L87
        r37 = d.n.f(d.o.a(th));     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        a(r18, r13);
        throw th;
    }

    private final void a(final a r3, x r4) {
        if (r3.h() == true) goto L5;
        return;
    L5:
        r3.c().a(r4, new $$Lambda$q$J4DSYiQ2KjTrPL1E8SsEdhD9fY(this, r3));
    }

    private static final d.x a(q r1, a r2) {
        r1.l.compareAndSet(r2, null);
        r2.a().a(r2.b());
        return d.x.f38692a;
    }

    private final Map<String, String> a(String r3, String r4) {
        return com.obric.autogui.resourcemanage.h.f30625a.a(r3, this.f30655c, r4, this.f30657e);
    }

    private final void a(Context r6, a r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L15;
        Loog.INSTANCE.d(TAG, "request active download cancellation, id=" + r8);
    L15:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        q r5 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Downloader.getInstance(r9).cancel(r8);     // Catch: Throwable -> L7
        Object r10 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L7
    L9:
        Throwable r11 = d.n.c(r10);
        if (r11 == null) goto L17;
        r7.b(r8);
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L18;
        Loog.INSTANCE.d(TAG, "cancel active download failed, id=" + r8 + ", error=" + r11);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L9
    }

    private final void b(a r5, o r6, x r7) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        ah.f30609a.a(r6.g(), this.k);     // Catch: Throwable -> L4
        Object r8 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
    L6:
        Throwable r9 = d.n.c(r8);     // Catch: Throwable -> L13
        if (r9 != null) goto L9;
    L11:
        a(r5, r7);
        return;
    L9:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L11;
        Loog.INSTANCE.d(TAG, "resource metrics failed: " + r9);     // Catch: Throwable -> L13
        goto L11
    L4:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L13
        r8 = d.n.f(d.o.a(th));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        a(r5, r7);
        throw th;
    }

    private final void a(Context r4, o r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "handleUninstall: " + r5.d());
    L5:
        com.obric.autogui.resourcemanage.d.f30616a.b(r6, r5, this.f30655c);
        com.obric.autogui.resourcemanage.d.f30616a.a(r5);
        d.h.a.b<o, d.x> r3 = this.g;
        if (r3 == null) goto L9;
        r3.invoke(r5);
        return;
    }

    private final void b(Context r4, o r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "handleRevert: " + r5.d());
    L5:
        com.obric.autogui.resourcemanage.d.f30616a.b(r6, r5, this.f30655c);
        com.obric.autogui.resourcemanage.d.f30616a.a(r5);
        d.h.a.b<o, d.x> r3 = this.h;
        if (r3 == null) goto L9;
        r3.invoke(r5);
        return;
    }
}
