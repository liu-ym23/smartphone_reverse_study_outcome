package i8;

/* loaded from: classes.dex */
public abstract class n extends m implements f8.k {

    /* renamed from: h, reason: collision with root package name */
    public final f8.j f4828h;

    /* renamed from: i, reason: collision with root package name */
    public final f8.n0 f4829i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(f8.j jVar, g8.j jVar2, e9.f fVar, f8.n0 n0Var) {
        super(jVar2, fVar);
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
        this.f4828h = jVar;
        this.f4829i = n0Var;
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 4 || i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getOriginal";
        } else if (i2 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // i8.m, f8.j
    /* renamed from: F0 */
    public f8.k a() {
        return this;
    }

    public f8.j p() {
        f8.j jVar = this.f4828h;
        if (jVar != null) {
            return jVar;
        }
        R(5);
        throw null;
    }

    public f8.n0 q() {
        f8.n0 n0Var = this.f4829i;
        if (n0Var != null) {
            return n0Var;
        }
        R(6);
        throw null;
    }
}
