package com.obric.autogui.agents.vlm.models.impl.applist.black;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: UserDefinedWhiteListFetcherWithCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements j {
    private static final String TAG = "WLFetcher/Cache";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27474a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final j.e f27475d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f27476e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f27477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.d.e<j.b> f27478c;

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherWithCache.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherWithCache.kt */
    public static final class b extends com.obric.autogui.session.d.a<j.b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.session.d.c<j.b> f27479b;

        /* JADX INFO: compiled from: UserDefinedWhiteListFetcherWithCache.kt */
        @d.c.b.a.f(b = "UserDefinedWhiteListFetcherWithCache.kt", c = {43}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherWithCache$cachedFullStateResult$1$spec$1")
        static final class a extends d.c.b.a.l implements d.h.a.b<d.c.d<? super j.b>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27480a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l f27481b;

            a(l r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27481b = r3;
                super(1, r5);
            }

            public final Object a(d.c.d<? super j.b> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27481b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super j.b> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27480a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L11:
                j.b r4 = (j.b) ZeusTransformUtils.preCheckCast(r5, j.b.class, "com.obric.aiagent.plugin");
                if (r4.a() == true) goto L14;
                Loog.INSTANCE.w(l.TAG, "load full state failed, keep full result in cache");
            L14:
                Map<String, j.e> r2 = r4.b();
                if (r2 == null) goto L17;
                Map r3 = ao.d(r2);
            L19:
                return j.b.a(r4, false, r3, 1, null);
            L17:
                r3 = null;
                goto L19
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                j r6 = l.b(this.f27481b);
                d.c.d<? super j.b> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27480a = 1;
                r5 = r6.b(r7);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        public static /* synthetic */ j.b lambda$cyu1TfvUng4pD724UGXxF7E5Bt0() {
            return f();
        }

        b(l r11) {
            super(null, 1, null);
            this.f27479b = new com.obric.autogui.session.d.c("UserDefinedWhiteListStateCache", (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r11, null), d.h.a.b.class, "com.obric.aiagent.plugin"), $$Lambda$l$b$cyu1TfvUng4pD724UGXxF7E5Bt0.INSTANCE, null, null, 24, null);
        }

        @Override // com.obric.autogui.session.d.a
        public com.obric.autogui.session.d.c<j.b> a() {
            return this.f27479b;
        }

        private static final j.b f() {
            return new j.b(false, null);
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherWithCache.kt */
    @d.c.b.a.f(b = "UserDefinedWhiteListFetcherWithCache.kt", c = {62}, d = DownloadConstants.QUERY_KEY, e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherWithCache")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f27484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27485d;

        c(l r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27484c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27483b = r3;
            this.f27485d |= Integer.MIN_VALUE;
            return this.f27484c.query(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherWithCache.kt */
    @d.c.b.a.f(b = "UserDefinedWhiteListFetcherWithCache.kt", c = {83}, d = "queryState", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherWithCache")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f27488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27489d;

        d(l r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27488c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27487b = r3;
            this.f27489d |= Integer.MIN_VALUE;
            return this.f27488c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherWithCache.kt */
    @d.c.b.a.f(b = "UserDefinedWhiteListFetcherWithCache.kt", c = {97}, d = "update", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherWithCache")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f27492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27493d;

        e(l r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27492c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27491b = r3;
            this.f27493d |= Integer.MIN_VALUE;
            return this.f27492c.update(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public l(j r5, long r6) {
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "delegate");
        this.f27477b = r7;
        ContentResolver r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver();
        Uri r0 = k.f27432a.a();
        final Handler r2 = new Handler(Looper.getMainLooper());
        ZeusProviderTransform.registerContentObserver(r8, r0, false, (ContentObserver) ZeusTransformUtils.preCheckCast(new UserDefinedWhiteListFetcherWithCache$1(this, r2), ContentObserver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f27478c = com.obric.autogui.session.d.b.a((com.obric.autogui.session.d.a) ZeusTransformUtils.preCheckCast(new b(this), com.obric.autogui.session.d.a.class, "com.obric.aiagent.plugin"), r6);
    }

    public static final /* synthetic */ com.obric.autogui.session.d.e a(l r0) {
        return r0.f27478c;
    }

    public static final /* synthetic */ j b(l r0) {
        return r0.f27477b;
    }

    public /* synthetic */ l(j r2, long r3, int r5, d.h.b.h r6) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = f27476e;
    L5:
        this(r4, r3);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object query(String r10, d.c.d<? super j.c> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
        if ((r0.f27485d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27485d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f27483b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27485d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.f27482a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L17:
        String r5 = r10;
        j.b r9 = (j.b) ZeusTransformUtils.preCheckCast(r13, j.b.class, "com.obric.aiagent.plugin");
        Map<String, j.e> r14 = r9.b();
        f r15 = null;
        if (r14 == null) goto L20;
        j.e r16 = (j.e) ZeusTransformUtils.preCheckCast(r14.get(r5), j.e.class, "com.obric.aiagent.plugin");
    L21:
        boolean r17 = r9.a();
        if (r16 == f27475d) goto L26;
        r15 = new f(com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27355c, r5, null, 4, null);
    L26:
        return new j.c(r17, (com.obric.autogui.agents.vlm.models.impl.applist.black.e) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.agents.vlm.models.impl.applist.black.e.class, "com.obric.aiagent.plugin"));
    L20:
        r16 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        com.obric.autogui.session.d.e<j.b> r18 = this.f27478c;
        r0.f27482a = r10;
        r0.f27485d = 1;
        r13 = r18.a(r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new c(this, r12);
        goto L8
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object a(d.c.d<? super j.a> r3) {
        d.c.d<? super j.a> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f27477b.a(r4);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object a(String r6, d.c.d<? super j.d> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
        if ((r0.f27489d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27489d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f27487b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27489d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.f27486a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L17:
        j.b r5 = (j.b) ZeusTransformUtils.preCheckCast(r9, j.b.class, "com.obric.aiagent.plugin");
        boolean r1 = r5.a();
        Map<String, j.e> r10 = r5.b();
        if (r10 == null) goto L20;
        j.e r11 = (j.e) ZeusTransformUtils.preCheckCast(r10.get(r6), j.e.class, "com.obric.aiagent.plugin");
    L22:
        return new j.d(r1, r11);
    L20:
        r11 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        com.obric.autogui.session.d.e<j.b> r12 = this.f27478c;
        r0.f27486a = r6;
        r0.f27489d = 1;
        r9 = r12.a(r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new d(this, r8);
        goto L8
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object b(d.c.d<? super j.b> r3) {
        d.c.d<? super j.b> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f27478c.a(r4);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object update(String r6, j.e r7, d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r0.f27493d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27493d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f27491b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27493d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        l this = (l) ZeusTransformUtils.preCheckCast(r0.f27490a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
    L17:
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r11 == false) goto L21;
        com.obric.autogui.session.d.a.a((com.obric.autogui.session.d.a) ZeusTransformUtils.preCheckCast(this.f27478c, com.obric.autogui.session.d.a.class, "com.obric.aiagent.plugin"), null, 1, null);
    L21:
        return d.c.b.a.b.a(r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        j r12 = this.f27477b;
        r0.f27490a = this;
        r0.f27493d = 1;
        r10 = r12.update(r6, r7, r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new e(this, r9);
        goto L8
    }

    public final void a() {
        this.f27478c.f();
    }

    static {
        f27474a = new a(null);
        f27475d = j.e.f27428a;
        f27476e = TimeUnit.MINUTES.toMillis(10);
    }
}
