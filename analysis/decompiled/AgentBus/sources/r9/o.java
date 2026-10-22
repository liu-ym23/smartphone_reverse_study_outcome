package r9;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import z7.m1;
import z7.q1;

/* loaded from: classes.dex */
public final class o extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9086g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f9087h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f9088i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9089j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(r rVar, f9.a aVar, int i2, int i10) {
        super(0);
        this.f9086g = i10;
        this.f9087h = rVar;
        this.f9088i = aVar;
        this.f9089j = i2;
    }

    /* JADX WARN: Type inference failed for: r5v13, types: [c7.f, java.lang.Object] */
    @Override // p7.a
    public final Object c() {
        switch (this.f9086g) {
            case 0:
                r rVar = (r) this.f9087h;
                k kVar = rVar.f9100a;
                a4.e eVarA = rVar.a((f8.j) kVar.f9072h);
                List listM1 = eVarA != null ? d7.r.m1(((i) kVar.f9070f).f9051e.j(eVarA, (f9.a) this.f9088i, this.f9089j)) : null;
                return listM1 == null ? d7.z.f2978f : listM1;
            case 1:
                r rVar2 = (r) this.f9087h;
                k kVar2 = rVar2.f9100a;
                a4.e eVarA2 = rVar2.a((f8.j) kVar2.f9072h);
                List listP = eVarA2 != null ? ((i) kVar2.f9070f).f9051e.p(eVarA2, (f9.a) this.f9088i, this.f9089j) : null;
                return listP == null ? d7.z.f2978f : listP;
            default:
                m1 m1Var = (m1) this.f9087h;
                q1 q1Var = m1Var.f11909g;
                Type type = q1Var != null ? (Type) q1Var.c() : null;
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    q7.k.d(componentType, "{\n                      …                        }");
                    return componentType;
                }
                boolean z4 = type instanceof GenericArrayType;
                int i2 = this.f9089j;
                if (z4) {
                    if (i2 == 0) {
                        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                        q7.k.d(genericComponentType, "{\n                      …                        }");
                        return genericComponentType;
                    }
                    throw new c7.i("Array type has been queried for a non-0th argument: " + m1Var, 3);
                }
                if (!(type instanceof ParameterizedType)) {
                    throw new c7.i("Non-generic type has been queried for arguments: " + m1Var, 3);
                }
                Type type2 = (Type) ((List) this.f9088i.getValue()).get(i2);
                if (type2 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type2;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    q7.k.d(lowerBounds, "argument.lowerBounds");
                    Type type3 = (Type) d7.n.h0(lowerBounds);
                    if (type3 == null) {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        q7.k.d(upperBounds, "argument.upperBounds");
                        type2 = (Type) d7.n.g0(upperBounds);
                    } else {
                        type2 = type3;
                    }
                }
                q7.k.d(type2, "{\n                      …                        }");
                return type2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(m1 m1Var, int i2, c7.f fVar) {
        super(0);
        this.f9086g = 2;
        this.f9087h = m1Var;
        this.f9089j = i2;
        this.f9088i = fVar;
    }
}
