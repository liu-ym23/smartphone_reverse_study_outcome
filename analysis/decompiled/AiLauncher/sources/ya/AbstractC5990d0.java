package ya;

import java.io.IOException;
import java.util.Iterator;

/* renamed from: ya.d0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5990d0 extends K0 implements Ca.i, Ca.j {
    public AbstractC5990d0() {
        super(null);
    }

    public abstract AbstractC5990d0 O0(boolean z10);

    public abstract AbstractC5990d0 P0(s0 s0Var);

    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Iterator<F9.c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            La.A.r(sb2, "[", kotlin.reflect.jvm.internal.impl.renderer.b.O(kotlin.reflect.jvm.internal.impl.renderer.b.f35920k, it.next(), null, 2, null), "] ");
        }
        sb2.append(H0());
        if (!F0().isEmpty()) {
            Z8.F.x0(F0(), sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (I0()) {
            sb2.append("?");
        }
        return sb2.toString();
    }
}
