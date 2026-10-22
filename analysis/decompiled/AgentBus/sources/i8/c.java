package i8;

/* loaded from: classes.dex */
public abstract class c extends h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(u9.n nVar, f8.j jVar, g8.j jVar2, e9.f fVar, int i2, boolean z4, int i10, f8.o0 o0Var) {
        super(nVar, jVar, jVar2, fVar, i2, z4, i10, o0Var);
        if (nVar == null) {
            R(0);
            throw null;
        }
        if (jVar == null) {
            R(1);
            throw null;
        }
        if (i2 == 0) {
            R(4);
            throw null;
        }
        if (o0Var != null) {
        } else {
            R(6);
            throw null;
        }
    }

    public static /* synthetic */ void R(int i2) {
        Object[] objArr = new Object[3];
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
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // i8.m
    public final String toString() {
        return (this.f4779k ? "reified " : "") + (a0() != 1 ? m.x.z(a0()).concat(" ") : "") + getName();
    }
}
