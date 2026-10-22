package i8;

import com.google.protobuf.y0;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h extends n implements f8.q0 {

    /* renamed from: j, reason: collision with root package name */
    public final int f4778j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4779k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4780l;

    /* renamed from: m, reason: collision with root package name */
    public final u9.i f4781m;

    /* renamed from: n, reason: collision with root package name */
    public final u9.i f4782n;

    /* renamed from: o, reason: collision with root package name */
    public final u9.k f4783o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(u9.n nVar, f8.j jVar, g8.j jVar2, e9.f fVar, int i2, boolean z4, int i10, f8.o0 o0Var) {
        super(jVar, jVar2, fVar, f8.n0.f3487b);
        if (nVar == null) {
            R(0);
            throw null;
        }
        if (jVar == null) {
            R(1);
            throw null;
        }
        if (jVar2 == null) {
            R(2);
            throw null;
        }
        if (fVar == null) {
            R(3);
            throw null;
        }
        if (i2 == 0) {
            R(4);
            throw null;
        }
        if (o0Var == null) {
            R(6);
            throw null;
        }
        this.f4778j = i2;
        this.f4779k = z4;
        this.f4780l = i10;
        f fVar2 = new f(this, nVar, o0Var);
        u9.k kVar = (u9.k) nVar;
        this.f4781m = new u9.i(kVar, fVar2);
        this.f4782n = new u9.i(kVar, new hb.k(1, this, fVar));
        this.f4783o = kVar;
    }

    public static /* synthetic */ void R(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
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
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // f8.q0
    public final u9.n A() {
        u9.k kVar = this.f4783o;
        if (kVar != null) {
            return kVar;
        }
        R(14);
        throw null;
    }

    @Override // i8.n
    /* renamed from: F0 */
    public final f8.k a() {
        return this;
    }

    public List G0(List list) {
        return list;
    }

    public abstract List H0();

    @Override // f8.q0
    public final boolean M() {
        return false;
    }

    @Override // f8.q0
    public final boolean N() {
        return this.f4779k;
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.p(this, obj);
    }

    @Override // i8.n, i8.m, f8.j
    public final f8.g a() {
        return this;
    }

    @Override // f8.q0
    public final int a0() {
        int i2 = this.f4778j;
        if (i2 != 0) {
            return i2;
        }
        R(7);
        throw null;
    }

    @Override // f8.q0
    public final int getIndex() {
        return this.f4780l;
    }

    @Override // f8.q0
    public final List getUpperBounds() {
        List listH = ((g) h()).d();
        if (listH != null) {
            return listH;
        }
        R(8);
        throw null;
    }

    @Override // f8.q0, f8.g
    public final v9.m0 h() {
        v9.m0 m0Var = (v9.m0) this.f4781m.c();
        if (m0Var != null) {
            return m0Var;
        }
        R(9);
        throw null;
    }

    @Override // f8.g
    public final v9.z k() {
        v9.z zVar = (v9.z) this.f4782n.c();
        if (zVar != null) {
            return zVar;
        }
        R(10);
        throw null;
    }

    @Override // i8.n, i8.m, f8.j
    public final f8.j a() {
        return this;
    }

    @Override // i8.n, i8.m, f8.j
    public final f8.q0 a() {
        return this;
    }
}
