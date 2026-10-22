package com.obric.autogui.session.a;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AOLocalJournalCleanser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30711a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<b> f30712b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.f.a f30713c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final am f30714d = null;

    /* JADX INFO: renamed from: com.obric.autogui.session.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOLocalJournalCleanser.kt */
    @f(b = "AOLocalJournalCleanser.kt", c = {61}, d = "invokeSuspend", e = "com.obric.autogui.session.journal.AOLocalJournalCleanser$launch$1")
    static final class C0831a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f30716b;

        C0831a(b r3, d.c.d<? super C0831a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30716b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0831a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0831a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0831a(this.f30716b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30715a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L11:
            Loog.INSTANCE.d("LocJorCleans", "[Cleanser] task `" + this.f30716b + "` started to run");
            b r11 = this.f30716b;
            long r5 = System.currentTimeMillis();
            r11.a();     // Catch: Throwable -> L14
        L13:
            a.c().set(null);
            long r7 = System.currentTimeMillis() - r5;
            kotlinx.coroutines.f.a.C1058a.b(a.b(), null, 1, null);
            Loog.INSTANCE.d("LocJorCleans", "[Cleanser] task `" + this.f30716b + "` done; latency=" + r7 + "ms");
            return x.f38692a;
        L14:
            th = move-exception;
            Loog.INSTANCE.e("LocJorCleans", "[Cleanser] task `" + r11 + "` failed to finish", th);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            a.c().set(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            kotlinx.coroutines.f.a r12 = a.b();
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30715a = 1;
            if (kotlinx.coroutines.f.a.C1058a.a(r12, null, r2, 1, null) != r0) goto L11;
            return r0;
        }
    }

    private a() {
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a b() {
        return f30713c;
    }

    public static final /* synthetic */ AtomicReference c() {
        return f30712b;
    }

    static {
        f30711a = new a();
        f30712b = new AtomicReference(null);
        f30713c = kotlinx.coroutines.f.c.a(false, 1, null);
        f30714d = an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }

    public final void a(File r7, long r8) {
        d.h.b.o.e(r7, "rootDir");
        b r6 = new b(r8, r7);
        AtomicReference<b> r9 = f30712b;
        if (r9.compareAndSet(null, r6) == true) goto L6;
        Loog.INSTANCE.w("LocJorCleans", "[Cleanser] for `" + r6 + "` cannot be run since current running = " + r9.get() + '.');
        return;
    L6:
        i.a(f30714d, null, null, (m) ZeusTransformUtils.preCheckCast(new C0831a(r6, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object a(d.c.d<? super x> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = kotlinx.coroutines.f.a.C1058a.a(f30713c, null, r2, 1, null);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    public final void a() {
        kotlinx.coroutines.f.a r2 = f30713c;
        if (r2.a() == false) goto L6;
        kotlinx.coroutines.f.a.C1058a.b(r2, null, 1, null);
        return;
    }
}
