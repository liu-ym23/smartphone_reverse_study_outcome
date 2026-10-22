package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.collections.j0;
import kotlin.collections.k0;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements KClass, ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21174b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f21175c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f21176d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f21177e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f21178f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f21179g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f21180a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(Class r10) {
            q.g(r10, "jClass");
            String r11 = null;
            if (r10.isAnonymousClass() == false) goto L6;
            return null;
        L6:
            if (r10.isLocalClass() == false) goto L9;
            return null;
        L9:
            if (r10.isArray() == false) goto L17;
            Class<?> r12 = r10.getComponentType();
            if (r12.isPrimitive() == false) goto L15;
            String r13 = (String) l.a().get(r12.getName());
            if (r13 == null) goto L15;
            r11 = r13 + "Array";
        L15:
            if (r11 != null) goto L21;
            return "kotlin.Array";
        L21:
            return r11;
        L17:
            String r14 = (String) l.a().get(r10.getName());
            if (r14 == null) goto L20;
            return r14;
        L20:
            return r10.getCanonicalName();
        }

        public final String b(Class r10) {
            q.g(r10, "jClass");
            String r11 = null;
            if (r10.isAnonymousClass() == false) goto L6;
            return null;
        L6:
            if (r10.isLocalClass() == false) goto L18;
            String r12 = r10.getSimpleName();
            Method r13 = r10.getEnclosingMethod();
            if (r13 == null) goto L13;
            q.d(r12);
            String r14 = StringsKt__StringsKt.u0(r12, r13.getName() + '$', null, 2, null);
            if (r14 == null) goto L13;
        L30:
            return r14;
        L13:
            Constructor<?> r15 = r10.getEnclosingConstructor();
            if (r15 == null) goto L16;
            q.d(r12);
            return StringsKt__StringsKt.u0(r12, r15.getName() + '$', null, 2, null);
        L16:
            q.d(r12);
            return StringsKt__StringsKt.t0(r12, '$', null, 2, null);
        L18:
            if (r10.isArray() == false) goto L26;
            Class<?> r16 = r10.getComponentType();
            r14 = "Array";
            if (r16.isPrimitive() == false) goto L24;
            String r17 = (String) l.c().get(r16.getName());
            if (r17 == null) goto L24;
            r11 = r17 + "Array";
        L24:
            if (r11 == null) goto L30;
            return r11;
        L26:
            String r18 = (String) l.c().get(r10.getName());
            if (r18 == null) goto L29;
            return r18;
        L29:
            return r10.getSimpleName();
        }

        public final boolean c(Object r10, Class r11) {
            q.g(r11, "jClass");
            Map r12 = l.b();
            q.e(r12, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer r13 = (Integer) r12.get(r11);
            if (r13 == null) goto L7;
            return y.k(r10, r13.intValue());
        L7:
            if (r11.isPrimitive() == false) goto L10;
            r11 = xf.a.b(xf.a.c(r11));
        L10:
            return r11.isInstance(r10);
        }

        public a() {
        }
    }

    static {
        f21174b = new a(null);
        List r10 = kotlin.collections.t.l(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r11 = new ArrayList(kotlin.collections.u.r(r10, 10));
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        kotlin.collections.t.q();
    L8:
        r11.add(kotlin.d.a((Class) r14, Integer.valueOf(r13)));
        r13 = r15;
        goto L4
    L9:
        f21175c = k0.q(r11);
        HashMap r16 = new HashMap();
        r16.put("boolean", "kotlin.Boolean");
        r16.put("char", "kotlin.Char");
        r16.put("byte", "kotlin.Byte");
        r16.put("short", "kotlin.Short");
        r16.put("int", "kotlin.Int");
        r16.put("float", "kotlin.Float");
        r16.put("long", "kotlin.Long");
        r16.put("double", "kotlin.Double");
        f21176d = r16;
        HashMap r17 = new HashMap();
        r17.put("java.lang.Boolean", "kotlin.Boolean");
        r17.put("java.lang.Character", "kotlin.Char");
        r17.put("java.lang.Byte", "kotlin.Byte");
        r17.put("java.lang.Short", "kotlin.Short");
        r17.put("java.lang.Integer", "kotlin.Int");
        r17.put("java.lang.Float", "kotlin.Float");
        r17.put("java.lang.Long", "kotlin.Long");
        r17.put("java.lang.Double", "kotlin.Double");
        f21177e = r17;
        HashMap r18 = new HashMap();
        r18.put("java.lang.Object", "kotlin.Any");
        r18.put("java.lang.String", "kotlin.String");
        r18.put("java.lang.CharSequence", "kotlin.CharSequence");
        r18.put("java.lang.Throwable", "kotlin.Throwable");
        r18.put("java.lang.Cloneable", "kotlin.Cloneable");
        r18.put("java.lang.Number", "kotlin.Number");
        r18.put("java.lang.Comparable", "kotlin.Comparable");
        r18.put("java.lang.Enum", "kotlin.Enum");
        r18.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        r18.put("java.lang.Iterable", "kotlin.collections.Iterable");
        r18.put("java.util.Iterator", "kotlin.collections.Iterator");
        r18.put("java.util.Collection", "kotlin.collections.Collection");
        r18.put("java.util.List", "kotlin.collections.List");
        r18.put("java.util.Set", "kotlin.collections.Set");
        r18.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        r18.put("java.util.Map", "kotlin.collections.Map");
        r18.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        r18.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        r18.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        r18.putAll(r16);
        r18.putAll(r17);
        Collection r19 = r16.values();
        q.f(r19, "<get-values>(...)");
        Iterator r20 = r19.iterator();
    L11:
        if (r20.hasNext() == false) goto L13;
        String r21 = (String) r20.next();
        StringBuilder r22 = new StringBuilder();
        r22.append("kotlin.jvm.internal.");
        q.d(r21);
        r22.append(StringsKt__StringsKt.w0(r21, '.', null, 2, null));
        r22.append("CompanionObject");
        Pair r23 = kotlin.d.a(r22.toString(), r21 + ".Companion");
        r18.put(r23.getFirst(), r23.getSecond());
        goto L11
    L13:
        Iterator r24 = f21175c.entrySet().iterator();
    L15:
        if (r24.hasNext() == false) goto L17;
        Map.Entry r25 = (Map.Entry) r24.next();
        Class r26 = (Class) r25.getKey();
        int r27 = ((Number) r25.getValue()).intValue();
        r18.put(r26.getName(), "kotlin.Function" + r27);
        goto L15
    L17:
        f21178f = r18;
        LinkedHashMap r28 = new LinkedHashMap(j0.e(r18.size()));
        Iterator r29 = r18.entrySet().iterator();
    L19:
        if (r29.hasNext() == false) goto L21;
        Map.Entry r30 = (Map.Entry) r29.next();
        r28.put(r30.getKey(), StringsKt__StringsKt.w0((String) r30.getValue(), '.', null, 2, null));
        goto L19
    L21:
        f21179g = r28;
    }

    public l(Class r10) {
        q.g(r10, "jClass");
        this.f21180a = r10;
    }

    public static final /* synthetic */ HashMap a() {
        return f21178f;
    }

    public static final /* synthetic */ Map b() {
        return f21175c;
    }

    public static final /* synthetic */ Map c() {
        return f21179g;
    }

    public final Void d() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object r10) {
        if ((r10 instanceof l) == true) goto L5;
    L7:
        return false;
    L5:
        if (q.b(xf.a.b(this), xf.a.b((KClass) r10)) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List getAnnotations() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection getConstructors() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class getJClass() {
        return this.f21180a;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public Collection getMembers() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection getNestedClasses() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return f21174b.a(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List getSealedSubclasses() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return f21174b.b(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List getSupertypes() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public List getTypeParameters() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return xf.a.b(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object r10) {
        return f21174b.c(r10, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        d();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
