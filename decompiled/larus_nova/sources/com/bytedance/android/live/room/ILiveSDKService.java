package com.bytedance.android.live.room;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.IStartLiveVerifyCallback;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.LiveSDKService")
public interface ILiveSDKService extends IService, IMiddlewareLiveSDKService {

    /* JADX INFO: renamed from: com.bytedance.android.live.room.ILiveSDKService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ o $default$getLottiePlayService(ILiveSDKService r100) {
            return r100.getLottiePlayService();
        }
    }

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    g createImagePicker(Activity r100, Fragment r101, String r102, DataCenter r103, int r104, int r105, int r106, int r107, g.b r108, IEntranceContext r110, String r111);

    i createLiveBroadcastEndFragment();

    e dnsOptimizer();

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    m getLottiePlayService();

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    /* bridge */ /* synthetic */ o getLottiePlayService();

    vlc.d getMessageManager(long r100, boolean r101, Context r102);

    v getXTSDKService();

    void handleRealNameConflict(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r103);

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    void handleRealNameConflict(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r103, String r104, IStartLiveVerifyCallback r105);

    void handleRealNameConflictWithoutDialog(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r103);

    void handleRealNameConflictWithoutDialog(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r103, IStartLiveVerifyCallback r104);

    t hostStickerViewService();

    j liveCommerceService();
}
