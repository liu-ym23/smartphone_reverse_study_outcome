package com.bytedance.android.livesdkapi.service;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.distribution.ILiveDistributionController;
import com.bytedance.android.livesdkapi.distribution.InitParams;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.AudienceSDKServiceImpl")
public interface ILiveAudienceSDKService extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.service.ILiveAudienceSDKService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$needPreLoadingClasses(ILiveAudienceSDKService r100) {
            return new ArrayList();
        }
    }

    ILiveDistributionController createLiveDistributionController(boolean r100, InitParams r101);

    ILiveRoomPageFragment createLiveRoomFragment(long r100, Bundle r101);

    List<Class<?>> needPreLoadingClasses();
}
