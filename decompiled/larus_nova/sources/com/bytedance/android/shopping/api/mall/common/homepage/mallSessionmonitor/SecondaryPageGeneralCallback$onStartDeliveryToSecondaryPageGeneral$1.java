package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

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
final class SecondaryPageGeneralCallback$onStartDeliveryToSecondaryPageGeneral$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $schema;

    public SecondaryPageGeneralCallback$onStartDeliveryToSecondaryPageGeneral$1(String r100) {
        this.$schema = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (b.f170354a == null) goto L5;
        d.c(new SecondaryPageGeneralCallback$unRegisterLifecycleGeneralCallback$1(Boolean.TRUE));
    L5:
        MallDeliveryLifecycleGeneralCallback r100 = new MallDeliveryLifecycleGeneralCallback(this.$schema);
        b.f170354a = r100;
        Context r101 = HybridAppInfoService.f47545p.getApplicationContext();
        if ((r101 instanceof Application) == true) goto L8;
        r101 = null;
    L8:
        Application r102 = (Application) r101;
        if (r102 == null) goto L12;
        r102.registerActivityLifecycleCallbacks(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
