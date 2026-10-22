package com.obric.aiagent.skill.ovirt.impl;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.api.aa;
import com.obric.aiagent.skill.manager.api.ac;
import com.obric.aiagent.skill.manager.api.ad;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.manager.api.u;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener;
import com.obric.aiagent.skill.ovirt.impl.reporting.OVirtReporter;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.v;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.bduploader.BDAbstractUpload;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.z;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.co;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: OVirt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OVirt implements IOVirtService, IOVirtService.e {
    private volatile com.obric.aiagent.skill.ovirt.impl.h.a active;
    private final AtomicBoolean exclusiveExecutionRequested;
    private final IOVirtService.b files;
    private final com.obric.aiagent.skill.ovirt.impl.d.a lifecycleDispatcher;
    private volatile b lifecyclePhase;
    private final IOVirtService.c maintenance;
    private final kotlinx.coroutines.f.a mutex;
    private final IOVirtService.d shell;
    private final com.obric.aiagent.skill.ovirt.impl.g.e shellCapability;
    private final IVirtService virt;

    /* JADX INFO: compiled from: OVirt.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f21011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f21012b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f21011a == r6.f21011a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21012b, r6.f21012b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f21011a) * 31) + this.f21012b.hashCode();
        }

        public String toString() {
            return "CleanupReport(success=" + this.f21011a + ", failedTaskIds=" + this.f21012b + ')';
        }

        public a(boolean r3, List<String> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "failedTaskIds");
            this.f21011a = r3;
            this.f21012b = r5;
        }

        public final boolean a() {
            return this.f21011a;
        }

        public /* synthetic */ a(boolean r2, List r3, int r4, d.h.b.h r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = d.a.p.b();
        L5:
            this(r2, r6);
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21013a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f21014b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f21015c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f21016d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f21017e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f21013a, f21014b, f21015c, f21016d};
        }

        static {
            f21013a = new b("IDLE", 0);
            f21014b = new b("OPENING", 1);
            f21015c = new b("ACTIVE", 2);
            f21016d = new b("CLOSING", 3);
            b[] r0 = a();
            f21017e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f21017e.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {383, 390, 392}, d = "access$impl_release", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class c<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21021d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f21022e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ OVirt h;
        int i;

        c(OVirt r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.g = r7;
            this.i |= Integer.MIN_VALUE;
            return this.h.access$impl_release(null, false, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {390}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$access$3")
    static final class d<T> extends d.c.b.a.l implements d.h.a.b<d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<com.obric.aiagent.skill.ovirt.impl.h.a, d.c.d<? super T>, Object> f21024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21025c;

        d(d.h.a.m<? super com.obric.aiagent.skill.ovirt.impl.h.a, ? super d.c.d<? super T>, ? extends Object> r3, com.obric.aiagent.skill.ovirt.impl.h.a r4, d.c.d<? super d> r5) {
            d.h.a.m<com.obric.aiagent.skill.ovirt.impl.h.a, d.c.d<? super T>, Object> r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21024b = r6;
            this.f21025c = r4;
            super(1, r7);
        }

        public final Object a(d.c.d<? super T> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f21024b, this.f21025c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(Object r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21023a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r4);
            d.h.a.m<com.obric.aiagent.skill.ovirt.impl.h.a, d.c.d<? super T>, Object> r5 = this.f21024b;
            com.obric.aiagent.skill.ovirt.impl.h.a r2 = this.f21025c;
            this.f21023a = 1;
            r4 = r5.invoke(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {532}, d = "cancelAllAndReconcile", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OVirt f21029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21030e;

        e(OVirt r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21029d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21028c = r3;
            this.f21030e |= Integer.MIN_VALUE;
            return OVirt.access$cancelAllAndReconcile(this.f21029d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {533}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$cancelAllAndReconcile$reconciled$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<com.obric.aiagent.skill.ovirt.impl.g.a> f21032b;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.OVirt$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: OVirt.kt */
        @d.c.b.a.f(b = "OVirt.kt", c = {534}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$cancelAllAndReconcile$reconciled$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends x>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21033a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ List<com.obric.aiagent.skill.ovirt.impl.g.a> f21034b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private /* synthetic */ Object f21035c;

            /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.OVirt$f$1$a */
            /* JADX INFO: compiled from: OVirt.kt */
            @d.c.b.a.f(b = "OVirt.kt", c = {534}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$cancelAllAndReconcile$reconciled$1$1$1$1")
            static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f21036a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.g.a f21037b;

                a(com.obric.aiagent.skill.ovirt.impl.g.a r3, d.c.d<? super a> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f21037b = r3;
                    super(2, r5);
                }

                public final Object a(am r3, d.c.d<? super x> r4) {
                    return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f21037b, r4), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r5) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f21036a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    d.o.a(r5);
                L12:
                    return x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    d.o.a(r5);
                    com.obric.aiagent.skill.ovirt.impl.g.a r6 = this.f21037b;
                    d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f21036a = 1;
                    if (r6.b(r2) != r0) goto L12;
                    return r0;
                }
            }

            AnonymousClass1(List<com.obric.aiagent.skill.ovirt.impl.g.a> r3, d.c.d<? super AnonymousClass1> r4) {
                List<com.obric.aiagent.skill.ovirt.impl.g.a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21034b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super List<x>> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f21034b, r5);
                r0.f21035c = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends x>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21033a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r12);
            L15:
                return r12;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r12);
                am r13 = (am) ZeusTransformUtils.preCheckCast(this.f21035c, am.class, "com.obric.aiagent.plugin");
                Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f21034b, Iterable.class, "com.obric.aiagent.plugin");
                Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r3 = r2.iterator();
            L10:
                if (r3.hasNext() == false) goto L12;
                r10.add(kotlinx.coroutines.i.b(r13, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a((com.obric.aiagent.skill.ovirt.impl.g.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.aiagent.skill.ovirt.impl.g.a.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null));
                goto L10
            L12:
                Collection r14 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
                d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21033a = 1;
                r12 = kotlinx.coroutines.f.a(r14, r4);
                if (r12 != r0) goto L15;
                return r0;
            }
        }

        f(List<com.obric.aiagent.skill.ovirt.impl.g.a> r3, d.c.d<? super f> r4) {
            List<com.obric.aiagent.skill.ovirt.impl.g.a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21032b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f21032b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21031a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.c.b.a.b.a(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f21032b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21031a = 1;
            if (an.a(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {554}, d = "cleanStaleRuntimeShellOutputs", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OVirt f21040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21041d;

        g(OVirt r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21040c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21039b = r3;
            this.f21041d |= Integer.MIN_VALUE;
            return OVirt.access$cleanStaleRuntimeShellOutputs(this.f21040c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {676, 189}, d = "cleanupIfOwned", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21045d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OVirt f21046e;
        int f;

        h(OVirt r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21046e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21045d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f21046e.cleanupIfOwned(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {BDAbstractUpload.KeyIsXQuicLibAvailable}, d = "closeLocked", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OVirt f21049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21050d;

        i(OVirt r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21049c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21048b = r3;
            this.f21050d |= Integer.MIN_VALUE;
            return OVirt.access$closeLocked(this.f21049c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {459, 460, 462, 468, 474, 480, 500, 500, 500, 500}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$closeTask$2")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OVirt f21055e;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.OVirt$j$1, reason: invalid class name */
        /* JADX INFO: compiled from: OVirt.kt */
        @d.c.b.a.f(b = "OVirt.kt", c = {463}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$closeTask$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21056a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21057b;

            AnonymousClass1(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21057b = r3;
                super(1, r5);
            }

            public final Object a(d.c.d<? super Boolean> r3) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f21057b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21056a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r7);
            L11:
                return r7;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r7);
                com.obric.aiagent.skill.ovirt.impl.a.a r8 = this.f21057b.j();
                String r2 = this.f21057b.a();
                y r3 = this.f21057b.d();
                d.c.d<? super Boolean> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21056a = 1;
                r7 = r8.b(r2, r3, r4);
                if (r7 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.OVirt$j$2, reason: invalid class name */
        /* JADX INFO: compiled from: OVirt.kt */
        @d.c.b.a.f(b = "OVirt.kt", c = {469}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$closeTask$2$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21058a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21059b;

            AnonymousClass2(com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d<? super AnonymousClass2> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21059b = r3;
                super(1, r5);
            }

            public final Object a(d.c.d<? super Boolean> r3) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f21059b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21058a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r7);
            L11:
                return r7;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r7);
                com.obric.aiagent.skill.ovirt.impl.a.a r8 = this.f21059b.j();
                String r2 = this.f21059b.a();
                y r3 = this.f21059b.d();
                d.c.d<? super Boolean> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21058a = 1;
                r7 = r8.a(r2, r3, r4);
                if (r7 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.OVirt$j$3, reason: invalid class name */
        /* JADX INFO: compiled from: OVirt.kt */
        @d.c.b.a.f(b = "OVirt.kt", c = {475}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$closeTask$2$3")
        static final class AnonymousClass3 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21060a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OVirt f21061b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21062c;

            AnonymousClass3(OVirt r3, com.obric.aiagent.skill.ovirt.impl.h.a r4, d.c.d<? super AnonymousClass3> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21061b = r3;
                this.f21062c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super Boolean> r3) {
                return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass3.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f21061b, this.f21062c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21060a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                com.obric.aiagent.skill.ovirt.impl.d.a r7 = this.f21061b.getLifecycleDispatcher$impl_release();
                String r2 = this.f21062c.a();
                d.c.d<? super Boolean> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21060a = 1;
                r6 = r7.b(r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.OVirt$j$4, reason: invalid class name */
        /* JADX INFO: compiled from: OVirt.kt */
        @d.c.b.a.f(b = "OVirt.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$closeTask$2$4")
        static final class AnonymousClass4 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21063a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OVirt f21064b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21065c;

            AnonymousClass4(OVirt r3, com.obric.aiagent.skill.ovirt.impl.h.a r4, d.c.d<? super AnonymousClass4> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f21064b = r3;
                this.f21065c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super Boolean> r3) {
                return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass4.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.f21064b, this.f21065c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f21063a != 0) goto L7;
                d.o.a(r2);
                return d.c.b.a.b.a(this.f21064b.getVirt$impl_release().getShell().b(this.f21065c.a()));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        j(com.obric.aiagent.skill.ovirt.impl.h.a r3, OVirt r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21054d = r3;
            this.f21055e = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super a> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f21054d, this.f21055e, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v35 */
        /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v43 */
        /* JADX WARN: Type inference failed for: r3v28 */
        /* JADX WARN: Type inference failed for: r3v29 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r2 = "purge_pipeline";
            Object r3 = d.c.a.b.a();
            switch(this.f21053c) {
                case 0: goto L70;
                case 1: goto L60;
                case 2: goto L57;
                case 3: goto L54;
                case 4: goto L45;
                case 5: goto L35;
                case 6: goto L26;
                case 7: goto L21;
                case 8: goto L16;
                case 9: goto L11;
                case 10: goto L6;
                default: goto L5;
            };
        L6:
            Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(this.f21052b, Throwable.class, "com.obric.aiagent.plugin");
            Object r5 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Exception -> L9
            throw r4;
        L9:
            e = e;
        L138:
            ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add("virt_close_failed");
            com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("OVirt/Service", "virt_close_failed", "close: Virt close failed uniqueId=" + this.f21054d.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            throw r4;
        L11:
            r2 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Exception -> L14
        L162:
        L117:
            ?? r0 = r2;
            CancellationException r6 = null;
        L148:
            if (r6 == null) goto L150;
            throw r6;
        L150:
            if (r0.isEmpty() == false) goto L153;
            com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("OVirt/Service", "close: completed", "close: closed uniqueId=" + this.f21054d.a());
            return new a(true, null, 2, 0 == true ? 1 : 0);
        L153:
            return new a(false, d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")));
        L16:
            r2 = (List) ZeusTransformUtils.preCheckCast(this.f21052b, List.class, "com.obric.aiagent.plugin");
            CancellationException r7 = (CancellationException) ZeusTransformUtils.preCheckCast(this.f21051a, CancellationException.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Exception -> L19
        L147:
            r0 = r2;
            r6 = r7;
        L19:
            e = e;
        L146:
            ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add("virt_close_failed");
            com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("OVirt/Service", "virt_close_failed", "close: Virt close failed uniqueId=" + this.f21054d.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L147
        L21:
            r2 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Exception -> L24
        L170:
            goto L117
        L26:
            List r8 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L29 Exception -> L31 CancellationException -> L33
            Object r1 = r18;
            String r16 = "purge_pipeline";
            r2 = r8;
        L176:
        L120:
            e = move-exception;
            CancellationException r9 = e;
        L155:
            IVirtService.c r10 = this.f21055e.getVirt$impl_release().getLifecycle();     // Catch: Exception -> L144
            d.c.d<? super x> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L144
            this.f21051a = r9;     // Catch: Exception -> L144
            this.f21052b = r2;     // Catch: Exception -> L144
            this.f21053c = 8;     // Catch: Exception -> L144
            if (r10.close(r11) != r3) goto L143;
            return r3;
        L143:
            r7 = r9;
        L144:
            e = e;
            r7 = r9;
        L118:
            e = e;
        L126:
            String r12 = r16;
            com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("OVirt/Service", r12, "close: failed uniqueId=" + this.f21054d.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L131
            ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add(r12);     // Catch: Throwable -> L131
            IVirtService.c r13 = this.f21055e.getVirt$impl_release().getLifecycle();     // Catch: Exception -> L14
            d.c.d<? super x> r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
            this.f21051a = r2;     // Catch: Exception -> L14
            this.f21053c = 9;     // Catch: Exception -> L14
            if (r13.close(r14) != r3) goto L162;
            return r3;
        L107:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L110;
            ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add("discard-shell-executions");     // Catch: Exception -> L118 CancellationException -> L120 Throwable -> L131
        L110:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L112;
            com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("OVirt/Service", "close: cleanup incomplete", "close: partial uniqueId=" + this.f21054d.a() + " failures=" + r2);     // Catch: Exception -> L118 CancellationException -> L120 Throwable -> L131
        L112:
            IVirtService.c r15 = this.f21055e.getVirt$impl_release().getLifecycle();     // Catch: Exception -> L24
            d.c.d<? super x> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
            this.f21051a = r2;     // Catch: Exception -> L24
            this.f21053c = 7;     // Catch: Exception -> L24
            if (r15.close(r17) != r3) goto L170;
            return r3;
        L33:
            e = move-exception;
            r9 = e;
            r2 = r8;
        L31:
            e = e;
            r16 = "purge_pipeline";
            r2 = r8;
        L29:
            th = move-exception;
            r4 = th;
            Object r19 = r8;
        L166:
            IVirtService.c r20 = this.f21055e.getVirt$impl_release().getLifecycle();     // Catch: Exception -> L136
            d.c.d<? super x> r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L136
            this.f21051a = r19;     // Catch: Exception -> L136
            this.f21052b = r4;     // Catch: Exception -> L136
            this.f21053c = 10;     // Catch: Exception -> L136
            if (r20.close(r21) != r3) goto L180;
            return r3;
        L180:
            throw r4;
        L136:
            e = e;
            r5 = r19;
            goto L138
        L35:
            Object r22 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L38 Exception -> L40 CancellationException -> L43
            Object r23 = r18;
            r16 = "purge_pipeline";
        L160:
        L122:
            e = e;
        L42:
            r2 = r22;
            goto L126
        L100:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r23, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L102;
            ((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.aiagent.plugin")).add("dynamic-providers");     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
        L102:
            OVirt r24 = this.f21055e;     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
            String r25 = this.f21054d.a();     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
            d.h.a.b r26 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.f21055e, this.f21054d, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
            d.c.d r27 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
            this.f21051a = r22;     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
            this.f21053c = 6;     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
            r1 = OVirt.access$runCleanupStep(r24, r25, "discard-shell-executions", r26, r27);     // Catch: Throwable -> L38 CancellationException -> L43 Exception -> L122
            if (r1 != r3) goto L105;
            return r3;
        L105:
            r2 = r22;
            goto L176
        L40:
            e = e;
            r16 = "purge_pipeline";
        L43:
            e = move-exception;
            r9 = e;
            r2 = r22;
        L38:
            th = move-exception;
            r4 = th;
            r19 = r22;
            goto L166
        L45:
            List r28 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L48 Exception -> L50 CancellationException -> L52
            Object r29 = r18;
            r16 = "purge_pipeline";
            r19 = r28;
        L93:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r29, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L95;
            ((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).add("configured-filesystem");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
        L95:
            OVirt r30 = this.f21055e;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            String r31 = this.f21054d.a();     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            d.h.a.b r32 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f21055e, this.f21054d, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            d.c.d r33 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            this.f21051a = r19;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            this.f21053c = 5;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            r23 = OVirt.access$runCleanupStep(r30, r31, "dynamic-providers", r32, r33);     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            if (r23 != r3) goto L98;
            return r3;
        L98:
            r22 = r19;
            goto L160
        L124:
            e = e;
        L67:
            r2 = r19;
            goto L126
        L52:
            e = move-exception;
            r9 = e;
            r2 = r28;
        L50:
            e = e;
            r16 = "purge_pipeline";
            r2 = r28;
        L48:
            th = move-exception;
            r4 = th;
            r19 = r28;
            goto L166
        L54:
            r19 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            Object r34 = r18;
            r16 = "purge_pipeline";
        L87:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r34, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L89;
            ((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).add("purge-shell-output");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
        L89:
            OVirt r35 = this.f21055e;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            String r36 = this.f21054d.a();     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            d.h.a.b r37 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f21054d, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            d.c.d r38 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            this.f21051a = r19;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            this.f21053c = 4;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            r29 = OVirt.access$runCleanupStep(r35, r36, "configured-filesystem", r37, r38);     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            if (r29 != r3) goto L93;
            return r3;
        L57:
            r19 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
        L81:
            this.f21054d.h().a();     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            OVirt r39 = this.f21055e;     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            String r40 = this.f21054d.a();     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            r16 = "purge_pipeline";
            d.h.a.b r41 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f21054d, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            d.c.d r110 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            this.f21051a = r19;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            this.f21053c = 3;     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            r34 = OVirt.access$runCleanupStep(r39, r40, "purge-shell-output", r41, r110);     // Catch: Throwable -> L63 CancellationException -> L68 Exception -> L124
            if (r34 != r3) goto L87;
            return r3;
        L60:
            r19 = (List) ZeusTransformUtils.preCheckCast(this.f21051a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
        L78:
            ca r42 = this.f21054d.f();     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            d.c.d r43 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            this.f21051a = r19;     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            this.f21053c = 2;     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            if (ce.a(r42, r43) != r3) goto L81;
            return r3;
        L70:
            d.o.a(r18);
            this.f21054d.a(true);
            if (IAppContext.Companion.isDebug() == false) goto L73;
            ILogDepend.Companion.i("OVirt/Service", "close: uniqueId=" + this.f21054d.a() + ", cancelling live handles");
        L74:
            r19 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            OVirt r44 = this.f21055e;     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            com.obric.aiagent.skill.ovirt.impl.h.a r111 = this.f21054d;     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            d.c.d r45 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            this.f21051a = r19;     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            this.f21053c = 1;     // Catch: Throwable -> L63 Exception -> L65 CancellationException -> L68
            if (OVirt.access$cancelAllAndReconcile(r44, r111, r45) != r3) goto L78;
            return r3;
        L73:
            ILogDepend.Companion.i("OVirt/Service", "close: cancelling live handles");
            goto L74
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L65:
            e = e;
            r16 = "purge_pipeline";
        L14:
            e = e;
            ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add("virt_close_failed");
            com.obric.aiagent.skill.ovirt.impl.b r46 = com.obric.aiagent.skill.ovirt.impl.b.f21110a;
            StringBuilder r47 = new StringBuilder();
        L116:
            r46.a("OVirt/Service", "virt_close_failed", r47.append("close: Virt close failed uniqueId=").append(this.f21054d.a()).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L131:
            th = th;
            r19 = "purge_pipeline";
        L64:
            r4 = th;
        L24:
            e = e;
            ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).add("virt_close_failed");
            r46 = com.obric.aiagent.skill.ovirt.impl.b.f21110a;
            r47 = new StringBuilder();
        L68:
            e = move-exception;
            r9 = e;
            r2 = r19;
        L63:
            th = th;
            goto L64
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {676, 103, 113, 132, 134, 149, 152}, d = "ensureActive", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21070e;
        long f;
        long g;
        long h;
        long i;
        int j;
        /* synthetic */ Object k;
        final /* synthetic */ OVirt l;
        int m;

        k(OVirt r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.k = r3;
            this.m |= Integer.MIN_VALUE;
            return this.l.ensureActive(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {255, 259, 294, 301, 341}, d = "initializeProjection", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21075e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ OVirt h;
        int i;

        l(OVirt r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return OVirt.access$initializeProjection(this.h, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {350}, d = "projectEmpty", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f21079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f21080e;
        final /* synthetic */ OVirt f;
        int g;

        m(OVirt r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21080e = r3;
            this.g |= Integer.MIN_VALUE;
            return OVirt.access$projectEmpty(this.f, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {BDImageUploader.KeyIsImageCountThreshold}, d = "rollbackOpening", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OVirt f21083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21084d;

        n(OVirt r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21083c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21082b = r3;
            this.f21084d |= Integer.MIN_VALUE;
            return OVirt.access$rollbackOpening(this.f21083c, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {AbstractDialog.HORIZONTAL_MAX_WIDTH, 441}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.OVirt$rollbackOpening$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.h.a f21086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OVirt f21087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f21088d;

        o(com.obric.aiagent.skill.ovirt.impl.h.a r3, OVirt r4, boolean r5, d.c.d<? super o> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21086b = r3;
            this.f21087c = r4;
            this.f21088d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f21086b, this.f21087c, this.f21088d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21085a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r6);
        L21:
            return x.f38692a;
        L10:
            d.o.a(r6);
            com.obric.aiagent.skill.ovirt.impl.h.a r7 = this.f21086b;
            if (r7 == null) goto L16;
            OVirt r2 = this.f21087c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21085a = 1;
            if (OVirt.access$closeTask(r2, r7, r3) != r0) goto L21;
            return r0;
        L16:
            if (this.f21088d == false) goto L21;
            IVirtService.c r8 = this.f21087c.getVirt$impl_release().getLifecycle();
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21085a = 2;
            if (r8.close(r4) != r0) goto L21;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OVirt.kt */
    @d.c.b.a.f(b = "OVirt.kt", c = {588}, d = "runCleanupStep", e = "com.obric.aiagent.skill.ovirt.impl.OVirt")
    static final class p extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f21091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OVirt f21093e;
        int f;

        p(OVirt r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21093e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21092d = r3;
            this.f |= Integer.MIN_VALUE;
            return OVirt.access$runCleanupStep(this.f21093e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$hj1_cPNoGQOel6wpQsdz-C88iJQ, reason: not valid java name */
    public static /* synthetic */ x m359lambda$hj1_cPNoGQOel6wpQsdzC88iJQ() {
        return access$lambda$10();
    }

    public OVirt() {
        this.lifecycleDispatcher = new com.obric.aiagent.skill.ovirt.impl.d.a();
        this.mutex = kotlinx.coroutines.f.c.a(false, 1, null);
        this.exclusiveExecutionRequested = new AtomicBoolean(false);
        IVirtService r0 = IVirtService.Companion.a();
        if (r0 == null) goto L7;
        this.virt = r0;
        this.lifecyclePhase = b.f21013a;
        com.obric.aiagent.skill.ovirt.impl.g.e r1 = new com.obric.aiagent.skill.ovirt.impl.g.e(this);
        this.shellCapability = r1;
        this.shell = (IOVirtService.d) ZeusTransformUtils.preCheckCast(r1, IOVirtService.d.class, "com.obric.aiagent.plugin");
        this.files = (IOVirtService.b) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.impl.c.b(this), IOVirtService.b.class, "com.obric.aiagent.plugin");
        this.maintenance = (IOVirtService.c) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.impl.e.a(this), IOVirtService.c.class, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new IllegalStateException("Virt SPI unavailable");
    }

    public static final /* synthetic */ Object access$cancelAllAndReconcile(OVirt r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d r4) {
        return r2.cancelAllAndReconcile(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$cleanStaleRuntimeShellOutputs(OVirt r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d r4) {
        return r2.cleanStaleRuntimeShellOutputs(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$closeLocked(OVirt r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d r4) {
        return r2.closeLocked(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$closeTask(OVirt r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d r4) {
        return r2.closeTask(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$initializeProjection(OVirt r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, d.c.d r4) {
        return r2.initializeProjection(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$projectEmpty(OVirt r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, com.obric.aiagent.skill.ovirt.impl.reporting.a r4, d.c.d r5) {
        return r2.projectEmpty(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$rollbackOpening(OVirt r2, com.obric.aiagent.skill.ovirt.impl.h.a r3, boolean r4, d.c.d r5) {
        return r2.rollbackOpening(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runCleanupStep(OVirt r2, String r3, String r4, d.h.a.b r5, d.c.d r6) {
        return r2.runCleanupStep(r3, r4, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.aiagent.skill.ovirt.impl.d.a getLifecycleDispatcher$impl_release() {
        return this.lifecycleDispatcher;
    }

    public final kotlinx.coroutines.f.a getMutex$impl_release() {
        return this.mutex;
    }

    public final AtomicBoolean getExclusiveExecutionRequested$impl_release() {
        return this.exclusiveExecutionRequested;
    }

    public final IVirtService getVirt$impl_release() {
        return this.virt;
    }

    public final com.obric.aiagent.skill.ovirt.impl.g.e getShellCapability$impl_release() {
        return this.shellCapability;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService
    public IOVirtService.e getTask() {
        return (IOVirtService.e) ZeusTransformUtils.preCheckCast(this, IOVirtService.e.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService
    public IOVirtService.d getShell() {
        return this.shell;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService
    public IOVirtService.b getFiles() {
        return this.files;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService
    public IOVirtService.c getMaintenance() {
        return this.maintenance;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService
    public void registerLifecycleListeners(List<? extends OVirtLifecycleListener> r3) {
        List<? extends OVirtLifecycleListener> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listeners");
        this.lifecycleDispatcher.a(r4);
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.e
    public boolean isAvailable() {
        return isAvailableNow$impl_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v118 */
    /* JADX WARN: Type inference failed for: r0v119 */
    /* JADX WARN: Type inference failed for: r0v120 */
    /* JADX WARN: Type inference failed for: r0v121 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v57, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v18, types: [long] */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Class, java.lang.Class<com.obric.aiagent.skill.ovirt.impl.OVirt>] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v31, types: [com.obric.aiagent.skill.ovirt.impl.OVirt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v33, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v34, types: [com.obric.aiagent.skill.ovirt.impl.OVirt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v43, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v65 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.obric.aiagent.skill.ovirt.impl.OVirt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v21, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24, types: [long] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v54, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [long] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [long] */
    /* JADX WARN: Type inference failed for: r7v15, types: [long] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v20, types: [long] */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.e
    public Object ensureActive(String r31, Map<String, String> r32, d.c.d<? super com.obric.aiagent.skill.ovirt.api.h> r33) {
        OVirt r0 = this;
        ?? r1 = OVirt.class;
        String r3 = "com.obric.aiagent.plugin";
        ?? r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, k.class) == false) goto L7;
        k r5 = (k) ZeusTransformUtils.preCheckCast(r4, k.class, "com.obric.aiagent.plugin");
        if ((r5.m & Integer.MIN_VALUE) == 0) goto L7;
        r5.m -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.k;
        Object r7 = d.c.a.b.a();
        ?? r8 = r5.m;
        switch(r8) {
            case 0: goto L54;
            case 1: goto L53;
            case 2: goto L48;
            case 3: goto L36;
            case 4: goto L27;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        long r9 = r5.h;
        long r11 = r5.g;
        long r13 = r5.f;
        th = (Throwable) ZeusTransformUtils.preCheckCast(r5.f21068c, Throwable.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r10 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f21067b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        OVirt r12 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21066a, r1, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L51
        kotlinx.coroutines.f.a r14 = r10;
        long r15 = r13;
        r3 = "com.obric.aiagent.plugin";
        ?? r16 = r9;
        ?? r17 = r12;
    L15:
        long r18 = r11;
        ILogDepend.Companion.e("OVirt/Service", "ensureActive failed", th);     // Catch: Throwable -> L177
        String r19 = th.getMessage();     // Catch: Throwable -> L177
        if (r19 != null) goto L167;
    L169:
        boolean r20 = false;
    L170:
        if (r20 == false) goto L172;
        com.obric.aiagent.skill.ovirt.api.f r21 = com.obric.aiagent.skill.ovirt.api.f.f20995c;     // Catch: Throwable -> L177
    L173:
        com.obric.aiagent.skill.ovirt.api.h r22 = (com.obric.aiagent.skill.ovirt.api.h) ZeusTransformUtils.preCheckCast(r17.failure(r21, th.getMessage(), r15, r18, d.c.b.a.b.a(r16)), com.obric.aiagent.skill.ovirt.api.h.class, r3);     // Catch: Throwable -> L177
        kotlinx.coroutines.f.a r23 = r14;
    L175:
        r23.b(null);
        return r22;
    L172:
        r21 = com.obric.aiagent.skill.ovirt.api.f.f20996d;     // Catch: Throwable -> L177
        goto L173
    L167:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, r3), (CharSequence) ZeusTransformUtils.preCheckCast("Virt", CharSequence.class, r3), true) != true) goto L169;
        r20 = true;
    L177:
        th = th;
        r2 = r14;
    L52:
        Object r24 = null;
        ?? r25 = r2;
    L203:
        r25.b(r24);
        throw th;
    L16:
        e = (CancellationException) ZeusTransformUtils.preCheckCast(r5.f21067b, CancellationException.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r26 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f21066a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L51
    L196:
        throw e;     // Catch: Throwable -> L51
    L19:
        long r110 = r5.i;
        int r27 = r5.j;
        long r111 = r5.h;
        long r112 = r5.g;
        long r28 = r5.f;
        com.obric.aiagent.skill.ovirt.impl.h.a r29 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r5.f21070e, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.h.a r113 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r5.f21069d, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r30 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f21068c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        String r34 = (String) ZeusTransformUtils.preCheckCast(r5.f21067b, String.class, "com.obric.aiagent.plugin");
        ?? r35 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21066a, r1, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L22 CancellationException -> L25
        r3 = "com.obric.aiagent.plugin";
        long r36 = r110;
        com.obric.aiagent.skill.ovirt.impl.h.a r37 = r113;
        ?? r114 = r111;
        String r115 = r34;
        com.obric.aiagent.skill.ovirt.impl.h.a r38 = r29;
        r35 = r35;
        r27 = r27;
    L205:
        long r210 = r35.elapsedSince$impl_release(r36);     // Catch: Throwable -> L109 CancellationException -> L112
        r35.active = r38;     // Catch: Throwable -> L109 CancellationException -> L112
        r35.updateLifecycle(b.f21015c);     // Catch: Throwable -> L109 CancellationException -> L112
        com.obric.aiagent.skill.ovirt.api.h.b r39 = new com.obric.aiagent.skill.ovirt.api.h.b(r115, false, new com.obric.aiagent.skill.ovirt.api.g(r35.elapsedSince$impl_release(r28), r112, r35.elapsedSince$impl_release(r114), r210));     // Catch: Throwable -> L109 CancellationException -> L112
        r3 = r3;
        r22 = (com.obric.aiagent.skill.ovirt.api.h) ZeusTransformUtils.preCheckCast(r39, com.obric.aiagent.skill.ovirt.api.h.class, r3);     // Catch: Throwable -> L107 CancellationException -> L112
        r23 = r30;
        goto L175
    L107:
        th = th;
    L111:
        ?? r40 = r114;
        com.obric.aiagent.skill.ovirt.impl.h.a r116 = r37;
        ?? r41 = r35;
        int r42 = r27;
    L24:
        r11 = r112;
        ?? r43 = r41;
        ?? r44 = r42;
        ?? r45 = r40;
    L154:
        if (r44 == 0) goto L156;
        boolean r46 = true;
    L221:
        r5.f21066a = r43;     // Catch: Throwable -> L181
        r5.f21067b = r30;     // Catch: Throwable -> L181
        r5.f21068c = th;     // Catch: Throwable -> L181
        r5.f21069d = null;     // Catch: Throwable -> L179
        r5.f21070e = null;     // Catch: Throwable -> L179
        r5.f = r28;     // Catch: Throwable -> L181
        r5.g = r11;     // Catch: Throwable -> L181
        r5.h = r45;     // Catch: Throwable -> L181
        r5.m = 7;     // Catch: Throwable -> L181
        if (r43.rollbackOpening(r116, r46, r5) != r7) goto L163;
        return r7;
    L163:
        r16 = r45;
        r15 = r28;
        r14 = r30;
        r17 = r43;
    L179:
        th = th;
        r25 = r30;
        r24 = null;
    L181:
        th = th;
        r2 = r30;
        goto L52
    L156:
        r46 = false;
    L112:
        e = e;
        r113 = r37;
    L26:
        kotlinx.coroutines.f.a r117 = r30;
        ?? r47 = r35;
        int r48 = r27;
    L35:
        boolean r118 = true;
        ?? r49 = r47;
        ?? r50 = r48;
    L185:
        if (r50 == 0) goto L187;
        boolean r51 = r118;
    L211:
        r5.f21066a = r117;     // Catch: Throwable -> L199
        r5.f21067b = e;     // Catch: Throwable -> L199
        r5.f21068c = null;     // Catch: Throwable -> L197
        r5.f21069d = null;     // Catch: Throwable -> L197
        r5.f21070e = null;     // Catch: Throwable -> L197
        r5.m = 6;     // Catch: Throwable -> L199
        if (r49.rollbackOpening(r113, r51, r5) != r7) goto L196;
        return r7;
    L197:
        th = th;
        r24 = null;
        r25 = r117;
    L199:
        th = th;
        r2 = r117;
        goto L52
    L187:
        r51 = false;
    L109:
        th = th;
        r3 = r3;
        goto L111
    L25:
        e = e;
    L22:
        th = th;
        r3 = "com.obric.aiagent.plugin";
        r116 = r113;
        r40 = r111;
        r41 = r35;
        r42 = r27;
        goto L24
    L27:
        int r52 = r5.j;
        long r53 = r5.h;
        long r54 = r5.g;
        long r119 = r5.f;
        com.obric.aiagent.skill.ovirt.impl.h.a r55 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r5.f21070e, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        r116 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r5.f21069d, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.f.a r120 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f21068c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        String r56 = (String) ZeusTransformUtils.preCheckCast(r5.f21067b, String.class, "com.obric.aiagent.plugin");
        OVirt r57 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21066a, r1, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L31 CancellationException -> L33
        ?? r211 = r53;
        kotlinx.coroutines.f.a r58 = r120;
        r115 = r56;
        r38 = r55;
        ?? r59 = r57;
        int r60 = r52;
    L30:
        long r61 = r119;
        r112 = r54;
        r36 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L118 CancellationException -> L121
        r5.f21066a = r59;     // Catch: Throwable -> L118 CancellationException -> L121
        r5.f21067b = r115;     // Catch: Throwable -> L118 CancellationException -> L121
        r5.f21068c = r58;     // Catch: Throwable -> L118 CancellationException -> L121
        r5.f21069d = r116;     // Catch: Throwable -> L118 CancellationException -> L121
        r5.f21070e = r38;     // Catch: Throwable -> L118 CancellationException -> L121
        r5.f = r61;     // Catch: Throwable -> L118 CancellationException -> L121
        r5.g = r112;     // Catch: Throwable -> L118 CancellationException -> L121
        kotlinx.coroutines.f.a r121 = r58;
        long r122 = r61;
        ?? r62 = r211;
        r5.h = r62;     // Catch: Throwable -> L114 CancellationException -> L116
        r5.j = r60;     // Catch: Throwable -> L114 CancellationException -> L116
        r5.i = r36;     // Catch: Throwable -> L114 CancellationException -> L116
        r5.m = 5;     // Catch: Throwable -> L114 CancellationException -> L116
        if (r59.initializeProjection(r38, r5) != r7) goto L102;
        return r7;
    L102:
        r37 = r116;
        r30 = r121;
        r114 = r62;
        r28 = r122;
        r35 = r59;
        r27 = r60;
        goto L205
    L116:
        e = e;
    L123:
        r118 = true;
        com.obric.aiagent.skill.ovirt.impl.h.a r212 = r116;
        r117 = r121;
        r113 = r212;
        r49 = r59;
        r50 = r60;
    L114:
        th = th;
        ?? r63 = r62;
    L120:
        r40 = r63;
        r30 = r121;
        r28 = r122;
        r41 = r59;
        r42 = r60;
        goto L24
    L121:
        e = e;
        r121 = r58;
    L118:
        th = th;
        r121 = r58;
        r122 = r61;
        r63 = r211;
        goto L120
    L33:
        e = e;
        r113 = r116;
        r117 = r120;
        r47 = r57;
        r48 = r52;
    L31:
        th = th;
        r3 = "com.obric.aiagent.plugin";
        r45 = r53;
        r30 = r120;
        r28 = r119;
        r11 = r54;
        r43 = r57;
        r44 = r52;
        goto L154
    L36:
        r2 = r5.j;
        r8 = r5.h;
        r54 = r5.g;
        r119 = r5.f;
        r117 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f21069d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        Map r64 = (Map) ZeusTransformUtils.preCheckCast(r5.f21068c, Map.class, "com.obric.aiagent.plugin");
        r115 = (String) ZeusTransformUtils.preCheckCast(r5.f21067b, String.class, "com.obric.aiagent.plugin");
        r1 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21066a, r1, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L39 Exception -> L44 CancellationException -> L46
        ?? r65 = r64;
        r1 = r1;
        ?? r66 = r8;
    L229:
        r1.clearAppPrivateShellOutputs();     // Catch: Throwable -> L128 CancellationException -> L130
        Map r67 = ao.a();     // Catch: Throwable -> L128 CancellationException -> L130
        r67.putAll(com.obric.aiagent.skill.ovirt.impl.h.b.f21450a.a());     // Catch: Throwable -> L128 CancellationException -> L130
        r67.putAll(r65);     // Catch: Throwable -> L128 CancellationException -> L130
        com.obric.aiagent.skill.ovirt.impl.h.a r68 = new com.obric.aiagent.skill.ovirt.impl.h.a(r115, ao.a(r67), r1.virt, r1.shellCapability);     // Catch: Throwable -> L128 CancellationException -> L130
    L235:
        r5.f21066a = r1;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.f21067b = r115;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.f21068c = r117;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.f21069d = r68;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.f21070e = r68;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.f = r119;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.g = r54;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.h = r66;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.j = 1;     // Catch: Throwable -> L124 CancellationException -> L126
        r5.m = 4;     // Catch: Throwable -> L124 CancellationException -> L126
        if (r1.cleanStaleRuntimeShellOutputs(r68, r5) != r7) goto L96;
        return r7;
    L96:
        r38 = r68;
        r211 = r66;
        r58 = r117;
        r116 = r38;
        r60 = 1;
        r59 = r1;
        goto L30
    L126:
        e = e;
        r113 = r68;
        r48 = 1;
        r47 = r1;
    L124:
        th = th;
        r3 = "com.obric.aiagent.plugin";
        ?? r69 = r66;
        r30 = r117;
        r116 = r68;
        ?? r70 = 1;
        ?? r71 = r1;
    L43:
        r28 = r119;
        r11 = r54;
        r43 = r71;
        r44 = r70;
        r45 = r69;
    L130:
        e = e;
        r2 = 1;
    L184:
        r118 = true;
        r113 = null;
        r49 = r1;
        r50 = r2;
    L128:
        th = th;
        ?? r72 = r66;
        r30 = r117;
        ?? r73 = 1;
        ?? r74 = r1;
    L42:
        r116 = null;
        r71 = r74;
        r70 = r73;
        r69 = r72;
        goto L43
    L46:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152 CancellationException -> L183
    L44:
        e = e;
        r3 = "com.obric.aiagent.plugin";
    L148:
        throw new IllegalStateException("Virt open failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r3));     // Catch: Throwable -> L152 CancellationException -> L183
    L39:
        th = th;
    L41:
        r72 = r8;
        r30 = r117;
        r74 = r1;
        r73 = r2;
        goto L42
    L48:
        long r75 = r5.g;
        long r76 = r5.f;
        kotlinx.coroutines.f.a r77 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f21069d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        Map r78 = (Map) ZeusTransformUtils.preCheckCast(r5.f21068c, Map.class, "com.obric.aiagent.plugin");
        String r123 = (String) ZeusTransformUtils.preCheckCast(r5.f21067b, String.class, "com.obric.aiagent.plugin");
        OVirt r79 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21066a, r1, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L51
        String r80 = r123;
        long r124 = r75;
        ?? r81 = r78;
        OVirt r82 = r79;
    L80:
        r115 = r80;
        long r213 = r76;
        r54 = r82.elapsedSince$impl_release(r124);     // Catch: Throwable -> L51
        r119 = r213;
        ?? r83 = r81;
        OVirt r84 = r82;
    L82:
        long r85 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L51
        r84.updateLifecycle(b.f21014b);     // Catch: Throwable -> L51
        IVirtService.c r86 = r84.virt.getLifecycle();     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.f21066a = r84;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.f21067b = r115;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.f21068c = r83;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.f21069d = r77;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.f = r119;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.g = r54;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.h = r85;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        r5.j = 0;     // Catch: Throwable -> L132 Exception -> L134 CancellationException -> L136
    L88:
        r5.m = 3;     // Catch: CancellationException -> L138 Throwable -> L141 Exception -> L144
        if (r86.open(r5) != r7) goto L91;
        return r7;
    L91:
        r117 = r77;
        r65 = r83;
        r1 = r84;
        r66 = r85;
        goto L229
    L136:
        e = e;
        boolean r87 = false;
    L242:
        throw e;     // Catch: Throwable -> L152 CancellationException -> L183
    L134:
        e = e;
        boolean r88 = false;
    L132:
        th = th;
        boolean r89 = false;
    L143:
        r116 = null;
        r30 = r77;
        r44 = r89;
        r45 = r85;
        r28 = r119;
        r11 = r54;
        r43 = r84;
    L138:
        e = e;
        r87 = false;
    L149:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152 CancellationException -> L183
    L144:
        e = e;
        r88 = false;
    L141:
        th = th;
        r89 = false;
        goto L143
    L53:
        long r90 = r5.f;
        kotlinx.coroutines.f.a r91 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r5.f21069d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        Map r92 = (Map) ZeusTransformUtils.preCheckCast(r5.f21068c, Map.class, "com.obric.aiagent.plugin");
        String r93 = (String) ZeusTransformUtils.preCheckCast(r5.f21067b, String.class, "com.obric.aiagent.plugin");
        OVirt r94 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21066a, r1, "com.obric.aiagent.plugin");
        d.o.a(r6);
        r80 = r93;
        r76 = r90;
        r23 = r91;
        r0 = r94;
        ?? r95 = r92;
    L213:
        com.obric.aiagent.skill.ovirt.impl.h.a r96 = r0.active;     // Catch: Throwable -> L201
        if (r96 == null) goto L75;
        if (r96.l() == true) goto L75;
        if (d.h.b.o.a(r96.a(), r80) == false) goto L75;
        r22 = (com.obric.aiagent.skill.ovirt.api.h) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.h.b(r80, true, new com.obric.aiagent.skill.ovirt.api.g(r0.elapsedSince$impl_release(r76), 0, 0, 0, 14, null)), com.obric.aiagent.skill.ovirt.api.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L201
    L75:
        if (r96 == null) goto L81;
        r124 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L201
        r5.f21066a = r0;     // Catch: Throwable -> L201
        r5.f21067b = r80;     // Catch: Throwable -> L201
        r5.f21068c = r95;     // Catch: Throwable -> L201
        r5.f21069d = r23;     // Catch: Throwable -> L201
        r5.f = r76;     // Catch: Throwable -> L201
        r5.g = r124;     // Catch: Throwable -> L201
        r5.m = 2;     // Catch: Throwable -> L201
        if (r0.closeLocked(r96, r5) != r7) goto L79;
        return r7;
    L79:
        kotlinx.coroutines.f.a r214 = r23;
        r82 = r0;
        r81 = r95;
        r77 = r214;
        goto L80
    L81:
        r115 = r80;
        kotlinx.coroutines.f.a r215 = r23;
        r84 = r0;
        r83 = r95;
        r77 = r215;
        long r216 = r76;
        r54 = 0;
        r119 = r216;
    L201:
        th = th;
        r2 = r23;
        goto L52
    L54:
        d.o.a(r6);
        long r97 = SystemClock.elapsedRealtime();
        if (isValidUniqueId(r31) == true) goto L59;
        return failure$default(this, com.obric.aiagent.skill.ovirt.api.f.f20993a, "uniqueId is invalid", r97, 0, null, 24, null);
    L59:
        if (isAvailableNow$impl_release() == false) goto L61;
        r23 = r0.mutex;
        r5.f21066a = r0;
        r80 = r31;
        r5.f21067b = r80;
        r5.f21068c = r2;
        r5.f21069d = r23;
        r5.f = r97;
        r5.m = 1;
        if (r23.a(null, r5) != r7) goto L65;
        return r7;
    L65:
        r76 = r97;
        r95 = r2;
        goto L213
    L61:
        return failure$default(this, com.obric.aiagent.skill.ovirt.api.f.f20994b, "Shell is unavailable", r97, 0, null, 24, null);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L51:
        th = th;
    L183:
        e = e;
    L152:
        th = th;
    L7:
        r5 = new k(r0, r4);
        goto L8
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.e
    public y paths(String r2) {
        d.h.b.o.e(r2, "uniqueId");
        com.obric.aiagent.skill.ovirt.impl.h.a r1 = activeState$impl_release(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.d();
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.e
    public Object skillLoaded(String r3, String r4, List<String> r5, d.c.d<? super x> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (isValidUniqueId(r3) == false) goto L5;
        Object r2 = this.lifecycleDispatcher.a(r3, r4, r7, r8);
        if (r2 != d.c.a.b.a()) goto L10;
        return r2;
    L10:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    @Override // com.obric.aiagent.skill.ovirt.api.IOVirtService.e
    public Object cleanupIfOwned(String r10, d.c.d<? super com.obric.aiagent.skill.ovirt.api.i> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r12, h.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f21045d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        boolean r5 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.f.a r9 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f21042a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Throwable -> L15
    L39:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L42;
        r5 = false;
    L42:
        kotlinx.coroutines.f.a r14 = r9;
        com.obric.aiagent.skill.ovirt.api.i r15 = (com.obric.aiagent.skill.ovirt.api.i) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.i.a(r5), com.obric.aiagent.skill.ovirt.api.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
    L44:
        r14.b(null);
        return r15;
    L15:
        th = th;
    L48:
        r9.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.f.a r16 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f21044c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.f21043b, String.class, "com.obric.aiagent.plugin");
        OVirt r4 = (OVirt) ZeusTransformUtils.preCheckCast(r0.f21042a, OVirt.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        r14 = r16;
        OVirt this = r4;
    L52:
        com.obric.aiagent.skill.ovirt.impl.h.a r6 = this.active;     // Catch: Throwable -> L46
        if (r6 != null) goto L32;
        r15 = (com.obric.aiagent.skill.ovirt.api.i) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.i.b("no active OVirt"), com.obric.aiagent.skill.ovirt.api.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        goto L44
    L32:
        if (d.h.b.o.a(r6.a(), r10) == true) goto L34;
        r15 = (com.obric.aiagent.skill.ovirt.api.i) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.i.b("uniqueId mismatch"), com.obric.aiagent.skill.ovirt.api.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        goto L44
    L34:
        r0.f21042a = r14;     // Catch: Throwable -> L46
        r0.f21043b = null;     // Catch: Throwable -> L46
        r0.f21044c = null;     // Catch: Throwable -> L46
        r0.f = 2;     // Catch: Throwable -> L46
        Object r17 = this.closeLocked(r6, r0);     // Catch: Throwable -> L46
        if (r17 != r2) goto L37;
        return r2;
    L37:
        kotlinx.coroutines.f.a r8 = r14;
        r13 = r17;
        r9 = r8;
    L46:
        th = th;
        r9 = r14;
        goto L48
    L20:
        d.o.a(r13);
        if (r10 == null) goto L51;
        if (isValidUniqueId(r10) == false) goto L51;
        r14 = this.mutex;
        r0.f21042a = this;
        r0.f21043b = r10;
        r0.f21044c = r14;
        r0.f = 1;
        if (r14.a(null, r0) != r2) goto L52;
        return r2;
    L51:
        return new com.obric.aiagent.skill.ovirt.api.i.b("uniqueId is invalid");
    L7:
        r0 = new h(this, r12);
        goto L8
    }

    public final boolean isAvailableNow$impl_release() {
        if (al.f19195a.a().F() == true) goto L14;
        return false;
    L14:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r3 = d.n.f(Boolean.valueOf(((OVirt) ZeusTransformUtils.preCheckCast(this, OVirt.class, "com.obric.aiagent.plugin")).virt.getLifecycle().isBackendSupported()));     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r3) == false) goto L13;
        r3 = false;
    L13:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L7:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L10
    }

    public static /* synthetic */ void assertShellEnabled$impl_release$default(OVirt r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.assertShellEnabled$impl_release(r1, r2);
    }

    public final void assertShellEnabled$impl_release(String r4, String r5) {
        d.h.b.o.e(r4, "action");
        if (al.f19195a.a().F() == false) goto L5;
        return;
    L5:
        com.obric.aiagent.skill.ovirt.impl.b r3 = com.obric.aiagent.skill.ovirt.impl.b.f21110a;
        String r0 = r4 + ": rejected because shell is disabled";
        StringBuilder r2 = new StringBuilder();
        r2.append(r4).append(": rejected because shell is disabled");
        if (r5 == null) goto L8;
        r2.append(" uniqueId=").append(r5);
    L8:
        x r6 = x.f38692a;
        String r7 = r2.toString();
        d.h.b.o.c(r7, "toString(...)");
        r3.b("SkRt/Shell", r0, r7);
        throw new com.obric.aiagent.skill.ovirt.api.e("OVirt shell is disabled by settings");
    }

    public final String busyReason$impl_release(v r2) {
        d.h.b.o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
        if (r2.a() == null) goto L5;
        return "A Shell execution is already running";
    L5:
        String r1 = r2.getMessage();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r3) == false) goto L12;
        r3 = "Virt is busy";
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [d.h.b.z$f] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.obric.aiagent.skill.manager.api.aa] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.obric.aiagent.skill.manager.api.aa] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.obric.aiagent.skill.manager.api.aa, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v9, types: [com.obric.aiagent.skill.manager.api.aa] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13, types: [com.obric.aiagent.skill.ovirt.impl.h.a] */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r13v10, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.aiagent.skill.ovirt.impl.OVirt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.obric.aiagent.skill.ovirt.impl.OVirt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [long] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.aiagent.skill.ovirt.impl.h.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.obric.aiagent.skill.ovirt.impl.h.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.aiagent.skill.ovirt.impl.h.a] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.aiagent.skill.ovirt.impl.h.a] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.obric.aiagent.skill.ovirt.impl.h.a] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.obric.aiagent.skill.ovirt.impl.h.a] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v12, types: [d.h.b.z$f] */
    /* JADX WARN: Type inference failed for: r3v23, types: [d.h.b.z$f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [d.h.b.z$f] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [long] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3, types: [long] */
    /* JADX WARN: Type inference failed for: r9v5, types: [long] */
    /* JADX WARN: Type inference failed for: r9v6, types: [long] */
    /* JADX WARN: Type inference failed for: r9v7, types: [long] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [long] */
    private final Object initializeProjection(com.obric.aiagent.skill.ovirt.impl.h.a r35, d.c.d<? super x> r36) {
        ?? r1 = this;
        ?? r2 = r35;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r36, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, l.class) == false) goto L7;
        l r5 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.g;
        Object r6 = d.c.a.b.a();
        int r7 = r5.i;
        ?? r11 = 3;
        r11 = 3;
        if (r7 == 0) goto L32;
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L24;
        if (r7 == 3) goto L23;
        if (r7 == 4) goto L18;
        if (r7 != 5) goto L17;
        d.o.a(r4);
    L85:
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r8 = r5.f;
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r5.f21075e, Closeable.class, "com.obric.aiagent.plugin");
        z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(r5.f21074d, z.f.class, "com.obric.aiagent.plugin");
        aa r12 = (aa) ZeusTransformUtils.preCheckCast(r5.f21073c, aa.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.h.a r13 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r5.f21072b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        OVirt r14 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21071a, OVirt.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L21
        ?? r15 = r8;
        ?? r16 = r10;
        ?? r17 = r12;
        ?? r18 = r13;
        ?? r19 = r14;
    L59:
        com.obric.aiagent.skill.ovirt.impl.f.b r110 = (com.obric.aiagent.skill.ovirt.impl.f.b) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.ovirt.impl.f.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r110.a(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r17.b(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r20, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L21
    L61:
        if (r22.hasNext() == false) goto L63;
        Iterator r34 = r22;
        ad r23 = (ad) ZeusTransformUtils.preCheckCast(r22.next(), ad.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        r21.add(new com.obric.aiagent.skill.ovirt.impl.f.a(r23.a(), null, r23.b(), 2, null));     // Catch: Throwable -> L21
        r22 = r34;
        goto L61
    L63:
        com.obric.aiagent.skill.ovirt.impl.f.b r28 = com.obric.aiagent.skill.ovirt.impl.f.b.a(r110, d.a.p.c(r0, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), false, false, null, 14, null);     // Catch: Throwable -> L21
        r16.f38504a = "batch_cleanup";     // Catch: Throwable -> L21
        d.f.c.a(r9, null);     // Catch: Exception -> L74 CancellationException -> L76
        OVirtReporter.a.a(OVirtReporter.Companion, r18.a(), r19.elapsedSince$impl_release(r15), r17.c(), r28, null, null, null, 112, null);     // Catch: Exception -> L74 CancellationException -> L76
    L21:
        th = th;
    L22:
        Throwable r24 = th;
        throw r24;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        d.f.c.a(r9, r24);     // Catch: Exception -> L74 CancellationException -> L76
        throw th;     // Catch: Exception -> L74 CancellationException -> L76
    L23:
        d.o.a(r4);
    L50:
        return x.f38692a;
    L24:
        long r25 = r5.f;
        com.obric.aiagent.skill.ovirt.impl.h.a r26 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r5.f21072b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        OVirt r111 = (OVirt) ZeusTransformUtils.preCheckCast(r5.f21071a, OVirt.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Exception -> L27 CancellationException -> L29
        ?? r27 = r25;
        r2 = r26;
        r1 = r111;
    L43:
        u r29 = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L92 CancellationException -> L94
    L94:
        CancellationException e2 = e;
    L98:
        OVirtReporter.Companion.a(r2.a(), r1.elapsedSince$impl_release(r27), null, null, "cancel", "manager_prepare", "cancelled");
        throw e2;
    L92:
        Exception e3 = e;
    L96:
        OVirtReporter.Companion.a(r2.a(), r1.elapsedSince$impl_release(r27), null, null, "fail", "manager_prepare", "internal_failed");
        throw e3;
    L45:
        if (ZeusTransformUtils.instanceOf(r29, u.a.class) == false) goto L52;
        OVirtReporter.a r112 = OVirtReporter.Companion;
        String r113 = r2.a();
        long r114 = r1.elapsedSince$impl_release(r27);
        String r30 = ((u.a) ZeusTransformUtils.preCheckCast(r29, u.a.class, "com.obric.aiagent.plugin")).a().name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r30, "toLowerCase(...)");
        r112.a(r113, r114, null, null, "fail", "manager_prepare", r30);
        com.obric.aiagent.skill.ovirt.impl.reporting.a r31 = com.obric.aiagent.skill.ovirt.impl.reporting.a.f21455b;
        r5.f21071a = null;
        r5.f21072b = null;
        r5.i = 3;
        if (r1.projectEmpty(r2, r31, r5) != r6) goto L50;
        return r6;
    L52:
        if (ZeusTransformUtils.instanceOf(r29, u.b.class) == false) goto L91;
        r11 = (aa) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r29, u.b.class, "com.obric.aiagent.plugin")).a(), aa.class, "com.obric.aiagent.plugin");
        ?? r32 = new z.f();
        r32.f38504a = "skill_projection";
        r9 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L78 CancellationException -> L87
        aa r115 = (aa) ZeusTransformUtils.preCheckCast(r9, aa.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L67
        com.obric.aiagent.skill.ovirt.impl.f.c r116 = r2.e();     // Catch: Throwable -> L67
        List<ac> r117 = r11.a();     // Catch: Throwable -> L67
        r5.f21071a = r1;     // Catch: Throwable -> L67
        r5.f21072b = r2;     // Catch: Throwable -> L67
        r5.f21073c = r11;     // Catch: Throwable -> L67
        r5.f21074d = r32;     // Catch: Throwable -> L67
        r5.f21075e = r9;     // Catch: Throwable -> L67
        r5.f = r27;     // Catch: Throwable -> L67
        r5.i = 4;     // Catch: Throwable -> L67
        Object r33 = r116.a(r117, r5);     // Catch: Throwable -> L67
        if (r33 != r6) goto L58;
        return r6;
    L58:
        r19 = r1;
        r18 = r2;
        r15 = r27;
        r16 = r32;
        r4 = r33;
        r17 = r11;
    L67:
        th = th;
        goto L22
    L87:
        e = e;
    L88:
        OVirtReporter.Companion.a(r2.a(), r1.elapsedSince$impl_release(r27), r11.c(), null, "cancel", (String) ZeusTransformUtils.preCheckCast(r32.f38504a, String.class, "com.obric.aiagent.plugin"), "cancelled");
        throw e;
    L78:
        e = e;
    L79:
        OVirtReporter.Companion.a(r2.a(), r1.elapsedSince$impl_release(r27), r11.c(), null, "fail", (String) ZeusTransformUtils.preCheckCast(r32.f38504a, String.class, "com.obric.aiagent.plugin"), "internal_failed");
        if (d.h.b.o.a(r32.f38504a, "batch_cleanup") == true) goto L86;
        ILogDepend.Companion.w("OVirt/Service", "Skill projection failed; using empty snapshot", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.ovirt.impl.reporting.a r37 = com.obric.aiagent.skill.ovirt.impl.reporting.a.f21457d;
        r5.f21071a = null;
        r5.f21072b = null;
        r5.f21073c = null;
        r5.f21074d = null;
        r5.f21075e = null;
        r5.i = 5;
        if (r1.projectEmpty(r2, r37, r5) != r6) goto L85;
        return r6;
    L86:
        throw e;
    L91:
        throw new d.k();
    L29:
        e2 = e;
        r27 = r25;
        r2 = r26;
        r1 = r111;
    L27:
        e3 = e;
        r27 = r25;
        r2 = r26;
        r1 = r111;
        goto L96
    L31:
        d.o.a(r4);
    L39:
        return x.f38692a;
    L32:
        d.o.a(r4);
        r27 = SystemClock.elapsedRealtime();
        ISkillManagerService r38 = ISkillManagerService.Companion.a();     // Catch: Exception -> L100 CancellationException -> L103
        if (r38 != null) goto L119;
        OVirtReporter.Companion.a(r35.a(), r1.elapsedSince$impl_release(r27), null, null, "fail", "manager_resolve", "service_unavailable");
        com.obric.aiagent.skill.ovirt.impl.reporting.a r39 = com.obric.aiagent.skill.ovirt.impl.reporting.a.f21454a;
        r5.i = 1;
        if (r1.projectEmpty(r2, r39, r5) != r6) goto L39;
        return r6;
    L119:
        r5.f21071a = r1;     // Catch: Exception -> L92 CancellationException -> L94
        r5.f21072b = r2;     // Catch: Exception -> L92 CancellationException -> L94
        r5.f = r27;     // Catch: Exception -> L92 CancellationException -> L94
        r5.i = 2;     // Catch: Exception -> L92 CancellationException -> L94
        r4 = r38.prepareInstalledSkillProjection(r5);     // Catch: Exception -> L92 CancellationException -> L94
        r1 = r1;
        r2 = r2;
        r27 = r27;
        if (r4 != r6) goto L43;
        return r6;
    L103:
        e = move-exception;
        OVirtReporter.Companion.a(r35.a(), r1.elapsedSince$impl_release(r27), null, null, "cancel", "manager_resolve", "cancelled");
        throw e;
    L100:
        e = move-exception;
        OVirtReporter.Companion.a(r35.a(), r1.elapsedSince$impl_release(r27), null, null, "fail", "manager_resolve", "service_unavailable");
        throw e;
    L76:
        e = e;
        r32 = 4;
        r27 = r1;
        r2 = 2;
        r1 = 1;
    L74:
        e = e;
        r32 = 4;
        r27 = r1;
        r2 = 2;
        r1 = 1;
    L7:
        r5 = new l(r1, r3);
        goto L8
    }

    private final Object projectEmpty(com.obric.aiagent.skill.ovirt.impl.h.a r21, com.obric.aiagent.skill.ovirt.impl.reporting.a r22, d.c.d<? super x> r23) {
        OVirt r1 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, m.class) == false) goto L7;
        m r3 = (m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f21080e;
        Object r4 = d.c.a.b.a();
        int r5 = r3.g;
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L20;
        long r6 = r3.f21079d;
        com.obric.aiagent.skill.ovirt.impl.reporting.a r7 = (com.obric.aiagent.skill.ovirt.impl.reporting.a) ZeusTransformUtils.preCheckCast(r3.f21078c, com.obric.aiagent.skill.ovirt.impl.reporting.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.h.a r8 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r3.f21077b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        OVirt r9 = (OVirt) ZeusTransformUtils.preCheckCast(r3.f21076a, OVirt.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Exception -> L14 CancellationException -> L17
        com.obric.aiagent.skill.ovirt.impl.reporting.a r10 = r7;
        r1 = r9;
    L62:
        com.obric.aiagent.skill.ovirt.impl.f.b r16 = (com.obric.aiagent.skill.ovirt.impl.f.b) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.ovirt.impl.f.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L32 CancellationException -> L34
    L49:
        OVirtReporter.a.a(OVirtReporter.Companion, r8.a(), r1.elapsedSince$impl_release(r6), r10, r16, false, 16, null);
        return x.f38692a;
    L34:
        e = e;
        com.obric.aiagent.skill.ovirt.impl.h.a r11 = r8;
    L55:
        com.obric.aiagent.skill.ovirt.impl.reporting.a r12 = r10;
    L56:
        OVirtReporter.Companion.a(r11.a(), r1.elapsedSince$impl_release(r6), r12, null, true);
        throw e;
    L32:
        e = e;
    L16:
        r11 = r8;
    L48:
        ILogDepend.Companion.w("OVirt/Service", "Empty Skill projection fallback failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r16 = null;
        r8 = r11;
        goto L49
    L17:
        e = e;
        r11 = r8;
        r12 = r7;
        r1 = r9;
    L14:
        e = e;
        r10 = r7;
        r1 = r9;
        goto L16
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        d.o.a(r2);
        long r13 = SystemClock.elapsedRealtime();
        com.obric.aiagent.skill.ovirt.impl.f.c r14 = r21.e();     // Catch: Exception -> L44 CancellationException -> L51
        List<ac> r15 = d.a.p.b();     // Catch: Exception -> L44 CancellationException -> L51
        r3.f21076a = r1;     // Catch: Exception -> L44 CancellationException -> L51
        r11 = r21;
        r3.f21077b = r11;     // Catch: Exception -> L40 CancellationException -> L42
        r10 = r22;
        r3.f21078c = r10;     // Catch: Exception -> L36 CancellationException -> L38
        r3.f21079d = r13;     // Catch: Exception -> L36 CancellationException -> L38
        r3.g = 1;     // Catch: Exception -> L36 CancellationException -> L38
        r2 = r14.a(r15, r3);     // Catch: Exception -> L36 CancellationException -> L38
        if (r2 != r4) goto L29;
        return r4;
    L29:
        r6 = r13;
        r8 = r11;
        goto L62
    L38:
        e = e;
    L54:
        r6 = r13;
    L36:
        e = e;
    L47:
        r6 = r13;
        goto L48
    L42:
        e = e;
    L53:
        r10 = r22;
    L40:
        e = e;
    L46:
        r10 = r22;
        goto L47
    L51:
        e = e;
        r11 = r21;
    L44:
        e = e;
        r11 = r21;
    L7:
        r3 = new m(r1, r0);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v3, types: [com.obric.aiagent.skill.ovirt.impl.OVirt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.aiagent.skill.ovirt.impl.OVirt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.aiagent.skill.ovirt.impl.h.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.obric.aiagent.skill.ovirt.impl.h.a] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.obric.aiagent.skill.ovirt.impl.OVirt] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.obric.aiagent.skill.ovirt.impl.g.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final <T> Object access$impl_release(String r17, boolean r18, d.h.a.a<x> r19, d.h.a.m<? super com.obric.aiagent.skill.ovirt.impl.h.a, ? super d.c.d<? super T>, ? extends Object> r20, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<? extends T>> r21) {
        ?? r1 = this;
        boolean r2 = r18;
        d.h.a.a<x> r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, c.class) == false) goto L7;
        c r7 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin");
        if ((r7.i & Integer.MIN_VALUE) == 0) goto L7;
        r7.i -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.g;
        Object r9 = d.c.a.b.a();
        int r10 = r7.i;
        if (r10 == 0) goto L30;
        if (r10 == 1) goto L25;
        if (r10 == 2) goto L16;
        if (r10 != 3) goto L15;
        int r4 = r7.f;
        r2 = r7.f21022e;
        ?? r11 = r4;
        ?? r12 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r7.f21019b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        ?? r13 = (OVirt) ZeusTransformUtils.preCheckCast(r7.f21018a, OVirt.class, "com.obric.aiagent.plugin");
    L96:
        d.o.a(r8);     // Catch: Throwable -> L19 v -> L21 CancellationException -> L23
        r11 = r11;
        r12 = r12;
        r13 = r13;
    L56:
        com.obric.aiagent.skill.ovirt.api.b r0 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.b.a(r8), com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19 v -> L21 CancellationException -> L23
        ?? r14 = r11;
        ?? r15 = r13;
    L72:
        if (r14 == 0) goto L74;
        kotlinx.coroutines.f.a.C1058a.b(r15.mutex, null, 1, null);
    L74:
        if (r2 == false) goto L76;
        r15.exclusiveExecutionRequested.set(false);
    L76:
        return r0;
    L21:
        e = e;
        ?? r16 = r13;
        ?? r22 = r11;
        ?? r23 = r12;
    L64:
        if (r2 == false) goto L70;
        String r24 = e.a();     // Catch: Throwable -> L28
        if (r24 == null) goto L68;
        com.obric.aiagent.skill.ovirt.api.b.b.c r25 = r16.shellCapability.a(r23, r24);     // Catch: Throwable -> L28
    L69:
        r0 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.b.C0439b(r25, r16.busyReason$impl_release(e)), com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        ?? r26 = r22;
        ?? r110 = r16;
    L61:
        r15 = r110;
        r14 = r26;
        goto L72
    L68:
        r25 = null;
        goto L69
    L70:
        r0 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.b.c((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        r26 = r22;
        r110 = r16;
    L23:
        e = move-exception;
        throw e;     // Catch: Throwable -> L28
    L19:
        th = th;
        ?? r111 = r13;
        ?? r27 = r11;
    L60:
        r0 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.b.c(th), com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        r26 = r27;
        r110 = r111;
        goto L61
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r28 = r7.f;
        r2 = r7.f21022e;
        r11 = r28;
        r12 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r7.f21019b, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        r13 = (OVirt) ZeusTransformUtils.preCheckCast(r7.f21018a, OVirt.class, "com.obric.aiagent.plugin");
        goto L96
    L25:
        int r29 = r7.f;
        r2 = r7.f21022e;
        r5 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r7.f21021d, d.h.a.m.class, "com.obric.aiagent.plugin");
        r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r7.f21020c, d.h.a.a.class, "com.obric.aiagent.plugin");
        String r30 = (String) ZeusTransformUtils.preCheckCast(r7.f21019b, String.class, "com.obric.aiagent.plugin");
        OVirt r112 = (OVirt) ZeusTransformUtils.preCheckCast(r7.f21018a, OVirt.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L28
        String r31 = r30;
        ?? r113 = r112;
    L89:
        ?? r32 = r113.activeState$impl_release(r31);     // Catch: Throwable -> L80
        if (r32 != 0) goto L94;
        com.obric.aiagent.skill.ovirt.api.b.d r33 = new com.obric.aiagent.skill.ovirt.api.b.d("OVirt is not active");     // Catch: Throwable -> L80
        kotlinx.coroutines.f.a.C1058a.b(r113.mutex, null, 1, null);
        if (r2 == false) goto L46;
        r113.exclusiveExecutionRequested.set(false);
    L46:
        return r33;
    L94:
        if (r2 == false) goto L52;
        IVirtService.d r34 = r113.virt.getShell();     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        d.h.a.b<? super d.c.d<? super T>, ? extends Object> r35 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r5, r32, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21018a = r113;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21019b = r32;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21020c = null;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21021d = null;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21022e = r2;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f = 1;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.i = 2;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        Object r36 = r34.a(r3, r35, r7);     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        if (r36 != r9) goto L51;
        return r9;
    L51:
        r8 = r36;
    L55:
        r12 = r32;
        r32 = 1;
        r13 = r113;
        r11 = r32;
    L52:
        r7.f21018a = r113;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21019b = r32;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21020c = null;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21021d = null;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f21022e = r2;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.f = 1;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r7.i = 3;     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        r8 = r5.invoke(r32, r7);     // Catch: Throwable -> L58 v -> L62 CancellationException -> L77
        if (r8 != r9) goto L55;
        return r9;
    L62:
        e = e;
        r23 = r32;
        r22 = 1;
        r16 = r113;
    L77:
        e = move-exception;
        throw e;     // Catch: Throwable -> L28
    L58:
        th = th;
        r27 = 1;
        r111 = r113;
    L80:
        th = th;
        r1 = 1;
        ?? r114 = r113;
    L84:
        if (r1 == 0) goto L86;
        kotlinx.coroutines.f.a.C1058a.b(r114.mutex, null, 1, null);
    L86:
        if (r2 == false) goto L88;
        r114.exclusiveExecutionRequested.set(false);
    L88:
        throw th;
    L30:
        d.o.a(r8);
        if (r2 == true) goto L33;
    L91:
        kotlinx.coroutines.f.a r37 = r1.mutex;     // Catch: Throwable -> L82
        r7.f21018a = r1;     // Catch: Throwable -> L82
        r31 = r17;
        r7.f21019b = r31;     // Catch: Throwable -> L82
        r7.f21020c = r3;     // Catch: Throwable -> L82
        r7.f21021d = r5;     // Catch: Throwable -> L82
        r7.f21022e = r2;     // Catch: Throwable -> L82
        r7.f = 0;     // Catch: Throwable -> L82
        r7.i = 1;     // Catch: Throwable -> L82
        if (kotlinx.coroutines.f.a.C1058a.a(r37, null, r7, 1, null) != r9) goto L39;
        return r9;
    L39:
        r113 = r1;
    L82:
        th = th;
        r114 = r1;
        r1 = 0;
        goto L84
    L33:
        if (r1.exclusiveExecutionRequested.compareAndSet(false, true) == true) goto L91;
        return new com.obric.aiagent.skill.ovirt.api.b.C0439b(null, "An exclusive execution is already running", 1, null);
    L28:
        th = th;
    L7:
        r7 = new c(r1, r6);
        goto L8
    }

    public static /* synthetic */ Object access$impl_release$default(OVirt r7, String r8, boolean r9, d.h.a.a r10, d.h.a.m r11, d.c.d r12, int r13, Object r14) {
        d.h.a.a<x> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r13 & 2) == 0) goto L5;
        r9 = false;
    L5:
        boolean r3 = r9;
        if ((r13 & 4) == 0) goto L9;
        r15 = $$Lambda$OVirt$hj1_cPNoGQOel6wpQsdzC88iJQ.INSTANCE;
    L9:
        return r7.access$impl_release(r8, r3, r15, r5, r6);
    }

    private static final x access$lambda$10() {
        return x.f38692a;
    }

    public final com.obric.aiagent.skill.ovirt.impl.h.a activeState$impl_release(String r4) {
        if (this.lifecyclePhase == b.f21015c) goto L5;
        return null;
    L5:
        com.obric.aiagent.skill.ovirt.impl.h.a r3 = this.active;
        if (r3 != null) goto L9;
        return null;
    L9:
        if (r3.l() == false) goto L11;
        return null;
    L11:
        if (r4 != null) goto L13;
    L15:
        return r3;
    L13:
        if (d.h.b.o.a(r3.a(), r4) == true) goto L15;
        return null;
    }

    private final Object closeLocked(com.obric.aiagent.skill.ovirt.impl.h.a r6, d.c.d<? super Boolean> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.aiagent.plugin");
        if ((r0.f21050d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21050d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f21048b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21050d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        OVirt this = (OVirt) ZeusTransformUtils.preCheckCast(r0.f21047a, OVirt.class, "com.obric.aiagent.plugin");
        d.o.a(r9);     // Catch: Throwable -> L23
    L20:
        boolean r10 = ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L23
        this.updateLifecycle(b.f21013a);
        return d.c.b.a.b.a(r10);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r9);
        updateLifecycle(b.f21016d);
        this.active = null;
        r0.f21047a = this;     // Catch: Throwable -> L23
        r0.f21050d = 1;     // Catch: Throwable -> L23
        r9 = closeTask(r6, r0);     // Catch: Throwable -> L23
        if (r9 != r2) goto L20;
        return r2;
    L23:
        th = move-exception;
        this.updateLifecycle(b.f21013a);
        throw th;
    L7:
        r0 = new i(this, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [d.x, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    private final Object rollbackOpening(com.obric.aiagent.skill.ovirt.impl.h.a r7, boolean r8, d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, n.class) == false) goto L7;
        n r0 = (n) ZeusTransformUtils.preCheckCast(r10, n.class, "com.obric.aiagent.plugin");
        if ((r0.f21084d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21084d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f21082b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21084d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        OVirt r6 = (OVirt) ZeusTransformUtils.preCheckCast(r0.f21081a, OVirt.class, "com.obric.aiagent.plugin");
        d.o.a(r11);     // Catch: Throwable -> L26
        OVirt r12 = r6;
    L24:
        r12.updateLifecycle(b.f21013a);
        OVirt this = x.f38692a;
        return this;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r11);
        this.active = null;
        d.c.g r4 = (d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r8 == false) goto L20;
        boolean r13 = true;
    L21:
        d.h.a.m r14 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r7, this, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        r0.f21081a = this;     // Catch: Throwable -> L26
        r0.f21084d = 1;     // Catch: Throwable -> L26
        this = this;
        if (kotlinx.coroutines.i.a(r4, r14, r0) != r2) goto L24;
        return r2;
    L20:
        r13 = false;
    L26:
        th = move-exception;
        this.updateLifecycle(b.f21013a);
        throw th;
    L7:
        r0 = new n(this, r10);
        goto L8
    }

    private final Object closeTask(com.obric.aiagent.skill.ovirt.impl.h.a r5, d.c.d<? super a> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(co.f39209b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r5, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    private final Object cancelAllAndReconcile(com.obric.aiagent.skill.ovirt.impl.h.a r11, d.c.d<? super x> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r13, e.class, "com.obric.aiagent.plugin");
        if ((r0.f21030e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21030e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f21028c;
        Object r14 = d.c.a.b.a();
        int r2 = r0.f21030e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        List r15 = (List) ZeusTransformUtils.preCheckCast(r0.f21027b, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.h.a r16 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r0.f21026a, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
        List r17 = r15;
        r11 = r16;
    L30:
        if (d.h.b.o.a(r10, d.c.b.a.b.a(true)) == true) goto L33;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/Shell", "cancelAllAndReconcile: timed out", "cancelAllAndReconcile: timed out shellGroupId=" + r11.c() + " liveHandles=" + r17.size());
    L33:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        Collection<com.obric.aiagent.skill.ovirt.impl.g.a> r18 = r11.k().values();
        d.h.b.o.c(r18, "<get-values>(...)");
        List r19 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L17;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Shell", "cancelAll: liveHandles=" + r19.size(), "cancelAll: shellGroupId=" + r11.c() + " liveHandles=" + r19.size());
    L17:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L19:
        if (r3.hasNext() == false) goto L22;
        ((com.obric.aiagent.skill.ovirt.impl.g.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.aiagent.skill.ovirt.impl.g.a.class, "com.obric.aiagent.plugin")).a(true);
        goto L19
    L22:
        if (r19.isEmpty() == true) goto L24;
        d.h.a.m r1 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r19, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f21026a = r11;
        r0.f21027b = r19;
        r0.f21030e = 1;
        Object r4 = dg.b(5000, r1, r0);
        if (r4 != r14) goto L28;
        return r14;
    L28:
        r17 = r19;
        r10 = r4;
        goto L30
    L24:
        return x.f38692a;
    L7:
        r0 = new e(this, r13);
        goto L8
    }

    private final Object cleanStaleRuntimeShellOutputs(com.obric.aiagent.skill.ovirt.impl.h.a r7, d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if ((r0.f21041d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21041d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f21039b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f21041d;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r7 = (com.obric.aiagent.skill.ovirt.impl.h.a) ZeusTransformUtils.preCheckCast(r0.f21038a, com.obric.aiagent.skill.ovirt.impl.h.a.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L24 CancellationException -> L28
    L21:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L27;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/Purge", "opening: stale shell output cleanup failed", "opening: stale shell output cleanup failed uniqueId=" + r7.a());     // Catch: Throwable -> L24 CancellationException -> L28
    L27:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r6);
        com.obric.aiagent.skill.ovirt.impl.a.a r11 = r7.j();     // Catch: Throwable -> L24 CancellationException -> L28
        String r3 = r7.a();     // Catch: Throwable -> L24 CancellationException -> L28
        y r5 = r7.d();     // Catch: Throwable -> L24 CancellationException -> L28
        r0.f21038a = r7;     // Catch: Throwable -> L24 CancellationException -> L28
        r0.f21041d = 1;     // Catch: Throwable -> L24 CancellationException -> L28
        r6 = r11.b(r3, r5, r0);     // Catch: Throwable -> L24 CancellationException -> L28
        if (r6 != r10) goto L21;
        return r10;
    L28:
        e = move-exception;
        throw e;
    L24:
        th = move-exception;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge", "opening: stale shell output cleanup threw", "opening: stale shell output cleanup threw uniqueId=" + r7.a(), th);
    L7:
        r0 = new g(this, r9);
        goto L8
    }

    private final void clearAppPrivateShellOutputs() {
        File r3 = new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), "skillruntime/shell-output");
        if (r3.exists() == true) goto L5;
        return;
    L5:
        if (d.f.k.h(r3) == true) goto L9;
        ILogDepend.Companion.w("OVirt/Service", "Failed to clear stale app-private shell output");
        return;
    }

    private final Object runCleanupStep(String r10, String r11, d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r12, d.c.d<? super Boolean> r13) {
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, p.class) == false) goto L7;
        p r0 = (p) ZeusTransformUtils.preCheckCast(r15, p.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f21092d;
        Object r16 = d.c.a.b.a();
        int r2 = r0.f;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L19;
        long r17 = r0.f21091c;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f21090b, String.class, "com.obric.aiagent.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r0.f21089a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r9);     // Catch: Throwable -> L14 CancellationException -> L16
    L25:
        boolean r20 = ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L14 CancellationException -> L16
        long r1 = System.currentTimeMillis() - r17;     // Catch: Throwable -> L14 CancellationException -> L16
        if (r20 == false) goto L28;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge", "run: ok durationMs=" + r1, "run: ok uniqueId=" + r19 + " id=" + r18 + " durationMs=" + r1);     // Catch: Throwable -> L14 CancellationException -> L16
    L34:
        return d.c.b.a.b.a(r20);
    L28:
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/Purge", "run: fail durationMs=" + r1, "run: fail uniqueId=" + r19 + " id=" + r18 + " durationMs=" + r1);     // Catch: Throwable -> L14 CancellationException -> L16
    L16:
        e = e;
        r11 = r18;
        r10 = r19;
    L36:
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.b("SkRt/Purge", "run: cancelled", "run: cancelled uniqueId=" + r10 + " id=" + r11);
        throw e;
    L14:
        th = th;
    L32:
        long r3 = System.currentTimeMillis() - r17;
        com.obric.aiagent.skill.ovirt.impl.b.f21110a.a("SkRt/Purge", "run: threw durationMs=" + r3, "run: threw uniqueId=" + r19 + " id=" + r18 + " durationMs=" + r3, th);
        r20 = false;
        goto L34
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r9);
        long r7 = System.currentTimeMillis();
        r0.f21089a = r10;     // Catch: Throwable -> L30 CancellationException -> L35
        r0.f21090b = r11;     // Catch: Throwable -> L30 CancellationException -> L35
        r0.f21091c = r7;     // Catch: Throwable -> L30 CancellationException -> L35
        r0.f = 1;     // Catch: Throwable -> L30 CancellationException -> L35
        r9 = r14.invoke(r0);     // Catch: Throwable -> L30 CancellationException -> L35
        if (r9 != r16) goto L24;
        return r16;
    L24:
        r19 = r10;
        r18 = r11;
        r17 = r7;
        goto L25
    L35:
        e = e;
    L30:
        th = th;
        r19 = r10;
        r18 = r11;
        r17 = r7;
    L7:
        r0 = new p(this, r15);
        goto L8
    }

    static /* synthetic */ com.obric.aiagent.skill.ovirt.api.h.a failure$default(OVirt r10, com.obric.aiagent.skill.ovirt.api.f r11, String r12, long r13, long r15, Long r17, int r18, Object r19) {
        if ((r18 & 8) == 0) goto L5;
        long r7 = 0;
    L7:
        if ((r18 & 16) == 0) goto L9;
        Long r9 = null;
    L11:
        return r10.failure(r11, r12, r13, r7, r9);
    L9:
        r9 = r17;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    private final com.obric.aiagent.skill.ovirt.api.h.a failure(com.obric.aiagent.skill.ovirt.api.f r13, String r14, long r15, long r17, Long r19) {
        long r1 = elapsedSince$impl_release(r15);
        if (r19 == null) goto L5;
        long r3 = elapsedSince$impl_release(((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.aiagent.plugin")).longValue());
    L7:
        return new com.obric.aiagent.skill.ovirt.api.h.a(r13, r14, new com.obric.aiagent.skill.ovirt.api.g(r1, r17, r3, 0, 8, null));
    L5:
        r3 = 0;
        goto L7
    }

    private final void updateLifecycle(b r1) {
        this.lifecyclePhase = r1;
    }

    private final boolean isValidUniqueId(String r7) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L16;
        if (d.h.b.o.a(r7, ".") == true) goto L16;
        if (d.h.b.o.a(r7, DownloadConstants.VULNERABILITY_PATH) == true) goto L16;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L16;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '\\', false, 2, null) == true) goto L16;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L16;
        return true;
    L16:
        return false;
    }

    public final long elapsedSince$impl_release(long r3) {
        return d.l.n.a(SystemClock.elapsedRealtime() - r3, 0);
    }
}
