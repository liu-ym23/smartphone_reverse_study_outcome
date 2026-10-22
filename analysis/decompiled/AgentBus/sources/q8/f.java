package q8;

import c7.j;
import c8.h;
import c8.r;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import d7.z;
import f8.l0;
import f8.n;
import f8.n0;
import h9.m;
import i8.i0;
import i8.j0;
import i8.k0;
import i8.r0;
import java.util.ArrayList;
import o8.x;
import q7.k;
import v9.v;

/* loaded from: classes.dex */
public class f extends i0 implements a {
    public final boolean F;
    public final j G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(f8.j jVar, g8.j jVar2, int i2, n nVar, boolean z4, e9.f fVar, n0 n0Var, l0 l0Var, int i10, boolean z10, j jVar3) {
        super(jVar, l0Var, jVar2, i2, nVar, z4, fVar, i10, n0Var, false, false, false, false, false);
        if (jVar == null) {
            R(0);
            throw null;
        }
        if (jVar2 == null) {
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
        if (fVar == null) {
            R(4);
            throw null;
        }
        if (n0Var == null) {
            R(5);
            throw null;
        }
        if (i10 == 0) {
            R(6);
            throw null;
        }
        this.F = z10;
        this.G = jVar3;
    }

    public static f O0(f8.j jVar, r8.d dVar, n nVar, boolean z4, e9.f fVar, k8.g gVar, boolean z10) {
        if (jVar == null) {
            R(7);
            throw null;
        }
        if (fVar != null) {
            return new f(jVar, dVar, 1, nVar, z4, fVar, gVar, null, 1, z10, null);
        }
        R(11);
        throw null;
    }

    public static /* synthetic */ void R(int i2) {
        String str = i2 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 21 ? 3 : 2];
        switch (i2) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "newModality";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[0] = "inType";
                break;
        }
        if (i2 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[2] = "createSubstitutedCopy";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
                objArr[2] = "enhance";
                break;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 21) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // i8.i0, f8.t0
    public final boolean D() {
        v type = getType();
        if (!this.F) {
            return false;
        }
        k.e(type, "type");
        if (((!h.F(type) && !r.a(type)) || v9.x0.e(type)) && !h.G(type)) {
            return false;
        }
        g8.k kVar = w8.r.f10926a;
        w9.f fVar = w9.f.f10932g;
        e9.c cVar = x.f7873p;
        k.d(cVar, "ENHANCED_NULLABILITY_ANNOTATION");
        return !w9.a.hasAnnotation(fVar, type, cVar) || h.G(type);
    }

    @Override // i8.i0
    public final i0 I0(f8.j jVar, int i2, n nVar, l0 l0Var, int i10, e9.f fVar) {
        if (jVar == null) {
            R(13);
            throw null;
        }
        if (i2 == 0) {
            R(14);
            throw null;
        }
        if (nVar == null) {
            R(15);
            throw null;
        }
        if (i10 == 0) {
            R(16);
            throw null;
        }
        if (fVar == null) {
            R(17);
            throw null;
        }
        return new f(jVar, getAnnotations(), i2, nVar, this.f4795k, fVar, n0.f3487b, l0Var, i10, this.F, this.G);
    }

    @Override // i8.i0
    public final void M0(v vVar) {
    }

    @Override // i8.s0, f8.b
    public final boolean O() {
        return false;
    }

    @Override // q8.a
    public final a t0(v vVar, ArrayList arrayList, v vVar2, j jVar) {
        v vVar3;
        j0 j0Var;
        k0 k0Var;
        l0 l0VarA = a() == this ? null : a();
        f fVar = new f(p(), getAnnotations(), i(), c(), this.f4795k, getName(), q(), l0VarA, getKind(), this.F, jVar);
        j0 j0Var2 = this.B;
        if (j0Var2 != null) {
            j0 j0Var3 = new j0(fVar, j0Var2.getAnnotations(), j0Var2.i(), j0Var2.c(), j0Var2.f4770j, j0Var2.f4771k, j0Var2.f4774n, getKind(), l0VarA == null ? null : l0VarA.b(), j0Var2.q());
            j0Var3.f4777q = j0Var2.f4777q;
            vVar3 = vVar2;
            j0Var3.f4813r = vVar3;
            j0Var = j0Var3;
        } else {
            vVar3 = vVar2;
            j0Var = null;
        }
        k0 k0Var2 = this.C;
        if (k0Var2 != null) {
            k0 k0Var3 = k0Var2;
            k0Var = new k0(fVar, k0Var2.getAnnotations(), k0Var3.i(), k0Var3.c(), k0Var3.f4770j, k0Var3.f4771k, k0Var3.f4774n, getKind(), l0VarA == null ? null : l0VarA.g(), k0Var2.q());
            k0Var.f4777q = k0Var.f4777q;
            r0 r0Var = (r0) k0Var2.x0().get(0);
            if (r0Var == null) {
                k0.R(6);
                throw null;
            }
            k0Var.f4821r = r0Var;
        } else {
            k0Var = null;
        }
        fVar.K0(j0Var, k0Var, this.D, this.E);
        p7.a aVar = this.f4797m;
        if (aVar != null) {
            fVar.L0(this.f4796l, aVar);
        }
        fVar.d0(r());
        fVar.N0(vVar3, getTypeParameters(), this.f4809y, vVar != null ? m.k(this, vVar, g8.h.f3888a) : null, z.f2978f);
        return fVar;
    }

    @Override // i8.i0, f8.b
    public final Object x(f8.a aVar) {
        j jVar = this.G;
        if (jVar == null || !((f8.a) jVar.f1973f).equals(aVar)) {
            return null;
        }
        return jVar.f1974g;
    }
}
