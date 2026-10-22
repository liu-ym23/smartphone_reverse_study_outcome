package X9;

import E9.b0;
import Z8.X;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* loaded from: classes5.dex */
public final class b {
    public static final a a(TypeUsage typeUsage, boolean z10, boolean z11, b0 b0Var) {
        p.i(typeUsage, "<this>");
        return new a(typeUsage, null, z11, z10, b0Var != null ? X.d(b0Var) : null, null, 34, null);
    }

    public static /* synthetic */ a b(TypeUsage typeUsage, boolean z10, boolean z11, b0 b0Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            b0Var = null;
        }
        return a(typeUsage, z10, z11, b0Var);
    }
}
