package com.bytedance.android.shopping.sku.common.monitor.fps;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import et3.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Let3/c;", AbsMethodDelegate.TAG_INVOKE, "()Let3/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class SkuYataFpsMonitor$fpsTracker$2 extends Lambda implements Function0<c> {
    final /* synthetic */ SkuYataFpsMonitor this$0;

    public SkuYataFpsMonitor$fpsTracker$2(SkuYataFpsMonitor r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final c invoke() {
        String r100 = this.this$0.f182759a.getSceneName();
        c r101 = new c(r100);
        r101.c(new SkuYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(this, r100));
        return r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c invoke() {
        return invoke();
    }
}
