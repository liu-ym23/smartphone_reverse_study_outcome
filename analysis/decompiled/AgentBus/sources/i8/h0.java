package i8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v9.v0;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public f8.j f4784a;

    /* renamed from: b, reason: collision with root package name */
    public int f4785b;

    /* renamed from: c, reason: collision with root package name */
    public f8.n f4786c;

    /* renamed from: e, reason: collision with root package name */
    public int f4788e;

    /* renamed from: h, reason: collision with root package name */
    public final v f4791h;

    /* renamed from: i, reason: collision with root package name */
    public final e9.f f4792i;

    /* renamed from: j, reason: collision with root package name */
    public final v9.v f4793j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i0 f4794k;

    /* renamed from: d, reason: collision with root package name */
    public f8.l0 f4787d = null;

    /* renamed from: f, reason: collision with root package name */
    public v9.s0 f4789f = v9.s0.f10589a;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4790g = true;

    public h0(i0 i0Var) {
        this.f4794k = i0Var;
        this.f4784a = i0Var.p();
        this.f4785b = i0Var.i();
        this.f4786c = i0Var.c();
        this.f4788e = i0Var.getKind();
        this.f4791h = i0Var.f4809y;
        this.f4792i = i0Var.getName();
        this.f4793j = i0Var.getType();
    }

    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? 2 : 3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                break;
            case 4:
                objArr[0] = "type";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 8:
                objArr[0] = "visibility";
                break;
            case 10:
                objArr[0] = "kind";
                break;
            case 12:
                objArr[0] = "typeParameters";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[0] = "substitution";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "owner";
                break;
        }
        if (i2 == 1) {
            objArr[1] = "setOwner";
        } else if (i2 == 2) {
            objArr[1] = "setOriginal";
        } else if (i2 == 3) {
            objArr[1] = "setPreserveSourceElement";
        } else if (i2 == 5) {
            objArr[1] = "setReturnType";
        } else if (i2 == 7) {
            objArr[1] = "setModality";
        } else if (i2 == 9) {
            objArr[1] = "setVisibility";
        } else if (i2 == 11) {
            objArr[1] = "setKind";
        } else if (i2 == 19) {
            objArr[1] = "setName";
        } else if (i2 == 13) {
            objArr[1] = "setTypeParameters";
        } else if (i2 == 14) {
            objArr[1] = "setDispatchReceiverParameter";
        } else if (i2 == 16) {
            objArr[1] = "setSubstitution";
        } else if (i2 != 17) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        } else {
            objArr[1] = "setCopyOverrides";
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                break;
            case 4:
                objArr[2] = "setReturnType";
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 8:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setKind";
                break;
            case 12:
                objArr[2] = "setTypeParameters";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[2] = "setSubstitution";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[2] = "setName";
                break;
            default:
                objArr[2] = "setOwner";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 5 && i2 != 7 && i2 != 9 && i2 != 11 && i2 != 19 && i2 != 13 && i2 != 14 && i2 != 16 && i2 != 17) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.lang.Throwable] */
    public final i0 b() {
        v vVar;
        v vVar2;
        j0 j0Var;
        k0 k0Var;
        v0 v0Var;
        p7.a aVar;
        v vVar3;
        v vVar4;
        v9.v vVarI;
        f8.j jVar = this.f4784a;
        int i2 = this.f4785b;
        f8.n nVar = this.f4786c;
        f8.l0 l0Var = this.f4787d;
        int i10 = this.f4788e;
        e9.f fVar = this.f4792i;
        i0 i0Var = this.f4794k;
        i0 i0VarI0 = i0Var.I0(jVar, i2, nVar, l0Var, i10, fVar);
        List typeParameters = i0Var.getTypeParameters();
        ArrayList arrayList = new ArrayList(((ArrayList) typeParameters).size());
        v0 v0VarU = v9.c.u(typeParameters, this.f4789f, i0VarI0, arrayList);
        v9.v vVar5 = this.f4793j;
        v9.v vVarI2 = v0VarU.i(3, vVar5);
        v vVar6 = null;
        if (vVarI2 != null) {
            v9.v vVarI3 = v0VarU.i(2, vVar5);
            if (vVarI3 != null) {
                i0VarI0.M0(vVarI3);
            }
            v vVar7 = this.f4791h;
            if (vVar7 != null) {
                v vVarD = vVar7.d(v0VarU);
                vVar = vVarD != null ? vVarD : null;
            }
            v vVar8 = i0Var.f4810z;
            if (vVar8 == null || (vVarI = v0VarU.i(2, vVar8.getType())) == null) {
                vVar2 = null;
            } else {
                vVar8.G0();
                vVar2 = new v(i0VarI0, new p9.b(i0VarI0, vVarI), vVar8.getAnnotations());
            }
            ArrayList arrayList2 = new ArrayList();
            for (v vVar9 : i0Var.f4808x) {
                v9.v vVarI4 = v0VarU.i(2, vVar9.getType());
                if (vVarI4 == null) {
                    vVar3 = vVar6;
                    vVar4 = vVar3;
                } else {
                    vVar4 = vVar6;
                    e9.f fVarE0 = ((p9.a) vVar9.G0()).E0();
                    vVar9.G0();
                    vVar3 = new v(i0VarI0, new p9.a(i0VarI0, vVarI4, fVarE0), vVar9.getAnnotations());
                }
                if (vVar3 != null) {
                    arrayList2.add(vVar3);
                }
                vVar6 = vVar4;
            }
            ?? r19 = vVar6;
            i0VarI0.N0(vVarI2, arrayList, vVar, vVar2, arrayList2);
            j0 j0Var2 = i0Var.B;
            f8.o0 o0Var = f8.n0.f3487b;
            if (j0Var2 == null) {
                j0Var = r19;
            } else {
                g8.j annotations = j0Var2.getAnnotations();
                int i11 = this.f4785b;
                f8.n nVarC = i0Var.B.c();
                if (this.f4788e == 2 && f8.o.e(f8.o.f(nVarC.f3485a.c()))) {
                    nVarC = f8.o.f3495h;
                }
                f8.n nVar2 = nVarC;
                j0 j0Var3 = i0Var.B;
                boolean z4 = j0Var3.f4770j;
                boolean z10 = j0Var3.f4771k;
                boolean z11 = j0Var3.f4774n;
                int i12 = this.f4788e;
                f8.l0 l0Var2 = this.f4787d;
                j0Var = new j0(i0VarI0, annotations, i11, nVar2, z4, z10, z11, i12, l0Var2 == null ? r19 : l0Var2.b(), o0Var);
            }
            if (j0Var != null) {
                j0 j0Var4 = i0Var.B;
                v9.v vVar10 = j0Var4.f4813r;
                j0Var.f4777q = i0.J0(v0VarU, j0Var4);
                j0Var.J0(vVar10 != null ? v0VarU.i(3, vVar10) : r19);
            }
            k0 k0Var2 = i0Var.C;
            if (k0Var2 == null) {
                k0Var = r19;
            } else {
                g8.j annotations2 = k0Var2.getAnnotations();
                int i13 = this.f4785b;
                f8.n nVarC2 = i0Var.C.c();
                if (this.f4788e == 2 && f8.o.e(f8.o.f(nVarC2.f3485a.c()))) {
                    nVarC2 = f8.o.f3495h;
                }
                f8.n nVar3 = nVarC2;
                k0 k0Var3 = i0Var.C;
                boolean z12 = k0Var3.f4770j;
                boolean z13 = k0Var3.f4771k;
                boolean z14 = k0Var3.f4774n;
                int i14 = this.f4788e;
                f8.l0 l0Var3 = this.f4787d;
                k0Var = new k0(i0VarI0, annotations2, i13, nVar3, z12, z13, z14, i14, l0Var3 == null ? r19 : l0Var3.g(), o0Var);
            }
            if (k0Var != null) {
                v0Var = v0VarU;
                List listK0 = u.K0(k0Var, i0Var.C.x0(), v0Var, false, false, null);
                if (listK0 == null) {
                    listK0 = Collections.singletonList(k0.I0(k0Var, l9.d.e(this.f4784a).n(), ((r0) i0Var.C.x0().get(0)).getAnnotations()));
                }
                if (listK0.size() != 1) {
                    throw new IllegalStateException();
                }
                k0Var.f4777q = i0.J0(v0Var, i0Var.C);
                r0 r0Var = (r0) listK0.get(0);
                if (r0Var == null) {
                    k0.R(6);
                    throw r19;
                }
                k0Var.f4821r = r0Var;
            } else {
                v0Var = v0VarU;
            }
            s sVar = i0Var.D;
            s sVar2 = sVar == null ? r19 : new s(sVar.getAnnotations(), i0VarI0);
            s sVar3 = i0Var.E;
            i0VarI0.K0(j0Var, k0Var, sVar2, sVar3 == null ? r19 : new s(sVar3.getAnnotations(), i0VarI0));
            if (this.f4790g) {
                ea.h hVar = new ea.h();
                Iterator it = i0Var.r().iterator();
                while (it.hasNext()) {
                    hVar.add(((f8.l0) it.next()).d(v0Var));
                }
                i0VarI0.f4800p = hVar;
            }
            if (i0Var.D() && (aVar = i0Var.f4797m) != null) {
                i0VarI0.L0(i0Var.f4796l, aVar);
            }
            return i0VarI0;
        }
        return null;
    }
}
