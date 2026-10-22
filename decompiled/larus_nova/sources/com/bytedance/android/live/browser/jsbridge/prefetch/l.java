package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.tools.prefetch.i.a f63814a;

    public l(ProcessManager.b r100) {
        this.f63814a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.ies.tools.prefetch.i.a r101 = this.f63814a;
        r101.b((com.bytedance.ies.tools.prefetch.i.b) r100);
    }
}
