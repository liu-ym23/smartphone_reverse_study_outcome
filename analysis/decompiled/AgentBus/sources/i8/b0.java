package i8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class b0 extends j {

    /* renamed from: l, reason: collision with root package name */
    public final int f4751l;

    /* renamed from: m, reason: collision with root package name */
    public int f4752m;

    /* renamed from: n, reason: collision with root package name */
    public f8.n f4753n;

    /* renamed from: o, reason: collision with root package name */
    public v9.i f4754o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f4755p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f4756q;

    /* renamed from: r, reason: collision with root package name */
    public final u9.n f4757r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(e8.k kVar, e9.f fVar, u9.n nVar) {
        super(nVar, kVar, fVar, f8.n0.f3487b);
        if (fVar == null) {
            j0(2);
            throw null;
        }
        if (nVar == null) {
            j0(4);
            throw null;
        }
        this.f4756q = new ArrayList();
        this.f4757r = nVar;
        this.f4751l = 2;
    }

    public static /* synthetic */ void j0(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                i10 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[1] = "getStaticScope";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
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
        int i2 = this.f4751l;
        if (i2 != 0) {
            return i2;
        }
        j0(8);
        throw null;
    }

    @Override // f8.e
    public final boolean C() {
        return false;
    }

    @Override // f8.e
    public final Collection E() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        j0(13);
        throw null;
    }

    @Override // f8.e
    public final boolean J() {
        return false;
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        return o9.m.f7933b;
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
        f8.n nVar = this.f4753n;
        if (nVar != null) {
            return nVar;
        }
        j0(10);
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
        v9.i iVar = this.f4754o;
        if (iVar != null) {
            return iVar;
        }
        j0(11);
        throw null;
    }

    @Override // f8.e, f8.w
    public final int i() {
        int i2 = this.f4752m;
        if (i2 != 0) {
            return i2;
        }
        j0(7);
        throw null;
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
        ArrayList arrayList = this.f4755p;
        if (arrayList != null) {
            return arrayList;
        }
        j0(15);
        throw null;
    }

    public final String toString() {
        return m.E0(this);
    }
}
