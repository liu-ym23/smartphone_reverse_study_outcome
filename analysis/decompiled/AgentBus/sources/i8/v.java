package i8;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import v9.v0;

/* loaded from: classes.dex */
public final class v extends m implements f8.j0 {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f4890h = 0;

    /* renamed from: i, reason: collision with root package name */
    public final f8.j f4891i;

    /* renamed from: j, reason: collision with root package name */
    public final p9.d f4892j;

    public v(f8.e eVar) {
        super(g8.h.f3888a, e9.h.f3203d);
        this.f4891i = eVar;
        this.f4892j = new p9.c(eVar);
    }

    public static /* synthetic */ void F0(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                i10 = 2;
                break;
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "substitutor";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 5:
                objArr[1] = "getTypeParameters";
                break;
            case 6:
                objArr[1] = "getType";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 9:
                objArr[1] = "getVisibility";
                break;
            case 10:
                objArr[1] = "getOriginal";
                break;
            case 11:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i2) {
            case 3:
                objArr[2] = "substitute";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i2 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i2 == 1) {
            objArr[1] = "getValue";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void T(int i2) {
        String str = (i2 == 7 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 7 || i2 == 8) ? 2 : 3];
        switch (i2) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = "name";
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i2 == 7) {
            objArr[1] = "getValue";
        } else if (i2 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i2) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 7 && i2 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public final p9.d G0() {
        switch (this.f4890h) {
            case 0:
                p9.c cVar = (p9.c) this.f4892j;
                if (cVar != null) {
                    return cVar;
                }
                R(1);
                throw null;
            default:
                a4.d dVar = (a4.d) this.f4892j;
                if (dVar != null) {
                    return dVar;
                }
                T(7);
                throw null;
        }
    }

    @Override // f8.p0
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public final v d(v0 v0Var) {
        if (v0Var == null) {
            F0(3);
            throw null;
        }
        if (!v0Var.f10596a.e()) {
            v9.v vVarI = p() instanceof f8.e ? v0Var.i(3, getType()) : v0Var.i(1, getType());
            if (vVarI == null) {
                return null;
            }
            if (vVarI != getType()) {
                return new v(p(), new p9.e(vVarI), getAnnotations());
            }
        }
        return this;
    }

    @Override // f8.b
    public final v I() {
        return null;
    }

    @Override // f8.b
    public final boolean O() {
        return false;
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.f(this, obj);
    }

    @Override // i8.m, f8.j
    public final f8.b a() {
        return this;
    }

    @Override // f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = f8.o.f3493f;
        if (nVar != null) {
            return nVar;
        }
        F0(9);
        throw null;
    }

    @Override // f8.b
    public final v9.v f() {
        return getType();
    }

    @Override // a4.d, p9.d
    public final v9.v getType() {
        v9.v type = G0().getType();
        if (type != null) {
            return type;
        }
        F0(6);
        throw null;
    }

    @Override // f8.b
    public final List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        F0(5);
        throw null;
    }

    @Override // f8.j
    public final f8.j p() {
        switch (this.f4890h) {
            case 0:
                f8.e eVar = (f8.e) this.f4891i;
                if (eVar != null) {
                    return eVar;
                }
                R(2);
                throw null;
            default:
                f8.j jVar = this.f4891i;
                if (jVar != null) {
                    return jVar;
                }
                T(8);
                throw null;
        }
    }

    @Override // f8.k
    public final f8.n0 q() {
        return f8.n0.f3487b;
    }

    @Override // f8.b
    public final Collection r() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        F0(8);
        throw null;
    }

    @Override // i8.m
    public String toString() {
        switch (this.f4890h) {
            case 0:
                return "class " + ((f8.e) this.f4891i).getName() + "::this";
            default:
                return super.toString();
        }
    }

    @Override // f8.b
    public final List x0() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        F0(7);
        throw null;
    }

    @Override // f8.b
    public final v y() {
        return null;
    }

    @Override // i8.m, f8.j
    public final f8.j a() {
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(f8.j jVar, a4.d dVar, g8.j jVar2) {
        this(jVar, dVar, jVar2, e9.h.f3203d);
        if (jVar == null) {
            T(0);
            throw null;
        }
        if (jVar2 != null) {
        } else {
            T(2);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(f8.j jVar, a4.d dVar, g8.j jVar2, e9.f fVar) {
        super(jVar2, fVar);
        if (jVar == null) {
            T(3);
            throw null;
        }
        if (jVar2 == null) {
            T(5);
            throw null;
        }
        if (fVar != null) {
            this.f4891i = jVar;
            this.f4892j = dVar;
            return;
        }
        T(6);
        throw null;
    }
}
