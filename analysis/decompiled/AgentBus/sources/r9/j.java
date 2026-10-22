package r9;

import java.util.ArrayList;
import z8.p0;

/* loaded from: classes.dex */
public final class j implements m, l {

    /* renamed from: b, reason: collision with root package name */
    public static final j f9067b = new j();

    /* renamed from: c, reason: collision with root package name */
    public static final j f9068c = new j();

    /* renamed from: d, reason: collision with root package name */
    public static final j f9069d = new j();

    public static int d(z8.z zVar) {
        int i2 = zVar == null ? -1 : u.$EnumSwitchMapping$0[zVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return 3;
            }
            if (i2 == 3) {
                return 4;
            }
            if (i2 == 4) {
                return 2;
            }
        }
        return 1;
    }

    @Override // r9.l
    public void a(f8.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1", "reportCannotInferVisibility"));
        }
    }

    @Override // r9.l
    public void b(f8.e eVar, ArrayList arrayList) {
    }

    @Override // r9.m
    public v9.v c(p0 p0Var, String str, v9.z zVar, v9.z zVar2) {
        q7.k.e(p0Var, "proto");
        q7.k.e(str, "flexibleId");
        q7.k.e(zVar, "lowerBound");
        q7.k.e(zVar2, "upperBound");
        throw new IllegalArgumentException("This method should not be used.");
    }
}
