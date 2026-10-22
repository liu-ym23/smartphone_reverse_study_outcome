package i8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class k extends j {

    /* renamed from: l, reason: collision with root package name */
    public final int f4815l;

    /* renamed from: m, reason: collision with root package name */
    public final int f4816m;

    /* renamed from: n, reason: collision with root package name */
    public final v9.i f4817n;

    /* renamed from: o, reason: collision with root package name */
    public o9.n f4818o;

    /* renamed from: p, reason: collision with root package name */
    public Set f4819p;

    /* renamed from: q, reason: collision with root package name */
    public i f4820q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(f8.j jVar, e9.f fVar, int i2, int i10, List list, u9.n nVar) {
        super(nVar, jVar, fVar, f8.n0.f3487b);
        if (jVar == null) {
            j0(0);
            throw null;
        }
        if (fVar == null) {
            j0(1);
            throw null;
        }
        if (i2 == 0) {
            j0(2);
            throw null;
        }
        if (i10 == 0) {
            j0(3);
            throw null;
        }
        if (nVar == null) {
            j0(6);
            throw null;
        }
        this.f4815l = i2;
        this.f4816m = i10;
        this.f4817n = new v9.i(this, Collections.EMPTY_LIST, list, nVar);
    }

    public static /* synthetic */ void j0(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                i10 = 2;
                break;
            case 12:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[1] = "getStaticScope";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // f8.e
    public final boolean A0() {
        return false;
    }

    @Override // f8.e
    public final int B() {
        int i2 = this.f4816m;
        if (i2 != 0) {
            return i2;
        }
        j0(15);
        throw null;
    }

    @Override // f8.e
    public final boolean C() {
        return false;
    }

    public final void C0(o9.n nVar, Set set, i iVar) {
        this.f4818o = nVar;
        this.f4819p = set;
        this.f4820q = iVar;
    }

    @Override // f8.e
    public final Collection E() {
        Set set = this.f4819p;
        if (set != null) {
            return set;
        }
        j0(11);
        throw null;
    }

    @Override // f8.e
    public final boolean J() {
        return false;
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        o9.n nVar = this.f4818o;
        if (nVar != null) {
            return nVar;
        }
        j0(13);
        throw null;
    }

    @Override // f8.e
    public final Collection U() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        j0(19);
        throw null;
    }

    @Override // f8.w
    public final boolean Z() {
        return false;
    }

    @Override // f8.e, f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = f8.o.f3492e;
        if (nVar != null) {
            return nVar;
        }
        j0(17);
        throw null;
    }

    @Override // f8.e
    public final boolean e() {
        return false;
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        return g8.h.f3888a;
    }

    @Override // f8.g
    public final v9.m0 h() {
        v9.i iVar = this.f4817n;
        if (iVar != null) {
            return iVar;
        }
        j0(10);
        throw null;
    }

    @Override // f8.e, f8.w
    public final int i() {
        int i2 = this.f4815l;
        if (i2 != 0) {
            return i2;
        }
        j0(16);
        throw null;
    }

    @Override // f8.e
    public final f8.r0 i0() {
        return null;
    }

    @Override // f8.e
    public final i k0() {
        return this.f4820q;
    }

    @Override // f8.e
    public final boolean l() {
        return false;
    }

    @Override // f8.e
    public final o9.n l0() {
        return o9.m.f7933b;
    }

    @Override // f8.h
    public final boolean m() {
        return false;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.e, f8.h
    public final List s() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        j0(18);
        throw null;
    }

    public String toString() {
        return "class " + getName();
    }
}
