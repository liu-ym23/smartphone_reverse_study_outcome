package com.bytedance.android.gamecp.live_impl.toolbar;

import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f57979a;

    public f(g r100) {
        this.f57979a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f57979a.f57990k = false;
        ToastUtil.a(R.string.gamecp_page_load_error);
        g.c(this.f57979a, false, null, null, ((Throwable) r100).getMessage(), 22);
    }
}
