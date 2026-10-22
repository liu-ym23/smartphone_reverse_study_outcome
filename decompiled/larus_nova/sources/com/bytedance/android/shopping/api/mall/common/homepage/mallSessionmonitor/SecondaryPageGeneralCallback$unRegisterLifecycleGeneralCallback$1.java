package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

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
final class SecondaryPageGeneralCallback$unRegisterLifecycleGeneralCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Boolean $forceUnRegister;

    public SecondaryPageGeneralCallback$unRegisterLifecycleGeneralCallback$1(Boolean r100) {
        this.$forceUnRegister = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (Intrinsics.areEqual(this.$forceUnRegister, Boolean.TRUE) == false) goto L14;
        MallDeliveryLifecycleGeneralCallback r100 = b.f170354a;
        MallDeliveryLifecycleGeneralCallback r101 = b.f170354a;
        if (r101 == null) goto L12;
        Context r102 = HybridAppInfoService.f47545p.getApplicationContext();
        if ((r102 instanceof Application) == true) goto L9;
        r102 = null;
    L9:
        Application r103 = (Application) r102;
        if (r103 == null) goto L12;
        r103.unregisterActivityLifecycleCallbacks(r101);
    L12:
        b.f170354a = null;
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
