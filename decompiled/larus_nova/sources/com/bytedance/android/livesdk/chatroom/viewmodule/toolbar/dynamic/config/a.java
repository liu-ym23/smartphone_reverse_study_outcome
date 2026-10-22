package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements ToolbarComponentCheckInterface {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface
    public final boolean checkThenLoad(ToolbarMatchInterface r100, Function0<Unit> r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "loadButton");
        Intrinsics.checkNotNullParameter(r102, "stopLoadCallback");
        if (jc0.a.a() == false) goto L5;
        r102.invoke("stop By rtChorus");
        return true;
    L5:
        r101.invoke();
        return true;
    }
}
