package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004*\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"createPreviewDefaultBridge", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessBridge;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IPreviewBridgeHost;", "scene", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;", "(Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILiveEnterRoomScene;)Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessBridge;", "livesdkapi_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ILiveEnterRoomBridgeExtKt {
    public static final <T extends AbsMergeWidget & IPreviewBridgeHost> ILivePreviewBusinessBridge createPreviewDefaultBridge(T r100, ILiveEnterRoomScene r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$createPreviewDefaultBridge");
        Intrinsics.checkNotNullParameter(r101, "scene");
        if (r100.getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L7;
        return null;
    L7:
        return new ILiveEnterRoomBridgeExtKt$createPreviewDefaultBridge$bridge$1(r100, r101);
    }
}
