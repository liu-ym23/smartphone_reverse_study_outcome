package n8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import kotlin.collections.EmptyList;
import x8.InterfaceC2121d;

/* loaded from: classes4.dex */
public final class j extends u implements InterfaceC2121d {

    /* renamed from: a, reason: collision with root package name */
    public final Type f5359a;
    public final l b;

    public j(Type reflectType) {
        l aVar;
        kotlin.jvm.internal.k.f(reflectType, "reflectType");
        this.f5359a = reflectType;
        if (reflectType instanceof Class) {
            aVar = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            aVar = new v((TypeVariable) reflectType);
        } else {
            if (!(reflectType instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + reflectType.getClass() + "): " + reflectType);
            }
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            kotlin.jvm.internal.k.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            aVar = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a((Class) rawType);
        }
        this.b = aVar;
    }

    @Override // n8.u, x8.InterfaceC2119b
    public final d a(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return null;
    }

    @Override // n8.u
    public final Type b() {
        return this.f5359a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList c() {
        /*
            r5 = this;
            java.lang.reflect.Type r5 = r5.f5359a
            java.util.List r5 = n8.AbstractC1744c.c(r5)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = D7.w.c0(r5, r1)
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L17:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L68
            java.lang.Object r1 = r5.next()
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            java.lang.String r2 = "type"
            kotlin.jvm.internal.k.f(r1, r2)
            boolean r2 = r1 instanceof java.lang.Class
            if (r2 == 0) goto L3b
            r3 = r1
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r4 = r3.isPrimitive()
            if (r4 == 0) goto L3b
            n8.s r1 = new n8.s
            r1.<init>(r3)
            goto L64
        L3b:
            boolean r3 = r1 instanceof java.lang.reflect.GenericArrayType
            if (r3 != 0) goto L5e
            if (r2 == 0) goto L4b
            r2 = r1
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r2 = r2.isArray()
            if (r2 == 0) goto L4b
            goto L5e
        L4b:
            boolean r2 = r1 instanceof java.lang.reflect.WildcardType
            if (r2 == 0) goto L58
            n8.x r2 = new n8.x
            java.lang.reflect.WildcardType r1 = (java.lang.reflect.WildcardType) r1
            r2.<init>(r1)
        L56:
            r1 = r2
            goto L64
        L58:
            n8.j r2 = new n8.j
            r2.<init>(r1)
            goto L56
        L5e:
            n8.h r2 = new n8.h
            r2.<init>(r1)
            goto L56
        L64:
            r0.add(r1)
            goto L17
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.j.c():java.util.ArrayList");
    }

    public final boolean d() {
        Type type = this.f5359a;
        if (type instanceof Class) {
            TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
            kotlin.jvm.internal.k.e(typeParameters, "getTypeParameters(...)");
            if (!(typeParameters.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        return EmptyList.f4893a;
    }
}
