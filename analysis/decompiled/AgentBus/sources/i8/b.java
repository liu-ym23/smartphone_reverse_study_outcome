package i8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.Collections;
import java.util.List;
import v9.v0;

/* loaded from: classes.dex */
public abstract class b extends z {

    /* renamed from: f, reason: collision with root package name */
    public final e9.f f4747f;

    /* renamed from: g, reason: collision with root package name */
    public final u9.i f4748g;

    /* renamed from: h, reason: collision with root package name */
    public final u9.i f4749h;

    /* renamed from: i, reason: collision with root package name */
    public final u9.i f4750i;

    public b(u9.n nVar, e9.f fVar) {
        if (nVar == null) {
            j0(0);
            throw null;
        }
        if (fVar == null) {
            j0(1);
            throw null;
        }
        this.f4747f = fVar;
        u9.k kVar = (u9.k) nVar;
        this.f4748g = new u9.i(kVar, new a(this, 0));
        this.f4749h = new u9.i(kVar, new a(this, 1));
        this.f4750i = new u9.i(kVar, new a(this, 2));
    }

    public static /* synthetic */ void j0(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16 || i2 == 17 || i2 == 19 || i2 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16 || i2 == 17 || i2 == 19 || i2 == 20) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[0] = "typeSubstitution";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i2 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i2 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i2 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i2 == 19) {
            objArr[1] = "substitute";
        } else if (i2 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[2] = "getMemberScope";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 6 && i2 != 9 && i2 != 12 && i2 != 14 && i2 != 16 && i2 != 17 && i2 != 19 && i2 != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // f8.e
    public final v B0() {
        v vVar = (v) this.f4750i.c();
        if (vVar != null) {
            return vVar;
        }
        j0(5);
        throw null;
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.n(this, obj);
    }

    @Override // i8.z
    public o9.n R(v9.s0 s0Var, w9.g gVar) {
        if (!s0Var.e()) {
            return new o9.t(T(gVar), new v0(s0Var));
        }
        o9.n nVarT = T(gVar);
        if (nVarT != null) {
            return nVarT;
        }
        j0(12);
        throw null;
    }

    @Override // f8.e
    public final o9.n X(v9.s0 s0Var) {
        l9.d.i(h9.f.d(this));
        o9.n nVarR = R(s0Var, w9.g.f10933a);
        if (nVarR != null) {
            return nVarR;
        }
        j0(16);
        throw null;
    }

    @Override // i8.z, f8.e, f8.j
    public final f8.g a() {
        return this;
    }

    @Override // f8.j
    public final e9.f getName() {
        e9.f fVar = this.f4747f;
        if (fVar != null) {
            return fVar;
        }
        j0(2);
        throw null;
    }

    @Override // f8.e
    public o9.n h0() {
        o9.n nVar = (o9.n) this.f4749h.c();
        if (nVar != null) {
            return nVar;
        }
        j0(4);
        throw null;
    }

    @Override // f8.e, f8.g
    public final v9.z k() {
        v9.z zVar = (v9.z) this.f4748g.c();
        if (zVar != null) {
            return zVar;
        }
        j0(20);
        throw null;
    }

    @Override // f8.e
    public o9.n p0() {
        l9.d.i(h9.f.d(this));
        o9.n nVarT = T(w9.g.f10933a);
        if (nVarT != null) {
            return nVarT;
        }
        j0(17);
        throw null;
    }

    @Override // f8.p0
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public f8.e d(v0 v0Var) {
        if (v0Var != null) {
            return v0Var.f10596a.e() ? this : new y(this, v0Var);
        }
        j0(18);
        throw null;
    }

    @Override // f8.e
    public List w0() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        j0(6);
        throw null;
    }

    @Override // i8.z, f8.j
    public final f8.j a() {
        return this;
    }

    @Override // i8.z, f8.e, f8.j
    public final f8.e a() {
        return this;
    }
}
