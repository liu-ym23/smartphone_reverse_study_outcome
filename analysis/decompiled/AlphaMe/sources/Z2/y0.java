package Z2;

import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class y0 extends A {
    @NotNull
    public abstract y0 getImmediate();

    @NotNull
    public A limitedParallelism(int i4) {
        I.e(i4);
        return this;
    }

    @Override // Z2.A
    @NotNull
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        return getClass().getSimpleName() + '@' + I.p(this);
    }

    @InternalCoroutinesApi
    @Nullable
    public final String toStringInternalImpl() {
        y0 immediate;
        f3.d dVar = Q.f2189a;
        y0 y0Var = d3.q.f12477a;
        if (this == y0Var) {
            return "Dispatchers.Main";
        }
        try {
            immediate = y0Var.getImmediate();
        } catch (UnsupportedOperationException unused) {
            immediate = null;
        }
        if (this == immediate) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
