package reactor.core.publisher;

import java.util.function.Supplier;

/* loaded from: classes4.dex */
public final /* synthetic */ class j0 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5920a;
    public final /* synthetic */ int b;

    public /* synthetic */ j0(int i, int i6) {
        this.f5920a = i6;
        this.b = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f5920a;
        int i6 = this.b;
        switch (i) {
            case 0:
                return ParallelFlux.lambda$collectSortedList$0(i6);
            default:
                return ParallelFlux.lambda$sorted$8(i6);
        }
    }
}
