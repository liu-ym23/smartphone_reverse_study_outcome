package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.GlobalSearchSession;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchResults;
import android.app.appsearch.SearchSpec;
import android.os.Build;
import android.util.EventsUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r {
    private static final String TAG = "AppFuncEnumerator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f18273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f18274b = null;

    /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
    @d.c.b.a.f(b = "AppFunctionMetadataEnumerator.kt", c = {194, 210}, d = "collectComponents", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionMetadataEnumerator")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f18278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ r f18279e;
        int f;

        a(r r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18279e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18278d = r3;
            this.f |= Integer.MIN_VALUE;
            return r.a(this.f18279e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
    @d.c.b.a.f(b = "AppFunctionMetadataEnumerator.kt", c = {134, ApWakeEvent.OTHER_END, 145}, d = "collectEntries", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionMetadataEnumerator")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18284e;
        final /* synthetic */ r f;
        int g;

        b(r r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18284e = r3;
            this.g |= Integer.MIN_VALUE;
            return r.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
    @d.c.b.a.f(b = "AppFunctionMetadataEnumerator.kt", c = {85, 86, EventsUtils.FEAT_TYPE_PROC_FREQUENT_RESTART}, d = "enumerate", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionMetadataEnumerator")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f18288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18289e;

        c(r r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18288d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18287c = r3;
            this.f18289e |= Integer.MIN_VALUE;
            return this.f18288d.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
    @d.c.b.a.f(b = "AppFunctionMetadataEnumerator.kt", c = {101}, d = "filterEnabled", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionMetadataEnumerator")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ r f18292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18293d;

        d(r r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18292c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18291b = r3;
            this.f18293d |= Integer.MIN_VALUE;
            return r.a(this.f18292c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
    @d.c.b.a.f(b = "AppFunctionMetadataEnumerator.kt", c = {104}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionMetadataEnumerator$filterEnabled$enabledFlags$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends Boolean>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<m> f18295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f18296c;

        /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
        @d.c.b.a.f(b = "AppFunctionMetadataEnumerator.kt", c = {103}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.AppFunctionMetadataEnumerator$filterEnabled$enabledFlags$1$1$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f18297a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ m f18298b;

            a(m r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f18298b = r3;
                super(2, r5);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f18298b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f18297a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r7);
            L11:
                return r7;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r7);
                l r8 = l.f18264a;
                String r2 = this.f18298b.c();
                String r3 = this.f18298b.d();
                d.c.d<? super Boolean> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f18297a = 1;
                r7 = r8.a(r2, r3, r4);
                if (r7 != r0) goto L11;
                return r0;
            }
        }

        e(List<m> r3, d.c.d<? super e> r4) {
            List<m> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18295b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<Boolean>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f18295b, r5);
            r0.f18296c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends Boolean>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18294a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L15:
            return r12;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            kotlinx.coroutines.am r13 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f18296c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f18295b, Iterable.class, "com.obric.aiagent.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            r10.add(kotlinx.coroutines.i.b(r13, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a((m) ZeusTransformUtils.preCheckCast(r3.next(), m.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null));
            goto L10
        L12:
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18294a = 1;
            r12 = kotlinx.coroutines.f.a(r14, r4);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
    static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n<List<? extends GenericDocument>> f18299a;

        f(kotlinx.coroutines.n<? super List<? extends GenericDocument>> r3) {
            this.f18299a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((AppSearchResult) ZeusTransformUtils.preCheckCast(r3, AppSearchResult.class, "com.obric.aiagent.plugin"));
        }

        public final void a(AppSearchResult<List<SearchResult>> r5) {
            if (r5.isSuccess() == false) goto L13;
            List r6 = (List) ZeusTransformUtils.preCheckCast(r5.getResultValue(), List.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L11;
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator<T> r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            r0.add(((SearchResult) ZeusTransformUtils.preCheckCast(r8.next(), SearchResult.class, "com.obric.aiagent.plugin")).getGenericDocument());
            goto L8
        L10:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        L12:
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f18299a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r1 = d.n.f38560a;
            r4.resumeWith(d.n.f(r9));
            return;
        L11:
            r9 = d.a.p.b();
            goto L12
        L13:
            ILogDepend.Companion.e(r.TAG, "getNextPage failed: " + r5.getErrorMessage());
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f18299a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r11 = d.n.f38560a;
            r10.resumeWith(d.n.f(d.a.p.b()));
        }
    }

    /* JADX INFO: compiled from: AppFunctionMetadataEnumerator.kt */
    static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n<GlobalSearchSession> f18300a;

        g(kotlinx.coroutines.n<? super GlobalSearchSession> r3) {
            this.f18300a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((AppSearchResult) ZeusTransformUtils.preCheckCast(r3, AppSearchResult.class, "com.obric.aiagent.plugin"));
        }

        public final void a(AppSearchResult<GlobalSearchSession> r5) {
            if (r5.isSuccess() == false) goto L5;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f18300a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r4.resumeWith(d.n.f(r5.getResultValue()));
            return;
        L5:
            ILogDepend.Companion.e(r.TAG, "createGlobalSearchSession failed: " + r5.getErrorMessage());
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f18300a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r7 = d.n.f38560a;
            r6.resumeWith(d.n.f(null));
        }
    }

    private r() {
    }

    public static final /* synthetic */ Object a(r r2, GlobalSearchSession r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r2, GlobalSearchSession r3, Set r4, d.c.d r5) {
        return r2.a(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r2, List r3, d.c.d r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ExecutorService a() {
        return f18274b;
    }

    static {
        f18273a = new r();
        f18274b = Executors.newSingleThreadExecutor();
    }

    public final Object a(d.c.d<? super List<m>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r11, c.class, "com.obric.aiagent.plugin");
        if ((r1.f18289e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f18289e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.f18287c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f18289e;
        if (r4 == 0) goto L27;
        if (r4 == 1) goto L24;
        if (r4 == 2) goto L19;
        if (r4 != 3) goto L18;
        d.o.a(r12);     // Catch: Throwable -> L15
    L62:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r1.f18286b, Closeable.class, "com.obric.aiagent.plugin");
        r r0 = (r) ZeusTransformUtils.preCheckCast(r1.f18285a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L22
    L40:
        List<m> r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        d.f.c.a(r9, null);     // Catch: Throwable -> L15
        r1.f18285a = null;     // Catch: Throwable -> L15
        r1.f18286b = null;     // Catch: Throwable -> L15
        r1.f18289e = 3;     // Catch: Throwable -> L15
        r12 = r0.a(r13, r1);     // Catch: Throwable -> L15
        if (r12 != r3) goto L62;
        return r3;
    L22:
        Throwable th = th;
    L60:
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        d.f.c.a(r9, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L24:
        r this = (r) ZeusTransformUtils.preCheckCast(r1.f18285a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L15
    L31:
        GlobalSearchSession r14 = (GlobalSearchSession) ZeusTransformUtils.preCheckCast(r12, GlobalSearchSession.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r14 == null) goto L34;
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(r14, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        GlobalSearchSession r2 = (GlobalSearchSession) ZeusTransformUtils.preCheckCast(r15, GlobalSearchSession.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        r r5 = f18273a;     // Catch: Throwable -> L47
        r1.f18285a = this;     // Catch: Throwable -> L47
        r1.f18286b = r15;     // Catch: Throwable -> L47
        r1.f18289e = 2;     // Catch: Throwable -> L47
        Object r6 = r5.a(r2, r1);     // Catch: Throwable -> L47
        if (r6 != r3) goto L39;
        return r3;
    L39:
        r0 = this;
        r9 = r15;
        r12 = r6;
    L47:
        th = move-exception;
        th = th;
        r9 = r15;
        goto L60
    L34:
        return d.a.p.b();
    L27:
        d.o.a(r12);
        r1.f18285a = this;     // Catch: Throwable -> L15
        r1.f18289e = 1;     // Catch: Throwable -> L15
        r12 = b(r1);     // Catch: Throwable -> L15
        if (r12 != r3) goto L31;
        return r3;
    L15:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "enumerate failed", th);
        return d.a.p.b();
    L7:
        r1 = new c(this, r11);
        goto L8
    }

    private final Object a(List<m> r7, d.c.d<? super List<m>> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin");
        if ((r0.f18293d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18293d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f18291b;
        Object r11 = d.c.a.b.a();
        int r2 = r0.f18293d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r9 = (List) ZeusTransformUtils.preCheckCast(r0.f18290a, List.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L20:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        Iterator r14 = r13.iterator();
    L22:
        if (r14.hasNext() == false) goto L30;
        Object r4 = r14.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L26;
        d.a.p.c();
    L26:
        m r15 = (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.get(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L29;
        r1.add(r4);
    L29:
        r3 = r5;
        goto L22
    L30:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "filterEnabled: total=" + r9.size() + ", enabled=" + r16.size());
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        if (r9.isEmpty() == false) goto L17;
        return r9;
    L17:
        d.h.a.m r17 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r9, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f18290a = r9;
        r0.f18293d = 1;
        r6 = an.a(r17, r0);
        if (r6 != r11) goto L20;
        return r11;
    L7:
        r0 = new d(this, r10);
        goto L8
    }

    private final Object b(d.c.d<? super GlobalSearchSession> r6) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        AppSearchManager r7 = (AppSearchManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(AppSearchManager.class), AppSearchManager.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        return null;
    L6:
        kotlinx.coroutines.o r1 = new kotlinx.coroutines.o(d.c.a.b.a(r5), 1);
        r1.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r7.createGlobalSearchSession((Executor) ZeusTransformUtils.preCheckCast(a(), Executor.class, "com.obric.aiagent.plugin"), (Consumer) ZeusTransformUtils.preCheckCast(new g(r2), Consumer.class, "com.obric.aiagent.plugin"));
        Object r8 = r1.h();
        if (r8 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r5);
    L9:
        return r8;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0159 -> B:38:0x015e). Please report as a decompilation issue!!! */
    private final Object a(GlobalSearchSession r27, d.c.d<? super List<m>> r28) {
        r r0 = this;
        GlobalSearchSession r1 = r27;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
        r5.g -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f18284e;
        Object r6 = d.c.a.b.a();
        int r7 = r5.g;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L19;
        ArrayList r2 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.f18280a, ArrayList.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L16
    L48:
        Object r8 = d.n.f((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L53:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L57;
        ILogDepend.Companion.w(TAG, "collect components failed: " + r9.getMessage());
        r8 = ao.b();
    L57:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L59:
        if (r13.hasNext() == false) goto L64;
        m r14 = (m) ZeusTransformUtils.preCheckCast(r13.next(), m.class, "com.obric.aiagent.plugin");
        h r15 = (h) ZeusTransformUtils.preCheckCast(r10.get(r14.c()), h.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L63;
        r15 = new h(null, 1, null);
    L63:
        r12.add(m.a(r14, null, null, null, null, null, null, null, null, r15, null, 767, null));
        goto L59
    L64:
        List<m> r16 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "enumerated AppFunction entries=" + r2.size() + ", componentPackages=" + r10.size());
        if (Build.VERSION.SDK_INT != 36) goto L68;
        r16 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.a.f18187a.a(r16);
    L68:
        if (ILogDepend.Companion.isDebug() == false) goto L73;
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L71:
        if (r17.hasNext() == false) goto L73;
        ILogDepend.Companion.d(TAG, "AppFunctionEntry: " + ((m) ZeusTransformUtils.preCheckCast(r17.next(), m.class, "com.obric.aiagent.plugin")));
    L73:
        return r16;
    L16:
        th = th;
    L52:
        d.n.a r18 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L53
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ArrayList r19 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.f18283d, ArrayList.class, "com.obric.aiagent.plugin");
        SearchResults r20 = (SearchResults) ZeusTransformUtils.preCheckCast(r5.f18282c, SearchResults.class, "com.obric.aiagent.plugin");
        GlobalSearchSession r21 = (GlobalSearchSession) ZeusTransformUtils.preCheckCast(r5.f18281b, GlobalSearchSession.class, "com.obric.aiagent.plugin");
        r r110 = (r) ZeusTransformUtils.preCheckCast(r5.f18280a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        ArrayList r22 = r19;
        GlobalSearchSession r23 = r21;
    L38:
        r r25 = r110;
        List r111 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        r r24 = r25;
    L27:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L39;
        Iterator r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L34;
        m r113 = r24.a((GenericDocument) ZeusTransformUtils.preCheckCast(r112.next(), GenericDocument.class, "com.obric.aiagent.plugin"));
        if (r113 == null) goto L30;
        d.c.b.a.b.a(r22.add(r113));
        goto L30
    L34:
        r5.f18280a = r24;
        r5.f18281b = r23;
        r5.f18282c = r20;
        r5.f18283d = r22;
        r5.g = 2;
        Object r114 = r24.a(r20, r5);
        if (r114 != r6) goto L37;
        return r6;
    L37:
        r110 = r24;
        r4 = r114;
        goto L38
    L39:
        r20.close();
        d.n.a r26 = d.n.f38560a;     // Catch: Throwable -> L50
        r r29 = (r) ZeusTransformUtils.preCheckCast(r24, r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        Collection r31 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        Iterator r32 = r30.iterator();     // Catch: Throwable -> L50
    L42:
        if (r32.hasNext() == false) goto L44;
        r31.add(((m) ZeusTransformUtils.preCheckCast(r32.next(), m.class, "com.obric.aiagent.plugin")).c());     // Catch: Throwable -> L50
        goto L42
    L44:
        Set<String> r33 = (Set) ZeusTransformUtils.preCheckCast(r31, Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        r5.f18280a = r22;     // Catch: Throwable -> L50
        r5.f18281b = null;     // Catch: Throwable -> L50
        r5.f18282c = null;     // Catch: Throwable -> L50
        r5.f18283d = null;     // Catch: Throwable -> L50
        r5.g = 3;     // Catch: Throwable -> L50
        r4 = r29.a(r23, r33, r5);     // Catch: Throwable -> L50
        if (r4 != r6) goto L47;
        return r6;
    L47:
        r2 = r22;
    L50:
        th = th;
        r2 = r22;
        goto L52
    L21:
        ArrayList r34 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.f18283d, ArrayList.class, "com.obric.aiagent.plugin");
        SearchResults r35 = (SearchResults) ZeusTransformUtils.preCheckCast(r5.f18282c, SearchResults.class, "com.obric.aiagent.plugin");
        GlobalSearchSession r36 = (GlobalSearchSession) ZeusTransformUtils.preCheckCast(r5.f18281b, GlobalSearchSession.class, "com.obric.aiagent.plugin");
        r r115 = (r) ZeusTransformUtils.preCheckCast(r5.f18280a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r22 = r34;
        r0 = r115;
        Object r116 = r4;
        SearchResults r37 = r35;
        r1 = r36;
    L25:
        r111 = (List) ZeusTransformUtils.preCheckCast(r116, List.class, "com.obric.aiagent.plugin");
        SearchResults r210 = r37;
        r24 = r0;
        r23 = r1;
        r20 = r210;
        goto L27
    L22:
        d.o.a(r4);
        SearchSpec r38 = new SearchSpec.Builder().addFilterSchemas(new String[]{"AppFunctionStaticMetadata"}).setResultCountPerPage(100).build();
        d.h.b.o.c(r38, "build(...)");
        r37 = r1.search("", r38);
        d.h.b.o.c(r37, "search(...)");
        r22 = new ArrayList();
        r5.f18280a = r0;
        r5.f18281b = r1;
        r5.f18282c = r37;
        r5.f18283d = r22;
        r5.g = 1;
        r116 = r0.a(r37, r5);
        if (r116 != r6) goto L25;
        return r6;
    L7:
        r5 = new b(r0, r3);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.Set] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0214 -> B:69:0x0217). Please report as a decompilation issue!!! */
    private final Object a(GlobalSearchSession r18, Set<String> r19, d.c.d<? super Map<String, h>> r20) {
        r r0 = this;
        SearchResults r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r19, Set.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L7;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f18278d;
        Object r7 = d.c.a.b.a();
        int r8 = r5.f;
        int r9 = 0;
        if (r8 == 0) goto L22;
        if (r8 == 1) goto L17;
        if (r8 != 2) goto L16;
        HashMap r1 = (HashMap) ZeusTransformUtils.preCheckCast(r5.f18277c, HashMap.class, "com.obric.aiagent.plugin");
        SearchResults r3 = (SearchResults) ZeusTransformUtils.preCheckCast(r5.f18276b, SearchResults.class, "com.obric.aiagent.plugin");
        r r10 = (r) ZeusTransformUtils.preCheckCast(r5.f18275a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L20
        r r11 = r10;
        r2 = r3;
    L69:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r9 = 0;
        r r13 = r11;
        SearchResults r14 = r2;
    L36:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L71;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L20
    L39:
        if (r15.hasNext() == false) goto L66;
        GenericDocument r16 = (GenericDocument) ZeusTransformUtils.preCheckCast(r15.next(), GenericDocument.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        String r17 = r16.getPropertyString("packageName");     // Catch: Throwable -> L20
        if (r17 == null) goto L65;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L46;
        r17 = null;
    L46:
        if (r17 == null) goto L65;
        Map r110 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Object r111 = r110.get(r17);     // Catch: Throwable -> L20
        if (r111 != null) goto L50;
        r111 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r110.put(r17, r111);     // Catch: Throwable -> L20
    L50:
        Map r112 = (Map) ZeusTransformUtils.preCheckCast(r111, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        GenericDocument[] r21 = r16.getPropertyDocumentArray("dataTypes");     // Catch: Throwable -> L20
        if (r21 != null) goto L53;
        r21 = new GenericDocument[r9];     // Catch: Throwable -> L20
    L53:
        int r113 = r21.length;     // Catch: Throwable -> L20
        int r114 = r9;
    L54:
        if (r114 >= r113) goto L65;
        GenericDocument r115 = r21[r114];     // Catch: Throwable -> L20
        String r116 = r115.getPropertyString("name");     // Catch: Throwable -> L20
        if (r116 == null) goto L64;
        GenericDocument r22 = r115.getPropertyDocument("dataTypeMetadata");     // Catch: Throwable -> L20
        if (r22 == null) goto L64;
        i r23 = f18273a.f(r22);     // Catch: Throwable -> L20
        if (r23 == null) goto L64;
        r112.put(r116, r23);     // Catch: Throwable -> L20
    L64:
        r114 = r114 + 1;     // Catch: Throwable -> L20
    L65:
        r9 = 0;
        goto L39
    L66:
        r5.f18275a = r13;     // Catch: Throwable -> L20
        r5.f18276b = r14;     // Catch: Throwable -> L20
        r5.f18277c = r1;     // Catch: Throwable -> L20
        r5.f = 2;     // Catch: Throwable -> L20
        r6 = r13.a(r14, r5);     // Catch: Throwable -> L20
        r11 = r13;
        r2 = r14;
        if (r6 != r7) goto L69;
        return r7;
    L71:
        r14.close();
        Map r24 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin");
        Map r25 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r24.size())), Map.class, "com.obric.aiagent.plugin");
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(r24.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L73:
        if (r26.hasNext() == false) goto L75;
        Object r27 = r26.next();
        r25.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r27, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), new h(ao.d((Map) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r27, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Map.class, "com.obric.aiagent.plugin"))));
        goto L73
    L75:
        return r25;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        HashMap r28 = (HashMap) ZeusTransformUtils.preCheckCast(r5.f18277c, HashMap.class, "com.obric.aiagent.plugin");
        SearchResults r29 = (SearchResults) ZeusTransformUtils.preCheckCast(r5.f18276b, SearchResults.class, "com.obric.aiagent.plugin");
        r r30 = (r) ZeusTransformUtils.preCheckCast(r5.f18275a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L20
        HashMap r31 = r28;
        r r32 = r30;
        SearchResults r33 = r29;
    L34:
        r12 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        HashMap r117 = r31;
        r13 = r32;
        r1 = r117;
        r14 = r33;
        goto L36
    L22:
        d.o.a(r6);
        if (r2.isEmpty() == true) goto L25;
        Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r35 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r34, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r36 = r34.iterator();
    L28:
        if (r36.hasNext() == false) goto L30;
        r35.add("AppFunctionComponentMetadataDocument-" + ((String) ZeusTransformUtils.preCheckCast(r36.next(), String.class, "com.obric.aiagent.plugin")));
        goto L28
    L30:
        List r37 = (List) ZeusTransformUtils.preCheckCast(r35, List.class, "com.obric.aiagent.plugin");
        SearchSpec.Builder r38 = new SearchSpec.Builder();
        String[] r39 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r37, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        SearchSpec r40 = r38.addFilterSchemas((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r39, r39.length), String[].class, "com.obric.aiagent.plugin")).setResultCountPerPage(100).build();
        d.h.b.o.c(r40, "build(...)");
        SearchResults r41 = r18.search("", r40);
        d.h.b.o.c(r41, "search(...)");
        r31 = new HashMap();
        r5.f18275a = r0;     // Catch: Throwable -> L20
        r5.f18276b = r41;     // Catch: Throwable -> L20
        r5.f18277c = r31;     // Catch: Throwable -> L20
        r5.f = 1;     // Catch: Throwable -> L20
        r6 = r0.a(r41, r5);     // Catch: Throwable -> L20
        r32 = r0;
        r33 = r41;
        if (r6 != r7) goto L34;
        return r7;
    L25:
        return ao.b();
    L20:
        th = move-exception;
        r2.close();
        throw th;
    L7:
        r5 = new a(r0, r4);
        goto L8
    }

    private final m a(GenericDocument r23) {
        String r1 = r23.getPropertyString("packageName");
        boolean r5 = true;
        if (r1 != null) goto L5;
    L12:
        String r2 = r23.getId();
        d.h.b.o.c(r2, "getId(...)");
        r1 = d.o.o.a(r2, '/', "");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L19;
        r1 = null;
    L19:
        if (r1 != null) goto L21;
        return null;
    L21:
        String r12 = r1;
        String r3 = r23.getPropertyString("functionId");
        if (r3 != null) goto L24;
    L31:
        String r4 = r23.getId();
        d.h.b.o.c(r4, "getId(...)");
        r3 = d.o.o.b(r4, '/', "");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L35;
        r5 = false;
    L35:
        if (r5 == true) goto L38;
        r3 = null;
    L38:
        if (r3 != null) goto L40;
        return null;
    L40:
        String r13 = r3;
        String r10 = r23.getPropertyString("schemaCategory");
        String r11 = r23.getPropertyString("schemaName");
        return new m(r10, r11, r12, r13, com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.b.f16414a.a(r10, r11, r13), r23.getPropertyString("description"), b(r23), c(r23), null, e(r23), 256, null);
    L24:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == true) goto L30;
        r3 = null;
    L30:
        if (r3 != null) goto L40;
    L26:
        r14 = false;
        goto L27
    L15:
        r9 = false;
        goto L16
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == true) goto L11;
        r1 = null;
    L11:
        if (r1 != null) goto L21;
    L7:
        r15 = false;
        goto L8
    }

    private final JsonObject b(GenericDocument r10) {
        GenericDocument[] r9 = r10.getPropertyDocumentArray("parameters");
        if (r9 != null) goto L6;
        return null;
    L6:
        JsonObject r11 = new JsonObject();
        JsonArray r0 = new JsonArray();
        int r1 = 0;
        int r2 = r9.length;
    L8:
        if (r1 >= r2) goto L23;
        GenericDocument r4 = r9[r1];
        String r5 = r4.getPropertyString("name");
        if (r5 == null) goto L22;
        GenericDocument r6 = r4.getPropertyDocument("dataTypeMetadata");
        if (r6 == null) goto L22;
        r r7 = f18273a;
        if (r7.d(r6) != null) goto L22;
        r11.add(r5, (JsonElement) ZeusTransformUtils.preCheckCast(r7.a(r6, r4.getPropertyString("description")), JsonElement.class, "com.obric.aiagent.plugin"));
        if (r4.getPropertyBoolean("isRequired") == false) goto L20;
    L21:
        r0.add(r5);
        goto L22
    L20:
        if (r6.getPropertyBoolean("isNullable") == false) goto L21;
    L22:
        r1 = r1 + 1;
        goto L8
    L23:
        JsonObject r12 = new JsonObject();
        r12.addProperty("type", "object");
        r12.add("properties", (JsonElement) ZeusTransformUtils.preCheckCast(r11, JsonElement.class, "com.obric.aiagent.plugin"));
        r12.add("required", (JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.aiagent.plugin"));
        return r12;
    }

    private final Map<String, String> c(GenericDocument r6) {
        GenericDocument[] r5 = r6.getPropertyDocumentArray("parameters");
        if (r5 == null) goto L5;
        Map r7 = ao.a();
        int r0 = 0;
        int r1 = r5.length;
    L7:
        if (r0 >= r1) goto L20;
        GenericDocument r2 = r5[r0];
        String r3 = r2.getPropertyString("name");
        if (r3 == null) goto L18;
        GenericDocument r4 = r2.getPropertyDocument("dataTypeMetadata");
        if (r4 == null) goto L18;
        String r8 = f18273a.d(r4);
        if (r8 == null) goto L18;
        r7.put(r3, r8);
    L18:
        r0 = r0 + 1;
        goto L7
    L20:
        return ao.a(r7);
    L5:
        return ao.b();
    }

    private final String d(GenericDocument r3) {
        int r2 = (int) r3.getPropertyLong("type");
        if (r2 != 3) goto L5;
    L12:
        String r4 = r3.getPropertyString("objectQualifiedName");
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        if (d.a.i.b(n.a(), r4) == true) goto L17;
        return null;
    L17:
        return r4;
    L5:
        if (r2 == 14) goto L12;
        if (r2 != 11) goto L9;
        r4 = r3.getPropertyString("dataTypeReference");
        goto L13
    L9:
        if (r2 == 12) goto L12;
        r4 = null;
        goto L13
    }

    static /* synthetic */ JsonObject a(r r0, GenericDocument r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r1.getPropertyString("description");
    L6:
        return r0.a(r1, r2);
    }

    private final JsonObject a(GenericDocument r17, String r18) {
        String r2 = r18;
        int r8 = 0;
        switch(((int) r17.getPropertyLong("type"))) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L34;
            case 9: goto L4;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        JsonObject r0 = new JsonObject();
    L36:
        String[] r1 = r17.getPropertyStringArray("enumValues");
        if (r1 != null) goto L39;
    L51:
        if (r2 != null) goto L53;
    L58:
        return r0;
    L53:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L56;
        r2 = null;
    L56:
        if (r2 == null) goto L58;
        r0.addProperty("description", r2);
        goto L58
    L39:
        if (r1.length != 0) goto L41;
        boolean r4 = true;
    L43:
        if ((!r4) == true) goto L46;
        r1 = null;
    L46:
        if (r1 == null) goto L51;
        JsonArray r5 = new JsonArray();
        int r6 = r1.length;
    L48:
        if (r8 >= r6) goto L50;
        r5.add(r1[r8]);
        r8 = r8 + 1;
        goto L48
    L50:
        d.x r3 = d.x.f38692a;
        r0.add("enum", (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L51
    L41:
        r4 = false;
        goto L43
    L5:
        r0 = a("object");
        goto L36
    L6:
        r0 = new JsonObject();
        r0.addProperty("type", "array");
        GenericDocument r7 = r17.getPropertyDocument("itemType");
        if (r7 == null) goto L10;
        JsonObject r9 = a(f18273a, r7, null, 2, null);
        if (r9 == null) goto L10;
    L11:
        r0.add("items", (JsonElement) ZeusTransformUtils.preCheckCast(r9, JsonElement.class, "com.obric.aiagent.plugin"));
    L10:
        r9 = new JsonObject();
        goto L11
    L12:
        r0 = a(WsChannelMultiProcessSharedProvider.INT_TYPE);
        goto L36
    L13:
        r0 = a("number");
        goto L36
    L14:
        r0 = new JsonObject();
        r0.addProperty("type", "object");
        JsonObject r10 = new JsonObject();
        JsonArray r11 = new JsonArray();
        GenericDocument[] r12 = r17.getPropertyDocumentArray("properties");
        if (r12 != null) goto L17;
        r12 = new GenericDocument[0];
    L17:
        int r13 = r12.length;
        int r14 = 0;
    L18:
        if (r14 >= r13) goto L33;
        GenericDocument r15 = r12[r14];
        String r16 = r15.getPropertyString("name");
        if (r16 == null) goto L32;
        GenericDocument r19 = r15.getPropertyDocument("dataTypeMetadata");
        if (r19 == null) goto L26;
        JsonObject r20 = f18273a.a(r19, r15.getPropertyString("description"));
        if (r20 == null) goto L26;
    L27:
        r10.add(r16, (JsonElement) ZeusTransformUtils.preCheckCast(r20, JsonElement.class, "com.obric.aiagent.plugin"));
        if (r19 == null) goto L32;
        if (r19.getPropertyBoolean("isNullable") == true) goto L32;
        r11.add(r16);
    L26:
        r20 = new JsonObject();
    L32:
        r14 = r14 + 1;
        goto L18
    L33:
        r0.add("properties", (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
        r0.add("required", (JsonElement) ZeusTransformUtils.preCheckCast(r11, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L36
    L34:
        r0 = a(WsChannelMultiProcessSharedProvider.STRING_TYPE);
        goto L36
    L35:
        r0 = a(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE);
        goto L36
    }

    private final JsonObject a(String r2) {
        JsonObject r1 = new JsonObject();
        r1.addProperty("type", r2);
        return r1;
    }

    private final i e(GenericDocument r6) {
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        r r5 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        GenericDocument r3 = r6.getPropertyDocument("response");     // Catch: Throwable -> L11
        if (r3 != null) goto L6;
        return null;
    L6:
        GenericDocument r4 = r3.getPropertyDocument("valueType");     // Catch: Throwable -> L11
        if (r4 != null) goto L9;
        return null;
    L9:
        Object r7 = d.n.f(r5.f(r4));     // Catch: Throwable -> L11
    L13:
        Throwable r8 = d.n.c(r7);
        if (r8 != null) goto L16;
        r1 = r7;
    L18:
        return (i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.aiagent.plugin");
    L16:
        ILogDepend.Companion.w(TAG, "parseReturnSchema failed for " + r6.getPropertyString("functionId") + ": " + r8.getMessage());
    L11:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L13
    }

    private final i f(GenericDocument r13) {
        boolean r5 = r13.getPropertyBoolean("isNullable");
        String r0 = r13.getPropertyString("description");
        String r1 = "";
        if (r0 != null) goto L5;
        String r6 = "";
    L6:
        int r4 = 0;
        Collection r7 = null;
        t r8 = null;
        String r9 = null;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.e r10 = null;
        Collection r11 = null;
        switch(((int) r13.getPropertyLong("type"))) {
            case 0: goto L103;
            case 1: goto L128;
            case 2: goto L127;
            case 3: goto L78;
            case 4: goto L125;
            case 5: goto L124;
            case 6: goto L123;
            case 7: goto L61;
            case 8: goto L53;
            case 9: goto L129;
            case 10: goto L46;
            case 11: goto L41;
            case 12: goto L31;
            case 13: goto L22;
            case 14: goto L9;
            default: goto L129;
        };
    L9:
        String r12 = r13.getPropertyString("objectQualifiedName");
        if (r12 == null) goto L116;
        GenericDocument[] r14 = r13.getPropertyDocumentArray("oneOf");
        if (r14 != null) goto L14;
        r14 = new GenericDocument[0];
    L14:
        r r2 = f18273a;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r15 = r14.length;
    L15:
        if (r4 >= r15) goto L20;
        i r16 = r2.f(r14[r4]);
        if (r16 == null) goto L19;
        r3.add(r16);
    L19:
        r4 = r4 + 1;
        goto L15
    L20:
        r8 = new t((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r12, r5, r6);
    L116:
        return (i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.aiagent.plugin");
    L22:
        String r17 = r13.getPropertyString("objectQualifiedName");
        if (r17 != null) goto L25;
    L29:
        r9 = "android.app.PendingIntent";
    L117:
        return (i) ZeusTransformUtils.preCheckCast(new u(r9, r5, r6), i.class, "com.obric.aiagent.plugin");
    L25:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L27;
        r9 = r17;
    L27:
        if (r9 == null) goto L29;
    L31:
        GenericDocument[] r18 = r13.getPropertyDocumentArray("allOf");
        if (r18 != null) goto L34;
        r18 = new GenericDocument[0];
    L34:
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r20 = r18.length;
    L35:
        if (r4 >= r20) goto L118;
        i r21 = f(r18[r4]);
        if (r21 == null) goto L39;
        r19.add(r21);
    L39:
        r4 = r4 + 1;
        goto L35
    L118:
        return (i) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.b((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), r13.getPropertyString("objectQualifiedName"), r5, r6), i.class, "com.obric.aiagent.plugin");
    L41:
        String r110 = r13.getPropertyString("dataTypeReference");
        if (r110 == null) goto L119;
        r1 = r110;
    L119:
        return (i) ZeusTransformUtils.preCheckCast(new v(r1, r5, r6), i.class, "com.obric.aiagent.plugin");
    L46:
        GenericDocument r111 = r13.getPropertyDocument("itemType");
        if (r111 != null) goto L49;
        return null;
    L49:
        i r112 = f(r111);
        if (r112 == null) goto L120;
        r10 = new com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.e(r112, r5, r6);
    L120:
        return (i) ZeusTransformUtils.preCheckCast(r10, i.class, "com.obric.aiagent.plugin");
    L53:
        String[] r113 = r13.getPropertyStringArray("enumValues");
        if (r113 != null) goto L56;
        r113 = new String[0];
    L56:
        Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(d.a.i.i(r113), Collection.class, "com.obric.aiagent.plugin");
        if (r114.isEmpty() == true) goto L121;
        r11 = r114;
    L121:
        return (i) ZeusTransformUtils.preCheckCast(new ah(r5, r6, (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin");
    L61:
        String[] r115 = r13.getPropertyStringArray("enumValues");
        if (r115 != null) goto L64;
        r115 = new String[0];
    L64:
        Collection r116 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r22 = r115.length;
    L65:
        if (r4 >= r22) goto L70;
        Integer r23 = d.o.o.d(r115[r4]);
        if (r23 == null) goto L69;
        r116.add(r23);
    L69:
        r4 = r4 + 1;
        goto L65
    L70:
        Collection r117 = (Collection) ZeusTransformUtils.preCheckCast(d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r116, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin");
        if (r117.isEmpty() == true) goto L122;
        r7 = r117;
    L122:
        return (i) ZeusTransformUtils.preCheckCast(new p(r5, r6, (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin");
    L78:
        GenericDocument[] r118 = r13.getPropertyDocumentArray("properties");
        if (r118 != null) goto L81;
        r118 = new GenericDocument[0];
    L81:
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r25 = r118.length;
        int r26 = 0;
    L82:
        if (r26 >= r25) goto L96;
        GenericDocument r27 = r118[r26];
        String r119 = r27.getPropertyString("name");
        if (r119 != null) goto L86;
    L85:
        d.m r28 = null;
    L93:
        if (r28 == null) goto L95;
        r24.add(r28);
    L95:
        r26 = r26 + 1;
        goto L82
    L86:
        GenericDocument r29 = r27.getPropertyDocument("dataTypeMetadata");
        if (r29 == null) goto L85;
        i r30 = f18273a.f(r29);
        if (r30 == null) goto L85;
        r28 = d.s.a(r119, r30);
        goto L93
    L96:
        Map r31 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        String[] r32 = r13.getPropertyStringArray("required");
        if (r32 != null) goto L126;
        r32 = new String[0];
    L126:
        return (i) ZeusTransformUtils.preCheckCast(new s(r31, d.a.i.g(r32), r13.getPropertyString("objectQualifiedName"), r5, r6), i.class, "com.obric.aiagent.plugin");
    L129:
        return null;
    L123:
        return (i) ZeusTransformUtils.preCheckCast(new q(r5, r6), i.class, "com.obric.aiagent.plugin");
    L124:
        return (i) ZeusTransformUtils.preCheckCast(new o(r5, r6), i.class, "com.obric.aiagent.plugin");
    L125:
        return (i) ZeusTransformUtils.preCheckCast(new j(r5, r6), i.class, "com.obric.aiagent.plugin");
    L127:
        return (i) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.g(r5, r6), i.class, "com.obric.aiagent.plugin");
    L128:
        return (i) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.f(r5, r6), i.class, "com.obric.aiagent.plugin");
    L103:
        return (i) ZeusTransformUtils.preCheckCast(new ai(r5, r6), i.class, "com.obric.aiagent.plugin");
    L5:
        r6 = r0;
        goto L6
    }

    private final Object a(SearchResults r5, d.c.d<? super List<? extends GenericDocument>> r6) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r7 = new kotlinx.coroutines.o(d.c.a.b.a(r4), 1);
        r7.e();
        kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r5.getNextPage((Executor) ZeusTransformUtils.preCheckCast(a(), Executor.class, "com.obric.aiagent.plugin"), (Consumer) ZeusTransformUtils.preCheckCast(new f(r1), Consumer.class, "com.obric.aiagent.plugin"));
        Object r8 = r7.h();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r4);
    L5:
        return r8;
    }
}
