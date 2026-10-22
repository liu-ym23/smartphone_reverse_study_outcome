package com.bytedance.android.livesdkapi.room.handler.enterroom;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessSession;", "", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "scene", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;", "getScene", "()Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewBusinessSession {
    DataCenter getDataCenter();

    ILiveEnterRoomScene getScene();
}
