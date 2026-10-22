package i8;

/* loaded from: classes.dex */
public abstract class m extends a4.d implements f8.j {

    /* renamed from: g, reason: collision with root package name */
    public final e9.f f4825g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(g8.j jVar, e9.f fVar) {
        super(jVar);
        if (jVar == null) {
            R(0);
            throw null;
        }
        if (fVar == null) {
            R(1);
            throw null;
        }
        this.f4825g = fVar;
    }

    public static String E0(f8.j jVar) {
        try {
            String str = g9.g.f3941e.x(jVar) + "[" + jVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(jVar)) + "]";
            if (str != null) {
                return str;
            }
            R(5);
            throw null;
        } catch (Throwable unused) {
            String str2 = jVar.getClass().getSimpleName() + " " + jVar.getName();
            if (str2 != null) {
                return str2;
            }
            R(6);
            throw null;
        }
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 5 || i2 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i2 != 2 && i2 != 3) {
            if (i2 == 4) {
                objArr[2] = "toString";
            } else if (i2 != 5 && i2 != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public f8.j a() {
        return this;
    }

    @Override // f8.j
    public final e9.f getName() {
        e9.f fVar = this.f4825g;
        if (fVar != null) {
            return fVar;
        }
        R(2);
        throw null;
    }

    public String toString() {
        return E0(this);
    }
}
