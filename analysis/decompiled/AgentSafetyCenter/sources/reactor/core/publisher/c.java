package reactor.core.publisher;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import reactor.core.Disposable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10766c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10767f;

    public /* synthetic */ c(int i) {
        this.f10766c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f10766c;
        Object obj2 = this.f10767f;
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
