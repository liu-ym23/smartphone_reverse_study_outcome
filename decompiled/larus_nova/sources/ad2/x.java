package ad2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3003a;

    public x(t r100) {
        this.f3003a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        t r101 = this.f3003a;
        r101.finishWithFailure((Throwable) r100);
    }
}
