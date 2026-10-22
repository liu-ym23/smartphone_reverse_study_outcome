package l8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

/* loaded from: classes.dex */
public final class q extends b0 implements v8.d {

    /* renamed from: a, reason: collision with root package name */
    public final Type f5880a;

    /* renamed from: b, reason: collision with root package name */
    public final s f5881b;

    public q(Type type) {
        s oVar;
        q7.k.e(type, "reflectType");
        this.f5880a = type;
        if (type instanceof Class) {
            oVar = new o((Class) type);
        } else if (type instanceof TypeVariable) {
            oVar = new c0((TypeVariable) type);
        } else {
            if (!(type instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + type.getClass() + "): " + type);
            }
            Type rawType = ((ParameterizedType) type).getRawType();
            q7.k.c(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            oVar = new o((Class) rawType);
        }
        this.f5881b = oVar;
    }

    @Override // l8.b0, v8.b
    public final e a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        return null;
    }

    @Override // l8.b0
    public final Type b() {
        return this.f5880a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList c() {
        /*
            r5 = this;
            java.lang.reflect.Type r5 = r5.f5880a
            java.util.List r5 = l8.d.c(r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = d7.t.A0(r5, r1)
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L15:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L66
            java.lang.Object r1 = r5.next()
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            java.lang.String r2 = "type"
            q7.k.e(r1, r2)
            boolean r2 = r1 instanceof java.lang.Class
            if (r2 == 0) goto L39
            r3 = r1
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r4 = r3.isPrimitive()
            if (r4 == 0) goto L39
            l8.z r1 = new l8.z
            r1.<init>(r3)
            goto L62
        L39:
            boolean r3 = r1 instanceof java.lang.reflect.GenericArrayType
            if (r3 != 0) goto L5c
            if (r2 == 0) goto L49
            r2 = r1
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r2 = r2.isArray()
            if (r2 == 0) goto L49
            goto L5c
        L49:
            boolean r2 = r1 instanceof java.lang.reflect.WildcardType
            if (r2 == 0) goto L56
            l8.e0 r2 = new l8.e0
            java.lang.reflect.WildcardType r1 = (java.lang.reflect.WildcardType) r1
            r2.<init>(r1)
        L54:
            r1 = r2
            goto L62
        L56:
            l8.q r2 = new l8.q
            r2.<init>(r1)
            goto L54
        L5c:
            l8.i r2 = new l8.i
            r2.<init>(r1)
            goto L54
        L62:
            r0.add(r1)
            goto L15
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.q.c():java.util.ArrayList");
    }

    public final boolean d() {
        Type type = this.f5880a;
        if (type instanceof Class) {
            TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
            q7.k.d(typeParameters, "getTypeParameters()");
            if (!(typeParameters.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        return d7.z.f2978f;
    }
}
