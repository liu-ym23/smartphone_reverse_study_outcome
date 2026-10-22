package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.tools.prefetch.i.a f63815a;

    public m(ProcessManager.b r100) {
        this.f63815a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.ies.tools.prefetch.i.a r101 = this.f63815a;
        r101.a((Throwable) r100);
    }
}
