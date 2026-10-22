package com.bytedance.android.annie.service.prefetch;

import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.tools.prefetch.i.a f39989a;

    public v(ProcessManager.b r100) {
        this.f39989a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.ies.tools.prefetch.i.a r101 = this.f39989a;
        r101.b((com.bytedance.ies.tools.prefetch.i.b) r100);
    }
}
