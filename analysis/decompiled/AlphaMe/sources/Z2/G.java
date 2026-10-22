package Z2;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public abstract class G {
    public static final d3.f a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(n0.f2230a) == null) {
            coroutineContext = coroutineContext.plus(I.a());
        }
        return new d3.f(coroutineContext);
    }
}
