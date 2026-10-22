package com.obric.autogui.session.d;

import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: AsyncResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e<T> extends com.obric.autogui.session.d.a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f30887b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f30888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f30889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c<T> f30890e;

    /* JADX INFO: compiled from: AsyncResource.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final <T> e<T> a(com.obric.autogui.session.d.a<T> r8, long r9) {
            o.e(r8, DBHelper.BATTERY_COL_SOURCE);
            return new e(r8, r9, null, 4, null);
        }
    }

    /* JADX INFO: compiled from: AsyncResource.kt */
    @d.c.b.a.f(b = "AsyncResource.kt", c = {226}, d = "invokeSuspend", e = "com.obric.autogui.session.preload.CachedAsyncResource$spec$1$1")
    static final class b extends d.c.b.a.l implements d.h.a.b<d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c<T> f30892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e<T> f30893c;

        b(c<T> r3, e<T> r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30892b = r3;
            this.f30893c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super T> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30892b, this.f30893c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(Object r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30891a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r4);
        L11:
            if (r4 == null) goto L13;
            e.a(this.f30893c).set(SystemClock.elapsedRealtime());
            return r4;
        L13:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r4);
            d.h.a.b<d.c.d<? super T>, Object> r5 = this.f30892b.b();
            this.f30891a = 1;
            r4 = r5.invoke(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    static {
        f30887b = new a(null);
    }

    public static /* synthetic */ x lambda$niL358xahwDJCvMDAVz7j9yTEHk(e r0, c r1, Object r2) {
        return a(r0, r1, r2);
    }

    public static final /* synthetic */ AtomicLong a(e r0) {
        return r0.f30889d;
    }

    /* synthetic */ e(com.obric.autogui.session.d.a r2, long r3, am r5, int r6, d.h.b.h r7) {
        am r8 = (am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L5;
        r8 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    L5:
        this(r2, r3, r8);
    }

    private e(com.obric.autogui.session.d.a<T> r16, long r17, am r19) {
        super((am) ZeusTransformUtils.wrapperContextForParams(r19, am.class, "com.obric.aiagent.plugin"));
        this.f30888c = r17;
        if (r17 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        this.f30889d = new AtomicLong(0);
        final c<T> r7 = r16.a();
        this.f30890e = c.a(r7, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r7, this, null), d.h.a.b.class, "com.obric.aiagent.plugin"), null, null, new $$Lambda$e$niL358xahwDJCvMDAVz7j9yTEHk(this, r7), 13, null);
        return;
    L10:
        throw new IllegalArgumentException("ttlMs must be > 0".toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.autogui.session.d.a
    public c<T> a() {
        return this.f30890e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final x a(e r2, c r3, Object r4) {
        r2.f30889d.set(0);
        r3.e().invoke(r4);
        return x.f38692a;
    }

    private final boolean g() {
        long r0 = this.f30889d.get();
        if (r0 != 0) goto L5;
    L7:
        return false;
    L5:
        if ((SystemClock.elapsedRealtime() - r0) > this.f30888c) goto L7;
        return true;
    }

    public final void f() {
        this.f30889d.set(0);
    }

    @Override // com.obric.autogui.session.d.a
    public Object a(d.c.d<? super T> r4) {
        d.c.d<? super T> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (e() == true) goto L10;
        if (d() == false) goto L10;
        if (g() == true) goto L10;
        com.obric.autogui.session.d.a.a((com.obric.autogui.session.d.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.session.d.a.class, "com.obric.aiagent.plugin"), null, 1, null);
    L10:
        return super.a(r5);
    }
}
