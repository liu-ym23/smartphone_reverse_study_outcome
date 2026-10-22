package ya;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes5.dex */
public class D0 extends C0 {

    /* renamed from: a, reason: collision with root package name */
    public final Variance f44014a;

    /* renamed from: b, reason: collision with root package name */
    public final S f44015b;

    public D0(Variance variance, S s10) {
        if (variance == null) {
            d(0);
        }
        if (s10 == null) {
            d(1);
        }
        this.f44014a = variance;
        this.f44015b = s10;
    }

    public static /* synthetic */ void d(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        switch (i10) {
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
        if (i10 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i10 == 3) {
            objArr[2] = "replaceType";
        } else if (i10 != 4 && i10 != 5) {
            if (i10 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ya.B0
    public B0 a(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (cVar == null) {
            d(6);
        }
        return new D0(this.f44014a, cVar.a(this.f44015b));
    }

    @Override // ya.B0
    public boolean b() {
        return false;
    }

    @Override // ya.B0
    public Variance c() {
        Variance variance = this.f44014a;
        if (variance == null) {
            d(4);
        }
        return variance;
    }

    @Override // ya.B0
    public S getType() {
        S s10 = this.f44015b;
        if (s10 == null) {
            d(5);
        }
        return s10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public D0(S s10) {
        this(Variance.INVARIANT, s10);
        if (s10 == null) {
            d(2);
        }
    }
}
