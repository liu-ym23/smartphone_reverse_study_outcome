package com.obric.agent.trace.omni;

import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/* JADX INFO: compiled from: OmniReportStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static final String TAG = "OmniReportStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f15686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f15687b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final j f15688c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ReentrantLock> f15689d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f15690e = null;

    /* JADX INFO: compiled from: OmniReportStore.kt */
    static final class a implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ d.h.a.b f15691a;

        a(d.h.a.b r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "function");
            this.f15691a = r4;
        }

        @Override // java.util.function.Function
        public final /* synthetic */ Object apply(Object r1) {
            return this.f15691a.invoke(r1);
        }
    }

    /* JADX INFO: compiled from: OmniReportStore.kt */
    public static final class b implements d.h.a.b<String, ReentrantLock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15692a = null;

        static {
            f15692a = new b();
        }

        public b() {
        }

        public final ReentrantLock a(String r1) {
            d.h.b.o.e(r1, "it");
            return new ReentrantLock();
        }

        @Override // d.h.a.b
        public /* synthetic */ ReentrantLock invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ com.obric.agent.trace.omni.a lambda$1OehjVTvFFT5U0tIlMR8EnOf7K8(String r0, d.h.a.b r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ x lambda$8lDdVSzpYT40qFCWQ9cuRmsLtCs(String r0, Map r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ List lambda$H19WCUgylT_9_mJrAOJ8kXD_enc(d.h.a.m r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$MxPSZT83hAUOxNw7xhXTdbIbucM(String r0) {
        return g(r0);
    }

    /* JADX INFO: renamed from: lambda$Qtk-YKdPAjNMbFY-Vs4C1dzYAo0, reason: not valid java name */
    public static /* synthetic */ com.obric.agent.trace.omni.a m109lambda$QtkYKdPAjNMbFYVs4C1dzYAo0(String r0) {
        return h(r0);
    }

    public static /* synthetic */ List lambda$ULKhPGgzBH17623dQykQDPmDwuo(Object r0, String r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Boolean lambda$fruslPL3HqcRCXemv2la3VNhc9w(String r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ com.obric.agent.trace.omni.a lambda$l5zWPLADMoQ6__pjDWvzw_3FxwU(String r0, d.h.a.b r1) {
        return d(r0, r1);
    }

    private k() {
    }

    static {
        f15686a = new k();
        f15687b = new g();
        f15688c = j.f15674a;
        f15689d = new ConcurrentHashMap();
        f15690e = new ConcurrentHashMap();
    }

    public final void a(final String r3, Map<String, ? extends Object> r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "messageId");
        d.h.b.o.e(r5, "params");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        ISecureLogDepend.Companion.w(TAG, "accept ignored: messageId is blank");
        return;
    L9:
        a("accept", r3, new $$Lambda$k$8lDdVSzpYT40qFCWQ9cuRmsLtCs(r3, r5));
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static final x b(String r5, Map r6) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        k r0 = f15686a;
        ReentrantLock r2 = f15689d.computeIfAbsent(r5, (Function) ZeusTransformUtils.preCheckCast(new a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f15692a, d.h.a.b.class, "com.obric.aiagent.plugin")), Function.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r2, "computeIfAbsent(...)");
        Lock r1 = (Lock) ZeusTransformUtils.preCheckCast((ReentrantLock) ZeusTransformUtils.preCheckCast(r2, ReentrantLock.class, "com.obric.aiagent.plugin"), Lock.class, "com.obric.aiagent.plugin");
        r1.lock();
    L13:
        th = move-exception;
        r1.unlock();
        throw th;
    L4:
        if (r0.e(r5) == false) goto L6;
        ISecureLogDepend.Companion.i(TAG, "accept ignored: messageId already finished, messageId=" + r5);     // Catch: Throwable -> L13
    L10:
        x r8 = x.f38692a;     // Catch: Throwable -> L13
        r1.unlock();
        return x.f38692a;
    L6:
        f r3 = r0.c(r5);     // Catch: Throwable -> L13
        if (r3 != null) goto L9;
        r3 = f15687b.a(r5);     // Catch: Throwable -> L13
    L9:
        r0.a(r3, r7);     // Catch: Throwable -> L13
        r0.a(r5, r3);     // Catch: Throwable -> L13
        goto L10
    }

    public final com.obric.agent.trace.omni.a a(final String r3, d.h.a.b<? super com.obric.agent.trace.omni.a, ? extends Map<String, ? extends Object>> r4) {
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "messageId");
        d.h.b.o.e(r5, "updateBlock");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        ISecureLogDepend.Companion.w(TAG, "updateAndGetSnapshot ignored: messageId is blank");
        return null;
    L10:
        return (com.obric.agent.trace.omni.a) ZeusTransformUtils.preCheckCast(a("updateAndGetSnapshot", r3, new $$Lambda$k$1OehjVTvFFT5U0tIlMR8EnOf7K8(r3, r5)), com.obric.agent.trace.omni.a.class, "com.obric.aiagent.plugin");
    L5:
        r0 = false;
        goto L6
    }

    private static final com.obric.agent.trace.omni.a c(String r6, d.h.a.b r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        k r0 = f15686a;
        ReentrantLock r2 = f15689d.computeIfAbsent(r6, (Function) ZeusTransformUtils.preCheckCast(new a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f15692a, d.h.a.b.class, "com.obric.aiagent.plugin")), Function.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r2, "computeIfAbsent(...)");
        Lock r3 = (Lock) ZeusTransformUtils.preCheckCast((ReentrantLock) ZeusTransformUtils.preCheckCast(r2, ReentrantLock.class, "com.obric.aiagent.plugin"), Lock.class, "com.obric.aiagent.plugin");
        r3.lock();
        com.obric.agent.trace.omni.a r4 = null;
        if (r0.e(r6) == false) goto L6;
        ISecureLogDepend.Companion.i(TAG, "updateAndGetSnapshot ignored: messageId already finished, messageId=" + r6);     // Catch: Throwable -> L26
    L24:
        r3.unlock();
        return r4;
    L6:
        f r5 = r0.c(r6);     // Catch: Throwable -> L26
        if (r5 == null) goto L9;
        com.obric.agent.trace.omni.a r9 = r0.a(r5, r6);     // Catch: Throwable -> L26
    L10:
        Map<String, ? extends Object> r10 = (Map) ZeusTransformUtils.preCheckCast(r8.invoke(r9), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r10 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == true) goto L21;
        if (r5 != null) goto L20;
        r5 = f15687b.a(r6);     // Catch: Throwable -> L26
    L20:
        r0.a(r5, r10);     // Catch: Throwable -> L26
        r0.a(r6, r5);     // Catch: Throwable -> L26
    L21:
        f r11 = r0.c(r6);     // Catch: Throwable -> L26
        if (r11 == null) goto L24;
        r4 = r0.a(r11, r6);     // Catch: Throwable -> L26
        goto L24
    L13:
        if (r10.isEmpty() == true) goto L16;
        r1 = false;
        goto L17
    L9:
        r9 = null;
    L26:
        th = move-exception;
        r3.unlock();
        throw th;
    }

    public final boolean a(final String r5) {
        d.h.b.o.e(r5, "messageId");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        ISecureLogDepend.Companion.w(TAG, "isMessageIdExist ignored: messageId is blank");
        return false;
    L10:
        if (d(r5) == false) goto L12;
        return true;
    L12:
        if (d.h.b.o.a(a("isMessageIdExist", r5, new $$Lambda$k$MxPSZT83hAUOxNw7xhXTdbIbucM(r5)), true) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    private static final boolean g(String r5) {
        k r0 = f15686a;
        ReentrantLock r1 = f15689d.computeIfAbsent(r5, (Function) ZeusTransformUtils.preCheckCast(new a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f15692a, d.h.a.b.class, "com.obric.aiagent.plugin")), Function.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r1, "computeIfAbsent(...)");
        Lock r2 = (Lock) ZeusTransformUtils.preCheckCast((ReentrantLock) ZeusTransformUtils.preCheckCast(r1, ReentrantLock.class, "com.obric.aiagent.plugin"), Lock.class, "com.obric.aiagent.plugin");
        r2.lock();
        if (r0.c(r5) == null) goto L6;
        boolean r6 = true;
    L7:
        r2.unlock();
        return r6;
    L6:
        r6 = false;
    L9:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    public final boolean a(final String r4, final String r5) {
        d.h.b.o.e(r4, "messageId");
        d.h.b.o.e(r5, "key");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        ISecureLogDepend.Companion.w(TAG, "bucketContains ignored: messageId is blank");
        return false;
    L10:
        if (d(r4) == false) goto L12;
        return true;
    L12:
        if (d.h.b.o.a(a("bucketContains", r4, new $$Lambda$k$fruslPL3HqcRCXemv2la3VNhc9w(r4, r5)), true) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    private static final Boolean b(String r5, String r6) {
        k r0 = f15686a;
        ReentrantLock r1 = f15689d.computeIfAbsent(r5, (Function) ZeusTransformUtils.preCheckCast(new a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f15692a, d.h.a.b.class, "com.obric.aiagent.plugin")), Function.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r1, "computeIfAbsent(...)");
        Lock r2 = (Lock) ZeusTransformUtils.preCheckCast((ReentrantLock) ZeusTransformUtils.preCheckCast(r1, ReentrantLock.class, "com.obric.aiagent.plugin"), Lock.class, "com.obric.aiagent.plugin");
        r2.lock();
        f r7 = r0.c(r5);     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        ConcurrentHashMap<String, List<Object>> r8 = r7.a();     // Catch: Throwable -> L12
        if (r8 == null) goto L9;
        Boolean r9 = Boolean.valueOf(r8.containsKey(r6));     // Catch: Throwable -> L12
    L10:
        r2.unlock();
        return r9;
    L9:
        r9 = null;
    L12:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    public final com.obric.agent.trace.omni.a b(final String r4) {
        d.h.b.o.e(r4, "messageId");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        ISecureLogDepend.Companion.w(TAG, "snapshot ignored: messageId is blank");
        return null;
    L10:
        return (com.obric.agent.trace.omni.a) ZeusTransformUtils.preCheckCast(a("snapshot", r4, new $$Lambda$k$QtkYKdPAjNMbFYVs4C1dzYAo0(r4)), com.obric.agent.trace.omni.a.class, "com.obric.aiagent.plugin");
    L5:
        r0 = false;
        goto L6
    }

    private static final com.obric.agent.trace.omni.a h(String r5) {
        k r0 = f15686a;
        ReentrantLock r1 = f15689d.computeIfAbsent(r5, (Function) ZeusTransformUtils.preCheckCast(new a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f15692a, d.h.a.b.class, "com.obric.aiagent.plugin")), Function.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r1, "computeIfAbsent(...)");
        Lock r2 = (Lock) ZeusTransformUtils.preCheckCast((ReentrantLock) ZeusTransformUtils.preCheckCast(r1, ReentrantLock.class, "com.obric.aiagent.plugin"), Lock.class, "com.obric.aiagent.plugin");
        r2.lock();
        f r3 = r0.c(r5);     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        com.obric.agent.trace.omni.a r6 = r0.a(r3, r5);     // Catch: Throwable -> L10
    L8:
        r2.unlock();
        return r6;
    L7:
        r6 = null;
    L10:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    public final com.obric.agent.trace.omni.a b(final String r3, d.h.a.b<? super com.obric.agent.trace.omni.a, ? extends Map<String, ? extends Object>> r4) {
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "messageId");
        d.h.b.o.e(r5, "updateBlock");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        ISecureLogDepend.Companion.w(TAG, "drainWithUpdate ignored: messageId is blank");
        return null;
    L10:
        return (com.obric.agent.trace.omni.a) ZeusTransformUtils.preCheckCast(a("drainWithUpdate", r3, new $$Lambda$k$l5zWPLADMoQ6__pjDWvzw_3FxwU(r3, r5)), com.obric.agent.trace.omni.a.class, "com.obric.aiagent.plugin");
    L5:
        r0 = false;
        goto L6
    }

    private static final com.obric.agent.trace.omni.a d(String r9, d.h.a.b r10) {
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        k r0 = f15686a;
        ReentrantLock r2 = f15689d.computeIfAbsent(r9, (Function) ZeusTransformUtils.preCheckCast(new a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f15692a, d.h.a.b.class, "com.obric.aiagent.plugin")), Function.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r2, "computeIfAbsent(...)");
        Lock r3 = (Lock) ZeusTransformUtils.preCheckCast((ReentrantLock) ZeusTransformUtils.preCheckCast(r2, ReentrantLock.class, "com.obric.aiagent.plugin"), Lock.class, "com.obric.aiagent.plugin");
        r3.lock();
    L26:
        th = move-exception;
        r3.unlock();
        throw th;
    L4:
        com.obric.agent.trace.omni.a r4 = null;
        if (r0.e(r9) == false) goto L7;
        ISecureLogDepend.Companion.i(TAG, "drainWithUpdate ignored: messageId already finished, messageId=" + r9);     // Catch: Throwable -> L26
    L24:
        r3.unlock();
        return r4;
    L7:
        f r5 = r0.c(r9);     // Catch: Throwable -> L26
        if (r5 == null) goto L24;
        Map<String, ? extends Object> r12 = (Map) ZeusTransformUtils.preCheckCast(r11.invoke(r0.a(r5, r9)), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r12 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        r0.a(r5, r12);     // Catch: Throwable -> L26
    L19:
        r4 = r0.a(r5, r9);     // Catch: Throwable -> L26
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L26
        ((Map) ZeusTransformUtils.preCheckCast(f15690e, Map.class, "com.obric.aiagent.plugin")).put(r9, Long.valueOf(r7));     // Catch: Throwable -> L26
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.a(r9, r7), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L26
    L21:
        if (r13.hasNext() == false) goto L23;
        f15690e.remove((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        goto L21
    L23:
        f15687b.d(r9);     // Catch: Throwable -> L26
        f15689d.remove(r9);     // Catch: Throwable -> L26
        ISecureLogDepend.Companion.i(TAG, "drainWithUpdate success, messageId=" + r9 + ", timelineSize=" + r4.c().size());     // Catch: Throwable -> L26
        goto L24
    L13:
        if (r12.isEmpty() == true) goto L16;
        r6 = false;
        goto L17
    }

    private static final List a(d.h.a.m r2, Object r3, Object r4) {
        return (List) ZeusTransformUtils.preCheckCast(((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin")).invoke(r3, r4), List.class, "com.obric.aiagent.plugin");
    }

    private static final List a(Object r2, String r3, List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<unused var>");
        if (r5 != null) goto L5;
        r5 = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.aiagent.plugin");
    L5:
        r5.add(r2);
        return r5;
    }

    private final f c(String r5) {
        g r0 = f15687b;
        f r1 = r0.b(r5);
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (e(r5) == false) goto L8;
        return null;
    L8:
        j.c r4 = f15688c.a(r5);
        if (r4 != null) goto L11;
        return null;
    L11:
        r0.a(r5, r4.a(), r4.b());
        ISecureLogDepend.Companion.i(TAG, "getBucketLocked restored persisted bucket, messageId=" + r5);
        return r4.a();
    }

    private final void a(String r5, f r6) {
        Long r1 = f15687b.c(r5);
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L21:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L8
        k r4 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        j r7 = f15688c;     // Catch: Throwable -> L8
        r7.a(r5, r6, r2);     // Catch: Throwable -> L8
        Object r8 = d.n.f(r7.b(r5));     // Catch: Throwable -> L8
    L10:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L13;
        ISecureLogDepend.Companion.e(TAG, "persistBucket failed, messageId=" + r5, r9);
    L13:
        List r10 = d.a.p.b();
        if (d.n.b(r8) == false) goto L16;
        r8 = r10;
    L16:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        f15687b.d(r12);
        f15689d.remove(r12);
        goto L18
    L20:
        return;
    L8:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L10
    L5:
        r2 = System.currentTimeMillis();
        goto L21
    }

    private final boolean d(String r2) {
        if (f15690e.containsKey(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (f(r2) == true) goto L8;
        return false;
    }

    private final boolean e(String r2) {
        if (f15690e.containsKey(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (f(r2) == true) goto L8;
        return false;
    }

    private final List<String> a(String r4, long r5) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        k r3 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = d.n.f(f15688c.a(r4, r5));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = d.n.c(r6);
        if (r7 == null) goto L10;
        ISecureLogDepend.Companion.e(TAG, "markFinished failed, messageId=" + r4, r7);
    L10:
        List r8 = d.a.p.b();
        if (d.n.b(r6) == false) goto L14;
        r6 = r8;
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L7
    }

    private final boolean f(String r6) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        k r5 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r7 = d.n.f(Boolean.valueOf(f15688c.c(r6)));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r7);
        if (r2 == null) goto L11;
        ISecureLogDepend.Companion.e(TAG, "isFinished failed, messageId=" + r6, r2);
    L11:
        if (d.n.b(r7) == false) goto L14;
        r7 = false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L7
    }

    private final <T> T a(String r3, String r4, d.h.a.a<? extends T> r5) {
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L5
        T r7 = (T) d.n.f(r2.invoke());
    L7:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L11;
        ISecureLogDepend.Companion.e(TAG, r3 + " failed, messageId=" + r4, r8);
    L11:
        if (d.n.b(r7) == false) goto L16;
        return null;
    L16:
        return r7;
    L5:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = (T) d.n.f(d.o.a(th));
        goto L7
    }

    private final com.obric.agent.trace.omni.a a(f r7, String r8) {
        HashMap r6 = new HashMap(r7.a().size());
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(r7.a(), Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")).put(r3, d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return new com.obric.agent.trace.omni.a(r8, (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin"), d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r7.b(), Iterable.class, "com.obric.aiagent.plugin")));
    }

    private final void a(f r6, Map<String, ? extends Object> r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Iterator r8 = r5.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        final Object r3 = r1.getValue();
        ConcurrentHashMap<String, List<Object>> r4 = r6.a();
        final d.h.a.m r9 = new $$Lambda$k$ULKhPGgzBH17623dQykQDPmDwuo(r3);
        r4.compute(r2, new $$Lambda$k$H19WCUgylT_9_mJrAOJ8kXD_enc(r9));
        goto L4
    L6:
        r6.b().add(new e(r5));
    }
}
