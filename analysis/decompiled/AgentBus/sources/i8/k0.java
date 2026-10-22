package i8;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class k0 extends g0 implements f8.k0 {

    /* renamed from: r, reason: collision with root package name */
    public r0 f4821r;

    /* renamed from: s, reason: collision with root package name */
    public final k0 f4822s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(f8.l0 l0Var, g8.j jVar, int i2, f8.n nVar, boolean z4, boolean z10, boolean z11, int i10, k0 k0Var, f8.n0 n0Var) {
        super(i2, nVar, l0Var, jVar, e9.f.g("<set-" + l0Var.getName() + ">"), z4, z10, z11, i10, n0Var);
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
        this.f4822s = k0Var != null ? k0Var : this;
    }

    public static r0 I0(k0 k0Var, v9.v vVar, g8.j jVar) {
        if (vVar == null) {
            R(8);
            throw null;
        }
        if (jVar != null) {
            return new r0(k0Var, null, 0, jVar, e9.h.f3206g, vVar, false, false, false, null, f8.n0.f3487b);
        }
        R(9);
        throw null;
    }

    public static /* synthetic */ void R(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                i10 = 2;
                break;
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i2) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // i8.n, i8.m, f8.j
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public final k0 a() {
        k0 k0Var = this.f4822s;
        if (k0Var != null) {
            return k0Var;
        }
        R(13);
        throw null;
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.F(this, obj);
    }

    @Override // f8.b
    public final v9.v f() {
        return l9.d.e(this).w();
    }

    @Override // f8.c, f8.b
    public final Collection r() {
        return H0(false);
    }

    @Override // f8.b
    public final List x0() {
        r0 r0Var = this.f4821r;
        if (r0Var == null) {
            throw new IllegalStateException();
        }
        List listSingletonList = Collections.singletonList(r0Var);
        if (listSingletonList != null) {
            return listSingletonList;
        }
        R(11);
        throw null;
    }
}
