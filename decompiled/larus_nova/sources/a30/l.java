package a30;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f1521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1522b;

    public l(j r100, String r101) {
        this.f1521a = r100;
        this.f1522b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f1521a.j("watchdog timeout, " + this.f1522b);
    }
}
