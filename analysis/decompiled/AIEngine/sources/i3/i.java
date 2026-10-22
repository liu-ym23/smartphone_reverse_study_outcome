package i3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends i3.e implements Comparable<i> {

    /* renamed from: p, reason: collision with root package name */
    public static final AnnotationIntrospector.ReferenceProperty f9516p = new AnnotationIntrospector.ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type.f3649a, "");

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9517b;

    /* renamed from: c, reason: collision with root package name */
    public final MapperConfig<?> f9518c;

    /* renamed from: d, reason: collision with root package name */
    public final AnnotationIntrospector f9519d;

    /* renamed from: e, reason: collision with root package name */
    public final PropertyName f9520e;
    public final PropertyName h;

    /* renamed from: j, reason: collision with root package name */
    public e<AnnotatedField> f9521j;

    /* renamed from: k, reason: collision with root package name */
    public e<AnnotatedParameter> f9522k;

    /* renamed from: l, reason: collision with root package name */
    public e<AnnotatedMethod> f9523l;

    /* renamed from: m, reason: collision with root package name */
    public e<AnnotatedMethod> f9524m;

    /* renamed from: n, reason: collision with root package name */
    public transient PropertyMetadata f9525n;

    /* renamed from: o, reason: collision with root package name */
    public transient AnnotationIntrospector.ReferenceProperty f9526o;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements g<Class<?>[]> {
        public a() {
        }

        @Override // i3.i.g
        public final Class<?>[] a(AnnotatedMember annotatedMember) {
            return i.this.f9519d.b0(annotatedMember);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements g<AnnotationIntrospector.ReferenceProperty> {
        public b() {
        }

        @Override // i3.i.g
        public final AnnotationIntrospector.ReferenceProperty a(AnnotatedMember annotatedMember) {
            return i.this.f9519d.N(annotatedMember);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements g<Boolean> {
        public c() {
        }

        @Override // i3.i.g
        public final Boolean a(AnnotatedMember annotatedMember) {
            return i.this.f9519d.n0(annotatedMember);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements g<h> {
        public d() {
        }

        @Override // i3.i.g
        public final h a(AnnotatedMember annotatedMember) {
            i iVar = i.this;
            h hVarY = iVar.f9519d.y(annotatedMember);
            return hVarY != null ? iVar.f9519d.z(annotatedMember, hVarY) : hVarY;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f9531a;

        /* renamed from: b, reason: collision with root package name */
        public final e<T> f9532b;

        /* renamed from: c, reason: collision with root package name */
        public final PropertyName f9533c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f9534d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f9535e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f9536f;

        public e(T t8, e<T> eVar, PropertyName propertyName, boolean z, boolean z3, boolean z10) {
            this.f9531a = t8;
            this.f9532b = eVar;
            PropertyName propertyName2 = (propertyName == null || propertyName.c()) ? null : propertyName;
            this.f9533c = propertyName2;
            if (z) {
                if (propertyName2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (propertyName.f3755a.isEmpty()) {
                    z = false;
                }
            }
            this.f9534d = z;
            this.f9535e = z3;
            this.f9536f = z10;
        }

        public final e<T> a(e<T> eVar) {
            e<T> eVar2 = this.f9532b;
            return eVar2 == null ? c(eVar) : c(eVar2.a(eVar));
        }

        public final e<T> b() {
            e<T> eVar = this.f9532b;
            if (eVar == null) {
                return this;
            }
            e<T> eVarB = eVar.b();
            if (this.f9533c != null) {
                return eVarB.f9533c == null ? c(null) : c(eVarB);
            }
            if (eVarB.f9533c == null) {
                boolean z = eVarB.f9535e;
                boolean z3 = this.f9535e;
                if (z3 == z) {
                    return c(eVarB);
                }
                if (z3) {
                    return c(null);
                }
            }
            return eVarB;
        }

        public final e<T> c(e<T> eVar) {
            if (eVar == this.f9532b) {
                return this;
            }
            return new e<>(this.f9531a, eVar, this.f9533c, this.f9534d, this.f9535e, this.f9536f);
        }

        public final e<T> d() {
            e<T> eVarD;
            boolean z = this.f9536f;
            e<T> eVar = this.f9532b;
            if (!z) {
                return (eVar == null || (eVarD = eVar.d()) == eVar) ? this : c(eVarD);
            }
            if (eVar == null) {
                return null;
            }
            return eVar.d();
        }

        public final e<T> e() {
            e<T> eVar = this.f9532b;
            e<T> eVarE = eVar == null ? null : eVar.e();
            return this.f9535e ? c(eVarE) : eVarE;
        }

        public final String toString() {
            String str = this.f9531a.toString() + "[visible=" + this.f9535e + ",ignore=" + this.f9536f + ",explicitName=" + this.f9534d + "]";
            e<T> eVar = this.f9532b;
            if (eVar == null) {
                return str;
            }
            StringBuilder sbP = a0.a.p(str, ", ");
            sbP.append(eVar.toString());
            return sbP.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class f<T extends AnnotatedMember> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public e<T> f9537a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f9537a != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            e<T> eVar = this.f9537a;
            if (eVar == null) {
                throw new NoSuchElementException();
            }
            T t8 = eVar.f9531a;
            this.f9537a = eVar.f9532b;
            return t8;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface g<T> {
        T a(AnnotatedMember annotatedMember);
    }

    public i() {
        throw null;
    }

    public i(MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z, PropertyName propertyName, PropertyName propertyName2) {
        this.f9518c = mapperConfig;
        this.f9519d = annotationIntrospector;
        this.h = propertyName;
        this.f9520e = propertyName2;
        this.f9517b = z;
    }

    public static boolean C(e eVar) {
        while (eVar != null) {
            if (eVar.f9533c != null && eVar.f9534d) {
                return true;
            }
            eVar = eVar.f9532b;
        }
        return false;
    }

    public static boolean D(e eVar) {
        while (eVar != null) {
            PropertyName propertyName = eVar.f9533c;
            if (propertyName != null && !propertyName.f3755a.isEmpty()) {
                return true;
            }
            eVar = eVar.f9532b;
        }
        return false;
    }

    public static boolean E(e eVar) {
        while (eVar != null) {
            if (eVar.f9536f) {
                return true;
            }
            eVar = eVar.f9532b;
        }
        return false;
    }

    public static boolean F(e eVar) {
        while (eVar != null) {
            if (eVar.f9535e) {
                return true;
            }
            eVar = eVar.f9532b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e G(e eVar, i3.c cVar) {
        AnnotatedMember annotatedMember = (AnnotatedMember) ((AnnotatedMember) eVar.f9531a).n(cVar);
        e<T> eVar2 = eVar.f9532b;
        if (eVar2 != 0) {
            eVar = eVar.c(G(eVar2, cVar));
        }
        return annotatedMember == eVar.f9531a ? eVar : new e(annotatedMember, eVar.f9532b, eVar.f9533c, eVar.f9534d, eVar.f9535e, eVar.f9536f);
    }

    public static Set I(e eVar, Set set) {
        while (eVar != null) {
            PropertyName propertyName = eVar.f9533c;
            if (eVar.f9534d && propertyName != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(propertyName);
            }
            eVar = eVar.f9532b;
        }
        return set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static i3.c J(e eVar) {
        i3.c cVar = ((AnnotatedMember) eVar.f9531a).f4123b;
        e<T> eVar2 = eVar.f9532b;
        return eVar2 != 0 ? i3.c.b(cVar, J(eVar2)) : cVar;
    }

    public static int K(AnnotatedMethod annotatedMethod) {
        String name = annotatedMethod.f4124d.getName();
        if (!name.startsWith("get") || name.length() <= 3) {
            return (!name.startsWith("is") || name.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    public static i3.c L(int i10, e... eVarArr) {
        i3.c cVarJ = J(eVarArr[i10]);
        do {
            i10++;
            if (i10 >= eVarArr.length) {
                return cVarJ;
            }
        } while (eVarArr[i10] == null);
        return i3.c.b(cVarJ, L(i10, eVarArr));
    }

    @Override // i3.e
    public final boolean A() {
        return C(this.f9521j) || C(this.f9523l) || C(this.f9524m) || C(this.f9522k);
    }

    @Override // i3.e
    public final boolean B() {
        Boolean bool = (Boolean) N(new c());
        return bool != null && bool.booleanValue();
    }

    public final void H(Set set, HashMap map, e eVar) {
        for (e eVar2 = eVar; eVar2 != null; eVar2 = eVar2.f9532b) {
            PropertyName propertyName = eVar2.f9533c;
            if (eVar2.f9534d && propertyName != null) {
                i iVar = (i) map.get(propertyName);
                if (iVar == null) {
                    iVar = new i(this.f9518c, this.f9519d, this.f9517b, this.h, propertyName);
                    map.put(propertyName, iVar);
                }
                if (eVar == this.f9521j) {
                    iVar.f9521j = eVar2.c(iVar.f9521j);
                } else if (eVar == this.f9523l) {
                    iVar.f9523l = eVar2.c(iVar.f9523l);
                } else if (eVar == this.f9524m) {
                    iVar.f9524m = eVar2.c(iVar.f9524m);
                } else {
                    if (eVar != this.f9522k) {
                        throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
                    }
                    iVar.f9522k = eVar2.c(iVar.f9522k);
                }
            } else if (eVar2.f9535e) {
                StringBuilder sb2 = new StringBuilder("Conflicting/ambiguous property name definitions (implicit name ");
                Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
                PropertyName propertyName2 = this.f9520e;
                sb2.append(propertyName2 == null ? "[null]" : com.fasterxml.jackson.databind.util.a.c(propertyName2.f3755a));
                sb2.append("): found multiple explicit names: ");
                sb2.append(set);
                sb2.append(", but also implicit accessor: ");
                sb2.append(eVar2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final void M(i iVar) {
        e<AnnotatedField> eVarA = this.f9521j;
        e<AnnotatedField> eVar = iVar.f9521j;
        if (eVarA == null) {
            eVarA = eVar;
        } else if (eVar != null) {
            eVarA = eVarA.a(eVar);
        }
        this.f9521j = eVarA;
        e<AnnotatedParameter> eVarA2 = this.f9522k;
        e<AnnotatedParameter> eVar2 = iVar.f9522k;
        if (eVarA2 == null) {
            eVarA2 = eVar2;
        } else if (eVar2 != null) {
            eVarA2 = eVarA2.a(eVar2);
        }
        this.f9522k = eVarA2;
        e<AnnotatedMethod> eVarA3 = this.f9523l;
        e<AnnotatedMethod> eVar3 = iVar.f9523l;
        if (eVarA3 == null) {
            eVarA3 = eVar3;
        } else if (eVar3 != null) {
            eVarA3 = eVarA3.a(eVar3);
        }
        this.f9523l = eVarA3;
        e<AnnotatedMethod> eVarA4 = this.f9524m;
        e<AnnotatedMethod> eVar4 = iVar.f9524m;
        if (eVarA4 == null) {
            eVarA4 = eVar4;
        } else if (eVar4 != null) {
            eVarA4 = eVarA4.a(eVar4);
        }
        this.f9524m = eVarA4;
    }

    public final <T> T N(g<T> gVar) {
        e<AnnotatedMethod> eVar;
        e<AnnotatedField> eVar2;
        if (this.f9519d != null) {
            if (this.f9517b) {
                e<AnnotatedMethod> eVar3 = this.f9523l;
                if (eVar3 != null) {
                    tA = gVar.a(eVar3.f9531a);
                }
            } else {
                e<AnnotatedParameter> eVar4 = this.f9522k;
                tA = eVar4 != null ? gVar.a(eVar4.f9531a) : null;
                if (tA == null && (eVar = this.f9524m) != null) {
                    tA = gVar.a(eVar.f9531a);
                }
            }
            if (tA == null && (eVar2 = this.f9521j) != null) {
                return gVar.a(eVar2.f9531a);
            }
        }
        return tA;
    }

    public final AnnotatedMember O() {
        if (this.f9517b) {
            return m();
        }
        AnnotatedMember annotatedMemberN = n();
        if (annotatedMemberN == null && (annotatedMemberN = t()) == null) {
            annotatedMemberN = p();
        }
        return annotatedMemberN == null ? m() : annotatedMemberN;
    }

    @Override // i3.e
    public final PropertyName b() {
        return this.f9520e;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d1  */
    @Override // i3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.PropertyMetadata c() {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.i.c():com.fasterxml.jackson.databind.PropertyMetadata");
    }

    @Override // java.lang.Comparable
    public final int compareTo(i iVar) {
        i iVar2 = iVar;
        if (this.f9522k != null) {
            if (iVar2.f9522k == null) {
                return -1;
            }
        } else if (iVar2.f9522k != null) {
            return 1;
        }
        return getName().compareTo(iVar2.getName());
    }

    @Override // i3.e
    public final boolean g() {
        return (this.f9522k == null && this.f9524m == null && this.f9521j == null) ? false : true;
    }

    @Override // q3.k
    public final String getName() {
        PropertyName propertyName = this.f9520e;
        if (propertyName == null) {
            return null;
        }
        return propertyName.f3755a;
    }

    @Override // i3.e
    public final boolean h() {
        return (this.f9523l == null && this.f9521j == null) ? false : true;
    }

    @Override // i3.e
    public final JsonInclude.Value i() {
        AnnotatedMember annotatedMemberM = m();
        AnnotationIntrospector annotationIntrospector = this.f9519d;
        JsonInclude.Value valueJ = annotationIntrospector == null ? null : annotationIntrospector.J(annotatedMemberM);
        return valueJ == null ? JsonInclude.Value.f3469e : valueJ;
    }

    @Override // i3.e
    public final h j() {
        return (h) N(new d());
    }

    @Override // i3.e
    public final AnnotationIntrospector.ReferenceProperty k() {
        AnnotationIntrospector.ReferenceProperty referenceProperty = this.f9526o;
        AnnotationIntrospector.ReferenceProperty referenceProperty2 = f9516p;
        if (referenceProperty != null) {
            if (referenceProperty == referenceProperty2) {
                return null;
            }
            return referenceProperty;
        }
        AnnotationIntrospector.ReferenceProperty referenceProperty3 = (AnnotationIntrospector.ReferenceProperty) N(new b());
        if (referenceProperty3 != null) {
            referenceProperty2 = referenceProperty3;
        }
        this.f9526o = referenceProperty2;
        return referenceProperty3;
    }

    @Override // i3.e
    public final Class<?>[] l() {
        return (Class[]) N(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i3.e
    public final AnnotatedParameter n() {
        e eVar = this.f9522k;
        if (eVar == null) {
            return null;
        }
        do {
            T t8 = eVar.f9531a;
            if (((AnnotatedParameter) t8).f4129c instanceof AnnotatedConstructor) {
                return (AnnotatedParameter) t8;
            }
            eVar = eVar.f9532b;
        } while (eVar != null);
        return this.f9522k.f9531a;
    }

    @Override // i3.e
    public final Iterator<AnnotatedParameter> o() {
        e<AnnotatedParameter> eVar = this.f9522k;
        if (eVar == null) {
            return com.fasterxml.jackson.databind.util.a.f4531c;
        }
        f fVar = new f();
        fVar.f9537a = eVar;
        return fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i3.e
    public final AnnotatedField p() {
        e<AnnotatedField> eVar = this.f9521j;
        if (eVar == null) {
            return null;
        }
        AnnotatedField annotatedField = eVar.f9531a;
        for (e eVar2 = eVar.f9532b; eVar2 != null; eVar2 = eVar2.f9532b) {
            AnnotatedField annotatedField2 = (AnnotatedField) eVar2.f9531a;
            Class<?> declaringClass = annotatedField.f4118c.getDeclaringClass();
            Class<?> declaringClass2 = annotatedField2.f4118c.getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (declaringClass.isAssignableFrom(declaringClass2)) {
                    annotatedField = annotatedField2;
                } else if (declaringClass2.isAssignableFrom(declaringClass)) {
                }
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + annotatedField.i() + " vs " + annotatedField2.i());
        }
        return annotatedField;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    @Override // i3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.introspect.AnnotatedMethod q() {
        /*
            r9 = this;
            i3.i$e<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r0 = r9.f9523l
            if (r0 != 0) goto L6
            r9 = 0
            return r9
        L6:
            i3.i$e<T> r1 = r0.f9532b
            if (r1 != 0) goto Lf
            T r9 = r0.f9531a
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r9 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r9
            return r9
        Lf:
            T r3 = r0.f9531a
            if (r1 == 0) goto L75
            T r2 = r1.f9531a
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r3 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r3
            java.lang.reflect.Method r4 = r3.f4124d
            java.lang.Class r4 = r4.getDeclaringClass()
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r2 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r2
            java.lang.reflect.Method r5 = r2.f4124d
            java.lang.Class r5 = r5.getDeclaringClass()
            if (r4 == r5) goto L35
            boolean r6 = r4.isAssignableFrom(r5)
            if (r6 == 0) goto L2e
            goto L41
        L2e:
            boolean r4 = r5.isAssignableFrom(r4)
            if (r4 == 0) goto L35
            goto L42
        L35:
            int r4 = K(r2)
            int r5 = K(r3)
            if (r4 == r5) goto L45
            if (r4 >= r5) goto L42
        L41:
            r0 = r1
        L42:
            i3.i$e<T> r1 = r1.f9532b
            goto Lf
        L45:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "Conflicting getter definitions for property \""
            r1.<init>(r4)
            java.lang.String r9 = r9.getName()
            r1.append(r9)
            java.lang.String r9 = "\": "
            r1.append(r9)
            java.lang.String r9 = r3.i()
            r1.append(r9)
            java.lang.String r9 = " vs "
            r1.append(r9)
            java.lang.String r9 = r2.i()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        L75:
            i3.i$e<T> r1 = r0.f9532b
            if (r1 != 0) goto L7a
            goto L89
        L7a:
            i3.i$e r2 = new i3.i$e
            com.fasterxml.jackson.databind.PropertyName r5 = r0.f9533c
            boolean r6 = r0.f9534d
            boolean r7 = r0.f9535e
            boolean r8 = r0.f9536f
            r4 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0 = r2
        L89:
            r9.f9523l = r0
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r3 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.i.q():com.fasterxml.jackson.databind.introspect.AnnotatedMethod");
    }

    @Override // i3.e
    public final JavaType r() {
        if (this.f9517b) {
            i3.a aVarQ = q();
            return (aVarQ == null && (aVarQ = p()) == null) ? TypeFactory.n() : aVarQ.f();
        }
        i3.a aVarN = n();
        if (aVarN == null) {
            AnnotatedMethod annotatedMethodT = t();
            if (annotatedMethodT != null) {
                return annotatedMethodT.t(0);
            }
            aVarN = p();
        }
        return (aVarN == null && (aVarN = q()) == null) ? TypeFactory.n() : aVarN.f();
    }

    @Override // i3.e
    public final Class<?> s() {
        return r().f3690a;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    @Override // i3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.introspect.AnnotatedMethod t() {
        /*
            r10 = this;
            i3.i$e<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r0 = r10.f9524m
            if (r0 != 0) goto L6
            r10 = 0
            return r10
        L6:
            i3.i$e<T> r1 = r0.f9532b
            if (r1 != 0) goto Lf
            T r10 = r0.f9531a
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r10 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r10
            return r10
        Lf:
            T r3 = r0.f9531a
            if (r1 == 0) goto L9b
            T r2 = r1.f9531a
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r3 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r3
            java.lang.reflect.Method r4 = r3.f4124d
            java.lang.Class r4 = r4.getDeclaringClass()
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r2 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r2
            java.lang.reflect.Method r5 = r2.f4124d
            java.lang.Class r5 = r5.getDeclaringClass()
            if (r4 == r5) goto L35
            boolean r6 = r4.isAssignableFrom(r5)
            if (r6 == 0) goto L2e
            goto L74
        L2e:
            boolean r4 = r5.isAssignableFrom(r4)
            if (r4 == 0) goto L35
            goto L75
        L35:
            java.lang.reflect.Method r4 = r2.f4124d
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = "set"
            boolean r6 = r4.startsWith(r5)
            r7 = 2
            r8 = 1
            r9 = 3
            if (r6 == 0) goto L4e
            int r4 = r4.length()
            if (r4 <= r9) goto L4e
            r4 = r8
            goto L4f
        L4e:
            r4 = r7
        L4f:
            java.lang.reflect.Method r6 = r3.f4124d
            java.lang.String r6 = r6.getName()
            boolean r5 = r6.startsWith(r5)
            if (r5 == 0) goto L62
            int r5 = r6.length()
            if (r5 <= r9) goto L62
            r7 = r8
        L62:
            if (r4 == r7) goto L67
            if (r4 >= r7) goto L75
            goto L74
        L67:
            com.fasterxml.jackson.databind.AnnotationIntrospector r4 = r10.f9519d
            if (r4 == 0) goto L78
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r4 = r4.q0(r3, r2)
            if (r4 != r3) goto L72
            goto L75
        L72:
            if (r4 != r2) goto L78
        L74:
            r0 = r1
        L75:
            i3.i$e<T> r1 = r1.f9532b
            goto Lf
        L78:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.getName()
            java.lang.String r1 = r3.i()
            java.lang.String r2 = r2.i()
            java.lang.String r3 = "\": "
            java.lang.String r4 = " vs "
            java.lang.String r5 = "Conflicting setter definitions for property \""
            java.lang.StringBuilder r10 = ai.onnxruntime.a.s(r5, r10, r3, r1, r4)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r0.<init>(r10)
            throw r0
        L9b:
            i3.i$e<T> r1 = r0.f9532b
            if (r1 != 0) goto La0
            goto Laf
        La0:
            i3.i$e r2 = new i3.i$e
            com.fasterxml.jackson.databind.PropertyName r5 = r0.f9533c
            boolean r6 = r0.f9534d
            boolean r7 = r0.f9535e
            boolean r8 = r0.f9536f
            r4 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0 = r2
        Laf:
            r10.f9524m = r0
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r3 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.i.t():com.fasterxml.jackson.databind.introspect.AnnotatedMethod");
    }

    public final String toString() {
        return "[Property '" + this.f9520e + "'; ctors: " + this.f9522k + ", field(s): " + this.f9521j + ", getter(s): " + this.f9523l + ", setter(s): " + this.f9524m + "]";
    }

    @Override // i3.e
    public final PropertyName u() {
        AnnotationIntrospector annotationIntrospector;
        if (O() != null && (annotationIntrospector = this.f9519d) != null) {
            annotationIntrospector.getClass();
        }
        return null;
    }

    @Override // i3.e
    public final boolean v() {
        return this.f9522k != null;
    }

    @Override // i3.e
    public final boolean w() {
        return this.f9521j != null;
    }

    @Override // i3.e
    public final boolean x(PropertyName propertyName) {
        return this.f9520e.equals(propertyName);
    }

    @Override // i3.e
    public final boolean y() {
        return this.f9524m != null;
    }

    @Override // i3.e
    public final boolean z() {
        return D(this.f9521j) || D(this.f9523l) || D(this.f9524m) || C(this.f9522k);
    }

    public i(i iVar, PropertyName propertyName) {
        this.f9518c = iVar.f9518c;
        this.f9519d = iVar.f9519d;
        this.h = iVar.h;
        this.f9520e = propertyName;
        this.f9521j = iVar.f9521j;
        this.f9522k = iVar.f9522k;
        this.f9523l = iVar.f9523l;
        this.f9524m = iVar.f9524m;
        this.f9517b = iVar.f9517b;
    }
}
