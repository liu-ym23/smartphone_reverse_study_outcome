package com.obric.autogui.database;

import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.n;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: DatabaseUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0728a f29021a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AutoActionDatabase f29022b;

    /* JADX INFO: renamed from: com.obric.autogui.database.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DatabaseUtils.kt */
    public static final class C0728a {
        public /* synthetic */ C0728a(h r1) {
            this();
        }

        private C0728a() {
        }
    }

    /* JADX INFO: compiled from: DatabaseUtils.kt */
    @d.c.b.a.f(b = "DatabaseUtils.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.database.DatabaseUtils$deleteTaskById$2")
    static final class b extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Long> f29025c;

        b(a r3, List<Long> r4, d.c.d<? super b> r5) {
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29024b = r3;
            this.f29025c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f29024b, this.f29025c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f29023a != 0) goto L14;
            o.a(r2);
            a r3 = this.f29024b;
            List<Long> r1 = this.f29025c;
            n.a r0 = n.f38560a;     // Catch: Throwable -> L7
            Object r4 = n.f(d.c.b.a.b.a(a.a(r3).o().a(r1)));     // Catch: Throwable -> L7
        L9:
            Integer r5 = d.c.b.a.b.a(0);
            if (n.b(r4) == true) goto L12;
            return r4;
        L12:
            return r5;
        L7:
            th = move-exception;
            n.a r6 = n.f38560a;
            r4 = n.f(o.a(th));
            goto L9
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DatabaseUtils.kt */
    @d.c.b.a.f(b = "DatabaseUtils.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.database.DatabaseUtils$deleteTaskByTimerTaskId$2")
    static final class c extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f29028c;

        c(a r3, List<String> r4, d.c.d<? super c> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29027b = r3;
            this.f29028c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f29027b, this.f29028c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f29026a != 0) goto L14;
            o.a(r2);
            a r3 = this.f29027b;
            List<String> r1 = this.f29028c;
            n.a r0 = n.f38560a;     // Catch: Throwable -> L7
            Object r4 = n.f(d.c.b.a.b.a(a.a(r3).o().b(r1)));     // Catch: Throwable -> L7
        L9:
            Integer r5 = d.c.b.a.b.a(0);
            if (n.b(r4) == true) goto L12;
            return r4;
        L12:
            return r5;
        L7:
            th = move-exception;
            n.a r6 = n.f38560a;
            r4 = n.f(o.a(th));
            goto L9
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DatabaseUtils.kt */
    @d.c.b.a.f(b = "DatabaseUtils.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.database.DatabaseUtils$getTaskById$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f29031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<com.obric.autogui.database.entity.a, x> f29032d;

        d(a r3, long r4, d.h.a.b<? super com.obric.autogui.database.entity.a, x> r6, d.c.d<? super d> r7) {
            d.h.a.b<com.obric.autogui.database.entity.a, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29030b = r3;
            this.f29031c = r4;
            this.f29032d = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f29030b, this.f29031c, this.f29032d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f29029a != 0) goto L7;
            o.a(r3);
            com.obric.autogui.database.entity.a r4 = a.a(this.f29030b).o().a(this.f29031c);
            this.f29032d.invoke(r4);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DatabaseUtils.kt */
    @d.c.b.a.f(b = "DatabaseUtils.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.database.DatabaseUtils$insertTask$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.database.entity.a f29035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ m<Boolean, Long, x> f29036d;

        e(a r3, com.obric.autogui.database.entity.a r4, m<? super Boolean, ? super Long, x> r5, d.c.d<? super e> r6) {
            m<Boolean, Long, x> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29034b = r3;
            this.f29035c = r4;
            this.f29036d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f29034b, this.f29035c, this.f29036d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f29033a != 0) goto L14;
            o.a(r7);
            long r2 = a.a(this.f29034b).o().a(this.f29035c);     // Catch: Exception -> L10
            if (r2 == (-1)) goto L8;
            this.f29036d.invoke(d.c.b.a.b.a(true), d.c.b.a.b.a(r2));     // Catch: Exception -> L10
            a.b(this.f29034b);     // Catch: Exception -> L10
        L15:
        L12:
            return x.f38692a;
        L8:
            this.f29036d.invoke(d.c.b.a.b.a(false), d.c.b.a.b.a(-1));     // Catch: Exception -> L10
        L10:
            this.f29036d.invoke(d.c.b.a.b.a(false), d.c.b.a.b.a(-1));
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DatabaseUtils.kt */
    @d.c.b.a.f(b = "DatabaseUtils.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.database.DatabaseUtils$updateTask$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.database.entity.a f29039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Boolean, x> f29040d;

        f(a r3, com.obric.autogui.database.entity.a r4, d.h.a.b<? super Boolean, x> r5, d.c.d<? super f> r6) {
            d.h.a.b<Boolean, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29038b = r3;
            this.f29039c = r4;
            this.f29040d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f29038b, this.f29039c, this.f29040d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f29037a != 0) goto L11;
            o.a(r2);
            a.a(this.f29038b).o().b(this.f29039c);     // Catch: Exception -> L7
            this.f29040d.invoke(d.c.b.a.b.a(true));     // Catch: Exception -> L7
            a.b(this.f29038b);     // Catch: Exception -> L7
        L9:
            return x.f38692a;
        L7:
            this.f29040d.invoke(d.c.b.a.b.a(false));
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f29021a = new C0728a(null);
    }

    public a(AutoActionDatabase r2) {
        d.h.b.o.e(r2, "autoActionDatabase");
        this.f29022b = r2;
    }

    public static final /* synthetic */ AutoActionDatabase a(a r0) {
        return r0.f29022b;
    }

    public static final /* synthetic */ void b(a r0) {
        r0.a();
    }

    public final void a(com.obric.autogui.database.entity.a r9, m<? super Boolean, ? super Long, x> r10) {
        m r11 = (m) ZeusTransformUtils.wrapperContextForParams(r10, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "task");
        d.h.b.o.e(r11, "callback");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r9, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final kotlinx.coroutines.b.h<List<com.obric.autogui.database.entity.a>> a(int r1, int r2, String r3) {
        return this.f29022b.o().a(r1, r2, r3);
    }

    public final void a(long r14, d.h.a.b<? super com.obric.autogui.database.entity.a, x> r16) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "callback");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r14, r6, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(com.obric.autogui.database.entity.a r9, d.h.a.b<? super Boolean, x> r10) {
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "task");
        d.h.b.o.e(r11, "callback");
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r9, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object a(List<Long> r5, d.c.d<? super x> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new b(this, r7, null), m.class, "com.obric.aiagent.plugin"), r8);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    public final Object b(List<String> r5, d.c.d<? super x> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new c(this, r7, null), m.class, "com.obric.aiagent.plugin"), r8);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    private final void a() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Intent r0 = new Intent("com.obric.autogui.database.TASK_LIST_CHANGED");
        if (r2 == null) goto L6;
        r2.sendBroadcast(r0);
        return;
    }
}
