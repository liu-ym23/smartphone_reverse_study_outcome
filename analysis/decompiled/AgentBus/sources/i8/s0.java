package i8;

import f8.t0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class s0 extends n implements t0 {

    /* renamed from: j, reason: collision with root package name */
    public v9.v f4851j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(f8.j jVar, g8.j jVar2, e9.f fVar, v9.v vVar, f8.n0 n0Var) {
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
        if (n0Var == null) {
            R(3);
            throw null;
        }
        this.f4851j = vVar;
    }

    public static /* synthetic */ void R(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i10 = 2;
                break;
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
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public v I() {
        return null;
    }

    @Override // f8.b
    public boolean O() {
        return false;
    }

    public v9.v f() {
        v9.v type = getType();
        if (type != null) {
            return type;
        }
        R(10);
        throw null;
    }

    @Override // a4.d, p9.d
    public final v9.v getType() {
        v9.v vVar = this.f4851j;
        if (vVar != null) {
            return vVar;
        }
        R(4);
        throw null;
    }

    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        R(8);
        throw null;
    }

    @Override // f8.b
    public final List x0() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        R(6);
        throw null;
    }

    public v y() {
        return null;
    }
}
