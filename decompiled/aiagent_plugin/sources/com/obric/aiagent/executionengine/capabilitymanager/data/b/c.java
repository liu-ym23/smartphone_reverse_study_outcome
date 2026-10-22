package com.obric.aiagent.executionengine.capabilitymanager.data.b;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: IntentRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "IntentRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16441a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f16442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f16443c;

    /* JADX INFO: compiled from: IntentRepo.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: IntentRepo.kt */
    @d.c.b.a.f(b = "IntentRepo.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.capabilitymanager.data.repo.IntentRepo$queryEnabledIntent$2")
    static final class b extends l implements m<am, d<? super List<? extends com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f16445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16446c;

        b(c r3, String r4, d<? super b> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f16445b = r3;
            this.f16446c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d<? super List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f16445b, this.f16446c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super List<? extends com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f16444a != 0) goto L7;
            o.a(r2);
            return c.a(this.f16445b).b(this.f16446c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f16441a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$_-8ysJVBg1fXhjNMeuXbCe-un54, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.authentication.license.a m159lambda$_8ysJVBg1fXhjNMeuXbCeun54() {
        return f();
    }

    public static /* synthetic */ com.obric.aiagent.authentication.a lambda$hgQ30sG_EXWbpsinlzPArgCIcbY() {
        return e();
    }

    public c() {
        this.f16442b = g.a($$Lambda$c$hgQ30sG_EXWbpsinlzPArgCIcbY.INSTANCE);
        this.f16443c = g.a($$Lambda$c$_8ysJVBg1fXhjNMeuXbCeun54.INSTANCE);
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.capabilitymanager.data.a.a a(c r0) {
        return r0.b();
    }

    private final com.obric.aiagent.executionengine.capabilitymanager.data.a.a b() {
        return com.obric.aiagent.executionengine.capabilitymanager.data.a.a.f16428a.a();
    }

    private final com.obric.aiagent.authentication.a c() {
        return (com.obric.aiagent.authentication.a) ZeusTransformUtils.preCheckCast(this.f16442b.b(), com.obric.aiagent.authentication.a.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final com.obric.aiagent.authentication.a e() {
        if (d.h.b.o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_NERIDA) == true) goto L7;
        if (d.h.b.o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_NERIDA_LITE) == true) goto L7;
    L10:
        if (d.h.b.o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_NERIDA) == false) goto L12;
    L26:
        String r0 = "security_policies/release-keys_n1_authorized_apps.json";
    L27:
        com.obric.aiagent.authentication.b r4 = null;
        com.obric.aiagent.authentication.a r1 = new com.obric.aiagent.authentication.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, 2, 0 == true ? 1 : 0);
        r1.a(p.a("security_policies/intent_register.json"), r0);
        return r1;
    L12:
        if (d.h.b.o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_NERIDA_LITE) == true) goto L26;
        if (d.h.b.o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_PIKE) == false) goto L20;
        if (d.h.b.o.a(Build.TAGS, "test-keys") == false) goto L20;
        r0 = "security_policies/test-keys_pike_authorized_apps.json";
    L20:
        if (d.h.b.o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_PIKE) == false) goto L23;
        r0 = "security_policies/release-keys_pike_authorized_apps.json";
        goto L27
    L23:
        if (d.h.b.o.a(Build.TAGS, "test-keys") == false) goto L25;
        r0 = "security_policies/test-keys_authorized_apps.json";
        goto L27
    L25:
        r0 = "security_policies/release-keys_authorized_apps.json";
    L7:
        if (d.h.b.o.a(Build.TAGS, "test-keys") == false) goto L10;
        r0 = "security_policies/test-keys_n1_authorized_apps.json";
        goto L27
    }

    private final com.obric.aiagent.authentication.license.a d() {
        return (com.obric.aiagent.authentication.license.a) ZeusTransformUtils.preCheckCast(this.f16443c.b(), com.obric.aiagent.authentication.license.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.authentication.license.a f() {
        return com.obric.aiagent.authentication.license.a.f16384a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public final List<String> a() {
        return b().a();
    }

    public final List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "packages");
        return b().a(r4);
    }

    public final Object a(com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r7, d<? super d.m<Integer, String>> r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r10 = b().a(r7.e());
        if (r10 != null) goto L5;
    L8:
        Object r11 = a(r7);
        String r1 = null;
        if (n.b(r11) == false) goto L15;
        Integer r12 = d.c.b.a.b.a(111);
        Throwable r13 = n.c(r11);
        if (r13 == null) goto L14;
        r1 = r13.getMessage();
    L14:
        return new d.m(r12, r1);
    L15:
        long r2 = b().a(r7);
        ILogDepend.Companion.i(TAG, "saveIntent " + r7.e() + " result = " + r2);
        int r14 = 0;
        if (r2 <= 0) goto L19;
        com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a.a(r7.b(), p.a(r7.a()), 0);
    L19:
        if (r2 > 0) goto L23;
        r14 = 104;
    L23:
        return new d.m(d.c.b.a.b.a(r14), null);
    L5:
        if (r10.d() == false) goto L8;
        return new d.m(d.c.b.a.b.a(-1), "Intent " + r7.a() + " has registered");
    }

    public final Object a(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r9, d<? super x> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (r11.isEmpty() == true) goto L5;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.data.a.a r0 = b();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (n.a(a((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        Map r8 = ao.a((Iterable) ZeusTransformUtils.preCheckCast(p.c(r13, (Iterable) ZeusTransformUtils.preCheckCast(r0.b((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r15 = r8.entrySet().iterator();
    L13:
        boolean r6 = false;
        if (r15.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r1.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L18;
        r6 = true;
    L18:
        if (r6 == false) goto L13;
        r14.put(r1.getKey(), r1.getValue());
        goto L13
    L20:
        Set r16 = r14.keySet();
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r18 = r17.iterator();
    L22:
        if (r18.hasNext() == false) goto L27;
        Object r19 = r18.next();
        String r20 = ((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r19, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).b();
        Object r21 = r7.get(r20);
        if (r21 != null) goto L26;
        r21 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r7.put(r20, r21);
    L26:
        ((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin")).add(r19);
        goto L22
    L27:
        Iterator r110 = r7.entrySet().iterator();
    L29:
        if (r110.hasNext() == false) goto L35;
        Map.Entry r22 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.getKey(), String.class, "com.obric.aiagent.plugin");
        List r24 = (List) ZeusTransformUtils.preCheckCast(r22.getValue(), List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.publish.a r25 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r26, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r28 = r26.iterator();
    L32:
        if (r28.hasNext() == false) goto L34;
        r27.add(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r28.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).a());
        goto L32
    L34:
        r25.a(r23, (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin"), 0);
        goto L29
    L35:
        ILogDepend.Companion.i(TAG, " saveIntents size " + r11.size() + " succeedItems = " + r16);
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    public final Object a(com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r9) {
        d.h.b.o.e(r9, "bean");
        Set r0 = ServiceManager.get().getServices(IntentFunction.class);
        d.h.b.o.b(r0, "ServiceManager.get().getServices(T::class.java)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (d.h.b.o.a(((IntentFunction) ZeusTransformUtils.preCheckCast(r2, IntentFunction.class, "com.obric.aiagent.plugin")).getName(), r9.a()) == false) goto L4;
    L10:
        if (((IntentFunction) ZeusTransformUtils.preCheckCast(r2, IntentFunction.class, "com.obric.aiagent.plugin")) != null) goto L12;
        n.a r8 = n.f38560a;
        return n.f(o.a((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("no intent define"), Throwable.class, "com.obric.aiagent.plugin")));
    L12:
        if (d().a(r9.b(), "intent_register", r9.a()) == false) goto L14;
        n.a r10 = n.f38560a;
        return n.f(0);
    L14:
        com.obric.aiagent.authentication.a r3 = c();
        String r11 = r9.b();
        String r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
        d.h.b.o.c(r4, "getPackageName(...)");
        return com.obric.aiagent.authentication.a.a(r3, "intent_register", r11, r4, r9.a(), null, 16, null);
    L8:
        r2 = null;
        goto L10
    }

    public final Object a(String r5, String r6, d<? super Integer> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        String r9 = r5 + r6;
        int r0 = b().a(r9, false);
        ILogDepend.Companion.i(TAG, "deleteIntent by key " + r9 + " result = " + r0);
        if (r0 <= 0) goto L6;
        com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a.a(r5, p.a(r6), 2);
        b().c(r9);
    L6:
        return d.c.b.a.b.a(r0);
    }

    public final Object b(List<String> r17, d<? super x> r18) {
        List<String> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r18, d.class, "com.obric.aiagent.plugin");
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3 = b().a(r0);
        if (r3.isEmpty() == true) goto L5;
        com.obric.aiagent.executionengine.capabilitymanager.data.a.a r4 = b();
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r6.add(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).e());
        goto L8
    L10:
        int r8 = r4.d((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.i(TAG, "deleteIntents by packages " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + " result = " + r8);
        if (r8 <= 0) goto L29;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r10 = r1.iterator();
    L14:
        if (r10.hasNext() == false) goto L19;
        Object r11 = r10.next();
        String r12 = ((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).b();
        Object r13 = r9.get(r12);
        if (r13 != null) goto L18;
        r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r9.put(r12, r13);
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin")).add(r11);
        goto L14
    L19:
        Iterator r14 = r9.entrySet().iterator();
    L21:
        if (r14.hasNext() == false) goto L27;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.aiagent.plugin");
        List r19 = (List) ZeusTransformUtils.preCheckCast(r15.getValue(), List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.publish.a r20 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r21, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r23 = r21.iterator();
    L24:
        if (r23.hasNext() == false) goto L26;
        r22.add(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).a());
        goto L24
    L26:
        r20.a(r16, (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin"), 2);
        goto L21
    L27:
        b().c(r3);
    L29:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    public final Object c(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r9, d<? super x> r10) {
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (r11.isEmpty() == true) goto L5;
        com.obric.aiagent.executionengine.capabilitymanager.data.a.a r13 = b();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r2.add(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).e());
        goto L8
    L10:
        int r14 = r13.d((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.i(TAG, "deleteIntents size " + r11.size() + " result = " + r14);
        if (r14 <= 0) goto L29;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L19;
        Object r4 = r16.next();
        String r5 = ((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).b();
        Object r6 = r3.get(r5);
        if (r6 != null) goto L18;
        r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r3.put(r5, r6);
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin")).add(r4);
        goto L14
    L19:
        Iterator r17 = r3.entrySet().iterator();
    L21:
        if (r17.hasNext() == false) goto L27;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin");
        List r18 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.publish.a r19 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r20, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r20.iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        r21.add(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r22.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).a());
        goto L24
    L26:
        r19.a(r8, (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), 2);
        goto L21
    L27:
        b().c(r11);
    L29:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    public final Object d(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r8, d<? super x> r9) {
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        if (r10.isEmpty() == true) goto L5;
        int r7 = b().e(r10);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L13;
        Object r2 = r13.next();
        String r3 = ((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).b();
        Object r4 = r0.get(r3);
        if (r4 != null) goto L12;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r0.put(r3, r4);
    L12:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).add(r2);
        goto L8
    L13:
        Iterator r14 = r0.entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L21;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.capabilitymanager.publish.a r15 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L18:
        if (r18.hasNext() == false) goto L20;
        r17.add(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).a());
        goto L18
    L20:
        r15.a(r5, (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), 1);
        goto L15
    L21:
        ILogDepend.Companion.i(TAG, " updateIntents size " + r10.size() + " result = " + r7);
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    public final Object a(String r5, d<? super List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.a.f16395a.a(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new b(this, r5, null), m.class, "com.obric.aiagent.plugin"), r7);
    }
}
