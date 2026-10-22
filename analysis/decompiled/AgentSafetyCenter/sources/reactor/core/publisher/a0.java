package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10756c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Predicate f10757f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Consumer f10758g;

    public /* synthetic */ a0(int i) {
        this.f10756c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10756c) {
            case 0:
                Flux.lambda$doOnError$21(this.f10757f, this.f10758g, (Throwable) obj);
                break;
            default:
                Mono.lambda$doOnError$22(this.f10757f, this.f10758g, (Throwable) obj);
                break;
        }
    }
}
