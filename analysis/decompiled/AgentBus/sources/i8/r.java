package i8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class r extends j {

    /* renamed from: l, reason: collision with root package name */
    public final v9.i f4841l;

    /* renamed from: m, reason: collision with root package name */
    public final q f4842m;

    /* renamed from: n, reason: collision with root package name */
    public final u9.l f4843n;

    /* renamed from: o, reason: collision with root package name */
    public final g8.j f4844o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(u9.n nVar, f8.e eVar, v9.z zVar, e9.f fVar, u9.l lVar, g8.j jVar, f8.n0 n0Var) {
        super(nVar, eVar, fVar, n0Var);
        if (nVar == null) {
            j0(6);
            throw null;
        }
        if (eVar == null) {
            j0(7);
            throw null;
        }
        if (zVar == null) {
            j0(8);
            throw null;
        }
        if (fVar == null) {
            j0(9);
            throw null;
        }
        if (lVar == null) {
            j0(10);
            throw null;
        }
        this.f4844o = jVar;
        this.f4841l = new v9.i(this, Collections.EMPTY_LIST, Collections.singleton(zVar), nVar);
        this.f4842m = new q(this, nVar);
        this.f4843n = lVar;
    }

    public static r C0(u9.n nVar, f8.e eVar, e9.f fVar, u9.i iVar, g8.j jVar, f8.n0 n0Var) {
        if (nVar == null) {
            j0(0);
            throw null;
        }
        if (eVar == null) {
            j0(1);
            throw null;
        }
        if (fVar == null) {
            j0(2);
            throw null;
        }
        if (iVar != null) {
            return new r(nVar, eVar, eVar.k(), fVar, iVar, jVar, n0Var);
        }
        j0(3);
        throw null;
    }

    public static /* synthetic */ void j0(int i2) {
        String str;
        int i10;
        switch (i2) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                i10 = 2;
                break;
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[1] = "getKind";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[1] = "getAnnotations";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                throw new IllegalStateException(str2);
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
        return 4;
    }

    @Override // f8.e
    public final boolean C() {
        return false;
    }

    @Override // f8.e
    public final Collection E() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        j0(16);
        throw null;
    }

    @Override // f8.e
    public final boolean J() {
        return false;
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        q qVar = this.f4842m;
        if (qVar != null) {
            return qVar;
        }
        j0(14);
        throw null;
    }

    @Override // f8.e
    public final Collection U() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        j0(23);
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
        j0(20);
        throw null;
    }

    @Override // f8.e
    public final boolean e() {
        return false;
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        g8.j jVar = this.f4844o;
        if (jVar != null) {
            return jVar;
        }
        j0(21);
        throw null;
    }

    @Override // f8.g
    public final v9.m0 h() {
        v9.i iVar = this.f4841l;
        if (iVar != null) {
            return iVar;
        }
        j0(17);
        throw null;
    }

    @Override // f8.e, f8.w
    public final int i() {
        return 1;
    }

    @Override // f8.e
    public final f8.r0 i0() {
        return null;
    }

    @Override // f8.e
    public final i k0() {
        return null;
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
        j0(22);
        throw null;
    }

    public final String toString() {
        return "enum entry " + getName();
    }
}
