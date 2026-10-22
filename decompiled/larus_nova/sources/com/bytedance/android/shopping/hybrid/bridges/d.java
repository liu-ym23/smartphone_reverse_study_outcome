package com.bytedance.android.shopping.hybrid.bridges;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECOpenVideoPreviewPanelMethod f176223a;

    public d(ECOpenVideoPreviewPanelMethod r100) {
        this.f176223a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECOpenVideoPreviewPanelMethod.e(this.f176223a, -1, "发布失败", 4);
        ECExceptionMonitor.e((Throwable) r100);
    }
}
