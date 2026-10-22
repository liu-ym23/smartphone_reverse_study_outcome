package reactor.util.concurrent;

import java.util.function.Supplier;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5954a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(int i, int i6) {
        this.f5954a = i6;
        this.b = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f5954a;
        int i6 = this.b;
        switch (i) {
            case 0:
                return Queues.lambda$unbounded$1(i6);
            default:
                return Queues.lambda$get$0(i6);
        }
    }
}
