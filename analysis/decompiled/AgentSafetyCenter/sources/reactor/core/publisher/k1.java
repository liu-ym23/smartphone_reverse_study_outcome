package reactor.core.publisher;

import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class k1 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10811c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ SignalLogger f10812f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f10813g;

    public /* synthetic */ k1(int i) {
        this.f10811c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10811c) {
            case 0:
                this.f10812f.lambda$onErrorCall$5(this.f10813g, (Throwable) obj);
                break;
            case 1:
                this.f10812f.lambda$onErrorCall$3(this.f10813g, (Throwable) obj);
                break;
            default:
                this.f10812f.lambda$onErrorCall$4(this.f10813g, (Throwable) obj);
                break;
        }
    }
}
