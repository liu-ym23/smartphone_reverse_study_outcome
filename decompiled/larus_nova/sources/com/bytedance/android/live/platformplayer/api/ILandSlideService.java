package com.bytedance.android.live.platformplayer.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import ds0.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.livesdk.landscapeslide.LandSlideService")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0002H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/platformplayer/api/ILandSlideService;", "Lcom/bytedance/android/live/base/IService;", "", "isSlideAble", "", "getSelectedRoomId", "Lds0/d;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "checkIsNotSupportLandFromDrawer", "roomSession", "", "showToast", "enableLand2Land", "platform-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILandSlideService extends IService {
    boolean checkIsNotSupportLandFromDrawer(d r100);

    boolean enableLand2Land();

    long getSelectedRoomId();

    boolean isSlideAble();

    void showToast(d r100);
}
