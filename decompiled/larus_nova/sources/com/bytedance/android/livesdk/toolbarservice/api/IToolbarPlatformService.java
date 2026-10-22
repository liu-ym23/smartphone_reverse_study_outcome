package com.bytedance.android.livesdk.toolbarservice.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.z;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import ot2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J<\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\nH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/toolbarservice/api/IToolbarPlatformService;", "Lcom/bytedance/android/live/base/IService;", "Lot2/b;", "getBottomToolbarLogImpl", "", "isPreload", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lkotlin/Function2;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "", "onSuccess", "doubleCheckToolbarData", "onInitToolbarData", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/z;", "checkManager", "registerPlaceHold", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IToolbarPlatformService extends IService {
    void doubleCheckToolbarData(boolean r100, IRoom r101, DataCenter r102, Function2<? super String, ? super ILiveToolbarData, Unit> r103);

    b getBottomToolbarLogImpl();

    void onInitToolbarData(DataCenter r100);

    void registerPlaceHold(DataCenter r100, z r101);
}
