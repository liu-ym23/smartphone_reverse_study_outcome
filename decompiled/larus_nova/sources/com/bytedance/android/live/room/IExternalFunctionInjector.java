package com.bytedance.android.live.room;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.room.service.ExternalFunctionInjectorService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u000eH&J\u001f\u0010\u000f\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u0002H\u0010H&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/room/IExternalFunctionInjector;", "Lcom/bytedance/android/live/base/IService;", "clearLiveRoomController", "", "roomId", "", "identityCode", "", "source", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider$ProviderSource;", "getLiveRoomController", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "", "getStartLivePreviewController", "Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewController;", "injectRoomControllerProvider", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;", ShortVideoSegments.KEY_PROP_PROVIDER, "(Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;)V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalFunctionInjector extends IService {
    void clearLiveRoomController(String r100, int r101);

    void clearLiveRoomController(String r100, int r101, ILiveRoomControllerProvider.ProviderSource r102);

    ILiveRoomController getLiveRoomController(long r100, int r101);

    ILiveRoomController getLiveRoomController(String r100, int r101);

    ILiveRoomController getLiveRoomController(String r100, int r101, ILiveRoomControllerProvider.ProviderSource r102);

    IStartLivePreviewController getStartLivePreviewController();

    <T extends ILiveRoomControllerProvider> void injectRoomControllerProvider(T r100);
}
