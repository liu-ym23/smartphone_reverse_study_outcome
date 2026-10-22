package i8;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class j0 extends g0 implements f8.k0 {

    /* renamed from: r, reason: collision with root package name */
    public v9.v f4813r;

    /* renamed from: s, reason: collision with root package name */
    public final j0 f4814s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(f8.l0 l0Var, g8.j jVar, int i2, f8.n nVar, boolean z4, boolean z10, boolean z11, int i10, j0 j0Var, f8.n0 n0Var) {
        super(i2, nVar, l0Var, jVar, e9.f.g("<get-" + l0Var.getName() + ">"), z4, z10, z11, i10, n0Var);
        if (jVar == null) {
            R(1);
            throw null;
        }
        if (i2 == 0) {
            R(2);
            throw null;
        }
        if (nVar == null) {
            R(3);
            throw null;
        }
        if (i10 == 0) {
            R(4);
            throw null;
        }
        if (n0Var == null) {
            R(5);
            throw null;
        }
        this.f4814s = j0Var != null ? j0Var : this;
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 6 || i2 == 7 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 6 || i2 == 7 || i2 == 8) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i2 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i2 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i2 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // i8.n, i8.m, f8.j
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public final j0 a() {
        j0 j0Var = this.f4814s;
        if (j0Var != null) {
            return j0Var;
        }
        R(8);
        throw null;
    }

    public final void J0(v9.v vVar) {
        if (vVar == null) {
            vVar = G0().getType();
        }
        this.f4813r = vVar;
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.u(this, obj);
    }

    @Override // f8.b
    public final v9.v f() {
        return this.f4813r;
    }

    @Override // f8.c, f8.b
    public final Collection r() {
        return H0(true);
    }

    @Override // f8.b
    public final List x0() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        R(7);
        throw null;
    }
}
