package bk3;

import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListStatusPositionalLoadInitialCallback f19306a;

    public d(ListStatusPositionalLoadInitialCallback r100) {
        this.f19306a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ListStatusPositionalLoadInitialCallback r101 = this.f19306a;
        ErrorDomain.NATIVE.getCode();
        ErrorCode.NATIVE_COMMON.getCode();
        ((Throwable) r100).getMessage();
        r101.a();
    }
}
