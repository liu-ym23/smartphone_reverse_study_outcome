package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kk.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$onStartDeliveryToSecondaryPage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isNightMode;
    final /* synthetic */ String $schema;
    final /* synthetic */ String $uuid;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$onStartDeliveryToSecondaryPage$1(MallDeliveryMonitor r100, String r101, String r102, boolean r103) {
        this.this$0 = r100;
        this.$uuid = r101;
        this.$schema = r102;
        this.$isNightMode = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MallDeliveryMonitor r100 = this.this$0;
        if (r100.f170371g == null) goto L5;
        d.c(new MallDeliveryMonitor$unRegisterLifecycleCallback$1(r100, Boolean.TRUE));
    L5:
        MallDeliveryMonitor r101 = this.this$0;
        r101.f170371g = new MallDeliveryMonitor.MallDeliveryLifecycleCallback(r101, this.$uuid, this.$schema, this.$isNightMode);
        MallDeliveryMonitor.MallDeliveryLifecycleCallback r102 = this.this$0.f170371g;
        if (r102 == null) goto L14;
        Context r103 = HybridAppInfoService.f47545p.getApplicationContext();
        if ((r103 instanceof Application) == true) goto L10;
        r103 = null;
    L10:
        Application r104 = (Application) r103;
        if (r104 == null) goto L15;
        r104.registerActivityLifecycleCallbacks(r102);
        return;
    L15:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
