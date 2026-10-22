package com.obric.autogui.agents.scripted.impl;

import android.content.Context;
import com.bytedance.vmsdk.worker.JsWorker;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.resourcemanage.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ad;
import d.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JSScriptServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JSScriptServiceImpl implements IJSScriptService {
    public static final a Companion = null;
    private static final String TAG = "JSScriptServiceImpl";
    private static final d.f<JSScriptServiceImpl> instance$delegate = null;
    private final d.f decryptorPool$delegate;
    private final d.f moduleReader$delegate;
    private final d.f preCheckExecutor$delegate;
    private final d.f resourceDownloader$delegate;
    private final d.f workerPoolManager$delegate;

    /* JADX INFO: compiled from: JSScriptServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: JSScriptServiceImpl.kt */
    @d.c.b.a.f(b = "JSScriptServiceImpl.kt", c = {110}, d = "getSupportedAbilityList", e = "com.obric.autogui.agents.scripted.impl.JSScriptServiceImpl")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f26953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSScriptServiceImpl f26954e;
        int f;

        b(JSScriptServiceImpl r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26954e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26953d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f26954e.getSupportedAbilityList(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JSScriptServiceImpl.kt */
    @d.c.b.a.f(b = "JSScriptServiceImpl.kt", c = {152}, d = "getSupportedAbilityListInternal", e = "com.obric.autogui.agents.scripted.impl.JSScriptServiceImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26959e;
        Object f;
        Object g;
        Object h;
        long i;
        /* synthetic */ Object j;
        final /* synthetic */ JSScriptServiceImpl k;
        int l;

        c(JSScriptServiceImpl r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.j = r7;
            this.l |= Integer.MIN_VALUE;
            return JSScriptServiceImpl.access$getSupportedAbilityListInternal(this.k, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JSScriptServiceImpl.kt */
    @d.c.b.a.f(b = "JSScriptServiceImpl.kt", c = {59, 64}, d = "onFoundationReady", e = "com.obric.autogui.agents.scripted.impl.JSScriptServiceImpl")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f26962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSScriptServiceImpl f26963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f26964e;

        d(JSScriptServiceImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26963d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26962c = r3;
            this.f26964e |= Integer.MIN_VALUE;
            return this.f26963d.onFoundationReady(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JSScriptServiceImpl.kt */
    /* synthetic */ class e extends d.h.b.l implements d.h.a.a<x> {
        e(Object r8) {
            super(0, r8, JSScriptServiceImpl.class, "invalidateRuntimeCaches", "invalidateRuntimeCaches()V", 0);
        }

        public final void a() {
            JSScriptServiceImpl.access$invalidateRuntimeCaches((JSScriptServiceImpl) ZeusTransformUtils.preCheckCast(this.receiver, JSScriptServiceImpl.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: JSScriptServiceImpl.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.a<x> {
        f(Object r8) {
            super(0, r8, JSScriptServiceImpl.class, "invalidateRuntimeCaches", "invalidateRuntimeCaches()V", 0);
        }

        public final void a() {
            JSScriptServiceImpl.access$invalidateRuntimeCaches((JSScriptServiceImpl) ZeusTransformUtils.preCheckCast(this.receiver, JSScriptServiceImpl.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: lambda$GX_3-gu1tw19ectjeKB0R7a_E8o, reason: not valid java name */
    public static /* synthetic */ JSScriptServiceImpl m721lambda$GX_3gu1tw19ectjeKB0R7a_E8o() {
        return instance_delegate$lambda$14();
    }

    /* JADX INFO: renamed from: lambda$KvZ_-UwNOH4l5Zlj0P4_4XD0gik, reason: not valid java name */
    public static /* synthetic */ Set m722lambda$KvZ_UwNOH4l5Zlj0P4_4XD0gik(String r0) {
        return getSupportedAbilityListInternal$lambda$10(r0);
    }

    public static /* synthetic */ p lambda$LlIOyHFxo8HNs71NsWfHKI66ZMc(JSScriptServiceImpl r0) {
        return moduleReader_delegate$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$NR7D1rOfc5zuk-fVO7AUDHri4tc, reason: not valid java name */
    public static /* synthetic */ com.obric.autogui.agents.scripted.impl.e m723lambda$NR7D1rOfc5zukfVO7AUDHri4tc() {
        return workerPoolManager_delegate$lambda$0();
    }

    public static /* synthetic */ s lambda$U7iH7af_NWYWvYwv4TKei5pbW5k(JSScriptServiceImpl r0) {
        return resourceDownloader_delegate$lambda$4(r0);
    }

    /* JADX INFO: renamed from: lambda$Umoe9X4758zj1jZTFviUei-usiA, reason: not valid java name */
    public static /* synthetic */ o m724lambda$Umoe9X4758zj1jZTFviUeiusiA() {
        return decryptorPool_delegate$lambda$2();
    }

    public static /* synthetic */ r lambda$Xgt3n3KYRDfVomKgBdel9C58SIc(JSScriptServiceImpl r0) {
        return preCheckExecutor_delegate$lambda$1(r0);
    }

    public JSScriptServiceImpl() {
        this.workerPoolManager$delegate = d.g.a($$Lambda$JSScriptServiceImpl$NR7D1rOfc5zukfVO7AUDHri4tc.INSTANCE);
        this.preCheckExecutor$delegate = d.g.a(new $$Lambda$JSScriptServiceImpl$Xgt3n3KYRDfVomKgBdel9C58SIc(this));
        this.decryptorPool$delegate = d.g.a($$Lambda$JSScriptServiceImpl$Umoe9X4758zj1jZTFviUeiusiA.INSTANCE);
        this.moduleReader$delegate = d.g.a(new $$Lambda$JSScriptServiceImpl$LlIOyHFxo8HNs71NsWfHKI66ZMc(this));
        this.resourceDownloader$delegate = d.g.a(new $$Lambda$JSScriptServiceImpl$U7iH7af_NWYWvYwv4TKei5pbW5k(this));
        onInit();
    }

    public static final /* synthetic */ d.f access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public static final /* synthetic */ Object access$getSupportedAbilityListInternal(JSScriptServiceImpl r8, Context r9, Set r10, String r11, q r12, d.c.d r13) {
        return r8.getSupportedAbilityListInternal((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin"), r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$invalidateRuntimeCaches(JSScriptServiceImpl r0) {
        r0.invalidateRuntimeCaches();
    }

    static {
        Companion = new a(null);
        instance$delegate = d.g.a($$Lambda$JSScriptServiceImpl$GX_3gu1tw19ectjeKB0R7a_E8o.INSTANCE);
    }

    private static final JSScriptServiceImpl instance_delegate$lambda$14() {
        return new JSScriptServiceImpl();
    }

    private final com.obric.autogui.agents.scripted.impl.e getWorkerPoolManager() {
        return (com.obric.autogui.agents.scripted.impl.e) ZeusTransformUtils.preCheckCast(this.workerPoolManager$delegate.b(), com.obric.autogui.agents.scripted.impl.e.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.agents.scripted.impl.e workerPoolManager_delegate$lambda$0() {
        return new com.obric.autogui.agents.scripted.impl.e();
    }

    private final r getPreCheckExecutor() {
        return (r) ZeusTransformUtils.preCheckCast(this.preCheckExecutor$delegate.b(), r.class, "com.obric.aiagent.plugin");
    }

    private static final r preCheckExecutor_delegate$lambda$1(JSScriptServiceImpl r1) {
        return new r(r1.getWorkerPoolManager());
    }

    private static final o decryptorPool_delegate$lambda$2() {
        return new o();
    }

    private final o getDecryptorPool() {
        return (o) ZeusTransformUtils.preCheckCast(this.decryptorPool$delegate.b(), o.class, "com.obric.aiagent.plugin");
    }

    private final p getModuleReader() {
        return (p) ZeusTransformUtils.preCheckCast(this.moduleReader$delegate.b(), p.class, "com.obric.aiagent.plugin");
    }

    private static final p moduleReader_delegate$lambda$3(JSScriptServiceImpl r1) {
        return new p(r1.getDecryptorPool());
    }

    private final s getResourceDownloader() {
        return (s) ZeusTransformUtils.preCheckCast(this.resourceDownloader$delegate.b(), s.class, "com.obric.aiagent.plugin");
    }

    private static final s resourceDownloader_delegate$lambda$4(JSScriptServiceImpl r4) {
        return new s((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r4), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.scripted.api.b
    public Object onFoundationReady(Context r7, d.c.d<? super x> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin");
        if ((r0.f26964e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f26964e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f26962c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f26964e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r11);
    L27:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (Context) ZeusTransformUtils.preCheckCast(r0.f26961b, Context.class, "com.obric.aiagent.plugin");
        JSScriptServiceImpl this = (JSScriptServiceImpl) ZeusTransformUtils.preCheckCast(r0.f26960a, JSScriptServiceImpl.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L20:
        if (this.isScriptEnable() == false) goto L22;
        this.ensureRuntimePoolsInitialized();
        com.obric.autogui.agents.scripted.impl.e r6 = this.getWorkerPoolManager();
        r0.f26960a = null;
        r0.f26961b = null;
        r0.f26964e = 2;
        if (r6.onFoundationReady(r9, r0) != r2) goto L27;
        return r2;
    L22:
        return x.f38692a;
    L16:
        d.o.a(r11);
        s r12 = getResourceDownloader();
        r0.f26960a = this;
        r0.f26961b = r9;
        r0.f26964e = 1;
        if (r12.onFoundationReady(r9, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new d(this, r10);
        goto L8
    }

    public void onInit() {
        getResourceDownloader().a();
        if (isScriptEnable() == false) goto L6;
        ensureRuntimePoolsInitialized();
        return;
    }

    private final void ensureRuntimePoolsInitialized() {
        getWorkerPoolManager().a();
        getDecryptorPool().a();
    }

    private final void invalidateRuntimeCaches() {
        getWorkerPoolManager().b();
        getDecryptorPool().b();
        l.f27011a.b();
    }

    @Override // com.obric.autogui.agents.scripted.api.IJSScriptService
    public boolean isScriptEnable() {
        return com.obric.autogui.agents.scripted.c.b.f26918a.a();
    }

    @Override // com.obric.autogui.agents.scripted.api.IJSScriptService
    public Object getSupportedAbilityList(Context r10, Set<String> r11, String r12, d.c.d<? super List<com.obric.autogui.agents.scripted.api.a>> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f & Integer.MIN_VALUE) == 0) goto L7;
        r15.f -= Integer.MIN_VALUE;
    L8:
        b r7 = r15;
        Object r16 = r7.f26953d;
        Object r17 = d.c.a.b.a();
        int r18 = r7.f;
        if (r18 == 0) goto L18;
        if (r18 != 1) goto L17;
        com.obric.autogui.agents.scripted.b.b r9 = (com.obric.autogui.agents.scripted.b.b) ZeusTransformUtils.preCheckCast(r7.f26952c, com.obric.autogui.agents.scripted.b.b.class, "com.obric.aiagent.plugin");
        q r19 = (q) ZeusTransformUtils.preCheckCast(r7.f26951b, q.class, "com.obric.aiagent.plugin");
        JSScriptServiceImpl r110 = (JSScriptServiceImpl) ZeusTransformUtils.preCheckCast(r7.f26950a, JSScriptServiceImpl.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: Throwable -> L14
        com.obric.autogui.agents.scripted.b.b r111 = r9;
        JSScriptServiceImpl this = r110;
    L38:
        List r112 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        this.reportPreCheckTelemetry(r19, r111);
        return r112;
    L30:
        Throwable th = th;
    L34:
        this.reportPreCheckTelemetry(r19, r111);
        throw th;
    L14:
        th = th;
        r111 = r9;
        this = r110;
        goto L34
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r16);
        if (isScriptEnable() == false) goto L21;
        ensureRuntimePoolsInitialized();
        q r113 = new q("script_pre_check_performance").a("session_id", r12).a(w.f27103a.a());
        r111 = new com.obric.autogui.agents.scripted.b.b(com.obric.autogui.agents.scripted.c.a.f26915a.a("script_precheck_memory_snapshot", r12, 0), null, 2, null);
        r111.a();
        r7.f26950a = this;     // Catch: Throwable -> L32
        r7.f26951b = r113;     // Catch: Throwable -> L32
        r7.f26952c = r111;     // Catch: Throwable -> L32
        r7.f = 1;     // Catch: Throwable -> L32
        Object r114 = getSupportedAbilityListInternal(r3, r4, r12, r113, r7);     // Catch: Throwable -> L32
        if (r114 != r17) goto L26;
        return r17;
    L26:
        r19 = r113;
        r16 = r114;
    L32:
        th = move-exception;
        r19 = r113;
        th = th;
        goto L34
    L21:
        return d.a.p.b();
    L7:
        r15 = new b(this, r14);
        goto L8
    }

    private final Object getSupportedAbilityListInternal(Context r30, Set<String> r31, String r32, q r33, d.c.d<? super List<com.obric.autogui.agents.scripted.api.a>> r34) {
        JSScriptServiceImpl r0 = this;
        q r9 = r33;
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.aiagent.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r31, Set.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r34, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r2.l & Integer.MIN_VALUE) == 0) goto L7;
        r2.l -= Integer.MIN_VALUE;
    L8:
        c r13 = r2;
        Object r3 = r13.j;
        Object r14 = d.c.a.b.a();
        int r4 = r13.l;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r5 = r13.i;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r13.h, String.class, "com.obric.aiagent.plugin");
        q r7 = (q) ZeusTransformUtils.preCheckCast(r13.g, q.class, "com.obric.aiagent.plugin");
        m r8 = (m) ZeusTransformUtils.preCheckCast(r13.f, m.class, "com.obric.aiagent.plugin");
        q r10 = (q) ZeusTransformUtils.preCheckCast(r13.f26959e, q.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r13.f26958d, String.class, "com.obric.aiagent.plugin");
        Set r16 = (Set) ZeusTransformUtils.preCheckCast(r13.f26957c, Set.class, "com.obric.aiagent.plugin");
        r11 = (Context) ZeusTransformUtils.preCheckCast(r13.f26956b, Context.class, "com.obric.aiagent.plugin");
        JSScriptServiceImpl r17 = (JSScriptServiceImpl) ZeusTransformUtils.preCheckCast(r13.f26955a, JSScriptServiceImpl.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L14
        Set r23 = r16;
        m r18 = r8;
        r0 = r17;
    L38:
        com.obric.autogui.agents.scripted.a.i r19 = (com.obric.autogui.agents.scripted.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.scripted.a.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r7.a(r6, System.currentTimeMillis() - r5);
        r0.putPreCheckStatusFields(r10.a("is_worker_cache_hit", d.c.b.a.b.a(r19.b())), r19);
        List<String> r20 = r19.a();
        if (r20.isEmpty() == false) goto L43;
        r10.a("ability_count", d.c.b.a.b.a(0));
        return d.a.p.b();
    L43:
        long r110 = System.currentTimeMillis();
        List<com.obric.autogui.agents.scripted.api.a> r21 = r0.getModuleReader().a(r11, r18, r15);     // Catch: Throwable -> L51
        r10.a("get_manifest", System.currentTimeMillis() - r110);
        List r22 = k.a(k.f27010a, r21, (Set) ZeusTransformUtils.preCheckCast(d.a.p.n((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin"), r23, r19.d(), $$Lambda$JSScriptServiceImpl$KvZ_UwNOH4l5Zlj0P4_4XD0gik.INSTANCE, null, 32, null);
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r24, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r26 = r24.iterator();
    L47:
        if (r26.hasNext() == false) goto L49;
        r25.add(((com.obric.autogui.agents.scripted.api.a) ZeusTransformUtils.preCheckCast(r26.next(), com.obric.autogui.agents.scripted.api.a.class, "com.obric.aiagent.plugin")).b());
        goto L47
    L49:
        r10.a("ability_list", (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin")).a("ability_count", d.c.b.a.b.a(r22.size()));
        return r22;
    L51:
        th = move-exception;
        r10.a("get_manifest", System.currentTimeMillis() - r110);
        throw th;
    L14:
        th = th;
        r9 = r7;
    L56:
        r9.a(r6, System.currentTimeMillis() - r5);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r3);
        long r27 = System.currentTimeMillis();
        p.b r28 = getModuleReader().b(r11, r32);     // Catch: Throwable -> L64
        r9.a("get_script_engine", System.currentTimeMillis() - r27);
        String r111 = r28.a();
        m r29 = getModuleReader().a(r11, "com.obric.ability.script");
        long r112 = System.currentTimeMillis();
        String r113 = "get_bundle_file";
        r18 = r29;
        p.b r35 = getModuleReader().a(r11, r29, "com.obric.ability.script", "pre-check-bundle.js", (com.obric.autogui.resourcemanage.s) ZeusTransformUtils.preCheckCast(new com.obric.autogui.resourcemanage.s.a("pre-check-bundle.js"), com.obric.autogui.resourcemanage.s.class, "com.obric.aiagent.plugin"), r32);     // Catch: Throwable -> L58
        r9.a(r113, System.currentTimeMillis() - r112);
        String r36 = r35.a();
        if (ZeusTransformUtils.instanceOf(r28, p.b.c.class) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r35, p.b.c.class) == true) goto L29;
    L32:
        long r114 = System.currentTimeMillis();
        r r37 = getPreCheckExecutor();     // Catch: Throwable -> L54
        r13.f26955a = r0;     // Catch: Throwable -> L54
        r13.f26956b = r11;     // Catch: Throwable -> L54
        r13.f26957c = r12;     // Catch: Throwable -> L54
        r13.f26958d = r32;     // Catch: Throwable -> L54
        r13.f26959e = r9;     // Catch: Throwable -> L54
        r13.f = r18;     // Catch: Throwable -> L54
        r13.g = r9;     // Catch: Throwable -> L54
        r13.h = "pre_check_script";     // Catch: Throwable -> L54
        r13.i = r114;     // Catch: Throwable -> L54
        r13.l = 1;     // Catch: Throwable -> L54
        r3 = r37.a(r11, r111, r36, r32, r13);     // Catch: Throwable -> L54
        if (r3 != r14) goto L37;
        return r14;
    L37:
        r6 = "pre_check_script";
        r15 = r32;
        r7 = r9;
        r10 = r7;
        r23 = r12;
        r5 = r114;
    L54:
        th = th;
        r6 = "pre_check_script";
        r5 = r114;
    L29:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L31;
        Loog.INSTANCE.d(TAG, "Resources missing (engine=" + ZeusTransformUtils.instanceOf(r28, p.b.c.class) + ", bundle=" + ZeusTransformUtils.instanceOf(r35, p.b.c.class) + "), triggering download");
    L31:
        getResourceDownloader().a(r11, com.obric.autogui.resourcemanage.k.g);
    L58:
        th = th;
    L62:
        r9.a(r113, System.currentTimeMillis() - r112);
        throw th;
    L60:
        th = th;
        r113 = "get_bundle_file";
    L64:
        th = move-exception;
        r9.a("get_script_engine", System.currentTimeMillis() - r27);
        throw th;
    L7:
        r2 = new c(r0, r1);
        goto L8
    }

    private static final Set getSupportedAbilityListInternal$lambda$10(String r2) {
        d.h.b.o.e(r2, "ability");
        return (Set) ZeusTransformUtils.preCheckCast(d.a.p.n((Iterable) ZeusTransformUtils.preCheckCast(l.f27011a.a(r2), Iterable.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    }

    private final void reportPreCheckTelemetry(q r4, com.obric.autogui.agents.scripted.b.b r5) {
        r5.a("precheck_end");
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r5.a(r0, "precheck_end", "end");
        r4.a(r0);
        r4.a();
    }

    @Override // com.obric.autogui.agents.scripted.api.IJSScriptService
    public String getMainJSCodeByAbility(Context r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "context");
        d.h.b.o.e(r13, "ability");
        if (isScriptEnable() == true) goto L5;
        return null;
    L5:
        ensureRuntimePoolsInitialized();
        m r0 = getModuleReader().a(r14, "com.obric.ability.script");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(p.a(getModuleReader(), r14, r0, null, 4, null), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (d.h.b.o.a(((com.obric.autogui.agents.scripted.api.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.scripted.api.a.class, "com.obric.aiagent.plugin")).b(), r13) == false) goto L7;
    L12:
        com.obric.autogui.agents.scripted.api.a r4 = (com.obric.autogui.agents.scripted.api.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.scripted.api.a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L15;
        String r5 = r4.a();
    L16:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L26;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "No script found for ability: " + r13);
        return null;
    L26:
        ad r15 = ad.f38485a;
        String r8 = String.format("scripts/%s/main.js", Arrays.copyOf(new Object[]{r5}, 1));
        d.h.b.o.c(r8, "format(...)");
        return p.a(getModuleReader(), r14, r0, "com.obric.ability.script", r8, (com.obric.autogui.resourcemanage.s) ZeusTransformUtils.preCheckCast(new com.obric.autogui.resourcemanage.s.a(r8), com.obric.autogui.resourcemanage.s.class, "com.obric.aiagent.plugin"), null, 32, null).a();
    L19:
        if (r6.length() == 0) goto L22;
        r7 = false;
        goto L23
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    }

    @Override // com.obric.autogui.agents.scripted.api.IJSScriptService
    public String getScriptEngine(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        if (isScriptEnable() == true) goto L5;
        return null;
    L5:
        ensureRuntimePoolsInitialized();
        return getModuleReader().b(r4, null).a();
    }

    @Override // com.obric.autogui.agents.scripted.api.IJSScriptService
    public JsWorker getScriptJSWorker(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        if (isScriptEnable() == true) goto L6;
        return null;
    L6:
        ensureRuntimePoolsInitialized();
        return getWorkerPoolManager().b(r4);
    }

    @Override // com.obric.autogui.agents.scripted.api.IJSScriptService
    public com.obric.autogui.resourcemanage.n clearLocalResource(Context r8, String r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r9, "packageName");
        com.obric.autogui.resourcemanage.n r10 = ac.a(ac.f30597a, r1, r9, null, null, 12, null);
        if (com.obric.autogui.agents.scripted.impl.c.a(r9) == false) goto L5;
        invalidateRuntimeCaches();
    L5:
        return r10;
    }

    private final q putPreCheckStatusFields(q r1, com.obric.autogui.agents.scripted.a.i r2) {
        r1.a("init_status", r2.c());
        return r1;
    }

    @Override // com.obric.autogui.agents.scripted.api.IJSScriptService
    public void requestResourceRecoveryOnScriptStartFailed(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "Script start failed, requesting resource recovery check");
    L5:
        getResourceDownloader().a(r5, com.obric.autogui.resourcemanage.k.h);
    }
}
