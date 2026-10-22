package com.fasterxml.jackson.databind.k;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: TypeFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final o f12985a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final n f12986b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final l f12987c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final l f12988d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final l f12989e = null;
    protected static final l f = null;
    protected static final l g = null;
    protected static final l h = null;
    protected static final l i = null;
    protected static final l j = null;
    protected static final l k = null;
    private static final com.fasterxml.jackson.databind.k[] p = null;
    private static final Class<?> q = null;
    private static final Class<?> r = null;
    private static final Class<?> s = null;
    private static final Class<?> t = null;
    private static final Class<?> u = null;
    private static final Class<?> v = null;
    private static final Class<?> w = null;
    private static final Class<?> x = null;
    private static final Class<?> y = null;
    protected final com.fasterxml.jackson.databind.l.p<Object, com.fasterxml.jackson.databind.k> l;
    protected final p[] m;
    protected final q n;
    protected final ClassLoader o;

    static {
        p = new com.fasterxml.jackson.databind.k[0];
        f12985a = new o();
        f12986b = n.a();
        q = String.class;
        r = Object.class;
        s = Comparable.class;
        t = Class.class;
        u = Enum.class;
        v = com.fasterxml.jackson.databind.n.class;
        Class<?> r6 = Boolean.TYPE;
        w = r6;
        Class<?> r7 = Integer.TYPE;
        x = r7;
        Class<?> r8 = Long.TYPE;
        y = r8;
        f12987c = new l(r6);
        f12988d = new l(r7);
        f12989e = new l(r8);
        f = new l(String.class);
        g = new l(Object.class);
        h = new l(Comparable.class);
        i = new l(Enum.class);
        j = new l(Class.class);
        k = new l(com.fasterxml.jackson.databind.n.class);
    }

    private o() {
        this((com.fasterxml.jackson.databind.l.p) ZeusTransformUtils.preCheckCast(null, com.fasterxml.jackson.databind.l.p.class, "com.obric.aiagent.plugin"));
    }

    public o(com.fasterxml.jackson.databind.l.p<Object, com.fasterxml.jackson.databind.k> r3) {
        com.fasterxml.jackson.databind.l.p<Object, com.fasterxml.jackson.databind.k> r4 = (com.fasterxml.jackson.databind.l.p) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.l.p.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = new com.fasterxml.jackson.databind.l.n(16, 200);
    L5:
        this.l = r4;
        this.n = new q(this);
        this.m = null;
        this.o = null;
    }

    public static o a() {
        return f12985a;
    }

    public ClassLoader b() {
        return this.o;
    }

    public static com.fasterxml.jackson.databind.k c() {
        return a().d();
    }

    public Class<?> a(String r3) {
        if (r3.indexOf(46) >= 0) goto L7;
        Class<?> r0 = c(r3);
        if (r0 == null) goto L7;
        return r0;
    L7:
        Throwable r1 = null;
        ClassLoader r2 = b();
        if (r2 != null) goto L10;
        r2 = Thread.currentThread().getContextClassLoader();
    L10:
        if (r2 != null) goto L25;
    L23:
        return b(r3);
    L18:
        e = move-exception;
        if (r1 != null) goto L21;
        r1 = com.fasterxml.jackson.databind.l.h.d(e);
    L21:
        com.fasterxml.jackson.databind.l.h.b(r1);
        throw new ClassNotFoundException(r1.getMessage(), r1);
    L25:
        return a(r3, true, r2);
    L14:
        e = move-exception;
        r1 = com.fasterxml.jackson.databind.l.h.d(e);
        goto L23
    }

    public Class<?> a(String r1, boolean r2, ClassLoader r3) {
        return Class.forName(r1, true, r3);
    }

    public Class<?> b(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin");
    }

    public Class<?> c(String r1) {
        if ("int".equals(r1) == false) goto L7;
        return Integer.TYPE;
    L7:
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r1) == false) goto L11;
        return Long.TYPE;
    L11:
        if (WsChannelMultiProcessSharedProvider.FLOAT_TYPE.equals(r1) == false) goto L15;
        return Float.TYPE;
    L15:
        if ("double".equals(r1) == false) goto L19;
        return Double.TYPE;
    L19:
        if (WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE.equals(r1) == false) goto L23;
        return Boolean.TYPE;
    L23:
        if ("byte".equals(r1) == false) goto L27;
        return Byte.TYPE;
    L27:
        if ("char".equals(r1) == false) goto L31;
        return Character.TYPE;
    L31:
        if ("short".equals(r1) == false) goto L35;
        return Short.TYPE;
    L35:
        if ("void".equals(r1) == true) goto L37;
        return null;
    L37:
        return Void.TYPE;
    }

    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r2, Class<?> r3) {
        return a(r2, r3, false);
    }

    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r4, Class<?> r5, boolean r6) {
        Class<?> r0 = r4.e();
        if (r0 != r5) goto L6;
        return r4;
    L6:
        if (r0 != Object.class) goto L9;
        com.fasterxml.jackson.databind.k r3 = a(null, r5, f12986b);
    L46:
        return r3.b(r4);
    L9:
        if (r0.isAssignableFrom(r5) == false) goto L48;
        if (r4.q() == false) goto L39;
        if (r4.s() == false) goto L24;
        if (r5 != HashMap.class) goto L17;
    L22:
        r3 = a(null, r5, n.a(r5, r4.w(), r4.x()));
        goto L46
    L17:
        if (r5 == LinkedHashMap.class) goto L22;
        if (r5 == EnumMap.class) goto L22;
        if (r5 != TreeMap.class) goto L39;
    L24:
        if (r4.r() == false) goto L39;
        if (r5 != ArrayList.class) goto L28;
    L37:
        r3 = a(null, r5, n.a(r5, r4.x()));
        goto L46
    L28:
        if (r5 == LinkedList.class) goto L37;
        if (r5 == HashSet.class) goto L37;
        if (r5 == TreeSet.class) goto L37;
        if (r0 != EnumSet.class) goto L39;
        return r4;
    L39:
        if (r4.A().b() == false) goto L41;
        r3 = a(null, r5, f12986b);
        goto L46
    L41:
        int r1 = r5.getTypeParameters().length;
        if (r1 != 0) goto L44;
        r3 = a(null, r5, f12986b);
        goto L46
    L44:
        r3 = a(null, r5, a(r4, r1, r5, r6));
        goto L46
    L48:
        throw new IllegalArgumentException(String.format("Class %s not subtype of %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(r5), com.fasterxml.jackson.databind.l.h.b(r4)}));
    }

    private n a(com.fasterxml.jackson.databind.k r5, int r6, Class<?> r7, boolean r8) {
        i[] r0 = new i[r6];
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L5;
        r0[r2] = new i(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        com.fasterxml.jackson.databind.k r3 = a(null, r7, n.a(r7, r0)).d(r5.e());
        if (r3 == null) goto L22;
        String r4 = a(r5, r3);
        if (r4 == null) goto L13;
        if (r8 == true) goto L13;
        throw new IllegalArgumentException("Failed to specialize base type " + r5.c() + " as " + r7.getName() + ", problem: " + r4);
    L13:
        com.fasterxml.jackson.databind.k[] r9 = new com.fasterxml.jackson.databind.k[r6];
    L14:
        if (r1 >= r6) goto L20;
        com.fasterxml.jackson.databind.k r10 = r0[r1].H();
        if (r10 != null) goto L18;
        r10 = c();
    L18:
        r9[r1] = r10;
        r1 = r1 + 1;
        goto L14
    L20:
        return n.a(r7, r9);
    L22:
        throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", new Object[]{r5.e().getName(), r7.getName()}));
    }

    private String a(com.fasterxml.jackson.databind.k r10, com.fasterxml.jackson.databind.k r11) {
        List<com.fasterxml.jackson.databind.k> r0 = r10.A().d();
        List<com.fasterxml.jackson.databind.k> r12 = r11.A().d();
        int r1 = r12.size();
        int r2 = r0.size();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L27;
        com.fasterxml.jackson.databind.k r5 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r0.get(r4), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        if (r4 >= r1) goto L7;
        com.fasterxml.jackson.databind.k r6 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r12.get(r4), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    L9:
        if (b(r5, r6) == true) goto L26;
        if (r5.a(Object.class) == true) goto L26;
        if (r4 != 0) goto L20;
        if (r10.s() == false) goto L20;
        if (r6.a(Object.class) == true) goto L26;
    L20:
        if (r5.n() == false) goto L25;
        if (r5.c(r6.e()) == true) goto L26;
    L25:
        return String.format("Type parameter #%d/%d differs; can not specialize %s with %s", new Object[]{Integer.valueOf(r4 + 1), Integer.valueOf(r2), r5.c(), r6.c()});
    L26:
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = c();
        goto L9
    L27:
        return null;
    }

    private boolean b(com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.k r10) {
        if (ZeusTransformUtils.instanceOf(r10, i.class) == false) goto L7;
        ((i) ZeusTransformUtils.preCheckCast(r10, i.class, "com.obric.aiagent.plugin")).c(r9);
        return true;
    L7:
        if (r9.e() == r10.e()) goto L9;
        return false;
    L9:
        List<com.fasterxml.jackson.databind.k> r11 = r9.A().d();
        List<com.fasterxml.jackson.databind.k> r12 = r10.A().d();
        int r0 = r11.size();
        int r3 = 0;
    L10:
        if (r3 >= r0) goto L15;
        if (b((com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r11.get(r3), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin"), (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r12.get(r3), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin")) == false) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.k r4, Class<?> r5) {
        Class<?> r3 = r4.e();
        if (r3 != r5) goto L5;
        return r4;
    L5:
        com.fasterxml.jackson.databind.k r0 = r4.d(r5);
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (r5.isAssignableFrom(r3) == true) goto L12;
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", new Object[]{r5.getName(), r4}));
    L12:
        throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", new Object[]{r5.getName(), r4}));
    }

    public com.fasterxml.jackson.databind.k d(String r1) {
        return this.n.a(r1);
    }

    public com.fasterxml.jackson.databind.k[] c(com.fasterxml.jackson.databind.k r1, Class<?> r2) {
        com.fasterxml.jackson.databind.k r0 = r1.d(r2);
        if (r0 != null) goto L7;
        return p;
    L7:
        return r0.A().e();
    }

    public com.fasterxml.jackson.databind.k a(Type r3) {
        return a(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin"), f12986b);
    }

    public com.fasterxml.jackson.databind.k a(Type r3, n r4) {
        return a(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin"), r4);
    }

    public e a(Class<? extends Collection> r3, Class<?> r4) {
        return a(r3, a(null, r4, f12986b));
    }

    public e a(Class<? extends Collection> r4, com.fasterxml.jackson.databind.k r5) {
        n r0 = n.b(r4, r5);
        e r3 = (e) ZeusTransformUtils.preCheckCast(a(null, r4, r0), e.class, "com.obric.aiagent.plugin");
        if (r0.b() == false) goto L10;
        if (r5 == null) goto L10;
        com.fasterxml.jackson.databind.k r1 = r3.d(Collection.class).x();
        if (r1.equals(r5) == true) goto L10;
        throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", new Object[]{com.fasterxml.jackson.databind.l.h.h(r4), r5, r1}));
    L10:
        return r3;
    }

    public h a(Class<? extends Map> r3, Class<?> r4, Class<?> r5) {
        if (r3 != Properties.class) goto L5;
        com.fasterxml.jackson.databind.k r6 = f;
        com.fasterxml.jackson.databind.k r7 = r6;
    L7:
        return a(r3, r6, r7);
    L5:
        n r0 = f12986b;
        r6 = a(null, r4, r0);
        r7 = a(null, r5, r0);
        goto L7
    }

    public h a(Class<? extends Map> r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.k r10) {
        n r1 = n.b(r8, new com.fasterxml.jackson.databind.k[]{r9, r10});
        h r7 = (h) ZeusTransformUtils.preCheckCast(a(null, r8, r1), h.class, "com.obric.aiagent.plugin");
        if (r1.b() == false) goto L13;
        com.fasterxml.jackson.databind.k r2 = r7.d(Map.class);
        com.fasterxml.jackson.databind.k r4 = r2.w();
        if (r4.equals(r9) == false) goto L12;
        com.fasterxml.jackson.databind.k r11 = r2.x();
        if (r11.equals(r10) == true) goto L13;
        throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", new Object[]{com.fasterxml.jackson.databind.l.h.h(r8), r10, r11}));
    L12:
        throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", new Object[]{com.fasterxml.jackson.databind.l.h.h(r8), r9, r4}));
    L13:
        return r7;
    }

    @Deprecated
    public com.fasterxml.jackson.databind.k a(Class<?> r3) {
        return a(r3, f12986b, null, null);
    }

    public com.fasterxml.jackson.databind.k a(Class<?> r2, n r3) {
        return a(r2, a(null, r2, r3));
    }

    private com.fasterxml.jackson.databind.k c(Class<?> r7, n r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.k[] r10) {
        if (r7 != Properties.class) goto L6;
        com.fasterxml.jackson.databind.k r6 = f;
    L5:
        com.fasterxml.jackson.databind.k r4 = r6;
        com.fasterxml.jackson.databind.k r5 = r4;
    L19:
        return h.a(r7, r8, r9, r10, r4, r5);
    L6:
        List<com.fasterxml.jackson.databind.k> r0 = r8.d();
        int r1 = r0.size();
        if (r1 != 0) goto L9;
        r6 = d();
        goto L5
    L9:
        if (r1 == 2) goto L16;
        Object[] r11 = new Object[4];
        r11[0] = com.fasterxml.jackson.databind.l.h.h(r7);
        r11[1] = Integer.valueOf(r1);
        if (r1 != 1) goto L13;
        String r12 = "";
    L14:
        r11[2] = r12;
        r11[3] = r8;
        throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", r11));
    L13:
        r12 = "s";
        goto L14
    L16:
        com.fasterxml.jackson.databind.k r13 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r0.get(0), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        r4 = r13;
        r5 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r0.get(1), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        goto L19
    }

    private com.fasterxml.jackson.databind.k d(Class<?> r3, n r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.k[] r6) {
        List<com.fasterxml.jackson.databind.k> r0 = r4.d();
        if (r0.isEmpty() == false) goto L6;
        com.fasterxml.jackson.databind.k r2 = d();
    L9:
        return e.a(r3, r4, r5, r6, r2);
    L6:
        if (r0.size() != 1) goto L11;
        r2 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r0.get(0), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        goto L9
    L11:
        throw new IllegalArgumentException("Strange Collection type " + r3.getName() + ": cannot determine type parameters");
    }

    private com.fasterxml.jackson.databind.k e(Class<?> r3, n r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.k[] r6) {
        List<com.fasterxml.jackson.databind.k> r0 = r4.d();
        if (r0.isEmpty() == false) goto L6;
        com.fasterxml.jackson.databind.k r2 = d();
    L9:
        return j.a(r3, r4, r5, r6, r2);
    L6:
        if (r0.size() != 1) goto L11;
        r2 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r0.get(0), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        goto L9
    L11:
        throw new IllegalArgumentException("Strange Reference type " + r3.getName() + ": cannot determine type parameters");
    }

    public com.fasterxml.jackson.databind.k a(Class<?> r2, n r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.k[] r5) {
        if (r3.b() == false) goto L8;
        com.fasterxml.jackson.databind.k r0 = b(r2);
        if (r0 == null) goto L8;
        return r0;
    L8:
        return b(r2, r3, r4, r5);
    }

    public com.fasterxml.jackson.databind.k b(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4) {
        return new l(r1, r2, r3, r4);
    }

    public com.fasterxml.jackson.databind.k d() {
        return g;
    }

    public com.fasterxml.jackson.databind.k b(Class<?> r1) {
        if (r1.isPrimitive() == false) goto L17;
        if (r1 != w) goto L9;
        return f12987c;
    L9:
        if (r1 != x) goto L13;
        return f12988d;
    L13:
        if (r1 == y) goto L15;
        return null;
    L15:
        return f12989e;
    L17:
        if (r1 != q) goto L21;
        return f;
    L21:
        if (r1 != r) goto L25;
        return g;
    L25:
        if (r1 == v) goto L27;
        return null;
    L27:
        return k;
    }

    public com.fasterxml.jackson.databind.k a(c r3, Type r4, n r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Class.class) == false) goto L6;
        com.fasterxml.jackson.databind.k r7 = a(r3, (Class) ZeusTransformUtils.preCheckCast(r6, Class.class, "com.obric.aiagent.plugin"), f12986b);
    L22:
        return a(r6, r7);
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L9;
        r7 = a(r3, (ParameterizedType) ZeusTransformUtils.preCheckCast(r6, ParameterizedType.class, "com.obric.aiagent.plugin"), r5);
        goto L22
    L9:
        if (ZeusTransformUtils.instanceOf(r6, com.fasterxml.jackson.databind.k.class) == false) goto L13;
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r6, com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r6, GenericArrayType.class) == false) goto L16;
        r7 = a(r3, (GenericArrayType) ZeusTransformUtils.preCheckCast(r6, GenericArrayType.class, "com.obric.aiagent.plugin"), r5);
        goto L22
    L16:
        if (ZeusTransformUtils.instanceOf(r6, TypeVariable.class) == false) goto L19;
        r7 = a(r3, (TypeVariable) ZeusTransformUtils.preCheckCast(r6, TypeVariable.class, "com.obric.aiagent.plugin"), r5);
        goto L22
    L19:
        if (ZeusTransformUtils.instanceOf(r6, WildcardType.class) == false) goto L23;
        r7 = a(r3, (WildcardType) ZeusTransformUtils.preCheckCast(r6, WildcardType.class, "com.obric.aiagent.plugin"), r5);
        goto L22
    L23:
        StringBuilder r8 = new StringBuilder().append("Unrecognized Type: ");
        if (r6 != null) goto L26;
        String r9 = "[null]";
    L28:
        throw new IllegalArgumentException(r8.append(r9).toString());
    L26:
        r9 = r6.toString();
        goto L28
    }

    public com.fasterxml.jackson.databind.k a(Type r8, com.fasterxml.jackson.databind.k r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.aiagent.plugin");
        if (this.m != null) goto L5;
        return r9;
    L5:
        n r0 = r9.A();
        if (r0 != null) goto L8;
        r0 = f12986b;
    L8:
        p[] r1 = this.m;
        int r2 = r1.length;
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L15;
        p r5 = r1[r4];
        com.fasterxml.jackson.databind.k r6 = r5.a(r9, r10, r0, this);
        if (r6 == null) goto L14;
        r4 = r4 + 1;
        r9 = r6;
        goto L9
    L14:
        throw new IllegalStateException(String.format("TypeModifier %s (of type %s) return null for type %s", new Object[]{r5, r5.getClass().getName(), r9}));
    L15:
        return r9;
    }

    public com.fasterxml.jackson.databind.k a(c r13, Class<?> r14, n r15) {
        com.fasterxml.jackson.databind.k r0 = b(r14);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r15 != null) goto L7;
    L10:
        Object r1 = r14;
    L11:
        com.fasterxml.jackson.databind.k r2 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(this.l.a(r1), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        return r2;
    L14:
        if (r13 != null) goto L16;
        c r16 = new c(r14);
    L22:
        if (r14.isArray() == false) goto L25;
        com.fasterxml.jackson.databind.k r17 = a.a(a(r16, r14.getComponentType(), r15), r15);
    L40:
        r16.a(r17);
        if (r17.F() == true) goto L43;
        this.l.b(r1, r17);
    L43:
        return r17;
    L25:
        if (r14.isInterface() == false) goto L27;
        com.fasterxml.jackson.databind.k r3 = null;
        com.fasterxml.jackson.databind.k[] r4 = c(r16, r14, r15);
    L28:
        com.fasterxml.jackson.databind.k r10 = r3;
        com.fasterxml.jackson.databind.k[] r11 = r4;
        if (r14 != Properties.class) goto L31;
        l r9 = f;
        r2 = h.a(r14, r15, r10, r11, r9, r9);
    L33:
        if (r2 != null) goto L39;
        r2 = a(r16, r14, r15, r10, r11);
        if (r2 != null) goto L39;
        r2 = b(r16, r14, r15, r10, r11);
        if (r2 != null) goto L39;
        r17 = b(r14, r15, r10, r11);
    L39:
        r17 = r2;
        goto L40
    L31:
        if (r10 == null) goto L33;
        r2 = r10.a(r14, r15, r10, r11);
        goto L33
    L27:
        r3 = b(r16, r14, r15);
        r4 = c(r16, r14, r15);
        goto L28
    L16:
        c r5 = r13.b(r14);
        if (r5 == null) goto L20;
        k r12 = new k(r14, f12986b);
        r5.a(r12);
        return r12;
    L20:
        r16 = r13.a(r14);
        goto L22
    L7:
        if (r15.b() == true) goto L10;
        r1 = r15.a(r14);
        goto L11
    }

    public com.fasterxml.jackson.databind.k b(c r1, Class<?> r2, n r3) {
        Type r4 = com.fasterxml.jackson.databind.l.h.u(r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return a(r1, r4, r3);
    }

    public com.fasterxml.jackson.databind.k[] c(c r5, Class<?> r6, n r7) {
        Type[] r8 = com.fasterxml.jackson.databind.l.h.v(r6);
        if (r8 == null) goto L12;
        if (r8.length == 0) goto L12;
        int r0 = r8.length;
        com.fasterxml.jackson.databind.k[] r1 = new com.fasterxml.jackson.databind.k[r0];
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L10;
        r1[r2] = a(r5, r8[r2], r7);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L12:
        return p;
    }

    public com.fasterxml.jackson.databind.k a(c r1, Class<?> r2, n r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.k[] r5) {
        if (r3 != null) goto L5;
        r3 = f12986b;
    L5:
        if (r2 != Map.class) goto L9;
        return c(r2, r3, r4, r5);
    L9:
        if (r2 != Collection.class) goto L13;
        return d(r2, r3, r4, r5);
    L13:
        if (r2 == AtomicReference.class) goto L15;
        return null;
    L15:
        return e(r2, r3, r4, r5);
    }

    public com.fasterxml.jackson.databind.k b(c r2, Class<?> r3, n r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.k[] r6) {
        int r1 = r6.length;
        int r7 = 0;
    L3:
        if (r7 >= r1) goto L8;
        com.fasterxml.jackson.databind.k r0 = r6[r7].a(r3, r4, r5, r6);
        if (r0 != null) goto L6;
        r7 = r7 + 1;
        goto L3
    L6:
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.k a(c r6, ParameterizedType r7, n r8) {
        ParameterizedType r9 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r7, ParameterizedType.class, "com.obric.aiagent.plugin");
        Class<?> r0 = (Class) ZeusTransformUtils.preCheckCast(r9.getRawType(), Class.class, "com.obric.aiagent.plugin");
        if (r0 != u) goto L7;
        return i;
    L7:
        if (r0 != s) goto L11;
        return h;
    L11:
        if (r0 == t) goto L13;
        Type[] r10 = r9.getActualTypeArguments();
        int r1 = 0;
        if (r10 != null) goto L17;
        int r2 = 0;
    L18:
        if (r2 != 0) goto L20;
        n r11 = f12986b;
    L25:
        return a(r6, r0, r11);
    L20:
        com.fasterxml.jackson.databind.k[] r3 = new com.fasterxml.jackson.databind.k[r2];
    L21:
        if (r1 >= r2) goto L23;
        r3[r1] = a(r6, r10[r1], r8);
        r1 = r1 + 1;
        goto L21
    L23:
        r11 = n.a(r0, r3);
        goto L25
    L17:
        r2 = r10.length;
        goto L18
    L13:
        return j;
    }

    public com.fasterxml.jackson.databind.k a(c r3, GenericArrayType r4, n r5) {
        return a.a(a(r3, ((GenericArrayType) ZeusTransformUtils.wrapperContextForParams(r4, GenericArrayType.class, "com.obric.aiagent.plugin")).getGenericComponentType(), r5), r5);
    }

    public com.fasterxml.jackson.databind.k a(c r3, TypeVariable<?> r4, n r5) {
        TypeVariable r6 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r4, TypeVariable.class, "com.obric.aiagent.plugin");
        String r0 = r6.getName();
        if (r5 == null) goto L21;
        com.fasterxml.jackson.databind.k r1 = r5.b(r0);
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (r5.c(r0) == true) goto L10;
        n r7 = r5.a(r0);
        monitor-enter(r6);
        Type[] r2 = r6.getBounds();     // Catch: Throwable -> L17
        monitor-exit(r6);     // Catch: Throwable -> L17
        return a(r3, r2[0], r7);
    L17:
        th = move-exception;
        throw th;
    L10:
        return g;
    L21:
        throw new IllegalArgumentException("Null `bindings` passed (type variable \"" + r0 + "\")");
    }

    public com.fasterxml.jackson.databind.k a(c r3, WildcardType r4, n r5) {
        return a(r3, ((WildcardType) ZeusTransformUtils.wrapperContextForParams(r4, WildcardType.class, "com.obric.aiagent.plugin")).getUpperBounds()[0], r5);
    }
}
