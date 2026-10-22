package com.obric.autogui.agents.vlm.models.omni.c;

import android.content.Context;
import android.os.SystemClock;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.z;

/* JADX INFO: compiled from: AppPrewarmSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f28268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.omni.r f28269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<k, h> f28270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z f28271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final am f28272e;
    private final Object f;
    private boolean g;
    private h h;
    private volatile k i;

    /* JADX INFO: compiled from: AppPrewarmSession.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AppPrewarmSession.kt */
    @d.c.b.a.f(b = "AppPrewarmSession.kt", c = {105}, d = "predict", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.AppPrewarmSession")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f28273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f28274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f28275c;

        b(j r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28274b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28273a = r3;
            this.f28275c |= Integer.MIN_VALUE;
            return j.a(this.f28274b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppPrewarmSession.kt */
    @d.c.b.a.f(b = "AppPrewarmSession.kt", c = {106, 108}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.AppPrewarmSession$predict$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f28277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f28279d;

        c(Context r3, String r4, String r5, d.c.d<? super c> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28277b = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f28278c = r4;
            this.f28279d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super f> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f28277b, this.f28278c, this.f28279d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super f> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28276a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L20:
            return (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            com.obric.autogui.agents.vlm.models.omni.c.c r9 = (com.obric.autogui.agents.vlm.models.omni.c.c) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.agents.vlm.models.omni.c.c.class, "com.obric.aiagent.plugin");
            if (r9.b().isEmpty() == true) goto L21;
            com.obric.autogui.agents.vlm.models.omni.c.d r2 = new com.obric.autogui.agents.vlm.models.omni.c.d(this.f28279d);
            d.c.d<? super f> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28276a = 2;
            r8 = r2.a(r9, 10000, r3);
            if (r8 != r0) goto L20;
            return r0;
        L21:
            return (f) ZeusTransformUtils.preCheckCast(new f.a("app_list_empty"), f.class, "com.obric.aiagent.plugin");
        L10:
            d.o.a(r8);
            Context r10 = this.f28277b;
            String r4 = this.f28278c;
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28276a = 1;
            r8 = e.a(r10, r4, r5);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppPrewarmSession.kt */
    @d.c.b.a.f(b = "AppPrewarmSession.kt", c = {44, 48, 51, 54, 60, 64}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.AppPrewarmSession$start$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f28280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f28281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f28282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f28283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f28284e;
        final /* synthetic */ k f;

        d(j r3, Context r4, String r5, k r6, d.c.d<? super d> r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28282c = r3;
            this.f28283d = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.f28284e = r5;
            this.f = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f28282c, this.f28283d, this.f28284e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            switch(this.f28281b) {
                case 0: goto L19;
                case 1: goto L16;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            d.o.a(r8);
        L63:
            return x.f38692a;
        L7:
            d.o.a(r8);     // Catch: Exception -> L12 CancellationException -> L14
            goto L63
        L8:
            d.o.a(r8);     // Catch: Exception -> L12 CancellationException -> L14
        L43:
            return x.f38692a;
        L9:
            d.o.a(r8);     // Catch: Exception -> L12 CancellationException -> L14
        L36:
            return x.f38692a;
        L10:
            d.o.a(r8);     // Catch: Exception -> L12 CancellationException -> L14
        L29:
            return x.f38692a;
        L16:
            long r1 = this.f28280a;
            d.o.a(r8);     // Catch: Exception -> L12 CancellationException -> L14
        L23:
            f r9 = (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            ce.b(getContext());     // Catch: Exception -> L12 CancellationException -> L14
            this.f.a(r9, SystemClock.elapsedRealtime() - r1);     // Catch: Exception -> L12 CancellationException -> L14
            if (ZeusTransformUtils.instanceOf(r9, f.a.class) == false) goto L30;
            k r2 = this.f;     // Catch: Exception -> L12 CancellationException -> L14
            String r10 = ((f.a) ZeusTransformUtils.preCheckCast(r9, f.a.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L12 CancellationException -> L14
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            this.f28281b = 2;     // Catch: Exception -> L12 CancellationException -> L14
            if (r2.a(r10, r3) != r0) goto L29;
            return r0;
        L30:
            d.h.b.o.a(r9, "null cannot be cast to non-null type com.obric.autogui.agents.vlm.models.omni.prewarm.AppPredictionResult.Success");     // Catch: Exception -> L12 CancellationException -> L14
            List<com.obric.autogui.agents.vlm.models.omni.c.b> r11 = ((f.b) ZeusTransformUtils.preCheckCast(r9, f.b.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L12 CancellationException -> L14
            if (r11.isEmpty() == false) goto L37;
            k r12 = this.f;     // Catch: Exception -> L12 CancellationException -> L14
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            this.f28281b = 3;     // Catch: Exception -> L12 CancellationException -> L14
            if (r12.a("model_chose_skip", r4) != r0) goto L36;
            return r0;
        L37:
            h r5 = (h) ZeusTransformUtils.preCheckCast(j.a(this.f28282c).invoke(this.f), h.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            if (r5 != null) goto L44;
            k r13 = this.f;     // Catch: Exception -> L12 CancellationException -> L14
            d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            this.f28281b = 4;     // Catch: Exception -> L12 CancellationException -> L14
            if (r13.a("consumer_not_ready", r6) != r0) goto L43;
            return r0;
        L44:
            Object r7 = j.b(this.f28282c);     // Catch: Exception -> L12 CancellationException -> L14
            j r14 = this.f28282c;     // Catch: Exception -> L12 CancellationException -> L14
            monitor-enter(r7);     // Catch: Exception -> L12 CancellationException -> L14
        L56:
            th = move-exception;
            throw th;     // Catch: Exception -> L12 CancellationException -> L14
        L47:
            if (j.c(r14) == false) goto L51;
            x r15 = x.f38692a;     // Catch: Throwable -> L56
            monitor-exit(r7);     // Catch: Exception -> L12 CancellationException -> L14
            return r15;
        L51:
            j.a(r14, r5);     // Catch: Throwable -> L56
            x r16 = x.f38692a;     // Catch: Throwable -> L56
            monitor-exit(r7);     // Catch: Exception -> L12 CancellationException -> L14
            ce.b(getContext());     // Catch: Exception -> L12 CancellationException -> L14
            d.c.d<? super x> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            this.f28281b = 5;     // Catch: Exception -> L12 CancellationException -> L14
            if (r5.a(r11, r17) != r0) goto L63;
            return r0;
        L19:
            d.o.a(r8);
            r1 = SystemClock.elapsedRealtime();     // Catch: Exception -> L12 CancellationException -> L14
            j r18 = this.f28282c;     // Catch: Exception -> L12 CancellationException -> L14
            Context r19 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f28283d.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            d.h.b.o.c(r19, "getApplicationContext(...)");     // Catch: Exception -> L12 CancellationException -> L14
            String r20 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.f28284e, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Exception -> L12 CancellationException -> L14
            d.c.d r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12 CancellationException -> L14
            this.f28280a = r1;     // Catch: Exception -> L12 CancellationException -> L14
            this.f28281b = 1;     // Catch: Exception -> L12 CancellationException -> L14
            r8 = j.a(r18, r19, r20, r21);     // Catch: Exception -> L12 CancellationException -> L14
            if (r8 != r0) goto L23;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            e = move-exception;
            throw e;
        L12:
            e = move-exception;
            k r22 = this.f;
            String r23 = "prewarm_exception:" + e.getClass().getSimpleName();
            d.c.d<? super x> r24 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28281b = 6;
            if (r22.a(r23, r24) != r0) goto L63;
            return r0;
        }
    }

    static {
        f28268a = new a(null);
    }

    public j(com.obric.autogui.agents.vlm.models.omni.r r3, d.h.a.b<? super k, ? extends h> r4) {
        d.h.a.b<k, h> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "owner");
        d.h.b.o.e(r5, "createConsumer");
        this.f28269b = r3;
        this.f28270c = r5;
        z r6 = cx.a((ca) ZeusTransformUtils.preCheckCast(r3.c().getCoroutineScope().a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin"));
        this.f28271d = r6;
        this.f28272e = an.a(r6.plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.f = new Object();
    }

    public static final /* synthetic */ d.h.a.b a(j r0) {
        return r0.f28270c;
    }

    public static final /* synthetic */ Object a(j r2, Context r3, String r4, d.c.d r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(j r2, h r3) {
        r2.h = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Object b(j r0) {
        return r0.f;
    }

    public static final /* synthetic */ boolean c(j r0) {
        return r0.g;
    }

    public final k a() {
        return this.i;
    }

    public final void a(Context r12, String r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        d.h.b.o.e(r13, DownloadConstants.QUERY_KEY);
        if (this.f28269b.h() == false) goto L5;
        return;
    L5:
        if (g.f28262a.a() == true) goto L7;
        return;
    L7:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L29;
        k r4 = new k(this.f28269b.a(), this.f28269b.b());
        Object r14 = this.f;
        monitor-enter(r14);
    L22:
        th = move-exception;
        throw th;
    L12:
        if (this.g == false) goto L14;
    L20:
        monitor-exit(r14);
        return;
    L14:
        if (this.i != null) goto L20;
        this.i = r4;     // Catch: Throwable -> L22
        x r0 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(r14);
        kotlinx.coroutines.i.a(this.f28272e, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r2, r13, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.intent.g r8) {
        d.h.b.o.e(r8, Ext.KEY_REQUEST);
        long r0 = SystemClock.elapsedRealtime();
        Object r2 = this.f;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L7;
        k r3 = null;
    L8:
        monitor-exit(r2);
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(this.f28271d, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
        if (r3 == null) goto L18;
        r3.a(r8, r0);
        return;
    L18:
        return;
    L7:
        this.g = true;     // Catch: Throwable -> L13
        r3 = this.i;     // Catch: Throwable -> L13
        goto L8
    }

    public final Object a(d.c.d<? super x> r3) {
        d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r0 = this.f;
        monitor-enter(r0);
        h r2 = this.h;     // Catch: Throwable -> L14
        monitor-exit(r0);
        if (r2 == null) goto L13;
        Object r5 = r2.a(r4);
        if (r5 != d.c.a.b.a()) goto L11;
        return r5;
    L11:
        return x.f38692a;
    L13:
        return x.f38692a;
    L14:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r0 = this.f;
        monitor-enter(r0);
        this.g = true;     // Catch: Throwable -> L11
        k r2 = this.i;     // Catch: Throwable -> L11
        monitor-exit(r0);
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(this.f28271d, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
        if (r2 == null) goto L16;
        k.a(r2, "session_closed", null, 2, null);
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final Object a(Context r8, String r9, d.c.d<? super f> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin");
        if ((r0.f28275c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28275c -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f28273a;
        Object r13 = d.c.a.b.a();
        int r2 = r0.f28275c;
        if (r2 == 0) goto L19;
        if (r2 != 1) goto L18;
        d.o.a(r7);     // Catch: Exception -> L13 CancellationException -> L15
    L26:
        f r14 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13 CancellationException -> L15
        if (r14 == null) goto L36;
        return r14;
    L36:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("model_timeout"), f.class, "com.obric.aiagent.plugin");
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        d.o.a(r7);
        String r15 = g.f28262a.b();     // Catch: Exception -> L13 CancellationException -> L15
        if (r15 == null) goto L34;
        d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r11, r9, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13 CancellationException -> L15
        r0.f28275c = 1;     // Catch: Exception -> L13 CancellationException -> L15
        r7 = dg.b(10000, r16, r0);     // Catch: Exception -> L13 CancellationException -> L15
        if (r7 != r13) goto L26;
        return r13;
    L34:
        return (f) ZeusTransformUtils.preCheckCast(new f.a("prediction_prompt_missing"), f.class, "com.obric.aiagent.plugin");
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        return (f) ZeusTransformUtils.preCheckCast(new f.a("prediction_exception:" + e.getClass().getSimpleName()), f.class, "com.obric.aiagent.plugin");
    L7:
        r0 = new b(this, r12);
        goto L8
    }
}
