package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$unRegisterLifecycleCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Boolean $forceUnRegister;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$unRegisterLifecycleCallback$1(MallDeliveryMonitor r100, Boolean r101) {
        this.this$0 = r100;
        this.$forceUnRegister = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (((Number) this.this$0.f170372h.getValue()).intValue() != 1) goto L5;
    L6:
        MallDeliveryMonitor.MallDeliveryLifecycleCallback r100 = this.this$0.f170371g;
        if (r100 == null) goto L14;
        Context r101 = HybridAppInfoService.f47545p.getApplicationContext();
        if ((r101 instanceof Application) == true) goto L11;
        r101 = null;
    L11:
        Application r102 = (Application) r101;
        if (r102 == null) goto L14;
        r102.unregisterActivityLifecycleCallbacks(r100);
    L14:
        this.this$0.f170371g = null;
        return;
    L5:
        if (Intrinsics.areEqual(this.$forceUnRegister, Boolean.TRUE) == true) goto L6;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
