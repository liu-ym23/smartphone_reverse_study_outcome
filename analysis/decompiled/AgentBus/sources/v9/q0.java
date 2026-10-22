package v9;

/* loaded from: classes.dex */
public final class q0 extends p0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f10582a;

    /* renamed from: b, reason: collision with root package name */
    public final v f10583b;

    public q0(int i2, v vVar) {
        if (i2 == 0) {
            e(0);
            throw null;
        }
        if (vVar == null) {
            e(1);
            throw null;
        }
        this.f10582a = i2;
        this.f10583b = vVar;
    }

    public static /* synthetic */ void e(int i2) {
        String str = (i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5) ? 2 : 3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i2 == 3) {
            objArr[2] = "replaceType";
        } else if (i2 != 4 && i2 != 5) {
            if (i2 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // v9.p0
    public final int a() {
        int i2 = this.f10582a;
        if (i2 != 0) {
            return i2;
        }
        e(4);
        throw null;
    }

    @Override // v9.p0
    public final v b() {
        v vVar = this.f10583b;
        if (vVar != null) {
            return vVar;
        }
        e(5);
        throw null;
    }

    @Override // v9.p0
    public final boolean c() {
        return false;
    }

    @Override // v9.p0
    public final p0 d(w9.g gVar) {
        if (gVar == null) {
            e(6);
            throw null;
        }
        v vVar = this.f10583b;
        q7.k.e(vVar, "type");
        return new q0(this.f10582a, vVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q0(v vVar) {
        this(1, vVar);
        if (vVar != null) {
        } else {
            e(2);
            throw null;
        }
    }
}
