package reactor.core.publisher;

import java.util.Collection;
import java.util.function.ToIntFunction;

/* loaded from: classes4.dex */
public final /* synthetic */ class F implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((Collection) obj).size();
    }
}
