package com.obric.aiagent.skill.ovirt.impl.d;

import android.os.SystemClock;
import com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener;
import com.obric.aiagent.skill.ovirt.impl.reporting.OVirtReporter;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.b.z;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0444a f21175a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f21176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashMap<String, OVirtLifecycleListener> f21177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile List<? extends OVirtLifecycleListener> f21178d;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    private static final class C0444a {
        public /* synthetic */ C0444a(d.h.b.h r1) {
            this();
        }

        private C0444a() {
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {120}, d = "afterShellReturn", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21183e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {121}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher$afterShellReturn$2$1")
    static final class c extends l implements d.h.a.b<d.c.d<? super n<? extends com.obric.aiagent.skill.ovirt.api.b.b.a>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OVirtLifecycleListener f21185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.aiagent.skill.ovirt.api.b.b.a> f21186c;

        c(OVirtLifecycleListener r3, z.f<com.obric.aiagent.skill.ovirt.api.b.b.a> r4, d.c.d<? super c> r5) {
            OVirtLifecycleListener r6 = (OVirtLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r3, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21185b = r6;
            this.f21186c = r4;
            super(1, r7);
        }

        public final Object a(d.c.d<? super n<com.obric.aiagent.skill.ovirt.api.b.b.a>> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f21185b, this.f21186c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super n<? extends com.obric.aiagent.skill.ovirt.api.b.b.a>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21184a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
            Object r5 = ((n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin")).a();
        L12:
            return n.g(r5);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            OVirtLifecycleListener r7 = this.f21185b;
            com.obric.aiagent.skill.ovirt.api.b.b.a r2 = (com.obric.aiagent.skill.ovirt.api.b.b.a) ZeusTransformUtils.preCheckCast(this.f21186c.f38504a, com.obric.aiagent.skill.ovirt.api.b.b.a.class, "com.obric.aiagent.plugin");
            d.c.d<? super n<com.obric.aiagent.skill.ovirt.api.b.b.a>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21184a = 1;
            r5 = r7.mo250afterShellReturngIAlus(r2, r3);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {97}, d = "beforeShellStart", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21191e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {98}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher$beforeShellStart$2$env$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super n<? extends Map<String, ? extends String>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OVirtLifecycleListener f21193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21194c;

        e(OVirtLifecycleListener r3, String r4, d.c.d<? super e> r5) {
            OVirtLifecycleListener r6 = (OVirtLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r3, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21193b = r6;
            this.f21194c = r4;
            super(1, r7);
        }

        public final Object a(d.c.d<? super n<? extends Map<String, String>>> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f21193b, this.f21194c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super n<? extends Map<String, ? extends String>>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21192a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
            Object r5 = ((n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin")).a();
        L12:
            return n.g(r5);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            OVirtLifecycleListener r7 = this.f21193b;
            String r2 = this.f21194c;
            d.c.d<? super n<? extends Map<String, String>>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21192a = 1;
            r5 = r7.mo251beforeShellStartgIAlus(r2, r3);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT}, d = "invokeListener-gIAlu-s", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher")
    static final class f<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f21195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f21196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21197c;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21196b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21195a = r3;
            this.f21197c |= Integer.MIN_VALUE;
            Object r2 = a.a(this.f21196b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {63}, d = "skillLoaded", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21201d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21202e;
        Object f;
        Object g;
        Object h;
        Object i;
        long j;
        int k;
        /* synthetic */ Object l;
        final /* synthetic */ a m;
        int n;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.m = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.l = r3;
            this.n |= Integer.MIN_VALUE;
            return this.m.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {64}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher$skillLoaded$2$1")
    static final class h extends l implements d.h.a.b<d.c.d<? super n<? extends x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OVirtLifecycleListener f21204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21206d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<String> f21207e;

        h(OVirtLifecycleListener r3, String r4, String r5, List<String> r6, d.c.d<? super h> r7) {
            OVirtLifecycleListener r8 = (OVirtLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r3, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21204b = r8;
            this.f21205c = r4;
            this.f21206d = r5;
            this.f21207e = r9;
            super(1, r10);
        }

        public final Object a(d.c.d<? super n<x>> r3) {
            return ((h) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r9) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f21204b, this.f21205c, this.f21206d, this.f21207e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super n<? extends x>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21203a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
            Object r7 = ((n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.aiagent.plugin")).a();
        L12:
            return n.g(r7);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            OVirtLifecycleListener r9 = this.f21204b;
            String r2 = this.f21205c;
            String r4 = this.f21206d;
            List<String> r5 = this.f21207e;
            d.c.d<? super n<x>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21203a = 1;
            r7 = r9.mo252onSkillLoadedBWLJW6A(r2, r4, r5, r3);
            if (r7 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {134}, d = "taskClosing", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21212e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        i(a r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirtLifecycleDispatcher.kt */
    @d.c.b.a.f(b = "OVirtLifecycleDispatcher.kt", c = {134}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.lifecycle.OVirtLifecycleDispatcher$taskClosing$2$1")
    static final class j extends l implements d.h.a.b<d.c.d<? super n<? extends x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OVirtLifecycleListener f21214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21215c;

        j(OVirtLifecycleListener r3, String r4, d.c.d<? super j> r5) {
            OVirtLifecycleListener r6 = (OVirtLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r3, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21214b = r6;
            this.f21215c = r4;
            super(1, r7);
        }

        public final Object a(d.c.d<? super n<x>> r3) {
            return ((j) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f21214b, this.f21215c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super n<? extends x>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21213a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
            Object r5 = ((n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin")).a();
        L12:
            return n.g(r5);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            OVirtLifecycleListener r7 = this.f21214b;
            String r2 = this.f21215c;
            d.c.d<? super n<x>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21213a = 1;
            r5 = r7.mo253onTaskClosinggIAlus(r2, r3);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    static {
        f21175a = new C0444a(null);
    }

    public a() {
        this.f21176b = new Object();
        this.f21177c = new LinkedHashMap();
        this.f21178d = p.b();
    }

    public static final /* synthetic */ Object a(a r2, d.h.a.b r3, d.c.d r4) {
        return r2.a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final void a(List<? extends OVirtLifecycleListener> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "candidates");
        Object r0 = this.f21176b;
        monitor-enter(r0);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L22
    L6:
        if (r12.hasNext() == false) goto L15;
        OVirtLifecycleListener r1 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r12.next(), OVirtLifecycleListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1.getId(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L9;
        OVirtLifecycleListener r2 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(this.f21177c.get(r1.getId()), OVirtLifecycleListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r2 == null) goto L12;
        if (r2 == r1) goto L6;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/TaskListener", "register: ignored duplicate listener id", "register: ignored duplicate listener id=" + r1.getId());     // Catch: Throwable -> L22
        goto L6
    L12:
        ((Map) ZeusTransformUtils.preCheckCast(this.f21177c, Map.class, "com.obric.aiagent.plugin")).put(r1.getId(), r1);     // Catch: Throwable -> L22
        goto L6
    L9:
        com.obric.aiagent.skill.ovirt.impl.b.a(com.obric.aiagent.skill.ovirt.impl.b.f21110a, "SkRt/TaskListener", "register: ignored listener with blank id", null, 4, null);     // Catch: Throwable -> L22
        goto L6
    L15:
        Collection<OVirtLifecycleListener> r13 = this.f21177c.values();     // Catch: Throwable -> L22
        d.h.b.o.c(r13, "<get-values>(...)");     // Catch: Throwable -> L22
        this.f21178d = p.o((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
        com.obric.aiagent.skill.ovirt.impl.b r14 = com.obric.aiagent.skill.ovirt.impl.b.f21110a;     // Catch: Throwable -> L22
        String r3 = "register: listenerCount=" + this.f21178d.size();     // Catch: Throwable -> L22
        StringBuilder r4 = new StringBuilder().append("register: listeners=");     // Catch: Throwable -> L22
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f21178d, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        Iterator r15 = r9.iterator();     // Catch: Throwable -> L22
    L17:
        if (r15.hasNext() == false) goto L19;
        r5.add(((OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r15.next(), OVirtLifecycleListener.class, "com.obric.aiagent.plugin")).getId());     // Catch: Throwable -> L22
        goto L17
    L19:
        r14.a("SkRt/TaskListener", r3, r4.append((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin")).toString());     // Catch: Throwable -> L22
        x r16 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0186 -> B:149:0x018c). Please report as a decompilation issue!!! */
    public final Object a(String r32, String r33, List<String> r34, d.c.d<? super x> r35) {
        a r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L7;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin");
        if ((r4.n & Integer.MIN_VALUE) == 0) goto L7;
        r4.n -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.l;
        Object r6 = d.c.a.b.a();
        int r7 = r4.n;
        if (r7 == 0) goto L22;
        if (r7 != 1) goto L21;
        int r2 = r4.k;
        long r11 = r4.j;
        OVirtLifecycleListener r8 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r4.i, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
        Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(r4.h, Iterator.class, "com.obric.aiagent.plugin");
        z.d r13 = (z.d) ZeusTransformUtils.preCheckCast(r4.g, z.d.class, "com.obric.aiagent.plugin");
        z.d r14 = (z.d) ZeusTransformUtils.preCheckCast(r4.f, z.d.class, "com.obric.aiagent.plugin");
        List<? extends OVirtLifecycleListener> r10 = (List) ZeusTransformUtils.preCheckCast(r4.f21202e, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(r4.f21201d, List.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r4.f21200c, String.class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r4.f21199b, String.class, "com.obric.aiagent.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r4.f21198a, a.class, "com.obric.aiagent.plugin");
        o.a(r5);     // Catch: Throwable -> L14 Error -> L16 CancellationException -> L18
        Object r17 = ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L14 Error -> L16 CancellationException -> L18
        List<? extends OVirtLifecycleListener> r18 = r10;
        List r19 = r12;
        OVirtLifecycleListener r20 = r8;
        g r27 = r4;
        int r21 = r2;
        g r110 = r27;
        String r111 = r15;
        long r22 = r11;
        Object r112 = r6;
        z.d r23 = r14;
        Iterator r113 = r9;
        z.d r24 = r13;
    L149:
        Throwable r114 = n.c(r17);     // Catch: Throwable -> L48 Error -> L50 CancellationException -> L52
        if (r114 != null) goto L46;
        x r25 = (x) ZeusTransformUtils.preCheckCast(r17, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48 Error -> L50 CancellationException -> L52
        r23.f38502a++;     // Catch: Throwable -> L48 Error -> L50 CancellationException -> L52
    L47:
        String r26 = r16;
        int r115 = r21;
    L147:
    L97:
        e = e;
        z.d r28 = r23;
        z.d r29 = r24;
    L99:
        r14 = r28;
        r13 = r29;
    L137:
        int r30 = 1;
        r13.f38502a++;     // Catch: Throwable -> L114
        throw e;     // Catch: Throwable -> L114
    L114:
        th = th;
    L118:
        String r116 = r26;
    L125:
        r1 = r19;
        String r117 = r111;
        r10 = r18;
    L126:
        r11 = r22;
    L127:
        OVirtReporter.a r118 = OVirtReporter.Companion;
        int r119 = r1.size();
        long r210 = d.l.n.a(SystemClock.elapsedRealtime() - r11, 0);
        int r211 = r10.size();
        int r31 = r14.f38502a;
        int r36 = r13.f38502a;
        if (r115 == 0) goto L130;
        boolean r212 = r30;
    L131:
        r118.a(r116, r117, r119, r210, r211, r31, r36, r212);
        throw th;
    L130:
        r212 = 0;
    L116:
        th = th;
        r30 = 1;
    L100:
        e = e;
        r28 = r23;
        r29 = r24;
    L102:
        r14 = r28;
        r13 = r29;
    L103:
        r30 = 1;
    L139:
        throw e;     // Catch: Throwable -> L123
    L123:
        th = th;
        r116 = r26;
        r115 = r30;
    L94:
        th = th;
        r28 = r23;
        r29 = r24;
    L96:
        r116 = r26;
        r14 = r28;
        r13 = r29;
        r1 = r19;
        r117 = r111;
        r10 = r18;
        r30 = 1;
        goto L126
    L27:
        if (r113.hasNext() == false) goto L88;
        OVirtLifecycleListener r37 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r113.next(), OVirtLifecycleListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L94 Error -> L97 CancellationException -> L100
        z.d r120 = r23;
        z.d r121 = r24;
        long r122 = r22;
        d.h.a.b r38 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new h(r37, r26, r111, r19, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L76 Error -> L80 CancellationException -> L84
        r110.f21198a = r0;     // Catch: Throwable -> L76 Error -> L80 CancellationException -> L84
        r110.f21199b = r26;     // Catch: Throwable -> L76 Error -> L80 CancellationException -> L84
        r110.f21200c = r111;     // Catch: Throwable -> L76 Error -> L80 CancellationException -> L84
        r110.f21201d = r19;     // Catch: Throwable -> L76 Error -> L80 CancellationException -> L84
        r110.f21202e = r18;     // Catch: Throwable -> L76 Error -> L80 CancellationException -> L84
        r28 = r120;
        r110.f = r28;     // Catch: Throwable -> L70 Error -> L72 CancellationException -> L74
        r29 = r121;
        r110.g = r29;     // Catch: Throwable -> L64 Error -> L66 CancellationException -> L68
        r110.h = r113;     // Catch: Throwable -> L64 Error -> L66 CancellationException -> L68
        r110.i = r37;     // Catch: Throwable -> L64 Error -> L66 CancellationException -> L68
        r22 = r122;
        r110.j = r22;     // Catch: Throwable -> L58 Error -> L60 CancellationException -> L62
        r110.k = r115;     // Catch: Throwable -> L58 Error -> L60 CancellationException -> L62
        r110.n = 1;     // Catch: Throwable -> L54 CancellationException -> L56 Error -> L60
        r17 = r0.a(r38, r110);     // Catch: Throwable -> L58 Error -> L60 CancellationException -> L62
        if (r17 != r112) goto L42;
        return r112;
    L42:
        r24 = r29;
        r23 = r28;
        r21 = r115;
        r16 = r26;
        r20 = r37;
        goto L149
    L56:
        e = e;
        r14 = r28;
        r13 = r29;
        r30 = 1;
    L54:
        th = th;
        r116 = r26;
        r14 = r28;
        r13 = r29;
        r30 = 1;
    L60:
        e = e;
    L62:
        e = e;
    L58:
        th = th;
        goto L96
    L66:
        e = e;
    L83:
        r22 = r122;
    L68:
        e = e;
    L87:
        r22 = r122;
    L64:
        th = th;
    L79:
        r22 = r122;
        goto L96
    L72:
        e = e;
    L82:
        r29 = r121;
    L74:
        e = e;
    L86:
        r29 = r121;
    L70:
        th = th;
    L78:
        r29 = r121;
        goto L79
    L80:
        e = e;
        r28 = r120;
    L84:
        e = e;
        r28 = r120;
    L76:
        th = th;
        r28 = r120;
        goto L78
    L88:
        z.d r39 = r23;
        z.d r40 = r24;
        OVirtReporter.a r41 = OVirtReporter.Companion;
        int r42 = r19.size();
        long r43 = d.l.n.a(SystemClock.elapsedRealtime() - r22, 0);
        int r44 = r18.size();
        int r45 = r39.f38502a;
        int r123 = r40.f38502a;
        if (r115 == 0) goto L91;
        boolean r46 = true;
    L92:
        r41.a(r26, r111, r42, r43, r44, r45, r123, r46);
        return x.f38692a;
    L91:
        r46 = false;
        goto L92
    L46:
        r24.f38502a++;     // Catch: Throwable -> L48 Error -> L50 CancellationException -> L52
        a(r0, "onSkillLoaded", r20.getId(), r114, null, 8, null);     // Catch: Throwable -> L48 Error -> L50 CancellationException -> L52
        goto L47
    L50:
        e = e;
        r14 = r23;
        r13 = r24;
        r26 = r16;
        r115 = r21;
    L52:
        e = e;
        r14 = r23;
        r13 = r24;
        r26 = r16;
    L48:
        th = th;
        r14 = r23;
        r13 = r24;
        r1 = r19;
        r116 = r16;
        r117 = r111;
        r10 = r18;
        r30 = 1;
        r115 = r21;
        goto L126
    L16:
        e = e;
        r18 = r10;
        r19 = r12;
        r115 = r2;
        r26 = r16;
        r111 = r15;
        r22 = r11;
    L18:
        e = e;
        r18 = r10;
        r26 = r16;
        r30 = 1;
        r19 = r12;
        r111 = r15;
        r22 = r11;
    L14:
        th = th;
        r117 = r15;
        r116 = r16;
        r30 = 1;
        r115 = r2;
        r1 = r12;
        goto L127
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        o.a(r5);
        r11 = SystemClock.elapsedRealtime();
        r10 = r0.f21178d;
        r14 = new z.d();
        r13 = new z.d();
        Iterator r47 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: CancellationException -> L104 Throwable -> L106 Error -> L108
        r18 = r10;
        r22 = r11;
        r24 = r13;
        r115 = 0;
        r111 = r33;
        r19 = r1;
        r110 = r4;
        r112 = r6;
        r23 = r14;
        r26 = r32;
        r113 = r47;
        goto L147
    L108:
        e = e;
        r18 = r10;
        r22 = r11;
        r115 = 0;
        r111 = r33;
        r19 = r1;
        r26 = r32;
    L104:
        e = e;
        r18 = r10;
        r22 = r11;
        r30 = 1;
        r111 = r33;
        r19 = r1;
        r26 = r32;
    L106:
        th = th;
        r116 = r32;
        r117 = r33;
        r30 = 1;
        r115 = 0;
    L7:
        r4 = new g(r0, r3);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00dd -> B:21:0x00e6). Please report as a decompilation issue!!! */
    public final Object a(String r19, d.c.d<? super Map<String, String>> r20) {
        a r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        Object r4 = d.c.a.b.a();
        int r5 = r3.h;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        OVirtLifecycleListener r6 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r3.f21191e, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
        Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f21190d, Iterator.class, "com.obric.aiagent.plugin");
        LinkedHashMap r8 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r3.f21189c, LinkedHashMap.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.f21188b, String.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r3.f21187a, a.class, "com.obric.aiagent.plugin");
        o.a(r2);
        Object r11 = ((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")).a();
        OVirtLifecycleListener r12 = r6;
        r0 = r10;
        LinkedHashMap r13 = r8;
        Iterator r14 = r7;
        Object r15 = r4;
        d r16 = r3;
        String r17 = r9;
    L21:
        Throwable r18 = n.c(r11);
        if (r18 != null) goto L26;
        Map r21 = (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin");
        if ((!r21.isEmpty()) == false) goto L27;
        r13.putAll(r21);
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/TaskListener", "beforeShellStart: env ready keyCount=" + r21.size(), "beforeShellStart: env ready listener=" + r12.getId() + " keys=" + r21.keySet());
    L27:
        String r22 = r17;
        r3 = r16;
        r4 = r15;
        Iterator r23 = r14;
        LinkedHashMap r24 = r13;
    L16:
        if (r23.hasNext() == false) goto L28;
        r12 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r23.next(), OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
        d.h.a.b r25 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r12, r22, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.f21187a = r0;
        r3.f21188b = r22;
        r3.f21189c = r24;
        r3.f21190d = r23;
        r3.f21191e = r12;
        r3.h = 1;
        Object r26 = r0.a(r25, r3);
        if (r26 != r4) goto L20;
        return r4;
    L20:
        d r110 = r3;
        r17 = r22;
        r11 = r26;
        r13 = r24;
        r14 = r23;
        r15 = r4;
        r16 = r110;
        goto L21
    L28:
        return r24;
    L26:
        a(r0, "beforeShellStart", r12.getId(), r18, null, 8, null);
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        LinkedHashMap r27 = new LinkedHashMap();
        r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.f21178d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r24 = r27;
        r22 = r19;
    L7:
        r3 = new d(r0, r1);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00db -> B:21:0x00e2). Please report as a decompilation issue!!! */
    public final Object a(com.obric.aiagent.skill.ovirt.api.b.b.a r16, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r17) {
        a r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        Object r4 = d.c.a.b.a();
        int r5 = r3.h;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        z.f r6 = (z.f) ZeusTransformUtils.preCheckCast(r3.f21183e, z.f.class, "com.obric.aiagent.plugin");
        OVirtLifecycleListener r7 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r3.f21182d, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
        Iterator r8 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f21181c, Iterator.class, "com.obric.aiagent.plugin");
        z.f r9 = (z.f) ZeusTransformUtils.preCheckCast(r3.f21180b, z.f.class, "com.obric.aiagent.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(r3.f21179a, a.class, "com.obric.aiagent.plugin");
        o.a(r2);
        Iterator r14 = r8;
        OVirtLifecycleListener r11 = r7;
        Object r12 = r4;
        b r13 = r3;
        z.f r15 = r9;
        Object r18 = ((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")).a();
        a r19 = r10;
    L21:
        Throwable r110 = n.c(r18);
        T r20 = r18;
        if (r110 == null) goto L25;
        a(r19, "afterShellReturn", r11.getId(), r110, null, 8, null);
        r20 = (com.obric.aiagent.skill.ovirt.api.b.b.a) ZeusTransformUtils.preCheckCast(r15.f38504a, com.obric.aiagent.skill.ovirt.api.b.b.a.class, "com.obric.aiagent.plugin");
    L25:
        r6.f38504a = r20;
        r0 = r19;
        z.f r21 = r15;
        r3 = r13;
        r4 = r12;
        Iterator r22 = r14;
    L16:
        if (r22.hasNext() == false) goto L27;
        OVirtLifecycleListener r23 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r22.next(), OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
        d.h.a.b r24 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r23, r21, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.f21179a = r0;
        r3.f21180b = r21;
        r3.f21181c = r22;
        r3.f21182d = r23;
        r3.f21183e = r21;
        r3.h = 1;
        Object r25 = r0.a(r24, r3);
        if (r25 != r4) goto L20;
        return r4;
    L20:
        r14 = r22;
        r11 = r23;
        r12 = r4;
        r13 = r3;
        r15 = r21;
        r19 = r0;
        r6 = r15;
        r18 = r25;
        goto L21
    L27:
        return r21.f38504a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        r21 = new z.f();
        r21.f38504a = r16;
        r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.f21178d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        r3 = new b(this, r1);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d9 -> B:21:0x00df). Please report as a decompilation issue!!! */
    public final Object b(String r11, d.c.d<? super Boolean> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r13, i.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f;
        Object r2 = d.c.a.b.a();
        int r3 = r0.h;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        OVirtLifecycleListener r10 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r0.f21212e, OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
        Iterator r15 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f21211d, Iterator.class, "com.obric.aiagent.plugin");
        z.a r4 = (z.a) ZeusTransformUtils.preCheckCast(r0.f21210c, z.a.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r0.f21209b, String.class, "com.obric.aiagent.plugin");
        a r6 = (a) ZeusTransformUtils.preCheckCast(r0.f21208a, a.class, "com.obric.aiagent.plugin");
        o.a(r14);
        Object r16 = ((n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin")).a();
        OVirtLifecycleListener r7 = r10;
        a this = r6;
        z.a r8 = r4;
        Object r9 = r2;
        i r17 = r0;
        String r1 = r5;
    L21:
        Throwable r18 = n.c(r16);
        if (r18 != null) goto L24;
        x r19 = (x) ZeusTransformUtils.preCheckCast(r16, x.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/TaskListener", "purge: provider cleaned", "purge: provider cleaned uniqueId=" + r1 + " provider=" + r7.getId());
    L25:
        String r110 = r1;
        r0 = r17;
        r2 = r9;
        z.a r20 = r8;
    L16:
        if (r15.hasNext() == false) goto L27;
        r7 = (OVirtLifecycleListener) ZeusTransformUtils.preCheckCast(r15.next(), OVirtLifecycleListener.class, "com.obric.aiagent.plugin");
        d.h.a.b r21 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new j(r7, r110, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r0.f21208a = this;
        r0.f21209b = r110;
        r0.f21210c = r20;
        r0.f21211d = r15;
        r0.f21212e = r7;
        r0.h = 1;
        Object r22 = this.a(r21, r0);
        if (r22 != r2) goto L20;
        return r2;
    L20:
        i r23 = r0;
        r1 = r110;
        r16 = r22;
        r8 = r20;
        r9 = r2;
        r17 = r23;
        goto L21
    L27:
        return d.c.b.a.b.a(r20.f38499a);
    L24:
        r8.f38499a = false;
        this.a("onTaskClosing", r7.getId(), r18, r1);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r14);
        z.a r111 = new z.a();
        r111.f38499a = true;
        r110 = r11;
        r15 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f21178d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r20 = r111;
    L7:
        r0 = new i(this, r13);
        goto L8
    }

    private final <T> Object a(d.h.a.b<? super d.c.d<? super n<? extends T>>, ? extends Object> r5, d.c.d<? super n<? extends T>> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");
        if ((r0.f21197c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21197c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f21195a;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f21197c;
        if (r2 == 0) goto L19;
        if (r2 != 1) goto L18;
        o.a(r4);     // Catch: Exception -> L13 CancellationException -> L15
    L23:
        Throwable r10 = n.c(((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L13 CancellationException -> L15
        if (ZeusTransformUtils.instanceOf(r10, CancellationException.class) == false) goto L26;
        throw r10;     // Catch: Exception -> L13 CancellationException -> L15
    L26:
        if (ZeusTransformUtils.instanceOf(r10, Error.class) == false) goto L34;
        throw r10;     // Catch: Exception -> L13 CancellationException -> L15
    L34:
        return ((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin")).a();
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        o.a(r4);
        r0.f21197c = 1;     // Catch: Exception -> L13 CancellationException -> L15
        r4 = r7.invoke(r0);     // Catch: Exception -> L13 CancellationException -> L15
        if (r4 != r9) goto L23;
        return r9;
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        n.a r11 = n.f38560a;
        return n.f(o.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
    L7:
        r0 = new f(this, r8);
        goto L8
    }

    static /* synthetic */ void a(a r0, String r1, String r2, Throwable r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    private final void a(String r4, String r5, Throwable r6, String r7) {
        com.obric.aiagent.skill.ovirt.impl.b r3 = com.obric.aiagent.skill.ovirt.impl.b.f21110a;
        String r0 = r4 + ": listener failed";
        StringBuilder r2 = new StringBuilder();
        r2.append(r4).append(": listener failed");
        if (r7 == null) goto L5;
        r2.append(" uniqueId=").append(r7);
    L5:
        r2.append(" listener=").append(r5);
        x r8 = x.f38692a;
        String r9 = r2.toString();
        d.h.b.o.c(r9, "toString(...)");
        r3.a("SkRt/TaskListener", r0, r9, r6);
    }
}
