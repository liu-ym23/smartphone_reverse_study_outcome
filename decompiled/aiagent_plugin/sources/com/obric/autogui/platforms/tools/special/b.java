package com.obric.autogui.platforms.tools.special;

import android.app.IScreenShotTickCallback;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ScreenShotTickManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "ScreenShotTick";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f30568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f30569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<IAutoActionSpecialApi.ScreenShotTickToken, C0828b> f30570c;

    /* JADX INFO: compiled from: ScreenShotTickManager.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.special.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScreenShotTickManager.kt */
    private static final class C0828b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f30571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f30572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final w<IAutoActionSpecialApi.ScreenShotTickResult> f30573c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0828b.class) == true) goto L8;
            return false;
        L8:
            C0828b r10 = (C0828b) ZeusTransformUtils.preCheckCast(r9, C0828b.class, "com.obric.aiagent.plugin");
            if (this.f30571a == r10.f30571a) goto L12;
            return false;
        L12:
            if (this.f30572b == r10.f30572b) goto L15;
            return false;
        L15:
            if (o.a(this.f30573c, r10.f30573c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f30571a) * 31) + Long.hashCode(this.f30572b)) * 31) + this.f30573c.hashCode();
        }

        public String toString() {
            return "Entry(startedAtMillis=" + this.f30571a + ", waitMillis=" + this.f30572b + ", deferred=" + this.f30573c + ')';
        }

        public C0828b(long r3, long r5, w<IAutoActionSpecialApi.ScreenShotTickResult> r7) {
            w<IAutoActionSpecialApi.ScreenShotTickResult> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.aiagent.plugin");
            o.e(r8, "deferred");
            this.f30571a = r3;
            this.f30572b = r5;
            this.f30573c = r8;
        }

        public /* synthetic */ C0828b(long r7, long r9, w r11, int r12, h r13) {
            w r5 = (w) ZeusTransformUtils.wrapperContextForParams(r11, w.class, "com.obric.aiagent.plugin");
            if ((r12 & 2) == 0) goto L5;
            long r3 = r7;
        L6:
            this(r7, r3, r5);
            return;
        L5:
            r3 = r9;
            goto L6
        }

        public final long a() {
            return this.f30571a;
        }

        public final void a(long r1) {
            this.f30572b = r1;
        }

        public final long b() {
            return this.f30572b;
        }

        public final w<IAutoActionSpecialApi.ScreenShotTickResult> c() {
            return this.f30573c;
        }
    }

    /* JADX INFO: compiled from: ScreenShotTickManager.kt */
    @f(b = "ScreenShotTickManager.kt", c = {152}, d = "awaitTick", e = "com.obric.autogui.platforms.tools.special.ScreenShotTickManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f30577d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f30578e;
        final /* synthetic */ b f;
        int g;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f30578e = r4;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScreenShotTickManager.kt */
    @f(b = "ScreenShotTickManager.kt", c = {153}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.special.ScreenShotTickManager$awaitTick$awaited$1")
    static final class d extends l implements m<am, d.c.d<? super IAutoActionSpecialApi.ScreenShotTickResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C0828b f30580b;

        d(C0828b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30580b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super IAutoActionSpecialApi.ScreenShotTickResult> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30580b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IAutoActionSpecialApi.ScreenShotTickResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30579a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<IAutoActionSpecialApi.ScreenShotTickResult> r6 = this.f30580b.c();
            d.c.d<? super IAutoActionSpecialApi.ScreenShotTickResult> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30579a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f30568a = new a(null);
    }

    public b() {
        this.f30569b = new AtomicInteger(0);
        this.f30570c = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap a(b r0) {
        return r0.f30570c;
    }

    public final IAutoActionSpecialApi.ScreenShotTickToken a(String r22, int r23, String r24) {
        o.e(r22, "packageName");
        final IAutoActionSpecialApi.ScreenShotTickToken r11 = new IAutoActionSpecialApi.ScreenShotTickToken(n.c(this.f30569b.incrementAndGet(), 0), r22);
        long r13 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.i(TAG, "[registerTick] start, token=" + r11 + ", paramInt=" + r23 + ", paramString=" + r24);
        ((Map) ZeusTransformUtils.preCheckCast(this.f30570c, Map.class, "com.obric.aiagent.plugin")).put(r11, new C0828b(r13, 0, y.a(null, 1, null), 2, null));
        IScreenShotTickCallback.Stub r0 = new ScreenShotTickManager$registerTick$cb$1(r11, this);
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L9
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        com.obric.autogui.platforms.tools.internal.a.f r4 = com.obric.autogui.platforms.tools.internal.a.f.f30329a;     // Catch: Throwable -> L9
        int r12 = r11.getRequestId();     // Catch: Throwable -> L9
        String r14 = r11.getPackageName();     // Catch: Throwable -> L9
        IScreenShotTickCallback r1 = (IScreenShotTickCallback) ZeusTransformUtils.preCheckCast(r0, IScreenShotTickCallback.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        String r15 = "com.obric.aiagent.plugin";
        IAutoActionSpecialApi.ScreenShotTickToken r16 = null;
        String r17 = TAG;
        String r18 = ", paramString=";
        String r20 = ", paramInt=";
        Object r5 = d.n.f(Boolean.valueOf(r4.a(r12, r14, r23, r24, r1)));     // Catch: Throwable -> L7
    L12:
        Throwable r6 = d.n.c(r5);
        if (r6 == null) goto L17;
        this.f30570c.remove(r11);
        Loog.INSTANCE.e(r17, "[registerTick] failed, token=" + r11, r6);
        r5 = false;
    L17:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, r15)).booleanValue() == true) goto L20;
        this.f30570c.remove(r11);
        Loog.INSTANCE.w(r17, "[registerTick] method not found or register failed, token=" + r11);
        return r16;
    L20:
        Loog.INSTANCE.i(r17, "[registerTick] end, token=" + r11 + r20 + r23 + r18 + r24);
        return r11;
    L7:
        th = th;
    L11:
        d.n.a r7 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
    L9:
        th = th;
        r15 = "com.obric.aiagent.plugin";
        r16 = null;
        r17 = TAG;
        r18 = ", paramString=";
        r20 = ", paramInt=";
        goto L11
    }

    public final Object a(IAutoActionSpecialApi.ScreenShotTickToken r28, long r29, d.c.d<? super IAutoActionSpecialApi.ScreenShotTickResult> r31) {
        b r0 = this;
        IAutoActionSpecialApi.ScreenShotTickToken r1 = r28;
        long r2 = r29;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L7;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        if ((r6.g & Integer.MIN_VALUE) == 0) goto L7;
        r6.g -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f30578e;
        Object r7 = d.c.a.b.a();
        int r8 = r6.g;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        long r3 = r6.f30577d;
        C0828b r9 = (C0828b) ZeusTransformUtils.preCheckCast(r6.f30576c, C0828b.class, "com.obric.aiagent.plugin");
        IAutoActionSpecialApi.ScreenShotTickToken r10 = (IAutoActionSpecialApi.ScreenShotTickToken) ZeusTransformUtils.preCheckCast(r6.f30575b, IAutoActionSpecialApi.ScreenShotTickToken.class, "com.obric.aiagent.plugin");
        b r11 = (b) ZeusTransformUtils.preCheckCast(r6.f30574a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        C0828b r12 = r9;
        r1 = r10;
        r2 = r3;
        r0 = r11;
        Object r13 = r5;
    L23:
        IAutoActionSpecialApi.ScreenShotTickResult r14 = (IAutoActionSpecialApi.ScreenShotTickResult) ZeusTransformUtils.preCheckCast(r13, IAutoActionSpecialApi.ScreenShotTickResult.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "[awaitTick] end, token=" + r1 + ", timeoutMillis=" + r2);
        r0.f30570c.remove(r1);
        if (r14 == null) goto L27;
        return r14;
    L27:
        return new IAutoActionSpecialApi.ScreenShotTickResult(IAutoActionSpecialApi.ScreenShotTickStatus.Timeout, r12.b() - r12.a(), AOSystemTools.INSTANCE.nowTimeMillis() - r12.a(), r1.getRequestId(), r1.getPackageName(), -1, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        r12 = (C0828b) ZeusTransformUtils.preCheckCast(r0.f30570c.get(r1), C0828b.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L17;
        r12.a(AOSystemTools.INSTANCE.nowTimeMillis());
    L17:
        if (r12 == null) goto L19;
        Loog.INSTANCE.i(TAG, "[awaitTick] start, token=" + r1 + ", timeoutMillis=" + r2);
        m r15 = (m) ZeusTransformUtils.preCheckCast(new d(r12, null), m.class, "com.obric.aiagent.plugin");
        r6.f30574a = r0;
        r6.f30575b = r1;
        r6.f30576c = r12;
        r6.f30577d = r2;
        r6.g = 1;
        r13 = dg.b(r2, r15, r6);
        if (r13 != r7) goto L23;
        return r7;
    L19:
        return new IAutoActionSpecialApi.ScreenShotTickResult(IAutoActionSpecialApi.ScreenShotTickStatus.Error, 0, 0, r28.getRequestId(), r28.getPackageName(), -1, null);
    L7:
        r6 = new c(r0, r4);
        goto L8
    }
}
