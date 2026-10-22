package reactor.core.publisher;

import java.util.function.Consumer;

/* renamed from: reactor.core.publisher.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1902s implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5934a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ C1902s(Runnable runnable, int i) {
        this.f5934a = i;
        this.b = runnable;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f5934a;
        Runnable runnable = this.b;
        switch (i) {
            case 0:
                Flux.lambda$doOnTerminate$22(runnable, (Throwable) obj);
                break;
            case 1:
                runnable.run();
                break;
            case 2:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
