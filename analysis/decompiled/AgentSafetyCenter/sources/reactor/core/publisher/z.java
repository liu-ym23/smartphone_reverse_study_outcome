package reactor.core.publisher;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class z implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10883c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Function f10884f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Function f10885g;

    public /* synthetic */ z(int i) {
        this.f10883c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f10883c) {
            case 0:
                Flux.lambda$collectMap$12(this.f10884f, this.f10885g, (Map) obj, obj2);
                break;
            default:
                Flux.lambda$collectMultimap$15(this.f10884f, this.f10885g, (Map) obj, obj2);
                break;
        }
    }
}
