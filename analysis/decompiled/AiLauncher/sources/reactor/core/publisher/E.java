package reactor.core.publisher;

import java.util.function.Supplier;

/* loaded from: classes5.dex */
public final /* synthetic */ class E implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return ContextPropagation.contextCaptureToEmpty();
    }
}
