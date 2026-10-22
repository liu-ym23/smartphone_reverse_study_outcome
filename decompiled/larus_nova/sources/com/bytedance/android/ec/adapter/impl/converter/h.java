package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements ToolbarComponentCheckInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vd.a f42785a;

    public h(vd.a r100) {
        this.f42785a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface
    public final boolean checkThenLoad(ToolbarMatchInterface r100, Function0<Unit> r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "loadButton");
        Intrinsics.checkNotNullParameter(r102, "stopLoadCallback");
        this.f42785a.a(new te.a(r100), r101, r102);
        return true;
    }
}
