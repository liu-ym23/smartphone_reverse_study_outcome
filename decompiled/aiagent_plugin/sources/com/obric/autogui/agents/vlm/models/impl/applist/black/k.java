package com.obric.autogui.agents.vlm.models.impl.applist.black;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.h.b.z;
import d.x;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;
import kotlinx.coroutines.de;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements j {
    private static final String TAG = "WLFetcher/UserDef";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27432a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Uri f27433c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final bp f27434d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f27435b;

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ long a(a r2) {
            return r2.b();
        }

        public final Uri a() {
            return k.a();
        }

        private final long b() {
            return AutoActionConfigs.INSTANCE.getLongCfg("vlm.common.whitelist_provider_timeout_ms", TimeUnit.SECONDS.toMillis(10));
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
    @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {78}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$query$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super j.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f27439d;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.k$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
        @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {100}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$query$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super j.c>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27440a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<ContentProviderClient> f27441b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ k f27442c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f27443d;

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.k$b$1$a */
            /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
            @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$query$2$1$cursor$1")
            static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Cursor>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f27444a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ z.f<ContentProviderClient> f27445b;

                a(z.f<ContentProviderClient> r3, d.c.d<? super a> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f27445b = r3;
                    super(2, r5);
                }

                public final Object a(am r3, d.c.d<? super Cursor> r4) {
                    return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27445b, r4), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super Cursor> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    d.c.a.b.a();
                    if (this.f27444a != 0) goto L10;
                    d.o.a(r8);
                    ContentProviderClient r0 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(this.f27445b.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
                    if (r0 != null) goto L11;
                    return null;
                L11:
                    return ZeusProviderTransform.query(r0, k.f27432a.a(), null, null, null, null, "com.obric.aiagent.plugin");
                L10:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(z.f<ContentProviderClient> r3, k r4, String r5, d.c.d<? super AnonymousClass1> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27441b = r3;
                this.f27442c = r4;
                this.f27443d = r5;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super j.c> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27441b, this.f27442c, this.f27443d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super j.c> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r1v7, types: [T, android.content.ContentProviderClient] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r13) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27440a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r13);
            L15:
                Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.aiagent.plugin");
                if (r14 != null) goto L40;
                Loog.INSTANCE.e(k.TAG, "query: cursor is NULL for " + k.f27432a.a());
                return new j.c(true, k.a(this.f27442c, this.f27443d));
            L40:
                int r2 = r14.getColumnIndex("package_name");     // Catch: Throwable -> L32
                if (r2 >= 0) goto L25;
                Loog.INSTANCE.e(k.TAG, "query: missing column: package_name");     // Catch: Throwable -> L32
                j.c r3 = new j.c(true, k.a(this.f27442c, this.f27443d));     // Catch: Throwable -> L32
                r14.close();
                return r3;
            L25:
                if (r14.moveToNext() == false) goto L31;
                if (d.h.b.o.a(r14.getString(r2), this.f27443d) == false) goto L25;
                j.c r4 = new j.c(true, null);     // Catch: Throwable -> L32
                r14.close();
                return r4;
            L31:
                r14.close();
                return new j.c(true, k.a(this.f27442c, this.f27443d));
            L32:
                th = move-exception;
                Loog.INSTANCE.e(k.TAG, "query: exception while checking " + this.f27443d + "; e=" + th, th);     // Catch: Throwable -> L37
            L37:
                th = move-exception;
                r14.close();
                throw th;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r13);
                this.f27441b.f38504a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f27442c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient(k.f27432a.a());
                if (this.f27441b.f38504a != null) goto L12;
                Loog.INSTANCE.e(k.TAG, "query: provider not found: " + k.f27432a.a());
                return new j.c(true, k.a(this.f27442c, this.f27443d));
            L12:
                au r15 = kotlinx.coroutines.i.b(an.a((d.c.g) ZeusTransformUtils.preCheckCast(k.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f27441b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27440a = 1;
                r13 = r15.a(r5);
                if (r13 != r0) goto L15;
                return r0;
            }
        }

        b(String r3, k r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27438c = r3;
            this.f27439d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super j.c> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f27438c, this.f27439d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super j.c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            z.f r0 = d.c.a.b.a();
            int r1 = this.f27437b;
            if (r1 == 0) goto L18;
            if (r1 != 1) goto L17;
            z.f r2 = (z.f) ZeusTransformUtils.preCheckCast(this.f27436a, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r12);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12 de -> L14
        L23:
            j.c r13 = (j.c) ZeusTransformUtils.preCheckCast(r12, j.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12 de -> L14
            ContentProviderClient r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L26:
            r11.close();
        L47:
            return r13;
        L12:
            RemoteException e2 = e;
        L37:
            Loog.INSTANCE.e(k.TAG, "query: RemoteException for " + this.f27438c, (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r13 = new j.c(true, k.a(this.f27439d, this.f27438c));     // Catch: Throwable -> L8
            r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L14:
            de e3 = e;
        L43:
            Loog.INSTANCE.e(k.TAG, "query: timeout for " + this.f27438c, (Throwable) ZeusTransformUtils.preCheckCast(e3, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r13 = new j.c(true, k.a(this.f27439d, this.f27438c));     // Catch: Throwable -> L8
            r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L10:
            Exception e4 = e;
        L31:
            Loog.INSTANCE.e(k.TAG, "query: unexpected exception for " + this.f27438c, (Throwable) ZeusTransformUtils.preCheckCast(e4, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r13 = new j.c(true, k.a(this.f27439d, this.f27438c));     // Catch: Throwable -> L8
            r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r12);
            z.f r14 = new z.f();
            long r5 = a.a(k.f27432a);     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            d.h.a.m r3 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r14, this.f27439d, this.f27438c, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            this.f27436a = r14;     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            this.f27437b = 1;     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            Object r4 = dg.a(r5, r3, r7);     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            if (r4 != r0) goto L22;
            return r0;
        L22:
            r2 = r14;
            r12 = r4;
            goto L23
        L35:
            e = move-exception;
            r2 = r14;
            e2 = e;
        L41:
            e = move-exception;
            r2 = r14;
            e3 = e;
        L29:
            e = move-exception;
            r2 = r14;
            e4 = e;
        L27:
            th = th;
            r0 = r14;
        L48:
            ContentProviderClient r15 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r0.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L51;
            r15.close();
        L51:
            throw th;
        L8:
            th = th;
            goto L48
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
    @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {269}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$queryAllStates$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super j.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f27448c;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.k$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
        @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {291}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$queryAllStates$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super j.b>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27449a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<ContentProviderClient> f27450b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ k f27451c;

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.k$c$1$a */
            /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
            @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$queryAllStates$2$1$cursor$1")
            static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Cursor>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f27452a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ z.f<ContentProviderClient> f27453b;

                a(z.f<ContentProviderClient> r3, d.c.d<? super a> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f27453b = r3;
                    super(2, r5);
                }

                public final Object a(am r3, d.c.d<? super Cursor> r4) {
                    return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27453b, r4), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super Cursor> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    d.c.a.b.a();
                    if (this.f27452a != 0) goto L10;
                    d.o.a(r8);
                    ContentProviderClient r0 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(this.f27453b.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
                    if (r0 != null) goto L11;
                    return null;
                L11:
                    return ZeusProviderTransform.query(r0, k.f27432a.a(), null, null, null, null, "com.obric.aiagent.plugin");
                L10:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(z.f<ContentProviderClient> r3, k r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27450b = r3;
                this.f27451c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super j.b> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27450b, this.f27451c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super j.b> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r1v7, types: [T, android.content.ContentProviderClient] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27449a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r12);
            L15:
                Cursor r11 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.aiagent.plugin");
                if (r11 != null) goto L19;
                Loog.INSTANCE.e(k.TAG, "queryAllStates: cursor is NULL for " + k.f27432a.a());
                return new j.b(true, ao.b());
            L19:
                Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
                int r2 = r11.getColumnIndex("package_name");     // Catch: Throwable -> L39
                if (r2 >= 0) goto L26;
                Loog.INSTANCE.e(k.TAG, "queryAllStates: missing column: package_name");     // Catch: Throwable -> L39
                j.b r14 = new j.b(true, ao.b());     // Catch: Throwable -> L39
                r11.close();
                return r14;
            L26:
                if (r11.moveToNext() == false) goto L37;
                String r3 = r11.getString(r2);     // Catch: Throwable -> L39
                CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
                if (r5 != null) goto L30;
            L33:
                boolean r6 = true;
            L34:
                if (r6 == true) goto L26;
                r13.put(r3, j.e.f27428a);     // Catch: Throwable -> L39
                goto L26
            L30:
                if (d.o.o.d(r5) == true) goto L33;
                r6 = false;
                goto L34
            L37:
                r11.close();
                return new j.b(true, r13);
            L39:
                th = move-exception;
                Loog.INSTANCE.e(k.TAG, "queryAllStates: exception while reading whitelist; e=" + th, th);     // Catch: Throwable -> L43
                j.b r15 = new j.b(true, ao.b());     // Catch: Throwable -> L43
                r11.close();
                return r15;
            L43:
                th = move-exception;
                r11.close();
                throw th;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r12);
                this.f27450b.f38504a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f27451c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient(k.f27432a.a());
                if (this.f27450b.f38504a != null) goto L12;
                Loog.INSTANCE.e(k.TAG, "queryAllStates: provider not found: " + k.f27432a.a());
                return new j.b(true, ao.b());
            L12:
                au r16 = kotlinx.coroutines.i.b(an.a((d.c.g) ZeusTransformUtils.preCheckCast(k.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f27450b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
                d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27449a = 1;
                r12 = r16.a(r4);
                if (r12 != r0) goto L15;
                return r0;
            }
        }

        c(k r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27448c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super j.b> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f27448c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super j.b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v6 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27447b;
            if (r1 == 0) goto L18;
            if (r1 != 1) goto L17;
            z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(this.f27446a, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r11);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12 de -> L14
        L23:
            j.b r12 = (j.b) ZeusTransformUtils.preCheckCast(r11, j.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12 de -> L14
            ContentProviderClient r13 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r10.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L47;
        L26:
            r13.close();
        L47:
            return r12;
        L12:
            RemoteException e2 = e;
        L37:
            Loog.INSTANCE.e(k.TAG, "queryAllStates: RemoteException", (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r12 = new j.b(true, ao.b());     // Catch: Throwable -> L8
            r13 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r10.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L47;
        L14:
            de e3 = e;
        L43:
            Loog.INSTANCE.e(k.TAG, "queryAllStates: timeout", (Throwable) ZeusTransformUtils.preCheckCast(e3, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r12 = new j.b(true, ao.b());     // Catch: Throwable -> L8
            r13 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r10.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L47;
        L10:
            Exception e4 = e;
        L31:
            Loog.INSTANCE.e(k.TAG, "queryAllStates: unexpected exception", (Throwable) ZeusTransformUtils.preCheckCast(e4, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r12 = new j.b(true, ao.b());     // Catch: Throwable -> L8
            r13 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r10.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L47;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r11);
            z.f r14 = new z.f();
            long r5 = a.a(k.f27432a);     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r14, this.f27448c, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            this.f27446a = r14;     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            this.f27447b = 1;     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            Object r15 = dg.a(r5, r2, r7);     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            if (r15 != r0) goto L22;
            return r0;
        L22:
            r11 = r15;
            r10 = r14;
            goto L23
        L35:
            e = move-exception;
            e2 = e;
            r10 = r14;
        L41:
            e = move-exception;
            e3 = e;
            r10 = r14;
        L29:
            e = move-exception;
            e4 = e;
            r10 = r14;
        L27:
            th = move-exception;
            th = th;
            z.f this = r14;
        L48:
            ContentProviderClient r16 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(this.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L51;
            r16.close();
        L51:
            throw th;
        L8:
            th = th;
            goto L48
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
    @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {179}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$queryState$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super j.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f27457d;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.k$d$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
        @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {200}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$queryState$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super j.d>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27458a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<ContentProviderClient> f27459b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ k f27460c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f27461d;

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.k$d$1$a */
            /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
            @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$queryState$2$1$cursor$1")
            static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Cursor>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f27462a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ z.f<ContentProviderClient> f27463b;

                a(z.f<ContentProviderClient> r3, d.c.d<? super a> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f27463b = r3;
                    super(2, r5);
                }

                public final Object a(am r3, d.c.d<? super Cursor> r4) {
                    return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27463b, r4), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super Cursor> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    d.c.a.b.a();
                    if (this.f27462a != 0) goto L10;
                    d.o.a(r8);
                    ContentProviderClient r0 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(this.f27463b.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
                    if (r0 != null) goto L11;
                    return null;
                L11:
                    return ZeusProviderTransform.query(r0, k.f27432a.a(), null, null, null, null, "com.obric.aiagent.plugin");
                L10:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(z.f<ContentProviderClient> r3, k r4, String r5, d.c.d<? super AnonymousClass1> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27459b = r3;
                this.f27460c = r4;
                this.f27461d = r5;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super j.d> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27459b, this.f27460c, this.f27461d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super j.d> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r1v7, types: [T, android.content.ContentProviderClient] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r13) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27458a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r13);
            L15:
                Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.aiagent.plugin");
                if (r14 != null) goto L42;
                Loog.INSTANCE.e(k.TAG, "queryState: cursor is NULL for " + k.f27432a.a());
                return new j.d(true, null);
            L42:
                int r2 = r14.getColumnIndex("package_name");     // Catch: Throwable -> L32
                if (r2 >= 0) goto L25;
                Loog.INSTANCE.e(k.TAG, "queryState: missing column: package_name");     // Catch: Throwable -> L32
                j.d r3 = new j.d(true, null);     // Catch: Throwable -> L32
                r14.close();
                return r3;
            L25:
                if (r14.moveToNext() == false) goto L31;
                if (d.h.b.o.a(r14.getString(r2), this.f27461d) == false) goto L25;
                j.d r4 = new j.d(true, j.e.f27428a);     // Catch: Throwable -> L32
                r14.close();
                return r4;
            L31:
                r14.close();
                return new j.d(true, null);
            L32:
                th = move-exception;
                Loog.INSTANCE.e(k.TAG, "queryState: exception while checking " + this.f27461d + "; e=" + th, th);     // Catch: Throwable -> L37
            L37:
                th = move-exception;
                r14.close();
                throw th;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r13);
                this.f27459b.f38504a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f27460c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient(k.f27432a.a());
                if (this.f27459b.f38504a != null) goto L12;
                Loog.INSTANCE.e(k.TAG, "queryState: provider not found: " + k.f27432a.a());
                return new j.d(true, null);
            L12:
                au r15 = kotlinx.coroutines.i.b(an.a((d.c.g) ZeusTransformUtils.preCheckCast(k.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f27459b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27458a = 1;
                r13 = r15.a(r5);
                if (r13 != r0) goto L15;
                return r0;
            }
        }

        d(String r3, k r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27456c = r3;
            this.f27457d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super j.d> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f27456c, this.f27457d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super j.d> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            z.f r0 = d.c.a.b.a();
            int r1 = this.f27455b;
            if (r1 == 0) goto L18;
            if (r1 != 1) goto L17;
            z.f r2 = (z.f) ZeusTransformUtils.preCheckCast(this.f27454a, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r12);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12 de -> L14
        L23:
            j.d r13 = (j.d) ZeusTransformUtils.preCheckCast(r12, j.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12 de -> L14
            ContentProviderClient r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L26:
            r11.close();
        L47:
            return r13;
        L12:
            RemoteException e2 = e;
        L37:
            Loog.INSTANCE.e(k.TAG, "queryState: RemoteException for " + this.f27456c, (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r13 = new j.d(true, null);     // Catch: Throwable -> L8
            r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L14:
            de e3 = e;
        L43:
            Loog.INSTANCE.e(k.TAG, "queryState: timeout for " + this.f27456c, (Throwable) ZeusTransformUtils.preCheckCast(e3, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r13 = new j.d(true, null);     // Catch: Throwable -> L8
            r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L10:
            Exception e4 = e;
        L31:
            Loog.INSTANCE.e(k.TAG, "queryState: unexpected exception for " + this.f27456c, (Throwable) ZeusTransformUtils.preCheckCast(e4, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
            r13 = new j.d(true, null);     // Catch: Throwable -> L8
            r11 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L47;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r12);
            z.f r14 = new z.f();
            long r6 = a.a(k.f27432a);     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            d.h.a.m r3 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r14, this.f27457d, this.f27456c, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            this.f27454a = r14;     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            this.f27455b = 1;     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            Object r4 = dg.a(r6, r3, r8);     // Catch: Throwable -> L27 Exception -> L29 RemoteException -> L35 de -> L41
            if (r4 != r0) goto L22;
            return r0;
        L22:
            r2 = r14;
            r12 = r4;
            goto L23
        L35:
            e = move-exception;
            r2 = r14;
            e2 = e;
        L41:
            e = move-exception;
            r2 = r14;
            e3 = e;
        L29:
            e = move-exception;
            r2 = r14;
            e4 = e;
        L27:
            th = th;
            r0 = r14;
        L48:
            ContentProviderClient r15 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r0.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L51;
            r15.close();
        L51:
            throw th;
        L8:
            th = th;
            goto L48
        }
    }

    /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
    @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {364}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$update$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f27467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ j.e f27468e;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.k$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDefinedWhiteListFetcherImpl.kt */
        @d.c.b.a.f(b = "UserDefinedWhiteListFetcherImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.UserDefinedWhiteListFetcherImpl$update$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27469a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<ContentProviderClient> f27470b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ k f27471c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f27472d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ j.e f27473e;

            AnonymousClass1(z.f<ContentProviderClient> r3, k r4, String r5, j.e r6, d.c.d<? super AnonymousClass1> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27470b = r3;
                this.f27471c = r4;
                this.f27472d = r5;
                this.f27473e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super Boolean> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27470b, this.f27471c, this.f27472d, this.f27473e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r0v7, types: [T, android.content.ContentProviderClient] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                d.c.a.b.a();
                if (this.f27469a != 0) goto L17;
                d.o.a(r7);
                this.f27470b.f38504a = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f27471c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient(k.f27432a.a());
                int r0 = 0;
                if (this.f27470b.f38504a != null) goto L8;
                Loog.INSTANCE.e(k.TAG, "update: provider not found: " + k.f27432a.a());
                return d.c.b.a.b.a(false);
            L8:
                Bundle r8 = new Bundle();
                String r3 = this.f27472d;
                j.e r4 = this.f27473e;
                r8.putString("package_name", r3);
                if (r4 != j.e.f27428a) goto L11;
                r0 = 1;
            L11:
                r8.putInt("app_permission_status", r0);
                ContentProviderClient r1 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(this.f27470b.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
                if (r1 == null) goto L14;
                r1.call("update_app_permission_on_auto_action", null, r8);
            L14:
                Loog.INSTANCE.d(k.TAG, "update: pkg=" + this.f27472d + ", state=" + this.f27473e);
                return d.c.b.a.b.a(true);
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        e(String r3, k r4, j.e r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27466c = r3;
            this.f27467d = r4;
            this.f27468e = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f27466c, this.f27467d, this.f27468e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v7, types: [d.h.b.z$f] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r0 = d.c.a.b.a();
            z.f r2 = this.f27465b;
            boolean r4 = false;
            if (r2 == 0) goto L10;
            if (r2 != 1) goto L9;
            z.f r3 = (z.f) ZeusTransformUtils.preCheckCast(this.f27464a, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r17);     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            Object r5 = r17;
            r2 = r3;
        L14:
            r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            ContentProviderClient r1 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L36;
        L17:
            r1.close();
        L36:
            return d.c.b.a.b.a(r4);
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r17);
            z.f r6 = new z.f();
            long r13 = a.a(k.f27432a);     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f27467d, this.f27466c, this.f27468e, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            this.f27464a = r6;     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            this.f27465b = 1;     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            r5 = dg.a(r13, r7, r8);     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L25 de -> L30
            r2 = r6;
            if (r5 != r0) goto L14;
            return r0;
        L18:
            th = move-exception;
            ContentProviderClient r9 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L40;
            r9.close();
        L40:
            throw th;
        L25:
            e = move-exception;
            Loog.INSTANCE.e(k.TAG, "update: RemoteException for " + this.f27466c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
            r1 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L36;
        L30:
            e = move-exception;
            Loog.INSTANCE.e(k.TAG, "update: timeout for " + this.f27466c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
            r1 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L36;
        L20:
            e = move-exception;
            Loog.INSTANCE.e(k.TAG, "update: unexpected exception for " + this.f27466c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
            r1 = (ContentProviderClient) ZeusTransformUtils.preCheckCast(r2.f38504a, ContentProviderClient.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L36;
            goto L17
        }
    }

    public k(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        this.f27435b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Uri a() {
        return f27433c;
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.impl.applist.black.e a(k r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ bp b() {
        return f27434d;
    }

    public final Context getContext() {
        return this.f27435b;
    }

    static {
        f27432a = new a(null);
        f27433c = Uri.parse("content://com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider/settings/user_whitelist_only_client");
        ExecutorService r0 = Executors.newFixedThreadPool(3);
        d.h.b.o.c(r0, "newFixedThreadPool(...)");
        f27434d = br.a(r0);
    }

    private final com.obric.autogui.agents.vlm.models.impl.applist.black.e a(String r7) {
        return (com.obric.autogui.agents.vlm.models.impl.applist.black.e) ZeusTransformUtils.preCheckCast(new f(com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27355c, r7, null, 4, null), com.obric.autogui.agents.vlm.models.impl.applist.black.e.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object query(String r5, d.c.d<? super j.c> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r5, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object a(d.c.d<? super j.a> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return new j.a(true, ax.b());
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object a(String r5, d.c.d<? super j.d> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r5, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object b(d.c.d<? super j.b> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.j
    public Object update(String r5, j.e r6, d.c.d<? super Boolean> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r5, this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
    }
}
