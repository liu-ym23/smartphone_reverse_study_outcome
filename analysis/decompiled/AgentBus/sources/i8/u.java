package i8;

import b0.r1;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v9.v0;

/* loaded from: classes.dex */
public abstract class u extends n implements f8.t {
    public boolean A;
    public boolean B;
    public Collection C;
    public volatile hb.k D;
    public final f8.t E;
    public final int F;
    public f8.t G;
    public Map H;

    /* renamed from: j, reason: collision with root package name */
    public List f4873j;

    /* renamed from: k, reason: collision with root package name */
    public List f4874k;

    /* renamed from: l, reason: collision with root package name */
    public v9.v f4875l;

    /* renamed from: m, reason: collision with root package name */
    public List f4876m;

    /* renamed from: n, reason: collision with root package name */
    public v f4877n;

    /* renamed from: o, reason: collision with root package name */
    public v f4878o;

    /* renamed from: p, reason: collision with root package name */
    public int f4879p;

    /* renamed from: q, reason: collision with root package name */
    public f8.n f4880q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4881r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4882s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4883t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4884u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4885v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4886w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4887x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f4888y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f4889z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i2, e9.f fVar, f8.j jVar, f8.t tVar, f8.n0 n0Var, g8.j jVar2) {
        super(jVar, jVar2, fVar, n0Var);
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
        if (n0Var == null) {
            R(4);
            throw null;
        }
        this.f4880q = f8.o.f3496i;
        this.f4881r = false;
        this.f4882s = false;
        this.f4883t = false;
        this.f4884u = false;
        this.f4885v = false;
        this.f4886w = false;
        this.f4887x = false;
        this.f4888y = false;
        this.f4889z = false;
        this.A = true;
        this.B = false;
        this.C = null;
        this.D = null;
        this.G = null;
        this.H = null;
        this.E = tVar == null ? this : tVar;
        this.F = i2;
    }

    public static ArrayList K0(f8.t tVar, List list, v0 v0Var, boolean z4, boolean z10, boolean[] zArr) {
        if (list == null) {
            R(30);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r0 r0Var = (r0) it.next();
            r0 r0Var2 = r0Var;
            v9.v vVarI = v0Var.i(2, r0Var2.getType());
            v9.v vVar = r0Var.f4849o;
            v9.v vVarI2 = vVar == null ? null : v0Var.i(2, vVar);
            if (vVarI == null) {
                return null;
            }
            if ((vVarI != r0Var2.getType() || vVar != vVarI2) && zArr != null) {
                zArr[0] = true;
            }
            r1 r1Var = r0Var instanceof q0 ? new r1(3, (List) ((q0) r0Var).f4840q.getValue()) : null;
            r0 r0Var3 = z4 ? null : r0Var;
            int i2 = r0Var.f4845k;
            g8.j annotations = r0Var.getAnnotations();
            e9.f name = r0Var.getName();
            boolean zH0 = r0Var.H0();
            boolean z11 = r0Var.f4847m;
            boolean z12 = r0Var.f4848n;
            f8.n0 n0VarQ = z10 ? r0Var.q() : f8.n0.f3487b;
            q7.k.e(annotations, "annotations");
            q7.k.e(name, "name");
            q7.k.e(n0VarQ, "source");
            arrayList.add(r1Var == null ? new r0(tVar, r0Var3, i2, annotations, name, vVarI, zH0, z11, z12, vVarI2, n0VarQ) : new q0(tVar, r0Var3, i2, annotations, name, vVarI, zH0, z11, z12, vVarI2, n0VarQ, r1Var));
        }
        return arrayList;
    }

    public static /* synthetic */ void R(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 9:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 9:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                i10 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 25:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[1] = "getTypeParameters";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[1] = "getKind";
                break;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 9:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                throw new IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case 17:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public final f8.t G0(f8.j jVar, int i2, f8.n nVar) {
        f8.t tVarBuild = o0().x(jVar).z(i2).s(nVar).o(2).a().build();
        if (tVarBuild != null) {
            return tVarBuild;
        }
        R(26);
        throw null;
    }

    @Override // f8.c
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public l0 Y(f8.j jVar, int i2, f8.n nVar) {
        return (l0) G0(jVar, i2, nVar);
    }

    @Override // f8.b
    public final v I() {
        return this.f4877n;
    }

    public abstract u I0(int i2, e9.f fVar, f8.j jVar, f8.t tVar, f8.n0 n0Var, g8.j jVar2);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    public u J0(t tVar) {
        ?? r10;
        v vVar;
        v vVar2;
        v9.v vVarI;
        boolean[] zArr = new boolean[1];
        g8.j jVarI = tVar.f4870x != null ? w7.e0.i(getAnnotations(), tVar.f4870x) : getAnnotations();
        f8.j jVar = tVar.f4853g;
        f8.t tVar2 = tVar.f4856j;
        int i2 = tVar.f4857k;
        e9.f fVar = tVar.f4863q;
        f8.n0 n0VarQ = tVar.f4866t ? ((n) (tVar2 != null ? tVar2 : a())).q() : f8.n0.f3487b;
        if (n0VarQ == null) {
            R(27);
            throw null;
        }
        u uVarI0 = I0(i2, fVar, jVar, tVar2, n0VarQ, jVarI);
        List typeParameters = tVar.f4869w;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        v0 v0VarV = v9.c.v(typeParameters, tVar.f4852f, uVarI0, arrayList, zArr);
        if (v0VarV != null) {
            ArrayList arrayList2 = new ArrayList();
            if (!tVar.f4859m.isEmpty()) {
                int i10 = 0;
                for (v vVar3 : tVar.f4859m) {
                    v9.v vVarI2 = v0VarV.i(2, vVar3.getType());
                    if (vVarI2 != null) {
                        int i11 = i10 + 1;
                        arrayList2.add(h9.m.e(uVarI0, vVarI2, ((p9.a) vVar3.G0()).E0(), vVar3.getAnnotations(), i10));
                        zArr[0] = zArr[0] | (vVarI2 != vVar3.getType());
                        i10 = i11;
                    }
                }
            }
            v vVar4 = tVar.f4860n;
            if (vVar4 != null) {
                v9.v vVarI3 = v0VarV.i(2, vVar4.getType());
                if (vVarI3 == null) {
                    return null;
                }
                tVar.f4860n.G0();
                v vVar5 = new v(uVarI0, new p9.b(uVarI0, vVarI3), tVar.f4860n.getAnnotations());
                zArr[0] = (vVarI3 != tVar.f4860n.getType()) | zArr[0];
                r10 = 0;
                vVar = vVar5;
            } else {
                r10 = 0;
                vVar = null;
            }
            v vVar6 = tVar.f4861o;
            if (vVar6 != null) {
                v vVarD = vVar6.d(v0VarV);
                if (vVarD == null) {
                    return null;
                }
                zArr[r10] = zArr[r10] | (vVarD != tVar.f4861o ? true : r10);
                vVar2 = vVarD;
            } else {
                vVar2 = null;
            }
            ArrayList arrayListK0 = K0(uVarI0, tVar.f4858l, v0VarV, tVar.f4867u, tVar.f4866t, zArr);
            if (arrayListK0 == null || (vVarI = v0VarV.i(3, tVar.f4862p)) == null) {
                return null;
            }
            boolean z4 = zArr[r10] | (vVarI != tVar.f4862p ? true : r10);
            zArr[r10] = z4;
            if (!z4 && tVar.B) {
                return this;
            }
            uVarI0.L0(vVar, vVar2, arrayList2, arrayList, arrayListK0, vVarI, tVar.f4854h, tVar.f4855i);
            uVarI0.f4881r = this.f4881r;
            uVarI0.f4882s = this.f4882s;
            uVarI0.f4883t = this.f4883t;
            uVarI0.f4884u = this.f4884u;
            uVarI0.f4885v = this.f4885v;
            uVarI0.f4889z = this.f4889z;
            uVarI0.f4886w = this.f4886w;
            uVarI0.O0(this.A);
            uVarI0.f4887x = tVar.f4868v;
            uVarI0.f4888y = tVar.f4871y;
            Boolean bool = tVar.A;
            uVarI0.P0(bool != null ? bool.booleanValue() : this.B);
            if (!tVar.f4872z.isEmpty() || this.H != null) {
                LinkedHashMap linkedHashMap = tVar.f4872z;
                Map map = this.H;
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!linkedHashMap.containsKey(entry.getKey())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (linkedHashMap.size() == 1) {
                    uVarI0.H = Collections.singletonMap(linkedHashMap.keySet().iterator().next(), linkedHashMap.values().iterator().next());
                } else {
                    uVarI0.H = linkedHashMap;
                }
            }
            if (tVar.f4865s || this.G != null) {
                f8.t tVar3 = this.G;
                if (tVar3 == null) {
                    tVar3 = this;
                }
                uVarI0.G = tVar3.d(v0VarV);
            }
            if (tVar.f4864r && !a().r().isEmpty()) {
                if (tVar.f4852f.e()) {
                    hb.k kVar = this.D;
                    if (kVar != null) {
                        uVarI0.D = kVar;
                        return uVarI0;
                    }
                    uVarI0.d0(r());
                    return uVarI0;
                }
                uVarI0.D = new hb.k(2, this, v0VarV);
            }
            return uVarI0;
        }
        return null;
    }

    public void L0(v vVar, v vVar2, List list, List list2, List list3, v9.v vVar3, int i2, f8.n nVar) {
        if (list == null) {
            R(5);
            throw null;
        }
        if (list2 == null) {
            R(6);
            throw null;
        }
        if (list3 == null) {
            R(7);
            throw null;
        }
        if (nVar == null) {
            R(8);
            throw null;
        }
        this.f4873j = d7.r.m1(list2);
        this.f4874k = d7.r.m1(list3);
        this.f4875l = vVar3;
        this.f4879p = i2;
        this.f4880q = nVar;
        this.f4877n = vVar;
        this.f4878o = vVar2;
        this.f4876m = list;
        for (int i10 = 0; i10 < list2.size(); i10++) {
            f8.q0 q0Var = (f8.q0) list2.get(i10);
            if (q0Var.getIndex() != i10) {
                throw new IllegalStateException(q0Var + " index is " + q0Var.getIndex() + " but position is " + i10);
            }
        }
        for (int i11 = 0; i11 < list3.size(); i11++) {
            r0 r0Var = (r0) list3.get(i11);
            if (r0Var.f4845k != i11) {
                throw new IllegalStateException(r0Var + "index is " + r0Var.f4845k + " but position is " + i11);
            }
        }
    }

    public final t M0(v0 v0Var) {
        if (v0Var != null) {
            return new t(this, v0Var.f(), p(), i(), c(), getKind(), x0(), S(), this.f4877n, f());
        }
        R(24);
        throw null;
    }

    public final void N0(f8.a aVar, Object obj) {
        if (this.H == null) {
            this.H = new LinkedHashMap();
        }
        this.H.put(aVar, obj);
    }

    @Override // f8.b
    public boolean O() {
        return this.B;
    }

    public void O0(boolean z4) {
        this.A = z4;
    }

    public Object P(f8.l lVar, Object obj) {
        return lVar.y(this, obj);
    }

    public void P0(boolean z4) {
        this.B = z4;
    }

    public final void Q0(v9.z zVar) {
        if (zVar != null) {
            this.f4875l = zVar;
        } else {
            R(11);
            throw null;
        }
    }

    @Override // f8.b
    public final List S() {
        List list = this.f4876m;
        if (list != null) {
            return list;
        }
        R(13);
        throw null;
    }

    @Override // f8.w
    public final boolean Z() {
        return this.f4886w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [f8.t] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // i8.n, i8.m, f8.j
    public f8.t a() {
        f8.t tVar = this.E;
        ?? A = this;
        if (tVar != this) {
            A = tVar.a();
        }
        if (A != 0) {
            return A;
        }
        R(20);
        throw null;
    }

    @Override // f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = this.f4880q;
        if (nVar != null) {
            return nVar;
        }
        R(16);
        throw null;
    }

    @Override // f8.t
    public final boolean c0() {
        return this.f4887x;
    }

    public void d0(Collection collection) {
        if (collection == null) {
            R(17);
            throw null;
        }
        this.C = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((f8.t) it.next()).n0()) {
                this.f4888y = true;
                return;
            }
        }
    }

    public boolean e() {
        return this.f4884u;
    }

    public boolean e0() {
        return this.f4885v;
    }

    public v9.v f() {
        return this.f4875l;
    }

    @Override // f8.t
    public final boolean f0() {
        if (this.f4881r) {
            return true;
        }
        Iterator it = a().r().iterator();
        while (it.hasNext()) {
            if (((f8.t) it.next()).f0()) {
                return true;
            }
        }
        return false;
    }

    @Override // f8.c
    public final int getKind() {
        int i2 = this.F;
        if (i2 != 0) {
            return i2;
        }
        R(21);
        throw null;
    }

    @Override // f8.b
    public final List getTypeParameters() {
        List list = this.f4873j;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // f8.w
    public final int i() {
        int i2 = this.f4879p;
        if (i2 != 0) {
            return i2;
        }
        R(15);
        throw null;
    }

    @Override // f8.t
    public final boolean n0() {
        return this.f4888y;
    }

    @Override // f8.t
    public boolean o() {
        return this.f4889z;
    }

    public f8.s o0() {
        return M0(v0.f10595b);
    }

    public Collection r() {
        hb.k kVar = this.D;
        if (kVar != null) {
            this.C = (Collection) kVar.c();
            this.D = null;
        }
        Collection collection = this.C;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        R(14);
        throw null;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.t
    public final f8.t v() {
        return this.G;
    }

    public boolean w() {
        return this.f4883t;
    }

    @Override // f8.b
    public Object x(f8.a aVar) {
        Map map = this.H;
        if (map == null) {
            return null;
        }
        return map.get(aVar);
    }

    @Override // f8.b
    public final List x0() {
        List list = this.f4874k;
        if (list != null) {
            return list;
        }
        R(19);
        throw null;
    }

    @Override // f8.b
    public final v y() {
        return this.f4878o;
    }

    @Override // f8.t
    public final boolean y0() {
        if (this.f4882s) {
            return true;
        }
        Iterator it = a().r().iterator();
        while (it.hasNext()) {
            if (((f8.t) it.next()).y0()) {
                return true;
            }
        }
        return false;
    }

    @Override // f8.p0
    public f8.t d(v0 v0Var) {
        if (v0Var == null) {
            R(22);
            throw null;
        }
        if (v0Var.f10596a.e()) {
            return this;
        }
        t tVarM0 = M0(v0Var);
        tVarM0.f4856j = a();
        tVarM0.f4866t = true;
        tVarM0.B = true;
        return tVarM0.C.J0(tVarM0);
    }
}
