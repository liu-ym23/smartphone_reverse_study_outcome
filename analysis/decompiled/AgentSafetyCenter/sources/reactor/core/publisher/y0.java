package reactor.core.publisher;

import reactor.util.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class y0 implements Logger.ChoiceOfMessageSupplier {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10882a;

    @Override // reactor.util.Logger.ChoiceOfMessageSupplier
    public final String get(boolean z10) {
        return MonoCacheInvalidateWhen.lambda$safeInvalidateHandler$0(this.f10882a, z10);
    }
}
