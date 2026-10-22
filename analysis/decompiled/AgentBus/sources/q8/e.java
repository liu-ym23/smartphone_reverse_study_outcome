package q8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import f8.j;
import f8.n;
import f8.n0;
import f8.t;
import g8.h;
import ga.i;
import h9.m;
import i8.l0;
import i8.u;
import i8.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import m.x;
import q7.k;
import v9.v0;

/* loaded from: classes.dex */
public final class e extends l0 implements a {
    public static final k9.a K = new k9.a();
    public static final k9.a L = new k9.a();
    public int I;
    public final boolean J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(j jVar, l0 l0Var, g8.j jVar2, e9.f fVar, int i2, n0 n0Var, boolean z4) {
        super(jVar, l0Var, jVar2, fVar, i2, n0Var);
        if (jVar == null) {
            R(0);
            throw null;
        }
        if (jVar2 == null) {
            R(1);
            throw null;
        }
        if (fVar == null) {
            R(2);
            throw null;
        }
        if (i2 == 0) {
            R(3);
            throw null;
        }
        this.I = 0;
        this.J = z4;
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 13 || i2 == 18 || i2 == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 13 || i2 == 18 || i2 == 21) ? 2 : 3];
        switch (i2) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "newOwner";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i2 == 13) {
            objArr[1] = "initialize";
        } else if (i2 == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i2 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 13 && i2 != 18 && i2 != 21) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static e V0(j jVar, r8.d dVar, e9.f fVar, k8.g gVar, boolean z4) {
        if (jVar == null) {
            R(5);
            throw null;
        }
        if (fVar != null) {
            return new e(jVar, null, dVar, fVar, 1, gVar, z4);
        }
        R(7);
        throw null;
    }

    @Override // i8.l0, i8.u
    public final u I0(int i2, e9.f fVar, j jVar, t tVar, n0 n0Var, g8.j jVar2) {
        if (jVar == null) {
            R(14);
            throw null;
        }
        if (i2 == 0) {
            R(15);
            throw null;
        }
        if (jVar2 == null) {
            R(16);
            throw null;
        }
        l0 l0Var = (l0) tVar;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(jVar, l0Var, jVar2, fVar, i2, n0Var, this.J);
        int i10 = this.I;
        boolean z4 = false;
        if (i10 != 1) {
            if (i10 == 2) {
                z4 = true;
            } else if (i10 != 3) {
                if (i10 != 4) {
                    throw null;
                }
                z4 = true;
            }
        }
        eVar.W0(z4, x.c(i10));
        return eVar;
    }

    @Override // i8.u, f8.b
    public final boolean O() {
        return x.c(this.I);
    }

    @Override // i8.l0
    public final l0 U0(v vVar, v vVar2, List list, List list2, List list3, v9.v vVar3, int i2, n nVar, Map map) {
        ba.g gVar;
        if (list == null) {
            R(9);
            throw null;
        }
        if (list2 == null) {
            R(10);
            throw null;
        }
        if (list3 == null) {
            R(11);
            throw null;
        }
        if (nVar == null) {
            R(12);
            throw null;
        }
        super.U0(vVar, vVar2, list, list2, list3, vVar3, i2, nVar, map);
        for (ba.j jVar : ba.t.f1629a) {
            i iVar = jVar.f1609b;
            e9.f fVar = jVar.f1608a;
            if (fVar == null || k.a(getName(), fVar)) {
                if (iVar != null) {
                    String strB = getName().b();
                    k.d(strB, "functionDescriptor.name.asString()");
                    if (!iVar.c(strB)) {
                        continue;
                    }
                }
                Collection collection = jVar.f1610c;
                if (collection == null || collection.contains(getName())) {
                    ba.f[] fVarArr = jVar.f1612e;
                    int length = fVarArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            gVar = ((String) jVar.f1611d.invoke(this)) != null ? new ba.g(false) : ba.g.f1596c;
                        } else {
                            if (fVarArr[i10].a(this) != null) {
                                gVar = new ba.g(false);
                                break;
                            }
                            i10++;
                        }
                    }
                    this.f4881r = gVar.f1597a;
                    return this;
                }
            }
        }
        gVar = ba.g.f1595b;
        this.f4881r = gVar.f1597a;
        return this;
    }

    public final void W0(boolean z4, boolean z10) {
        this.I = z4 ? z10 ? 4 : 2 : z10 ? 3 : 1;
    }

    @Override // q8.a
    public final a t0(v9.v vVar, ArrayList arrayList, v9.v vVar2, c7.j jVar) {
        ArrayList arrayListG = n7.a.g(arrayList, x0(), this);
        v vVarK = vVar == null ? null : m.k(this, vVar, h.f3888a);
        i8.t tVarM0 = M0(v0.f10595b);
        tVarM0.f4858l = arrayListG;
        tVarM0.f4862p = vVar2;
        tVarM0.f4860n = vVarK;
        tVarM0.f4867u = true;
        tVarM0.f4866t = true;
        e eVar = (e) tVarM0.C.J0(tVarM0);
        if (jVar != null) {
            eVar.N0((f8.a) jVar.f1973f, jVar.f1974g);
        }
        if (eVar != null) {
            return eVar;
        }
        R(21);
        throw null;
    }
}
