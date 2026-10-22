package i8;

import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import v9.v0;

/* loaded from: classes.dex */
public abstract class g0 extends n implements f8.k0 {

    /* renamed from: j, reason: collision with root package name */
    public boolean f4770j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4771k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4772l;

    /* renamed from: m, reason: collision with root package name */
    public final f8.l0 f4773m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f4774n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4775o;

    /* renamed from: p, reason: collision with root package name */
    public f8.n f4776p;

    /* renamed from: q, reason: collision with root package name */
    public f8.t f4777q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(int i2, f8.n nVar, f8.l0 l0Var, g8.j jVar, e9.f fVar, boolean z4, boolean z10, boolean z11, int i10, f8.n0 n0Var) {
        super(l0Var.p(), jVar, fVar, n0Var);
        if (i2 == 0) {
            R(0);
            throw null;
        }
        if (nVar == null) {
            R(1);
            throw null;
        }
        if (jVar == null) {
            R(3);
            throw null;
        }
        if (n0Var == null) {
            R(5);
            throw null;
        }
        this.f4777q = null;
        this.f4772l = i2;
        this.f4776p = nVar;
        this.f4773m = l0Var;
        this.f4770j = z4;
        this.f4771k = z10;
        this.f4774n = z11;
        this.f4775o = i10;
    }

    public static /* synthetic */ void R(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                i10 = 2;
                break;
            case 7:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i2) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[1] = "getContextReceiverParameters";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public final f8.l0 G0() {
        f8.l0 l0Var = this.f4773m;
        if (l0Var != null) {
            return l0Var;
        }
        R(13);
        throw null;
    }

    public final ArrayList H0(boolean z4) {
        ArrayList arrayList = new ArrayList(0);
        for (f8.l0 l0Var : G0().r()) {
            f8.k kVarB = z4 ? l0Var.b() : l0Var.g();
            if (kVarB != null) {
                arrayList.add(kVarB);
            }
        }
        return arrayList;
    }

    @Override // f8.b
    public final v I() {
        return G0().I();
    }

    @Override // f8.b
    public final boolean O() {
        return false;
    }

    @Override // f8.b
    public final List S() {
        List listS = G0().S();
        if (listS != null) {
            return listS;
        }
        R(14);
        throw null;
    }

    @Override // f8.c
    public final f8.c Y(f8.e eVar, int i2, f8.n nVar) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // f8.w
    public final boolean Z() {
        return false;
    }

    @Override // f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = this.f4776p;
        if (nVar != null) {
            return nVar;
        }
        R(11);
        throw null;
    }

    @Override // f8.t
    public final boolean c0() {
        return false;
    }

    @Override // f8.t, f8.p0
    public final f8.t d(v0 v0Var) {
        if (v0Var != null) {
            return this;
        }
        R(7);
        throw null;
    }

    @Override // f8.c
    public final void d0(Collection collection) {
        if (collection != null) {
            return;
        }
        R(16);
        throw null;
    }

    @Override // f8.t
    public final boolean e() {
        return this.f4774n;
    }

    @Override // f8.t
    public final boolean e0() {
        return false;
    }

    @Override // f8.t
    public final boolean f0() {
        return false;
    }

    @Override // f8.c
    public final int getKind() {
        int i2 = this.f4775o;
        if (i2 != 0) {
            return i2;
        }
        R(6);
        throw null;
    }

    @Override // f8.b
    public final List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        R(9);
        throw null;
    }

    @Override // f8.w
    public final int i() {
        int i2 = this.f4772l;
        if (i2 != 0) {
            return i2;
        }
        R(10);
        throw null;
    }

    @Override // f8.t
    public final boolean n0() {
        return false;
    }

    @Override // f8.t
    public final boolean o() {
        return false;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.t
    public final f8.t v() {
        return this.f4777q;
    }

    @Override // f8.w
    public final boolean w() {
        return this.f4771k;
    }

    @Override // f8.b
    public final Object x(f8.a aVar) {
        return null;
    }

    @Override // f8.b
    public final v y() {
        return G0().y();
    }

    @Override // f8.t
    public final boolean y0() {
        return false;
    }

    @Override // f8.p0
    public final /* bridge */ /* synthetic */ f8.k d(v0 v0Var) {
        d(v0Var);
        return this;
    }
}
