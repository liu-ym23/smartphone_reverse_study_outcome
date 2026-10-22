package reactor.core.publisher;

import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class t0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10860c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Class f10861f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Consumer f10862g;

    public /* synthetic */ t0(int i) {
        this.f10860c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10860c) {
            case 0:
                Mono.lambda$doOnError$21(this.f10861f, this.f10862g, (Throwable) obj);
                break;
            default:
                Operators.lambda$discardLocalAdapter$0(this.f10861f, this.f10862g, obj);
                break;
        }
    }
}
