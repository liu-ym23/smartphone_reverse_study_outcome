package d.h.b;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements e, d.m.c<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38489a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends d.c<?>>, Integer> f38490c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f38491d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap<String, String> f38492e = null;
    private static final HashMap<String, String> f = null;
    private static final Map<String, String> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f38493b;

    /* JADX INFO: compiled from: ClassReference.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final String a(Class<?> r6) {
            o.e(r6, "jClass");
            String r1 = null;
            if (r6.isAnonymousClass() == false) goto L6;
        L28:
            return r1;
        L6:
            if (r6.isLocalClass() == false) goto L16;
            String r5 = r6.getSimpleName();
            Method r0 = r6.getEnclosingMethod();
            if (r0 == null) goto L11;
            o.a(r5);
            String r2 = d.o.o.b(r5, r0.getName() + '$', null, 2, null);
            if (r2 == null) goto L11;
            return r2;
        L11:
            Constructor<?> r7 = r6.getEnclosingConstructor();
            if (r7 == null) goto L14;
            o.a(r5);
            return d.o.o.b(r5, r7.getName() + '$', null, 2, null);
        L14:
            o.a(r5);
            return d.o.o.b(r5, '$', null, 2, null);
        L16:
            if (r6.isArray() == false) goto L24;
            Class<?> r8 = r6.getComponentType();
            if (r8.isPrimitive() == false) goto L22;
            String r9 = (String) ZeusTransformUtils.preCheckCast(f.c().get(r8.getName()), String.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L22;
            r1 = r9 + "Array";
        L22:
            if (r1 != null) goto L28;
            return "Array";
        L24:
            String r3 = (String) ZeusTransformUtils.preCheckCast(f.c().get(r6.getName()), String.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L27;
            return r3;
        L27:
            return r6.getSimpleName();
        }

        public final boolean a(Object r3, Class<?> r4) {
            o.e(r4, "jClass");
            Map r2 = f.d();
            o.a(r2, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(r4), Integer.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L7;
            return ae.a(r3, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
        L7:
            if (r4.isPrimitive() == false) goto L10;
            r4 = d.h.a.b(d.h.a.a(r4));
        L10:
            return ZeusTransformUtils.instanceOf(r4, r3);
        }
    }

    public f(Class<?> r2) {
        o.e(r2, "jClass");
        this.f38493b = r2;
    }

    public static final /* synthetic */ Map c() {
        return g;
    }

    public static final /* synthetic */ Map d() {
        return f38490c;
    }

    @Override // d.h.b.e
    public Class<?> a() {
        return this.f38493b;
    }

    @Override // d.m.c
    public String b() {
        return f38489a.a(a());
    }

    @Override // d.m.a
    public List<Annotation> getAnnotations() {
        e();
        throw new d.d();
    }

    @Override // d.m.c
    public boolean a(Object r2) {
        return f38489a.a(r2, a());
    }

    private final Void e() {
        throw new d.h.b();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(d.h.a.b((d.m.c) ZeusTransformUtils.preCheckCast(this, d.m.c.class, "com.obric.aiagent.plugin")), d.h.a.b((d.m.c) ZeusTransformUtils.preCheckCast(r3, d.m.c.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        return true;
    }

    @Override // d.m.c
    public int hashCode() {
        return d.h.a.b((d.m.c) ZeusTransformUtils.preCheckCast(this, d.m.c.class, "com.obric.aiagent.plugin")).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f38489a = new a(null);
        int r3 = 0;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new Class[]{d.h.a.a.class, d.h.a.b.class, d.h.a.m.class, d.h.a.q.class, d.h.a.r.class, d.h.a.s.class, d.h.a.t.class, d.h.a.u.class, d.h.a.v.class, d.h.a.w.class, d.h.a.c.class, d.h.a.d.class, d.h.a.e.class, d.h.a.f.class, d.h.a.g.class, d.h.a.h.class, d.h.a.i.class, d.h.a.j.class, d.h.a.k.class, d.h.a.l.class, d.h.a.n.class, d.h.a.o.class, d.h.a.p.class}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Object r5 = r1.next();
        int r7 = r3 + 1;
        if (r3 >= 0) goto L8;
        d.a.p.c();
    L8:
        r2.add(d.s.a((Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin"), Integer.valueOf(r3)));
        r3 = r7;
        goto L4
    L9:
        f38490c = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        HashMap<String, String> r4 = new HashMap();
        r4.put(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE, "kotlin.Boolean");
        r4.put("char", "kotlin.Char");
        r4.put("byte", "kotlin.Byte");
        r4.put("short", "kotlin.Short");
        r4.put("int", "kotlin.Int");
        r4.put(WsChannelMultiProcessSharedProvider.FLOAT_TYPE, "kotlin.Float");
        r4.put(WsChannelMultiProcessSharedProvider.LONG_TYPE, "kotlin.Long");
        r4.put("double", "kotlin.Double");
        f38491d = r4;
        HashMap<String, String> r6 = new HashMap();
        r6.put("java.lang.Boolean", "kotlin.Boolean");
        r6.put("java.lang.Character", "kotlin.Char");
        r6.put("java.lang.Byte", "kotlin.Byte");
        r6.put("java.lang.Short", "kotlin.Short");
        r6.put("java.lang.Integer", "kotlin.Int");
        r6.put("java.lang.Float", "kotlin.Float");
        r6.put("java.lang.Long", "kotlin.Long");
        r6.put("java.lang.Double", "kotlin.Double");
        f38492e = r6;
        HashMap<String, String> r8 = new HashMap();
        r8.put("java.lang.Object", "kotlin.Any");
        r8.put("java.lang.String", "kotlin.String");
        r8.put("java.lang.CharSequence", "kotlin.CharSequence");
        r8.put("java.lang.Throwable", "kotlin.Throwable");
        r8.put("java.lang.Cloneable", "kotlin.Cloneable");
        r8.put("java.lang.Number", "kotlin.Number");
        r8.put("java.lang.Comparable", "kotlin.Comparable");
        r8.put("java.lang.Enum", "kotlin.Enum");
        r8.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        r8.put("java.lang.Iterable", "kotlin.collections.Iterable");
        r8.put("java.util.Iterator", "kotlin.collections.Iterator");
        r8.put("java.util.Collection", "kotlin.collections.Collection");
        r8.put("java.util.List", "kotlin.collections.List");
        r8.put("java.util.Set", "kotlin.collections.Set");
        r8.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        r8.put("java.util.Map", "kotlin.collections.Map");
        r8.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        r8.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        r8.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        r8.putAll((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        r8.putAll((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin"));
        Collection<String> r9 = r4.values();
        o.c(r9, "<get-values>(...)");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        Object r11 = r10.next();
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        StringBuilder r14 = new StringBuilder().append("kotlin.jvm.internal.");
        o.a(r13);
        d.m r15 = d.s.a(r14.append(d.o.o.c(r13, '.', null, 2, null)).append("CompanionObject").toString(), r13 + ".Companion");
        r12.put(r15.a(), r15.b());
        goto L11
    L13:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<Class<? extends d.c<?>>, Integer>> r17 = f38490c.entrySet().iterator();
    L15:
        if (r17.hasNext() == false) goto L17;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.put(((Class) ZeusTransformUtils.preCheckCast(r18.getKey(), Class.class, "com.obric.aiagent.plugin")).getName(), "kotlin.Function" + ((Number) ZeusTransformUtils.preCheckCast(r18.getValue(), Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L15
    L17:
        f = r8;
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r19.size())), Map.class, "com.obric.aiagent.plugin");
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r19.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L19:
        if (r21.hasNext() == false) goto L21;
        Object r22 = r21.next();
        r20.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r22, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), d.o.o.c((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r22, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"), '.', null, 2, null));
        goto L19
    L21:
        g = r20;
    }
}
