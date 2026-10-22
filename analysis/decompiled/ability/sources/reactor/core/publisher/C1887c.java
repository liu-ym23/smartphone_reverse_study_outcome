package reactor.core.publisher;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import reactor.core.Disposable;

/* renamed from: reactor.core.publisher.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1887c implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5907a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C1887c(Object obj, int i) {
        this.f5907a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f5907a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ConnectableFlux.lambda$connect$0((Disposable[]) obj2, (Disposable) obj);
                break;
            default:
                ((List) obj).sort((Comparator) obj2);
                break;
        }
    }
}
