package reactor.util.context;

import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Context[] f10908c;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ContextN.lambda$putAllInto$0(this.f10908c, obj, obj2);
    }
}
