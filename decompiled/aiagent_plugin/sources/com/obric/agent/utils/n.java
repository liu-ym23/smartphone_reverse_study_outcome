package com.obric.agent.utils;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: DeferIntentUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f16046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f16047b = null;

    /* JADX INFO: compiled from: DeferIntentUtil.kt */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: DeferIntentUtil.kt */
    @d.c.b.a.f(b = "DeferIntentUtil.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.utils.DeferIntentUtil$addDeferIntent$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f16050c;

        b(String r3, a r4, d.c.d<? super b> r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16049b = r3;
            this.f16050c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f16049b, this.f16050c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f16048a != 0) goto L7;
            d.o.a(r2);
            n.a().put(this.f16049b, this.f16050c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DeferIntentUtil.kt */
    public static final class c extends LinkedHashMap<String, a> {
        c() {
            super(5, 0.75f, true);
        }

        public a a(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(super.get(r2), a.class, "com.obric.aiagent.plugin");
        }

        public a a(String r3, a r4) {
            return (a) ZeusTransformUtils.preCheckCast(super.getOrDefault(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin");
        }

        public Collection<a> a() {
            return super.values();
        }

        public boolean a(a r3) {
            return super.containsValue((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin"));
        }

        public int b() {
            return super.size();
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public boolean b(String r3, a r4) {
            return super.remove(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"));
        }

        public a c(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(super.remove(r2), a.class, "com.obric.aiagent.plugin");
        }

        public Set<Map.Entry<String, a>> c() {
            return super.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L7;
            return false;
        L7:
            return a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, a>> entrySet() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<a> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, a> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= 10) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: DeferIntentUtil.kt */
    @d.c.b.a.f(b = "DeferIntentUtil.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.utils.DeferIntentUtil$onServerReply$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16053c;

        d(boolean r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16052b = r3;
            this.f16053c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f16052b, this.f16053c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f16051a != 0) goto L17;
            d.o.a(r3);
            if (this.f16052b == true) goto L15;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f16053c, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == false) goto L15;
            a r2 = (a) ZeusTransformUtils.preCheckCast(n.a().remove(this.f16053c), a.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L15;
            r2.a();
            goto L15
        L9:
            r4 = false;
        L15:
            return d.x.f38692a;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private n() {
    }

    public static final /* synthetic */ c a() {
        return f16047b;
    }

    static {
        f16046a = new n();
        f16047b = new c();
    }

    public final void a(String r8, a r9) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "questionId");
        d.h.b.o.e(r7, "job");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r8, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r7, String r8, Map<String, String> r9, boolean r10) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, DbHelper.COL_ID);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r10, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
