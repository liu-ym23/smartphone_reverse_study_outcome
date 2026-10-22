package ad2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3005a;

    public z(t r100) {
        this.f3005a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        t r101 = this.f3005a;
        r101.finishWithFailure((Throwable) r100);
    }
}
