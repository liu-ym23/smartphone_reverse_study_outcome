package com.obric.aiagent.executionengine.scheduler.impl.a;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: AtomicActionScheduler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements com.obric.aiagent.executionengine.scheduler.impl.a.e.b {
    private static final String TAG = "AtomicActionScheduler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f18120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<com.obric.aiagent.executionengine.scheduler.impl.a.e> f18121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicInteger f18122c;

    /* JADX INFO: compiled from: AtomicActionScheduler.kt */
    @d.c.b.a.f(b = "AtomicActionScheduler.kt", c = {97}, d = "maybeSchedulePendingLeaves", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionScheduler")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f18126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f18127e;
        int f;

        a(h r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18127e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18126d = r3;
            this.f |= Integer.MIN_VALUE;
            return h.a(this.f18127e, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AtomicActionScheduler.kt */
    @d.c.b.a.f(b = "AtomicActionScheduler.kt", c = {174}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionScheduler$onStateChanged$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.a.e.a f18129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.a.e f18130c;

        b(com.obric.aiagent.executionengine.scheduler.impl.a.e.a r3, com.obric.aiagent.executionengine.scheduler.impl.a.e r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18129b = r3;
            this.f18130c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f18129b, this.f18130c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18128a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            if (this.f18129b != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18068e) goto L11;
        L12:
            this.f18130c.b((com.obric.aiagent.executionengine.scheduler.impl.a.e.b) ZeusTransformUtils.preCheckCast(h.f18120a, com.obric.aiagent.executionengine.scheduler.impl.a.e.b.class, "com.obric.aiagent.plugin"));
            h.a().decrementAndGet();
            h r7 = h.f18120a;
            com.obric.aiagent.executionengine.scheduler.impl.a.e r2 = this.f18130c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18128a = 1;
            if (h.b(r7, r2, r3) != r0) goto L16;
            return r0;
        L11:
            if (this.f18129b != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18067d) goto L16;
            goto L12
        }
    }

    /* JADX INFO: compiled from: AtomicActionScheduler.kt */
    @d.c.b.a.f(b = "AtomicActionScheduler.kt", c = {78}, d = "scheduleActionsInJob", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionScheduler")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f18131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f18132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f18133c;

        c(h r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18132b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18131a = r3;
            this.f18133c |= Integer.MIN_VALUE;
            return this.f18132b.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AtomicActionScheduler.kt */
    @d.c.b.a.f(b = "AtomicActionScheduler.kt", c = {121, 126, ApWakeEvent.ACCELERATING_END}, d = "scheduleCurrent", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionScheduler")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f18134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f18135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f18136c;

        d(h r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18135b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18134a = r3;
            this.f18136c |= Integer.MIN_VALUE;
            return h.a(this.f18135b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AtomicActionScheduler.kt */
    @d.c.b.a.f(b = "AtomicActionScheduler.kt", c = {145, 150}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionScheduler$scheduleNext$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.a.e f18139c;

        e(com.obric.aiagent.executionengine.scheduler.impl.a.e r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18139c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f18139c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18138b;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f18137a, Iterator.class, "com.obric.aiagent.plugin");
            o.a(r8);
        L26:
            if (r2.hasNext() == false) goto L31;
            com.obric.aiagent.executionengine.scheduler.impl.a.e r9 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
            h r3 = h.f18120a;
            this.f18137a = r2;
            this.f18138b = 2;
            if (h.a(r3, r9, this) != r0) goto L26;
            return r0;
        L31:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r8);
            goto L31
        L10:
            o.a(r8);
            List<com.obric.aiagent.executionengine.scheduler.impl.a.e> r10 = this.f18139c.j().c(this.f18139c);
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L13;
        L16:
            boolean r5 = true;
        L18:
            if (r5 == false) goto L24;
            int r11 = h.a().get();
            ISecureLogDepend.Companion.i(h.TAG, "scheduleNext: no outgoing-nodes for action=" + this.f18139c + "; current scheduled = " + r11);
            if (r11 != 0) goto L31;
            h r12 = h.f18120a;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18138b = 1;
            if (h.a(r12, r6) != r0) goto L31;
            return r0;
        L24:
            ILogDepend.Companion.d(h.TAG, "scheduleNext: scheduling outgoing nodes = " + r10);
            r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            goto L26
        L13:
            if (r4.isEmpty() == true) goto L16;
            r5 = false;
            goto L18
        }
    }

    private h() {
    }

    public static final /* synthetic */ Object a(h r2, com.obric.aiagent.executionengine.scheduler.impl.a.e r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(h r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicInteger a() {
        return f18122c;
    }

    public static final /* synthetic */ Object b(h r2, com.obric.aiagent.executionengine.scheduler.impl.a.e r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f18120a = new h();
        f18121b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        f18122c = new AtomicInteger(0);
    }

    private final String a(com.obric.aiagent.executionengine.scheduler.impl.a.e r2) {
        if (ZeusTransformUtils.instanceOf(r2, k.class) == true) goto L7;
        return null;
    L7:
        return ((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.aiagent.plugin")).a();
    }

    private final boolean b(com.obric.aiagent.executionengine.scheduler.impl.a.e r1) {
        if (a(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean c(com.obric.aiagent.executionengine.scheduler.impl.a.e r8) {
        if (f18121b.isEmpty() == false) goto L6;
        ILogDepend.Companion.d(TAG, "no pending leaves; this node shall be executed");
        return false;
    L6:
        List<com.obric.aiagent.executionengine.scheduler.impl.a.e> r7 = r8.j().b(r8);
        if (r7 != null) goto L9;
        return false;
    L9:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L15;
        Object r3 = r10.next();
        if (ZeusTransformUtils.instanceOf((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin"), k.class) == false) goto L11;
        r2.add(r3);
        goto L11
    L15:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L18;
    L20:
        Iterator r12 = r11.iterator();
    L22:
        if (r12.hasNext() == false) goto L19;
        com.obric.aiagent.executionengine.scheduler.impl.a.e r4 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        if (r4.g() != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18067d) goto L26;
    L29:
        boolean r5 = true;
    L30:
        if (r5 == true) goto L22;
        boolean r13 = false;
    L32:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L34:
        if (r15.hasNext() == false) goto L38;
        Object r16 = r15.next();
        if ((!ZeusTransformUtils.instanceOf((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin"), k.class)) == false) goto L34;
        r6.add(r16);
        goto L34
    L38:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L41;
    L43:
        Iterator r18 = r17.iterator();
    L45:
        if (r18.hasNext() == false) goto L42;
        if (((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin")).g() != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18064a) goto L49;
        boolean r19 = true;
    L50:
        if (r19 == true) goto L45;
        boolean r20 = false;
    L52:
        if (r13 == false) goto L76;
        if (r20 == true) goto L55;
        return false;
    L55:
        return true;
    L76:
        return false;
    L49:
        r19 = false;
    L42:
        r20 = true;
        goto L52
    L41:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L43;
    L26:
        if (r4.g() == com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18068e) goto L29;
        r5 = false;
    L19:
        r13 = true;
        goto L32
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L20;
        goto L19
    }

    public final Object a(com.obric.aiagent.executionengine.scheduler.impl.a.c<com.obric.aiagent.executionengine.scheduler.impl.a.e> r7, d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f18133c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18133c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f18131a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f18133c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r10);
    L32:
        return d.c.b.a.b.a(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        List<com.obric.aiagent.executionengine.scheduler.impl.a.e> r11 = r7.c();
        ISecureLogDepend.Companion.i(TAG, "scheduleActionsInJob actionLeavesList=" + r11);
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L17;
    L20:
        boolean r13 = true;
    L21:
        if (r13 == true) goto L23;
        List<com.obric.aiagent.executionengine.scheduler.impl.a.e> r14 = p.g((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin"));
        f18121b = r14;
        if (r14.isEmpty() == true) goto L27;
        r0.f18133c = 1;
        if (a(r0) != r2) goto L32;
        return r2;
    L27:
        return d.c.b.a.b.a(false);
    L23:
        return d.c.b.a.b.a(false);
    L17:
        if (r12.isEmpty() == true) goto L20;
        r13 = false;
    L7:
        r0 = new c(this, r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00cb -> B:22:0x00ce). Please report as a decompilation issue!!! */
    private final Object a(d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f18126d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.aiagent.executionengine.scheduler.impl.a.e r10 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r0.f18125c, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        d.a.h r4 = (d.a.h) ZeusTransformUtils.preCheckCast(r0.f18124b, d.a.h.class, "com.obric.aiagent.plugin");
        h r7 = (h) ZeusTransformUtils.preCheckCast(r0.f18123a, h.class, "com.obric.aiagent.plugin");
        o.a(r13);
        com.obric.aiagent.executionengine.scheduler.impl.a.e r14 = r10;
        h this = r7;
    L23:
        if (this.b(r14) == false) goto L26;
        ISecureLogDepend.Companion.i(TAG, "schedulePendingLeavesList; scheduled = " + r14 + "; noInterruptMode entered = " + this.a(r14));
    L28:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L31;
        f18121b = p.g((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
    L31:
        return x.f38692a;
    L26:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L28;
    L19:
        r14 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r4.b(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "schedulePendingLeavesList; scheduled = " + r14 + "; currentQueue = " + r4);
        r0.f18123a = this;
        r0.f18124b = r4;
        r0.f18125c = r14;
        r0.f = 1;
        if (this.a(r14, r0) != r2) goto L23;
        return r2;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        if (f18121b.isEmpty() == false) goto L18;
        ILogDepend.Companion.d(TAG, "schedulePendingLeavesList: pendingLeaves is empty.");
        return x.f38692a;
    L18:
        d.a.h r15 = new d.a.h((Collection) ZeusTransformUtils.preCheckCast(f18121b, Collection.class, "com.obric.aiagent.plugin"));
        f18121b.clear();
        r4 = r15;
    L7:
        r0 = new a(this, r12);
        goto L8
    }

    private final Object a(com.obric.aiagent.executionengine.scheduler.impl.a.e r9, d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin");
        if ((r0.f18136c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18136c -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f18134a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f18136c;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        o.a(r12);
    L43:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r12);
    L34:
        return x.f38692a;
    L17:
        o.a(r12);
    L25:
        d.c.b.a.b.a(f18122c.incrementAndGet());
    L46:
        return x.f38692a;
    L18:
        o.a(r12);
        if (r9.g() != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18064a) goto L27;
        if (d(r9) == false) goto L27;
        r9.a((com.obric.aiagent.executionengine.scheduler.impl.a.e.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.executionengine.scheduler.impl.a.e.b.class, "com.obric.aiagent.plugin"));
        ISecureLogDepend.Companion.i(TAG, "scheduleCurrent: schedule action=" + r9);
        r9.i();
        g r8 = g.f18111a;
        r0.f18136c = 1;
        if (r8.a(r9, r0) != r2) goto L25;
        return r2;
    L27:
        if (r9.g() != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18064a) goto L36;
        if (e(r9) == false) goto L36;
        ISecureLogDepend.Companion.i(TAG, "scheduleCurrent: abort action=" + r9);
        r9.h();
        r0.f18136c = 2;
        if (b(r9, r0) != r2) goto L34;
        return r2;
    L36:
        if (r9.g() == com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18064a) goto L38;
    L44:
        ILogDepend.Companion.d(TAG, "scheduleCurrent: maybe the dependencies are not finished; action=" + r9.e() + '.');
        goto L46
    L38:
        if (c(r9) == false) goto L44;
        ILogDepend.Companion.d(TAG, "scheduleCurrent: checking pendingLeaves; action=" + a(r9));
        r0.f18136c = 3;
        if (a(r0) != r2) goto L43;
        return r2;
    L7:
        r0 = new d(this, r11);
        goto L8
    }

    private final Object b(com.obric.aiagent.executionengine.scheduler.impl.a.e r8, d.c.d<? super ca> r9) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.c(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean d(com.obric.aiagent.executionengine.scheduler.impl.a.e r5) {
        List<com.obric.aiagent.executionengine.scheduler.impl.a.e> r4 = r5.j().b(r5);
        if (r4 == null) goto L24;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L7;
    L9:
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L26;
        if (((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin")).g() != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18067d) goto L15;
        boolean r0 = true;
    L16:
        if (r0 == true) goto L11;
        return false;
    L15:
        r0 = false;
        goto L16
    L26:
        return true;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        return true;
    L24:
        return true;
    }

    private final boolean e(com.obric.aiagent.executionengine.scheduler.impl.a.e r5) {
        List<com.obric.aiagent.executionengine.scheduler.impl.a.e> r4 = r5.j().b(r5);
        if (r4 == null) goto L24;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L7;
    L9:
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L26;
        if (((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin")).g() != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18068e) goto L15;
        boolean r0 = true;
    L16:
        if (r0 == false) goto L11;
        return true;
    L15:
        r0 = false;
        goto L16
    L26:
        return false;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        return false;
    L24:
        return false;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.a.e.b
    public void a(com.obric.aiagent.executionengine.scheduler.impl.a.e r7, com.obric.aiagent.executionengine.scheduler.impl.a.e.a r8) {
        d.h.b.o.e(r7, "action");
        d.h.b.o.e(r8, "newState");
        kotlinx.coroutines.i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.c(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r8, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
