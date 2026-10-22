package com.obric.autogui.agents.a.l;

import android.content.ComponentName;
import android.graphics.Bitmap;
import com.obric.autogui.agents.a.m.q;
import com.obric.autogui.agents.a.m.s;
import com.obric.autogui.agents.a.m.t;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotTaskInfo;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.de;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "ActionEffectSnapshot";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.a.a f26547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f26548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f26549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f26550e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    private static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f26551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.a.m.l f26552b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26551a, r6.f26551a) == true) goto L12;
            return false;
        L12:
            if (this.f26552b == r6.f26552b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            T r0 = this.f26551a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f26552b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "CapabilityCapture(value=" + this.f26551a + ", state=" + this.f26552b + ')';
        }

        public a(T r2, com.obric.autogui.agents.a.m.l r3) {
            o.e(r3, "state");
            this.f26551a = r2;
            this.f26552b = r3;
        }

        public final T a() {
            return this.f26551a;
        }

        public final com.obric.autogui.agents.a.m.l b() {
            return this.f26552b;
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t f26553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q f26554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private s f26555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f26556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f26557e;

        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {890}, d = "await", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$SnapshotTimingScope")
        static final class a<T> extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f26558a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f26559b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f26560c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f26561d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f26562e;

            a(c r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26561d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f26560c = r3;
                this.f26562e |= Integer.MIN_VALUE;
                return this.f26561d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {899}, d = "cancelAndAwait", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$SnapshotTimingScope")
        static final class b extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f26563a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f26564b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f26565c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f26566d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f26567e;

            b(c r3, d.c.d<? super b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26566d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f26565c = r3;
                this.f26567e |= Integer.MIN_VALUE;
                return this.f26566d.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public c(t r1, q r2) {
            this.f26553a = r1;
            this.f26554b = r2;
            this.f26555c = s.f26710a;
        }

        public final void a(s r2) {
            o.e(r2, "<set-?>");
            this.f26555c = r2;
        }

        public final void a(boolean r1) {
            this.f26556d = r1;
        }

        public final com.obric.autogui.agents.a.m.n a(com.obric.autogui.agents.a.m.k r3) {
            o.e(r3, "capability");
            q r0 = this.f26554b;
            if (r0 != null) goto L5;
            return null;
        L5:
            t r2 = this.f26553a;
            if (r2 != null) goto L8;
            return null;
        L8:
            return r2.a(r0, r3);
        }

        public final void a(com.obric.autogui.agents.a.m.n r2, com.obric.autogui.agents.a.m.l r3) {
            o.e(r3, "state");
            if (r2 != null) goto L5;
            return;
        L5:
            t r1 = this.f26553a;
            if (r1 == null) goto L9;
            r1.a(r2, r3);
            return;
        }

        public final void a(com.obric.autogui.agents.a.m.k r2, com.obric.autogui.agents.a.m.l r3) {
            o.e(r2, "capability");
            o.e(r3, "state");
            q r0 = this.f26554b;
            if (r0 != null) goto L5;
            return;
        L5:
            t r1 = this.f26553a;
            if (r1 == null) goto L9;
            r1.a(r0, r2, r3);
            return;
        }

        public final void a(com.obric.autogui.agents.a.l.a r3, com.obric.autogui.agents.a.m.l r4) {
            o.e(r3, "requirements");
            o.e(r4, "requestedState");
            com.obric.autogui.agents.a.m.k r0 = com.obric.autogui.agents.a.m.k.f26676a;
            if (r3.c() == false) goto L5;
            com.obric.autogui.agents.a.m.l r1 = r4;
        L6:
            a(r0, r1);
            com.obric.autogui.agents.a.m.k r2 = com.obric.autogui.agents.a.m.k.f26677b;
            if (r3.b() == false) goto L9;
            com.obric.autogui.agents.a.m.l r5 = r4;
        L10:
            a(r2, r5);
            com.obric.autogui.agents.a.m.k r6 = com.obric.autogui.agents.a.m.k.f26678c;
            if (r3.a() == false) goto L13;
            com.obric.autogui.agents.a.m.l r7 = r4;
        L14:
            a(r6, r7);
            com.obric.autogui.agents.a.m.k r8 = com.obric.autogui.agents.a.m.k.f26679d;
            if (r3.c() == true) goto L18;
            r4 = com.obric.autogui.agents.a.m.l.f26681a;
        L18:
            a(r8, r4);
            return;
        L13:
            r7 = com.obric.autogui.agents.a.m.l.f26681a;
            goto L14
        L9:
            r5 = com.obric.autogui.agents.a.m.l.f26681a;
            goto L10
        L5:
            r1 = com.obric.autogui.agents.a.m.l.f26681a;
            goto L6
        }

        public final <T> Object a(au<? extends T> r8, d.c.d<? super T> r9) {
            au r10 = (au) ZeusTransformUtils.wrapperContextForParams(r8, au.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
            if ((r0.f26562e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f26562e -= Integer.MIN_VALUE;
        L8:
            Object r12 = r0.f26560c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f26562e;
            if (r3 == 0) goto L18;
            if (r3 != 1) goto L17;
            long r7 = r0.f26559b;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.f26558a, c.class, "com.obric.aiagent.plugin");
            d.o.a(r12);     // Catch: Throwable -> L14
            long r5 = r7;
            c this = r1;
        L22:
            this.a(r5);
            return r12;
        L14:
            th = th;
            r5 = r7;
            this = r1;
        L25:
            this.a(r5);
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r12);
            r5 = AOSystemTools.INSTANCE.bootTimeMillis();
            r0.f26558a = this;     // Catch: Throwable -> L24
            r0.f26559b = r5;     // Catch: Throwable -> L24
            r0.f26562e = 1;     // Catch: Throwable -> L24
            r12 = r10.a(r0);     // Catch: Throwable -> L24
            if (r12 != r2) goto L22;
            return r2;
        L24:
            th = th;
        L7:
            r0 = new a(this, r11);
            goto L8
        }

        public final Object b(au<?> r8, d.c.d<? super x> r9) {
            au r10 = (au) ZeusTransformUtils.wrapperContextForParams(r8, au.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
            b r0 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
            if ((r0.f26567e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f26567e -= Integer.MIN_VALUE;
        L8:
            Object r12 = r0.f26565c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f26567e;
            if (r3 == 0) goto L18;
            if (r3 != 1) goto L17;
            long r7 = r0.f26564b;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.f26563a, c.class, "com.obric.aiagent.plugin");
            d.o.a(r12);     // Catch: Throwable -> L14
            long r5 = r7;
            c this = r1;
        L22:
            this.a(r5);
            return x.f38692a;
        L14:
            th = th;
            r5 = r7;
            this = r1;
        L25:
            this.a(r5);
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r12);
            r5 = AOSystemTools.INSTANCE.bootTimeMillis();
            ca r13 = (ca) ZeusTransformUtils.preCheckCast(r10, ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
            r0.f26563a = this;     // Catch: Throwable -> L24
            r0.f26564b = r5;     // Catch: Throwable -> L24
            r0.f26567e = 1;     // Catch: Throwable -> L24
            if (ce.a(r13, r0) != r2) goto L22;
            return r2;
        L24:
            th = th;
        L7:
            r0 = new b(this, r11);
            goto L8
        }

        public final void a() {
            q r1 = this.f26554b;
            if (r1 != null) goto L5;
            return;
        L5:
            t r0 = this.f26553a;
            if (r0 == null) goto L9;
            r0.a(r1, this.f26557e, this.f26555c, this.f26556d);
            return;
        }

        private final void a(long r5) {
            this.f26557e += d.l.n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r5, 0);
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.l.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    private static final class C0669d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f26568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f26569b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, C0669d.class) == true) goto L8;
            return false;
        L8:
            C0669d r8 = (C0669d) ZeusTransformUtils.preCheckCast(r7, C0669d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26568a, r8.f26568a) == true) goto L12;
            return false;
        L12:
            if (this.f26569b == r8.f26569b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            T r0 = this.f26568a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Long.hashCode(this.f26569b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "TimedCapture(value=" + this.f26568a + ", elapsedMs=" + this.f26569b + ')';
        }

        public C0669d(T r1, long r2) {
            this.f26568a = r1;
            this.f26569b = r2;
        }

        public final T a() {
            return this.f26568a;
        }

        public final long b() {
            return this.f26569b;
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {566}, d = "calculateFingerprint", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f26571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f26572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26573d;

        e(d r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26572c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26571b = r3;
            this.f26573d |= Integer.MIN_VALUE;
            return d.a(this.f26572c, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {134}, d = "capture", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26577d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f26578e;
        final /* synthetic */ d f;
        int g;

        f(d r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            this.f26578e = r12;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, null, null, false, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {246, 355, 359, 360, 389, 411, BDAbstractUpload.KeyIsTotalRequestTimeout, 461}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.autogui.agents.a.l.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26583e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        long l;
        int m;
        int n;
        int o;
        int p;
        int q;
        final /* synthetic */ com.obric.autogui.agents.a.l.c r;
        final /* synthetic */ com.obric.autogui.agents.a.l.a s;
        final /* synthetic */ c t;
        final /* synthetic */ com.obric.autogui.agents.vlm.models.a.a.b u;
        final /* synthetic */ d v;
        final /* synthetic */ boolean w;
        final /* synthetic */ String x;
        final /* synthetic */ String y;
        private /* synthetic */ Object z;

        /* JADX INFO: renamed from: com.obric.autogui.agents.a.l.d$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super a<com.obric.autogui.agents.a.d.c>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26584a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f26585b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.models.a.a.b f26586c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f26587d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f26588e;

            AnonymousClass1(d r3, com.obric.autogui.agents.vlm.models.a.a.b r4, AtomicInteger r5, String r6, d.c.d<? super AnonymousClass1> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26585b = r3;
                this.f26586c = r4;
                this.f26587d = r5;
                this.f26588e = r6;
                super(1, r8);
            }

            public final Object a(d.c.d<? super a<com.obric.autogui.agents.a.d.c>> r3) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r9) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26585b, this.f26586c, this.f26587d, this.f26588e, r7), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super a<com.obric.autogui.agents.a.d.c>> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26584a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r8);
            L11:
                return r8;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r8);
                d r9 = this.f26585b;
                IScreenshot r2 = this.f26586c.a();
                AtomicInteger r3 = this.f26587d;
                String r4 = this.f26588e;
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26584a = 1;
                r8 = d.a(r9, r2, r3, r4, r5);
                if (r8 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {465}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$component$1")
        static final class a extends d.c.b.a.l implements d.h.a.b<d.c.d<? super a<com.obric.autogui.agents.a.l.b>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26589a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f26590b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f26591c;

            a(d r3, String r4, d.c.d<? super a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26590b = r3;
                this.f26591c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super a<com.obric.autogui.agents.a.l.b>> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f26590b, this.f26591c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super a<com.obric.autogui.agents.a.l.b>> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26589a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                d r7 = this.f26590b;
                String r2 = this.f26591c;
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26589a = 1;
                r6 = d.a(r7, r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {343}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$componentDeferred$1$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super C0669d<com.obric.autogui.agents.a.l.b>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26592a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f26593b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f26594c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.a.m.n f26595d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f26596e;

            /* JADX INFO: renamed from: com.obric.autogui.agents.a.l.d$g$b$1, reason: invalid class name */
            /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
            @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {347}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$componentDeferred$1$1$1")
            static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super a<com.obric.autogui.agents.a.l.b>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f26597a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ d f26598b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f26599c;

                AnonymousClass1(d r3, String r4, d.c.d<? super AnonymousClass1> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f26598b = r3;
                    this.f26599c = r4;
                    super(1, r6);
                }

                public final Object a(d.c.d<? super a<com.obric.autogui.agents.a.l.b>> r3) {
                    return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(d.c.d<?> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26598b, this.f26599c, r5), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.b
                public /* synthetic */ Object invoke(d.c.d<? super a<com.obric.autogui.agents.a.l.b>> r3) {
                    return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r6) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f26597a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    d.o.a(r6);
                L11:
                    return r6;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    d.o.a(r6);
                    d r7 = this.f26598b;
                    String r2 = this.f26599c;
                    d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f26597a = 1;
                    r6 = d.a(r7, r2, r3);
                    if (r6 != r0) goto L11;
                    return r0;
                }
            }

            b(d r3, c r4, com.obric.autogui.agents.a.m.n r5, String r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26593b = r3;
                this.f26594c = r4;
                this.f26595d = r5;
                this.f26596e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super C0669d<com.obric.autogui.agents.a.l.b>> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f26593b, this.f26594c, this.f26595d, this.f26596e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super C0669d<com.obric.autogui.agents.a.l.b>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26592a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r9);
            L11:
                return r9;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r9);
                d r10 = this.f26593b;
                c r2 = this.f26594c;
                com.obric.autogui.agents.a.m.n r3 = this.f26595d;
                d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26593b, this.f26596e, null), d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26592a = 1;
                r9 = d.a(r10, r2, r3, r4, r5);
                if (r9 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {393}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$imageFingerprint$1$1")
        static final class c extends d.c.b.a.l implements d.h.a.b<d.c.d<? super a<com.obric.autogui.agents.a.d.c>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26600a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f26601b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ IScreenshot f26602c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f26603d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f26604e;

            c(d r3, IScreenshot r4, AtomicInteger r5, String r6, d.c.d<? super c> r7) {
                IScreenshot r8 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r4, IScreenshot.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26601b = r3;
                this.f26602c = r8;
                this.f26603d = r5;
                this.f26604e = r6;
                super(1, r9);
            }

            public final Object a(d.c.d<? super a<com.obric.autogui.agents.a.d.c>> r3) {
                return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r9) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f26601b, this.f26602c, this.f26603d, this.f26604e, r7), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super a<com.obric.autogui.agents.a.d.c>> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26600a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r8);
            L11:
                return r8;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r8);
                d r9 = this.f26601b;
                IScreenshot r2 = this.f26602c;
                AtomicInteger r3 = this.f26603d;
                String r4 = this.f26604e;
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26600a = 1;
                r8 = d.a(r9, r2, r3, r4, r5);
                if (r8 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.a.l.d$g$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {282}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$screenshotDeferred$1$1")
        static final class C0670d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super C0669d<ScreenshotResult>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26605a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f26606b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f26607c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.a.m.n f26608d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f26609e;
            final /* synthetic */ String f;
            final /* synthetic */ com.obric.autogui.agents.a.l.a g;

            /* JADX INFO: renamed from: com.obric.autogui.agents.a.l.d$g$d$1, reason: invalid class name */
            /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
            @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {286}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$screenshotDeferred$1$1$1")
            static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super a<ScreenshotResult>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f26610a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ d f26611b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f26612c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f26613d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.obric.autogui.agents.a.l.a f26614e;

                AnonymousClass1(d r3, String r4, String r5, com.obric.autogui.agents.a.l.a r6, d.c.d<? super AnonymousClass1> r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f26611b = r3;
                    this.f26612c = r4;
                    this.f26613d = r5;
                    this.f26614e = r6;
                    super(1, r8);
                }

                public final Object a(d.c.d<? super a<ScreenshotResult>> r3) {
                    return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(d.c.d<?> r9) {
                    d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26611b, this.f26612c, this.f26613d, this.f26614e, r7), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.b
                public /* synthetic */ Object invoke(d.c.d<? super a<ScreenshotResult>> r3) {
                    return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f26610a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    d.o.a(r8);
                L11:
                    return r8;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    d.o.a(r8);
                    d r9 = this.f26611b;
                    String r2 = this.f26612c;
                    String r3 = this.f26613d;
                    boolean r4 = this.f26614e.a();
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f26610a = 1;
                    r8 = d.a(r9, r2, r3, r4, r5);
                    if (r8 != r0) goto L11;
                    return r0;
                }
            }

            C0670d(d r3, c r4, com.obric.autogui.agents.a.m.n r5, String r6, String r7, com.obric.autogui.agents.a.l.a r8, d.c.d<? super C0670d> r9) {
                d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26606b = r3;
                this.f26607c = r4;
                this.f26608d = r5;
                this.f26609e = r6;
                this.f = r7;
                this.g = r8;
                super(2, r10);
            }

            public final Object a(am r3, d.c.d<? super C0669d<ScreenshotResult>> r4) {
                return ((C0670d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0670d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0670d(this.f26606b, this.f26607c, this.f26608d, this.f26609e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super C0669d<ScreenshotResult>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26605a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r12);
            L11:
                return r12;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r12);
                d r13 = this.f26606b;
                c r2 = this.f26607c;
                com.obric.autogui.agents.a.m.n r3 = this.f26608d;
                d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26606b, this.f26609e, this.f, this.g, null), d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26605a = 1;
                r12 = d.a(r13, r2, r3, r4, r5);
                if (r12 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
        @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {316}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$viewTreeDeferred$1$1")
        static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super C0669d<List<? extends ViewHierarchyDump>>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26615a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f26616b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f26617c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.a.m.n f26618d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f26619e;

            /* JADX INFO: renamed from: com.obric.autogui.agents.a.l.d$g$e$1, reason: invalid class name */
            /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
            @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {320}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureActive$2$viewTreeDeferred$1$1$1")
            static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super a<List<? extends ViewHierarchyDump>>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f26620a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ d f26621b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f26622c;

                AnonymousClass1(d r3, String r4, d.c.d<? super AnonymousClass1> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f26621b = r3;
                    this.f26622c = r4;
                    super(1, r6);
                }

                public final Object a(d.c.d<? super a<List<ViewHierarchyDump>>> r3) {
                    return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(d.c.d<?> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26621b, this.f26622c, r5), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.b
                public /* synthetic */ Object invoke(d.c.d<? super a<List<? extends ViewHierarchyDump>>> r3) {
                    return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r6) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f26620a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    d.o.a(r6);
                L11:
                    return r6;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    d.o.a(r6);
                    d r7 = this.f26621b;
                    String r2 = this.f26622c;
                    d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f26620a = 1;
                    r6 = d.b(r7, r2, r3);
                    if (r6 != r0) goto L11;
                    return r0;
                }
            }

            e(d r3, c r4, com.obric.autogui.agents.a.m.n r5, String r6, d.c.d<? super e> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26616b = r3;
                this.f26617c = r4;
                this.f26618d = r5;
                this.f26619e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super C0669d<List<ViewHierarchyDump>>> r4) {
                return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f26616b, this.f26617c, this.f26618d, this.f26619e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super C0669d<List<? extends ViewHierarchyDump>>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26615a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r9);
            L11:
                return r9;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r9);
                d r10 = this.f26616b;
                c r2 = this.f26617c;
                com.obric.autogui.agents.a.m.n r3 = this.f26618d;
                d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26616b, this.f26619e, null), d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26615a = 1;
                r9 = d.a(r10, r2, r3, r4, r5);
                if (r9 != r0) goto L11;
                return r0;
            }
        }

        g(com.obric.autogui.agents.a.l.c r3, com.obric.autogui.agents.a.l.a r4, c r5, com.obric.autogui.agents.vlm.models.a.a.b r6, d r7, boolean r8, String r9, String r10, d.c.d<? super g> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.r = r3;
            this.s = r4;
            this.t = r5;
            this.u = r6;
            this.v = r7;
            this.w = r8;
            this.x = r9;
            this.y = r10;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.agents.a.l.c> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r13, d.c.d<?> r14) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            g r15 = new g(this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, r11);
            r15.z = r13;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r15, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.agents.a.l.c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v156, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r4v40, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r4v66, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r4v90, types: [T, java.lang.Long] */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r63) {
            Object r0 = d.c.a.b.a();
            int r2 = this.q;
            String r3 = ", image_hash_elapsed_ms=";
            String r4 = d.TAG;
            switch(r2) {
                case 0: goto L43;
                case 1: goto L42;
                case 2: goto L37;
                case 3: goto L31;
                case 4: goto L26;
                case 5: goto L20;
                case 6: goto L17;
                case 7: goto L11;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            int r1 = this.p;
            int r5 = this.o;
            int r10 = this.n;
            int r11 = this.m;
            long r12 = this.l;
            z.f r14 = (z.f) ZeusTransformUtils.preCheckCast(this.i, z.f.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r6 = (List) ZeusTransformUtils.preCheckCast(this.h, List.class, "com.obric.aiagent.plugin");
            C0669d r8 = (C0669d) ZeusTransformUtils.preCheckCast(this.g, C0669d.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.d.c r7 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(this.f, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
            int r17 = r1;
            C0669d r9 = (C0669d) ZeusTransformUtils.preCheckCast(this.f26583e, C0669d.class, "com.obric.aiagent.plugin");
            z.f r15 = (z.f) ZeusTransformUtils.preCheckCast(this.f26582d, z.f.class, "com.obric.aiagent.plugin");
            String r13 = (String) ZeusTransformUtils.preCheckCast(this.f26581c, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.b r21 = (com.obric.autogui.agents.a.l.b) ZeusTransformUtils.preCheckCast(this.f26580b, com.obric.autogui.agents.a.l.b.class, "com.obric.aiagent.plugin");
            z.f r22 = (z.f) ZeusTransformUtils.preCheckCast(this.f26579a, z.f.class, "com.obric.aiagent.plugin");
            AtomicInteger r16 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.z, AtomicInteger.class, "com.obric.aiagent.plugin");
            d.o.a(r63);     // Catch: Throwable -> L9
            AtomicInteger r24 = r16;
            String r18 = ", image_hash_elapsed_ms=";
            String r19 = d.TAG;
            String r20 = "com.obric.aiagent.plugin";
            int r23 = r5;
            String r110 = r13;
            Object r25 = r63;
            String r26 = "";
            z.f r111 = r14;
            C0669d r112 = r9;
            z.f r113 = r15;
        L417:
            r111.f38504a = d.c.b.a.b.a(((C0669d) ZeusTransformUtils.preCheckCast(r25, C0669d.class, r20)).b());     // Catch: Throwable -> L608
            com.obric.autogui.agents.a.l.b r27 = (com.obric.autogui.agents.a.l.b) ZeusTransformUtils.preCheckCast(((C0669d) ZeusTransformUtils.preCheckCast(r25, C0669d.class, r20)).a(), com.obric.autogui.agents.a.l.b.class, r20);     // Catch: Throwable -> L608
            if (r27 == null) goto L421;
            ComponentName r28 = r27.b();     // Catch: Throwable -> L608
            int r114 = r11;
            z.f r64 = r111;
            com.obric.autogui.agents.a.l.b r29 = r21;
            z.f r115 = r22;
            int r210 = r23;
            int r116 = r10;
            int r117 = r17;
            z.f r30 = r113;
            com.obric.autogui.agents.a.l.b r118 = r27;
            C0669d r119 = r112;
            AtomicInteger r31 = r24;
            C0669d r120 = r8;
            com.obric.autogui.agents.a.d.c r32 = r7;
            List<ViewHierarchyDump> r33 = r6;
            ComponentName r34 = r28;
            String r35 = r110;
        L675:
        L605:
            th = th;
            z.f r36 = r30;
        L607:
            String r37 = r35;
            r15 = r36;
        L619:
            if (r37 == null) goto L625;
            d r38 = this.v;
            ScreenshotResult r39 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r15.f38504a, ScreenshotResult.class, r20);
            if (r39 == null) goto L623;
            IScreenshot r40 = r39.getPic();
        L624:
            d.a(r38, r37, r40);
            x r41 = x.f38692a;
            goto L625
        L623:
            r40 = null;
        L625:
            throw th;
        L423:
            if (this.s.a() == false) goto L429;
            if (r34 != null) goto L429;
            r31.incrementAndGet();     // Catch: Throwable -> L427
        L427:
            th = th;
            r37 = r35;
            r15 = r30;
        L429:
            z.f r121 = r30;
            ScreenshotResult r42 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r30.f38504a, ScreenshotResult.class, r20);     // Catch: Throwable -> L603
            if (r42 != null) goto L681;
        L438:
            com.obric.autogui.agents.a.l.b r43 = null;
        L439:
            if (r29 != null) goto L443;
            if (r43 == null) goto L444;
            r118 = r43;
        L444:
            if (r118 != null) goto L446;
            boolean r122 = true;
        L457:
            boolean r123 = false;
        L458:
            if (r118 != null) goto L460;
        L466:
            com.obric.autogui.agents.a.l.b r44 = null;
        L468:
            if (this.s.d() == false) goto L472;
            if (r34 == null) goto L472;
            if (r44 != null) goto L472;
            r31.incrementAndGet();     // Catch: Throwable -> L436
        L436:
            th = th;
            r37 = r35;
            r15 = r121;
        L472:
            z.f r54 = r64;
            boolean r124 = r122;
            z.f r56 = r115;
            long r57 = r12;
            com.obric.autogui.agents.a.l.c r125 = new com.obric.autogui.agents.a.l.c(r34, r33, r32, r44, false, r31.get(), 16, null);     // Catch: Throwable -> L601
            StringBuilder r45 = new StringBuilder();     // Catch: Throwable -> L601
            StringBuilder r46 = r45.append("[OAutoActionEffect] snapshot capture ").append(this.y).append(", required_component=").append(this.s.a()).append(", required_foreground_task=").append(this.s.d()).append(", required_viewtree=").append(this.s.b()).append(", required_image=").append(this.s.c()).append(", reused_component=");     // Catch: Throwable -> L601
            if (r210 == 0) goto L477;
            boolean r126 = r124;
        L478:
            StringBuilder r47 = r46.append(r126).append(", reused_foreground_task=");     // Catch: Throwable -> L601
            if (r117 == 0) goto L481;
            boolean r127 = r124;
        L482:
            StringBuilder r48 = r47.append(r127).append(", reused_viewtree=");     // Catch: Throwable -> L601
            if (r116 == 0) goto L485;
            boolean r128 = r124;
        L486:
            StringBuilder r49 = r48.append(r128).append(", reused_image=");     // Catch: Throwable -> L601
            if (r114 == 0) goto L489;
            boolean r129 = r124;
        L490:
            StringBuilder r50 = r49.append(r129).append(", acquired_component=");     // Catch: Throwable -> L601
            if (this.s.a() == false) goto L498;
            if (r210 != 0) goto L498;
        L496:
            th = th;
            r37 = r35;
            r15 = r121;
            goto L619
        L494:
            if (r125.a() == null) goto L498;
            boolean r130 = r124;
        L499:
            StringBuilder r51 = r50.append(r130).append(", acquired_foreground_task=");     // Catch: Throwable -> L601
            if (this.s.d() == false) goto L505;
            if (r117 != 0) goto L505;
            if (r125.d() == null) goto L505;
            boolean r131 = r124;
        L506:
            r51.append(r131).append(", acquired_viewtree=");     // Catch: Throwable -> L601
            if (this.s.b() == false) goto L512;
            if (r116 != 0) goto L512;
            if (r125.b() == null) goto L512;
            boolean r132 = r124;
        L513:
            StringBuilder r52 = r45.append(r132).append(", acquired_screenshot=");     // Catch: Throwable -> L601
            r36 = r121;
            ScreenshotResult r53 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r36.f38504a, ScreenshotResult.class, r20);     // Catch: Throwable -> L599
            if (r53 == null) goto L518;
            IScreenshot r55 = r53.getPic();     // Catch: Throwable -> L599
        L519:
            if (r55 == null) goto L521;
            boolean r133 = r124;
        L522:
            StringBuilder r58 = r52.append(r133).append(", available_component=");     // Catch: Throwable -> L599
            if (r125.a() == null) goto L525;
            boolean r134 = r124;
        L526:
            StringBuilder r59 = r58.append(r134).append(", available_foreground_task=");     // Catch: Throwable -> L599
            if (r125.d() == null) goto L529;
            boolean r135 = r124;
        L530:
            StringBuilder r60 = r59.append(r135).append(", foreground_task_top_consistent=");     // Catch: Throwable -> L599
            if (r123 == false) goto L533;
            boolean r136 = r124;
        L534:
            StringBuilder r61 = r60.append(r136).append(", available_viewtree=");     // Catch: Throwable -> L599
            if (r125.b() == null) goto L537;
            boolean r137 = r124;
        L538:
            StringBuilder r62 = r61.append(r137).append(", available_image=");     // Catch: Throwable -> L599
            if (r125.c() == null) goto L541;
            boolean r138 = r124;
        L542:
            StringBuilder r65 = r62.append(r138).append(", secure=").append(r125.e()).append(", error_count=").append(r125.f()).append(", screenshot_capture_executed=");     // Catch: Throwable -> L599
            if (r119 == null) goto L545;
            Long r66 = d.c.b.a.b.a(r119.b());     // Catch: Throwable -> L599
        L546:
            if (r66 == null) goto L548;
            boolean r139 = r124;
        L549:
            StringBuilder r67 = r65.append(r139).append(", screenshot_elapsed_ms=");     // Catch: Throwable -> L599
            if (r119 == null) goto L552;
            String r68 = d.c.b.a.b.a(r119.b()).toString();     // Catch: Throwable -> L599
        L553:
            if (r68 != null) goto L555;
            r68 = r26;
        L555:
            StringBuilder r69 = r67.append(r68).append(", viewtree_capture_executed=");     // Catch: Throwable -> L599
            if (r120 == null) goto L558;
            Long r70 = d.c.b.a.b.a(r120.b());     // Catch: Throwable -> L599
        L559:
            if (r70 == null) goto L561;
            boolean r140 = r124;
        L562:
            r69.append(r140);     // Catch: Throwable -> L599
            StringBuilder r71 = r45.append(", viewtree_elapsed_ms=");     // Catch: Throwable -> L599
            if (r120 == null) goto L565;
            String r72 = d.c.b.a.b.a(r120.b()).toString();     // Catch: Throwable -> L599
        L566:
            if (r72 != null) goto L568;
            r72 = r26;
        L568:
            StringBuilder r73 = r71.append(r72).append(", image_hash_executed=");     // Catch: Throwable -> L599
            if (r56.f38504a == 0) goto L571;
            boolean r74 = r124;
        L572:
            StringBuilder r75 = r73.append(r74).append(r18);     // Catch: Throwable -> L599
            Long r76 = (Long) ZeusTransformUtils.preCheckCast(r56.f38504a, Long.class, r20);     // Catch: Throwable -> L599
            if (r76 == null) goto L575;
            String r77 = r76.toString();     // Catch: Throwable -> L599
        L576:
            if (r77 != null) goto L578;
            r77 = r26;
        L578:
            StringBuilder r78 = r75.append(r77).append(", top_component_capture_executed=");     // Catch: Throwable -> L599
            if (r54.f38504a == 0) goto L581;
            boolean r79 = r124;
        L582:
            StringBuilder r80 = r78.append(r79).append(", top_component_elapsed_ms=");     // Catch: Throwable -> L599
            Long r81 = (Long) ZeusTransformUtils.preCheckCast(r54.f38504a, Long.class, r20);     // Catch: Throwable -> L599
            if (r81 == null) goto L585;
            String r82 = r81.toString();     // Catch: Throwable -> L599
        L586:
            if (r82 != null) goto L588;
            r82 = r26;
        L588:
            r80.append(r82).append(", elapsed_ms=").append(d.a(this.v, r57));     // Catch: Throwable -> L599
            String r83 = r45.toString();     // Catch: Throwable -> L599
            if (r125.f() != 0) goto L591;
            Loog.INSTANCE.i(r19, r83);     // Catch: Throwable -> L599
        L592:
            if (r35 == null) goto L598;
            d r84 = this.v;
            ScreenshotResult r85 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r36.f38504a, ScreenshotResult.class, r20);
            if (r85 == null) goto L596;
            IScreenshot r86 = r85.getPic();
        L597:
            d.a(r84, r35, r86);
            x r87 = x.f38692a;
            goto L598
        L596:
            r86 = null;
        L598:
            return r125;
        L591:
            Loog.INSTANCE.w(r19, r83);     // Catch: Throwable -> L599
            goto L592
        L585:
            r82 = null;
            goto L586
        L581:
            r79 = false;
            goto L582
        L575:
            r77 = null;
            goto L576
        L571:
            r74 = false;
            goto L572
        L565:
            r72 = null;
            goto L566
        L561:
            r140 = false;
            goto L562
        L558:
            r70 = null;
            goto L559
        L552:
            r68 = null;
            goto L553
        L548:
            r139 = false;
            goto L549
        L545:
            r66 = null;
            goto L546
        L541:
            r138 = false;
            goto L542
        L537:
            r137 = false;
            goto L538
        L533:
            r136 = false;
            goto L534
        L529:
            r135 = false;
            goto L530
        L525:
            r134 = false;
            goto L526
        L521:
            r133 = false;
            goto L522
        L518:
            r55 = null;
        L599:
            th = th;
        L512:
            r132 = false;
        L505:
            r131 = false;
        L498:
            r130 = false;
            goto L499
        L489:
            r129 = false;
            goto L490
        L485:
            r128 = false;
            goto L486
        L481:
            r127 = false;
            goto L482
        L477:
            r126 = false;
        L601:
            th = th;
            r36 = r121;
            goto L607
        L460:
            if (this.s.d() == false) goto L463;
            if (r123 == false) goto L463;
            boolean r88 = r122;
        L464:
            if (r88 == false) goto L466;
            r44 = r118;
        L463:
            r88 = false;
            goto L464
        L446:
            if (r118.a() == true) goto L448;
        L452:
            boolean r89 = false;
        L453:
            r122 = true;
            if (r89 != true) goto L457;
            r123 = true;
            goto L458
        L448:
            if (r118.b() == null) goto L452;
            if (o.a(r118.b(), r34) == false) goto L452;
            r89 = true;
            goto L453
        L443:
            r118 = r29;
            goto L444
        L681:
            ScreenshotTaskInfo r90 = r42.getTaskInfo();     // Catch: Throwable -> L436
            if (r90 == null) goto L438;
            r43 = d.a(this.v, r90);     // Catch: Throwable -> L436
        L603:
            th = th;
            r36 = r121;
        L608:
            th = th;
        L609:
            r15 = r113;
            r37 = r110;
            goto L619
        L421:
            r114 = r11;
            r64 = r111;
            r35 = r110;
            r29 = r21;
            r115 = r22;
            r210 = r23;
            r116 = r10;
            r117 = r17;
            r30 = r113;
            r118 = r27;
            r119 = r112;
            r31 = r24;
            r120 = r8;
            r32 = r7;
            r33 = r6;
            r34 = null;
        L9:
            th = th;
            r20 = "com.obric.aiagent.plugin";
            r37 = r13;
            goto L619
        L11:
            int r91 = this.p;
            int r92 = this.o;
            int r93 = this.n;
            int r94 = this.m;
            long r141 = this.l;
            z.f r142 = (z.f) ZeusTransformUtils.preCheckCast(this.k, z.f.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r143 = (List) ZeusTransformUtils.preCheckCast(this.j, List.class, "com.obric.aiagent.plugin");
            C0669d r144 = (C0669d) ZeusTransformUtils.preCheckCast(this.i, C0669d.class, "com.obric.aiagent.plugin");
            r117 = r91;
            com.obric.autogui.agents.a.d.c r145 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(this.h, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
            C0669d r95 = (C0669d) ZeusTransformUtils.preCheckCast(this.g, C0669d.class, "com.obric.aiagent.plugin");
            r15 = (z.f) ZeusTransformUtils.preCheckCast(this.f, z.f.class, "com.obric.aiagent.plugin");
            r26 = "";
            au<?> r211 = (au) ZeusTransformUtils.preCheckCast(this.f26583e, au.class, "com.obric.aiagent.plugin");
            String r212 = (String) ZeusTransformUtils.preCheckCast(this.f26582d, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.b r213 = (com.obric.autogui.agents.a.l.b) ZeusTransformUtils.preCheckCast(this.f26581c, com.obric.autogui.agents.a.l.b.class, "com.obric.aiagent.plugin");
            ComponentName r96 = (ComponentName) ZeusTransformUtils.preCheckCast(this.f26580b, ComponentName.class, "com.obric.aiagent.plugin");
            z.f r214 = (z.f) ZeusTransformUtils.preCheckCast(this.f26579a, z.f.class, "com.obric.aiagent.plugin");
            AtomicInteger r97 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.z, AtomicInteger.class, "com.obric.aiagent.plugin");
            d.o.a(r63);     // Catch: Throwable -> L14
            r18 = ", image_hash_elapsed_ms=";
            r19 = d.TAG;
            r20 = "com.obric.aiagent.plugin";
            z.f r98 = r142;
            C0669d r99 = r144;
            r112 = r95;
            r35 = r212;
            AtomicInteger r215 = r97;
            long r146 = r141;
            Object r147 = r0;
            Object r100 = r63;
            ComponentName r610 = r96;
        L372:
            r98.f38504a = d.c.b.a.b.a(((C0669d) ZeusTransformUtils.preCheckCast(r100, C0669d.class, r20)).b());     // Catch: Throwable -> L374
            ComponentName r148 = r610;
            int r611 = r93;
            Object r310 = r147;
            long r149 = r146;
            r33 = r143;
            r30 = r15;
            r115 = r214;
            r111 = r98;
            r114 = r94;
            r8 = r99;
            com.obric.autogui.agents.a.d.c r101 = r145;
            r29 = r213;
            r118 = (com.obric.autogui.agents.a.l.b) ZeusTransformUtils.preCheckCast(((C0669d) ZeusTransformUtils.preCheckCast(r100, C0669d.class, r20)).a(), com.obric.autogui.agents.a.l.b.class, r20);     // Catch: Throwable -> L374
            r31 = r215;
            r210 = r92;
        L683:
        L610:
            th = th;
            r113 = r30;
            r110 = r35;
            goto L609
        L380:
            if (this.s.a() == true) goto L670;
            r114 = r114;
            r34 = null;
            z.f r510 = r111;
            r116 = r611;
            r64 = r510;
            long r612 = r149;
            r30 = r30;
            r115 = r115;
            r117 = r117;
            r12 = r612;
            r119 = r112;
            r120 = r8;
            r32 = r101;
            goto L675
        L670:
            if (r148 == null) goto L392;
            if (r211 != null) goto L389;
            this.t.a(com.obric.autogui.agents.a.m.k.f26678c, com.obric.autogui.agents.a.m.l.f26682b);     // Catch: Throwable -> L386
        L389:
            r34 = r148;
        L390:
            r12 = r149;
        L391:
            r119 = r112;
            r120 = r8;
            r32 = r101;
            z.f r511 = r111;
            r116 = r611;
            r64 = r511;
            goto L675
        L392:
            r149 = r149;
            r114 = r114;
            ScreenshotResult r102 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r30.f38504a, ScreenshotResult.class, r20);     // Catch: Throwable -> L610
            if (r102 == null) goto L396;
            ComponentName r103 = r102.getTopComponent();     // Catch: Throwable -> L386
        L397:
            if (r103 == null) goto L399;
            this.t.a(com.obric.autogui.agents.a.m.k.f26678c, com.obric.autogui.agents.a.m.l.f26682b);     // Catch: Throwable -> L386
            r34 = ((ScreenshotResult) ZeusTransformUtils.preCheckCast(r30.f38504a, ScreenshotResult.class, r20)).getTopComponent();     // Catch: Throwable -> L386
            goto L390
        L399:
            if (r118 == null) goto L401;
            ComponentName r104 = r118.b();     // Catch: Throwable -> L386
        L402:
            if (r104 == null) goto L405;
            r34 = r118.b();     // Catch: Throwable -> L386
            goto L390
        L405:
            if (r211 == null) goto L408;
        L406:
            r30 = r30;
            r115 = r115;
            r117 = r117;
            r12 = r149;
            r34 = null;
            goto L391
        L408:
            if (this.w == true) goto L411;
            this.t.a(com.obric.autogui.agents.a.m.k.f26678c, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L386
            goto L406
        L411:
            com.obric.autogui.agents.a.m.n r105 = this.t.a(com.obric.autogui.agents.a.m.k.f26678c);     // Catch: Throwable -> L610
            d r150 = this.v;     // Catch: Throwable -> L610
            c r151 = this.t;     // Catch: Throwable -> L610
            d.h.a.b r106 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this.v, this.y, null), d.h.a.b.class, r20);     // Catch: Throwable -> L610
            d.c.d r152 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, r20);     // Catch: Throwable -> L610
            this.z = r31;     // Catch: Throwable -> L610
            this.f26579a = r115;     // Catch: Throwable -> L610
            this.f26580b = r29;     // Catch: Throwable -> L610
            this.f26581c = r35;     // Catch: Throwable -> L610
            this.f26582d = r30;     // Catch: Throwable -> L610
            this.f26583e = r112;     // Catch: Throwable -> L610
            this.f = r101;     // Catch: Throwable -> L610
            this.g = r8;     // Catch: Throwable -> L610
            this.h = r33;     // Catch: Throwable -> L610
            this.i = r111;     // Catch: Throwable -> L610
            this.j = null;     // Catch: Throwable -> L610
            this.k = null;     // Catch: Throwable -> L610
            z.f r153 = r115;
            this.l = r149;     // Catch: Throwable -> L610
            r24 = r31;
            this.m = r114;     // Catch: Throwable -> L610
            int r107 = r611;
            this.n = r107;     // Catch: Throwable -> L610
            int r108 = r210;
            this.o = r108;     // Catch: Throwable -> L610
            int r109 = r117;
            this.p = r109;     // Catch: Throwable -> L610
            r17 = r109;
            this.q = 8;     // Catch: Throwable -> L610
            r113 = r30;
            r110 = r35;
            r25 = d.a(r150, r151, r105, r106, r152);     // Catch: Throwable -> L608
            Object r154 = r310;
            if (r25 != r154) goto L416;
            return r154;
        L416:
            r6 = r33;
            r21 = r29;
            r23 = r108;
            r10 = r107;
            r7 = r101;
            r22 = r153;
            r12 = r149;
            r11 = r114;
            goto L417
        L401:
            r104 = null;
            goto L402
        L396:
            r103 = null;
        L386:
            th = th;
            r15 = r30;
        L375:
            r37 = r35;
        L374:
            th = th;
        L14:
            th = th;
            r20 = "com.obric.aiagent.plugin";
        L16:
            r37 = r212;
            goto L619
        L17:
            r26 = "";
            int r155 = this.p;
            int r156 = this.o;
            int r157 = this.n;
            int r158 = this.m;
            long r216 = this.l;
            com.obric.autogui.agents.a.d.c r159 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(this.i, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
            C0669d r160 = (C0669d) ZeusTransformUtils.preCheckCast(this.h, C0669d.class, "com.obric.aiagent.plugin");
            z.f r161 = (z.f) ZeusTransformUtils.preCheckCast(this.g, z.f.class, "com.obric.aiagent.plugin");
            au<?> r162 = (au) ZeusTransformUtils.preCheckCast(this.f, au.class, "com.obric.aiagent.plugin");
            int r163 = r155;
            String r164 = (String) ZeusTransformUtils.preCheckCast(this.f26583e, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.b r165 = (com.obric.autogui.agents.a.l.b) ZeusTransformUtils.preCheckCast(this.f26582d, com.obric.autogui.agents.a.l.b.class, "com.obric.aiagent.plugin");
            ComponentName r166 = (ComponentName) ZeusTransformUtils.preCheckCast(this.f26581c, ComponentName.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r167 = (List) ZeusTransformUtils.preCheckCast(this.f26580b, List.class, "com.obric.aiagent.plugin");
            z.f r217 = (z.f) ZeusTransformUtils.preCheckCast(this.f26579a, z.f.class, "com.obric.aiagent.plugin");
            AtomicInteger r168 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.z, AtomicInteger.class, "com.obric.aiagent.plugin");
            d.o.a(r63);     // Catch: Throwable -> L23
            r18 = ", image_hash_elapsed_ms=";
            r19 = d.TAG;
            int r169 = r156;
            ComponentName r218 = r166;
            AtomicInteger r170 = r168;
            Object r171 = r0;
            Object r172 = r63;
            String r173 = "com.obric.aiagent.plugin";
            z.f r174 = r161;
            List<ViewHierarchyDump> r175 = r167;
            r212 = r164;
        L336:
            AtomicInteger r613 = r170;
            r20 = r173;
            Object r311 = r171;
            r112 = r160;
            List<ViewHierarchyDump> r176 = r175;
            r115 = r217;
            C0669d r177 = (C0669d) ZeusTransformUtils.preCheckCast(r172, C0669d.class, r20);     // Catch: Throwable -> L340
            r15 = r174;
            r29 = r165;
            AtomicInteger r178 = r613;
            int r179 = r157;
            com.obric.autogui.agents.a.d.c r180 = r159;
            int r614 = r163;
            int r181 = r169;
            r35 = r212;
            long r512 = r216;
            int r182 = r158;
        L339:
            long r183 = r512;
        L612:
            th = th;
            String r184 = r35;
        L25:
            r37 = r184;
            goto L619
        L349:
            if (this.s.b() == false) goto L353;
            if (r176 == null) goto L353;
            this.t.a(com.obric.autogui.agents.a.m.k.f26677b, com.obric.autogui.agents.a.m.l.f26682b);     // Catch: Throwable -> L374
        L353:
            if (r176 != null) goto L358;
            if (r177 == null) goto L357;
            r33 = (List) ZeusTransformUtils.preCheckCast(r177.a(), List.class, r20);     // Catch: Throwable -> L374
        L360:
            if (this.s.b() == false) goto L363;
            if (r33 != null) goto L363;
            r178.incrementAndGet();     // Catch: Throwable -> L374
        L363:
            z.f r185 = new z.f();     // Catch: Throwable -> L612
            if (r162 == null) goto L378;
            c r186 = this.t;     // Catch: Throwable -> L612
            this.z = r178;     // Catch: Throwable -> L612
            this.f26579a = r115;     // Catch: Throwable -> L612
            this.f26580b = r218;     // Catch: Throwable -> L612
            this.f26581c = r29;     // Catch: Throwable -> L612
            this.f26582d = r35;     // Catch: Throwable -> L612
            this.f26583e = r162;     // Catch: Throwable -> L612
            this.f = r15;     // Catch: Throwable -> L612
            this.g = r112;     // Catch: Throwable -> L612
            this.h = r180;     // Catch: Throwable -> L612
            this.i = r177;     // Catch: Throwable -> L612
            this.j = r33;     // Catch: Throwable -> L612
            this.k = r185;     // Catch: Throwable -> L612
            r184 = r35;
            ComponentName r187 = r218;
            this.l = r183;     // Catch: Throwable -> L376
            r215 = r178;
            int r188 = r182;
            this.m = r188;     // Catch: Throwable -> L376
            int r189 = r179;
            this.n = r189;     // Catch: Throwable -> L376
            int r190 = r181;
            this.o = r190;     // Catch: Throwable -> L376
            int r191 = r614;
            this.p = r191;     // Catch: Throwable -> L376
            this.q = 7;     // Catch: Throwable -> L376
            r100 = r186.a(r162, this);     // Catch: Throwable -> L376
            r147 = r311;
            if (r100 != r147) goto L371;
            return r147;
        L371:
            r610 = r187;
            r214 = r115;
            r146 = r183;
            r98 = r185;
            r35 = r184;
            r94 = r188;
            r145 = r180;
            r211 = r162;
            r92 = r190;
            r117 = r191;
            r143 = r33;
            r213 = r29;
            r93 = r189;
            r99 = r177;
        L376:
            th = th;
            goto L25
        L378:
            int r219 = r614;
            r310 = r311;
            r611 = r179;
            r31 = r178;
            r148 = r218;
            r210 = r181;
            r117 = r219;
            r149 = r183;
            r101 = r180;
            r35 = r35;
            r118 = null;
            r8 = r177;
            r30 = r15;
            r111 = r185;
            r211 = r162;
            r114 = r182;
            goto L683
        L357:
            r33 = null;
            goto L360
        L358:
            r33 = r176;
        L340:
            th = th;
            r15 = r174;
            goto L16
        L20:
            r26 = "";
            int r192 = this.p;
            int r193 = this.o;
            int r194 = this.n;
            int r195 = this.m;
            r216 = this.l;
            C0669d r196 = (C0669d) ZeusTransformUtils.preCheckCast(this.j, C0669d.class, "com.obric.aiagent.plugin");
            z.f r197 = (z.f) ZeusTransformUtils.preCheckCast(this.i, z.f.class, "com.obric.aiagent.plugin");
            au<?> r198 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
            au<?> r199 = (au) ZeusTransformUtils.preCheckCast(this.g, au.class, "com.obric.aiagent.plugin");
            String r200 = (String) ZeusTransformUtils.preCheckCast(this.f, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.b r1100 = (com.obric.autogui.agents.a.l.b) ZeusTransformUtils.preCheckCast(this.f26583e, com.obric.autogui.agents.a.l.b.class, "com.obric.aiagent.plugin");
            ComponentName r201 = (ComponentName) ZeusTransformUtils.preCheckCast(this.f26582d, ComponentName.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r202 = (List) ZeusTransformUtils.preCheckCast(this.f26581c, List.class, "com.obric.aiagent.plugin");
            z.f r203 = (z.f) ZeusTransformUtils.preCheckCast(this.f26580b, z.f.class, "com.obric.aiagent.plugin");
            AtomicInteger r220 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.f26579a, AtomicInteger.class, "com.obric.aiagent.plugin");
            am r204 = (am) ZeusTransformUtils.preCheckCast(this.z, am.class, "com.obric.aiagent.plugin");
            d.o.a(r63);     // Catch: Throwable -> L23
            Object r205 = r0;
            r18 = ", image_hash_elapsed_ms=";
            r19 = d.TAG;
            int r513 = r193;
            au<?> r221 = r198;
            au<?> r1101 = r199;
            z.f r206 = r197;
            r218 = r201;
            r175 = r202;
            r115 = r203;
            Object r207 = r63;
            String r1102 = "com.obric.aiagent.plugin";
            int r1103 = r192;
            String r1104 = r200;
        L687:
            r115.f38504a = d.c.b.a.b.a(((C0669d) ZeusTransformUtils.preCheckCast(r207, C0669d.class, r1102)).b());     // Catch: Throwable -> L300
            com.obric.autogui.agents.a.d.c r208 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(((C0669d) ZeusTransformUtils.preCheckCast(r207, C0669d.class, r1102)).a(), com.obric.autogui.agents.a.d.c.class, r1102);     // Catch: Throwable -> L300
            if (r208 != null) goto L299;
            int r209 = r195;
            C0669d r222 = r196;
            com.obric.autogui.agents.a.l.b r223 = r1100;
            r178 = r220;
            ComponentName r514 = r218;
            z.f r224 = r206;
            ComponentName r225 = r514;
        L661:
            AtomicInteger r615 = r178;
            ComponentName r1105 = r225;
            this.t.a(com.obric.autogui.agents.a.m.k.f26679d, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L312
            r178 = r615;
            r311 = r205;
            int r226 = r194;
            int r227 = r209;
            r1101 = r1101;
            String r228 = r1104;
            r1103 = r1103;
            r180 = null;
            r29 = r223;
            z.f r229 = r224;
            r112 = r222;
            r173 = r1102;
            r218 = r1105;
            r162 = r221;
            int r1106 = r513;
        L691:
        L614:
            th = th;
            r212 = r228;
        L616:
            r20 = r173;
            r15 = r229;
            goto L16
        L321:
            if (this.s.c() == false) goto L327;
            if (r180 != null) goto L327;
            r178.incrementAndGet();     // Catch: Throwable -> L325
        L325:
            th = th;
            r37 = r228;
            r15 = r229;
        L205:
            r20 = r173;
        L327:
            if (r1101 == null) goto L347;
            c r230 = this.t;     // Catch: Throwable -> L614
            this.z = r178;     // Catch: Throwable -> L614
            this.f26579a = r115;     // Catch: Throwable -> L614
            this.f26580b = r175;     // Catch: Throwable -> L614
            this.f26581c = r218;     // Catch: Throwable -> L614
            this.f26582d = r29;     // Catch: Throwable -> L614
            this.f26583e = r228;     // Catch: Throwable -> L614
            this.f = r162;     // Catch: Throwable -> L614
            this.g = r229;     // Catch: Throwable -> L614
            this.h = r112;     // Catch: Throwable -> L614
            this.i = r180;     // Catch: Throwable -> L614
            r212 = r228;
            this.j = null;     // Catch: Throwable -> L345
            this.l = r216;     // Catch: Throwable -> L345
            this.m = r227;     // Catch: Throwable -> L345
            int r231 = r226;
            this.n = r231;     // Catch: Throwable -> L345
            AtomicInteger r616 = r178;
            int r232 = r1106;
            this.o = r232;     // Catch: Throwable -> L345
            int r233 = r1103;
            this.p = r233;     // Catch: Throwable -> L345
            r163 = r233;
            this.q = 6;     // Catch: Throwable -> L345
            r172 = r230.a(r1101, this);     // Catch: Throwable -> L345
            r171 = r311;
            if (r172 != r171) goto L334;
            return r171;
        L334:
            r158 = r227;
            r217 = r115;
            r160 = r112;
            r159 = r180;
            r157 = r231;
            r170 = r616;
            com.obric.autogui.agents.a.l.b r515 = r29;
            r174 = r229;
            r169 = r232;
            r165 = r515;
        L345:
            th = th;
            goto L616
        L347:
            String r234 = r228;
            r20 = r173;
            r176 = r175;
            r614 = r1103;
            r181 = r1106;
            r179 = r226;
            r177 = null;
            r15 = r229;
            r35 = r234;
            r512 = r216;
            r182 = r227;
        L312:
            th = th;
            r15 = r224;
        L302:
            r20 = r1102;
            r37 = r1104;
            goto L619
        L299:
            r311 = r205;
            r229 = r206;
            r226 = r194;
            r1101 = r1101;
            r228 = r1104;
            r1103 = r1103;
            r29 = r1100;
            r1106 = r513;
            r180 = r208;
            r112 = r196;
            r173 = r1102;
            r178 = r220;
            r162 = r221;
            r227 = r195;
        L300:
            th = th;
            r15 = r206;
            goto L302
        L26:
            r26 = "";
            long r235 = this.l;
            C0669d r236 = (C0669d) ZeusTransformUtils.preCheckCast(this.f26583e, C0669d.class, "com.obric.aiagent.plugin");
            r15 = (z.f) ZeusTransformUtils.preCheckCast(this.f26582d, z.f.class, "com.obric.aiagent.plugin");
            au<?> r237 = (au) ZeusTransformUtils.preCheckCast(this.f26581c, au.class, "com.obric.aiagent.plugin");
            String r238 = (String) ZeusTransformUtils.preCheckCast(this.f26580b, String.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r239 = (List) ZeusTransformUtils.preCheckCast(this.f26579a, List.class, "com.obric.aiagent.plugin");
            z.f r1107 = (z.f) ZeusTransformUtils.preCheckCast(this.z, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r63);     // Catch: Throwable -> L29
            r3 = ", image_hash_elapsed_ms=";
            r4 = d.TAG;
            String r240 = r238;
            r1102 = "com.obric.aiagent.plugin";
        L646:
            x r241 = x.f38692a;     // Catch: Throwable -> L235
            r229 = r15;
            r175 = r239;
            long r242 = r235;
        L237:
            this.t.a(true);     // Catch: Throwable -> L272
            if (this.s.c() == false) goto L241;
            this.t.a(com.obric.autogui.agents.a.m.k.f26679d, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L272
        L241:
            if (this.s.b() == false) goto L245;
            if (r175 == null) goto L245;
            this.t.a(com.obric.autogui.agents.a.m.k.f26677b, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L272
        L245:
            if (this.s.a() == false) goto L248;
            if (r237 != null) goto L248;
            this.t.a(com.obric.autogui.agents.a.m.k.f26678c, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L272
        L248:
            Loog r243 = Loog.INSTANCE;     // Catch: Throwable -> L272
            StringBuilder r244 = new StringBuilder().append("[OAutoActionEffect] snapshot capture short-circuited ").append(this.y).append(", reason=secure_result, screenshot_capture_executed=true, screenshot_elapsed_ms=");     // Catch: Throwable -> L272
            if (r236 == null) goto L251;
            String r245 = d.c.b.a.b.a(r236.b()).toString();     // Catch: Throwable -> L272
        L252:
            if (r245 != null) goto L254;
            r245 = r26;
        L254:
            StringBuilder r246 = r244.append(r245).append(", viewtree_capture_executed=false, viewtree_elapsed_ms=, image_hash_executed=");     // Catch: Throwable -> L272
            if (r1107.f38504a == 0) goto L257;
            boolean r247 = true;
        L258:
            StringBuilder r248 = r246.append(r247).append(r3);     // Catch: Throwable -> L272
            Long r249 = (Long) ZeusTransformUtils.preCheckCast(r1107.f38504a, Long.class, r1102);     // Catch: Throwable -> L272
            if (r249 == null) goto L261;
            String r250 = r249.toString();     // Catch: Throwable -> L272
        L262:
            if (r250 != null) goto L264;
            r250 = r26;
        L264:
            r243.i(r4, r248.append(r250).append(", top_component_capture_executed=false, top_component_elapsed_ms=, elapsed_ms=").append(d.a(this.v, r242)).toString());     // Catch: Throwable -> L272
            com.obric.autogui.agents.a.l.c r251 = com.obric.autogui.agents.a.l.c.f26541a.b();     // Catch: Throwable -> L272
            if (r240 == null) goto L271;
            d r252 = this.v;
            ScreenshotResult r253 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r229.f38504a, ScreenshotResult.class, r1102);
            if (r253 == null) goto L269;
            IScreenshot r254 = r253.getPic();
        L270:
            d.a(r252, r240, r254);
            x r255 = x.f38692a;
            goto L271
        L269:
            r254 = null;
        L271:
            return r251;
        L272:
            th = th;
            r37 = r240;
        L274:
            r15 = r229;
        L226:
            r20 = r1102;
            goto L619
        L261:
            r250 = null;
            goto L262
        L257:
            r247 = false;
            goto L258
        L251:
            r245 = null;
        L235:
            th = th;
            r37 = r240;
        L29:
            th = th;
            r37 = r238;
        L36:
            r20 = "com.obric.aiagent.plugin";
            goto L619
        L31:
            r26 = "";
            long r256 = this.l;
            C0669d r257 = (C0669d) ZeusTransformUtils.preCheckCast(this.f26583e, C0669d.class, "com.obric.aiagent.plugin");
            r15 = (z.f) ZeusTransformUtils.preCheckCast(this.f26582d, z.f.class, "com.obric.aiagent.plugin");
            au<?> r258 = (au) ZeusTransformUtils.preCheckCast(this.f26581c, au.class, "com.obric.aiagent.plugin");
            String r259 = (String) ZeusTransformUtils.preCheckCast(this.f26580b, String.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r1108 = (List) ZeusTransformUtils.preCheckCast(this.f26579a, List.class, "com.obric.aiagent.plugin");
            z.f r1109 = (z.f) ZeusTransformUtils.preCheckCast(this.z, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r63);     // Catch: Throwable -> L34
            r3 = ", image_hash_elapsed_ms=";
            r4 = d.TAG;
            r1102 = "com.obric.aiagent.plugin";
            r115 = r1109;
            C0669d r260 = r257;
            au<?> r1110 = r258;
            r37 = r259;
            r242 = r256;
            Object r261 = r0;
        L653:
            x r262 = x.f38692a;     // Catch: Throwable -> L225
            r236 = r260;
            r229 = r15;
            r240 = r37;
            r175 = r1108;
            r237 = r1110;
            r1107 = r115;
        L228:
            if (r237 == null) goto L237;
            c r263 = this.t;     // Catch: Throwable -> L272
            this.z = r1107;     // Catch: Throwable -> L272
            this.f26579a = r175;     // Catch: Throwable -> L272
            this.f26580b = r240;     // Catch: Throwable -> L272
            this.f26581c = r237;     // Catch: Throwable -> L272
            this.f26582d = r229;     // Catch: Throwable -> L272
            this.f26583e = r236;     // Catch: Throwable -> L272
            this.f = null;     // Catch: Throwable -> L272
            this.g = null;     // Catch: Throwable -> L272
            this.h = null;     // Catch: Throwable -> L272
            this.i = null;     // Catch: Throwable -> L272
            this.j = null;     // Catch: Throwable -> L272
            this.l = r242;     // Catch: Throwable -> L272
            this.q = 4;     // Catch: Throwable -> L272
            if (r263.b(r237, this) != r261) goto L232;
            return r261;
        L232:
            r235 = r242;
            r239 = r175;
            r15 = r229;
        L225:
            th = th;
        L34:
            th = th;
            r37 = r259;
            goto L36
        L37:
            r26 = "";
            int r264 = this.p;
            int r265 = this.o;
            int r266 = this.n;
            int r267 = this.m;
            long r1111 = this.l;
            r15 = (z.f) ZeusTransformUtils.preCheckCast(this.j, z.f.class, "com.obric.aiagent.plugin");
            au<?> r268 = (au) ZeusTransformUtils.preCheckCast(this.i, au.class, "com.obric.aiagent.plugin");
            au<?> r1112 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
            String r1113 = (String) ZeusTransformUtils.preCheckCast(this.g, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.b r269 = (com.obric.autogui.agents.a.l.b) ZeusTransformUtils.preCheckCast(this.f, com.obric.autogui.agents.a.l.b.class, "com.obric.aiagent.plugin");
            ComponentName r270 = (ComponentName) ZeusTransformUtils.preCheckCast(this.f26583e, ComponentName.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r271 = (List) ZeusTransformUtils.preCheckCast(this.f26582d, List.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.d.c r272 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(this.f26581c, com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
            z.f r273 = (z.f) ZeusTransformUtils.preCheckCast(this.f26580b, z.f.class, "com.obric.aiagent.plugin");
            AtomicInteger r274 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.f26579a, AtomicInteger.class, "com.obric.aiagent.plugin");
            am r275 = (am) ZeusTransformUtils.preCheckCast(this.z, am.class, "com.obric.aiagent.plugin");
            d.o.a(r63);     // Catch: Throwable -> L40
            int r312 = r265;
            int r313 = r266;
            String r276 = r1113;
            int r314 = r264;
            ComponentName r315 = r270;
            r261 = r0;
            r3 = ", image_hash_elapsed_ms=";
            r4 = d.TAG;
            r229 = r15;
            r175 = r271;
            Object r277 = r63;
            r173 = "com.obric.aiagent.plugin";
            com.obric.autogui.agents.a.l.b r278 = r269;
        L198:
            r1102 = r173;
            r260 = (C0669d) ZeusTransformUtils.preCheckCast(r277, C0669d.class, r1102);     // Catch: Throwable -> L201
            r29 = r278;
            r1101 = r1112;
            r115 = r273;
            r178 = r274;
            int r617 = r312;
            r1103 = r314;
            r227 = r267;
            com.obric.autogui.agents.a.d.c r279 = r272;
            r218 = r315;
            String r516 = r276;
            am r280 = r275;
            r37 = r516;
            r1110 = r268;
            r242 = r1111;
            int r1114 = r313;
        L209:
            if (r260 != null) goto L693;
            T r281 = 0;
        L642:
            r229.f38504a = r281;     // Catch: Throwable -> L617
            int r282 = r1114;
            if (d.a(this.v, (ScreenshotResult) ZeusTransformUtils.preCheckCast(r229.f38504a, ScreenshotResult.class, r1102)) == false) goto L275;
            if (r1101 == null) goto L227;
            c r283 = this.t;     // Catch: Throwable -> L213
            this.z = r115;     // Catch: Throwable -> L213
            this.f26579a = r175;     // Catch: Throwable -> L213
            this.f26580b = r37;     // Catch: Throwable -> L213
            this.f26581c = r1110;     // Catch: Throwable -> L213
            this.f26582d = r229;     // Catch: Throwable -> L213
            this.f26583e = r260;     // Catch: Throwable -> L213
            this.f = null;     // Catch: Throwable -> L213
            this.g = null;     // Catch: Throwable -> L213
            this.h = null;     // Catch: Throwable -> L213
            this.i = null;     // Catch: Throwable -> L213
            this.j = null;     // Catch: Throwable -> L213
            this.l = r242;     // Catch: Throwable -> L213
            this.q = 3;     // Catch: Throwable -> L213
            if (r283.b(r1101, this) != r261) goto L222;
            return r261;
        L222:
            r1108 = r175;
            r15 = r229;
            goto L653
        L227:
            r236 = r260;
            r1107 = r115;
            r240 = r37;
            r237 = r1110;
            goto L228
        L275:
            r18 = r3;
            r19 = r4;
            r216 = r242;
            ScreenshotResult r284 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r229.f38504a, ScreenshotResult.class, r1102);     // Catch: Throwable -> L617
            if (r284 != null) goto L279;
            IScreenshot r285 = null;
        L281:
            if (r279 == null) goto L626;
            r311 = r261;
            r228 = r37;
            r180 = r279;
            r226 = r282;
            r1106 = r617;
        L319:
            r112 = r260;
            r173 = r1102;
            r162 = r1110;
            goto L691
        L626:
        L315:
            th = th;
            z.f r286 = r229;
        L317:
            r15 = r286;
            goto L226
        L283:
            if (this.s.c() == false) goto L314;
            if (r285 == null) goto L309;
            c r287 = this.t;     // Catch: Throwable -> L315
            d r288 = this.v;     // Catch: Throwable -> L315
            String r1115 = this.x;     // Catch: Throwable -> L315
            com.obric.autogui.agents.a.m.n r289 = r287.a(com.obric.autogui.agents.a.m.k.f26679d);     // Catch: Throwable -> L315
            au<?> r290 = r1110;
            Object r316 = r261;
            am r291 = r280;
            r18 = r18;
            int r410 = r227;
            r19 = r19;
            int r517 = r617;
            C0669d r1116 = r260;
            z.f r292 = r229;
            d.h.a.b r293 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r288, r285, r178, r1115, null), d.h.a.b.class, r1102);     // Catch: Throwable -> L307
            this.z = r291;     // Catch: Throwable -> L307
            this.f26579a = r178;     // Catch: Throwable -> L307
            this.f26580b = r115;     // Catch: Throwable -> L307
            this.f26581c = r175;     // Catch: Throwable -> L307
            r218 = r218;
            this.f26582d = r218;     // Catch: Throwable -> L307
            com.obric.autogui.agents.a.l.b r294 = r29;
            this.f26583e = r294;     // Catch: Throwable -> L307
            this.f = r37;     // Catch: Throwable -> L307
            this.g = r1101;     // Catch: Throwable -> L307
            this.h = r290;     // Catch: Throwable -> L307
            r286 = r292;
            this.i = r286;     // Catch: Throwable -> L305
            this.j = r1116;     // Catch: Throwable -> L305
            r216 = r216;
            this.l = r216;     // Catch: Throwable -> L305
            this.m = r410;     // Catch: Throwable -> L305
            AtomicInteger r618 = r178;
            this.n = r282;     // Catch: Throwable -> L305
            this.o = r517;     // Catch: Throwable -> L305
            r513 = r517;
            int r295 = r1103;
            this.p = r295;     // Catch: Throwable -> L305
            r1103 = r295;
            this.q = 5;     // Catch: Throwable -> L305
            r221 = r290;
            r1104 = r37;
            r207 = d.a(r288, r287, r289, r293, this);     // Catch: Throwable -> L303
            r205 = r316;
            if (r207 != r205) goto L295;
            return r205;
        L295:
            r220 = r618;
            r206 = r286;
            r1100 = r294;
            r194 = r282;
            r196 = r1116;
            r195 = r410;
        L303:
            th = th;
            r15 = r286;
        L305:
            th = th;
        L307:
            th = th;
            r286 = r292;
            goto L317
        L309:
            r513 = r617;
            r1104 = r37;
            r222 = r260;
            r205 = r261;
            r18 = r18;
            r19 = r19;
            r221 = r1110;
            r216 = r216;
            r225 = r218;
            r224 = r229;
            r223 = r29;
            r194 = r282;
            r209 = r227;
            goto L661
        L314:
            r311 = r261;
            r228 = r37;
            r226 = r282;
            r1106 = r617;
            r180 = null;
            goto L319
        L279:
            r285 = r284.getPic();     // Catch: Throwable -> L213
        L617:
            th = th;
            r20 = r1102;
            r15 = r229;
            goto L619
        L693:
            r281 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r260.a(), ScreenshotResult.class, r1102);     // Catch: Throwable -> L213
        L213:
            th = th;
        L201:
            th = th;
            r15 = r229;
            r37 = r276;
        L40:
            th = th;
            r20 = "com.obric.aiagent.plugin";
            r37 = r1113;
            goto L619
        L42:
            r26 = "";
            long r296 = this.l;
            z.f r297 = (z.f) ZeusTransformUtils.preCheckCast(this.f26580b, z.f.class, "com.obric.aiagent.plugin");
            AtomicInteger r298 = (AtomicInteger) ZeusTransformUtils.preCheckCast(this.f26579a, AtomicInteger.class, "com.obric.aiagent.plugin");
            am r299 = (am) ZeusTransformUtils.preCheckCast(this.z, am.class, "com.obric.aiagent.plugin");
            d.o.a(r63);
            Object r300 = r63;
        L69:
            r297.f38504a = d.c.b.a.b.a(((C0669d) ZeusTransformUtils.preCheckCast(r300, C0669d.class, "com.obric.aiagent.plugin")).b());
            r115 = r297;
            com.obric.autogui.agents.a.d.c r301 = (com.obric.autogui.agents.a.d.c) ZeusTransformUtils.preCheckCast(((C0669d) ZeusTransformUtils.preCheckCast(r300, C0669d.class, "com.obric.aiagent.plugin")).a(), com.obric.autogui.agents.a.d.c.class, "com.obric.aiagent.plugin");
            long r1117 = r296;
            AtomicInteger r1118 = r298;
        L70:
            am r1119 = r299;
            com.obric.autogui.agents.a.l.c r302 = this.r;
            if (r302 == null) goto L78;
            List<ViewHierarchyDump> r303 = r302.b();
            if (r303 == null) goto L78;
        L77:
            r175 = r303;
        L82:
            com.obric.autogui.agents.a.l.c r304 = this.r;
            if (r304 == null) goto L88;
            ComponentName r305 = r304.a();
            if (r305 == null) goto L88;
        L87:
            ComponentName r306 = r305;
        L92:
            com.obric.autogui.agents.a.l.c r307 = this.r;
            if (r307 == null) goto L96;
            com.obric.autogui.agents.a.l.b r308 = r307.d();
            if (r308 == null) goto L96;
        L102:
            if (r308 != null) goto L104;
        L113:
            com.obric.autogui.agents.a.l.b r309 = null;
        L115:
            if (this.s.c() == false) goto L118;
            if (r301 == null) goto L118;
            int r317 = 1;
        L120:
            if (this.s.b() == false) goto L123;
            if (r175 == null) goto L123;
            int r318 = 1;
        L125:
            if (this.s.a() == false) goto L128;
            if (r306 == null) goto L128;
            int r319 = 1;
        L130:
            if (this.s.d() == false) goto L133;
            if (r309 == null) goto L133;
            int r619 = 1;
        L135:
            if (this.s.c() == false) goto L140;
            if (r301 != null) goto L140;
            if (this.w == false) goto L140;
            boolean r1120 = true;
        L141:
            if (r1120 == false) goto L143;
            String r320 = "action_effect_" + this.x + '_' + d.a(this.v).incrementAndGet();
        L144:
            if (r320 == null) goto L146;
            com.obric.autogui.agents.a.m.n r2100 = this.t.a(com.obric.autogui.agents.a.m.k.f26676a);
        L147:
            if (r320 == null) goto L149;
            d r321 = this.v;
            c r322 = this.t;
            int r323 = r317;
            String r324 = this.y;
            com.obric.autogui.agents.a.l.b r325 = r309;
            com.obric.autogui.agents.a.l.a r326 = this.s;
            int r327 = r619;
            int r328 = r323;
            com.obric.autogui.agents.a.l.b r329 = r325;
            ComponentName r330 = r306;
            au r331 = kotlinx.coroutines.i.b(r1119, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0670d(r321, r322, r2100, r320, r324, r326, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        L151:
            if (this.s.b() == true) goto L154;
            this.t.a(com.obric.autogui.agents.a.m.k.f26677b, com.obric.autogui.agents.a.m.l.f26681a);
        L154:
            if (this.s.b() == false) goto L160;
            if (r175 != null) goto L160;
            if (this.w == true) goto L160;
            this.t.a(com.obric.autogui.agents.a.m.k.f26677b, com.obric.autogui.agents.a.m.l.f26683c);
        L160:
            if (this.s.b() == false) goto L165;
            if (r175 != null) goto L165;
            if (this.w == false) goto L165;
            com.obric.autogui.agents.a.m.n r2101 = this.t.a(com.obric.autogui.agents.a.m.k.f26677b);
        L166:
            if (r2101 == null) goto L168;
            r1101 = kotlinx.coroutines.i.b(r1119, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this.v, this.t, r2101, this.y, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        L170:
            if (this.s.a() == true) goto L172;
            this.t.a(com.obric.autogui.agents.a.m.k.f26678c, com.obric.autogui.agents.a.m.l.f26681a);
        L172:
            r278 = r329;
            if (this.s.d() == false) goto L176;
            if (r278 != null) goto L176;
            boolean r332 = true;
        L178:
            if (this.s.a() == false) goto L185;
            if (r1120 == true) goto L185;
            if (this.w == false) goto L185;
            if (r330 == null) goto L184;
            if (r332 == false) goto L185;
        L184:
            com.obric.autogui.agents.a.m.n r411 = this.t.a(com.obric.autogui.agents.a.m.k.f26678c);
        L186:
            if (r411 == null) goto L188;
            au<?> r333 = kotlinx.coroutines.i.b(r1119, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.v, this.t, r411, this.y, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        L189:
            r229 = new z.f();
            if (r331 != 0) goto L649;
            ComponentName r334 = r330;
            r1102 = "com.obric.aiagent.plugin";
            r242 = r1117;
            r261 = r0;
            r279 = r301;
            r37 = r320;
            r29 = r278;
            r280 = r1119;
            r178 = r1118;
            r1114 = r318;
            r218 = r334;
            r617 = r319;
            r1103 = r327;
            r227 = r328;
            r1110 = r333;
            r260 = null;
            goto L209
        L649:
            c r335 = this.t;     // Catch: Throwable -> L206
            this.z = r1119;     // Catch: Throwable -> L206
            this.f26579a = r1118;     // Catch: Throwable -> L206
            this.f26580b = r115;     // Catch: Throwable -> L206
            this.f26581c = r301;     // Catch: Throwable -> L206
            this.f26582d = r175;     // Catch: Throwable -> L206
            this.f26583e = r330;     // Catch: Throwable -> L206
            this.f = r278;     // Catch: Throwable -> L206
            r276 = r320;
            this.g = r276;     // Catch: Throwable -> L203
            this.h = r1101;     // Catch: Throwable -> L203
            this.i = r333;     // Catch: Throwable -> L203
            this.j = r229;     // Catch: Throwable -> L203
            long r336 = r1117;
            this.l = r336;     // Catch: Throwable -> L203
            r315 = r330;
            int r337 = r328;
            this.m = r337;     // Catch: Throwable -> L203
            int r338 = r318;
            this.n = r338;     // Catch: Throwable -> L203
            r313 = r338;
            int r339 = r319;
            this.o = r339;     // Catch: Throwable -> L203
            r312 = r339;
            int r340 = r327;
            this.p = r340;     // Catch: Throwable -> L203
            r314 = r340;
            this.q = 2;     // Catch: Throwable -> L203
            r277 = r335.a(r331, this);     // Catch: Throwable -> L203
            r261 = r0;
            if (r277 != r261) goto L196;
            return r261;
        L196:
            r272 = r301;
            r275 = r1119;
            r274 = r1118;
            r273 = r115;
            r1112 = r1101;
            r1111 = r336;
            r267 = r337;
            r268 = r333;
        L203:
            th = th;
        L204:
            r15 = r229;
            r37 = r276;
        L206:
            th = th;
            r276 = r320;
            goto L204
        L188:
            r333 = null;
        L185:
            r411 = null;
        L176:
            r332 = false;
            goto L178
        L168:
            r1101 = null;
        L165:
            r2101 = null;
            goto L166
        L149:
            r327 = r619;
            r328 = r317;
            r329 = r309;
            r330 = r306;
            r331 = null;
            goto L151
        L146:
            r2100 = null;
            goto L147
        L143:
            r320 = null;
        L140:
            r1120 = false;
        L133:
            r619 = 0;
        L128:
            r319 = 0;
        L123:
            r318 = 0;
        L118:
            r317 = 0;
            goto L120
        L104:
            if (r308.a() == true) goto L106;
        L110:
            boolean r341 = false;
        L111:
            if (r341 == false) goto L113;
            r309 = r308;
            goto L115
        L106:
            if (r308.b() == null) goto L110;
            if (o.a(r308.b(), r306) == false) goto L110;
            r341 = true;
        L96:
            com.obric.autogui.agents.vlm.models.a.a.b r342 = this.u;
            if (r342 == null) goto L101;
            ScreenshotTaskInfo r343 = r342.d();
            if (r343 == null) goto L101;
            r308 = d.a(this.v, r343);
        L101:
            r308 = null;
        L88:
            com.obric.autogui.agents.vlm.models.a.a.b r344 = this.u;
            if (r344 == null) goto L91;
            r305 = r344.b();
            goto L87
        L91:
            r306 = null;
        L78:
            com.obric.autogui.agents.vlm.models.a.a.b r345 = this.u;
            if (r345 == null) goto L81;
            r303 = r345.c();
            goto L77
        L81:
            r175 = null;
            goto L82
        L43:
            r26 = "";
            d.o.a(r63);
            r299 = (am) ZeusTransformUtils.preCheckCast(this.z, am.class, "com.obric.aiagent.plugin");
            r296 = AOSystemTools.INSTANCE.bootTimeMillis();
            com.obric.autogui.agents.a.l.c r346 = this.r;
            if (r346 == null) goto L46;
            int r347 = r346.f();
        L47:
            r298 = new AtomicInteger(r347);
            r297 = new z.f();
            com.obric.autogui.agents.a.l.c r1121 = this.r;
            if (r1121 == null) goto L50;
            com.obric.autogui.agents.a.d.c r1122 = r1121.c();
        L52:
            if (this.s.c() == true) goto L56;
            r1122 = null;
        L56:
            if (this.s.c() == true) goto L59;
            this.t.a(com.obric.autogui.agents.a.m.k.f26676a, com.obric.autogui.agents.a.m.l.f26681a);
            this.t.a(com.obric.autogui.agents.a.m.k.f26679d, com.obric.autogui.agents.a.m.l.f26681a);
        L58:
            r3 = ", image_hash_elapsed_ms=";
            r4 = d.TAG;
            r115 = r297;
            r1117 = r296;
            r1118 = r298;
            r301 = r1122;
            goto L70
        L59:
            if (r1122 == null) goto L61;
            this.t.a(com.obric.autogui.agents.a.m.k.f26676a, com.obric.autogui.agents.a.m.l.f26681a);
            this.t.a(com.obric.autogui.agents.a.m.k.f26679d, com.obric.autogui.agents.a.m.l.f26682b);
            goto L58
        L61:
            com.obric.autogui.agents.vlm.models.a.a.b r1123 = this.u;
            if (r1123 == null) goto L64;
            IScreenshot r1124 = r1123.a();
        L65:
            if (r1124 == null) goto L58;
            this.t.a(com.obric.autogui.agents.a.m.k.f26676a, com.obric.autogui.agents.a.m.l.f26682b);
            com.obric.autogui.agents.a.m.n r1125 = this.t.a(com.obric.autogui.agents.a.m.k.f26679d);
            d r1126 = this.v;
            c r1127 = this.t;
            d.h.a.b r1128 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.v, this.u, r298, this.x, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r1129 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.z = r299;
            this.f26579a = r298;
            this.f26580b = r297;
            this.l = r296;
            this.q = 1;
            r300 = d.a(r1126, r1127, r1125, r1128, r1129);
            if (r300 != r0) goto L69;
            return r0;
        L64:
            r1124 = null;
            goto L65
        L50:
            r1122 = null;
            goto L52
        L46:
            r347 = 0;
            goto L47
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L23:
            th = th;
            r20 = "com.obric.aiagent.plugin";
            goto L25
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {671}, d = "captureForegroundTaskFacts", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f26624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f26625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26626d;

        h(d r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26625c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26624b = r3;
            this.f26626d |= Integer.MIN_VALUE;
            return d.a(this.f26625c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureForegroundTaskFacts$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.autogui.agents.a.l.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26627a;

        i(d.c.d<? super i> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.agents.a.l.b> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.agents.a.l.b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f26627a != 0) goto L16;
            d.o.a(r8);
            DisplayedAppInfo r7 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
            String r9 = null;
            if (r7 == null) goto L17;
            int r1 = r7.getTaskId();
            boolean r2 = r7.isVisible();
            ComponentName r3 = r7.getTopActivity();
            ComponentName r0 = r7.getRealActivity();
            if (r0 == null) goto L9;
            String r4 = r0.getPackageName();
        L10:
            ComponentName r10 = r7.getBaseActivity();
            if (r10 == null) goto L14;
            r9 = r10.getPackageName();
        L14:
            return new com.obric.autogui.agents.a.l.b(r1, r2, r3, r4, r9);
        L9:
            r4 = null;
            goto L10
        L17:
            return null;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {524}, d = "captureScreenshot", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f26631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f26632e;
        int f;

        j(d r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26632e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26631d = r3;
            this.f |= Integer.MIN_VALUE;
            return d.a(this.f26632e, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {525}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureScreenshot$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ScreenshotResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f26634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f26635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f26636d;

        k(d r3, String r4, boolean r5, d.c.d<? super k> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26634b = r3;
            this.f26635c = r4;
            this.f26636d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super ScreenshotResult> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f26634b, this.f26635c, this.f26636d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ScreenshotResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26633a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L11:
            return r12;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            com.obric.autogui.agents.vlm.models.a.a r3 = d.b(this.f26634b);
            String r4 = this.f26635c;
            boolean r6 = this.f26636d;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26633a = 1;
            r12 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r3, r4, null, r6, false, r8, 10, null);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {595}, d = "captureViewTree", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f26638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f26639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26640d;

        l(d r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26639c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26638b = r3;
            this.f26640d |= Integer.MIN_VALUE;
            return d.b(this.f26639c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {596}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider$captureViewTree$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ViewHierarchyDump>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26641a;

        m(d.c.d<? super m> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super List<ViewHierarchyDump>> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ViewHierarchyDump>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26641a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L12:
            return ((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            AOSystemTools r11 = AOSystemTools.INSTANCE;
            int r4 = AutoActionVirtualDisplay.INSTANCE.getOperatingDisplayId();
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26641a = 1;
            r10 = AOSystemTools.dumpViewHierarchy$default(r11, r4, false, r6, 2, null);
            if (r10 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ActionEffectSnapshotProvider.kt */
    @d.c.b.a.f(b = "ActionEffectSnapshotProvider.kt", c = {633}, d = "measureCapture", e = "com.obric.autogui.agents.actioneffect.snapshot.ActionEffectSnapshotProvider")
    static final class n<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26645d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f26646e;
        /* synthetic */ Object f;
        final /* synthetic */ d g;
        int h;

        n(d r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return d.a(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f26546a = new b(null);
    }

    /* JADX INFO: renamed from: lambda$itS-pdpy9LpRjemyqYSU4q-FyA8, reason: not valid java name */
    public static /* synthetic */ com.obric.autogui.agents.a.d.c m713lambda$itSpdpy9LpRjemyqYSU4qFyA8(IScreenshot r0) {
        return a(r0);
    }

    public d(com.obric.autogui.agents.vlm.models.a.a r3) {
        com.obric.autogui.agents.vlm.models.a.a r4 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "screenshotProvider");
        this.f26547b = r4;
        this.f26548c = new AtomicInteger(0);
        this.f26549d = new Object();
        this.f26550e = new Object();
    }

    public static final /* synthetic */ long a(d r0, long r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.obric.autogui.agents.a.l.b a(d r0, ScreenshotTaskInfo r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(d r2, c r3, com.obric.autogui.agents.a.m.n r4, d.h.a.b r5, d.c.d r6) {
        return r2.a(r3, r4, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, IScreenshot r3, AtomicInteger r4, String r5, d.c.d r6) {
        return r2.a((IScreenshot) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshot.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, String r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, String r3, String r4, boolean r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicInteger a(d r0) {
        return r0.f26548c;
    }

    public static final /* synthetic */ void a(d r2, String r3, IScreenshot r4) {
        r2.a(r3, (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r4, IScreenshot.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean a(d r0, ScreenshotResult r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.a.a b(d r0) {
        return r0.f26547b;
    }

    public static final /* synthetic */ Object b(d r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(com.obric.autogui.agents.a.a r26, String r27, com.obric.autogui.agents.a.l.a r28, com.obric.autogui.agents.vlm.models.a.a.b r29, com.obric.autogui.agents.a.l.c r30, boolean r31, t r32, com.obric.autogui.agents.a.m.o r33, Integer r34, d.c.d<? super com.obric.autogui.agents.a.l.c> r35) {
        com.obric.autogui.agents.a.l.a r11 = r28;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, f.class) == false) goto L7;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        f r9 = r3;
        Object r4 = r9.f26578e;
        Object r13 = d.c.a.b.a();
        int r5 = r9.g;
        int r6 = 0;
        if (r5 == 0) goto L25;
        if (r5 != 1) goto L24;
        r6 = r9.f26577d;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r9.f26576c, c.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.l.a r7 = (com.obric.autogui.agents.a.l.a) ZeusTransformUtils.preCheckCast(r9.f26575b, com.obric.autogui.agents.a.l.a.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.preCheckCast(r9.f26574a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L14 CancellationException -> L17 de -> L20
        r11 = r7;
    L128:
        com.obric.autogui.agents.a.l.c r0 = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.a.l.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L76 CancellationException -> L78 de -> L80
        if (r6 != 0) goto L122;
    L74:
        r1.a();
        return r0;
    L122:
        r8.c();     // Catch: Throwable -> L64 CancellationException -> L68
    L64:
        th = move-exception;
        r1.a(s.f26713d);     // Catch: Throwable -> L71
        throw th;     // Catch: Throwable -> L71
    L68:
        e = move-exception;
        r1.a(s.f26712c);     // Catch: Throwable -> L71
        throw e;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        r1.a();
        throw th;
    L80:
        e = e;
    L99:
        r1.a(s.f26711b);     // Catch: Throwable -> L103
        if (r6 != 0) goto L102;
        r1.a(r11, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L103
    L102:
        throw e;     // Catch: Throwable -> L103
    L78:
        e = e;
    L95:
        r1.a(s.f26712c);     // Catch: Throwable -> L103
        if (r6 != 0) goto L98;
        r1.a(r11, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L103
    L98:
        throw e;     // Catch: Throwable -> L103
    L76:
        th = th;
    L91:
        r1.a(s.f26713d);     // Catch: Throwable -> L103
        if (r6 != 0) goto L94;
        r1.a(r11, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L103
    L94:
        throw th;     // Catch: Throwable -> L103
    L20:
        e = e;
        r11 = r7;
    L17:
        e = e;
        r11 = r7;
    L14:
        th = th;
        r11 = r7;
        goto L91
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L25:
        d.o.a(r4);
        String r10 = com.obric.autogui.agents.a.c.f26286a.a(r26) + ", capture_stage=" + com.obric.autogui.agents.a.b.a(r27, 0, 1, null);
        if (r32 == 0) goto L28;
        q r12 = r32.a(r33, r27, r34);
    L29:
        c r15 = new c(r32, r12);
        if (r30 != null) goto L130;
    L40:
        boolean r14 = false;
    L42:
        if (r14 == true) goto L88;
        if (r31 == false) goto L48;
        if (com.obric.autogui.agents.a.k.a.f26530a.a() == true) goto L88;
    L48:
        if (b() == true) goto L131;
        r15.a(s.f26713d);     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        r15.a(r11, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] snapshot capture rejected " + r10 + ", reason=provider_closed");     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        com.obric.autogui.agents.a.l.c r16 = new com.obric.autogui.agents.a.l.c(null, null, null, null, false, 1, 24, null);     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        r15.a();
        return r16;
    L131:
        String r17 = r26.b() + '_' + com.obric.autogui.agents.a.b.a(r27, 0, 1, null);     // Catch: Throwable -> L82 CancellationException -> L84 de -> L86
        if (r31 == false) goto L55;
        boolean r18 = true;
    L56:
        r9.f26574a = this;     // Catch: Throwable -> L82 CancellationException -> L84 de -> L86
        r9.f26575b = r11;     // Catch: Throwable -> L82 CancellationException -> L84 de -> L86
        r9.f26576c = r15;     // Catch: Throwable -> L82 CancellationException -> L84 de -> L86
        r9.f26577d = 1;     // Catch: Throwable -> L82 CancellationException -> L84 de -> L86
        r9.g = 1;     // Catch: Throwable -> L82 CancellationException -> L84 de -> L86
        r4 = a(r17, r10, r28, r29, r30, r18, r15, r9);     // Catch: Throwable -> L82 CancellationException -> L84 de -> L86
        if (r4 != r13) goto L59;
        return r13;
    L59:
        r8 = this;
        r6 = 1;
        r1 = r15;
        goto L128
    L55:
        r18 = false;
    L86:
        e = e;
        r6 = 1;
    L39:
        r1 = r15;
    L84:
        e = e;
        r6 = 1;
    L37:
        r1 = r15;
    L82:
        th = th;
        r6 = 1;
    L35:
        r1 = r15;
    L88:
        r15.a(true);     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        r15.a(r11, com.obric.autogui.agents.a.m.l.f26683c);     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] snapshot skipped " + r10 + ", reason=secure_page");     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        com.obric.autogui.agents.a.l.c r19 = com.obric.autogui.agents.a.l.c.f26541a.b();     // Catch: Throwable -> L34 CancellationException -> L36 de -> L38
        r15.a();
        return r19;
    L130:
    L38:
        e = e;
    L36:
        e = e;
    L34:
        th = th;
        goto L35
    L32:
        if (r30.e() != true) goto L40;
        r14 = true;
        goto L42
    L28:
        r12 = null;
    L103:
        th = move-exception;
        if (0 != 0) goto L124;
    L117:
        r32.a();
        throw th;
    L124:
        c();     // Catch: Throwable -> L107 CancellationException -> L111
    L111:
        e = move-exception;
        r32.a(s.f26712c);     // Catch: Throwable -> L114
        throw e;     // Catch: Throwable -> L114
    L107:
        th = move-exception;
        r32.a(s.f26713d);     // Catch: Throwable -> L114
        throw th;     // Catch: Throwable -> L114
    L114:
        th = move-exception;
        r32.a();
        throw th;
    L7:
        r3 = new f(this, r2);
        goto L8
    }

    public static /* synthetic */ Object a(d r13, com.obric.autogui.agents.a.a r14, String r15, com.obric.autogui.agents.a.l.a r16, com.obric.autogui.agents.vlm.models.a.a.b r17, com.obric.autogui.agents.a.l.c r18, boolean r19, t r20, com.obric.autogui.agents.a.m.o r21, Integer r22, d.c.d r23, int r24, Object r25) {
        d.c.d<? super com.obric.autogui.agents.a.l.c> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r24 & 8) == 0) goto L5;
        com.obric.autogui.agents.vlm.models.a.a.b r6 = null;
    L7:
        if ((r24 & 16) == 0) goto L9;
        com.obric.autogui.agents.a.l.c r7 = null;
    L11:
        if ((r24 & 32) == 0) goto L13;
        boolean r8 = true;
    L15:
        if ((r24 & 64) == 0) goto L17;
        t r9 = null;
    L19:
        if ((r24 & 128) == 0) goto L21;
        com.obric.autogui.agents.a.m.o r10 = com.obric.autogui.agents.a.m.o.f26694c;
    L23:
        if ((r24 & 256) == 0) goto L25;
        Integer r11 = null;
    L27:
        return r13.a(r14, r15, r16, r6, r7, r8, r9, r10, r11, r12);
    L25:
        r11 = r22;
        goto L27
    L21:
        r10 = r21;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }

    public final void a() {
        Object r0 = this.f26549d;
        monitor-enter(r0);
        this.g = true;     // Catch: Throwable -> L10
        boolean r1 = d();     // Catch: Throwable -> L10
        monitor-exit(r0);
        if (r1 == false) goto L15;
        e();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final Object a(String r14, String r15, com.obric.autogui.agents.a.l.a r16, com.obric.autogui.agents.vlm.models.a.a.b r17, com.obric.autogui.agents.a.l.c r18, boolean r19, c r20, d.c.d<? super com.obric.autogui.agents.a.l.c> r21) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        return an.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r18, r16, r20, r17, this, r19, r14, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    private final Object a(String r11, String r12, boolean r13, d.c.d<? super a<ScreenshotResult>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r15, j.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f26631d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        IScreenshot r6 = null;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r12 = (String) ZeusTransformUtils.preCheckCast(r0.f26630c, String.class, "com.obric.aiagent.plugin");
        r11 = (String) ZeusTransformUtils.preCheckCast(r0.f26629b, String.class, "com.obric.aiagent.plugin");
        d this = (d) ZeusTransformUtils.preCheckCast(r0.f26628a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
    L24:
        ScreenshotResult r17 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r16, ScreenshotResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
        ce.b(r0.getContext());     // Catch: Throwable -> L27 CancellationException -> L29 de -> L50
        return new a(r17, com.obric.autogui.agents.a.m.l.f26684d);
    L29:
        e = e;
    L40:
        if (r17 == null) goto L42;
        r6 = r17.getPic();
    L42:
        this.a(r11, r6);
        throw e;
    L27:
        th = move-exception;
        ScreenshotResult r18 = r17;
        th = th;
    L33:
        if (r18 == null) goto L35;
        IScreenshot r19 = r18.getPic();
    L36:
        this.a(r11, r19);
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] screenshot capture failed " + r12 + ", error_type=" + th.getClass().getSimpleName());
        return new a(null, com.obric.autogui.agents.a.m.l.g);
    L35:
        r19 = null;
    L45:
        if (r17 == null) goto L47;
        IScreenshot r110 = r17.getPic();
    L48:
        this.a(r11, r110);
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] screenshot capture timeout " + r12 + ", timeout_ms=1500");
        return new a(null, com.obric.autogui.agents.a.m.l.f26685e);
    L47:
        r110 = null;
        goto L48
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r16);
        if (r13 == false) goto L20;
        boolean r111 = true;
    L21:
        d.h.a.m r112 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, r11, r111, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
        r0.f26628a = this;     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
        r0.f26629b = r11;     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
        r0.f26630c = r12;     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
        r0.f = 1;     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
        r16 = dg.a(1500, r112, r0);     // Catch: Throwable -> L31 CancellationException -> L38 de -> L44
        if (r16 != r2) goto L24;
        return r2;
    L20:
        r111 = false;
    L44:
        r17 = null;
    L38:
        e = e;
        r17 = null;
    L31:
        th = th;
        r18 = null;
    L7:
        r0 = new j(this, r15);
        goto L8
    }

    private final Object a(IScreenshot r5, AtomicInteger r6, String r7, d.c.d<? super a<com.obric.autogui.agents.a.d.c>> r8) {
        final IScreenshot r9 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r5, IScreenshot.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, e.class) == false) goto L7;
        e r11 = (e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin");
        if ((r11.f26573d & Integer.MIN_VALUE) == 0) goto L7;
        r11.f26573d -= Integer.MIN_VALUE;
    L8:
        Object r4 = r11.f26571b;
        Object r12 = d.c.a.b.a();
        int r1 = r11.f26573d;
        if (r1 == 0) goto L18;
        if (r1 != 1) goto L17;
        r6 = (AtomicInteger) ZeusTransformUtils.preCheckCast(r11.f26570a, AtomicInteger.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: CancellationException -> L14 Throwable -> L27
    L25:
    L32:
        return new a(r4, com.obric.autogui.agents.a.m.l.f26684d);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r4);
        if (r9 == null) goto L21;
        d.h.a.a r13 = new $$Lambda$d$itSpdpy9LpRjemyqYSU4qFyA8(r9);     // Catch: CancellationException -> L14 Throwable -> L27
        r11.f26570a = r6;     // Catch: CancellationException -> L14 Throwable -> L27
        r11.f26573d = 1;     // Catch: CancellationException -> L14 Throwable -> L27
        r4 = r9.withResourcesLocked(r13, r11);     // Catch: CancellationException -> L14 Throwable -> L27
        if (r4 != r12) goto L25;
        return r12;
    L21:
        return new a(null, com.obric.autogui.agents.a.m.l.f26683c);
    L14:
        e = move-exception;
        throw e;
    L27:
        r6.incrementAndGet();
        return new a(null, com.obric.autogui.agents.a.m.l.g);
    L7:
        r11 = new e(this, r10);
        goto L8
    }

    private static final com.obric.autogui.agents.a.d.c a(IScreenshot r2) {
        Bitmap r3 = ((IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin")).getBitmap();
        return com.obric.autogui.agents.a.d.d.f26364a.a(r3);
    }

    private final Object a(String r9, d.c.d<? super a<List<ViewHierarchyDump>>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, l.class) == false) goto L7;
        l r0 = (l) ZeusTransformUtils.preCheckCast(r11, l.class, "com.obric.aiagent.plugin");
        if ((r0.f26640d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f26640d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f26638b;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f26640d;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r9 = (String) ZeusTransformUtils.preCheckCast(r0.f26637a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
    L20:
    L31:
        return new a(r8, com.obric.autogui.agents.a.m.l.f26684d);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r8);
        d.h.a.m r13 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        r0.f26637a = r9;     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        r0.f26640d = 1;     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        r8 = dg.a(800, r13, r0);     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        if (r8 != r12) goto L20;
        return r12;
    L26:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] viewtree capture timeout " + r9 + ", timeout_ms=800");
        return new a(null, com.obric.autogui.agents.a.m.l.f26685e);
    L24:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] viewtree capture failed " + r9 + ", error_type=" + th.getClass().getSimpleName());
        return new a(null, com.obric.autogui.agents.a.m.l.g);
    L7:
        r0 = new l(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.obric.autogui.agents.a.m.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.obric.autogui.agents.a.l.d$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.obric.autogui.agents.a.l.d$c] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private final <T> Object a(c r9, com.obric.autogui.agents.a.m.n r10, d.h.a.b<? super d.c.d<? super a<T>>, ? extends Object> r11, d.c.d<? super C0669d<T>> r12) {
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, n.class) == false) goto L7;
        n r0 = (n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        ?? r15 = r0.f;
        Object r2 = d.c.a.b.a();
        int r3 = r0.h;
        if (r3 == 0) goto L22;
        if (r3 != 1) goto L21;
        long r8 = r0.f26646e;
        com.obric.autogui.agents.a.m.l r16 = (com.obric.autogui.agents.a.m.l) ZeusTransformUtils.preCheckCast(r0.f26645d, com.obric.autogui.agents.a.m.l.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.m.n r17 = (com.obric.autogui.agents.a.m.n) ZeusTransformUtils.preCheckCast(r0.f26644c, com.obric.autogui.agents.a.m.n.class, "com.obric.aiagent.plugin");
        c r4 = (c) ZeusTransformUtils.preCheckCast(r0.f26643b, c.class, "com.obric.aiagent.plugin");
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.f26642a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L14 CancellationException -> L16 de -> L18
        long r5 = r8;
        d this = r1;
        ?? r18 = r4;
        r10 = r17;
        ?? r19 = r15;
    L26:
        a r110 = (a) ZeusTransformUtils.preCheckCast(r19, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        com.obric.autogui.agents.a.m.l r111 = r110.b();     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        C0669d r6 = new C0669d(r110.a(), this.a(r5));     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        r18.a(r10, r111);
        return r6;
    L35:
        de e2 = e;
    L36:
        com.obric.autogui.agents.a.m.l r112 = com.obric.autogui.agents.a.m.l.f26685e;     // Catch: Throwable -> L38
        throw e2;     // Catch: Throwable -> L38
    L32:
        CancellationException e3 = e;
    L33:
        com.obric.autogui.agents.a.m.l r113 = com.obric.autogui.agents.a.m.l.f;     // Catch: Throwable -> L38
        throw e3;     // Catch: Throwable -> L38
    L29:
        Throwable th = th;
    L30:
        com.obric.autogui.agents.a.m.l r114 = com.obric.autogui.agents.a.m.l.g;     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L18:
        e2 = e;
    L16:
        e3 = e;
    L14:
        th = th;
        goto L30
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        d.o.a(r15);
        r5 = AOSystemTools.INSTANCE.bootTimeMillis();
        com.obric.autogui.agents.a.m.l r115 = com.obric.autogui.agents.a.m.l.g;
        r0.f26642a = this;     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        r0.f26643b = r9;     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        r0.f26644c = r10;     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        r0.f26645d = r115;     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        r0.f26646e = r5;     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        r0.h = 1;     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        Object r116 = r13.invoke(r0);     // Catch: Throwable -> L29 CancellationException -> L32 de -> L35
        r18 = r9;
        r19 = r116;
        if (r116 != r2) goto L26;
        return r2;
    L38:
        th = move-exception;
        r9.a(r10, r15);
        throw th;
    L7:
        r0 = new n(this, r14);
        goto L8
    }

    private final boolean a(ScreenshotResult r4) {
        if (r4 == null) goto L4;
        ScreenshotResult.Status r3 = r4.getStatus();
    L6:
        if (r3 == ScreenshotResult.Status.ContainsSecure) goto L13;
        if (r4 == null) goto L9;
        int r5 = r4.getFlags();
    L11:
        if ((r5 & 1) != 0) goto L13;
        return false;
    L9:
        r5 = 0;
    L13:
        return true;
    L4:
        r3 = null;
        goto L6
    }

    private final long a(long r3) {
        return d.l.n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r3, 0);
    }

    private final Object b(String r9, d.c.d<? super a<com.obric.autogui.agents.a.l.b>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r11, h.class, "com.obric.aiagent.plugin");
        if ((r0.f26626d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f26626d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f26624b;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f26626d;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r9 = (String) ZeusTransformUtils.preCheckCast(r0.f26623a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
    L20:
    L31:
        return new a(r8, com.obric.autogui.agents.a.m.l.f26684d);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r8);
        d.h.a.m r13 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        r0.f26623a = r9;     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        r0.f26626d = 1;     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        r8 = dg.a(800, r13, r0);     // Catch: Throwable -> L22 CancellationException -> L24 de -> L26
        if (r8 != r12) goto L20;
        return r12;
    L26:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] foreground task capture timeout " + r9 + ", timeout_ms=800");
        return new a(null, com.obric.autogui.agents.a.m.l.f26685e);
    L24:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] foreground task capture failed " + r9 + ", error_type=" + th.getClass().getSimpleName());
        return new a(null, com.obric.autogui.agents.a.m.l.g);
    L7:
        r0 = new h(this, r11);
        goto L8
    }

    private final com.obric.autogui.agents.a.l.b a(ScreenshotTaskInfo r7) {
        int r1 = r7.getTaskId();
        boolean r2 = r7.isVisible();
        ComponentName r3 = r7.getTopComponent();
        ComponentName r0 = r7.getRealComponent();
        if (r0 == null) goto L5;
        String r5 = r0.getPackageName();
    L6:
        ComponentName r8 = r7.getBaseComponent();
        if (r8 == null) goto L9;
        String r9 = r8.getPackageName();
    L11:
        return new com.obric.autogui.agents.a.l.b(r1, r2, r3, r5, r9);
    L9:
        r9 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    private final boolean b() {
        Object r0 = this.f26549d;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.g == false) goto L7;
        r2 = false;
    L8:
        monitor-exit(r0);
        return r2;
    L7:
        this.f++;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private final void c() {
        Object r0 = this.f26549d;
        monitor-enter(r0);
        this.f--;     // Catch: Throwable -> L9
        boolean r1 = d();     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r1 == false) goto L14;
        e();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final boolean d() {
        if (this.g == true) goto L5;
        return false;
    L5:
        if (this.f <= 0) goto L7;
        return false;
    L7:
        if (this.h == false) goto L9;
        return false;
    L9:
        if (this.i == true) goto L17;
        this.h = true;
        return true;
    L17:
        return false;
    }

    private final void a(String r6, IScreenshot r7) {
        IScreenshot r8 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r7, IScreenshot.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L19
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Object r1 = r5.f26550e;     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        IScreenshot r9 = r5.f26547b.a(r6);     // Catch: Throwable -> L16
        if (r9 == null) goto L9;
        r8 = r9;
    L9:
        if (r8 != null) goto L11;
    L13:
        x r10 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L19
        Object r11 = d.n.f(x.f38692a);     // Catch: Throwable -> L19
    L21:
        Throwable r12 = d.n.c(r11);
        if (r12 == null) goto L28;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] screenshot release failed, capture_id=" + com.obric.autogui.agents.a.b.a(r6, 0, 1, null) + ", error_type=" + r12.getClass().getSimpleName());
        return;
    L28:
        return;
    L11:
        if (r8.getBitmap().isRecycled() == true) goto L13;
        r8.release();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L21
    }

    private final void e() {
        z.a r0 = new z.a();
        int r2 = 0;
    L4:
        if (r2 >= 3) goto L24;
        if (r0.f38499a == true) goto L23;
        int r3 = r2 + 1;
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L17
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Object r6 = r5.f26550e;     // Catch: Throwable -> L17
        monitor-enter(r6);     // Catch: Throwable -> L17
        r5.f26547b.e();     // Catch: Throwable -> L14
        x r7 = x.f38692a;     // Catch: Throwable -> L14
        monitor-exit(r6);     // Catch: Throwable -> L17
        Object r8 = d.n.f(x.f38692a);     // Catch: Throwable -> L17
    L19:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L22;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] snapshot provider cleanup failed, attempt=" + r3 + "/3, error_type=" + r9.getClass().getSimpleName());
    L22:
        r0.f38499a = d.n.a(r8);
        goto L23
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
    L23:
        r2 = r2 + 1;
        goto L4
    L24:
        Object r11 = this.f26549d;
        monitor-enter(r11);
        this.h = false;     // Catch: Throwable -> L36
        if (r0.f38499a == false) goto L29;
        this.i = true;     // Catch: Throwable -> L36
    L29:
        x r12 = x.f38692a;     // Catch: Throwable -> L36
        monitor-exit(r11);
        if (r0.f38499a == false) goto L34;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] snapshot provider closed, all screenshots released");
        return;
    L34:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] snapshot provider cleanup unresolved, attempts=3");
        return;
    L36:
        th = move-exception;
        throw th;
    }
}
