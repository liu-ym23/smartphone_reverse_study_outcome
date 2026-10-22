package reactor.core.publisher;

import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class x implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10874a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ BiFunction f10875b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ ContextView f10876c;

    public /* synthetic */ x(int i) {
        this.f10874a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f10874a) {
            case 0:
                return Flux.lambda$null$40(this.f10875b, this.f10876c, (qd.c) obj);
            default:
                return Mono.lambda$null$37(this.f10875b, this.f10876c, (qd.c) obj);
        }
    }
}
