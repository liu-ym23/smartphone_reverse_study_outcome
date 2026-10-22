package com.obric.aiagent.executionengine.capabilitymanager.matcher.a;

import android.app.Application;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.AppFunctionIntentMapping;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.AppFunctionNode;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDslCapabilitySource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.obric.aiagent.executionengine.capabilitymanager.matcher.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f16476b = null;

    /* JADX INFO: compiled from: AppFunctionDslCapabilitySource.kt */
    @f(b = "AppFunctionDslCapabilitySource.kt", c = {42}, d = "snapshot", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.AppFunctionDslCapabilitySource")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f16479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16480d;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16479c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16478b = r3;
            this.f16480d |= Integer.MIN_VALUE;
            return this.f16479c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private b() {
    }

    static {
        f16475a = new b();
        f16476b = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16399a;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return f16476b;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void a() {
        x.f18310a.a();
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public Object a(d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b>> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");
        if ((r0.f16480d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16480d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f16478b;
        Object r14 = d.c.a.b.a();
        int r2 = r0.f16480d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Map<String, AppFunctionIntentMapping> r15 = (Map) ZeusTransformUtils.preCheckCast(r0.f16477a, Map.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L22:
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, AppFunctionIntentMapping>> r17 = r15.entrySet().iterator();
    L24:
        if (r17.hasNext() == false) goto L32;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        AppFunctionIntentMapping r3 = (AppFunctionIntentMapping) ZeusTransformUtils.preCheckCast(r1.getValue(), AppFunctionIntentMapping.class, "com.obric.aiagent.plugin");
        b r4 = f16475a;
        if (r4.a(r3) == true) goto L28;
        com.obric.aiagent.executionengine.capabilitymanager.api.a.b r5 = null;
    L29:
        if (r5 == null) goto L24;
        r16.add(r5);
        goto L24
    L28:
        r5 = new com.obric.aiagent.executionengine.capabilitymanager.api.a.b(com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16399a, r7, r4.c(), r7, null, 16, null);
        goto L29
    L32:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        Map<String, AppFunctionIntentMapping> r18 = com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.a.f18157a.a();
        if (r18.isEmpty() == true) goto L17;
        x r6 = x.f18310a;
        r0.f16477a = r18;
        r0.f16480d = 1;
        if (r6.a(800, r0) != r14) goto L21;
        return r14;
    L21:
        r15 = r18;
        goto L22
    L17:
        return p.b();
    L7:
        r0 = new a(this, r13);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void b() {
        x.f18310a.b();
    }

    private final boolean a(AppFunctionIntentMapping r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r7.getFunctions(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r6.iterator();
    L3:
        boolean r2 = false;
        if (r9.hasNext() == false) goto L12;
        Object r1 = r9.next();
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(((AppFunctionNode) ZeusTransformUtils.preCheckCast(r1, AppFunctionNode.class, "com.obric.aiagent.plugin")).getConverterClassName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
    L9:
        r2 = true;
    L10:
        if (r2 == false) goto L3;
        r8.add(r1);
        goto L3
    L8:
        if (d.o.o.d(r4) == false) goto L10;
    L12:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r10.isEmpty() == false) goto L15;
        return true;
    L15:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L18;
    L20:
        Iterator r12 = r11.iterator();
    L22:
        if (r12.hasNext() == false) goto L25;
        if (com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.c.f18183a.b((AppFunctionNode) ZeusTransformUtils.preCheckCast(r12.next(), AppFunctionNode.class, "com.obric.aiagent.plugin")) == true) goto L22;
        return false;
    L25:
        return true;
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L20;
        goto L20
    }

    private final String c() {
        String r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
        d.h.b.o.c(r2, "getPackageName(...)");
        return r2;
    }
}
