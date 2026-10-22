package com.bytedance.android.livesdkapi.room.handler.toolbar;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/ToolbarComponentCheckInterface;", "", "checkThenLoad", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/ToolbarMatchInterface;", "loadButton", "Lkotlin/Function0;", "", "stopLoadCallback", "Lkotlin/Function1;", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ToolbarComponentCheckInterface {
    boolean checkThenLoad(ToolbarMatchInterface r100, Function0<Unit> r101, Function1<? super String, Unit> r102);
}
