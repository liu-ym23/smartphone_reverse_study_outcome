package reactor.core.publisher;

import java.util.Collection;
import java.util.function.ToIntFunction;

/* renamed from: reactor.core.publisher.q0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C5382q0 implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((Collection) obj).size();
    }
}
