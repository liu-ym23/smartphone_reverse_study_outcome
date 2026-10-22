package X8;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.InterfaceC1507O;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class F extends N {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1522a = 1;
    public final Object b;
    public final Object c;

    public F(w wVar, Variance variance) {
        if (variance == null) {
            e(0);
            throw null;
        }
        if (wVar == null) {
            e(1);
            throw null;
        }
        this.b = variance;
        this.c = wVar;
    }

    public static /* synthetic */ void e(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
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
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = AppAgent.CONSTRUCT;
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // X8.N
    public final Variance a() {
        switch (this.f1522a) {
            case 0:
                return Variance.e;
            default:
                Variance variance = (Variance) this.b;
                if (variance != null) {
                    return variance;
                }
                e(4);
                throw null;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [C7.f, java.lang.Object] */
    @Override // X8.N
    public final w b() {
        switch (this.f1522a) {
            case 0:
                return (w) this.c.getF4884a();
            default:
                w wVar = (w) this.c;
                if (wVar != null) {
                    return wVar;
                }
                e(5);
                throw null;
        }
    }

    @Override // X8.N
    public final boolean c() {
        switch (this.f1522a) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // X8.N
    public final N d(Y8.f kotlinTypeRefiner) {
        switch (this.f1522a) {
            case 0:
                kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
                return this;
            default:
                if (kotlinTypeRefiner == null) {
                    e(6);
                    throw null;
                }
                Variance variance = (Variance) this.b;
                w type = (w) this.c;
                kotlinTypeRefiner.getClass();
                kotlin.jvm.internal.k.f(type, "type");
                return new F(type, variance);
        }
    }

    public F(InterfaceC1507O typeParameter) {
        kotlin.jvm.internal.k.f(typeParameter, "typeParameter");
        this.b = typeParameter;
        this.c = kotlin.a.b(LazyThreadSafetyMode.b, new I8.e(this, 10));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public F(w wVar) {
        this(wVar, Variance.c);
        if (wVar != null) {
        } else {
            e(2);
            throw null;
        }
    }
}
