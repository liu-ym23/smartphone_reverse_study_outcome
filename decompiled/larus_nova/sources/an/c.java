package an;

import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListStatusPositionalLoadRangeCallback f4483a;

    public c(ListStatusPositionalLoadRangeCallback r100) {
        this.f4483a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f4483a.a();
    }
}
