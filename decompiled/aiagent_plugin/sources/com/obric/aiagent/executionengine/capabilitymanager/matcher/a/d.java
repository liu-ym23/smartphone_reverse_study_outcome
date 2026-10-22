package com.obric.aiagent.executionengine.capabilitymanager.matcher.a;

import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.aa;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.ad;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.ae;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.af;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.y;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: KDocAppFunctionCapabilitySource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.obric.aiagent.executionengine.capabilitymanager.matcher.b {
    private static final String TAG = "KDocAppFunctionSource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Boolean> f16489b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final x.a f16490c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f16491d = null;

    /* JADX INFO: compiled from: KDocAppFunctionCapabilitySource.kt */
    @f(b = "KDocAppFunctionCapabilitySource.kt", c = {86}, d = "filterEntries", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.KDocAppFunctionCapabilitySource")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f16495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f16496e;
        /* synthetic */ Object f;
        final /* synthetic */ d g;
        int h;

        a(d r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return d.a(this.g, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: KDocAppFunctionCapabilitySource.kt */
    @f(b = "KDocAppFunctionCapabilitySource.kt", c = {ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId}, d = "getAppFunctionSkills$execution_engine_impl_release", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.KDocAppFunctionCapabilitySource")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f16498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16499c;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16498b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16497a = r3;
            this.f16499c |= Integer.MIN_VALUE;
            return this.f16498b.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: KDocAppFunctionCapabilitySource.kt */
    @f(b = "KDocAppFunctionCapabilitySource.kt", c = {96}, d = "isAuthorized", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.KDocAppFunctionCapabilitySource")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f16502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16503d;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16502c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16501b = r3;
            this.f16503d |= Integer.MIN_VALUE;
            return d.a(this.f16502c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.matcher.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KDocAppFunctionCapabilitySource.kt */
    static final class C0335d implements x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0335d f16504a = null;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.matcher.a.d$d$a */
        /* JADX INFO: compiled from: KDocAppFunctionCapabilitySource.kt */
        @f(b = "KDocAppFunctionCapabilitySource.kt", c = {40, 46, 48}, d = "onRefreshSucceeded", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.KDocAppFunctionCapabilitySource$refreshListener$1")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f16505a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f16506b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ C0335d f16507c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f16508d;

            a(C0335d r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f16507c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f16506b = r3;
                this.f16508d |= Integer.MIN_VALUE;
                return this.f16507c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            f16504a = new C0335d();
        }

        C0335d() {
        }

        @Override // com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x.a
        public final Object a(List<m> r9, d.c.d<? super d.x> r10) {
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r12, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin");
            if ((r0.f16508d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f16508d -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.f16506b;
            Object r13 = d.c.a.b.a();
            int r2 = r0.f16508d;
            if (r2 == 0) goto L18;
            if (r2 == 1) goto L17;
            if (r2 == 2) goto L16;
            if (r2 != 3) goto L15;
            o.a(r8);
        L34:
            return d.x.f38692a;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            List<ad> r14 = (List) ZeusTransformUtils.preCheckCast(r0.f16505a, List.class, "com.obric.aiagent.plugin");
            o.a(r8);
        L30:
            af r15 = af.f18217a;
            r0.f16505a = null;
            r0.f16508d = 3;
            if (r15.a(r14, r0) != r13) goto L34;
            return r13;
        L17:
            o.a(r8);
        L21:
            r14 = ae.f18213a.a((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"));
            Set r16 = p.q((Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a.f16409a.a().c(), Iterable.class, "com.obric.aiagent.plugin"));
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r4 = r3.iterator();
        L23:
            if (r4.hasNext() == false) goto L27;
            Object r6 = r4.next();
            if (r16.contains(((ad) ZeusTransformUtils.preCheckCast(r6, ad.class, "com.obric.aiagent.plugin")).a()) == true) goto L23;
            r5.add(r6);
            goto L23
        L27:
            List<ad> r17 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
            aa r1 = aa.f18198a;
            r0.f16505a = r14;
            r0.f16508d = 2;
            if (r1.a(r17, r0) != r13) goto L30;
            return r13;
        L18:
            o.a(r8);
            d r18 = d.f16488a;
            r0.f16508d = 1;
            r8 = d.a(r18, r11, r0);
            if (r8 != r13) goto L21;
            return r13;
        L7:
            r0 = new a(this, r12);
            goto L8
        }
    }

    /* JADX INFO: compiled from: KDocAppFunctionCapabilitySource.kt */
    @f(b = "KDocAppFunctionCapabilitySource.kt", c = {59, 60}, d = "snapshot", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.KDocAppFunctionCapabilitySource")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f16511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16512d;

        e(d r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16511c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16510b = r3;
            this.f16512d |= Integer.MIN_VALUE;
            return this.f16511c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$0Y3q-NNbNU-Uy-ZfyiHse1wQGwk, reason: not valid java name */
    public static /* synthetic */ boolean m161lambda$0Y3qNNbNUUyZfyiHse1wQGwk(Set r0, m r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$gxpWCetB6Jpn5bkdwl9rffJ6vhE(m r0) {
        return a(r0);
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, List r3, d.c.d r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f16488a = new d();
        f16489b = new ConcurrentHashMap();
        f16490c = (x.a) ZeusTransformUtils.preCheckCast(C0335d.f16504a, x.a.class, "com.obric.aiagent.plugin");
        f16491d = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16400b;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return f16491d;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void a() {
        x.f18310a.a(f16490c);
        x.f18310a.a();
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public Object a(d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b>> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r13, e.class, "com.obric.aiagent.plugin");
        if ((r0.f16512d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16512d -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f16510b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16512d;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r14);
    L22:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r11.iterator();
    L24:
        if (r16.hasNext() == false) goto L27;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r16.next(), m.class, "com.obric.aiagent.plugin");
        r15.add(new com.obric.aiagent.executionengine.capabilitymanager.api.a.b(com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16400b, r1.e(), r1.c(), r1.d(), null, 16, null));
        goto L24
    L27:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d this = (d) ZeusTransformUtils.preCheckCast(r0.f16509a, d.class, "com.obric.aiagent.plugin");
        o.a(r14);
    L19:
        List<m> r17 = x.f18310a.c();
        r0.f16509a = null;
        r0.f16512d = 2;
        r14 = this.a(r17, r0);
        if (r14 != r2) goto L22;
        return r2;
    L16:
        o.a(r14);
        x r18 = x.f18310a;
        r0.f16509a = this;
        r0.f16512d = 1;
        if (r18.a(800, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new e(this, r13);
        goto L8
    }

    public final Object b(d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c>> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if ((r0.f16499c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16499c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16497a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16499c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r8);
    L17:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(ae.f18213a.a((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        y r9 = y.f18329a;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r5.iterator();
    L19:
        if (r10.hasNext() == false) goto L24;
        com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c r4 = r9.a((ad) ZeusTransformUtils.preCheckCast(r10.next(), ad.class, "com.obric.aiagent.plugin"));
        if (r4 == null) goto L19;
        r1.add(r4);
        goto L19
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        List<m> r11 = x.f18310a.c();
        r0.f16499c = 1;
        r8 = a(r11, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new b(this, r7);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void b() {
        x.f18310a.b();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x011f -> B:25:0x0123). Please report as a decompilation issue!!! */
    private final Object a(List<m> r10, d.c.d<? super List<m>> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f;
        Object r2 = d.c.a.b.a();
        int r3 = r0.h;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r0.f16496e, String.class, "com.obric.aiagent.plugin");
        Iterator r15 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f16495d, Iterator.class, "com.obric.aiagent.plugin");
        final Set r4 = (Set) ZeusTransformUtils.preCheckCast(r0.f16494c, Set.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r0.f16493b, List.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.preCheckCast(r0.f16492a, d.class, "com.obric.aiagent.plugin");
        o.a(r14);
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L28;
        r4.add(r9);
    L28:
        d this = r6;
    L20:
        if (r15.hasNext() == false) goto L30;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        r0.f16492a = this;
        r0.f16493b = r5;
        r0.f16494c = r4;
        r0.f16495d = r15;
        r0.f16496e = r16;
        r0.h = 1;
        Object r7 = this.a(r16, r0);
        if (r7 != r2) goto L24;
        return r2;
    L24:
        r6 = this;
        r9 = r16;
        r14 = r7;
        goto L26
    L30:
        return d.n.m.g(d.n.m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")), new $$Lambda$d$0Y3qNNbNUUyZfyiHse1wQGwk(r4)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r14);
        List r17 = d.n.m.g(d.n.m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$d$gxpWCetB6Jpn5bkdwl9rffJ6vhE.INSTANCE));
        Set r18 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r20 = r8.iterator();
    L16:
        if (r20.hasNext() == false) goto L18;
        r19.add(((m) ZeusTransformUtils.preCheckCast(r20.next(), m.class, "com.obric.aiagent.plugin")).c());
        goto L16
    L18:
        Iterator r21 = p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r5 = r17;
        r15 = r21;
        r4 = r18;
    L7:
        r0 = new a(this, r13);
        goto L8
    }

    private static final boolean a(m r1) {
        d.h.b.o.e(r1, "it");
        if (r1.a() == null) goto L5;
    L7:
        return false;
    L5:
        if (r1.b() != null) goto L7;
        return true;
    }

    private static final boolean a(Set r2, m r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return r4.contains(r3.c());
    }

    private final Object a(String r6, d.c.d<? super Boolean> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");
        if ((r0.f16503d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16503d -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f16501b;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f16503d;
        boolean r4 = true;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L19;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.f16500a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);     // Catch: Exception -> L14 CancellationException -> L16
    L27:
        boolean r10 = !((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L30:
        if (r10 == true) goto L32;
        ILogDepend.Companion.w(TAG, "filter virus AppFunctions, package=" + r6);
    L32:
        Boolean r11 = (Boolean) ZeusTransformUtils.preCheckCast(f16489b.putIfAbsent(r6, d.c.b.a.b.a(r10)), Boolean.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L35;
        r4 = r11.booleanValue();
    L39:
        return d.c.b.a.b.a(r4);
    L35:
        if (r10 == true) goto L39;
        r4 = false;
        goto L39
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        o.a(r5);
        Boolean r12 = (Boolean) ZeusTransformUtils.preCheckCast(f16489b.get(r6), Boolean.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L23;
        IAutoActionSecurityApi r13 = AOPlatformTools.INSTANCE.security();     // Catch: Exception -> L14 CancellationException -> L16
        r0.f16500a = r6;     // Catch: Exception -> L14 CancellationException -> L16
        r0.f16503d = 1;     // Catch: Exception -> L14 CancellationException -> L16
        r5 = r13.checkVirus(r6, r0);     // Catch: Exception -> L14 CancellationException -> L16
        if (r5 != r9) goto L27;
        return r9;
    L23:
        return d.c.b.a.b.a(r12.booleanValue());
    L16:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "checkVirus failed, allow package=" + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r10 = true;
    L7:
        r0 = new c(this, r8);
        goto L8
    }
}
