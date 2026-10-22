package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBroadcastCallback;
import com.bytedance.ies.sdk.widgets.Widget;
import r70.b;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.broadcast.BroadcastSDKServiceImpl")
public interface ILiveBroadcastSDKService extends IService {
    ILiveBgBroadcastFragment createBgBroadcastFragment(Bundle r100);

    Fragment createLiveBroadcastFragment(ILiveBroadcastCallback r100, Bundle r101);

    Fragment createLiveSubBroadcastFragment(ILiveBroadcastCallback r100, Bundle r101);

    Class<? extends Widget> getAnchorRoomManageWidget();

    b getBroadcastMediaElementFilter();

    Class<? extends Widget> getStartZoomWidget();

    void showMediaIntroDialog(Context r100);
}
