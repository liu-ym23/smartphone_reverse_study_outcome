package reactor.core.publisher;

import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class t implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10858c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Runnable f10859f;

    public /* synthetic */ t(int i) {
        this.f10858c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f10858c;
        Runnable runnable = this.f10859f;
        switch (i) {
            case 0:
                Flux.lambda$doOnTerminate$22(runnable, (Throwable) obj);
                break;
            case 1:
                Mono.lambda$doOnTerminate$23(runnable, obj);
                break;
            case 2:
                Mono.lambda$doOnTerminate$24(runnable, (Throwable) obj);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
