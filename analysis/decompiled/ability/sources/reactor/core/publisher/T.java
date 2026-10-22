package reactor.core.publisher;

import java.util.function.Consumer;

/* loaded from: classes4.dex */
public final /* synthetic */ class T implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5896a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ Consumer c;

    public /* synthetic */ T(Class cls, Consumer consumer, int i) {
        this.f5896a = i;
        this.b = cls;
        this.c = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5896a) {
            case 0:
                Mono.lambda$doOnError$21(this.b, this.c, (Throwable) obj);
                break;
            default:
                Operators.lambda$discardLocalAdapter$0(this.b, this.c, obj);
                break;
        }
    }
}
