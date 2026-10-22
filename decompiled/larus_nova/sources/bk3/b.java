package bk3;

import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListStatusPositionalLoadRangeCallback f19303a;

    public b(ListStatusPositionalLoadRangeCallback r100) {
        this.f19303a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f19303a.a();
    }
}
