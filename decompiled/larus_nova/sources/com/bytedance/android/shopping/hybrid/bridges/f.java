package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import android.os.Handler;
import cg3.k;
import com.bytedance.android.shopping.order.PublishUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECOpenVideoPreviewPanelMethod f176226a;

    public f(ECOpenVideoPreviewPanelMethod r100) {
        this.f176226a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Handler r101 = PublishUtil.f179649a;
        Context r102 = this.f176226a.getContext();
        PublishUtil.e(r102, (k) r100, false);
    }
}
