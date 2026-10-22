package i8;

/* loaded from: classes.dex */
public abstract class j extends b {

    /* renamed from: j, reason: collision with root package name */
    public final f8.j f4811j;

    /* renamed from: k, reason: collision with root package name */
    public final f8.n0 f4812k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(u9.n nVar, f8.j jVar, e9.f fVar, f8.n0 n0Var) {
        super(nVar, fVar);
        if (nVar == null) {
            j0(0);
            throw null;
        }
        if (jVar == null) {
            j0(1);
            throw null;
        }
        if (fVar == null) {
            j0(2);
            throw null;
        }
        this.f4811j = jVar;
        this.f4812k = n0Var;
    }

    public static /* synthetic */ void j0(int i2) {
        String str = (i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i2 == 2) {
            objArr[0] = "name";
        } else if (i2 == 3) {
            objArr[0] = "source";
        } else if (i2 == 4 || i2 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i2 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // f8.j
    public final f8.j p() {
        f8.j jVar = this.f4811j;
        if (jVar != null) {
            return jVar;
        }
        j0(4);
        throw null;
    }

    @Override // f8.k
    public final f8.n0 q() {
        f8.n0 n0Var = this.f4812k;
        if (n0Var != null) {
            return n0Var;
        }
        j0(5);
        throw null;
    }

    public boolean w() {
        return false;
    }
}
